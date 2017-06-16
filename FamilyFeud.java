import java.util.Arrays;
import java.util.Scanner;

public class FamilyFeud {

 static int playerTwoPoint = 0;
 static int playerPoint = 0;
 static int answersLeft = 2;
 static int x = 0;
 static String answer = null;

 static String player1, player2;

 static boolean ANSWERCORRECT = false;
 // Scanner Variable
 static Scanner in = new Scanner(System.in);

 // ROUND ONE VARIABLES
 static String roundOne[] = { "TAILS", "WHISKERS" };

 // ROUND TWO VARIABLES
 static String roundTwo[] = { "GYM", "DRAMA" };

 // ROUND THREE VARIABLES
 static String roundThree[] = { "MATH", "FRENCH" };

 public static void main(String args[]) {

  System.out.println("\tWELCOME TO FAMILY FEUD!");
  System.out.println();
  System.out.println("\t DA RULES");
  System.out.println("--------------------------------------------------------------------------------------");
  System.out.println(
    "There are 3 rounds to the game. Player 1 starts the first\nround and Player two will start the second, and so on.\n"
      + "The player starting the round has to guess all the answers to the game, if\nthey guess wrong then they will get a strike\n"
      + "3 strikes and you're out! This gives the second player an opprtunity to steal and win the round.");
  System.out.println("--------------------------------------------------------------------------------------");
  System.out.println();
  System.out.print("Player 1 Name: ");
  player1 = in.next();
  System.out.print("Player 2 Name: ");
  player2 = in.next();

  startGame("Name something cats have that people do not. ", "first", player1, roundOne, 2, 1);

  startGame("What are the students favorite courses?", "Second", player2, roundTwo, 2, 2);

  startGame("What are the students most hated courses?", "Third", player1, roundThree, 2, 3);
  
  announceWinner() ; 

 }
 
 public static void announceWinner() {
  clearScreen() ; 
  System.out.println("\tFINAL SCORE");
  System.out.println();
  
  //PLAYER ONE DEFEATED PLAYER TWO 
  if(playerPoint > playerTwoPoint) {
   System.out.println(player2 + "Lost!");
  } 
  //PLAYER TWO DEFEATED PLAYER ONE
  else if(playerPoint < playerTwoPoint) {
   System.out.println(player1 = "Lost");
  }
  //IT WAS A DRAW
  else {
   System.out.println("IT WAS A DRAW!");
   
  }
  
  displayScore() ; 
  
 }



 public static void startGame(String question, String roundType, String player, String currentRound[],
  int answersLeft, int roundNumber) {
  x = 0;

  while (answersLeft > 0 && x < 3) {

   clearScreen();

   displayScore();
   System.out.println(player + "'s turn");

   System.out.println("\t\tROUND " + roundNumber);

   System.out.println(question);

   System.out.println();
   System.out.println("# of Strikes: " + (x));
   System.out.println("Still need to answer: " + answersLeft);
   System.out.println();
   System.out.print("Answer: ");
   answer = in.next();
   answer = answer.toUpperCase(); 

   int prevAnswer = answersLeft;
   for (int i = 0; i < currentRound.length; i++) {
    if (currentRound[i].equals(answer)) {

     currentRound[i] = currentRound[currentRound.length - 1];
     currentRound = Arrays.copyOf(currentRound, currentRound.length - 1);

     answersLeft--;

    }

   }

   if (answersLeft == prevAnswer) {
    x++;
   }

  }
  // clearScreen();
  if (answersLeft == 0) {
   //System.out.println("----------------------------");
   if (player.equals(player1)) {
    playerPoint++;
   } else if (player.equals(player2)) {
    playerTwoPoint++;
   }

  }
  if (x == 3) {
   clearScreen();
   System.out.println(
     player + " coudn't get all the answers to the question, " + player2 + " you can try and steal!");
   System.out.print("Answer: ");
   answer = in.next();
   
   for (int i = 0; i < currentRound.length; i++) {
    if (answer.equals(currentRound[i])) {
     ANSWERCORRECT = true;
     playerTwoPoint++;
     break;

    }
   }

  }

  ANSWERCORRECT = false;

 }

 public static void clearScreen() {
  for (int i = 0; i <= 23; i++) {
   System.out.println();
  }
 }

 public static void displayScore() {

  System.out.println("----------------------------");
  System.out.println(player1 + ": " + playerPoint);
  System.out.println(player2 + ": " + playerTwoPoint);
  System.out.println("------------------------------");
 }

}
