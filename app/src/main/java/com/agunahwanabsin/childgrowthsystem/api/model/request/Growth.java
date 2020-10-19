package com.agunahwanabsin.childgrowthsystem.api.model.request;

import com.google.gson.annotations.SerializedName;

public class Growth {
    @SerializedName("TanggalCatat")
    private String TanggalCatat;
    @SerializedName("DeviceId")
    private String DeviceId;
    @SerializedName("Tinggi")
    private int Tinggi;
    @SerializedName("Berat")
    private int Berat;
    @SerializedName("Catatan")
    private String Catatan;

    public String getTanggalCatat() {
        return TanggalCatat;
    }

    public void setTanggalCatat(String tanggalCatat) {
        TanggalCatat = tanggalCatat;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public int getTinggi() {
        return Tinggi;
    }

    public void setTinggi(int tinggi) {
        Tinggi = tinggi;
    }

    public int getBerat() {
        return Berat;
    }

    public void setBerat(int berat) {
        Berat = berat;
    }

    public String getCatatan() {
        return Catatan;
    }

    public void setCatatan(String catatan) {
        Catatan = catatan;
    }
}
