package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	private String username;
	private String password;
	private String email;
	private String city;
	
}
