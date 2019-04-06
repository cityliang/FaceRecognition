package com.alibaba.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@EnableScheduling
@SpringBootApplication
public class FaceRecognitionApp extends SpringBootServletInitializer {
	/**
	 * 人脸识别授权码
	 */
	public String VENDOR_KEY = "eyJ2ZW5kb3JJZCI6ImNlc2hpX3ZlbmRvciIsInJvbGUiOjIsImNvZGUiOiIzRDE5RUIwNjY1OEE5MUExQzlCNDY0MzhDN0QwNDFGMyIsImV4cGlyZSI6IjIwMTkwMzMxIiwidHlwZSI6MX0=";
	public static void main(String[] args) {
		// 下面是 人脸识别SDK 授权认证  已弃用
//        int error = FaceEngine.authorize(VENDOR_KEY);
//        if (error != Error.OK) {
//            log.error("authorize error 人脸识别认证失败: " + error);
//            return;
//        } else {
//            log.info("authorize OK 人脸识别认证成功");
//        }
        // 启动springboot程序
        SpringApplication.run(FaceRecognitionApp.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FaceRecognitionApp.class);
	}
}
