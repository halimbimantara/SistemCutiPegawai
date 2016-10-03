package teknologi.inspira.bentang.sistemcutipegawai.rest;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import teknologi.inspira.bentang.sistemcutipegawai.model.Cuti;
import teknologi.inspira.bentang.sistemcutipegawai.util.Constant;

/**
 * Created by halim on 9/27/2016.
 */

public class RestClient {
    private static RestClient instance = null;
    private CutiApi cutiApi;

    private RestClient(){
//        OkHttpClient client = new OkHttpClient();
//        client.interceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Interceptor.Chain chain) throws IOException {
//                Response response = chain.proceed(chain.request());
//
//                Log.d("test", response.toString());
//                // Do anything with response here
//                return response;
//            }
//        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cutiApi= retrofit.create(CutiApi.class);
    }

    public static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    //interface LoginApi
    public CutiApi getSimpegApi() {
        return cutiApi;
    }
}
