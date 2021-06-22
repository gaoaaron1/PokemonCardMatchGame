package drivers;

import gui.firstScene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

//The MAIN class for executing GUI for the game

public class Main extends Application { // it extends to a class. 
	Stage stage; 
	
	public void setScene(Scene scene) {
		
		stage.setScene(scene);				//Setting up the scene for the stage
		stage.setX(-10);
		stage.setY(0);
		stage.setResizable(true); 			//Making it re-sizable
	}
	
	
	
	public void start(Stage stage) {
		this.stage = stage; // stage can read the parameter inside start method which is stage. 
		stage.setTitle("POKEMON CARD MATCH MEMORY GAME"); 		// This sets the title of the top window. 
		// This sets the icon of the pokemon game. 
		stage.getIcons().add(new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\pokemonIcon.png"));
		
		stage.setResizable(false); // It is setting a resizable window when you load the game. 
		stage.show();
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);		//Removing the fullscreen message;
		stage.setFullScreen(true);						//Fullscreen the game window
		
		firstScene scene = new firstScene(this); // This will create a new scene for the firstScene class. 
		scene.setup(); // This will set up the first scene from the firstScene class.
	}
	
	public static void main(String[] args) {			//Launching the Application
		launch(args);
	}
}
