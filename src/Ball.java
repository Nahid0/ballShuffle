import javax.swing.ImageIcon;


public class Ball {
    private ImageIcon img ; 
    private int number ;
    
    public void setImageIcon (ImageIcon imgs) {
        this.img = imgs ;
    }
    
    public void setNumber (int n ) {
        this.number = n;
    }
    
    public int getNumber() {
        return number;
    }
    
    public ImageIcon getImageIcon(){
        return img ;
    }
}
