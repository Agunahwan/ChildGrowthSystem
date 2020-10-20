package com.agunahwanabsin.childgrowthsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.agunahwanabsin.childgrowthsystem.api.instance.GrowthInterface;
import com.agunahwanabsin.childgrowthsystem.api.model.request.Growth;
import com.agunahwanabsin.childgrowthsystem.api.services.GrowthServices;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActionGrowthActivity extends AppCompatActivity {

    TextView lblTanggal;
    EditText txtTinggi, txtBerat, txtCatatan;
    Button btnTanggal, btnMinTinggi, btnMaxTinggi, btnMinBerat, btnMaxBerat, btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_growth);

        // Add Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Initiate object view
        lblTanggal = (TextView) findViewById(R.id.tanggal);
        txtTinggi = (EditText) findViewById(R.id.tinggi);
        txtBerat = (EditText) findViewById(R.id.berat);
        txtCatatan = (EditText) findViewById(R.id.catatan);
        btnTanggal = (Button) findViewById(R.id.datepicker);
        btnMinTinggi = (Button) findViewById(R.id.min_tinggi);
        btnMaxTinggi = (Button) findViewById(R.id.max_tinggi);
        btnMinBerat = (Button) findViewById(R.id.min_berat);
        btnMaxBerat = (Button) findViewById(R.id.max_berat);
        btnSimpan = (Button) findViewById(R.id.simpan);

        // Set event button
        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateTimeDialog();
            }
        });
        btnMinTinggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumberPickerClick(txtTinggi, false);
            }
        });
        btnMaxTinggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumberPickerClick(txtTinggi);
            }
        });
        btnMinBerat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumberPickerClick(txtBerat, false);
            }
        });
        btnMaxBerat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumberPickerClick(txtBerat);
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public String getDeviceId() {
        TelephonyManager telephonyManager;
        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        /*
         * getDeviceId() returns the unique device ID.
         * For example,the IMEI for GSM and the MEID or ESN for CDMA phones.
         */
        String deviceId = telephonyManager.getDeviceId();

        return deviceId;
    }

    private void setNumberPickerClick(EditText textBox) {
        this.setNumberPickerClick(textBox, true);
    }

    private void setNumberPickerClick(EditText textBox, boolean isAddButton) {
        int jumlah;
        final int increment = 5;

        if (textBox.getText().toString().trim().equals("")) {
            jumlah = 0;
        } else {
            jumlah = Integer.parseInt(textBox.getText().toString());
        }

        if (isAddButton) {
            jumlah += increment;
        } else {
            if (jumlah > (increment - 1)) {
                jumlah -= increment;
            } else {
                jumlah = 0;
            }
        }

        textBox.setText(String.valueOf(jumlah));
    }

    private void showDateTimeDialog() {
        int mYear, mMonth, mDay;

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        String monthString = String.valueOf(monthOfYear + 1);
                        if (monthString.length() == 1) {
                            monthString = "0" + monthString;
                        }
                        lblTanggal.setText(dayOfMonth + "/" + monthString + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void save() {
        // Preparing data for saving
        Growth data = new Growth();
        data.setDeviceId("");
        data.setTanggalCatat(lblTanggal.getText().toString());
        data.setTinggi(Integer.parseInt(txtTinggi.getText().toString()));
        data.setBerat(Integer.parseInt(txtBerat.getText().toString()));
        data.setCatatan(txtCatatan.getText().toString());

        GrowthInterface service = GrowthServices.save();
        Call<Boolean> call = service.save(data);
        Callback<Boolean> callback = new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()) {
                    Boolean isSuccess = response.body();
                    if (isSuccess) {
                        Toast.makeText(getApplicationContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Data gagal disimpan!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t.toString(), Toast.LENGTH_LONG).show();
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        };
        call.enqueue(callback);
    }
}