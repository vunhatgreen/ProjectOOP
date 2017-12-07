package state;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
public class Sound {
	private Player player;
    private String filename;
    
    public Sound(String filename) {
        this.filename = filename;
    }
    
    public void stop() {
        if (player != null)
            player.close();
    }
    
    public void play() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(bis);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }).start();
    }
}
