package com.foo.step;

import com.foo.componet.ComponetSummary;

public class PreparaArguementsStep implements Step {

	public boolean doStep(String commond, ComponetSummary componetSummary) {
		componetSummary.getComponet().prepareArguements(componetSummary.getArgs());
		return true;
	}

}
