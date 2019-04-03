package cipher;
import java.io.*;
import java.util.Scanner;
import java.nio.*;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class cipher_classes {
	private static Scanner sc;

	public static void main (String[] args) throws FileNotFoundException, IOException {
		sc = new Scanner (System.in);
		
		System.out.println("Please, enter the file directory.");
		String fileName=sc.nextLine();
		System.out.println("Please, enter the encrypt length (INT ONLY).");
		int encryptLength=sc.nextInt();
		
		encryptFile(fileName, encryptLength);			
		
	}
	
	public static String encryptString(String eString, int n) {
		
		String encrypted=new String();
		
        for(int i=0;i<eString.length();i++) {
			
			encrypted+=(char)(eString.charAt(i)+n);
			
		}
        
        //System.out.print(encrypted);
        
        return encrypted;
	}
	
    public static void encryptFile(String fileDir, int encryptLength) throws FileNotFoundException, IOException {
    	
    	try(BufferedReader br = new BufferedReader(new FileReader(fileDir))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    
		    
		    
		    String everything = sb.toString();
		    
		    //deletes old file and contents
		    File encryptedFile= new File("C://dir//user//encryptedFile.txt");
		    
		    
		    System.out.println("Attempting to encrypt your string using length of "
			+ encryptLength + "...\n\n");
		    encryptString(everything, encryptLength);
		    
		    PrintWriter writer = new PrintWriter(encryptedFile, "UTF-8");
		    writer.println(encryptString(everything, encryptLength));
		    writer.close();
		    
		    TimeUnit.SECONDS.sleep(1);
		    
		    System.out.print("Your file has been successfully encrypted and stored "+
		    "in the following directory.\n"+encryptedFile);
		    
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    }
		

}
