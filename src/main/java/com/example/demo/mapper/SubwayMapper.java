package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubwayMapper {
    @Insert("insert into subway(RIDE_PASGR_NUM, USE_DT, LINE_NUM, SUB_STA_NM, ALIGHT_PASGR_NUM, WORK_DT) values(#{RIDE_PASGR_NUM}, #{USE_DT}, #{LINE_NUM}, #{SUB_STA_NM}, #{ALIGHT_PASGR_NUM}, #{WORK_DT})")
    public void insertSubwayOnOff(@Param("RIDE_PASGR_NUM") int RIDE_PASGR_NUM,
                                  @Param("USE_DT") String USE_DT,
                                  @Param("LINE_NUM") String LINE_NUM,
                                  @Param("SUB_STA_NM") String SUB_STA_NM,
                                  @Param("ALIGHT_PASGR_NUM") int ALIGHT_PASGR_NUM,
                                  @Param("WORK_DT") String WORK_DT);

}
