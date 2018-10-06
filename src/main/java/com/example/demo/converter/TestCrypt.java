package com.example.demo.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		System.out.println(bcpe.encode("@p0ll0n1@"));
	}

}
