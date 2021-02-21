package com.ryanmcvicker12;
import java.util.*;

public class GameBoard{

	public static Map<String,String> GameBoard(ArrayList<String> wordList){
			//create new array list from the pre existing word list 
			//iterate through wordList
			
			// create dictionary to hold each word and create a certain amount of dashes determined by its length
			Map<String, String> gameBoard = new HashMap<String, String>();	

			for ( String index : wordList){
				
				System.out.println("element in array list : " + index);		
				//find the size of the index 
				System.out.println("Size of the index in the array list : " + index.length());
				String dashes = "";
				// for loop to determine how many dashes will be in the string  
				for (int i = 0 ; i < index.length();i++){
					dashes += " _ ";
				}
				gameBoard.put(index, dashes);
			}

			System.out.println("Game board: ");
			for ( Map.Entry<String, String> entry : gameBoard.entrySet()){

				System.out.println(entry.getValue());
			}
			return gameBoard;
			
		} 

}
