package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.StoreInformation;
import com.example.demo.repository.StoreInformationRepository;

@SpringBootApplication
public class DbdemospringbootApplication implements CommandLineRunner {

	@Autowired
	StoreInformationRepository storeInformationRepository;

	public static void main(String[] args) {
		SpringApplication.run(DbdemospringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		StoreInformation storeInformationOne = new StoreInformation("Amazon", "All type bags are available",
				"687688787687");
		StoreInformation storeInformationTwo = new StoreInformation("Flipkart", "All type books are available",
				"68768878766");
		StoreInformation storeInformationThree = new StoreInformation("Meesho", "All type Fashion are available",
				"687688787688");
		StoreInformation storeInformationFour = new StoreInformation("Myntra", "All type Fashion  are available",
				"687688787689");
		storeInformationRepository.save(storeInformationOne);
		storeInformationRepository.save(storeInformationTwo);
		storeInformationRepository.save(storeInformationThree);
		storeInformationRepository.save(storeInformationFour);

		storeInformationRepository.findByStoreName("Amazon").forEach(val -> System.out.println(val));

		storeInformationRepository.findByStoreDetail("All type Fashion  are available")
				.forEach(val -> System.out.println(val));

		storeInformationRepository.findByStorePhoneNumber("687688787688").forEach(val -> System.out.println(val));

		storeInformationRepository.findById(2).ifPresent(val -> System.out.println(val));

		System.out.println(storeInformationRepository.count());

		storeInformationRepository.deleteById(3);

		System.out.println(storeInformationRepository.count());

	}

}
