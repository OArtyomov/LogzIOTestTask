package com.logzio.transform.processor.impl;

import com.logzio.transform.processor.core.Processor;

import java.util.Map;

public class NumOfFieldsProcessor implements Processor {
	private Map<String, String> configuration;

	@Override
	public void initialize(Map<String, String> configuration) {
		this.configuration = configuration;
	}

	@Override
	public void process(Map<String, Object> jsonDocument) {
		jsonDocument.put(configuration.get("targetFieldName"), jsonDocument.size());
	}
}
