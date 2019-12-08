package com.logzio.transform.processor.impl;

import com.logzio.transform.processor.core.Processor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProcessorFactoryImplTest {


	private ProcessorFactoryImpl processorFactory = new ProcessorFactoryImpl();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testCreateForAddField() {
		final Processor processor = processorFactory.create("AddField");
		assertThat(processor.getClass(), equalTo(AddFieldProcessor.class));
	}

	@Test
	public void testCreateForRemoveField() {
		final Processor processor = processorFactory.create("RemoveField");
		assertThat(processor.getClass(), equalTo(RemoveFieldProcessor.class));
	}

	@Test
	public void testCreateForNumberOfFields() {
		final Processor processor = processorFactory.create("CountNumOfFields");
		assertThat(processor.getClass(), equalTo(CountNumOfFieldsProcessor.class));
	}

	@Test
	public void testCreateForUnknownProcessorName() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("No processor for processorName: unknownProcessor");
		processorFactory.create("unknownProcessor");
	}
}