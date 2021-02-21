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
		
		// scanner object for reading input 
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a word with the letters LWLMOE: ");
		String userGuess = userInput.nextLine();
		
		//open the text file and check if the users input matches any of the words in the file
		// want to use the fastest and most secure method for reading files 
		String path = "level1.txt";
		//add Integer variable to keep track of points?
		int score = 0;
		//array to store all the answers the user has given so far 
		ArrayList<String> foundAnswers = new ArrayList<String>();	


		
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
			System.out.println(wordList);//TODO: remove in final product, Reason: gives away the answers
			//scan the list and see if the users input is in the arraylist
			if(wordList.contains(userGuess.toUpperCase())){
				score += 1;
				System.out.println("you've got an answer right!");
				//delete the word from the list 
				wordList.remove(userGuess.toUpperCase());
			}
			//close the file 
			System.out.printf("user score : %d\n\n " , score);
			
			System.out.println(wordList);// TODO: remove in final product, same reason in line 51
				
			br.close();
			//after file closes pass wordList into GameBoard to draw the board 
			GameBoard(wordList);
							
		} catch( Exception ex){
		}
		
	}
	//method to display the game board
	private static Map<String,String> GameBoard(ArrayList<String> wordList){
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
