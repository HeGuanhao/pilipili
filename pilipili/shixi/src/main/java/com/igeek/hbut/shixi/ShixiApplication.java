package com.igeek.hbut.shixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.igeek.hbut.shixi.mapper"})
public class ShixiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShixiApplication.class, args);
	}

}
