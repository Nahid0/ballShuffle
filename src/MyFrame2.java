

//--------------- this is game window component frame ---------------
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MyFrame2 extends JFrame{
    private Button start_button,again_button;
	private Button exit_button;
	private TextField tf;
	
	    ImageIcon img1, img2, img3,img_for_ball,img_for_null;
	    
	    JLabel score, life, gameheader;
	    JLabel a,b,c,label_for_null;//----a,b,c for box lavel and label_.. for cross label
	    
	    //----variables for ball lavel-------
        JLabel[] label ;
        JLabel[] label_for_2 ;
        JLabel[] label_for_3 ;
        
         int for_a,for_b,for_c ;//-------for ball number get------
         int x = 100;
         int y = 250 ;
         int gameScore = 0 ,s=0;
         int lifeScore=5;
         String inputName;
         
        
         ButtonSensor bs = new ButtonSensor(); //-----buttonSensor class object reference---------
         ButtonSensor2 bs2=new ButtonSensor2();
        
         
         
         MyFrame2() {
        	 
        	   // lifeScore=bs2.lifeValue;//----lifemode-------
        	   // pack();
        	 	img_for_null = new ImageIcon("null2.png");
        	 	
        	 	
                start_button = new Button("Start");
		        exit_button = new Button("Exit");
		        again_button=new Button("Again");
		        
		        gameheader= new JLabel("Ball Shuffel");
		        gameheader.setSize(300, 50);
		        gameheader.setLocation(300, 30);
		        gameheader.setForeground(Color.red);
		        gameheader.setFont(new Font("Lucida Console", 1, 30));
                
                
                score = new JLabel("Score : " + gameScore);
                score.setLocation(50 , 100);
                score.setSize(200,50);
                score.setForeground(Color.yellow);
                score.setFont(new Font("Segoe UI Light", 1, 30));
                
               //-----------setting background---------
                JLabel background=new JLabel(new ImageIcon("bg2.png"));
                setContentPane(background);
    	       
    	       
                
                life = new JLabel("Life : " +lifeScore);
                life.setLocation(550 , 100);
                life.setSize(400,50);
                life.setForeground(Color.YELLOW);
                life.setFont(new Font("Segoe UI Light", 1, 30));
                
                
               
		        setLayout(null);//-----setting layout null-------
                
               
                
                addWindowListener(new WindowSensor());
                
               img1 = new ImageIcon("box.png");
		       img2 = new ImageIcon("box.png");
		       img3 = new ImageIcon("box.png"); 
                
               
               // ---------setting boxes----------
		       a = new JLabel(img1);// box1
               b = new JLabel(img2);//box2
               c = new JLabel(img2);//box3
               
                
                start_button.setLocation(150, 560);
                start_button.setSize(100 , 50);
                start_button.setBackground(Color.black);
                start_button.setForeground(Color.green);
                
                
                exit_button.setLocation(350, 560);
                exit_button.setSize(100 , 50);
                exit_button.setBackground(Color.red);
                exit_button.setForeground(Color.black);
                
                
                again_button.setLocation(150, 560);
                again_button.setSize(100 , 50);
                again_button.setBackground(Color.black);
                again_button.setForeground(Color.green);
                
                
                a.setLocation(80, 250);
                a.setSize(215 , 150);
                
                b.setLocation(280, 250);
                b.setSize(215 , 150);
                
                c.setLocation(490, 250);
                c.setSize(215, 150);
                
            
                
                
                add(start_button);
                add(exit_button);
                
                //---------adding button to action listner-----------
                start_button.addActionListener(bs);
                exit_button.addActionListener(bs);
                again_button.addActionListener(bs);
                
                add(a);
                add(b);
                add(c);
                add(score);
                add(life);
                add(gameheader);
                
                
                bs.get(start_button, exit_button, again_button,tf,this);
                
        }
         
         //-----------paint method---------------
        // public void paint(Graphics g)
        // {
        	// g.drawImage(img, 0, 0, null);
        // }
         
         public void framrBehindWork(int ball1,int ball2,int ball3){ 
        	 //-------ball class objects--------
        	 Ball ball_1 = new Ball();
            // ball_1.setImageIcon(img1);
             ball_1.setNumber(ball1);
             
             
             Ball ball_2 = new Ball();
             //ball_2.setImageIcon(img1);
             ball_2.setNumber(ball2);
             
             Ball ball_3 = new Ball();
             //ball_3.setImageIcon(img1);
             ball_3.setNumber(ball3);
             
             //--------setting the game ball img--------
             
              img_for_ball = new ImageIcon("ball.png");
              
             
             for_a = ball_1.getNumber();
             for_b = ball_2.getNumber();
             for_c = ball_3.getNumber();
             
             
             label = new JLabel[for_a];
             label_for_2 = new JLabel[for_b];
             label_for_3 = new JLabel[for_c];
        	 
         }
         
        
        
}