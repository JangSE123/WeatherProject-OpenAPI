package com.example.project.service;

import com.example.project.model.WeatherInfoVO;

import java.util.List;

public interface WeatherSearchService {
    public List<WeatherInfoVO> searchWeatherList(String urlBuilder) throws Exception;
}
