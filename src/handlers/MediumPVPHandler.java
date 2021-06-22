package handlers;

import java.io.File;

import drivers.Main;
import gui.LaunchPVP;
import gui.PVPSelect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MediumPVPHandler implements EventHandler<ActionEvent>{
	Main menu;
	File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav");
	
	public MediumPVPHandler(Main menu) {
		this.menu = menu;
	}

	@Override
	public void handle(ActionEvent event) {
		soundTest.PlaySound(jump);
		LaunchPVP scene = new LaunchPVP(menu);
		LaunchPVP.difficulty = 6;
		scene.setup();
		
	}

}
