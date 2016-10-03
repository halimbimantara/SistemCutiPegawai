package teknologi.inspira.bentang.sistemcutipegawai.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.inspira.bentang.sistemcutipegawai.R;
import teknologi.inspira.bentang.sistemcutipegawai.activity.LoginActivity;
import teknologi.inspira.bentang.sistemcutipegawai.model.BuatCuti;
import teknologi.inspira.bentang.sistemcutipegawai.rest.RestClient;
import teknologi.inspira.bentang.sistemcutipegawai.util.ConnectivityReceiver;

/**
 * Created by halim on 9/30/2016.
 */

public class CreateCutiFragment extends Fragment {
    //inisialisasi
    protected RestClient restClient = RestClient.getInstance();
    Context mcContext;
    EditText tgl_start;
    EditText tgl_end;
    EditText no_tlp;
    EditText email;
    EditText Nip_atasan,Jabatan_atasan,Keterangan;
    Button save;
    ProgressBar pb_save;
    Spinner SpJeniscuti;
    boolean isConnected = ConnectivityReceiver.isConnected();
    String[] jenisCuti = new String[]{
            "Cuti Tahunan",
            "Cuti Besar",
            "Cuti Sakit",
            "Cuti Bersalin",
            "Cuti Alasan Penting",
            "Cuti Diluar Tanggungan Negara"
    };
    List<String> cutiList = new ArrayList<>(Arrays.asList(jenisCuti));
    private int mYear, mMonth, mDay, mHour, mMinute;
    private ProgressDialog progress;
    private int cutiposition=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.content_create, container, false);
        getActivity().setTitle("Pengajuan Cuti");
        tgl_start = (EditText) rootView.findViewById(R.id.tanggal_mulai);
        tgl_end = (EditText) rootView.findViewById(R.id.tanggal_selesai);

        save = (Button) rootView.findViewById(R.id.btn_submit);
        no_tlp = (EditText) rootView.findViewById(R.id.Et_notelp);

        email = (EditText) rootView.findViewById(R.id.Et_email);
        Nip_atasan= (EditText) rootView.findViewById(R.id.Et_Nip);
        Jabatan_atasan = (EditText) rootView.findViewById(R.id.Et_jabatan);
        SpJeniscuti=(Spinner)rootView.findViewById(R.id.Sp_jenis);
        Keterangan=(EditText)rootView.findViewById(R.id.Et_Keterangan);

        final ArrayAdapter<String> spinnerArrayAdapter =new ArrayAdapter<String>(getContext(),R.layout.spinner_jencuti,cutiList);
        SpJeniscuti.setAdapter(spinnerArrayAdapter);

        SpJeniscuti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cutiposition=position+1;
                System.out.println(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tgl_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(0, monthOfYear, 0, 0, 0);
                        Date chosenDate = cal.getTime();
                        tgl_start.setText((year) + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        tgl_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(0, monthOfYear, 0, 0, 0);
                        Date chosenDate = cal.getTime();
                        tgl_end.setText((year) + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isConnected) {
                    progress = new ProgressDialog(getContext());
                    progress.setMessage("Proses mensubmit data");
                    progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progress.show();

                    SharedPreferences pref = getActivity().getSharedPreferences(LoginActivity.MyPREFERENCES, Context.MODE_PRIVATE);
                    String nama = pref.getString("NAME", "");
                    String nip = pref.getString("NIP", "");
                    String telpon = no_tlp.getText().toString();
                    String Email = email.getText().toString();
                    String nipatasan = Nip_atasan.getText().toString();
                    final String JabatanAtasan = Jabatan_atasan.getText().toString();
                    String keterangan = Keterangan.getText().toString();
                    String Ttgl_start = tgl_start.getText().toString();
                    String Ttgl_end = tgl_end.getText().toString();
                    int JenisCuti = cutiposition;

                    String id = "2";
                    Call<BuatCuti> apiResponse = restClient.getSimpegApi().postWithFormParams(nip, nama, telpon, Email, id, nipatasan, JabatanAtasan, keterangan, Ttgl_start, Ttgl_end, JenisCuti);
                    apiResponse.enqueue(new Callback<BuatCuti>() {
                        @Override
                        public void onResponse(Call<BuatCuti> call, Response<BuatCuti> response) {
                            if (response.body().isStatus() == true) {
                                Toast.makeText(getContext(), response.body().getMessage() + response.body().getNip(), Toast.LENGTH_LONG).show();
                                no_tlp.setText("");
                                email.setText("");
                                Nip_atasan.setText("");
                                Jabatan_atasan.setText("");
                                tgl_start.setText("");
                                tgl_end.setText("");
                                Keterangan.setText("");

                                progress.hide();
                            } else {
                                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                                progress.hide();
                            }
                            System.out.println(response.body().getMessage());
                        }

                        @Override
                        public void onFailure(Call<BuatCuti> call, Throwable t) {
                            progress.hide();
                            if(isConnected) {
                                Toast.makeText(getContext(), "Ada Kesalahan System" + t.getMessage(), Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(rootView.getContext(), "Maaf Tidak Ada Koneksi Internet", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(rootView.getContext(), "Maaf Tidak Ada Koneksi Internet", Toast.LENGTH_LONG).show();
                }
                }
        });
        return rootView;
    }

}

