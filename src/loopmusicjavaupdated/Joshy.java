package loopmusicjavaupdated;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;



public class Joshy extends Application {
	
	final int numOfRows = 5;
	final int numOfColumns = 4;

	GridPane grid = new GridPane();

	ArrayList<ImageView> back = new ArrayList<>();
	ArrayList<Image> iv = new ArrayList<>();
	ArrayList<ImageView> checkImage = new ArrayList<>();

	int i;
	int counter = 0;
	int scoreKpr=0;

	Text score = new Text();

	Image image;


	public void start(Stage primaryStage) throws FileNotFoundException {

		FileInputStream input = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
		FileInputStream one = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard2.png");
		FileInputStream two = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
		FileInputStream three = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
		FileInputStream four = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
		FileInputStream five = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
		FileInputStream six = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
		FileInputStream seven = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
		FileInputStream eight = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
		FileInputStream nine = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");
		FileInputStream ten = new FileInputStream("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\PokemonCard.png");

		image = new Image(input);


		iv.add(new Image(one));
		iv.add(new Image(two));
		iv.add(new Image(three));
		iv.add(new Image(four));
		iv.add(new Image(five));
		iv.add(new Image(six));
		iv.add(new Image(seven));
		iv.add(new Image(eight));
		iv.add(new Image(nine));
		iv.add(new Image(ten));
		iv.add(iv.get(0));
		iv.add(iv.get(1));
		iv.add(iv.get(2));
		iv.add(iv.get(3));
		iv.add(iv.get(4));
		iv.add(iv.get(5));
		iv.add(iv.get(6));
		iv.add(iv.get(7));
		iv.add(iv.get(8));
		iv.add(iv.get(9));


		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));
		back.add(new ImageView(image));


	//shuffling images
	Collections.shuffle(iv);

	grid.setAlignment(Pos.TOP_CENTER);
	grid.setGridLinesVisible(false);
	score.setTextAlignment(TextAlignment.RIGHT);
	score.maxWidth(100);
	grid.add(score, 1, 4);


	//adding columns and rows.
	for(int i = 0; i < numOfRows-1; i++ ){
	RowConstraints rc = new RowConstraints();
	rc.setPercentHeight(100/numOfRows+3);
	grid.getRowConstraints().add(rc);
	}

	for(int i = 0; i < numOfColumns; i++){
	ColumnConstraints cc = new ColumnConstraints();
	cc.setPercentWidth(100/numOfColumns);
	grid.getColumnConstraints().add(cc);
	}


	//adding button.
	Button qBtn = new Button();
	qBtn.setAlignment(Pos.CENTER);
	qBtn.setText("Quit");
	qBtn.setMaxWidth(100);
	grid.add(qBtn, 3, 4);

	//setting imageview
	imageSet();


	//setting button action
	qBtn.setOnAction(e ->{
	primaryStage.close();
	});

	//click listener
	OnClick();


	//primary stage setup.
	primaryStage.setScene(new Scene(grid, 800, 800));
	primaryStage.show();
	primaryStage.setTitle("Memory Master");

	}

	private void OnClick(){
	//checking for click
	back.get(0).setOnMouseClicked(e->{
	back.get(0).setImage(iv.get(0));
	if(counter == 0){
	checkImage.add(back.get(0));
	counter++;
	}
	if(counter == 1){
	checkImage.add(back.get(0));
	counter = 0;
	if(checkImage.get(0).equals(checkImage.get(1))){
	scoreKpr++;
	}
	}
	else{
	back.get(0).setImage(image);
	}


	});


	//code for click listener.

	back.get(1).setOnMouseClicked(e->{
	back.get(1).setImage(iv.get(1));
	if(counter == 0){
		checkImage.add(back.get(0));
		counter++;
	}
	else if(counter == 1){
		checkImage.add(back.get(0));
		counter = 0;
	
		if(checkImage.get(0).equals(checkImage.get(1))){
			scoreKpr++;
			}
	}
	
	else{
		back.get(0).setImage(image);
		}

		});

		back.get(2).setOnMouseClicked(e->{
			back.get(2).setImage(iv.get(2));
	});

	back.get(3).setOnMouseClicked(e->{
	back.get(3).setImage(iv.get(3));
	});

	back.get(4).setOnMouseClicked(e->{
	back.get(4).setImage(iv.get(4));
	});

	back.get(5).setOnMouseClicked(e->{
	back.get(5).setImage(iv.get(5));
	});

	back.get(6).setOnMouseClicked(e->{
	back.get(6).setImage(iv.get(6));
	});

	back.get(7).setOnMouseClicked(e->{
	back.get(7).setImage(iv.get(7));
	});

	back.get(8).setOnMouseClicked(e->{
	back.get(8).setImage(iv.get(8));
	});

	back.get(9).setOnMouseClicked(e->{
	back.get(9).setImage(iv.get(9));
	});

	back.get(10).setOnMouseClicked(e->{
	back.get(10).setImage(iv.get(10));
	});

	back.get(11).setOnMouseClicked(e->{
	back.get(11).setImage(iv.get(11));
	});

	back.get(12).setOnMouseClicked(e->{
	back.get(12).setImage(iv.get(12));
	});

	back.get(13).setOnMouseClicked(e->{
	back.get(13).setImage(iv.get(13));
	});

	back.get(14).setOnMouseClicked(e->{
	back.get(14).setImage(iv.get(14));
	});

	back.get(15).setOnMouseClicked(e->{
	back.get(15).setImage(iv.get(15));
	});
	}

	private void imageSet(){
		int count = 0;
		for(int i = 0; i < 4; i++ ){
			for(int j = 0; j < 4; j++ ){
				back.get(count).setFitHeight(140);
				back.get(count).setFitWidth(125);
				grid.add(back.get(count), i, j);
				count++;
			}
		}
	}

	
	
	public static void main(String [] args) {
		
			launch(args);
	}

	
}
