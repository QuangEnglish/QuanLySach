import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataIO {
	 static String rootDir;
	 public static void readData(ArrayList<Book> listA) {
		 File inputFile = new File(rootDir+"//book_data.txt");
		 FileReader fReader = null;
		 BufferedReader bReader = null;
		
		 try {
			 fReader = new FileReader(inputFile);
			 bReader = new BufferedReader(fReader);
			String line;
			 while ((line = bReader.readLine()) != null) {
					String[] parts = line.split(";");
					int namXB =  Integer.parseInt(parts[4]);
					Book bok = new Book(parts[0], parts[1], parts[2], parts[3], namXB);
					listA.add(bok);
				}
		 }catch(IOException e ) {
			 e.printStackTrace();
		 }finally {
			try {
				if(bReader != null) bReader.close();
			}catch(IOException e) {
			}
		}	 
	 }
	 
	 public static void saveData(ArrayList<Book> listB) {
		 File outputFile = new File(rootDir+"//book_data.txt");
		 FileWriter fWrite = null;
		 BufferedWriter bWrite = null;
		 
		 try {
			 fWrite = new FileWriter(outputFile);
			 bWrite = new BufferedWriter(fWrite);
			 for (Book bok : listB) {
				bWrite.write(bok.toString());
				bWrite.newLine();
				
			}		 
		 }catch(IOException e ) {
			 e.printStackTrace();
		 }finally {
			try {
				if(bWrite != null) bWrite.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
			
	 }
}
