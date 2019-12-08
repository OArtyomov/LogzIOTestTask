package com.logzio.transform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logzio.model.PipelineDescriptor;

import java.io.File;
import java.io.IOException;

public class ContentTransformer {

	private static final ObjectMapper mapper = new ObjectMapper();

	public PipelineDescriptor transform(File sourceFile) {
		try {
			return mapper.readValue(sourceFile, PipelineDescriptor.class);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
}