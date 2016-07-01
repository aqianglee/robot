package com.foo.step;

import com.foo.componet.Componet;
import com.foo.componet.ComponetSummary;
import com.foo.robot.Config;

public class DecodeCommandStep implements Step {

	public boolean doStep(String commond, ComponetSummary componetSummary) {
		String[] split = commond.split(" ");
		Componet componet = Config.getComponets().get(split[0]);
		if (componet != null) {
			componetSummary.setComponet(componet);
			return true;
		}
		return false;
	}

}
