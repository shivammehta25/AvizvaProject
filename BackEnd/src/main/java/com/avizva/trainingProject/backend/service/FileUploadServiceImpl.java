package com.avizva.trainingProject.backend.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.avizva.trainingProject.backend.model.Product;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	private static final Logger LOGGER = LogManager.getLogger(FileUploadServiceImpl.class);

	private final String fileDir = "/tmp/Gamazon/productImages/";

	public boolean saveFile(Path path, byte[] file) {
		try {
			Files.write(path, file);
		} catch (IOException e) {
			LOGGER.error(e);
			return false;
		}
		return true;
	}

	
	public boolean uploadProductImage(Product product, MultipartFile file) {
		
		if (file.isEmpty()){
			LOGGER.info("Empty image file");
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
			LOGGER.error(e);
		}
		return false;
	}

}