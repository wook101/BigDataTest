package com.example.demo.dto;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public class SubwayStat3 {
    @SerializedName("WORK_DT")
    private String WORK_DT;
    @SerializedName("ALIGHT_PASGR_NUM")
    private int ALIGHT_PASGR_NUM;
    @SerializedName("RIDE_PASGR_NUM")
    private int RIDE_PASGR_NUM;
    @SerializedName("SUB_STA_NM")
    private String SUB_STA_NM;
    @SerializedName("LINE_NUM")
    private String LINE_NUM;
    @SerializedName("USE_DT")
    private String USE_DT;
}
