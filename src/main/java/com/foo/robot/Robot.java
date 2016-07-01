package com.foo.robot;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.foo.componet.Componet;
import com.foo.componet.ComponetSummary;
import com.foo.step.DecodeArgsStep;
import com.foo.step.DecodeCommandStep;
import com.foo.step.PreparaArguementsStep;
import com.foo.step.Step;

public class Robot {
	private Scanner scanner = new Scanner(System.in);

	public Robot() {
		try {
			initComponet();
			initSteps();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		String commond = null;
		while (!(commond = scanner.nextLine()).equals("exit")) {
			ComponetSummary summary = new ComponetSummary();
			for (Step step : Config.getSteps()) {
				if (!step.doStep(commond, summary)) {
					break;
				}
			}
			summary.getComponet().execute();
		}
	}

	@SuppressWarnings("unchecked")
	private void initComponet() throws Exception {
		File inputXml = new File("src/main/resources/componet.xml");
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputXml);
			Element elements = document.getRootElement();
			for (Iterator<Element> i = elements.elementIterator(); i.hasNext();) {
				Element element = (Element) i.next();
				String key = element.attributeValue("id");
				String className = element.attributeValue("class");
				Componet componet = (Componet) Class.forName(className).newInstance();
				Config.getComponets().put(key, componet);
			}
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private void initSteps() {
		Config.getSteps().add(new DecodeCommandStep());
		Config.getSteps().add(new DecodeArgsStep());
		Config.getSteps().add(new PreparaArguementsStep());
	}
}
