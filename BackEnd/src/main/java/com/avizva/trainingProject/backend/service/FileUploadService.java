package com.avizva.trainingProject.backend.service;

import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import com.avizva.trainingProject.backend.model.Product;

public interface FileUploadService {
	
	public boolean saveFile(Path path, byte[] file);
	
	public boolean uploadProductImage(Product product, MultipartFile file);
}
