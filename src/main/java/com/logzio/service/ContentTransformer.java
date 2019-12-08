package com.logzio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logzio.transform.model.PipelineDescriptor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ContentTransformer {

	private static final ObjectMapper mapper = new ObjectMapper();

	public PipelineDescriptor transform(File sourceFile) {
		try {
			return mapper.readValue(sourceFile, PipelineDescriptor.class);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public HashMap<String, Object> readFile(File sourceFile){
		try {
			return mapper.readValue(sourceFile, HashMap.class);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
}