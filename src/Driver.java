import java.io.File;
import java.util.ArrayList;


public class Driver {
	static ArrayList<File> files = new ArrayList<File>();							//Stores all the files in the folder
	static ArrayList<File> execfiles = new ArrayList<File>();						//Stores executable files from the folder
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final File folder = new File("C:/Users/Dustin Feldsine/Desktop/test");	//Directory where files will be indexed
		files = listFilesForFolder(folder);										//Updates current files list
		
		checkIfExecutable();													//checks for executable files
		
		for(int a = 0; a < files.size(); a++){									//Test statement
			System.out.println(files.get(a));
		}
		
		for(int a = 0; a < execfiles.size(); a++){								//Test statement
			System.out.println(execfiles.get(a));
		}
		
		
		
		
	}
	
	public static ArrayList<File> listFilesForFolder(final File folder) {		//Retrieves files in the directory
		ArrayList<File> a = new ArrayList<File>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	a.add(fileEntry);
	            System.out.println(fileEntry.getName());
	        }
	    }
	    return a;
	}
	
	public static void checkIfExecutable(){
		for(int b = 0; b < files.size(); b++){									//Checks if file is executable
			File file = files.get(b);
			String name = file.getName();
			int length = name.length();
			String end = (String) (name.subSequence(length-4, length));
			if(end.equalsIgnoreCase(".exe") || end.equalsIgnoreCase(".msi")){
				execfiles.add(file);
			}
		}
	}
	
	
}
