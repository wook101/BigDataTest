package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubwayStat {
    private String USE_DT;
    private String LINE_NUM;
    private String SUB_STA_NM;
    private int RIDE_PASGR_NUM;
    private int ALIGHT_PASGR_NUM;
    private String WORK_DT;
}
