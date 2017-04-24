import java.util.*;


 public class Program implements programCodeInt {
	 int gamebox1=0;int gamebox2=0;int gamebox3=0;
	 int gamepoints=0,life=5;
     int gameball=3;
     int ballpoints=1000;
     
     Random ran=new Random();
     
	public void setValues(){// ----------interface method--------------
		
	     	 int reminder=0;
	         int box1= ran.nextInt(3);
	         gamebox1=box1;
	         //box2 start
	          reminder=gameball-gamebox1;
	          if(reminder>=0 ){
	          	    if(reminder==1){
	          	    	gamebox2=reminder;
	          	    }
	          	     if(reminder==0){
	          	    	gamebox2=reminder;
	          	    }
	          	    else{
	                      int box2=ran.nextInt(reminder);
	                      gamebox2=box2;
	                    } 
	            }
	         //box3 start
	         reminder=gameball-(gamebox1+gamebox2);
	            gamebox3=reminder;
	            
	            System.out.println("out:"+gamebox1 +gamebox2 +gamebox3);
	}
	
 }

       
  

