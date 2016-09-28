package teknologi.inspira.bentang.sistemcutipegawai.rest;

/**
 * Created by halim on 9/27/2016.
 */


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import teknologi.inspira.bentang.sistemcutipegawai.model.Cuti;
import teknologi.inspira.bentang.sistemcutipegawai.model.User;

public interface CutiApi {
    //get List cuti berdasarkan nip
    @POST("user/login")
    Call<User> getLogin(@Query("nip") String nip, @Query("password") String password);

    @GET("listcuti/{id}")
    Call<Cuti> getListCuti(@Path("id") int id, @Query("token") String apiKey);

}
