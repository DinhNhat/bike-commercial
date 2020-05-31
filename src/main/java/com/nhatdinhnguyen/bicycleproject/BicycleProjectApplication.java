package com.nhatdinhnguyen.bicycleproject;

import com.nhatdinhnguyen.bicycleproject.db.domain.Brand;
import com.nhatdinhnguyen.bicycleproject.db.repo.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BicycleProjectApplication implements CommandLineRunner {

	@Autowired
	private BrandRepository brandRepository;

	public static void main(String[] args) {
		SpringApplication.run(BicycleProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("************Original Brand***************");
		this.brandRepository.findAll().forEach(System.out::println);
		System.out.println("The total number of brand: " + this.brandRepository.count());
	}
}
