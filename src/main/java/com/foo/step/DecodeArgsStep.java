package com.foo.step;

import com.foo.componet.ComponetSummary;

public class DecodeArgsStep implements Step {

	public boolean doStep(String commond, ComponetSummary componetSummary) {
		String[] split = commond.split(" ");
		if (split.length % 2 == 1) {
			for (int i = 1; i < split.length; i += 2) {
				componetSummary.getArgs().put(split[i], split[i + 1]);
			}
			return true;
		}
		return false;
	}

}
