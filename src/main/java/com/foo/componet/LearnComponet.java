package com.foo.componet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class LearnComponet implements Componet {

	private String question;
	private String answer;

	public void execute() {
		try {
			Properties properties = new Properties();
			File file = new File("src/main/resources/ques&ans.properties");
			properties.load(new FileInputStream(file));
			properties.setProperty(question, answer);
			properties.store(new FileOutputStream(file), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prepareArguements(Map<String, String> args) {
		String q = args.get("-q");
		String a = args.get("-a");
		if (q == null || a == null) {
			throw new RuntimeException();
		}
		question = q;
		answer = a;
	}

}
