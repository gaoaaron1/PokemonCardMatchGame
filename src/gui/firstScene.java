package gui;

import drivers.Main;
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
import loopmusicjavaupdated.musicStuff;

public class firstScene extends baseScene{
	public static final int buttonHeight = 20;
	public static final int buttonWidth = 20;
	StackPane gamePane = new StackPane();
	public static boolean playMusic = false;
	
	
	public firstScene(Main menu) {
		super(menu);
	}

	
	@Override
	public void setup() {
		
		if (playMusic == false) {
			String filepath = ("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\Poketheme.wav");
			musicStuff musicObject = new musicStuff();
			musicObject.playMusic(filepath);
		}
		

		
		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\pokemonBackground2.png");
		
//----------------------------------------------------------Adding Button Images:
		Image startImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\START.png");			//Adding the image for the start button
		ImageView startIV = new ImageView(startImg);
		Image creditsImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\CREDITS.png");		//Adding the image for the credits button
		ImageView creditsIV = new ImageView(creditsImg);
		Image exitImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EXIT.png");				//Adding the image for the exit button
		ImageView exitIV = new ImageView(exitImg);
//----------------------------------------------------------Creating Buttons:
		Button start = new Button();						//Adding a START button
		Button credits = new Button();						//Adding a CREDITS button
		Button exit = new Button ();						//Adding a EXIT button
		
		
//----------------------------------------------------------START BUTTON:
		start.setGraphic(startIV);			//Adding the start image onto the start button
		start.setBackground(null);							//Removing the background of the button
		start.setOnMouseEntered(a->{						//Adding the drop-shadow on the button when mouse hovers on the button
			start.setEffect(new DropShadow(50, Color.CRIMSON));
			start.setScaleX(1.1);
    		start.setScaleY(1.1);
		});
		start.setOnMouseExited(a-> {						//Removing the drop-shadow on the button when mouse does not on the button	
				start.setEffect(null);
				start.setScaleX(1.0);
	    		start.setScaleY(1.0);
		
		});
		
//----------------------------------------------------------CREDITS BUTTON:
		credits.setGraphic(creditsIV);		//Adding the credit image onto the credit button
		credits.setBackground(null);						//Removing the background of the button
		credits.setOnMouseEntered(a->{						//Adding the drop-shadow on the button when mouse hovers on the button
				credits.setEffect(new DropShadow(50, Color.CRIMSON));
				credits.setScaleX(1.1);
	    		credits.setScaleY(1.1);
		});
		credits.setOnMouseExited(a-> {						//Removing the drop-shadow on the button when mouse does not on the button	
			credits.setEffect(null);
			credits.setScaleX(1.0);
			credits.setScaleY(1.0);
    		
		});
//----------------------------------------------------------EXIT BUTTON:
		exit.setGraphic(exitIV);			//Adding the exit image onto the exit button
		exit.setBackground(null);							//Removing the background of the button
		exit.setOnMouseEntered(a->{						//Adding the drop-shadow on the button when mouse hovers on the button
			exit.setEffect(new DropShadow(50, Color.CRIMSON));
			exit.setScaleX(1.1);
			exit.setScaleY(1.1);
		});
		exit.setOnMouseExited(a-> {						//Removing the drop-shadow on the button when mouse does not on the button	
			exit.setEffect(null);
			exit.setScaleX(1.0);
			exit.setScaleY(1.0);
		
		});
		
//----------------------------------------------------------Sizing the Buttons:	
		startIV.setFitHeight(90);							//Sizing the start button
		startIV.setFitWidth(200);
				
		creditsIV.setFitHeight(90);							//Sizing the credits button
		creditsIV.setFitWidth(200);
				
		exitIV.setFitHeight(90);							//Sizing the exit button
		exitIV.setFitWidth(200);
//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
		BGImg.setFitHeight(1000);
		BGImg.setFitWidth(2000);
		
		VBox menuBox = new VBox();							//Adding the buttons to the VBox
		menuBox.getChildren().add(start);
		menuBox.getChildren().add(credits);
		menuBox.getChildren().add(exit);
		
		menuBox.setAlignment(Pos.CENTER);					//Aligning the menu start & quit buttons to the center
		
				//Adding HBox to the pane
		
		gamePane.getChildren().add(BGImg);					//Adding the Background Image on to the gamepane
		gamePane.getChildren().add(menuBox);				//Adding the menuBox with the; START, CREDITS, EXIT to the gamepane
		gamePane.setAlignment(Pos.CENTER);					//Aligning to the center
		
		
//----------------------------------------------------------Attaching the event handlers for START
		start.setOnAction(new EventHandler<ActionEvent>()
				{
			@Override
			public void handle(ActionEvent event) {
				playMusic = true;
				GameSelect scene = new GameSelect(getMenu());
				scene.setup();
				
			}
	});

//----------------------------------------------------------Attaching the event handlers for CREDITS
		credits.setOnAction(new EventHandler<ActionEvent>()
				{
			@Override
			public void handle(ActionEvent event) {
				System.out.println("GAME DEVELOPED BY:\nAaron Gao\nAdarsha Kanel\nAhmed Obad\nJoshua Bernard\nCPSC 233 - T04");
				playMusic = true;
				CreditScene scene = new CreditScene(getMenu());
				scene.setup();
				
			}
	});

//----------------------------------------------------------Attaching the event handlers for EXIT
		exit.setOnAction(new EventHandler<ActionEvent>()
		{
				@Override
				public void handle(ActionEvent event) {
					Platform.exit();
					
				}
		});
		
//----------------------------------------------------------Setting up the scene and showing display
		setScene(new Scene( gamePane, 2000, 1000));
		display();
	}

}

