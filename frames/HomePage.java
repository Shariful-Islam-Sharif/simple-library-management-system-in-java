package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//import repository.*;
import entity.*;


public class HomePage extends JFrame implements ActionListener
{
	private JLabel label,adminLabel;
	private JButton loginBtn, /*adminBtn,studentBtn,*/ exitBtn;
	private JPanel panel;
	
	public HomePage()
	{
		super("HomePage");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		label = new JLabel("AIUB Library");
		label.setBounds(350, 10, 350, 30);
		panel.add(label);
		
		/*
		adminBtn = new JButton("Admin");
		adminBtn.setBounds(100, 80, 100, 30);
		panel.add(adminBtn);
		adminBtn.addActionListener(this);
		
		
		
		studentBtn = new JButton("Student");
		studentBtn.setBounds(100, 120, 100, 30);
		panel.add(studentBtn);
		studentBtn.addActionListener(this);*/
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(80, 360, 100, 30);
		panel.add(loginBtn);
		loginBtn.addActionListener(this);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(680, 360, 80, 30);
		panel.add(exitBtn);
		exitBtn.addActionListener(this);
		
		
		
		this.add(panel);
	}
	
		
		
		public void actionPerformed(ActionEvent ae)
		{
			String command = ae.getActionCommand();
			
			/*
			if(command.equals(adminBtn.getText()))
			{
				AdminLoginFrame alf = new AdminLoginFrame();
				alf.setVisible(true);
				this.setVisible(false);
			}
			else if(command.equals(studentBtn.getText()))
			{
				StudentLoginFrame slf = new StudentLoginFrame();
				slf.setVisible(true);
				this.setVisible(false);
			}
			*/
			
			if(command.equals(loginBtn.getText()))
			{
				StudentAdminLoginFrame salf = new StudentAdminLoginFrame();
				salf.setVisible(true);
				this.setVisible(false);
			}
			else if(command.equals(exitBtn.getText()))
			{
				System.exit(0);
			}
			else{}
		}
	
}