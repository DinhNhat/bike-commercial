package com.nhatdinhnguyen.bicycleproject;

import com.nhatdinhnguyen.bicycleproject.db.domain.Brand;
import com.nhatdinhnguyen.bicycleproject.db.domain.Category;
import com.nhatdinhnguyen.bicycleproject.db.domain.Customer;
import com.nhatdinhnguyen.bicycleproject.db.repo.BrandRepository;
import com.nhatdinhnguyen.bicycleproject.db.repo.CategoryRepository;
import com.nhatdinhnguyen.bicycleproject.db.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;

@SpringBootApplication
public class BicycleProjectApplication implements CommandLineRunner {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(BicycleProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("************Original Brand***************");
		this.brandRepository.findAll().forEach(System.out::println);
		System.out.println("The total number of brand: " + this.brandRepository.count());

//		System.out.println("\nFind Customer with the state is 'CA'");
//		customerRepository.findAll(Example.of(new Customer("CA"))).forEach(System.out::println);
	}
}
