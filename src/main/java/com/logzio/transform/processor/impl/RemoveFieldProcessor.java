package com.logzio.transform.processor.impl;

import com.logzio.transform.processor.core.Processor;

import java.util.Map;

import static com.logzio.transform.processor.impl.ProcessorConstants.FIELD_NAME;

public class RemoveFieldProcessor implements Processor {


	private Map<String, String> configuration;

	@Override
	public void initialize(Map<String, String> configuration) {
		this.configuration = configuration;
	}

	@Override
	public void process(Map<String, Object> jsonDocument) {
		jsonDocument.remove(configuration.get(FIELD_NAME));
	}
}
