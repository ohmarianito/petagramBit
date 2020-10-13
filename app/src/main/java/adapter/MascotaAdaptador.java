package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.petagrambit.Mascota;
import com.coursera.petagrambit.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        if (mascota.getNombre().equals("NONE")){
            mascotaViewHolder.tvNombreCV.setText("");
            mascotaViewHolder.imgFav.setVisibility(View.INVISIBLE);
        }else {
            mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        }
        mascotaViewHolder.imgUrlCV.setImageResource(mascota.getUrlImage());
        mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));


    }

    @Override
    public int getItemCount() {
       return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgUrlCV;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageView imgFav;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUrlCV    = (ImageView) itemView.findViewById(R.id.imgUrlCV);
            tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikesCV   = (TextView) itemView.findViewById(R.id.tvLikesCV);
            imgFav    = (ImageView) itemView.findViewById(R.id.imgFavCV);

        }
    }
}
