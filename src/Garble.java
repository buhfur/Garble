import java.util.*;
import javax.swing.*;
import java.io.*;

//Ryan McVicker
// 2.20.2021 


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
			while(line != null){
				line = br.readLine();
				
				//compare the users input to the file output adds the answer to list to make sure user doesnt get points for the same answer more than once
				if ((String)userGuess.toUpperCase() == (String)line){
					System.out.println("found an answer!");
					//make sure the answer is not in the foundAnswers list


					if(foundAnswers.contains((String)userGuess.toUpperCase()) == false){
						// user gets points for the answer
						FoundAnswer = true;	
						//now add the answer to the array list
						foundAnswers.add(userGuess.toUpperCase());
						System.out.println("You've earned a point!");
					}else{
						System.out.println("You have already entered that answer!");	
					}

					
					
				}else{ 
					String userGuessUp = userGuess.toUpperCase();
					System.out.println(userGuessUp == (String)line);
					System.out.printf("User entered : %s \n Line read was:  %s\n\n",(String)userGuess.toUpperCase(),(String)line); 
				}
				
			}
			//check the FoundAnswer boolean to see if the player earned a point, then reset the boolean
			if (FoundAnswer == true) {
				// add points based on time of completion
				score += 1;
				//change found answer to false
				FoundAnswer = false;
			}				
			//close the file 
			br.close();
							
		} catch( Exception ex){
		}
		
	}

}
