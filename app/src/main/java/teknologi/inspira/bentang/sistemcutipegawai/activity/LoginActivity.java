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

import butterknife.ButterKnife;
import butterknife.BindView;;
import butterknife.OnClick;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.inspira.bentang.sistemcutipegawai.R;
import teknologi.inspira.bentang.sistemcutipegawai.model.ApiResponse;
import teknologi.inspira.bentang.sistemcutipegawai.model.User;
import teknologi.inspira.bentang.sistemcutipegawai.rest.RestClient;

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
        if (mEt_nip.getText().equals(null) || mEt_password.getText().equals(null)){
            Toast.makeText(getBaseContext(), "Maaf NIP tidak boleh kosong !", Toast.LENGTH_SHORT).show();
        }else{
            //show loading
            mPbLoading.setVisibility(View.VISIBLE);
            Call<User> apiResponseList = restClient.getSimpegApi().getLogin(mEt_nip.getText().toString(),mEt_password.getText().toString());
          apiResponseList.enqueue(new Callback<User>() {
              @Override
              public void onResponse(Call<User> call, Response<User> response) {
                  //cek
                  System.out.println(response.body().getStatus());
                  SharedPreferences.Editor editor = sharedpreferences.edit();
                  if(response.body().isError() == false) {
                      editor.putString("NIP", mEt_nip.getText().toString());
                      editor.putString("NAME", response.body().getNamapeg());
                      editor.putString("TOKEN", response.body().getToken());
                      editor.commit();
                      //start MainActivity
                      Intent intent;
                      intent = new Intent(getBaseContext(), MainActivity.class);
                      startActivity(intent);
                      finish();
                  }else{
                      Toast.makeText(getBaseContext(),"Maaf user anda tidak valid !",Toast.LENGTH_LONG).show();
                  }
              }
              @Override
              public void onFailure(Call<User> call, Throwable t) {

              }
          });

            Toast.makeText(getBaseContext(), "Berhasil", Toast.LENGTH_SHORT).show();

        }
    }

}
