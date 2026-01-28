package masterMindB;
import java.util.Scanner;


public class masterMindB {
	
	public static void main(String[] args) {
		
		internal internal = new internal();
		// control codes -- inactive
		// int blank, white, black;
		// blank = 0;
		// white = 1;
		// black = 2;
		
		// color codes
		// int red, orange, yellow, green, blue, purple, pink, cyan, lime, brown;
		// red = 1;
		// orange = 2;
		// yellow = 3;
		// green = 4; 
		// blue = 5;
		// purple = 6;
		// pink = 7; -- inactive
		// cyan = 8; -- inactive
		// lime = 9; -- inactive
		// brown= 0; -- inactive
		
		// correction stack
		int correctionGreat = 0;
		int correctionGood = 0;
		
		// codes
		String keyCode;
		String inputCode;
		String outputCode;
		String constructCode; 
		
		// conditions
		boolean winner = false;
		boolean gameOver = false;
		boolean welcome = true;
		
		// modular
		int repeater;
		int checker;
		int mistakes;
		int attempts;
		int games;
		int codeLength = 0;
		
		// other variables
		String results = "";
		String correctionComment = "";
		String feedBackComment = "";
		String response;
		String userName = "bean (placeholder)";
		
		// set up.
		Scanner player = new Scanner(System.in);
		System.out.println("Please enter a username.");
		userName = player.nextLine(); 	
		System.out.println("special rules:");
		System.out.println("---   ---   ---   ---   ---   ---   ---   ---   ---   ---   ---   ---   ---");
		System.out.println("1. feedback is in a unspecified order,");
		System.out.println(" youll have to figure out what slot you have correct yourself!");
		System.out.println("");
		System.out.println("2. the code can not contain duplicate colors.");
		System.out.println("you can still put multiple of the same color down.");
		System.out.println("---   ---   ---   ---   ---   ---   ---   ---   ---   ---   ---   ---   ---");
		System.out.println("");
		// game
		
		for (games = 1; games < 10;) {
			
			keyCode = internal.codeGenerator(codeLength);
			
			if (welcome == true) {
				System.out.println("Game start, good luck "+userName+"!");
			}
			else {
				System.out.println("Game start, lets see if you do better.");
			}
			
			System.out.println(" ");
			System.out.println("Your options are:");
			System.out.println("-red, orange, yellow, green, blue, purple.-");
			constructCode = "";
			mistakes = 0;
			
			
			for (attempts = 10; attempts > 0;) {	
				for (repeater = 0; repeater < 4;) {
					inputCode = player.nextLine();
					outputCode = (internal.colorToNumber(inputCode));
					if (outputCode .equals("error")) {
						System.out.println(internal.spellingComment(mistakes));	
						mistakes = (mistakes + 1);
					}
					else {
						constructCode = constructCode+outputCode;
						repeater++;
					}
					
				}
				
				
				for (checker = 0; checker < 4;) {
					char guesedCharacter = constructCode.charAt(checker);
					char correctCharacter = keyCode.charAt(checker);
					if (guesedCharacter == correctCharacter) {
						correctionGreat = correctionGreat + 1;
					}
					else if (keyCode.indexOf(guesedCharacter) != -1) {
						correctionGood = correctionGood + 1;
					}
					
					checker++;
				}
				
				if (correctionGreat == 4) {
					winner = true;
				}
				
				results = internal.feedBackGen(correctionGreat,correctionGood,results);
				
				System.out.println(results);
				System.out.println(" ");
				
				if (winner == true) {
					correctionComment = "Okay. great. you got it, good job.";
					attempts = 0;
					gameOver = true;
				}
				
				else {
					correctionComment = "that wasn't quite right.";
					System.out.println(correctionComment);
					attempts = attempts - 1;
					System.out.println("lives left: " + attempts);
					
					if (attempts == 0) {
						gameOver = true;
					}
					
				}
				
				if (gameOver == true) {
					if (winner == true) {
						feedBackComment = "in that case...";
					}
					else if (winner == false) {
						feedBackComment = "You lost, that's too bad!";
					}
				}
				
				System.out.println(feedBackComment);
				System.out.println(" ");
				constructCode = "";
				results = "";
				checker = 0;
				repeater = 0;
				correctionGreat = 0;
				correctionGood = 0;
			}
			
			if (games < 10) {
				System.out.println("play again?");
				response = player.nextLine();
				if (response.equals("no") || response.equals("n") || response.equals("stop")) {
					games = 999999999;
				}
				attempts = 12;
			}
			
			welcome = false;
		}	
		
		player.close();
		System.out.println("you quit the game.");
	}

}
