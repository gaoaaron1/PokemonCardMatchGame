package gui;

import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import compgraphics.Tile;

//import application.Grid;

/*************************************************************************
 * The purpose of this GUI.java class is to show the GUI or Graphics User
 * Interface in the Card Match Memory Game. The GUI is using the
 * imported Application called the java.fx or java.swing. The GUI is
 * not yet fully connected to the other classes rather it presents a
 * menu screen and allows for the menu and the game to be displayed by
 * running the Game.java class.
 * ***********************************************************************
 */

public class graphics extends Application {
	
	public int numRows = LaunchPVP.difficulty;
	public int numCols = LaunchPVP.difficulty;
	
	public static int difficultySize = 100;
	
	
	public static int size = 1100;
	
	public static void setSize(int mySize) {
		size = mySize;
	}


    //The Tile object is used for this GUI to show the function of the game.
    private Tile selected = null;
    private int clicker = 2;
    
    public static int player = 1;
    
    
	public ImageView imageView;
	
	static Image backimg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
	static Image img0 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Meowth.png");
	static Image img1 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Bulbasaur.png");
	static Image img2 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Charmander.png");
	static Image img3 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Squirtle.png");
	static Image img4 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Pikachu.png");
	static Image img5 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Jigglypuff.png");
	static Image img6 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Mr.Mime.png");
	static Image img7 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Geodude.png");
	static Image img8 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Snorlax.png");
	static Image img9 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Treecko.png");
	static Image img10 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Piplup.png");
	static Image img11 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Pidgey.png");
	static Image img12 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Chimchar.png");
	static Image img13 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Slowpoke.png");
	static Image img14 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Mew.png");
	static Image img15 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\MewTwo.png");
	static Image img16 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Machop.png");
	static Image img17 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Arbok.png");
	static Image imgX = backimg;
    
    
	static graphics obj = new graphics();
    
    public static int playerOneScore = 0;
    public static int playerTwoScore = 0;
	int [][] agrid = new int[numRows][numCols];		// empty grid that will be filled with random values
	int[][] grid =Grid.createGrid(agrid, numRows, numCols);			// grid will now point at agrid
    
	//Using the Grid creation method createGrid to make the tiles array to display the text
	//The value of each tile has been displayed from the value of the grid.
	
