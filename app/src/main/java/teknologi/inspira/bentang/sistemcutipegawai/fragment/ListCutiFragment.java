package teknologi.inspira.bentang.sistemcutipegawai.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.inspira.bentang.sistemcutipegawai.R;
import teknologi.inspira.bentang.sistemcutipegawai.activity.LoginActivity;
import teknologi.inspira.bentang.sistemcutipegawai.adapter.DataListCutiAdapter;
import teknologi.inspira.bentang.sistemcutipegawai.model.ApiResponse;
import teknologi.inspira.bentang.sistemcutipegawai.model.Cuti;
import teknologi.inspira.bentang.sistemcutipegawai.rest.RestClient;

/**
 * Created by halim on 9/29/2016.
 */
public class ListCutiFragment extends Fragment {
    //API
    protected RestClient restClient = RestClient.getInstance();
    protected RecyclerView mRecyclerView;
    protected List<Cuti> list;
    @BindView(R.id.pb_loading_listcuti)
    ProgressBar mPbLoading;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_status_cuti, container, false);
        rootView.setTag("Recycle View");
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.item_list_cuti);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        getActivity().setTitle("History Pengajuan Cuti");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.item_list_cuti);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        SharedPreferences pref = getActivity().getSharedPreferences(LoginActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //load nip from sharepref
        String nip=pref.getString("NIP","");
        mPbLoading.setVisibility(View.VISIBLE);
        Call<ApiResponse<List<Cuti>>> apiResponseList = restClient.getSimpegApi().getListCuti(nip);
        apiResponseList.enqueue(new Callback<ApiResponse<List<Cuti>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Cuti>>> call, Response<ApiResponse<List<Cuti>>> response) {
                mPbLoading.setVisibility(View.GONE);
                if(response.body().isStatus() == false ) {
                    Toast.makeText(getActivity().getBaseContext(), R.string.noData, Toast.LENGTH_LONG).show();
                }
                if (!response.body().isStatus() == false && response.body().isStatus() == true) {
                    List<Cuti> cuti= response.body().getData();
                    mAdapter = new DataListCutiAdapter(cuti,R.id.movies_layout, getActivity());
                    mRecyclerView.setAdapter(new DataListCutiAdapter(cuti, R.layout.list_cuti, getActivity()));
                    System.out.println(response.body().getData().get(0).getNama());
                    Log.d("", "Number of cuti received: " + cuti.size());
                } else {
//                    mAdapter = new NullAdapter(getActivity());
                    System.out.println("Data Cuti tidak ada");
                }
//                mRecyclerView.setAdapter(mAdapter);
                mPbLoading.setVisibility(View.GONE);
            }
            @Override
            public void onFailure(Call<ApiResponse<List<Cuti>>> call, Throwable t) {
                System.out.println("GAGAL");
                mPbLoading.setVisibility(View.GONE);
            }
        });
        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.addItemDecoration(new BackgroundItemDecoration(R.color.colorOdd, R.color.colorEven));
        super.onViewCreated(view, savedInstanceState);
    }
}
