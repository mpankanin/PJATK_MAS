package com.mas.manageIT;

import com.mas.manageIT.model.Employer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManageItApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ManageItApplication.class, args);
		Employer employer = new Employer("Jarek", "Jareczek", "jarek@op.pl", "Prezes");
		System.out.println(employer.toString());
	}

}
