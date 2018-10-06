//JANE SMYTH
//C00208290

package CalculatorProject;

import javax.swing.JOptionPane;

//HAVE A CLASS WITH ALL CALCULATIONS IN ONE CLASS FOR CALCULATOR PROJECT


public class Calculations
{
	private static String current="";
	private static Double valueA = 0.0;
	private static Double valueB=0.0;
	private static String resultStr="";
	private static String task="";
	private static int decClickCount=0;
	private static char charValue;
	private static Double answer=null;
	private static Double memoryValue=0D;
	private static String prevCurrent;



	
	public Calculations () {
	}
	 
		public static String inputVal (String textBoxValue)
		{
			if(textBoxValue.charAt(0) =='.')
			{
				decClickCount++;
			}
			if(textBoxValue.charAt(0) >= '0' && textBoxValue.charAt(0) <='9')
			{
				current += textBoxValue;
				return current;
				
			}
			
			charValue =textBoxValue.charAt(0);
													
			switch(textBoxValue)
			{
			case "+":
				try {
				
				if(task=="") 
				{
				valueA=Double.parseDouble(current);	
				
				}
				
				else {
					valueB=Double.parseDouble(current);
					add(valueA,valueB);
					valueA=answer; 
					}
					
				}
				
				catch (NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null, nfe, "Error Message", JOptionPane.ERROR_MESSAGE);
				}
	
				current="";
				task="Plus";
				decClickCount=0;
				return current;
				
				
			case "-":
				try {
				
				if(task=="") 
				{
				valueA=Double.parseDouble(current);	
				}
				else {
					valueB=Double.parseDouble(current);
					subtract(valueA,valueB);
					valueA=answer; 
					}
				}
				catch (NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null, nfe, "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				current="";
				task="Minus";
				decClickCount=0;
				return current;
				
			case "x":
				try {
				
				if(task=="") {
	
				valueA=Double.parseDouble(current);	
				
				}
				else {
					valueB=Double.parseDouble(current);
					multiply(valueA,valueB);
					valueA=answer; 
					}
					
				}
				catch (NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null, nfe, "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				
				current="";
				task="Multiply";
				decClickCount=0;
				return current;

			case "\u00F7"://Unicode for divide symbol
				try {
				
				
				if(task=="") 
				{
				valueA=Double.parseDouble(current);
				
				}
				else {
				valueB=Double.parseDouble(current);
				divide(valueA,valueB);
				valueA=answer;
				}
				}
				catch (NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null, nfe, "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				current="";
				task="Divide";
				decClickCount=0;
				return current;

				
			case ".":
				if(decClickCount<=1)
				{
					current+='.';	
				}
					return current;//returns current value without the additional decimal point as there can only be one
				
			case "\u00B1"://negative symbol
				Negate();
				return current;
				
				
			case "AC"://clear 
					clearAll();
					return current;
			
			case "MRC"://memory recall=>displays current value stored in memory
				current="";
				return memoryValue.toString();
				
			case "M+"://memory adds=> adds current value to memory/pluses current value to value already in memory
				if(current!="")
				{
				memoryValue+=Double.parseDouble(current);
				prevCurrent=current;
				current="";
				return prevCurrent;
				}
				else
					return current;
			case "M-"://memory subtract=> replaces memory value that is stored with memory value minus current value
				if(current != "") {
				memoryValue=memoryValue-Double.parseDouble(current);
				prevCurrent=current;
				current="";
				return prevCurrent;
				}
				else
					return current;
				
				
			case "MC": //memory Clear=> clears memory value
				memoryValue=0D;
				return current;//leaves any value user has already entered on screen
				//but clears memory value for example, number 8 is in memory, 
				//user clicks 9 but then decides to clear the memory function, the number 9 stays
				//on screen but memory will be cleared so if MRC is call
			
				
			case "=":
				try {
				Calcs(task);
				
				resultStr=answer.toString();
				answer=null;
				return resultStr;	
				}
				catch (Exception dbze)
				{
					JOptionPane.showMessageDialog(null, dbze, "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				catch (NullPointerException npe)
				{
					JOptionPane.showMessageDialog(null, npe, "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				catch (NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null, nfe, "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				task = "";
				valueA= 0D; //0 double 
				valueB=0D;	//0 double
				decClickCount=0;
				current="";
				
			case "\u232B"://backspace
				if(current.length() >0) {
				current = current.substring(0, current.length()-1);
				}
				return current;
				
			}
			return resultStr;
			
		}

		
		public static void add(double a, double b)
		{
			answer= a+b;
		}

		public static void subtract(double a, double b)
		{
			answer= a-b;
		}
		public static void multiply(double a, double b)
		{
			answer= a*b;
		}
		public static void divide(double a, double b) throws Exception
		{
			if(b==0)
				throw new Exception();
			answer=a/b;
		}
		public static void clearAll()//for AC button
		{
			current="";
			task = "";
			valueA= 0D;
			valueB=0D;
			answer=null;
			decClickCount=0;
		}
		
		public static void Negate()
		{
				if(current== "")//if there are no numbers already in the Calulators textbox 
					//as negative symbol must go before number, cannot have 5(-)4
				{
					current ="-";
				}
				
		}
		public static void Calcs(String task) //calculations
		{
			valueB=Double.parseDouble(current);
			switch(task) {
			case "Plus":
				add(valueA, valueB);
				break;
			case "Minus":
				subtract(valueA, valueB);
				break;
			case "Multiply":
				multiply(valueA, valueB);
				break;
			case "Divide":
				divide(valueA,valueB);
				break;
			default:
				current="";
			}
			
		}

}
