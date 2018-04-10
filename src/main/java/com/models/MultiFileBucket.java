package com.models;

import java.util.ArrayList;
import java.util.List;

public class MultiFileBucket {

	List<FileInfo> files = new ArrayList<FileInfo>();

	public MultiFileBucket() {
		files.add(new FileInfo());
		files.add(new FileInfo());
		files.add(new FileInfo());
	}

	public List<FileInfo> getFiles() {
		return files;
	}

	public void setFiles(List<FileInfo> files) {
		this.files = files;
	}
}