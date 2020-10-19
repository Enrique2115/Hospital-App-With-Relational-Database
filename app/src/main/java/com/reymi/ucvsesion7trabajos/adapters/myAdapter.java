package com.reymi.ucvsesion7trabajos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reymi.ucvsesion7trabajos.R;
import com.reymi.ucvsesion7trabajos.entidades.Cita;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.CitasViewHolder> {

    private Context context;
    private int layout;
    private ArrayList<Cita> citaList;
    private OnItemClickListener onItemClickListener;

    public myAdapter(Context context, int layout, ArrayList<Cita> citaList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.layout = layout;
        this.citaList = citaList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);
        return new CitasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitasViewHolder holder, int position) {
        holder.setDatos(citaList.get(position));
        holder.bind(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return citaList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class CitasViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombreMedico, tvNombrePaciente, tvConsulta, tvPrecio;

        public CitasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreMedico = itemView.findViewById(R.id.tvNombreMedico);
            tvNombrePaciente = itemView.findViewById(R.id.tvNombrePaciente);
            tvConsulta = itemView.findViewById(R.id.tvConsulta);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }

        void setDatos(Cita cita) {
            tvNombreMedico.setText(cita.getNomMedico());
            tvNombrePaciente.setText(cita.getNomPaciente());
            tvConsulta.setText(cita.getConsulta());
            tvPrecio.setText(String.valueOf(cita.getPrecio()));
        }

        public void bind(final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
