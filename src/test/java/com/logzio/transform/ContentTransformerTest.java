package com.logzio.transform;

import com.logzio.model.PipelineDescriptor;
import com.logzio.service.ContentTransformer;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


public class ContentTransformerTest {

	@Test
	public void testTransform() {
		ContentTransformer contentTransformer = new ContentTransformer();
		File sourceFile = new File("/home/osboxes/projects/LogzIO/LogzIOTestTask/src/test/resources/pipelineFile.json");
		final PipelineDescriptor transform = contentTransformer.transform(sourceFile);
		assertThat(transform, notNullValue());
	}
}