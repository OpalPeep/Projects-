package SoundBoard;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.text.ParseException;

public class FileProcessing {
	
	/**
	 * Use TBA, I think it will be used eventually
	 */
	public byte[] scanForByte(){
		File file = new File("Texts/*");
		Path files = file.toPath();
		byte[] Data = new byte[(int) file.length()]; 
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(files, charset)) {
		    String line = null;
		    int i = 0;
		    while ((line = reader.readLine()) != null) {
		    	//NumberFormat is better due to its cutting off at unparseable symbols.
		    	Data[i] = NumberFormat.getInstance().parse(line).byteValue();
		        i++;
		        //Moved System Output below int uptick for the sake of readability (Normies).
		        System.out.println(i + ": " + Data[i - 1]);
		    }
		} catch (IOException | ParseException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return Data;
	}
	
	/**
	 * Function used for scanning save files for player data.
	 */
	public static String[] scanForString(String fileName){
		File file = new File(fileName);
		Path files = file.toPath();
		String[] Data = new String[(int) file.length()]; 
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(files, charset)) {
		    String line = null;
		    int i = 0;
		    while ((line = reader.readLine()) != null) {
		    	Data[i] = line;
		        System.out.println(i + ": " + Data[i]);
		        i++;
		        //Moved System Output below int uptick for the sake of readability (Normies)(Redacted).
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return Data;
	}

}
