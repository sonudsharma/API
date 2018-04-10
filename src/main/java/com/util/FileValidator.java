package com.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.models.FileInfo;

//@Component
public class FileValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return FileInfo.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		FileInfo file = (FileInfo) obj;

		/*
		 * if (file.getFileName() != null) {
		 * 
		 * if (file.getFile().getSize() == 0) { errors.rejectValue("file",
		 * "missing.file"); } }
		 */
	}
}