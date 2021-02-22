package com.ryanmcvicker12; 
import java.util.*;

// class for printing the game board for each level

public class GameBoard{

	public void PrintBoard(ArrayList<String> wordList){
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

			System.out.println("Game board: ");
			for (var value : gameBoard.values()){

				System.out.println(value);
			}
			
			System.out.println("====================");	
			System.out.println("| L  W  L  M  O  E |");	
			System.out.println("====================");	
	} 
	
	

}
