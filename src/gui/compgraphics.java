package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javax.swing.JFrame;

import java.awt.AWTException;

//import compgraphics.Tile;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;

public class compgraphics extends Application {
	static int  numRows = LaunchCPU.difficulty;
	static int numCols = LaunchCPU.difficulty;
	static int size = 1000;
	public static int difficultySize = 100;
	
	public static void setRows(int row) {
		numRows = row;
	}
	public static void setCols(int cols) {
		numCols = cols;
	}
	public static void setSize(int mySize) {
		size = mySize;
	}
	
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

	static compgraphics obj = new compgraphics();
	
	int counting_man = -2; 

    Tile selected = null;	// selected will keep track of the card clicked
    private int counter = 4;		// counter 2 = first card, counter 1 = second card
    private int player = 1;			// will alternate between the players
    private int[][] comp_mem = new int[numRows][numCols];	// array that will keep track of all the cards discovered
    private int score1 = 0;			// score for the player
    private int score2 = 0;			// score for the computer
    private int [][] agrid = new int[numRows][numCols];		// empty grid that will be filled with random values
    private String[][] array = new String[numRows][numCols];	// will keep track of all the matched cards
    private int[][] grid =Grid.createGrid(agrid, numRows, numCols);			// grid will now point at agrid
    private int[]coordtotile = new int[2];					// keep track of the coordinates of mouse clicked by the player
    private int[]coordinatetotile = new int[4];				// will take the coordtotile for both cards and remember it
    private int[] tiletocoordinate = new int[4];			// tile that will store the tile used by computer to coordinates
    private int screenHeight;								// screenHeight will will store the height of the screen
    private int screenWidth;								// screenWidth will store the width of the screen
    private int []coordinate_array = new int[4];			// coordinate array will store the value that the vsComputer will give us
    public int scored_player = 0;
    
	public static void myContent(){
		obj.createContent();
	}
    
