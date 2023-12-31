package com.tuan5;

import com.neovisionaries.i18n.CountryCode;
import com.tuan5.backend.models.Address;
import com.tuan5.backend.models.Candidate;
import com.tuan5.backend.repositories.AddressRepository;
import com.tuan5.backend.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
@SpringBootApplication
public class Tuan5Application {

	public static void main(String[] args) {
		SpringApplication.run(Tuan5Application.class, args);
	}
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Bean
	CommandLineRunner initData() {
		return args -> {
			Random rnd = new Random();
			for (int i = 1; i < 1000; i++) {
				Address add = new Address(
						rnd.nextInt(1, 1000) + "",
						"Quang Trung",
						"HCM",
						rnd.nextInt(70000, 80000) + "",
						CountryCode.VN);
				addressRepository.save(add);
				Candidate can = new Candidate(
						"Name #" + i,
						LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
						add,
						rnd.nextLong(1111111111L, 9999999999L) + "",
						"email_" + i + "@gmail.com");
				candidateRepository.save(can);
				System.out.println("Added: " + can);
			}
		};
	}
}
