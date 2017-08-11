package com.panli.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MyContactInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyContactInterFrm frame = new MyContactInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyContactInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8054\u7CFB\u6211\u4EEC");
		setBounds(100, 100, 528, 356);
		
		JLabel label = new JLabel("\u4F60\u6709\u4EC0\u4E48\u95EE\u9898");
		label.setFont(new Font("ËÎÌו", Font.BOLD, 15));
		label.setIcon(new ImageIcon(MyContactInterFrm.class.getResource("/images/smile.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(177)
					.addComponent(label)
					.addContainerGap(281, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(130)
					.addComponent(label)
					.addContainerGap(182, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
