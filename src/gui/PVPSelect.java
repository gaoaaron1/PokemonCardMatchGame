package gui;

import drivers.Main;
import handlers.buttonHandlers;
import handlers.buttonHandlers.EasyPVPHandler;
import handlers.buttonHandlers.HardPVPHandler;
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

public class PVPSelect extends GameSelect {
	StackPane gamePane = new StackPane();

//----------------------------------------------------------Creating Buttons:
	public Button easy = new Button();						//Adding a EASY button
	public Button hard = new Button();						//Adding a HARD button
	public Button back = new Button();						//Adding a BACK button
		
	public PVPSelect(Main menu) {
		super(menu);
	}

	@Override
	public void setup() {
		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\behindgame2.gif");

//----------------------------------------------------------Adding Button Images:
		Image easyImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EASY.png");				//Adding the image for the EASY button
		ImageView easyIV = new ImageView(easyImg);
		Image hardImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\HARD.png");				//Adding the image for the HARD button
		ImageView hardIV = new ImageView(hardImg);
		Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");				//Adding the image for the BACK button
		ImageView backIV = new ImageView(backImg);
		
//----------------------------------------------------------EASY BUTTON:
		easy.setGraphic(easyIV);			//Adding the start image onto the EASY button
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

//----------------------------------------------------------Sizing the Buttons:	
		easyIV.setFitHeight(90);
		easyIV.setFitWidth(200);
		
		hardIV.setFitHeight(90);
		hardIV.setFitWidth(200);
		
		backIV.setFitHeight(90);
		backIV.setFitWidth(200);
				

//----------------------------------------------------------HARD BUTTON:
		hard.setGraphic(hardIV);							//Adding the exit image onto the HARD button
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
		back.setGraphic(backIV);							//Adding the exit image onto the BACK button
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
		menuBox.getChildren().add(easy);
		menuBox.getChildren().add(hard);
		menuBox.getChildren().add(back);
		
		menuBox.setAlignment(Pos.CENTER);					//Aligning the menu start & quit buttons to the center
		
				//Adding HBox to the pane
		
		gamePane.getChildren().add(menuBox);				//Adding the menuBox with the; START, CREDITS, EXIT to the gamepane
		gamePane.setAlignment(Pos.CENTER);					//Aligning to the center
		
		/*
		BtnExitHandler exitHandle = new BtnExitHandler();	//Attaching the event handlers for QUIT
		exit.setOnAction(exitHandle);
		*/
	
//----------------------------------------------------------Attaching the event handlers for EASY
		EasyPVPHandler easyHandle = new EasyPVPHandler(getMenu());
		easy.setOnAction(easyHandle);

//----------------------------------------------------------Attaching the event handlers for EASY
		HardPVPHandler hardHandle = new HardPVPHandler(getMenu());
		hard.setOnAction(hardHandle);		
		
		
//----------------------------------------------------------Attaching the event handlers for EASY
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
