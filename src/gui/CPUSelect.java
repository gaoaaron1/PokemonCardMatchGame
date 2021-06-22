package gui;

import java.io.File;

import drivers.Main;

import handlers.buttonHandlers;
import handlers.buttonHandlers.EasyCPUHandler;
import handlers.buttonHandlers.HardCPUHandler;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

public class CPUSelect extends GameSelect {
	StackPane gamePane = new StackPane();
	MediaPlayer mediaplayer;
	
//----------------------------------------------------------Creating Buttons:
	public Button easy = new Button();						//Adding a EASY button
	public Button hard = new Button();						//Adding a HARD button
	public Button back = new Button();						//Adding a BACK button
	
	public CPUSelect(Main menu) {
		super(menu);
	}

	@Override
	public void setup() {
		
		//Media videoFile = new Media("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\behindgame.gif");

		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\behindgame2.gif");

		/*The video playing behind the CPU Select buttons was taken from the YouTube Channel Level UP.
		 *NO infringement of any kind is intended from this non-profit, personal use animation***
		 * https://www.youtube.com/watch?v=OBWnZLsIebU - Original Pokemon Intro (Sprite Edition!) BY Level UP
		 * Accessed on August 12th, 2019
		 * 
		 */
		//mediaplayer = new MediaPlayer(videoFile);
//		MediaView mediaview = new MediaView(mediaplayer);
//		mediaplayer.play();
//		mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);

//----------------------------------------------------------Adding Button Images:
		Image easyImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EASY.png");				//Adding the image for the EASY button
		Image hardImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\HARD.png");				//Adding the image for the HARD button
		Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");				//Adding the image for the BACK button
		
		BGImg.setFitWidth(2000);
		BGImg.setFitHeight(1000);
		
//----------------------------------------------------------EASY BUTTON:
		easy.setGraphic(new ImageView(easyImg));			//Adding the start image onto the EASY button
		easy.setBackground(null);							//Removing the background of the button
		easy.setOnMouseEntered(a->{							//Adding the drop-shadow on the button when mouse hovers on the button
			easy.setEffect(new DropShadow(50, Color.CRIMSON));
			easy.setScaleX(1.1);
			easy.setScaleY(1.1);
		});
		easy.setOnMouseExited(a-> {							//Removing the drop-shadow on the button when mouse does not on the button	
			easy.setEffect(null);
			easy.setScaleX(1.0);
			easy.setScaleY(1.0);
			
		});
				

//----------------------------------------------------------HARD BUTTON:
		hard.setGraphic(new ImageView(hardImg));			//Adding the exit image onto the HARD button
		hard.setBackground(null);							//Removing the background of the button
		hard.setOnMouseEntered(a->{							//Adding the drop-shadow on the button when mouse hovers on the button
			hard.setEffect(new DropShadow(50, Color.CRIMSON));
			hard.setScaleX(1.1);
			hard.setScaleY(1.1);
		});
		hard.setOnMouseExited(a-> {							//Removing the drop-shadow on the button when mouse does not on the button	
			hard.setEffect(null);
			hard.setScaleX(1.0);
			hard.setScaleY(1.0);
			
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
//		mediaview.setFitHeight(900);
//		mediaview.setFitHeight(900);
//		
//		gamePane.getChildren().add(mediaview);
		
		VBox menuBox = new VBox();							//Adding the buttons to the VBox
		menuBox.getChildren().add(easy);
		menuBox.getChildren().add(hard);
		menuBox.getChildren().add(back);
			
		menuBox.setAlignment(Pos.CENTER);					//Aligning the menu start & quit buttons to the center
		
				//Adding HBox to the pane
		gamePane.getChildren().add(BGImg);
		gamePane.getChildren().add(menuBox);				//Adding the menuBox with the; START, CREDITS, EXIT to the gamepane
		gamePane.setAlignment(Pos.CENTER);					//Aligning to the center
		
		/*
		BtnExitHandler exitHandle = new BtnExitHandler();	//Attaching the event handlers for QUIT
		exit.setOnAction(exitHandle);
		*/
	
//----------------------------------------------------------Attaching the event handlers for EASY
		EasyCPUHandler easyHandle = new EasyCPUHandler(getMenu());//Attaching the event handlers for START
		easy.setOnAction(easyHandle);
		
//----------------------------------------------------------Attaching the event handlers for EASY
		HardCPUHandler hardHandle = new HardCPUHandler(getMenu());//Attaching the event handlers for START
		hard.setOnAction(hardHandle);

//----------------------------------------------------------Attaching the event handlers for GOING BACK TO MAIN MENU
		back.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) {
				GameSelect scene = new GameSelect(getMenu());
				scene.setup();
			}
		});


//----------------------------------------------------------Setting up the scene and showing display
		setScene(new Scene( gamePane, 2000, 1000));
		display();
	}
	

}
