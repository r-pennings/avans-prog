package zilver;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

public class MyScene extends Scene {

	private static BorderPane root = new BorderPane();
	
	private ButtonPane buttonPane;
	private DrawPane drawPane;
	
	public MyScene(Controller controller) {
		super(root);
		
		root.setPrefSize(400, 400);
		
		drawPane = new DrawPane();
		buttonPane = new ButtonPane(controller, this, drawPane);
		
		MenuBar menu = createMenu();
		
		root.setTop(menu);
		root.setCenter(drawPane);
		root.setBottom(buttonPane);
	}
	
	private MenuBar createMenu() {
		MenuBar menu = new MenuBar();
		
		Menu file = new Menu("File");
		MenuItem exit = new MenuItem("Exit");
		file.getItems().add(exit);
		
		Menu effect = new Menu("Effects");
		ToggleGroup effectGroup = new ToggleGroup();
		
		RadioMenuItem grayscale = new RadioMenuItem("GrayScale");
		grayscale.setToggleGroup(effectGroup);
		grayscale.setOnAction(e -> drawPane.setGrayScale());
		
		RadioMenuItem fullcolor = new RadioMenuItem("FullColor");
		fullcolor.setToggleGroup(effectGroup);
		fullcolor.setSelected(true);
		fullcolor.setOnAction(e -> drawPane.setFullColor());
		
		effect.getItems().add(grayscale);
		effect.getItems().add(fullcolor);
		
		menu.getMenus().add(file);
		menu.getMenus().add(effect);
		
		return menu;
	}
}
