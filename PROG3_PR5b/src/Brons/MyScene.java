package Brons;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MyScene extends Scene {

	private MyPanesCollection myPanesCollection = new MyPanesCollection();
	private MenuBar menuBar;

	public static final int SCENEWIDTH = 400;
	public static final int SCENEHEIGHT = 400;
	
	public MyScene(Main main, Pane pane, Color gray) {
		super(pane, SCENEWIDTH, SCENEHEIGHT, gray);

		createMenu();
		
		((VBox) this.getRoot()).getChildren().add(menuBar);
		((VBox) this.getRoot()).getChildren().add(myPanesCollection.getFlowPane());
	}

	private void createMenu() {
		Menu fileMenu = new Menu("File");
		MenuItem exitItem = new MenuItem("Exit");
		exitItem.setOnAction(e -> handleExit());
		fileMenu.getItems().add(exitItem);

		Menu layoutMenu = new Menu("Layout");
		
		MenuItem flowPaneItem = new MenuItem("FlowPane");
		flowPaneItem.setOnAction(e -> handleFlowPaneItem());
		layoutMenu.getItems().add(flowPaneItem);

		MenuItem borderPaneItem = new MenuItem("BorderPane");
		borderPaneItem.setOnAction(e -> handleBorderPaneItem());
		layoutMenu.getItems().add(borderPaneItem);

		MenuItem vBoxItem = new MenuItem("VBox");
		vBoxItem.setOnAction(e -> handleVBoxPaneItem());
		layoutMenu.getItems().add(vBoxItem);

		MenuItem hBoxItem = new MenuItem("HBox");
		hBoxItem.setOnAction(e -> handleHBoxPaneItem());
		layoutMenu.getItems().add(hBoxItem);

		MenuItem gridPaneItem = new MenuItem("GridPane");
		gridPaneItem.setOnAction(e -> handleGridPaneItem());
		layoutMenu.getItems().add(gridPaneItem);

		MenuItem tilePaneItem = new MenuItem("TilePane");
		tilePaneItem.setOnAction(e -> handleTilePaneItem());
		layoutMenu.getItems().add(tilePaneItem);

		MenuItem stackPaneItem = new MenuItem("StackPane");
		stackPaneItem.setOnAction(e -> handleStackPaneItem());
		layoutMenu.getItems().add(stackPaneItem);

		MenuItem anchorPaneItem = new MenuItem("AnchorPane");
		anchorPaneItem.setOnAction(e -> handleAnchorPaneItem());
		layoutMenu.getItems().add(anchorPaneItem);

		menuBar = new MenuBar(fileMenu, layoutMenu);
	}

	private void handleFlowPaneItem() {
		changePane(myPanesCollection.getFlowPane());
	}

	private void handleBorderPaneItem() {
		changePane(myPanesCollection.getBorderPane());
	}

	private void handleVBoxPaneItem() {
		changePane(myPanesCollection.getVBoxPane());
	}

	private void handleHBoxPaneItem() {
		changePane(myPanesCollection.getHBoxPane());
	}

	private void handleGridPaneItem() {
		changePane(myPanesCollection.getGridPane());
	}

	private void handleTilePaneItem() {
		changePane(myPanesCollection.getTilePane());
	}

	private void handleStackPaneItem() {
		changePane(myPanesCollection.getStackPane());
	}

	private void handleAnchorPaneItem() {
		changePane(myPanesCollection.getAnchorPane());
	}

	private void handleExit() {
		Platform.exit();
	}

	private void changePane(Pane pane) {
		pane.setPrefSize(getWidth(), getHeight());
		setRoot(new VBox(menuBar, pane));
	}
}
