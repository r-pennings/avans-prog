import java.awt.Color;

public class Shape {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private ShapeType shape;

	public Shape(int x, int y, int width, int height, Color color, ShapeType shape) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.shape = shape;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Color getColor() {
		return color;
	}

	public ShapeType getShape() {
		return shape;
	}
}
