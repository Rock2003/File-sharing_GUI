import java.io.File;
import java.nio.file.Files;

import javax.swing.JFileChooser;

public class RetrieveGUI {
	
	private static File server = new File("\\\\YOUSSEF\\Server");
	
	public RetrieveGUI() throws InterruptedException {
		try {
			JFileChooser cho = new JFileChooser();
			cho.setCurrentDirectory(server);
			cho.setDialogTitle("Choose File to import");
			cho.showOpenDialog(null);
			File f = cho.getSelectedFile();
		
			String path = f.getAbsolutePath();
			String fileName = "";
			for(int i = path.length() - 1; i >= 0; i--) {
				if (path.charAt(i) == '\\') {
					fileName = path.substring(i);
					i = -1;
				}
			}
		
			JFileChooser blo = new JFileChooser();
			blo.setCurrentDirectory(new File("C:\\Users\\Youssef\\Desktop"));
			blo.setDialogTitle("Where do you want to export the file?");
			blo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			blo.showOpenDialog(null);
			File n = new File(blo.getSelectedFile().getAbsoluteFile() + fileName); 
		
		
			Files.copy(f.toPath(), n.toPath());
			
			new End(true);
		
		} catch (Exception e) {
			new End(false);
		}
	}
	
	

}
