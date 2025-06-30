package com.akrishtyadav.aspectObrientedProgramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AspectObrientedProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectObrientedProgrammingApplication.class, args);
	}

}
