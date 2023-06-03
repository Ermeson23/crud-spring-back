package com.ermeson.crudspring;

import com.ermeson.crudspring.model.Course;
import com.ermeson.crudspring.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular");
			c.setCategory("Front-end");

			// Course c2 = new Course();
			// c2.setName("React");
			// c2.setCategory("front-end");

			// Course c3 = new Course();
			// c3.setName("Spring");
			// c3.setCategory("back-end");

			// Course c4 = new Course();
			// c4.setName("Python");
			// c4.setCategory("back-end");

			// Course c5 = new Course();
			// c5.setName("Angular + Spring");
			// c5.setCategory("full-stack");

			 courseRepository.save(c);
			// courseRepository.save(c2);
			// courseRepository.save(c3);
			// courseRepository.save(c4);
			// courseRepository.save(c5);
		};
	}

}
