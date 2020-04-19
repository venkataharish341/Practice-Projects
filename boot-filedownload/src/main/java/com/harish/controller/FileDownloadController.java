package com.harish.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("files")
public class FileDownloadController {

	private static final String EXTERNAL_FILE_PATH = "C:/Users/htavva/Downloads/";

	@GetMapping("/download/{fileName:.+}")
	public ResponseEntity<Resource> downloadPDFResource(@PathVariable("fileName") String fileName) throws IOException {

		File file = new File(EXTERNAL_FILE_PATH + fileName);
		if (file.exists()) {

			Resource inputStream = new InputStreamResource(new FileInputStream(file));

			return ResponseEntity
					.ok()
					.header("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""))
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.contentLength((int)file.length())
					.body(inputStream);	

		}
		return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path path = Paths.get( EXTERNAL_FILE_PATH + fileName); // Location
		try {
			// Copy the uploaded file to some location.
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/files/download/")
				.path(fileName)
				.toUriString();
		return ResponseEntity.ok(fileDownloadUri);
	}
	
}
