package gui;

import java.io.File;

import drivers.Main;
import handlers.soundTest;
import handlers.buttonHandlers.StartCPUHandler;
import handlers.buttonHandlers.StartPVPHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GameSelect extends firstScene {
	// instance variables 
	public static final int buttonHeight = 50;
	public static final int buttonWidth = 100;
	StackPane gamePane = new StackPane();
	
	public GameSelect(Main menu) {
		super(menu);
	}

	@Override
	public void setup() {
		// it finds the file which contains the gif file. 
		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\pokegirlthrow.gif");
		
//----------------------------------------------------------Creating Buttons:	
		Button multiplayer = new Button();					//Player vs. Player
		Button computer = new Button();						//Player vs. Computer
		Button back = new Button();							//Back

//----------------------------------------------------------Adding Button Images:
		Image multiplayerImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\MULTIPLAYER.png");		//Adding the image for the MULTIPLAYER button
		Image computerImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\COMPUTER.png");		//Adding the image for the COMPUTER button
		Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");		//Adding the image for the COMPUTER button
//----------------------------------------------------------MULTIPLAYER BUTTON:
		multiplayer.setGraphic
		(new ImageView(multiplayerImg));					//Adding the start image onto the "MULTIPLAYER" button
		multiplayer.setBackground(null);					//Removing the background of the button
		multiplayer.setOnMouseEntered(a->{					//Adding the drop-shadow on the button when mouse hovers on the button
			multiplayer.setEffect(new DropShadow(50, Color.CRIMSON));
			multiplayer.setScaleX(1.1);
			multiplayer.setScaleY(1.1);
		});
		multiplayer.setOnMouseExited(a-> {					//Removing the drop-shadow on the button when mouse does not on the button	
			multiplayer.setEffect(null);
			multiplayer.setScaleX(1.0);
			multiplayer.setScaleY(1.0);
		});
		
//----------------------------------------------------------COMPUTER BUTTON:
		computer.setGraphic(new ImageView(computerImg));	//Adding the start image onto the "COMPUTER" button
		computer.setBackground(null);						//Removing the background of the button
		computer.setOnMouseEntered(a->{						//Adding the drop-shadow on the button when mouse hovers on the button
			computer.setEffect(new DropShadow(50, Color.CRIMSON));
			computer.setScaleX(1.1);
			computer.setScaleY(1.1);
		});
		computer.setOnMouseExited(a-> {						//Removing the drop-shadow on the button when mouse does not on the button	
			computer.setEffect(null);
			computer.setScaleX(1.0);
			computer.setScaleY(1.0);				
		});

		//----------------------------------------------------------BACK BUTTON:
		back.setGraphic(new ImageView(backImg));			//Adding the exit image onto the BACK button
		back.setBackground(null);							//Removing the background of the button
		back.setOnMouseEntered(a->{							//Adding the drop-shadow on the button when mouse hovers on the button
			back.setEffect(new DropShadow(50, Color.CRIMSON));
			back.setScaleX(1.1);
			back.setScaleY(1.1);
		});
		back.setOnMouseExited(a-> {							//Removing the drop-shadow on the button when mouse does not on the button	
			back.setEffect(null);
			back.setScaleX(1.0);
			back.setScaleY(1.0);	
		});	
//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
		BGImg.setFitHeight(1000);
		BGImg.setFitWidth(2000);
		
		gamePane.getChildren().add(BGImg);
		VBox menuBox = new VBox();							//Adding the buttons to the VBox
		menuBox.getChildren().add(multiplayer);
		menuBox.getChildren().add(computer);
		menuBox.getChildren().add(back);
		
		menuBox.setAlignment(Pos.CENTER);					//Aligning the menu start & quit buttons to the center
		
				//Adding HBox to the pane
		
		gamePane.getChildren().add(menuBox);
		gamePane.setAlignment(Pos.CENTER);
		
		/*
		BtnExitHandler exitHandle = new BtnExitHandler();	//Attaching the event handlers for QUIT
		exit.setOnAction(exitHandle);
		*/


//----------------------------------------------------------Attaching the event handlers for MULTIPLAYER
				StartPVPHandler PVPHandle = new StartPVPHandler(getMenu());
				firstScene.playMusic = true;
				multiplayer.setOnAction(PVPHandle);

//----------------------------------------------------------Attaching the event handlers for COMPUTER
				StartCPUHandler CPUHandle = new StartCPUHandler(getMenu());
				firstScene.playMusic = true;
				computer.setOnAction(CPUHandle);
				
	//----------------------------------------------------------Attaching the event handlers for GOING BACK TO MAIN MENU
			back.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event) {
						firstScene scene = new firstScene(getMenu());
						firstScene.playMusic = true;
						scene.setup();
					}
				});

//----------------------------------------------------------Setting up the scene and showing display
		setScene(new Scene( gamePane, 2000, 1000));
		display();
	}
	

}
