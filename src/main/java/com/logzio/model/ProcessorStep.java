package com.logzio.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ProcessorStep {

	private String processor;

	private Map<String, String> configuration;
}