	public static void myEasyGUI(){
		obj.easyGUI();
		}
	
	
	public Parent easyGUI() {
        Pane gameWindow = LaunchPVP.gamePane;
        gameWindow.setPrefSize(size,size);
	
    	/*Initializing the number of tiles with each pair of tiles so for the 
    	 *easy level there would be a total of 16 tiles with 8 tiles that show 
    	 *the same image which can be matched.
    	 */
			List<Tile> tiles = new ArrayList<>();
			for(int y = 0; y<numRows; y++){
				for(int e = 0; e<numCols; e++){
					if (grid[y][e] ==0) {
						imgX = img0; // Meowth
					}
					if (grid[y][e] == 1) {
						imgX = img1; // Bulbasaur
					}
					if (grid[y][e] == 2) {
						imgX = img2; // Charmander
					}
					if (grid[y][e] == 3) {
						imgX = img3; // Squirtle
					}
					if (grid[y][e] == 4) {
						imgX = img4; // Pikachu
					}
					if (grid[y][e] == 5) {
						imgX = img5; // Jigglypuff
					}
					if (grid[y][e] == 6) {
						imgX = img6; // Mr.Mime
					}
					if (grid[y][e] == 7) {
						imgX = img7; // Geodude
					}
					if (grid[y][e] == 8) {
						imgX = img8; // Snorlax
					}
					if (grid[y][e] == 9) {
						imgX = img9; // Treecko
					}
					if (grid[y][e] == 10) {
						imgX = img10; // Piplup
					}
					if (grid[y][e] == 11) {
						imgX = img11; // Pidgey
					}
					if (grid[y][e] == 12) {
						imgX = img12; // Chimchar
					}
					if (grid[y][e] == 13) {
						imgX = img13; // Slowpoke
					}
					if (grid[y][e] == 14) {
						imgX = img14; // Mew
					}
					if (grid[y][e] == 15) {
						imgX = img15; // MewTwo
					}
					if (grid[y][e] == 16) {
						imgX = img16; // Machop
					}
					if (grid[y][e] == 17) {
						imgX = img17; // Arbok
					}
					
					tiles.add(new Tile(String.valueOf(grid[y][e])));
				}
			}

			for (int i = 0; i < tiles.size(); i++) {
				Tile tile = tiles.get(i);
				tile.setTranslateX((size / numRows) * (i % numRows));				// will create the tile into a certianw width
				tile.setTranslateY((size/ numCols) * (i / numCols));	
				gameWindow.getChildren().add(tile);
		}
		return gameWindow;
	}
	
	
	/*This method is the stage that sets the window itself. It calls the method
	 * to run the createContent method to create the grid of tiles with the text.
	 * 
	 */

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(easyGUI()));
        primaryStage.show();
        primaryStage.setFullScreen(true);
		
		
    }
	
    //A method to show the card display, flipping functionality, equality checking and returning the proper results.
    private class Tile extends StackPane {

    	private ImageView imgGame = new ImageView(img0);
    	private ImageView imgGameX = new ImageView(imgX);
    	
        private Text text = new Text();
        Rectangle border = new Rectangle(size/ numRows, size/numCols);

        //A method to show the initial display of the tiles and the border with different colors.
        //Positioning of the tiles and the font of the card value has also been set by this method.
        public Tile(String firstCard) {
        	
        	if (numRows == 4) {
        		difficultySize = 200;
        	}
        	else if (numRows == 6) {
        		difficultySize = 140;
        	}
        	
           	imgGame.setImage(backimg);
        	imgGame.setFitHeight(difficultySize);
        	imgGame.setFitWidth(difficultySize);
        	
        	
           	imgGameX.setFitHeight(difficultySize);
        	imgGameX.setFitWidth(difficultySize);
        	
        	
            border.setStroke(Color.BLACK);
            border.setFill(Color.WHITE);

            text.setText(firstCard);
            text.setFont(Font.font(30));
            text.setStroke(Color.BLACK);

            setAlignment(Pos.CENTER);
            getChildren().addAll(imgGame, imgGameX);

            setOnMouseClicked(this::cardClickedByMouse);
            hideCard();
        }

        /*This method reads the MouseEvent and looks at the user clicks and performs what is necessary
         * in the code to check for equality between the two tiles.
         * 
         * If the tiles are equal then the tiles will become the same color as to show equality.
         * If the tiles are NOT equal then the tiles will go back to its "flipping" mechanism.
         * 
         */
        
        public void cardClickedByMouse(MouseEvent event) {
			if (player%2 == 0) {
				player = 2;
			}
			else {
				player = 1;
			}
			
			if (player == 1) {
				System.out.println("Current player is "+ player);
				if (cardClicked() || clicker == 0) {
					return;
				}
				clicker--;
				if (selected == this) {
					clicker ++;
				}
				if (selected!= this) {
					if (selected == null) {
						selected = this;
						showCard(() -> {});
					}
					else {
						showCard(() -> {
							if (equaltiles(selected)) {
								playerOneScore ++;
								System.out.println("Player 1 score is: "+ playerOneScore);
		                		LaunchPVP.myPrintScore(true);
								
							}
							else if (!equaltiles(selected)) {
								selected.hideCard();
								this.hideCard();
							}
						
							selected = null;
							clicker = 2;
							player++;
						});
						LaunchPVP.SecondTurn(true);
					}
				}
			}
			
			else if (player == 2) {
				System.out.println("Current player is "+ player);
				if (cardClicked() || clicker == 0) {
					return;
				}
				clicker--;
				if (selected == this) {
					clicker ++;
				}
				if (selected!= this) {
					if (selected == null) {
						selected = this;
						showCard(() -> {});
					}
					
					else {
						showCard(() -> {
							if (equaltiles(selected)) {
								playerTwoScore  ++;
								System.out.println("Player 2 score is: "+ playerTwoScore );
		                		LaunchPVP.CPUPrintScore(true);
							
							}
							else if (!equaltiles(selected)) {
								selected.hideCard();
								this.hideCard();
							}
						
							selected = null;
							clicker = 2;
							player++;
						});
						LaunchPVP.FirstTurn(true);
					}
				}
        	}
		}

        //This method will check if the card is open and return the opacity to 1 to indicate that the card
        //has been opened as to show the user not to pick the same card again.
        public boolean cardClicked() {
            return imgGameX.getOpacity() == 1;
        }

        /*This method will fade the card to show it and runs the action to show the card to view it separately
         * from the background stroke color.
         */
        public void showCard(Runnable action) {
            FadeTransition flip = new FadeTransition(Duration.seconds(0.5), imgGameX);
            flip.setToValue(1);
            flip.setOnFinished(e -> action.run());
            flip.play();
        }

        //This method will close the card by performing a fade transition to hide the card
        public void hideCard() {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), imgGameX);
            ft.setToValue(0);
            ft.play();
        }

        //This method checks if both the values of the text are the same. EQUALITY TO CHECK TO HIDE tiles OR REVEL THEM.
        public boolean equaltiles(Tile secondCard) {
            //return text.getText().equals(secondCard.text.getText());
        	return imgGameX.getImage().equals(secondCard.imgGameX.getImage());
        }
    }


    
    /*This is called as the GUI.java class extends to the Application class in
     * java.fx so the launch(args) is also extended by the Application class.
     */
    public static void main(String[] args) {
    	launch(args);
    	
        /*
   		String filepath = ("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\Poketheme.wav");
		musicStuff musicObject = new musicStuff();
		musicObject.playMusic(filepath);
		*/
    }
}