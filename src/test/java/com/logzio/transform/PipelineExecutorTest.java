package com.logzio.transform;

import com.logzio.model.PipelineDescriptor;
import com.logzio.service.ContentTransformer;
import com.logzio.service.PipelineExecutor;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PipelineExecutorTest {

	@Test
	public void testTransform() {
		ContentTransformer contentTransformer = new ContentTransformer();
		File pipelineFile = new File("/home/osboxes/projects/LogzIO/LogzIOTestTask/src/test/resources/pipelineFile.json");
		final PipelineDescriptor transform = contentTransformer.transform(pipelineFile);


		File sourceFile = new File("/home/osboxes/projects/LogzIO/LogzIOTestTask/src/test/resources/sourceFile.json");
		final HashMap<String, Object> sourceData = contentTransformer.readFile(sourceFile);
		PipelineExecutor executor = new PipelineExecutor();
		executor.transform(transform, sourceData);

		assertThat(sourceData.get("userSurname"), equalTo("Preston"));
		assertThat(sourceData.get("numOfFields"), equalTo(4));
		assertThat(sourceData.get("accountName"), equalTo("Facebook"));
		assertThat(sourceData.get("age"), equalTo(25));
		assertThat(sourceData.size(), equalTo(4));
	}
}