
//----------this is Home Window class-------------------


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame {
	 ButtonSensor2 bsc=new ButtonSensor2();
	
	 private JButton play_button,exit_button,records_buttton,lifeMode_button;
	 private JLabel gameName,game_subheader;
	  TextField nameEnter;
	 
	
	 
	 public Home() throws SQLException{
		     
		 	
		 	play_button = new JButton("Play");
		 	exit_button = new JButton("Exit");
		 	records_buttton=new JButton("Records");
		 	lifeMode_button=new JButton("LifeMode");
		 	
		 	
		 	
		 	
		 	
	        play_button.setBounds(200, 250, 150, 100);
	        play_button.setBackground(new Color(68, 65, 65));
	        play_button.setForeground(Color.BLACK);
	        play_button.setFont(new Font("Lucida Console", 1, 25));
	        play_button.setBorder(null);
	        
	     
	        exit_button.setBackground(Color.red);
	        exit_button.setForeground(Color.black);
	       // exit_button.setfore
	        exit_button.setFont(new Font("Lucida Console", 1, 25));
	        exit_button.setBounds(375, 250, 150, 100);
	        exit_button.setBorder(null);
	        
	        
	        records_buttton.setBounds(210, 400, 145, 95);
	        records_buttton.setBackground(new Color(68, 65, 65));
	        records_buttton.setForeground(Color.BLACK);
	        records_buttton.setFont(new Font("Lucida Console", 1, 25));
	        records_buttton.setBorder(null);
	        
	        
	        
	        lifeMode_button.setBounds(380, 400, 145, 95);
	        lifeMode_button.setBackground(new Color(68, 65, 65));
	        lifeMode_button.setForeground(Color.BLACK);
	        lifeMode_button.setFont(new Font("Lucida Console", 1, 25));
	        lifeMode_button.setBorder(null);
	        
	        
	        JLabel background=new JLabel(new ImageIcon("bg3.png"));
	        
	        setContentPane(background);  
	       
	        
	        gameName=new JLabel("Ball  Shuffle");
	        gameName.setSize(340, 140);
	        gameName.setLocation(227, 30);
	        gameName.setForeground(Color.black);
	        gameName.setFont(new Font("Lucida Console", 0, 40));
	        
	        game_subheader=new JLabel("The Game of Box ");
	        game_subheader.setSize(400, 50);
	        game_subheader.setLocation(400, 115);
	        game_subheader.setForeground(Color.black);
	        game_subheader.setFont(new Font("Lucida Console", 0, 15));
	        
	        add(gameName);
	        add(game_subheader);
	        add(play_button);
	        add(exit_button);
	        add(records_buttton);
	        add(lifeMode_button);
	        setSize(700, 700);
	        setLayout(null);
	        play_button.addActionListener(bsc);
	        exit_button.addActionListener(bsc);
	        records_buttton.addActionListener(bsc);
	        lifeMode_button.addActionListener(bsc);
	        
	        bsc.getHome(play_button,exit_button, records_buttton,lifeMode_button,this);//---------home class method-----------
	        

	 }
	 
}
