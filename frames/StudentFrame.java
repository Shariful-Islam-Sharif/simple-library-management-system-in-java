package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//import repository.*;
import entity.*;


public class StudentFrame extends JFrame implements ActionListener
{
	private JLabel label;
	private JButton addBtn, /*viewBtn,*/ returnBtn, backBtn, logoutBtn, exitBtn;
	private JPanel panel;
	
	public StudentFrame()
	{
		super("StudentFrame");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		label = new JLabel("AIUB Library");
		label.setBounds(350, 10, 350, 30);
		panel.add(label);
		
		addBtn = new JButton("Add Book");
		addBtn.setBounds(100, 80, 110, 30);
		panel.add(addBtn);
		addBtn.addActionListener(this);
		/*
		viewBtn = new JButton("View  Book");
		viewBtn.setBounds(100, 120, 110, 30);
		panel.add(viewBtn);
		viewBtn.addActionListener(this);
		*/
		returnBtn = new JButton("Return Book");
		returnBtn.setBounds(100, 160, 110, 30);
		panel.add(returnBtn);
		returnBtn.addActionListener(this);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(80, 360, 100, 30);
		panel.add(backBtn);
		backBtn.addActionListener(this);
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(380, 360, 100, 30);
		panel.add(logoutBtn);
		logoutBtn.addActionListener(this);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(680, 360, 80, 30);
		panel.add(exitBtn);
		exitBtn.addActionListener(this);
		
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
		{
			String command = ae.getActionCommand();
			
			if(command.equals(addBtn.getText()))
			{
				AddBookFrame abf = new AddBookFrame();
				abf.setVisible(true);
				this.setVisible(false);
			}
			/*
			else if(command.equals(viewBtn.getText()))
			{
				ViewBookFrame vbf = new ViewBookFrame();
				vbf.setVisible(true);
				this.setVisible(false);
			}*/
			else if(command.equals(returnBtn.getText()))
			{
				DeleteBookFrame dbf = new DeleteBookFrame();
				dbf.setVisible(true);
				this.setVisible(false);
			}
			
			else if(command.equals(backBtn.getText()))
			{
				StudentAdminLoginFrame salf = new StudentAdminLoginFrame();
				salf.setVisible(true);
				this.setVisible(false);
			}
			else if(command.equals(logoutBtn.getText()))
			{
				HomePage hp = new HomePage();
				hp.setVisible(true);
				this.setVisible(false);
			}
			else if(command.equals(exitBtn.getText()))
			{
				System.exit(0);
			}
			else{}
		}
	
	
}