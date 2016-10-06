package teknologi.inspira.bentang.sistemcutipegawai.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by halim on 10/5/2016.
 */

public class Atasan {


    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("message")
    @Expose
    private String message;


    @SerializedName("nipatasan")
    @Expose
    private String nipatasan;

    @SerializedName("namapeg")
    @Expose
    private String namapeg;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNipatasan() {
        return nipatasan;
    }

    public void setNipatasan(String nipatasan) {
        this.nipatasan = nipatasan;
    }

    public String getNamapeg() {
        return namapeg;
    }

    public void setNamapeg(String namapeg) {
        this.namapeg = namapeg;
    }
}
