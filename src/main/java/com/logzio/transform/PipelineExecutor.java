package com.logzio.transform;

import com.logzio.model.PipelineDescriptor;
import com.logzio.model.ProcessorStep;
import com.logzio.transform.processor.core.Processor;
import com.logzio.transform.processor.core.ProcessorFactory;
import com.logzio.transform.processor.impl.ProcessorFactoryImpl;

import java.util.Map;

public class PipelineExecutor {

	private static final ProcessorFactory processorFactor = new ProcessorFactoryImpl();


	public void transform(PipelineDescriptor pipelineDescriptor,
						  Map<String, Object> jsonDocument) {
		if (pipelineDescriptor.getSteps() != null) {
			pipelineDescriptor.getSteps().stream().forEach(step -> processStep(step, jsonDocument));
		}
	}

	private void processStep(ProcessorStep step, Map<String, Object> jsonDocument) {
		final Processor processor = processorFactor.create(step.getProcessor());
		processor.initialize(step.getConfiguration());
		processor.process(jsonDocument);
	}

}
