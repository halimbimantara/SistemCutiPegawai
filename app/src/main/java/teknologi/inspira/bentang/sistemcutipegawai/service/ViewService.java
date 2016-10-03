package teknologi.inspira.bentang.sistemcutipegawai.service;

/**
 * Created by halim on 9/29/2016.
 */
        import android.content.Context;
        import android.graphics.Color;
        import android.widget.LinearLayout;
        import android.widget.TextView;

/**
 * Created by ekky on 1/25/16.
 */
public class ViewService {
    public LinearLayout setLinearLayout(String label, String value, Context mContext){
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView tvLabel = new TextView(mContext);
        TextView tvValue = new TextView(mContext);
        tvLabel.setText(label);
        tvLabel.setTextColor(Color.BLACK);
        if (value==null){
            tvValue.setText(" ");
        }else{
            tvValue.setText(value);
        }
        linearLayout.addView(tvLabel);
        linearLayout.addView(tvValue);
        return linearLayout;
    }

    public LinearLayout setNullLinearLayout(Context mContext){
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView tvLabel = new TextView(mContext);
        tvLabel.setText("Data tidak ada.");
        return linearLayout;
    }
}
