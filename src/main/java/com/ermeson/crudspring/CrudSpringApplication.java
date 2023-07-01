package com.ermeson.crudspring;

import com.ermeson.crudspring.enums.Category;
import com.ermeson.crudspring.model.Course;
import com.ermeson.crudspring.model.Lesson;
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
			c.setCategory(Category.FRONTEND);

			Lesson l = new Lesson();
			l.setName("Introdução");
			l.setYoutubeUrl("wtstfs98");
			l.setCourse(c);
			c.getLessons().add(l);

			courseRepository.save(c);
		};
	}

}
