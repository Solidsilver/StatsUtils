package utils;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class FileUtils {

	public static void arrayToFile(double[] a, String fname) throws Exception {
		File fn = new File(fname);
		PrintStream fout = new PrintStream(fn);
		for(int i = 0; i < a.length; i++) {
			fout.println(a[i]);
		}
		fout.close();
	}
	
	public static void arrayToFile(int[] a, String fname) throws Exception {
		File fn = new File(fname);
		PrintStream fout = new PrintStream(fn);
		for(int i = 0; i < a.length; i++) {
			fout.println(a[i]);
		}
		fout.close();
	}
	
	public static void arrayToFile(String[] a, String fname) throws Exception {
		File fn = new File(fname);
		PrintStream fout = new PrintStream(fn);
		for(int i = 0; i < a.length; i++) {
			fout.println(a[i]);
		}
		fout.close();
	}


	//Count the number of lines in a given file
	public static int countRecords(Scanner fin) throws Exception {
      int cntr = 0;
      while (fin.hasNextLine()) {
        	fin.nextLine();
        	cntr++;
		}
      return cntr;
	}


	//File Factory
	public static File fileFactory(String filename) throws Exception {
		File fn = new File(filename);
		return fn;
	}


	//File to Array
	public static String[] fileToArray(String fname) throws Exception {
		Scanner fout = scannerFactory(fname);
		String[] strs = new String[countRecords(fout)];
		fout = scannerFactory(fname);
		int cntr = 0;
		while (fout.hasNextLine()) {
			strs[cntr] = fout.nextLine();
			cntr++;
		}
		return strs;
	}

	
	//Print Stream Factory
	public static PrintStream printStreamFactory(String fname) throws Exception {
		File fn = fileFactory(fname);
		return printStreamFactory(fn);	
	}

	public static PrintStream printStreamFactory(File file) throws Exception {
		if (!file.exists() || !file.canRead()) {
			throw new Exception("IllegalArgumentException");
		}
		PrintStream fout = new PrintStream(file);
		return fout;
	}


	//Scanner Factory
	public static Scanner scannerFactory(File file) throws Exception {
		if (file.exists() && file.canRead()) {
			Scanner fin = new Scanner(file);
			return fin;
		} else {
			throw new Exception("IllegalArgumentException");
		}

	}

	public static Scanner scannerFactory(String fname) throws Exception {
		File fn = fileFactory(fname);
		if (fn.exists() && fn.canRead()) {
			Scanner fin = new Scanner(fn);
			return fin;
		} else {
			throw new Exception("IllegalArgumentException");
		}
	}


	// File Factory User Input
	public static Scanner scannerFactoryUserInput() throws Exception {
		Scanner kb = new Scanner(System.in);
		Scanner fin;
		String fileName;
		File fn = new File(" ");
		do {
			if (!fn.getName().equals(" ")) {
				if (!fn.exists()) {
					System.out.println("File does not exist.");
				} else if (!fn.canRead()) {
					System.out.println("File not readable.");
				}
			}
			System.out.print("Enter a file name: ");
			fileName = kb.nextLine();
			fn = new File(fileName);

		} while (!fn.exists() || !fn.canRead());
		fin = new Scanner(fn);
		kb.close();
		return fin;

	}

	
}