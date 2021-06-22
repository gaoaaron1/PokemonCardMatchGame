package gui;

import drivers.Main;
import handlers.buttonHandlers.StartCPUHandler;
import handlers.buttonHandlers.StartPVPHandler;
import javafx.application.Platform;
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

public class CreditScene extends firstScene {
	public static final int buttonHeight = 1;
	public static final int buttonWidth = 1;
	StackPane gamePane = new StackPane();
	
	public CreditScene(Main menu) {
		super(menu);
	}

	@Override
	public void setup() {
		
		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EndCredits.png");
		
//----------------------------------------------------------Creating Buttons:	
		Button back = new Button();							//Back button to main menu

//----------------------------------------------------------Adding Button Images:
		Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");				//Adding the image for the BACK button
		ImageView backIV = new ImageView(backImg);
		
//----------------------------------------------------------BACK BUTTON:
		back.setGraphic(backIV);			//Adding the exit image onto the BACK button
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
		
//----------------------------------------------------------Sizing the Buttons:	
		backIV.setFitHeight(50);
		backIV.setFitWidth(100);

//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
		BGImg.setFitHeight(1000);
		BGImg.setFitWidth(1950);
		
		gamePane.getChildren().add(BGImg);
		VBox menuBox = new VBox();									//Adding the buttons to the VBox
		menuBox.getChildren().add(back);
		
		
		menuBox.setAlignment(Pos.BOTTOM_CENTER);					//Aligning the menu start & quit buttons to the center
		
				//Adding HBox to the pane
		
		gamePane.getChildren().add(menuBox);
		gamePane.setAlignment(Pos.CENTER);
		
		/*
		BtnExitHandler exitHandle = new BtnExitHandler();	//Attaching the event handlers for QUIT
		exit.setOnAction(exitHandle);
		*/

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
