package com.logzio.transform.processor.impl;

import com.logzio.transform.processor.core.Processor;

import java.util.Map;

public class RemoveFieldProcessor implements Processor {
	private Map<String, String> configuration;

	@Override
	public void initialize(Map<String, String> configuration) {
		this.configuration = configuration;
	}

	@Override
	public void process(Map<String, Object> jsonDocument) {
		jsonDocument.remove(configuration.get("fieldName"));
	}
}
