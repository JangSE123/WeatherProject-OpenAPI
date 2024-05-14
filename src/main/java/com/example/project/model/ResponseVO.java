package com.example.project.model;

import java.util.List;

public class ResponseVO {
    private ResponseVO response;

    public ResponseVO(){}

    public ResponseVO(ResponseVO response){
        this.response = response;
    }

    public ResponseVO getResponse() {
        return response;
    }
    public void setResponse(ResponseVO response) {
        this.response = response;
    }

    public String toString() {
        return "WeatherSearchResultVO {response=" + response
                + ", getResponse()=" + getResponse()
                + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "}";
    }

}
