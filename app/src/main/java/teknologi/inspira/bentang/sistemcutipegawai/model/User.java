package teknologi.inspira.bentang.sistemcutipegawai.model;

/**
 * Created by halim on 9/27/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("message")
    @Expose
    private String message;


    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nip")
    @Expose
    private String nip;

    @SerializedName("namapeg")
    @Expose
    private String namapeg;


    @SerializedName("token")
    @Expose
    private String token;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamapeg() {
        return namapeg;
    }

    public void setNamapeg(String namapeg) {
        this.namapeg = namapeg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}