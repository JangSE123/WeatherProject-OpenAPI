package com.example.project;

import com.example.project.changeValue.MapController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherProjectApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(WeatherProjectApplication.class, args);
//	}
	public static void main(String[] args) {
		SpringApplication.run(MapController.class, args);
	}

}