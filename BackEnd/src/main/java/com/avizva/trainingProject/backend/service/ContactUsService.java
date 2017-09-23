package com.avizva.trainingProject.backend.service;

import com.avizva.trainingProject.backend.model.ContactUs;
/**
 * 
 * @author Akshay.Chourasia
 * This Interface is used to call the contact us section of the application calls the contactUsDAO
 */
public interface ContactUsService {
	public boolean contactUs(ContactUs contactUs);
}
