DROP TABLE IF EXISTS subway;
create table subway (id int primary key auto_increment,
                    RIDE_PASGR_NUM int,
                    USE_DT VARCHAR(10),
                    LINE_NUM VARCHAR(10),
                    SUB_STA_NM VARCHAR(20),
                    ALIGHT_PASGR_NUM int,
                    WORK_DT VARCHAR(10));