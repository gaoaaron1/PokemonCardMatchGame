package handlers;

import java.io.File;

import drivers.Main;
import gui.CPUSelect;
import gui.GameSelect;
import gui.LaunchCPU;
import gui.LaunchPVP;
import gui.PVPSelect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class buttonHandlers implements EventHandler<ActionEvent> {
	Main menu;
	
	public buttonHandlers(Main menu) {
		this.menu = menu;
	}
	
	@Override
	public void handle(ActionEvent event) {
	}
	
//-------------------------------------------------PVP Handles
	public static class StartPVPHandler implements EventHandler<ActionEvent>{
		File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav"); // 
		Main menu;
		
		public StartPVPHandler(Main menu) {
			this.menu = menu;
		}

		@Override
		public void handle(ActionEvent event) {
			soundTest.PlaySound(jump); // plays the sound jump which takes the resource from file. 
			PVPSelect scene = new PVPSelect(menu);
			scene.setup();
			
		}

	}

	//-------------------------------------------------- Easy CPU Handle
	public static class EasyPVPHandler implements EventHandler<ActionEvent>{
		File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav");
		Main menu;
		
		public EasyPVPHandler(Main menu) {
			this.menu = menu;
		}

		@Override
		public void handle(ActionEvent event) {
			soundTest.PlaySound(jump);
			LaunchPVP scene = new LaunchPVP(menu);
			LaunchPVP.difficulty = 4;
			scene.setup();
			
		}

	}
	
	
	//-------------------------------------------------- Hard PVP Handle
	public static class HardPVPHandler implements EventHandler<ActionEvent>{
		File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav");
		Main menu;
		
		public HardPVPHandler(Main menu) {
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

	

//------------------------------------------------- EASY CPU Handles
	public static class EasyCPUHandler implements EventHandler<ActionEvent>{
		File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav");
		Main menu;
		
		public EasyCPUHandler(Main menu) {
			this.menu = menu;
		}

		@Override
		public void handle(ActionEvent event) {
			soundTest.PlaySound(jump); // play sound 
			LaunchCPU scene = new LaunchCPU(menu);
			LaunchCPU.difficulty = 4;
			scene.setup();
			
		}

	}
	
//-------------------------------------------------- Hard CPU Handle
	public static class HardCPUHandler implements EventHandler<ActionEvent>{
		File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav");
		Main menu;
		
		public HardCPUHandler(Main menu) {
			this.menu = menu;
		}

		@Override
		public void handle(ActionEvent event) {
			soundTest.PlaySound(jump);
			LaunchCPU scene = new LaunchCPU(menu);
			LaunchCPU.difficulty = 6;
			scene.setup();
			
		}

	}
	
	
	//-------------------------------------------------GAME Handles	
	public static class StartCPUHandler implements EventHandler<ActionEvent>{
		File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav");
		Main menu;
		
		public StartCPUHandler(Main menu) {
			this.menu = menu;
		}

		@Override
		public void handle(ActionEvent event) {
			soundTest.PlaySound(jump);
			CPUSelect scene = new CPUSelect(menu);
			scene.setup();
			
		}

	}
	
	//-------------------------------------------------- Start Handle
	public static class StartHandler implements EventHandler<ActionEvent>{
		File jump = new File("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\jump.wav.wav");
		Main menu;
		
		public StartHandler(Main menu) {
			this.menu = menu;
		}

		@Override
		public void handle(ActionEvent event) {
			soundTest.PlaySound(jump);
			GameSelect scene = new GameSelect(menu);
			scene.setup();
			
		}

	}
	

	
}
