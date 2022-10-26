import java.util.Scanner;
public class NumberGuesser{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int inp;
		while(true){
		int totalAttempts = 5;
		int attempts = 0;
		int userInput = 0;
		int matchScore = 1000;
		int unmatchScore = 200;
		int attemptDeduction = 100;
		int score = 0;
		int randomNum = (int)(Math.random() * 99 + 1);
		System.out.println("Welcome to the Guess Game\nYou will be asked to guess a number to win the game \nYou have maximum 5 attempts");
		do{
			System.out.println("Enter a number between 1 to 100");
			userInput = sc.nextInt();
			score -= attemptDeduction;
			if(userInput == randomNum){
				score += matchScore;
				System.out.println("Hurray!!!!!!! \n It's a match \n Your Score is " + score);
				break;
			}
			else if(userInput < randomNum){
				score += unmatchScore;
				System.out.println("Your guess number is smaller");	
			}
			else if(userInput > randomNum){
				score += unmatchScore;
				System.out.println("Your guess number is larger");
			}	
			else{
				System.out.println("enter a valid number");
			}
			attempts++;

			if(attempts == totalAttempts){
				System.out.println("Sorry you ran out of attempts, Better Luck next Time");
				System.out.println("The Secret Numer is \n----------" + randomNum + "----------");
				System.out.println("Your Score is " + score);
				break;
			}
		}while(attempts <= totalAttempts);
		System.out.println("Want to play again? 1 for yes 0 for no");
		inp = sc.nextInt();
		if(inp == 0){
			break;
		}
	}
	System.out.println("Hope to see you again");
	}
}
