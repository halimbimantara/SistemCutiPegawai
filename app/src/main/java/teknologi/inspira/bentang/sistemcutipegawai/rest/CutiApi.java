package teknologi.inspira.bentang.sistemcutipegawai.rest;

/**
 * Created by halim on 9/27/2016.
 */


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import teknologi.inspira.bentang.sistemcutipegawai.model.ApiResponse;
import teknologi.inspira.bentang.sistemcutipegawai.model.Cuti;
import teknologi.inspira.bentang.sistemcutipegawai.model.User;

public interface CutiApi {

    @GET("user/login/{nip}/{password}")
    Call<User> getLogin(@Path("nip") String nip, @Path("password") String password);

    @GET("status_cuti/{id}")
    Call<ApiResponse<List<Cuti>>> getListCuti(@Path("id") String id);

}
