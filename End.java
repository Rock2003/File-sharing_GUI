import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End {
	public JFrame frame;
	public JLabel label;
	public JPanel panel;
	
	public End(boolean bool) {
		label = new JLabel();
		if(bool) {
			label.setText("<html><font color='green'>Task was succesful!</font></html>");
		} else {
			label.setText("<html><font color='red'>An Error occured.</font></html>");
		}
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(180, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		label.setBounds(10, 10, 190, 50);
		
		panel.add(label);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		method();
	}
	public void method() {
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}	
		});
		timer.start();
	}
}
