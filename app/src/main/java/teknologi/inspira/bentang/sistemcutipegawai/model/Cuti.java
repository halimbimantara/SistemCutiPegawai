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


}
