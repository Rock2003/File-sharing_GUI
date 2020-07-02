import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SecurityGUI implements ActionListener {
	
	private static CheckID checker;
	private JFrame frame;
	private JLabel username;
	private JLabel password;
	private JLabel success;
	private JPanel panel;
	private JButton button;
	private JTextField userNameText;
	private JPasswordField passwordText;
	
	private static boolean safe;
	
	public SecurityGUI() {
		safe = false;
		frame = new JFrame();
		panel = new JPanel();
		username = new JLabel("Username:");
		password = new JLabel("Password:");
		userNameText = new JTextField();
		passwordText = new JPasswordField();
		button = new JButton("Submit");
		success = new JLabel("");
		try {
			checker = new CheckID();
		} catch (FileNotFoundException e) {}
		
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		username.setBounds(10,20, 80, 25);
		password.setBounds(10, 55, 80, 25);
		
		panel.add(username);
		panel.add(password);
		
		userNameText.setBounds(100, 20, 200, 25);
		passwordText.setBounds(100, 55, 200, 25);
		
		panel.add(userNameText);
		panel.add(passwordText);
		
		button.setBounds(120, 100, 80, 25);
		button.addActionListener(this);
		
		panel.add(button);
		
		success.setBounds(30, 135, 300, 25);
		
		panel.add(success);
		
		frame.setTitle("login");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String userNameInput = userNameText.getText();
		String passwordInput = String.valueOf(passwordText.getPassword());
		if(checker.check(userNameInput, passwordInput)) {
			safe = true;
			frame.dispose();
		} else {
			success.setText("<html><font color='red'>Your username and password don't match.</font></html>");
		}
	}

	public boolean isSecure() {
		return safe;
	}
}