    public Parent createContent() {

        Pane root = LaunchCPU.gamePane;
        root.setPrefSize(size, size);					// will create a scene of this height and width
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				array[i][j] = "*";					// will make an array filled with * to be used by computer
			}
		}
			List<Tile> tiles = new ArrayList<>();	// will make the tiles into a array list
			
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
					tiles.add(new Tile(String.valueOf(grid[y][e])));		// adds the random values from grid to be transformed into tiles
				}
			}

			for (int i = 0; i < tiles.size(); i++) {
				Tile tile = tiles.get(i);
				tile.setTranslateX((size / numRows) * (i % numRows));				// will create the tile into a certianw width
				tile.setTranslateY((size/ numCols) * (i / numCols));				// will create the tile into a certain length
				root.getChildren().add(tile);							// adds the tile into the scene
			}
		return root;
	}
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(createContent()));				// will make the tiles to be shown
        primaryStage.show();											// will show the tiles currently made
        primaryStage.setFullScreen(true);
    }

    public class Tile extends StackPane {
    
    	private ImageView imgGame = new ImageView(img0);
    	private ImageView imgGameX = new ImageView(imgX);
    	
        public Text text = new Text();

        public Tile(String value) {
        	
        	if (numRows == 4) {
        		difficultySize = 200;
        	}
        	
        	if (numRows == 6) {
        		difficultySize = 140;
        	}
        	
          	imgGame.setImage(backimg);
        	imgGame.setFitHeight(difficultySize);
        	imgGame.setFitWidth(difficultySize);
        	
           	imgGameX.setFitHeight(difficultySize);
        	imgGameX.setFitWidth(difficultySize);
        	
        	
            Rectangle border = new Rectangle(size/numRows, size/numCols); 	// will make a rectangle that will fix into the tile

            border.setFill(null);											// will choose what the border of rectangle is
            border.setStroke(Color.BLACK);									// will choose the color of it

            text.setText(value);											// the value of tile will be shown 
            text.setFont(Font.font(30));
            text.setId("fancytext");
            
            setAlignment(Pos.CENTER);										// where the number will be shown
            getChildren().addAll(border, imgGame, imgGameX);							
            setOnMouseClicked(event -> {
				try {
					handleMouseClick(event);								// exectues the handle mouse click methof
				} catch (AWTException e) {
					e.printStackTrace();									// if exection if made
				}
			});
            close();														// closes the scene
        }
        
    	public int screenHeight() {
	       return 0;								// returns the new height
    	} 	 
    	
    	public int screenWidth() {
	        return 0;								// returns the value
    	}
    	
    	public int[] computerCoordsToTile(int x, int y) {
    		int width = screenWidth();
    		int height = screenHeight();
    		int distance_row = size / numRows;
    		int distance_column = size / numCols;
    		int x_cc = x;
    		int y_cc = y;
    		for(int i = 0; i< numRows  ; i++){
    			for(int j = 0; j< numCols  ; j++){
    				if (((x_cc >= (width +(distance_column * j))) && ( x_cc < (width +(distance_column * (j+1)))) ) 
    				&& (y_cc >= (height +(distance_row * i)))&& (y_cc < (height +(distance_row * (i+1)))) ){
    					coordtotile[0] = j;					// will store the coordinates x clicked by player into a tile location
    					coordtotile[1] = i;					// will store the coordinates y clicked by player into a tile location
    				}    				
    			}
    		}
    		return(coordtotile);			// returns the array
    	}    

    	public int[] tiletoCoordinate(int x , int y, int x2, int y2) {
    		int width = screenWidth();
    		int height = screenHeight();
    		int distance_row = size / numRows;
    		int distance_column = size/ numCols;
    		if (x >= 0 ) {
			tiletocoordinate[0] = ((width + (distance_column * x)) + (distance_column/2)) ;		// will take the first tile's x given by comp into a coordinate
    		}
			if (x2 >= 0 ) {
			tiletocoordinate[2] = ((width + (distance_column * x2))+ (distance_column /2)) ;		// will take the second tile's x given by comp into a coordinate
    		}     	
			if (y >= 0) {
				tiletocoordinate[1] = ((height + (distance_row * y)) + (distance_row / 2)) ;	// will take the first tile's y given by comp into coordinate
			}
			if(y2 >= 0) {
				tiletocoordinate[3] = ((height + (distance_row * y2)) + (distance_row / 2)) ;	// will take the first tile's y given by comp into coordinate
			}	
    		return(tiletocoordinate);			// returns that as a array
    	}
		public void handleMouseClick(MouseEvent event) throws AWTException {
				System.out.println("score  1 + 2 is: " +(score1+score2)); 
				
	
				if (counter == 3) {			// will print that its player's 1 turn only once
					System.out.println("Current player is "+ player);
				}
				if (counter == 3 || counter == 2) 
					if ((isOpen() || event.getClickCount() > 1) || counter == 0) {	// makes it so that one tile can't be clicked multiple times
						return;
					}
				counter--;					// decrease the counter by 1 

				if (counter == 3) {		// will prompt the first click
					int coordx = MouseInfo.getPointerInfo().getLocation().x;		// will give the x coordinates clicked
					int coordy = MouseInfo.getPointerInfo().getLocation().y;		// will give the y coordinates clicked
					coordtotile = computerCoordsToTile(coordx , coordy);			// will store the x and y coordinates that was clicked
					coordinatetotile[0] = coordtotile[0];
					coordinatetotile[1] = coordtotile[1];
				}
				if (counter == 2) {												//will prompt the player for the second click
					int coordx1 = MouseInfo.getPointerInfo().getLocation().x;	// gives the x axis of this click
					int coordy1 = MouseInfo.getPointerInfo().getLocation().y;	// gives the y axis of this click
					coordtotile = computerCoordsToTile(coordx1,coordy1);		// stores the second x and y axis to coordtotile
					coordinatetotile[2] = coordtotile[0];
					coordinatetotile[3] = coordtotile[1];
				} 
				if (selected == this) {
					counter++;
					this.isOpen();
				}
				if (selected != this ) {
					
					if (counter == 2) {
						if (grid[coordinatetotile[1]][coordinatetotile[0]] == grid[coordinatetotile[3]][coordinatetotile[2]]){
							array[coordinatetotile[1]][coordinatetotile[0]] = Integer.toString(grid[coordinatetotile[1]][coordinatetotile[0]]);
							// will store the value in the array coordinate of the first card if the card have matched
							array[coordinatetotile[3]][coordinatetotile[2]] = Integer.toString(grid[coordinatetotile[3]][coordinatetotile[2]]);
							// will store the value in the array variable if the second card is matched
						}
					}
					if (counter >= 2) {
		
						if (grid[coordtotile[1]][coordtotile[0]] != 0) {				// will store the coordinate to comp mem if it isnt the value 0
							comp_mem[coordtotile[1]][coordtotile[0]] = grid[coordtotile[1]][coordtotile[0]];
						}
						else {
							comp_mem[coordtotile[1]][coordtotile[0]] = 100;				// will store the coordinate as 100 in comp mem is the value is 0
						}
						if (selected == null ) {										
							selected = this;									// will make the tile into selected
							open(() -> {});
						}
						
						else {
							
							open(() -> {
									System.out.println("this is: "+ this);
									System.out.println("selected  is: "+ selected);
								if (hasSameValue(selected)) {				// if both the clicks have the same value
									score1 ++;
									System.out.println("Player 1 score is: "+ score1);
									LaunchCPU.myPrintScore(true);
									// score increases by one because the cards have matched
									// displays the score
									scored_player = 1;
									counting_man = -2;

								}
								else if (!hasSameValue(selected)) {	// if the values were not the same
									System.out.println("counter not pressed: " + counter);
									counting_man = -2;

									selected.close();				// closes the tiles
									this.close();					// closes the second tile
								}
								
								selected = null;				// selected reset
								player = 2;

							});
							LaunchCPU.SecondTurn(true);
						}
					}
				}
				for(int i = 0; i < grid.length; i++) {
					for (int j = 0; j < grid[i].length; j++) {
						if (array[i][j] != "*") {
							counting_man ++;
						}
					}
				}
				System.out.println("Counting man is: "+ counting_man);
				if ((((counting_man != ((numRows * numCols)) )) && 
						(((scored_player != 1&& ((counting_man < ((numRows * numCols))-2 ))))
								||((scored_player == 1 && ((counting_man < ((numRows * numCols))))))))){
					counting_man = -2;
					if (counter <=2 ) {
						if (counter == 2) {
							System.out.println("COMPUTER'S TURN");	// will print the computer's turn once
						}
						if ((isOpen() || event.getClickCount() > 1) || counter < 0) {
							return;									// makes it that the computer cannot click the same tile twice and not make the tile
						}
						if (counter == 2) {		// only occurs one per computer turn
							coordinate_array = vsComputer.computer(grid,comp_mem,array, numRows, numCols, counter);
							// will call the method in vsComp for computer player
							if (((coordinate_array[0] == coordinate_array[2] ) && (coordinate_array[1] == coordinate_array[3]))
									|| (((coordinate_array[0] == coordinatetotile[2]) && (coordinate_array[1] == coordinatetotile[3]))
									|| ((coordinate_array[0] == coordinatetotile[0]) && (coordinate_array[1] == coordinatetotile[1])))){
									while (((coordinate_array[0] == coordinate_array[2] ) && (coordinate_array[1] == coordinate_array[3]))) {
										coordinate_array = vsComputer.computer(grid,comp_mem,array, numRows, numCols, counter);
									}
									 if (((coordinate_array[0] == coordinatetotile[2]) && (coordinate_array[1] == coordinatetotile[3]))
											 && (((coordinate_array[2] != coordinatetotile[2]) && (coordinate_array[3] != coordinatetotile[3])))){
												 int[] temp = new int[4];
												 for (int i = 0; i <4 ; i++) {
													 temp[i] = coordinate_array[i];
												 }
												 coordinate_array[0] = temp[2];
												 coordinate_array[1] = temp[3];
												 coordinate_array[2] = temp[0];
												 coordinate_array[3] = temp[1];
											 }
										}
								}
							}
						
			
							tiletocoordinate = tiletoCoordinate( coordinate_array[0] ,  coordinate_array[1],  coordinate_array[2],  coordinate_array[3]);
							// will convert the coordinate array tiles location into coordinates 
							if (counter == 2 ) {	
		 				// will auto click this x and y axis
								click(tiletocoordinate[0], tiletocoordinate[1]);	// will click the first card picked
			
								if (grid[coordinate_array[1]][coordinate_array[0]] != 0) {
									comp_mem[coordinate_array[1]][coordinate_array[0]] = grid[coordinate_array[1]][coordinate_array[0]];
									// will store the value into the comp mem array if it is not 0
								}
								else {
									comp_mem[coordinate_array[1]][coordinate_array[0]] = 100;
									// will store the value into comp mem as 100 if it is 0
								}
		
							}
							if (counter == 1 && player == 2) {		// will check if counter is 1 and will prompt the click
								Robot bot = new Robot();
								bot.delay(200);
		
								click(tiletocoordinate[2], tiletocoordinate[3]);		// will the second coordinate given by computer
		
								if (grid[coordinate_array[3]][coordinate_array[2]] != 0) {
									comp_mem[coordinate_array[3]][coordinate_array[2]] = grid[coordinate_array[3]][coordinate_array[2]];
									// will store the comp mem if it is not 0
								}
								else {
									comp_mem[coordinate_array[3]][coordinate_array[2]] = 100;
									// will store the comp mem as 100, if the value is not 0
								}
							}	
							if (counter == 1) {
								if (grid[coordinate_array[1]][coordinate_array[0]] == grid[coordinate_array[3]][coordinate_array[2]]) {
									array[coordinate_array[1]][coordinate_array[0]] = Integer.toString(grid[coordinate_array[1]][coordinate_array[0]]);
									// will store the values into the array variable if they match
									array[coordinate_array[3]][coordinate_array[2]] = Integer.toString(grid[coordinate_array[3]][coordinate_array[2]]);
									// will store the values into the array variable if they match
								}
							}
		
							if (counter <= 1 && player == 2) {
			
								if (selected == null ) {	
									selected = this;
									open(() -> {});
								}
								else {
									open(() -> {
										if (hasSameValue(selected)) {
											score2 ++;	// will increase the score by 1
											System.out.println("Computer 1 score is: "+ score2);				
											LaunchCPU.CPUPrintScore(true);
											scored_player = 2;

												counting_man = -2;

											}
										else if (!hasSameValue(selected)) {
											selected.close();	// will close the selected tile
											this.close();		// will close the current tile
											counting_man = -2;

										}
									
										selected = null;
										counter = 4;			// resets the counter to 2
										player =1; 

									});
									LaunchCPU.FirstTurn(true);
								}
							}
				}
		}
		
		public void click(int x, int y) throws AWTException{	// the auto click bot
			Robot bot = new Robot();
			bot.mouseMove(x, y);  				// will auto click this x and y axis
			bot.mouseMove(x, y);  				// will auto click this x and y axis
			bot.mouseMove(x, y);  				// will auto click this x and y axis
			bot.mouseMove(x, y);  				// will auto click this x and y axis
			bot.mousePress(InputEvent.BUTTON1_MASK);
			bot.delay(200);
			bot.mouseRelease(InputEvent.BUTTON1_MASK);
			bot.delay(200);

		}

        public boolean isOpen() {
            return imgGameX.getOpacity() == 1.00;			// will change the opacity of the tile to 1, making it completely blank
        }

        public void open(Runnable actions) {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.2), imgGameX);
            ft.setToValue(1.0);
            ft.setOnFinished(e -> actions.run());
            ft.play();
        }

        public void close() {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.7), imgGameX);
            ft.setToValue(0);
            ft.play();
        }

        public boolean hasSameValue(Tile something) {
            //return text.getText().equals(something.text.getText());	// if both the tiles have the same value, this is passed
        	return imgGameX.getImage().equals(something.imgGameX.getImage());
        	
        }
    }

    public static void main(String[] args) {

        launch(args);
		
    }

}
