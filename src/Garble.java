import java.util.*;
import javax.swing.*;
import java.io.*;

//Ryan McVicker
// 2.20.2021 
//TODO: need to remove null and ' ' from wordlist

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
				wordList.add(line);
				
			}
			System.out.println(wordList);
			//scan the list and see if the users input is in the arraylist
			if(wordList.contains(userGuess.toUpperCase())){
				score += 1;
				System.out.println("you've got an answer right!");
				//delete the word from the list 
				wordList.remove(userGuess.toUpperCase());
			}
			//close the file 
			System.out.printf("user score : %d\n\n " , score);
			
			System.out.println(wordList);
			
			br.close();
							
		} catch( Exception ex){
		}
		
	}

}
