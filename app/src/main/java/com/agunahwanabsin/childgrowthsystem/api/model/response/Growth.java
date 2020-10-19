package com.agunahwanabsin.childgrowthsystem.api.model.response;

import com.google.gson.annotations.SerializedName;

public class Growth {
    @SerializedName("tanggal_catat")
    private String TanggalCatat;
    @SerializedName("tinggi")
    private int Tinggi;
    @SerializedName("berat")
    private int Berat;
    @SerializedName("catatan")
    private String Catatan;
    @SerializedName("create_date")
    private String CreateDate;
    @SerializedName("create_by")
    private String CreateBy;
    @SerializedName("update_date")
    private String UpdateDate;
    @SerializedName("update_by")
    private String UpdateBy;

    public String getTanggalCatat() {
        return TanggalCatat;
    }

    public void setTanggalCatat(String tanggalCatat) {
        TanggalCatat = tanggalCatat;
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

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String createBy) {
        CreateBy = createBy;
    }

    public String getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(String updateDate) {
        UpdateDate = updateDate;
    }

    public String getUpdateBy() {
        return UpdateBy;
    }

    public void setUpdateBy(String updateBy) {
        UpdateBy = updateBy;
    }
}
