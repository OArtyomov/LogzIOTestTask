package com.logzio.transform.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PipelineDescriptor {

	private List<ProcessorStep> steps;
}
