package handlers;

import drivers.Main;
import gui.CPUSelect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartCPUHandler implements EventHandler<ActionEvent>{
	Main menu;
	
	public StartCPUHandler(Main menu) {
		this.menu = menu;
	}

	@Override
	public void handle(ActionEvent event) {
		CPUSelect scene = new CPUSelect(menu);
		scene.setup();
		
	}

}
