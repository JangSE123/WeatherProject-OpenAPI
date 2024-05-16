package com.example.project.controller;

import com.example.project.changeValue.CoordinateConverter;
import com.example.project.model.ParamDTO;
import com.example.project.model.WeatherInfoVO;
import com.example.project.service.WeatherSearchService;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WeatherSearchController {

    @Resource(name = "weatherSearchService")
    private WeatherSearchService weatherSearchService;

    @RequestMapping(value = "/weather")
    public String weather() throws Exception{
        return "weather";
    }

    @RequestMapping(value = "weathersearch")
    public String weatherSearchList(ParamDTO params, Model model) throws Exception{
//    public String weatherSearchList(String baseDate,String baseTime, String Nx, String Ny, Model model) throws Exception{

        // @PathParam("nx")string nx
        //http://localhost:8080/weathersearch?nx="12"&ny=52

        // 기상청 API service Key값, 받아올 자료 URL 설정
        String serviceKey = "=yuuAIagVrMk4nnZy2%2Fy47WSlSR6qihjxhcjfgbeNq5%2BeNCpfO%2FvoIwRuplGaBHclEUKpYaAmKL6aoxBKPfZqSw%3D%3D";
        String URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";

//        //검색어 Encoding
//        try {
//            params.getParma1();
//            keyword = URLEncoder.encode(keyword, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException("검색어 인코딩 실패",e);
//        }

        //URI 및 WEB에서 설정한 값 설정
        StringBuilder urlBuilder = new StringBuilder(URL); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(params.getBaseDate(), "UTF-8")); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(params.getBaseTime(), "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(params.getNx(), "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(params.getNy(), "UTF-8")); /*예보지점의 Y 좌표값*/
//        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); /*‘21년 6월 28일 발표*/
//        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(baseTime, "UTF-8")); /*06시 발표(정시단위) */
//        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(Nx, "UTF-8")); /*예보지점의 X 좌표값*/
//        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(Ny, "UTF-8")); /*예보지점의 Y 좌표값*/

        List<WeatherInfoVO> weathers = weatherSearchService.searchWeatherList(urlBuilder.toString());

        // 발표시간이 같은 데이터를 그룹화하는 맵
        Map<String, List<WeatherInfoVO>> groupedWeathers = new HashMap<>();
        for (WeatherInfoVO weather : weathers) {
            String fcstTime = weather.getFcstTime();
            if (!groupedWeathers.containsKey(fcstTime)) {
                groupedWeathers.put(fcstTime, new ArrayList<>());
            }
            groupedWeathers.get(fcstTime).add(weather);
        }
        model.addAttribute("groupedWeathers", groupedWeathers);

        System.out.println(" URL ==> "+urlBuilder);

        model.addAttribute("weathers", weathers);

        return "weatherSearchResult";

    }
}