package com.inner_circle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@SpringBootApplication
public class InnerCircleApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat calendarFormat = new SimpleDateFormat("HH:mm:ss");

		System.out.printf("Request received at: %s.\n", calendarFormat.format(calendar.getTime()));
		System.out.printf("Thread name: %s.\n", Thread.currentThread().getName());

		return "A heroic path from PHP to Java!";
	}

	public static void main(String[] args) {
		SpringApplication.run(InnerCircleApplication.class, args);
	}
}