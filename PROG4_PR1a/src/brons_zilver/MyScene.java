package brons_zilver;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MyScene extends Scene {
	
	public MyScene(BorderPane root) {
		super(root);
		
		DrawPane drawPane = new DrawPane();
		ControlPane controlPane = new ControlPane(drawPane);
		
		root.setLeft(drawPane);
		root.setRight(controlPane);
	}

}
