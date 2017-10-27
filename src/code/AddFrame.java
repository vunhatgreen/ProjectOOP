package code;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import game.Game;

public class AddFrame extends Canvas {
	
	private static final long serialVersionUID = -8255319694373975038L;
	
	public AddFrame(int width, int               height, String title, boolean fullscreen, Game game) {
		JFrame frame = new JFrame(title);
		frame.getContentPane().setBackground(Color.BLACK);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		if(fullscreen == true) {
			frame.setLayout(new BorderLayout());

			frame.setUndecorated(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);	
//			int xsize = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
//			int ysize = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//			frame.setSize(xsize,ysize);
		}
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setCursor(frame.getToolkit().createCustomCursor(
	            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
	            "null"));
		
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}
