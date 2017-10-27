package code;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class AddImage extends Canvas{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int reWidth;
	private int reHeight;
	private String url;
	
	public AddImage(int x, int y, String url, Graphics g) {
		this.x = x;
		this.y = y;
		this.url = url;
		doPaint(g);
	}
	public AddImage(int x, int y, int reWidth, int reHeight, String addr, Graphics g) {
		this.x = x;
		this.y = y;
		this.reWidth = reWidth;
		this.reHeight = reHeight;
		this.url = addr;
		rePaint(g);
	}
	public void doPaint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage(this.url);
		g.drawImage(img, this.x, this.y, this);
	}
	public void rePaint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage(this.url);
		g.drawImage(img, this.x, this.y, this.reWidth,this.reHeight, this);
	}
}
