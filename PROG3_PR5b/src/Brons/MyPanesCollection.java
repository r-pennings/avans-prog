package Brons;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MyPanesCollection {
	private ArrayList<MyPane> panes;

	private MyPane BLUE;
	private MyPane GREEN;
	private MyPane YELLOW;
	private MyPane RED;
	private MyPane PURPLE;
	private MyPane ORANGE;

	public MyPanesCollection() {
		panes = new ArrayList<MyPane>();
		panes.add(new MyPane(Color.web("#4394f7"), "blauw"));
		panes.add(new MyPane(Color.web("#5fb731"), "groen"));
		panes.add(new MyPane(Color.web("#f2cc1f"), "geel"));
		panes.add(new MyPane(Color.web("#e54445"), "rood"));
		panes.add(new MyPane(Color.web("#a24dda"), "paars"));
		panes.add(new MyPane(Color.web("#ee7c16"), "oranje"));

		BLUE = panes.get(0);
		GREEN = panes.get(1);
		YELLOW = panes.get(2);
		RED = panes.get(3);
		PURPLE = panes.get(4);
		ORANGE = panes.get(5);
	}

	public FlowPane getFlowPane() {
		FlowPane flowPane = new FlowPane(5, 5);

		flowPane.getChildren().addAll(panes);
		flowPane.setAlignment(Pos.TOP_CENTER);

		setAbsolutePaneSize();

		return flowPane;
	}

	public BorderPane getBorderPane() {
		BorderPane borderPane = new BorderPane();

		borderPane.setTop(BLUE);
		borderPane.setLeft(GREEN);
		borderPane.setCenter(YELLOW);
		borderPane.setRight(RED);
		borderPane.setBottom(PURPLE);

		setComputedPaneSize();

		return borderPane;
	}

	public VBox getVBoxPane() {
		VBox vbox = new VBox();

		vbox.getChildren().addAll(panes);

		setComputedPaneSize();

		return vbox;
	}

	public HBox getHBoxPane() {
		HBox hbox = new HBox();

		hbox.getChildren().addAll(panes);

		setComputedPaneSize();

		return hbox;
	}

	public GridPane getGridPane() {
		GridPane gridPane = new GridPane();

		gridPane.add(BLUE, 0, 0, 1, 2);
		gridPane.add(GREEN, 1, 0);
		gridPane.add(ORANGE, 1, 1);
		gridPane.add(YELLOW, 2, 0, 1, 3);
		gridPane.add(PURPLE, 0, 2, 2, 1);
		gridPane.add(RED, 0, 3, 3, 1);

		setComputedPaneSize();

		return gridPane;
	}

	public TilePane getTilePane() {
		TilePane tilepane = new TilePane();

		tilepane.getChildren().addAll(panes);

		tilepane.setPrefTileWidth(MyScene.SCENEWIDTH / 3);
		tilepane.setPrefTileHeight(MyScene.SCENEHEIGHT / 2);

		setComputedPaneSize();

		return tilepane;
	}

	public Pane getStackPane() {
		StackPane stackpane = new StackPane(BLUE, GREEN, YELLOW, RED, PURPLE, ORANGE);

		setComputedPaneSize();

//		stackpane.getChildren().addAll(panes);

//		StackPane.setMargin(stackpane, new Insets(50, 100, 50, 100));
//
//		stackpane.setAlignment(Pos.CENTER);

		return stackpane;
	}

	public AnchorPane getAnchorPane() {
		AnchorPane anchorpane = new AnchorPane();

		setComputedPaneSize();

		// Anchor Blauw
		AnchorPane.setTopAnchor(BLUE, 0.0);
		AnchorPane.setLeftAnchor(BLUE, 20.0);
		AnchorPane.setBottomAnchor(BLUE, 0.0);

		// Anchor Geel
		double y_left = MyPane.PANEWIDTH + 40.0;
		AnchorPane.setTopAnchor(YELLOW, MyScene.SCENEHEIGHT - (MyPane.PANEHEIGHT * 2.5));
		AnchorPane.setLeftAnchor(YELLOW, y_left);
		AnchorPane.setBottomAnchor(YELLOW, 0.0);
		AnchorPane.setRightAnchor(YELLOW, y_left - MyPane.PANEWIDTH);
		
		// Anchor Rood
		double redHeight = 25.0;
		double bottomPadding = 20.0;

		AnchorPane.setTopAnchor(RED, MyScene.SCENEHEIGHT - redHeight - bottomPadding);
		AnchorPane.setRightAnchor(RED, 0.0);
		AnchorPane.setBottomAnchor(RED, 20.0);
		AnchorPane.setLeftAnchor(RED, 0.0);

		anchorpane.getChildren().addAll(panes);

		return anchorpane;
	}

	private void setAbsolutePaneSize() {
		for (MyPane p : panes) {
			// set absolute size restrictions
			p.setPrefSize(MyPane.PANEWIDTH, MyPane.PANEHEIGHT);
			p.setMinSize(MyPane.PANEWIDTH, MyPane.PANEHEIGHT);
			p.setMaxSize(MyPane.PANEWIDTH, MyPane.PANEHEIGHT);
		}
	}

	private void setComputedPaneSize() {
		for (MyPane p : panes) {
			// let javaFX compute the size
			p.setPrefSize(MyPane.PANEWIDTH, MyPane.PANEHEIGHT);
			p.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
			p.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		}
	}

}
