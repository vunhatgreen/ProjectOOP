package code;
import java.io.*;
import javax.sound.sampled.*;
   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class AddSound {
   
   // Constructor
   public AddSound(String url) {
//      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      this.setTitle("Test Sound Clip");
//      this.setSize(300, 200);
//      this.setVisible(true);
	   
      try {
         // Open an audio input stream.
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource(url));
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
}