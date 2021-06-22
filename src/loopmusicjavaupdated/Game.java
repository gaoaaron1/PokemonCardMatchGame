package loopmusicjavaupdated;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Game extends Application {
	
	private static final int NUM_OF_PAIRS = 8;
	private static final int NUM_PER_ROW = 4;
	
	
	
	private Tile selected = null;
	private int clickCount = 2;
	public int cardType = 1;
	
	public ImageView imageView;
	
	
	Image img = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
	Image img2 = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Charmander.png");
	
	
	
	
	
	private Parent createContent() {
		/*
		ImageView iv = new ImageView();
		Image image = new Image("file:1H.png");
		iv.setImage(image);
		//pane.getChildren().add(iv);
		iv.setImage(image);
		iv.setRotate(90);
		iv.setPreserveRatio(true);
		iv.setFitWidth(300);
	//	iv.setFitHeight(150);*/
		
		Pane root = new Pane();
		root.setPrefSize(600, 600);
		
		
		
		char c = '1';
		List<Tile> tiles = new ArrayList<>();
		for (int i = 0;i<NUM_OF_PAIRS;i++)	{
			 tiles.add(new Tile(String.valueOf(c)));      // or Tile(C+"")
			 tiles.add(new Tile(String.valueOf(c))); 
			 c++;			
		}
		
		Collections.shuffle(tiles);
		for (int i = 0; i<tiles.size() ;i++) {
			Tile tile = tiles.get(i);
			tile.setTranslateX(150*(i%NUM_PER_ROW));
			tile.setTranslateY(150*(i/NUM_PER_ROW));
			root.getChildren().add(tile);
			
			
			ImageView imgGame = new ImageView(img);
        	imgGame.setImage(img);
        	imgGame.setFitHeight(100);
        	imgGame.setFitWidth(100);
        	tile.getChildren().add(imgGame);
		
			/*
			if (cardType == 0) {
				ImageView imgGame = new ImageView(img);
            	imgGame.setImage(img);
            	imgGame.setFitHeight(100);
            	imgGame.setFitWidth(100);
            	tile.getChildren().add(imgGame);
			}
			
			else if (cardType == 1) {
				ImageView imgGame2 = new ImageView(img2);
            	imgGame2.setImage(img2);
            	imgGame2.setFitHeight(100);
            	imgGame2.setFitWidth(100);
            	tile.getChildren().add(imgGame2);
			}
			*/
			
			System.out.println(tiles);
            
		}
		
		return root;
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		/*
	    String path = ("C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Poketheme.wav"); 
        Media media = new Media(new File(path).toURI().toString());  
        MediaPlayer mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.setAutoPlay(true);  
        */
	    
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
		
			
	}
	
	private class Tile extends StackPane {
		private Text text = new Text();
		
		public Tile(String value) {
			Rectangle border = new Rectangle (150,150);
			border.setFill(null);
			border.setStroke(Color.BLUE);
			
			
			text.setText(value);
			text.setFont(Font.font(30));
			
			setAlignment(Pos.CENTER);
			getChildren().addAll(border,text);
			
			setOnMouseClicked(this::handleMouseClick);
				
			
			close();
			
		}
		
		public void handleMouseClick(MouseEvent event) {
			if (isOpen() || clickCount==0)
				return;
			clickCount--;
			
			if (selected ==null) {
				selected = this;
				open(()->{});
			}else {
				open(()->{});
					if (!hasSameValue(selected)) {
						selected.close();
						this.close();

					
				}
					selected =null;
					clickCount=2;
			}
		}
		
		public boolean isOpen() {
			String textID = text.getText();
			int textValue = Integer.parseInt(textID);
			
			System.out.println(textValue);
			
			if (textValue == 1) {
				System.out.println("True");
				cardType = 1;
				
				
				
			}
			
			System.out.println(textID);
			return text.getOpacity()==1;
			
			
		}
		
		
		public void open(Runnable action) {
			FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(0.5);
            ft.setOnFinished(e -> action.run());
            ft.play();
		}
		public void close() {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(0);
            ft.play();
        }
		
		
		public boolean hasSameValue(Tile other) {
			return text.getText().equals(other.text.getText());
			
		}
	}
	
	
    public static void run() {
        
    	String filepath = ("C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\Poketheme.wav");
        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath);
    }
	
	public static void main(String [] args) {
		
			run();
			
			launch(args);
	}

	
}
