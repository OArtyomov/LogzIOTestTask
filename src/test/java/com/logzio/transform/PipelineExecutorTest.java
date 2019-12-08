package com.logzio.transform;

import com.logzio.model.PipelineDescriptor;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PipelineExecutorTest {

	@Test
	public void transform() {
		ContentTransformer contentTransformer = new ContentTransformer();
		File pipelineFile = new File("/home/osboxes/projects/LogzIO/LogzIOTestTask/src/test/resources/pipelineFile.json");
		final PipelineDescriptor transform = contentTransformer.transform(pipelineFile);


		File sourceFile = new File("/home/osboxes/projects/LogzIO/LogzIOTestTask/src/test/resources/sourceFile.json");
		final HashMap<String, Object> sourceData = contentTransformer.readFile(sourceFile);
		PipelineExecutor executor = new PipelineExecutor();
		executor.transform(transform, sourceData);

		assertThat(sourceData.get("userSurname"), equalTo("Preston"));
		assertThat(sourceData.get("numOfFields"), equalTo(3));
		assertThat(sourceData.get("accountName"), equalTo("Facebook"));
		assertThat(sourceData.size(), equalTo(3));
	}
}