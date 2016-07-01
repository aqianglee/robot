package com.foo.componet;

import java.util.Map;

public class ChatComponet implements Componet {
	private String content;

	public void execute() {
		System.out.println(content);
	}

	public void prepareArguements(Map<String, String> args) {
		content = args.get("-c");
	}

	public void showHelp() {
		// TODO Auto-generated method stub

	}

}
