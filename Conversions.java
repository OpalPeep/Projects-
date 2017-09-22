package exporting;

import java.util.Scanner;
/*
 * @author George West
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
		System.out.println("What type of conversion do you want to do? Fahrenheight to Celsius, (f-c)");
		System.out.println("or Celsius to Fahrenheight. (c-f)");
		type = scan.next();
		switch(type){
		case "Stop" : System.exit(0);
		break;
		case "f-c" : t = true; break;
		case "c-f" : t = true; break;
		default : System.out.println("Error, imput a valid conversion type"); break;
		}
		}
		s = false;
		while(s == false){
		System.out.println("What temperature do you want to convert?");
		String temp2 = scan.next();
		for(int i = 0; i <= temp2.length(); i++){
		//Number overflow exception V1
		if(temp2.length() >= -Integer.MAX_VALUE / 10)	{
			s = false;
			break;
		}
		boolean l = true;
		//Stop using letters V1
		switch(temp2.charAt(i)){
		case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': l = false; s = true; break;
		default : l = false; break;
		}		
		if(l == false)break;
		}
		if(s == true){
		temp = Integer.parseInt(temp2);
		Conversions.math(temp, type);
		}
		//Number overflow exception V2
		else if(temp2.length() >= -Integer.MAX_VALUE / 10)	{
			System.out.print("Try again, this number is too large");
		}
		//Stop using letters V2
		else{
			System.out.println("Please use real numbers for this perameter");
		}
		}
	}
}
}