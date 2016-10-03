package teknologi.inspira.bentang.sistemcutipegawai.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by halim on 9/26/2016.
 */

public class Cuti {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("kode_usulan")
    @Expose
    private String kodeusulan;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("waktu_usulan")
    @Expose
    private String waktuUsulan;

    @SerializedName("tmulai")
    @Expose
    private String tmulai;

    @SerializedName("takhir")
    @Expose
    private String takhir;

    public String getJcuti() {
        return jcuti;
    }

    public void setJcuti(String jcuti) {
        this.jcuti = jcuti;
    }

    public String getWaktuUsulan() {
        return waktuUsulan;
    }

    public void setWaktuUsulan(String waktuUsulan) {
        this.waktuUsulan = waktuUsulan;
    }

    public String getTmulai() {
        return tmulai;
    }

    public void setTmulai(String tmulai) {
        this.tmulai = tmulai;
    }

    public String getTakhir() {
        return takhir;
    }

    public void setTakhir(String takhir) {
        this.takhir = takhir;
    }

    @SerializedName("jcuti")
    @Expose
    private String jcuti;

    //status cuti yang diajukan
    @SerializedName("status_cuti")
    @Expose
    private int status_cuti;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKodeusulan() {
        return kodeusulan;
    }

    public void setKodeusulan(String kodeusulan) {
        this.kodeusulan = kodeusulan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStatus_cuti() {
        return status_cuti;
    }

    public void setStatus_cuti(int status_cuti) {
        this.status_cuti = status_cuti;
    }
}
