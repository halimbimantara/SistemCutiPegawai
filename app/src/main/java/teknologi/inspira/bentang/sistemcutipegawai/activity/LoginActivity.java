package teknologi.inspira.bentang.sistemcutipegawai.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import teknologi.inspira.bentang.sistemcutipegawai.R;
import teknologi.inspira.bentang.sistemcutipegawai.model.User;
import teknologi.inspira.bentang.sistemcutipegawai.rest.RestClient;
import teknologi.inspira.bentang.sistemcutipegawai.util.ConnectivityReceiver;

;

/**
 * Created by halim on 9/26/2016.
 */

public class LoginActivity extends AppCompatActivity{

    private static final String TAG = LoginActivity.class.getSimpleName();

    //inisialisasi
   protected RestClient restClient = RestClient.getInstance();

    @BindView(R.id.input_nip)
    EditText mEt_nip;
    @BindView(R.id.input_password)
    EditText mEt_password;
    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;

    //save data login to preference
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        Paper.init(getBaseContext());
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void login(){
        if (mEt_nip.getText().equals("") || mEt_password.getText().equals("")){
            Toast.makeText(getBaseContext(), "Maaf NIP tidak boleh kosong !", Toast.LENGTH_SHORT).show();
        }else{
            //show loading
            boolean isConnected = ConnectivityReceiver.isConnected();
            if(isConnected) {
                mPbLoading.setVisibility(View.VISIBLE);
                Call<User> apiResponseList = restClient.getSimpegApi().getLogin(mEt_nip.getText().toString(), mEt_password.getText().toString());
                apiResponseList.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        mPbLoading.setVisibility(View.GONE);
                        System.out.println(response.body().isStatus());
                        if (response.body().isStatus() == false) {
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString("NIP", mEt_nip.getText().toString());
                            editor.putString("NAME", response.body().getNamapeg());
                            editor.putString("TOKEN", response.body().getToken());
                            editor.commit();

                            Intent intent;
                            intent = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getBaseContext(), "Maaf akun anda tidak terdaftar !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        mPbLoading.setVisibility(View.GONE);
                        Toast.makeText(getBaseContext(), "Ada kesalahan sistem hubungi pengembang!", Toast.LENGTH_LONG).show();
                    }
                });
            }else {
                Toast.makeText(this, "Maaf Tidak Ada Koneksi Internet", Toast.LENGTH_LONG).show();
            }

        }
    }

}
