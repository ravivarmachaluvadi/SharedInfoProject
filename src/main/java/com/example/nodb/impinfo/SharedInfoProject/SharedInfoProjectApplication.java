package com.example.nodb.impinfo.SharedInfoProject;

import com.example.nodb.impinfo.SharedInfoProject.entity.PostComment;
import com.example.nodb.impinfo.SharedInfoProject.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootApplication
public class SharedInfoProjectApplication implements CommandLineRunner {

	@Autowired
	EntityManager entityManager;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SharedInfoProjectApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		PostEntity post = new PostEntity("First post");
		post.setId(221);

		post.getComments().add(
				new PostComment("My first review")
		);
		post.getComments().add(
				new PostComment("My second review")
		);
		post.getComments().add(
				new PostComment("My third review")
		);

		entityManager.persist(post);

		System.out.println();

		System.out.println();

	}
}
