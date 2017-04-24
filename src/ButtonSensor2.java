import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import java.beans.Statement;
import java.sql.*; 



public class ButtonSensor2 implements ActionListener {
   private Home ho1;
  
   
   private JButton play,exit,records,lifeMode;
   private String msg="Game Exit";
   int lifeValue;
 
   
   //---------------------------database----------------------------------------------
   
     //private databaseConnection db;
	 private String qurey,qurey2,name;
	 int score;
	 Statement st;
	 
	 //----database connection method---------
	 Connection connection = null;
	 public void connection() throws SQLException{
         
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your MySQL JDBC Driver?");
				e.printStackTrace();
				return;
			}

			

			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ballshuffle","root", "");

			} catch (SQLException e) {
				System.out.println("Connection Failed!");
				e.printStackTrace();
				return;
			}

			if (connection != null) {
				
			} else {
				System.out.println("Failed to make connection!");
			}
		        
		        }
	 
	 //--------database connection method ends--------
    
	 public void databaseGetData(){
		 
		  qurey2="SELECT user_name , user_point FROM  userdb ORDER BY user_point DESC LIMIT 10";
		  
		 
		 try {
				st = connection.createStatement();
				ResultSet rs=st.executeQuery(qurey2);
				while(rs.next()){
		
				 score=rs.getInt("user_point");
				 name=rs.getString("user_name");
		         System.out.println("name : "+name+"  Score : "+score);
				 
				// JOptionPane.showMessageDialog(null,  score + "\n" + name );
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	 
	//----------------------------------------------database statement ends------------------------------------------
   
	
	public void getHome(JButton bt ,JButton bt2, JButton bt3,JButton bt4,Home ho1){
		this.play=bt;
		this.ho1=ho1;
		this.exit=bt2;
		this.records=bt3;
		this.lifeMode=bt4;
	}
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==play){
			
			
			//String nameGet=JOptionPane.showInputDialog(null, "Please Enter Your name :");
			
			
			
			//------------------- Game main pages-------------------
			    MyFrame2 mf = new MyFrame2();
				ho1.setVisible(false);
				mf.setSize(700, 700);
				mf.setBackground(new Color(68, 65, 65));
				
				mf.setVisible(true);
		 }
		
		//----------- Records Button------------------
		 if(ae.getSource()==records){
			   try {
				connection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   databaseGetData();
			 
		   }//----------Record Button ends----------
		 
		 
		 //--------------LifeMode Button----------------------
		 if(ae.getSource()==lifeMode){
			 JFrame frame = new JFrame();
			 String lifeList[] = new String[3];

			 lifeList[0]="1";
			 lifeList[1]="3";
			 lifeList[2]="5";

			 String get= (String) JOptionPane.showInputDialog(frame, "Choose Life Option", "Life Mode", JOptionPane.QUESTION_MESSAGE,
			        null, lifeList, "hj");
			 
			  lifeValue=Integer.parseInt(get);
			 
			 //---------------game page load----------------
			 
			   MyFrame2 mf = new MyFrame2();
			   
				ho1.setVisible(false);
				//mf.lifeScore=lifeValue;
				mf.setSize(700, 700);
				mf.setBackground(new Color(68, 65, 65));
				
				mf.setVisible(true);
			

			  }
			 
		 //-------------End of LifeMode button----------------
	  
		
		//---------exit Button----------
		if(ae.getSource()==exit){
			System.out.println("Exit Button Pressed");
			JOptionPane.showMessageDialog(ho1, msg);
			System.exit(0);
		}//--------exit button ends-------
	}
	
}
