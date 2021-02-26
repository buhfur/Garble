package com.ryanmcvicker12;
import java.util.*;
import javax.swing.*;
import java.io.*;
//Ryan McVicker
// 2.20.2021 
//TODO: need to remove dashes comparative to the word entered 
// for level 1 the letters are : "LWLMOE"
public class Garble{
	
	public static void main(String[] args) throws IOException {
		
		Garble obj = new Garble();
		
		//open the text file and check if the users input matches any of the words in the file
		
		String path = "level1.txt";
		
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
		}
		
	}
	
	//method returns the arraylist to print out the board 
	public void GameLoop(ArrayList<String> wordList){

		int PLAYER_SCORE;
		boolean IS_GAME_OVER = false;
		
		ArrayList<String> foundAnswers = new ArrayList<String>();	
		Scanner userInput = new Scanner(System.in);
		//run until IS_GAME_OVER IS TRUE
		while(IS_GAME_OVER != true){

			// game loop here 
			// get answer from player and then check 
			//first print the game board 
			// get the players input
			// determine if the player earned points
			// clear the console ( only in command line version)

			GameBoard theBoard = new GameBoard();

			Map<String, String> returnedBoard = theBoard.PrintBoard(wordList);

			System.out.print("Enter a word : ");

			String userGuess = userInput.nextLine();				

			//check the users input 

			if(wordList.contains(userGuess.toUpperCase())) {
				//make sure the player hasnt already guessed that word 

				if ( foundAnswers.contains(userGuess.toUpperCase())){

					System.out.println("you have already guessed that answer!");

				}else{	

					System.out.println("you've got an answer right!");

					//delete the word from the list 
					
					wordList.remove(userGuess.toUpperCase());

					foundAnswers.add(userGuess.toUpperCase());//do i really need this list?
				}
			
				
			}else{
				System.out.println("that answer is wrong!");
			}
				
		} 

	}




}
