package SoundBoard;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class FilePlayer {
	Hashtable<String, AudioInputStream> audioTable = new Hashtable<String, AudioInputStream>(10,10);

	public void loadClip (String fileToLoad, String index) {
		File file = new File(fileToLoad);
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			audioTable.put(index, stream);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void playClip(String index) {
	Clip clip = null;
	DataLine.Info info = new DataLine.Info(Clip.class, null); 	
    LineListener lineListener = new LineListener() {
		
		@Override
		public void update(LineEvent event) {
			if(event.getType() == Type.STOP) {
				event.getLine().close();
			}
		}
	};
        try {
        	clip =  (Clip) AudioSystem.getLine(info);
        	clip.open(audioTable.get(index));
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    clip.addLineListener(lineListener);
    clip.start();   
	}
}
