package com.logzio.transform.processor.impl;

import com.logzio.transform.processor.core.Processor;
import com.logzio.transform.processor.core.ProcessorFactory;

public class ProcessorFactoryImpl implements ProcessorFactory {
	@Override
	public Processor create(String processorName) {

		switch (processorName) {
			case "AddField":
				return new AddFieldProcessor();
			case "RemoveField":
				return new RemoveFieldProcessor();
			case "CountNumOfFields":
				return new CountOfFieldsProcessor();
			default:
				throw new RuntimeException("No processor for processorName: " + processorName);
		}

	}
}
