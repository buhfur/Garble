package com.ryanmcvicker12; 
import java.util.*;

// class for printing the game board for each level

public class GameBoard{
	//return a Map of the board to use in Garble.java
	public Map<String,String> PrintBoard(ArrayList<String> wordList){
			//create new array list from the pre existing word list 
			//iterate through wordList
			
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
				//change the dashes here?
				//try to index the list given the guess?
				System.out.println(value);
			}
			
			System.out.println("====================");	
			System.out.println("| L  W  L  M  O  E |");	
			System.out.println("====================");	
			return gameBoard;
	} 
	
}
