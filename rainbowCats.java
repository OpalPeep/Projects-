package Nya;

import java.util.Random;
import javax.management.timer.Timer;

public class rainbowCats {

	public static void main(String args[]){
		Random rando = new Random();
		int amount = rando.nextInt(1000);
	    int nps = rando.nextInt(10);
	    int cat = 1;
	    if(nps == 0){nps = 1;}
    	if(amount == 0){amount = 1;}
	    while(cat == cat){
	    		if(amount == 0){System.exit(0);}
		    	System.out.println("nya");
		    	amount = amount - 1;
	    	    try {
	    			Thread.sleep(Timer.ONE_SECOND / nps);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    }
	}
}
