package com.avizva.trainingProject.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * @author Akshay.Chourasia
 * This module is helpful in resetting user password.
 */

@Entity
@Component
public class ForgotPass {
	
	@Id
	private String email;
	
	private String otp;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "ForgotPass [email=" + email + ", otp=" + otp + "]";
	}
	
	
	
}
