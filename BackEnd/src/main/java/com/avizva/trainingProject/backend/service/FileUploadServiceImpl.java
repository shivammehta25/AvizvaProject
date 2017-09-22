package com.avizva.trainingProject.backend.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.avizva.trainingProject.backend.model.Product;

@Transactional
@Service
public class FileUploadServiceImpl implements FileUploadService {

	/**
	 * Initialized the LOGGER 
	 */
	private static final Logger LOGGER = LogManager.getLogger(FileUploadServiceImpl.class);

	/**
	 * This variable is used to Define the path of stored files
	 */
	private final String fileDir = "/Users/Shared/";

	/**
	 * This method takes file path and the byte stream as a variable
	 *  and returns boolean based on false and true 
	 */
	public boolean saveFile(Path path, byte[] file) {
		LOGGER.info("<-- FileUploadService.savePath Called--->");
		try {
			Files.write(path, file);
			LOGGER.info("<-- Files.write() successful-->");
		} catch (IOException e) {
			LOGGER.error("Exception Occured, error excecuting saveFile");
			return false;
		}
		return true;
	}

	
	/**
	 *  This method uploads the product image and saves it from the multipart file
	 */
	public boolean uploadProductImage(Product product, MultipartFile file) {
		LOGGER.info("<-- FileUploadService.uploadProductImage Called--->");
		if (file.isEmpty()){
			LOGGER.info("Empty image file passed");
			return false;
		}
		String fileName = "Product"+product.getProductName() ;
		LOGGER.info(fileName);
		Path path = FileSystems.getDefault()
				.getPath(fileDir + fileName);
		try {
			if (saveFile(path, file.getBytes())) {
				LOGGER.info("File saved successfully");
				return true;
			}
		} catch (IOException e) {
			LOGGER.error("Exception Occured, error excecuting uploadProductImage");
		}
		return false;
	}

}