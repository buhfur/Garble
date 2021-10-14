package com.ryanmcvicker12; 
import java.util.*;


// class for printing the game board for each level

public class GameBoard{
	//return a Map of the board to use in Garble.java
	public Map<String,String> PrintBoard(ArrayList<String> wordList, ArrayList<String> foundAnswers, String level){

			//create new array list from the pre existing word list 
			
			// create dictionary to hold each word and create a certain amount of dashes determined by its length

			Map<String, String> gameBoard = new HashMap<String, String>();	

			for ( String index : wordList){
				
				//find the size of the index 

				String dashes = "";

				// for loop to determine how many dashes will be in the string  

				for (int i = 0 ; i < index.length();i++){
					dashes += " _ ";
				}
				gameBoard.put(index, dashes);
			}

			//for loop to print out game board
			System.out.println("Game board: ");
			for (var value : gameBoard.values()){
				System.out.println(value);
				//print all foundAnswers
			}


			if( foundAnswers.size() > 0 ){
				for ( var foundValue : foundAnswers ){
					System.out.println(foundValue);
				}
			}
			//need to change this to meet the level
			Map<String,String> levelLetters = new HashMap<String, String>();
			levelLetters.put("level1.txt", " L  W  L  M  O  E ");
			levelLetters.put("level2.txt", " H  S  G  F  T  I ");
			levelLetters.put("level3.txt", " E  M  I  S  S  L");
			levelLetters.put("level4.txt", " R  A  N  Y  C  O");
			levelLetters.put("level5.txt", " G  A  E  D  R  G");
			//print out the letters
			System.out.println("====================");	
			System.out.printf("| %s |\n", levelLetters.get(level));	
			System.out.println("====================");	

			return gameBoard;
	} 
	
}
