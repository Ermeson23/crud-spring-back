package com.ermeson.crudspring;

import com.ermeson.crudspring.enums.Category;
import com.ermeson.crudspring.model.Course;
import com.ermeson.crudspring.model.Lesson;


import com.ermeson.crudspring.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner initDataBase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			for (int i = 0; i < 20; i++) {
				Course c = new Course();
				c.setName("Angular");
				c.setCategory(Category.FRONTEND);

				Lesson l = new Lesson();
				l.setName("Introdução");
				l.setYoutubeUrl("wtstfs98ea");
				l.setCourse(c);
				c.getLessons().add(l);

				Lesson l2 = new Lesson();
				l2.setName("Angular");
				l2.setYoutubeUrl("wtsv2wtst8");
				l2.setCourse(c);
				c.getLessons().add(l2);

				courseRepository.save(c);
			}
		};
	}

}
