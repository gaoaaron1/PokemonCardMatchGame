package handlers;

import java.io.File;

import drivers.Main;
import gui.CreditScene;
import gui.GameSelect;
import gui.LaunchCPU;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CreditHandler implements EventHandler<ActionEvent>{
	Main menu;
	
	public CreditHandler(Main menu) {
		this.menu = menu;
	}

	@Override
	public void handle(ActionEvent event) {
		//LaunchCPU.boardSetUp = false;
		CreditScene scene = new CreditScene(menu);
		scene.setup();
		
	}

}
