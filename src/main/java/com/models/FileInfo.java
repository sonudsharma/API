package com.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class FileInfo implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private static final long serialVersionUID = 1L;

	// MultipartFile file;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_ID")
	private Integer id;

	@Column(name = "DOC_FILE_NAME")
	private String fileName;

	@Column(name = "DOC_FILE_SIZE")
	private long size;

	@Column(name = "DOC_FILE_PATH")
	private String Path;

	@Column(name = "DOC_FILE_CATEGORY")
	private String category;

	@Column(name = "DOC_USER_ID")
	private Integer userId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/*
	 * public MultipartFile getFile() { return file; }
	 * 
	 * public void setFile(MultipartFile file) { this.file = file; }
	 */
}