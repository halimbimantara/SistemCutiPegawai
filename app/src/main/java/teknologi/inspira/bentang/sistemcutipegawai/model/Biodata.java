package teknologi.inspira.bentang.sistemcutipegawai.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by halim on 10/5/2016.
 */

public class Biodata {

    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("namapeg")
    @Expose
    private String namapeg;


    @SerializedName("pangkat")
    @Expose
    private String pangkat;

    @SerializedName("jabatan")
    @Expose
    private String jabatan;

    @SerializedName("unitkerja")
    @Expose
    private String unitkerja;

    @SerializedName("no_hp")
    @Expose
    private String no_hp;

    @SerializedName("email")
    @Expose
    private String email;

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

    public String getNamapeg() {
        return namapeg;
    }

    public void setNamapeg(String namapeg) {
        this.namapeg = namapeg;
    }

    public String getPangkat() {
        return pangkat;
    }

    public void setPangkat(String pangkat) {
        this.pangkat = pangkat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getUnitkerja() {
        return unitkerja;
    }

    public void setUnitkerja(String unitkerja) {
        this.unitkerja = unitkerja;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
