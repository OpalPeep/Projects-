package test;

import java.util.Scanner;
/* @version 1.2
 * @author N/A
 * This program converts Fahrenheit to Celsius
 */
public class Conversions {
	public static void math(double temp, String type){
		//converts and prints the result
	double mainT = temp;
	double product = 0;
	switch(type){
	case "c-f" : product = (((mainT * 9) / 5) + 32);
		break;
	case "f-c" : product = ((mainT - 32) * 5) / 9;
		break;
		//Last ditch error stopping, I do not believe anything can filter to this point, but I am not certain
	default : System.out.println("Error, imput a valid conversion type");
	return;
	}
	System.out.println(temp + " -- " + product);
	}
	
	public static void main(String [] args){
		//Gets user input, then passes to "math"
		boolean s = false;
		double temp = 0;
		String type = "2";
		Scanner scan = new Scanner(System.in);
		
		while(1 == 1 ){
		boolean t = false;
		while(t == false){
		System.out.println("What type of conversion do you want to do? Fahrenheit to Celsius, (f-c)");
		System.out.println("or Celsius to Fahrenheight. (c-f)");
		type = scan.next();
		
		switch(type){
		case "Stop" : scan.close(); System.exit(0);
		break;
		case "f-c" : t = true; break;
		case "c-f" : t = true; break;
		default : System.out.println("Error, imput a valid conversion type"); break;
		}
		}
		s = false;
		
		while(s == false){
	    boolean l = false; 
		System.out.println("What temperature do you want to convert?");
		String temp2 = scan.next();
		switch(temp2.charAt(0)){
		 case '+': case '-':  l = true; break;
		 default : break;
		}
		
		for(int i = 0; i < temp2.length(); i++){
		//Number overflow exception V1
			if(l == true){
				l = false; 
				i++;
			}
		if(temp2.length() <= -Integer.MAX_VALUE / 10 || temp2.length() >= Integer.MAX_VALUE / 10 )	{
			s = false;
			break;
		}
		boolean m = true;
		//Stop using letters V1
		System.out.println(i);
		System.out.println(temp2.charAt(i));
		switch(temp2.charAt(i)){
		case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '.': s = true; break;
        default : m = false; s = false; break;
		}		
		if(m == false){ s = false; System.out.println("Break");break;}
		}
		if(s == true){
			//Number overflow exception V2
			if(temp2.length() <= -Integer.MAX_VALUE / 10 || temp2.length() >= Integer.MAX_VALUE / 10 )	{
				System.out.println("Try again, this number is too large");
			}
		temp = Double.parseDouble(temp2);
		Conversions.math(temp, type);
		}
		//Stop using letters V2
		else{
			System.out.println("Please use real numbers for this perameter");
		}
		}
	}
}
}
