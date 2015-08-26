import java.io.File;
import java.util.ArrayList;


public class Driver {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<File> files = new ArrayList<File>();
		final File folder = new File("C:/Users/Dustin Feldsine/Desktop");
		files = listFilesForFolder(folder);
		
		for(int a = 0; a < files.size(); a++){
			System.out.println(files.get(a));
		}
		
		for(int b = 0; b < files.size(); b++){
			File file = files.get(b);
			if(!(file.canExecute()==true)){
				files.remove(b);
			}
		}
		
		for(int a = 0; a < files.size(); a++){
			System.out.println(files.get(a));
		}
		
		
	}
	public static ArrayList<File> listFilesForFolder(final File folder) {
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
}
