package edu.rosehulman.csse413;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NLPQuery {

	public static void main(String[] args) {
		StringBuilder processedFile = new StringBuilder();
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("processed.txt"));
            while((line = bufferedReader.readLine()) != null) {
                processedFile.append(line + "\n");
            }   
            bufferedReader.close();         
        } catch (FileNotFoundException e) {
        	System.out.println("File not found");
        } catch (IOException e) {
        	System.out.println("IO Exception");
        }
        
        String[] list = processedFile.toString().split("\n");
        
        Scanner input = new Scanner(System.in);
        String inputLine = input.nextLine();
        
        while (!inputLine.equalsIgnoreCase("exit")) {
        	if (inputLine.endsWith("?")) {
        		String queryMatch = inputLine.replaceAll("\\?", "").replaceAll(" ", ",");
        		String prettyPrint = inputLine.replaceAll("\\?", "").trim() + ".";
        		boolean found = false;
        		for (String s : list) {
        			if (s.equalsIgnoreCase(queryMatch)) {
        				System.out.println("Yes, " + prettyPrint);
        				found = true;
        				break;
        			}
        		}
        		if (!found) {
        			System.out.println("Unknown if " + prettyPrint);
        		}
        	} else {
        		System.out.println("Please ask a question (use \"?\") e.g. \"Lincoln was president?\"");
        	}
        	inputLine = input.nextLine();
        }
	}

}
