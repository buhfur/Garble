package com.ryanmcvicker12;
import java.util.*;
import javax.swing.*;
import java.io.*;
//Ryan McVicker
// 2.20.2021 
//TODO: need to remove dashes comparative to the word entered 
// for level 1 the letters are : "LWLMOE"
public class Garble{
	public static OSValidator osv = new OSValidator();
	public static String userLevelPick;
	public static String path, playAgain;
	public static Map<String, String> levelMap;
	public static Scanner sc = new Scanner(System.in); 	

	public static void main(String[] args) throws IOException {
		
		Garble obj = new Garble();

		//open the text file and check if the users input matches any of the words in the file

		//map for storing the levels and their respective file path

		levelMap = new HashMap<String,String>();
		levelMap.put("1" , "level1.txt");
		levelMap.put("2" , "level2.txt");
		levelMap.put("3" , "level3.txt");
		levelMap.put("4" , "level4.txt");
		levelMap.put("5" , "level5.txt");
		//get users input for level selection

		System.out.println("|=================================|");
		System.out.println("|	Made by: Ryan McVicker          |");
		System.out.println("====================================");
		System.out.println("| ENTER THE LEVEL YOU WANT TO PLAY |");
		System.out.println("-----------------------------------|");
		System.out.println("|	'1' = Level 1                    |");
		System.out.println("|	'2' = Level 2                    |");
		System.out.println("|	'3' = Level 3                    |");
		System.out.println("|	'4' = Level 4                    |");
		System.out.println("|	'5' = Level 5                    |");
		System.out.println("====================================");
		System.out.print("Pick your level : ");


		userLevelPick = sc.nextLine();	
		path = levelMap.get(userLevelPick);
		//clear the screen 
		osv.ClearScreen();				

		try{
			boolean FoundAnswer = false;

			FileReader fr = new FileReader(path);

			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();

			ArrayList<String> wordList = new ArrayList<String>();
			while(line != null){
				
				line = br.readLine();

				//add all the words in the file to an array list
				//also remove 'null' from the array list
				
				if (line != null){

					//adds the string to the arrayList

					wordList.add(line);

					}	
				}

			//close the file 
				
			br.close();

			//after file closes call game loop 

			obj.GameLoop(wordList);

							
		} catch( Exception ex){
			System.out.println(ex);
		}
		
	}
	
	//method returns the arraylist to print out the board 
	public void GameLoop(ArrayList<String> wordList){

		int PLAYER_SCORE;
		boolean IS_GAME_OVER = false;
		final int wordListSize = wordList.size();
		String userGuess;

		ArrayList<String> foundAnswers = new ArrayList<String>();	
		//run until IS_GAME_OVER IS TRUE
		while(foundAnswers.size() < wordListSize){


			GameBoard theBoard = new GameBoard();
			//pass in the levelMap to give an input for a map in GameBoard.java that will print out the right letters
			Map<String, String> returnedBoard = theBoard.PrintBoard(wordList, foundAnswers, levelMap.get(userLevelPick)  );

			System.out.print("Enter a word : ");

			userGuess = sc.nextLine();				

//			OSValidator osv = new OSValidator();

			//check the users input 

			if(wordList.contains(userGuess.toUpperCase())) {
				//make sure the player hasnt already guessed that word 

				if ( foundAnswers.contains(userGuess.toUpperCase())){

					System.out.println("you have already guessed that answer!");

					//clear the screen

					osv.ClearScreen();

				}else{	

					System.out.println("you've got an answer right!");

					//delete the word from the list 
					
					wordList.remove(userGuess.toUpperCase());

					foundAnswers.add(userGuess.toUpperCase());

					//clear the screen

					osv.ClearScreen();

				}
			
				
			}else{

				System.out.println("that answer is wrong!");

				//clear the screen

				osv.ClearScreen();

			}
				
		} 
		//could print the time it took to complete the game???
		System.out.println("You guessed all the words! Thanks for playing! :)");
		//ask the player if they would like to advance to the next level
	}



}
