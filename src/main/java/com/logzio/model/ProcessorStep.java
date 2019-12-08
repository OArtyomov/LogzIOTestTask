package com.logzio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessorStep {

	private String processor;

	private Configuration configuration;
}