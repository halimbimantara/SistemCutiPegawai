package teknologi.inspira.bentang.sistemcutipegawai.model;

/**
 * Created by halim on 9/27/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("error")
    @Expose
    private boolean error;


    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nip")
    @Expose
    private String nip;

    @SerializedName("username")
    @Expose
    private String namapeg;


    @SerializedName("token")
    @Expose
    private String token;


    @SerializedName("status")
    @Expose
    private int status;

//    @SerializedName("file_foto")
//    @Expose
//    private String fileFoto;

    /**
     *
     * @return
     * The nip
     */
    public String getNip() {
        return nip;
    }

    /**
     *
     * @param nip
     * The nip
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    /**
     *
     * @return
     * The namapeg
     */
    public String getNamapeg() {
        return namapeg;
    }
    /**
     *
     * @param namapeg
     * The namapeg
     */
    public void setNamapeg(String namapeg) {
        this.namapeg = namapeg;
    }

    /**
     *
     * @return
     * The fileFoto
     *
    public String getFileFoto() {
        return fileFoto;
    }
*/
    /**
     *
     * @param //fileFoto
     * The file_foto
     *
    public void setFileFoto(String fileFoto) {
        this.fileFoto = fileFoto;
    }
*/
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}