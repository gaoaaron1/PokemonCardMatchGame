package gui;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import drivers.Main;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class baseScene extends JPanel {
	private Scene scene;
	Main menu;
	boolean maintheme = true;
	
	public baseScene(Main menu) {
		this.menu = menu;
	}
	
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Main getMenu() {
		return menu;
	}

	public void setMenu(Main menu) {
		this.menu = menu;
	}
	
	public abstract void setup();
	
	protected void display() {
		
		menu.setScene(this.scene);
	}
}
