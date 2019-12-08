package com.logzio.transform.processor.core;

public interface ProcessorFactory {
	Processor create(String processorName);
}
