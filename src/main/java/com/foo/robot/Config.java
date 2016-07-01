package com.foo.robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foo.componet.Componet;
import com.foo.step.Step;

public class Config {
	private static final Map<String, Componet> componets = new HashMap<String, Componet>();
	private static final List<Step> steps = new ArrayList<Step>();

	public static Map<String, Componet> getComponets() {
		return componets;
	}

	public static List<Step> getSteps() {
		return steps;
	}

}
