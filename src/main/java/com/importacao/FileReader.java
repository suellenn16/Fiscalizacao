package com.importacao;

import java.io.File;
import java.util.Scanner;

public class FileReader {
	
	public static Scanner read(String fileName) throws Exception{
		String path = System.getProperty("user.dir") + "/";
		Scanner scanner = new Scanner(new File(path +"/" + fileName));
		scanner.useDelimiter("\n");
		
		return scanner;
	}

}
