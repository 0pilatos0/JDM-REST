package com.avd.jdmrest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer {
	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	private String username;

	@Getter
	@Setter
	private LocalDate dateOfBirth;

	@Getter
	@Setter
	private String address;
	@Getter
	@Setter
	private String phoneNumber;

	public Customer() {
	}

	public Customer(String username, LocalDate dateOfBirth, String address, String phoneNumber) {
		this.username = username;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
}

