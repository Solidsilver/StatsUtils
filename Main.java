import utils.*;
import java.util.Scanner;
import java.io.File;

public class Main {
	public static void main(String[] args) throws Exception{
		File fn = FileUtils.fileFactory("nums.txt");
		Scanner fin = FileUtils.scannerFactoryUserInput();
		ArrayExtras.printLnArray(FileUtils.fileToArray("text.txt"));
	}
}