package com.example.demo.controller;

import com.example.demo.dto.SubwayStat;
import com.example.demo.mapper.SubwayMapper;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;


@Controller
public class JsonFileParsingController {

    private SubwayMapper mapper;
    public JsonFileParsingController(SubwayMapper mapper){
        this.mapper = mapper;
    }

    @GetMapping("/parse")
    @ResponseBody
    String fileParsing(){
        ClassPathResource resource = new ClassPathResource("json/data.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject=null;
        try{
            FileReader fileReader = new FileReader(ResourceUtils.getFile(resource.getURI()));
            jsonObject = (JSONObject) jsonParser.parse(fileReader);
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
        JSONObject CardSubwayStatsNewObject = (JSONObject) jsonObject.get("CardSubwayStatsNew");
        JSONArray row = (JSONArray) CardSubwayStatsNewObject.get("row");
        for (Object idx : row){
            System.out.println(idx);
            Gson gson = new Gson();
            SubwayStat subwayStat = gson.fromJson(idx.toString(),SubwayStat.class);
            /*
            mapper.insertSubwayOnOff(subwayStat.getRIDE_PASGR_NUM(),
                    subwayStat.getUSE_DT(),
                    subwayStat.getLINE_NUM(),
                    subwayStat.getSUB_STA_NM(),
                    subwayStat.getALIGHT_PASGR_NUM(),
                    subwayStat.getWORK_DT());

             */
        }


        return "성공";
    }





}
