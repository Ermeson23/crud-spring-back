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

			for (int i = 1; i < 6; i++) {
				Course c = new Course();
				c.setName("Angular " + i);
				c.setCategory(Category.FRONTEND);

				for(int j = 0; j < 1; j++) {
					Lesson l = new Lesson();
					l.setName("Introdução");
					l.setYoutubeUrl("GTy47yMdCgs");
					l.setCourse(c);
					c.getLessons().add(l);
				}

				courseRepository.save(c);
			}
		};
	}

}
