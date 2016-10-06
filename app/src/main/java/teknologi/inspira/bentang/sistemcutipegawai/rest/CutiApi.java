package teknologi.inspira.bentang.sistemcutipegawai.rest;

/**
 * Created by halim on 9/27/2016.
 */

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import teknologi.inspira.bentang.sistemcutipegawai.model.ApiResponse;
import teknologi.inspira.bentang.sistemcutipegawai.model.Atasan;
import teknologi.inspira.bentang.sistemcutipegawai.model.Biodata;
import teknologi.inspira.bentang.sistemcutipegawai.model.BuatCuti;
import teknologi.inspira.bentang.sistemcutipegawai.model.Cuti;
import teknologi.inspira.bentang.sistemcutipegawai.model.JenisCuti;
import teknologi.inspira.bentang.sistemcutipegawai.model.User;

public interface CutiApi {

    @GET("user/login/{nip}/{password}")
    Call<User> getLogin(@Path("nip") String nip, @Path("password") String password);

    @GET("status_cuti/{id}")
    Call<ApiResponse<List<Cuti>>> getListCuti(@Path("id") String id);

    @GET("jeniscuti/")
    Call<ApiResponse<List<JenisCuti>>> getJenisCuti();

    @GET("biodata/{nip}")
    Call<Biodata> getBiodata(@Path("nip") String nip);

    @GET("nipatasan")
    Call<ApiResponse<List<Atasan>>> getAtasan();

    /**
     * Exemplary login data sent as JSON
     */
    @FormUrlEncoded
    @POST("createcuti")
    Call<BuatCuti> postWithFormParams(@Field("nip") String nip,@Field("nama") String nama,@Field("telp") String telpon,
                                      @Field("email") String email,@Field("id") String id,@Field("nip_atasan")String nip_atasan,
                                      @Field("jabatan") String jabatan,@Field("keterangan") String keterangan,
                                      @Field("tmulai")String tgl_mulai,@Field("takhir")String tgl_akhir,
                                      @Field("jcuti")int jenis_cuti,
                                      @Field("jbatan")String jbatan,
                                      @Field("pangkat")String pangkat,
                                      @Field("unitkerja")String unitkerja);

}
