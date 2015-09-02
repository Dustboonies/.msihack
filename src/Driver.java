import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Driver {
	static ArrayList<File> files = new ArrayList<File>();						//Stores all the files in the folder
	static ArrayList<File> execfiles = new ArrayList<File>();					//Stores executable files from the folder
	static JFrame frame = new JFrame();
	static JButton[] fButton = new JButton[10];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final File folder = new File("C:/Users/Dustin Feldsine/Desktop/test");	//Directory where files will be indexed
		files = listFilesForFolder(folder);										//Updates current files list
		
		checkIfExecutable();													//checks for executable files
		addButtons();
		createGUI();
		updateLoop();
		
		
		for(int a = 0; a < execfiles.size(); a++){								//Test statement
			System.out.println(execfiles.get(a));
		}
		
	}
	
	public static void createGUI(){
		frame.setLayout(new GridLayout(execfiles.size(),1));
		frame.setTitle("Install the following:");
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	private static void updateLoop() {
		// TODO Auto-generated method stub
		for (JButton b: fButton){
			b.addActionListener(ActionLister n);
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
	
	public ArrayList<File> getFiles(){
		return execfiles;
	}

	public static void addButtons(){
		for( int z = 0; z < execfiles.size();z++){
			fButton[z] = new JButton(z + ")" + execfiles.get(z).getName());
			frame.add(fButton[z]);
		}
//		JButton firstButton = new JButton("1) " + execfiles.get(0).getName());
//		JButton secondButton = new JButton("2) " + execfiles.get(1).getName());
//		JButton thirdButton = new JButton("3) " + execfiles.get(2).getName());
		
//		frame.add(secondButton);
//		frame.add(thirdButton);
		
	}
	
}
