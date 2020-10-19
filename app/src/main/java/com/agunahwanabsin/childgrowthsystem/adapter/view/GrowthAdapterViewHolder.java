package com.agunahwanabsin.childgrowthsystem.adapter.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agunahwanabsin.childgrowthsystem.R;

public class GrowthAdapterViewHolder extends RecyclerView.ViewHolder {
    public TextView tanggalCatat;
    public TextView tinggi;
    public TextView berat;
    public Button hapus;

    public GrowthAdapterViewHolder(@NonNull View itemView) {
        super(itemView);

        tanggalCatat = (TextView) itemView.findViewById(R.id.tanggal);
        tinggi = (TextView) itemView.findViewById(R.id.tinggi);
        berat = (TextView) itemView.findViewById(R.id.berat);
        hapus = (Button) itemView.findViewById(R.id.hapus);
    }
}
