package com.agunahwanabsin.childgrowthsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agunahwanabsin.childgrowthsystem.R;
import com.agunahwanabsin.childgrowthsystem.adapter.view.GrowthAdapterViewHolder;
import com.agunahwanabsin.childgrowthsystem.api.model.response.Growth;
import com.agunahwanabsin.childgrowthsystem.helper.CommonLibrary;

import java.util.List;

public class GrowthAdapter extends RecyclerView.Adapter<GrowthAdapterViewHolder> {
    Context mContext;
    List<Growth> mListData;

    public GrowthAdapter(Context mContext, List<Growth> mListData) {
        this.mContext = mContext;
        this.mListData = mListData;
    }

    @NonNull
    @Override
    public GrowthAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_data, parent, false);
        GrowthAdapterViewHolder viewHolder = new GrowthAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GrowthAdapterViewHolder holder, int position) {
        String tanggal = CommonLibrary.formattingDate(mListData.get(position).getTanggalCatat());
        String tinggi = String.valueOf(mListData.get(position).getTinggi());
        String berat = String.valueOf(mListData.get(position).getBerat());

        holder.tanggalCatat.setText(tanggal);
        holder.tinggi.setText(tinggi);
        holder.berat.setText(berat);

        holder.hapus.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return (mListData != null ? mListData.size() : 0);
    }
}
