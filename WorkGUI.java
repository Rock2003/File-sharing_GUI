import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorkGUI {
	
	JFrame frame;
	JPanel panel;
	JButton retrieve;
	JButton store;
	JLabel label1;
	JLabel label2;
	
	public WorkGUI() {
		label1 = new JLabel("<html><h3>Welcome to your Database!</h3><html>");
		label2 = new JLabel("What do you want to do?");
		frame = new JFrame();
		panel = new JPanel();
		retrieve = new JButton("Retrieve Files");
		store = new JButton("Store Files");
		
		frame.setSize(450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		retrieve.setBounds(60,150, 150, 30);
		store.setBounds(220, 150, 150, 30);
		
		label1.setBounds(130, 20, 250, 25);
		label2.setBounds(140, 80, 160, 25);

		panel.add(label1);
		panel.add(label2);
		
		panel.add(retrieve);
		panel.add(store);

		retrieve.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							new RetrieveGUI();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}	
				}
		);
		store.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new StoreGUI();
					}	
				}
		);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
