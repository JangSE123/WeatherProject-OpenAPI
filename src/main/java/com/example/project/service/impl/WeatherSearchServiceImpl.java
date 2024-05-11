package com.example.project.service.impl;

import com.example.project.adapter.WeatherInfoSearchInterface;
import com.example.project.model.WeatherInfoVO;
import com.example.project.model.WeatherSearchResultVO;
import com.example.project.service.WeatherSearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("weatherSearchService")
public class WeatherSearchServiceImpl implements WeatherSearchService {
    WeatherInfoSearchInterface weatherSearchInterface = new WeatherInfoSearchInterface();

    public List<WeatherInfoVO> searchWeatherList (String urlBuilder ) throws Exception {
        String responseBody = weatherSearchInterface.getWeatherInfo(urlBuilder);
        ObjectMapper mapper = new ObjectMapper();
        WeatherSearchResultVO resultVO = null;

        try {
            resultVO = mapper.readValue(responseBody, WeatherSearchResultVO.class);
        } catch (JsonMappingException e) {
            throw new Exception("JSON 에러 : " + e);
        } catch (JsonProcessingException e) {
            throw new Exception("JSON 에러 : " + e);
        }

        List<WeatherInfoVO> weathers = resultVO.getItems();

        for (int i = 0; i < weathers.size(); i++) {
            WeatherInfoVO weatherInfo = weathers.get(i);
            System.out.println(i+"==>" + weatherInfo.getAddress());
        }
        return weathers;
    }
}
