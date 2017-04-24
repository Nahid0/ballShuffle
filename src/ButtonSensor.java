
import java.awt.Button;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class ButtonSensor implements ActionListener {
	Program pr1=new Program();
	private MyFrame2 ob;
	private ButtonSensor2 bs2;
	
	
	private Button start, exit,again;
	private TextField tf;
	private MouseListener ml,ml2,ml3;
	private String msg="Click on the box";
	private String msg2="Game Ends";
	private String msg3="Sorry!! there is no ball! 1 life lost";
	private String msg4="You Have No Life ! Game Ends!!";
	private String msg5="congratulation!! You made new High Score !";
	private boolean count=false;
	private int highScoreCheck=0,lifeEndCount=0;
    
	
	
	//---for checking purpopse-----------
	Boolean hmm1 = true ;
	Boolean hmm2 = true ;
	Boolean hmm3 = true ;
	
	//--------------database statement----------------
	
	 private databaseConnection db2;
	 private String qurey,qurey2,nameGet;
	 Statement st2;
	 
	 
	public void databaseInsertData(){
		
		 try {
				db2 = new databaseConnection();
				db2.connection();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		      int point=ob.gameScore;
			
			qurey="insert into userdb(user_point,user_name)values('"+point+"','"+nameGet+"') ";
			try {
				st2 = db2.connection.createStatement();
				//st2.executeUpdate(name);
				st2.executeUpdate(qurey);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 
	}
	
	public void databaseGetData(){
		 
		
		  int point=ob.gameScore;
		  
		  qurey2="select count(user_point) as highScore from userdb where user_point>'"+point+"'";
		  
		 
		 try {
				st2 = db2.connection.createStatement();
				//st2.executeUpdate(name);
				ResultSet rs=st2.executeQuery(qurey2);
				while(rs.next()){
				highScoreCheck=rs.getInt("highScore");
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	 
	//-------------database statement ends-------------

	public void get(Button a, Button b, Button c,TextField t, MyFrame2 m) {
		start = a;
		exit = b;
		again=c;
		tf = t;
        this.ob =m;
        
        
	}
	
	

	public void actionPerformed(ActionEvent ae) {
         
		 
		//-----------------start button start------------------------
		if (ae.getSource() == start) {
			           lifeEndCount=0;
                       System.out.println("start btn");
                      
                       nameGet=JOptionPane.showInputDialog(ob, "Please Enter Your name :");
                       JOptionPane.showMessageDialog(ob, msg);
                       
                     
                       //------------------box1 operation----------------------
                       MouseListener ml = new MouseAdapter() {
                           public void mouseClicked(MouseEvent evt) {
                                  
                                   ob.a.setVisible(false);
                                   
                                   
                                   //----------------cross_button------------------
                                   if(ob.for_a==0){
                                	   
                                	   ob.lifeScore=ob.lifeScore-1;
                                	   
                                	   ob.label_for_null=new JLabel(ob.img_for_null);
                                	   
                                	
                                	   ob.label_for_null.setLocation(ob.x-10, ob.y+40);
                                	   ob.label_for_null.setSize(50 , 50);
                                	   
                                	   ob.add(ob.label_for_null);
                                	   ob.pack();
                                	   ob.setSize(700,700);
                                	   
                                       }//----------if ends--------
                                   
                                   
                                   
                                   else{
                                   for (int k = 0; k < ob.for_a; k++) {
                                        ob.label[k] = new JLabel(ob.img_for_ball);

                                        ob.label[k].setLocation(ob.x=ob.x+40, ob.y);
                                        ob.label[k].setSize(35 , 35);
                                      
                                        ob.add(ob.label[k]);
                                       
                                        //ob.c.removeMouseListener(ml3);
                                        ob.c.setEnabled(false);
                                       // ob.b.removeMouseListener(ml2);
                                        ob.b.setEnabled(false);
                                        
                                        
                                        
                                        }
                                  
                                   }//---------else ends----------
                                   		
                                   
                                 //--points will not add after one click condition-----------
                                   	if(hmm1) {
                                   		
                                   		hmm2 = false ;
                           	   			hmm3 = false ;
                           	   		   ob.gameScore = ob.gameScore+ob.for_a*1000 ;
	                                   ob.score.setText("Score : " + ob.gameScore);
	                                   ob.life.setText("Life : " + ob.lifeScore);
	                                   
                                   	}
                                   	
                                   
                           }
                       };
                       
                       
                     //------------------box2 operation----------------------
                    
                    MouseListener ml2 = new MouseAdapter() {
                        @Override
                         public void mouseClicked(MouseEvent e) 
                         {   
                             int p = 300;
                          
                            ob.b.setVisible(false);
                            
                            
                            
                            if(ob.for_b==0){//----------if starts-----------
                            	
                            	ob.label_for_null=new JLabel(ob.img_for_null);
                         	   
                         	   ob.label_for_null.setLocation(p+55, ob.y+40);
                         	   ob.label_for_null.setSize(50 , 50);
                         	   
                         	   ob.add(ob.label_for_null);
                         	   ob.pack();
                         	   ob.setSize(700,700);
                                ob.lifeScore=ob.lifeScore-1;
                                
                                }//----------if ends------------
                            
                            else{
                             for (int k = 0; k < ob.for_b; k++) {
                                 ob.label_for_2[k] = new JLabel(ob.img_for_ball);
                                 System.out.println("loop");
                                  ob.label_for_2[k].setLocation(p=p+55, ob.y);
                                  ob.label_for_2[k].setSize(35 , 35);
                                  ob.add(ob.label_for_2[k]);
                                  
                                  ob.a.setEnabled(false);
                                  ob.c.setEnabled(false);
                                  
                             }
                             
                            }
                            
                          //--points will not add after one click condition-----------
                             if(hmm2) {
                            		
                            		hmm1 = false ;
                    	   			hmm3 = false ;
                    	   			ob.gameScore = ob.gameScore+ob.for_b*1000 ;
	                                ob.score.setText("Score : " + ob.gameScore);
	                                ob.life.setText("Life : " + ob.lifeScore);
                                
                            	}
                             
                             
                         } 
                 }; //----------------box2 operation ends-----------------
                 
                
                 
               //------------------box3 operation----------------------
                 MouseListener ml3 = new MouseAdapter() {
                     @Override
                      public void mouseClicked(MouseEvent ev) 
                      {   
                          int p = 450;
                         // countB=true;
                        
                         ob.c.setVisible(false);
                         
                         
                         /////---------if starts------------
                         if(ob.for_c==0){
                        	
                           ob.label_for_null=new JLabel(ob.img_for_null);
                       	   
                       	   ob.label_for_null.setLocation(p+55, ob.y+40);
                       	   ob.label_for_null.setSize(50 , 50);
                       	   
                       	   ob.add(ob.label_for_null);
                       	   ob.pack();
                       	   ob.setSize(700,700);
                              ob.lifeScore=ob.lifeScore-1;
                             ob.lifeScore=ob.lifeScore-1;
                         }/////////---------if ends--------------
                         
                         
                         else{
                          for (int k = 0; k < ob.for_c; k++) {
                              ob.label_for_3[k] = new JLabel(ob.img_for_ball);
                              System.out.println("loop");
                               ob.label_for_3[k].setLocation(p=p+55, ob.y);
                               ob.label_for_3[k].setSize(35 , 35);
                               ob.add(ob.label_for_3[k]);
                               
                               ob.a.setEnabled(false);
                               ob.b.setEnabled(false);
                               
                          }
                          
                         }//----------else ends----------
                      
                         //--points will not add after one click condition-----------
                          if(hmm3) {
                         		
                         		hmm1 = false ;
                 	   			hmm2 = false ;
                 	   		    ob.gameScore = ob.gameScore+ob.for_c*1000 ;
                                ob.score.setText("Score : " + ob.gameScore);
                                ob.life.setText("Life : " + ob.lifeScore);
                         	}
                          
                          
                          
                      } 
              };
                 
              
                	
                 pr1.setValues();//program class set() called
                 ob.framrBehindWork(pr1.gamebox1,pr1.gamebox2,pr1.gamebox3);
                
                 ob.a.addMouseListener(ml);
                
                 ob.b.addMouseListener(ml2);
                 ob.c.addMouseListener(ml3);     
                       
      
		}//------------start button ends----------
		
		
		start.setVisible(false);
		ob.add(again);
		again.setVisible(true);
		
		//------------------Again Button start----------------
		if (ae.getSource() == again) {
			
			hmm1 =true ;
			hmm2 = true ;
			hmm3 = true ;
			   
				if(ob.label_for_null !=null) {
					ob.remove(ob.label_for_null);
				}
			  
			
			//-----------deleting ball level start-------
			for (int i = 0; i < ob.for_a; i++) {
				if(ob.label[i]!=null) {
					ob.remove(ob.label[i]);
					ob.x = 100; 
					ob.y = 250 ;
				}
			}
			
			for (int i = 0; i < ob.for_b; i++) {
				if(ob.label_for_2[i]!=null) {
					ob.remove(ob.label_for_2[i]);
					ob.x = 100; 
					ob.y = 250 ;
				}
			}
			
			for (int i = 0; i < ob.for_c; i++) {
				if(ob.label_for_3[i]!=null) {
					ob.remove(ob.label_for_3[i]);
					ob.x = 100; 
					ob.y = 250 ;
				}
			}//--------deleting ball level ends-------------
			
			
			//---------Life end condition-------------
			if(ob.lifeScore==0){
				count=true;
				lifeEndCount=lifeEndCount+1;//------ all life ending checking----------
				JOptionPane.showMessageDialog(ob, msg4);
				if(lifeEndCount==1){
				databaseInsertData();
				databaseGetData();
				
				if(highScoreCheck==0){
					
					JOptionPane.showMessageDialog(ob, msg5);
				}
				else{
					
					
				}
				//System.out.println("data:"+highScoreCheck);
				}
				
				
				//System.exit(0);
			}
			
			else{
			
			 ob.a.setEnabled(true);
             ob.b.setEnabled(true);
             ob.c.setEnabled(true);
			
			
			ob.a.setVisible(true);
			ob.b.setVisible(true);
			ob.c.setVisible(true);
			
			pr1.setValues();//--------program class set() called----------
        	ob.framrBehindWork(pr1.gamebox1,pr1.gamebox2,pr1.gamebox3);//--------getting random values-----------
			
			ob.a.addMouseListener(ml); 
            
            ob.b.addMouseListener(ml2);
            ob.c.addMouseListener(ml3);   
			
			 
			
			System.out.println("Again button pressed");
			}
		}//-----------------again button  ends-------------
		
		
           //----exit button --------------
		else if (ae.getSource() == exit) {
			System.out.println("Cancel Button Pressed");
			
			if(count!=true){
			//-------database work-------
			
			if(nameGet!=null){
				databaseInsertData();
		    }
			
			//-------database work ends------
			}
			JOptionPane.showMessageDialog(ob, msg2);
			System.exit(0);
		}

	}

}

