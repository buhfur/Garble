package com.ryanmcvicker12;
import java.util.*;
import javax.swing.*;
import java.io.*;
//Ryan McVicker
// 2.20.2021 
//TODO: need to remove null and ' ' from wordlist
//TODO: make game loop and add in 

// gonna try putting all the words in a text file and ask the user for an input and make sure the word is in there
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
			
			System.out.println(wordList);// TODO: remove in final product, same reason in line 51
				
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
//		GameBoard newBoard = new GameBoard();		
		
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
			theBoard.PrintBoard(wordList);
			System.out.print("Enter a word : ");
			String userGuess = userInput.next();				
			//check the users input 
			if(wordList.contains(userGuess.toUpperCase()) && !foundAnswers.contains(userGuess.toUpperCase())){
				
				System.out.println("you've got an answer right!");
				//delete the word from the list 
				wordList.remove(userGuess.toUpperCase());
				foundAnswers.add(userGuess.toUpperCase());//do i really need this list?
				//clears the console using ANSI escape codes
				System.out.print("\033[H\033[2J");  
    				System.out.flush();
				
			}
				
		} 

	}




}
