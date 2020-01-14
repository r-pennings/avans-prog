package brons;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MyScene extends Scene {

	private static BorderPane root = new BorderPane();
	
	private ButtonPane buttonPane;
	private DrawPane drawPane;
	
	public MyScene(Controller controller, Message message) {
		super(root);
		
		buttonPane = new ButtonPane(controller);
		drawPane = new DrawPane(message);
		
		root.setTop(drawPane);
		root.setBottom(buttonPane);
	}
}
