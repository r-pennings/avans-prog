import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Main extends Canvas {

	private static int frameWidth;
	private static int frameHeight;

	private static final int maxShapeSize = 100;
	private static final int minShapeSize = 25;

	private static ArrayList<Shape> shapes;

	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.width;
		frameHeight = screenSize.height;

		initShapes();

		JFrame frame = new JFrame();
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Canvas canvas = new Main();
		canvas.setSize(frameWidth, frameHeight);
		canvas.setBackground(getRandomColor());
		frame.add(canvas);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static Color getRandomColor() {
		Random random = new Random();

		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);

		return new Color(r, g, b).brighter();
	}

	public static int getRandomSize() {
		Random random = new Random();
		return ((random.nextInt(maxShapeSize) + 1) + minShapeSize);
	}

	public static int getRandomX(int width) {
		Random random = new Random();
		int maxPos = (frameWidth - width);

		return random.nextInt(maxPos);
	}

	public static int getRandomY(int height) {
		Random random = new Random();
		int maxPos = (frameHeight - height);

		return random.nextInt(maxPos);
	}

	public void paint(Graphics g) {
		for (Shape shape : shapes) {
			g.setColor(shape.getColor());

			if (shape.getShape() == ShapeType.Circle) {
				g.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			} else {
				g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			}
		}
	}

	private static void initShapes() {
		shapes = new ArrayList<Shape>();

		// Circles
		for (int i = 0; i < 5; i++) {
			int width = getRandomSize();
			int height = getRandomSize();

			int x = getRandomX(width);
			int y = getRandomY(height);

			Color color = getRandomColor();

			shapes.add(new Shape(x, y, width, height, color, ShapeType.Circle));
		}

		// Rectangles
		for (int i = 0; i < 5; i++) {
			int width = getRandomSize();
			int height = getRandomSize();

			int x = getRandomX(width);
			int y = getRandomY(height);
			System.out.println("W: " + width + ", H: " + height + ", X: " + x + ", Y: " + y);

			Color color = getRandomColor();

			shapes.add(new Shape(x, y, width, height, color, ShapeType.Rectangle));
		}
	}

}
