package com.example.project.controller;

import com.example.project.service.WeatherSearchService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

public class WeatherSearchController {

    @Resource(name = "weatherSearchService")
    private WeatherSearchService weatherSearchService;

    @RequestMapping(value = "/weather")
    public String weather() throws Exception{
        return "weather";
    }

    @RequestMapping(value = "weathersearch")
    public String weatherSearch() throws Exception{

        // 기상청 API service Key값
        String serviceKey = "=yuuAIagVrMk4nnZy2%2Fy47WSlSR6qihjxhcjfgbeNq5%2BeNCpfO%2FvoIwRuplGaBHclEUKpYaAmKL6aoxBKPfZqSw%3D%3D";
        String URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";

        //URI 및 WEB에서 설정한 값 설정
        StringBuilder urlBuilder = new StringBuilder(URL); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode("20240511", "UTF-8")); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0600", "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/

    }
}
