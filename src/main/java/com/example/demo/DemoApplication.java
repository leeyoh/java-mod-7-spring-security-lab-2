package com.example.demo;
import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import com.example.demo.model.Signup;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.CamperRepository;
import com.example.demo.repository.SignupRepository;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Component
	public class ApplicationStartupRunner implements CommandLineRunner {
//		private final CamperRepository camperRepository;
//		private final ActivityRepository activityRepository;
//		private final SignupRepository signupRepository;
//
//		public ApplicationStartupRunner(CamperRepository camperRepository, ActivityRepository activityRepository, SignupRepository signupRepository) {
//			this.camperRepository = camperRepository;
//			this.activityRepository = activityRepository;
//			this.signupRepository = signupRepository;
//		}
//		@Override
		public void run(String... args) {}
	}
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
