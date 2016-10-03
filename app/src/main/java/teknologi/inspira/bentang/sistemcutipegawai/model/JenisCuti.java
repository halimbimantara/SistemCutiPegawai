package teknologi.inspira.bentang.sistemcutipegawai.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by halim on 9/30/2016.
 */
public class JenisCuti {
    @SerializedName("kategori_cuti")
    String kategori;

    @SerializedName("nama_cuti")
    String nama_cuti;

    @SerializedName("max")
    int max;

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getNama_cuti() {
        return nama_cuti;
    }

    public void setNama_cuti(String nama_cuti) {
        this.nama_cuti = nama_cuti;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
