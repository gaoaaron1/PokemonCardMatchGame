package handlers;

import java.io.File;

import drivers.Main;
import gui.GameSelect;
import gui.LaunchCPU;
import gui.LaunchPVP;
import gui.firstScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BackHandler implements EventHandler<ActionEvent>{
	Main menu;
	
	public BackHandler(Main menu) {
		this.menu = menu;
	}

	@Override
	public void handle(ActionEvent event) {
		//LaunchCPU.boardSetUp = false;
		firstScene scene = new firstScene(menu);
		LaunchPVP.boardSetUp = false;
		LaunchPVP.reloadGame = true; 
		scene.setup();
		
	}

}
