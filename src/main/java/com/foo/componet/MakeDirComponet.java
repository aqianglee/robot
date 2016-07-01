package com.foo.componet;

import java.io.File;
import java.util.Map;

public class MakeDirComponet implements Componet {

	private String name;

	public void execute() {
		File file = new File(name);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
	}

	public void prepareArguements(Map<String, String> args) {
		name = args.get("-n");
	}

	public void showHelp() {

	}

}
