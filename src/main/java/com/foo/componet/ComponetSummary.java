package com.foo.componet;

import java.util.HashMap;
import java.util.Map;

public class ComponetSummary {

	private Componet componet;
	private Map<String, String> args = new HashMap<String, String>();

	public Componet getComponet() {
		return componet;
	}

	public void setComponet(Componet componet) {
		this.componet = componet;
	}

	public Map<String, String> getArgs() {
		return args;
	}

	public void setArgs(Map<String, String> args) {
		this.args = args;
	}

}
