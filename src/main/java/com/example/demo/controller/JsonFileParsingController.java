package com.example.demo.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class JsonFileParsingController {

    @GetMapping("/parse")
    String fileParsing(){

        ClassPathResource resource = new ClassPathResource("json/data.json");
        JSONParser jsonParser = new JSONParser();
        try{
            FileReader fileReader = new FileReader(ResourceUtils.getFile(resource.getURI()));
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            System.out.println(jsonObject);
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }


        return "";
    }


}
