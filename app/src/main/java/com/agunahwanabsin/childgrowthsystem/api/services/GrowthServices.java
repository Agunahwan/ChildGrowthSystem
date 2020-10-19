package com.agunahwanabsin.childgrowthsystem.api.services;

import com.agunahwanabsin.childgrowthsystem.api.helper.ApiClient;
import com.agunahwanabsin.childgrowthsystem.api.instance.GrowthInterface;

public class GrowthServices {
    public static GrowthInterface getList(){
        return ApiClient.getRetrofitInstance().create(GrowthInterface.class);
    }

    public static GrowthInterface save(){
        return ApiClient.getRetrofitInstance().create(GrowthInterface.class);
    }

    public static GrowthInterface delete(){
        return ApiClient.getRetrofitInstance().create(GrowthInterface.class);
    }
}
