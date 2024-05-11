package com.example.project.service;

import com.example.project.model.WeatherInfoVO;

import java.util.List;
import java.util.Map;

public interface WeatherSearchService {
    public List<WeatherInfoVO> searchWeatherList(String urlBuilder) throws Exception;
}
