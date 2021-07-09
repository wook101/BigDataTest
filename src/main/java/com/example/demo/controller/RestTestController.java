package com.example.demo.controller;



import com.example.demo.dto.SubwayStat;
import com.example.demo.dto.SubwayStat3;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class RestTestController {

    @GetMapping("/")
    public ResponseEntity home(){
        /*
        1.RestTempate객체 생성
        2.URI클래스의 create메소드의 인자로 openApi주소입력
        3.RestTemplate클래스 exchange메소드의 인자로 url, http메소드 타입, HttpEntity객체, String.class
        4.ResponseEntity의 getBody().toStirng()메소드 실행 //getBody(), body부분만 사용
        5.파싱, 데이터 처리

        6.클래스 생성 후 매핑 후 db에 저장 // Gson라이브러리로 dto와 json형태의 string 매핑
        7.json파일에서 데이터 읽어온 후 db에 저장
        */
        RestTemplate restTemplate = new RestTemplate();
        URI url = URI.create("http://openapi.seoul.go.kr:8088/69584a57756568643130366e5a756c77/json/CardSubwayStatsNew/1/10/20210701");
        HttpEntity entity = null;
        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("1.body: "+response.getBody().toString());

        JSONParser jsonParser = new JSONParser();
        try{
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody().toString());//String to JSONObject
            JSONObject CardSubwayStatsNew = (JSONObject) jsonObject.get("CardSubwayStatsNew");  //Object to JSONObject
            JSONArray jsonArray = (JSONArray) CardSubwayStatsNew.get("row");                    //Object to JSONArray
            System.out.println("2.CardSubwayStatsNew: "+CardSubwayStatsNew.toString());
            System.out.println("3.row: ");
            Gson gson = new Gson();
            for (Object idx : jsonArray){
                SubwayStat subwayStatDto = gson.fromJson(idx.toString(), SubwayStat.class);
                System.out.println(subwayStatDto.toString());
            }
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return response;
    }

}
