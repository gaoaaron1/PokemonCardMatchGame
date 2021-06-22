package handlers;

import java.io.File;

import drivers.Main;
import gui.PVPSelect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartPVPHandler implements EventHandler<ActionEvent>{
	Main menu;
	File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav");
	
	
	public StartPVPHandler(Main menu) {
		this.menu = menu;
	}

	@Override
	public void handle(ActionEvent event) {
		soundTest.PlaySound(jump);
		PVPSelect scene = new PVPSelect(menu);
		scene.setup();
		
	}

}
