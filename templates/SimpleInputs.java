//package templates;

import java.io.Console;


import java.io.FileWriter;
import java.io.IOException;


import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class SimpleInputs {
	
	public static void main(String args[]){
		
		String fileName = "C://u/lines.txt";
		
		try(Scanner scanner = new Scanner (new File (fileName))){
			
			while(scanner.hasNext()){
				System.out.println(scanner.nextLine());
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		String input = System.console().readLine("write:");
		
		System.out.println("You wrote" + input);
	}

}