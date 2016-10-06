package teknologi.inspira.bentang.sistemcutipegawai.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import teknologi.inspira.bentang.sistemcutipegawai.R;
import teknologi.inspira.bentang.sistemcutipegawai.model.Cuti;

/**
 * Created by halim on 9/29/2016.
 */

public class DataListCutiAdapter extends RecyclerView.Adapter<DataListCutiAdapter.CutiViewHolder> {
    private List<Cuti> listCuti;
    private Context mContext;
    private int rowLayout;

    public static class CutiViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle,kodeusulan;
        TextView waktuUsulan;
        TextView tmulai,takhir;
        TextView rating;
        TextView status;
        RelativeLayout bg_status;
        ImageView label;

        public CutiViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.judul);
            waktuUsulan = (TextView) v.findViewById(R.id.waktu_usulan);
            tmulai   =(TextView) v.findViewById(R.id.description);
            status   =(TextView) v.findViewById(R.id.status);
            bg_status = (RelativeLayout) v.findViewById(R.id.bg_status);
            label    =(ImageView)v.findViewById(R.id.rating_image);
            kodeusulan =(TextView)v.findViewById(R.id.kodeusulan);

        }
    }
    public DataListCutiAdapter(List<Cuti> listCuti,int rowLayout, Context context){
        this.listCuti  = listCuti;
        this.rowLayout = rowLayout;
        this.mContext  = context;
    }

    @Override
    public DataListCutiAdapter.CutiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CutiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CutiViewHolder holder, int position) {
        holder.movieTitle.setText(listCuti.get(position).getJcuti());
        holder.waktuUsulan.setText("Diusulkan :"+listCuti.get(position).getWaktuUsulan());
        holder.tmulai.setText(listCuti.get(position).getTmulai()+" - "+listCuti.get(position).getTakhir());
        holder.kodeusulan.setText(listCuti.get(position).getKodeusulan());

        int statusCuti=listCuti.get(position).getStatus_cuti();
        if(statusCuti == 1) {
            holder.label.setImageResource(R.drawable.ic_wait);
            holder.status.setText("Pending");
        }else if(statusCuti == 2) {
            holder.label.setImageResource(R.drawable.ic_done);
            holder.status.setText("Approval");
        }else if(statusCuti == 3){
            holder.label.setImageResource(R.drawable.ic_cetak);
            holder.status.setText("Output");
        }else if(statusCuti == 4){
            holder.label.setImageResource(R.drawable.ic_batal);
            holder.status.setText("Penolakan");
        }
    }

    @Override
    public int getItemCount() {
        return listCuti.size();
    }


}
