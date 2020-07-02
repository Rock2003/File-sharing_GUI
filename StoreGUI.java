import java.io.File;
import java.nio.file.Files;

import javax.swing.JFileChooser;

public class StoreGUI {
	
	private static File SERVER = new File("\\\\YOUSSEF\\Server");
	
	public StoreGUI() {
		try {
			JFileChooser cho = new JFileChooser();
			cho.setCurrentDirectory(new File("C:\\"));
			cho.setDialogTitle("Choose File to export");
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
		
			File n = new File(SERVER + fileName); 
		
		
			Files.copy(f.toPath(), n.toPath());
			
			new End(true);
		
		} catch (Exception e) {
			new End(false);
		}
	}
}
