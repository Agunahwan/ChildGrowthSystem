package com.agunahwanabsin.childgrowthsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agunahwanabsin.childgrowthsystem.adapter.GrowthAdapter;
import com.agunahwanabsin.childgrowthsystem.api.instance.GrowthInterface;
import com.agunahwanabsin.childgrowthsystem.api.model.response.Growth;
import com.agunahwanabsin.childgrowthsystem.api.services.GrowthServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvData;
    Button btnTambah;
    GrowthAdapter adapter;
    List<Growth> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = (RecyclerView) findViewById(R.id.data_recycler);
        btnTambah = (Button) findViewById(R.id.tambah);

        rvData.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvData.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActionGrowthActivity.class);
                startActivity(intent);
            }
        });

        getListData();
    }

    private void getListData() {
        GrowthInterface service = GrowthServices.getList();
        Call<List<Growth>> call = service.getList();
        Callback<List<Growth>> callback = new Callback<List<Growth>>() {
            @Override
            public void onResponse(Call<List<Growth>> call, Response<List<Growth>> response) {
                if (response.isSuccessful()) {
                    listData = response.body();
                    if (listData.size() > 0) {
                        adapter = new GrowthAdapter(getApplicationContext(), listData);

                        rvData.setAdapter(adapter);
                    } else {
                        Toast.makeText(getApplicationContext(), "Data kosong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Growth>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t.toString(), Toast.LENGTH_LONG).show();
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        };
        call.enqueue(callback);
    }
}