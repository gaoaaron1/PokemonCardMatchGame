package handlers;

import java.io.File;

import drivers.Main;
import gui.GameSelect;
import gui.LaunchCPU;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartHandler implements EventHandler<ActionEvent>{
	Main menu;
	File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav");
	
	public StartHandler(Main menu) {
		this.menu = menu;
	}

	@Override
	public void handle(ActionEvent event) {
		soundTest.PlaySound(jump);
		//LaunchCPU.boardSetUp = false;
		GameSelect scene = new GameSelect(menu);
		scene.setup();
		
	}

}
