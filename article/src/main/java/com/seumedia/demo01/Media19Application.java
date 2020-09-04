package com.seumedia.demo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.seumedia.demo01.mapper")
public class Media19Application {


	public static void main(String[] args) {
		SpringApplication.run(Media19Application.class, args);
	}

}
