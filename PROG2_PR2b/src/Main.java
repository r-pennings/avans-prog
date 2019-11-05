import java.awt.*;

import javax.swing.*;

public class Main extends Canvas {
	
	private static final int height = 400;
	private static final int width = 400;
	
	private static final int circleWidth = 100;
	private static final int circleHeight = 100;
	
	private static final int squareWidth = 100;
	private static final int squareHeight = 100;

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(squareHeight, squareWidth, squareHeight, squareWidth);
		
		g.setColor(Color.YELLOW);
		g.fillOval(0, 0, circleHeight, circleWidth);
		
		g.setColor(Color.BLUE);
		g.drawLine(0, 0, height, width);
		
		g.setColor(Color.BLACK);
		g.drawString("Mijn naam is Roel!", width - 200, height - 100);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		Canvas canvas = new Main();
		canvas.setSize(height, width);
		frame.add(canvas);
		
		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

}
