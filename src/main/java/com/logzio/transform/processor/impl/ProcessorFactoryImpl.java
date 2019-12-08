package com.logzio.transform.processor.impl;

import com.logzio.transform.processor.core.Processor;
import com.logzio.transform.processor.core.ProcessorFactory;

public class ProcessorFactoryImpl implements ProcessorFactory {
	@Override
	public Processor create(String processorName) {
		if (processorName.equals("AddField")) {
			return new AddFieldProcessor();
		}
		if (processorName.equals("RemoveField")) {
			return new RemoveFieldProcessor();
		}
		if (processorName.equals("CountNumOfFields")) {
			return new NumOfFieldsProcessor();
		}
		throw new RuntimeException("No processor for processorName: " + processorName);
	}
}
