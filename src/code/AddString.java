package code;
import java.awt.Color;
import java.awt.Graphics;

public class AddString{
	private int x;
	private int y;
	private String string;
	private String colorHexcode;
	
	public AddString(int x, int y, String colorHexcode, String string, Graphics g) {
		this.x = x;
		this.y = y;
		this.string = string;
		this.colorHexcode = colorHexcode;
		paint(g);
	}
	public void paint(Graphics g) {
		g.setColor(Color.decode(colorHexcode));
		g.drawString(string, x, y);
		g.setColor(Color.WHITE);
	}

}
