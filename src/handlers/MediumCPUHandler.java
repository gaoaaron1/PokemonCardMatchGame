package handlers;

import drivers.Main;
import gui.LaunchCPU;
import gui.PVPSelect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MediumCPUHandler implements EventHandler<ActionEvent>{
	Main menu;
	
	public MediumCPUHandler(Main menu) {
		this.menu = menu;
	}

	@Override
	public void handle(ActionEvent event) {
		LaunchCPU scene = new LaunchCPU(menu);
		LaunchCPU.difficulty = 6;
		scene.setup();
		
	}

}
