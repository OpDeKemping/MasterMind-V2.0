package masterMindB;

import java.util.Scanner;
import java.util.Random;

public class internal {
	
	
	public String codeGenerator(int length) {
		int codePicker;
		String x = "";
		for (length = 0; length < 4;) {
			codePicker = (int) (Math.random() * 7);
			if (x.indexOf(Integer.toString(codePicker)) == -1) {
				x = x + codePicker;
				length++;
			}
		}
		return x;
	}
	
	public String colorToNumber(String input) {
			String output;
			if (input.equalsIgnoreCase("red") ) {
				output = "1";
			}
			else if (input.equalsIgnoreCase("orange") ) {
				output = "2";
			}
			else if (input.equalsIgnoreCase("yellow") ) {
				output = "3";
			}
			else if (input.equalsIgnoreCase("green") ) {
				output = "4";
			}
			else if (input.equalsIgnoreCase("blue") ) {
				output = "5";
			}
			else if (input.equalsIgnoreCase("purple") ) {
				output = "6";
			}
			else {
				output = "error";
			}
			
			return output;
		
	}
	
	public String spellingComment(int faults) {
		String response = "";
		if (faults == 0) {
			System.out.println("Check your spelling (one at a time)");	
		}
		else if (faults == 1) {
			response = ("Please try that again.");	
		}
		else if (faults == 2) {
			response = ("Spelling error, try again.");	
		}
		else if (faults == 3) {
			response = ("Spelling error, try again.");	
		}
		else if (faults == 4) {
			response = ("Spelling error, try again.");	
		}
		else if (faults == 5) {
			response = ("Spelling error, try again.");	
		}
		else if (faults == 6) {
			response = ("Spelling error, try again. (please stop)");	
		}
		else if (faults == 7) {
			response = ("Just try again.");	
		}
		else if (faults == 8) {
			response = ("come on, you should be able to get the spelling right by now.");	
		}
		else if (faults == 9) {
			response = ("spelling.");	
		}
		else if (faults > 9) {
			response = ("Spelling error.   :( ");	
		}
		
		return response;
		
	}
	
	public String feedBackGen(int great,int good,String result) {
		int printer;
		for (printer = 0;  printer < 4;) {
			if (great > 0) {
				result = result + "black,";
				great = great - 1;
			}
			else if (good > 0) {
				result = result + "white,";
				good = good - 1;
			}
			else {
				result = result + "x,";
			}
			
			printer++;
		}
		result = result + "-";
		return result;
	}
	
}