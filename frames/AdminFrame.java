package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import entity.*;
//import repository.*;


public class AdminFrame extends JFrame implements ActionListener
{
	private JLabel label;
	private JButton backBtn,logoutBtn,exitBtn,addBtn,/*viewBtn,*/delBtn;
	private JPanel panel;
	
	public AdminFrame()
	{
		super("AdminFrame");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		label = new JLabel("AIUB Library");
		label.setBounds(350, 10, 350, 30);
		panel.add(label);
		
		addBtn = new JButton("Add Student");
		addBtn.setBounds(100, 80, 120, 30);
		panel.add(addBtn);
		addBtn.addActionListener(this);
		/*
		viewBtn = new JButton("View Student");
		viewBtn.setBounds(100, 120, 120, 30);
		panel.add(viewBtn);
		viewBtn.addActionListener(this);
		*/
		delBtn = new JButton("Delete Student");
		delBtn.setBounds(100, 160, 120, 30);
		panel.add(delBtn);
		delBtn.addActionListener(this);
		
		
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
			StudentRegistrationFrame srf = new StudentRegistrationFrame();
			srf.setVisible(true);
			this.setVisible(false);
		}
		/*
		else if(command.equals(viewBtn.getText()))
		{
			ViewFrame vf = new ViewFrame();
			vf.setVisible(true);
			this.setVisible(false);
		}*/
		else if(command.equals(delBtn.getText()))
		{
			DeleteFrame df = new DeleteFrame();
			df.setVisible(true);
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