
package gui;

import javax.swing.JFrame;
import javafx.scene.layout.Pane; 
import drivers.Main;
import handlers.buttonHandlers;
import handlers.buttonHandlers.StartPVPHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class LaunchPVP extends PVPSelect {

	// instance variables 
	private Text turnText = new Text();
	private int turnPhase = -1; 
	
    private Text Player1text = new Text();
    private Text Player2text = new Text();
    private Text scoreText = new Text();
    private Text scoreText2 = new Text();
    private int Player1Score = -1;
    private int Player2Score = -1;   
    private int numpairs = 0; 
    
    //------------------------------------// End game images. 
    private Image gameOverImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\gameover.png");
    private ImageView goIV = new ImageView(gameOverImg);
    private Image gameOverBGImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\pokegameover.png");
    private ImageView goBGIV = new ImageView(gameOverBGImg);
    
    public static int difficulty = 0;
    
    //------------------------------------------// this section for updating board. 
    public static boolean firstSetUp = false;
    public static boolean secondSetUp = false;
    public static boolean boardSetUp = false;
    public static boolean CPUBoardSetUp = false;
    
    public static boolean reloadGame = false;
    
    // convert the class into an object class.
    static LaunchPVP obj = new LaunchPVP(null);
    
    // Creates a new pane 
    static Pane gamePane = new Pane();
    public LaunchPVP(Main menu) {
        super(menu);
    }
    
//--------------------------------------------------------------------------------------------------------// This is for updating turns.
    
    public static void FirstTurn(boolean myFirstSetUp){
        firstSetUp = myFirstSetUp;
        obj.setTurn();
    }
    
    public static void SecondTurn(boolean mySecondSetUp){
        secondSetUp = mySecondSetUp;
        obj.setTurn2();
    }
    
    public void setTurn() {
        turnPhase = 0; // player 1's turn
        setup(); // calls set up() again which will draw everything. 
    }
    
    public void setTurn2() {
        turnPhase = 1; // player 1's turn
        setup(); // calls set up() again which will draw everything. 
    }
    
    
//--------------------------------------------------------------------------------------------------------// This is for setting up the score.     
    
    // This can be used to set up an object so it can be compatible between static and non static variables  
    public static void mySetScore(boolean myBoardSetUp){
        boardSetUp = myBoardSetUp;
        obj.setScore();
    }
    
    // same thing as mySetScore but with the CPU because it links towards the next method setScore() and setScore2()
    public static void CPUSetScore(boolean myCPUBoardSetUp){
        CPUBoardSetUp = myCPUBoardSetUp;
        obj.setScore2();
    }
    
    public void setScore() {
        Player1Score += 1; // adds towards the score of the first player. 
        setup(); // calls set up() again which will draw everything. 
    }
    
    public void setScore2() {
        Player2Score += 1; // adds towards the score if the second player. 
        setup(); // calls setup() again which will draw everything.
    }
   
//--------------------------------------------------------------------------------------------------------// This is for updating score.     
    
    public static void myPrintScore(boolean myBoardSetUp){
        boardSetUp = myBoardSetUp;
        obj.printScore();
    }
    
    // same thing as myPrintScore but with the CPU because it links towards the next method printScore() and printScore2()
    public static void CPUPrintScore(boolean myCPUBoardSetUp){
        CPUBoardSetUp = myCPUBoardSetUp;
        obj.printScore2();
    }
     
    
    public void printScore() {
        Player1Score += 1; // adds towards the score of the first player. 
        numpairs += 1; // adds a pair so the game can later detect when the game ends. 
        setup(); // calls set up() again which will draw everything. 
    }
    
    public void printScore2() {
        Player2Score += 1; // adds towards the score if the second player. 
        numpairs += 1; // adds a pair so the game can later detect when the game ends 
        setup(); // calls setup() again which will draw everything.
    }
    
  //--------------------------------------------------------------------------------------------------------// This is for setting up the main game elements.
    
    @Override
    public void setup() { //launch game.
        
    	if (boardSetUp == false) { // This is to ensure it only draws once after the set up is launched.
		VBox menuBox5 = new VBox(); 
		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\behindgame.gif");
		BGImg.setFitWidth(2000);
		BGImg.setFitHeight(1000);
		
		gamePane.getChildren().add(BGImg);					// Add background image which is the gif. 
		gamePane.getChildren().add(menuBox5);				//Adding the menuBox with the; START, CREDITS, EXIT to the gamepane
    	}
    	
    	
        
    	// draws all the buttons. 
        Image gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player1win.png");
        ImageView grIV = new ImageView(gameResultImg);
    
        Image exitImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EXIT.png");              //Adding the image for the exit button
        ImageView exitIV = new ImageView(exitImg);
        
        Image startImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\START.png");            //Adding the image for the start button
        ImageView startIV = new ImageView(startImg);
        
        Button exit = new Button ();                        //Adding a EXIT button
        Button start = new Button();                        //Adding a START button
        
//----------------------------------------   EASY DIFFICULTY   ---------------------------------------------------//         
        
        // this is the difficulty 4 which will set up the board as it links to the graphics class. 
        if (difficulty == 4) {
        
    
//----------------------------------------------------------Draw the text for turn alternations (STRING TEXT):
    	
        
        if (turnPhase == 0) {
        	turnText.setText("Player 1's turn");

        }
        else if (turnPhase == 1) {
        	turnText.setText("Player 2's turn");
        }
        
        if (boardSetUp == true) {
        	turnText.setFont(Font.font(70));
        	turnText.setStroke(Color.GREEN);
        	turnText.setTranslateX(-150);
        	turnText.setTranslateY(-20);
        }
        
//----------------------------------------------------------Adding Score (INT VALUE):
        
       // player 1 score
        if (Player1Score>-1) 	
            scoreText.setText(Integer.toString(Player1Score));
            scoreText.setFont(Font.font(90));
            scoreText.setStroke(Color.DARKRED);
            scoreText.setFill(Color.DARKORANGE);
            scoreText.setTranslateX(350);
            scoreText.setTranslateY(-25);
        
        // player 2 score
        if (Player2Score >-1)
            scoreText2.setText(Integer.toString(Player2Score));
            scoreText2.setFont(Font.font(90));
            scoreText2.setStroke(Color.DARKRED);
            scoreText2.setFill(Color.DARKORANGE);
            scoreText2.setTranslateX(350);
            scoreText2.setTranslateY(-45);
 
//----------------------------------------------------------Adding Button Images:
            Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");              //Adding the image for the BACK button
            ImageView backIV = new ImageView(backImg);
            
        
//----------------------------------------------------------BACK BUTTON:
            back.setGraphic(backIV);                            //Adding the exit image onto the BACK button
            back.setBackground(null);                           //Removing the background of the button
            back.setOnMouseEntered(a->{                         //Adding the drop-shadow on the button when mouse hovers on the button
                back.setEffect(new DropShadow(50, Color.CRIMSON));
                back.setScaleX(1.1);
                back.setScaleY(1.1);
            });
            back.setOnMouseExited(a-> {                         //Removing the drop-shadow on the button when mouse does not on the button  
                back.setEffect(null);
                back.setScaleX(1.0);
                back.setScaleY(1.0);
            });
//----------------------------------------------------------Sizing the Buttons: 
            backIV.setFitHeight(50);                        //Sizing the back button
            backIV.setFitWidth(90);
            backIV.setTranslateX(1050);
            backIV.setTranslateY(500);
 
 
//----------------------------------------------------------PLAYER TEXT DISPLAY:
        VBox menuBox2 = new VBox(); 
 
        menuBox2.getChildren().add(scoreText);
        menuBox2.getChildren().add(scoreText2);
        menuBox2.getChildren().add(turnText);
 
        menuBox2.setTranslateX(1250);
        menuBox2.setTranslateY(10);
        menuBox2.setScaleX(1.0);
        menuBox2.setScaleY(1.0);
        
        gamePane.getChildren().add(menuBox2);
        //menuBox2.setAlignment(Pos.CENTER);
        
        
        
//--------------------------------------------------// This will keep the board from generating again when updating so we have our end here.         
        
        
        if (boardSetUp == false) {
 
//----------------------------------------------------------SCORE DISPLAY: 
        
        // text features
        	
       Image p1ScoreImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player1score.png");
       Image p2ScoreImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player2score.png");
       
       ImageView Score1Img = new ImageView(p1ScoreImg);
       ImageView Score2Img = new ImageView(p2ScoreImg);
       
       Score1Img.setTranslateX(1100);
       Score1Img.setTranslateY(10);	
       Score1Img.setFitWidth(450);
       Score1Img.setFitHeight(75);
        	
       Score2Img.setTranslateX(1100);
       Score2Img.setTranslateY(40);	
       Score2Img.setFitWidth(450);
       Score2Img.setFitHeight(75);
        	
        Player1text.setText("Player 1 Score: ");
        Player1text.setFont(Font.font(50));
        Player1text.setStroke(Color.BLACK);
        Player1text.setTranslateX(1200);
        Player1text.setTranslateY(0);
        
        Player2text.setText("Player 2 Score: ");
        Player2text.setFont(Font.font(50));
        Player2text.setStroke(Color.BLACK);
        Player2text.setTranslateX(1200);
        Player2text.setTranslateY(0);
    
//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
        
        VBox menuBox = new VBox();                          //Adding the buttons to the VBox
        //menuBox.getChildren().addAll(Player1text,Player2text);
        menuBox.getChildren().addAll(Score1Img,Score2Img);
        
        
        //menuBox.getChildren().add(BGImg);
        gamePane.getChildren().add(menuBox);
        
        
        back.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                GameSelect scene = new GameSelect(getMenu());
                scene.setup();
        
            }
        });
        
        //graphics.createGrid();
        graphics.setSize(1050);
        graphics.myEasyGUI();
        Grid.createGrid(new int[4][4], 4, 4);  
        
        setScene(new Scene( gamePane, 2000, 1000));
        
        boardSetUp = true;
        FirstTurn(true);
        mySetScore(true);
        CPUSetScore(true);
        
        display();      
        }   
        } 
        
        // This lets the game detect the number of pairs so it will know when the game will end and draw out the images. 
        if (numpairs == 8) {
            if (Player1Score > Player2Score) {
                gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player1win.png");
                grIV = new ImageView(gameResultImg);
            }
            else if (Player1Score < Player2Score) {
                gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player2win.png");
                grIV = new ImageView(gameResultImg);
            }
            else 
            {
                gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\tiegame.png");
                grIV = new ImageView(gameResultImg);
                
            }
 
//----------------------------------------------------------START BUTTON:
            start.setGraphic(startIV);                          //Adding the start image onto the start button
            start.setBackground(null);                          //Removing the background of the button
            start.setOnMouseEntered(a->{                        //Adding the drop-shadow on the button when mouse hovers on the button
                start.setEffect(new DropShadow(50, Color.CRIMSON));
                start.setScaleX(0.9);
                start.setScaleY(0.9);
                });
            start.setOnMouseExited(a-> {                        //Removing the drop-shadow on the button when mouse does not on the button  
                start.setEffect(null);
                start.setScaleX(0.8);
                start.setScaleY(0.8);
            });
            
//----------------------------------------------------------EXIT BUTTON:    
            exit.setGraphic(exitIV);                            //Adding the exit image onto the exit button
            exit.setBackground(null);                           //Removing the background of the button
            exit.setOnMouseEntered(a->{                         //Adding the drop-shadow on the button when mouse hovers on the button
                exit.setEffect(new DropShadow(50, Color.CRIMSON));
                exit.setScaleX(0.9);
                exit.setScaleY(0.9);
            });
            exit.setOnMouseExited(a-> {                         //Removing the drop-shadow on the button when mouse does not on the button  
                exit.setEffect(null);
                exit.setScaleX(0.8);
                exit.setScaleY(0.8);
            
            });
            
//----------------------------------------------------------Sizing the Images:  
            grIV.setTranslateX(675);
            grIV.setTranslateY(80);
            grIV.setFitHeight(100);
            grIV.setFitWidth(300);
                    
            
            goIV.setTranslateX(675);
            goIV.setTranslateY(100);    
            goIV.setFitHeight(300);
            goIV.setFitWidth(300);  
            
            start.setTranslateX(675);
            start.setTranslateY(120);
            
            exit.setTranslateX(675);
            exit.setTranslateY(130);
            
//--------------------------------------------------// this is for the extra background.            
            
            goBGIV.setTranslateX(400);
            goBGIV.setTranslateY(50);
            goBGIV.setFitWidth(850);
            goBGIV.setFitHeight(850);
            
            VBox menuBox4 = new VBox();
            menuBox4.getChildren().add(goBGIV);
            gamePane.getChildren().add(menuBox4);
        
//--------------------------------------------------// this is for the extra features.            
            
            VBox menuBox3 = new VBox(20);
            
            menuBox3.getChildren().addAll(grIV, start, exit);
            
            gamePane.getChildren().add(menuBox3);
            menuBox3.setAlignment(Pos.CENTER);      
        }
        
        
        
        
       // if difficulty is 6 then it would launch 6x6 board as the compgraphics would take the instance variable from this class.  
       if (difficulty == 6) {              
    	   if (numpairs == 18) {
           if (Player1Score > Player2Score) {
               gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player1win.png");
               grIV = new ImageView(gameResultImg);
           }
           else if (Player1Score < Player2Score) {
               gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player2win.png");
               grIV = new ImageView(gameResultImg);
           }
           else 
           {
               gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\tiegame.png");
               grIV = new ImageView(gameResultImg);
               
           }

//----------------------------------------------------------START BUTTON:
           start.setGraphic(startIV);                          //Adding the start image onto the start button
           start.setBackground(null);                          //Removing the background of the button
           start.setOnMouseEntered(a->{                        //Adding the drop-shadow on the button when mouse hovers on the button
               start.setEffect(new DropShadow(50, Color.CRIMSON));
               start.setScaleX(1.1);
               start.setScaleY(1.1);
               });
           start.setOnMouseExited(a-> {                        //Removing the drop-shadow on the button when mouse does not on the button  
               start.setEffect(null);
               start.setScaleX(1.0);
               start.setScaleY(1.0);
           });
           
//----------------------------------------------------------EXIT BUTTON:    
           exit.setGraphic(exitIV);                            //Adding the exit image onto the exit button
           exit.setBackground(null);                           //Removing the background of the button
           exit.setOnMouseEntered(a->{                         //Adding the drop-shadow on the button when mouse hovers on the button
               exit.setEffect(new DropShadow(50, Color.CRIMSON));
               exit.setScaleX(1.1);
               exit.setScaleY(1.1);
           });
           exit.setOnMouseExited(a-> {                         //Removing the drop-shadow on the button when mouse does not on the button  
               exit.setEffect(null);
               exit.setScaleX(1.0);
               exit.setScaleY(1.0);
           
           });
           
//----------------------------------------------------------Sizing the Images:  
           grIV.setTranslateX(860);
           grIV.setTranslateY(80);
           grIV.setFitHeight(150);
           grIV.setFitWidth(500);
                   
           goIV.setTranslateX(860);
           goIV.setTranslateY(100);
           
           start.setTranslateX(860);
           start.setTranslateY(120);
           exit.setTranslateX(860);
           exit.setTranslateY(130);
           
           VBox menuBox3 = new VBox(20); 
           menuBox3.getChildren().addAll(grIV,goIV, start, exit);
           gamePane.getChildren().add(menuBox3);
           menuBox3.setAlignment(Pos.CENTER);      
       }
   
//----------------------------------------------------------Adding Player Score (INT VALUE):
       if (Player1Score>0)
           scoreText.setText(Integer.toString(Player1Score));
           scoreText.setFont(Font.font(25));
           scoreText.setStroke(Color.CRIMSON);
           scoreText.setTranslateX(1450);
           scoreText.setTranslateY(0);
       
       // computer score
       if (Player2Score >0)
           scoreText2.setText(Integer.toString(Player2Score));
           scoreText2.setFont(Font.font(25));
           scoreText2.setStroke(Color.CRIMSON);
           scoreText2.setTranslateX(1450);
           scoreText2.setTranslateY(0);

//----------------------------------------------------------Adding Button Images:
           Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");              //Adding the image for the BACK button
           ImageView backIV = new ImageView(backImg);
           
       
//----------------------------------------------------------BACK BUTTON:
           back.setGraphic(backIV);                            //Adding the exit image onto the BACK button
           back.setBackground(null);                           //Removing the background of the button
           back.setOnMouseEntered(a->{                         //Adding the drop-shadow on the button when mouse hovers on the button
               back.setEffect(new DropShadow(50, Color.CRIMSON));
               back.setScaleX(1.1);
               back.setScaleY(1.1);
           });
           back.setOnMouseExited(a-> {                         //Removing the drop-shadow on the button when mouse does not on the button  
               back.setEffect(null);
               back.setScaleX(1.0);
               back.setScaleY(1.0);
           });
//----------------------------------------------------------Sizing the Buttons: 
           backIV.setFitHeight(50);                        //Sizing the back button
           backIV.setFitWidth(90);
           backIV.setTranslateX(1050);
           backIV.setTranslateY(500);


//----------------------------------------------------------PLAYER TEXT DISPLAY:
       VBox menuBox2 = new VBox(); 

       menuBox2.getChildren().add(scoreText);
       menuBox2.getChildren().add(scoreText2);
       gamePane.getChildren().add(menuBox2);
       menuBox2.setAlignment(Pos.CENTER);
       
       
       if (boardSetUp == false) {

//----------------------------------------------------------SCORE DISPLAY:
    
       // text features
       Player1text.setText("Player 1 Score: ");
       Player1text.setFont(Font.font(25));
       Player1text.setStroke(Color.BLACK);
       Player1text.setTranslateX(1200);
       Player1text.setTranslateY(0);
       
       Player2text.setText("Player 2 Score: ");
       Player2text.setFont(Font.font(25));
       Player2text.setStroke(Color.BLACK);
       Player2text.setTranslateX(1200);
       Player2text.setTranslateY(0);
   
//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
       //BGImg.setFitHeight(860);
       //BGImg.setFitWidth(1380);
       
       VBox menuBox = new VBox();                          //Adding the buttons to the VBox
       menuBox.getChildren().addAll(Player1text,Player2text);
       
       
       //menuBox.getChildren().add(BGImg);
       gamePane.getChildren().add(menuBox);
       
       
       back.setOnAction(new EventHandler<ActionEvent>()
       {
           @Override
           public void handle(ActionEvent event) {
               GameSelect scene = new GameSelect(getMenu());
               scene.setup();
       
           }
       });
       
       
       //graphics.createGrid();
       graphics.setSize(1025);
       graphics.myEasyGUI();
       Grid.createGrid(new int[6][6], 6, 6);   
       
       // sets scene with 2000 width and 1000 height to fit my screen. 
       setScene(new Scene( gamePane, 2000, 1000));
       
       // board set up is true so it won't draw the game again once the score updates. 
       boardSetUp = true;
       
       display();      
       }   
    	   
    	   
    	   
    	   
    	   
       }
 
    }
}