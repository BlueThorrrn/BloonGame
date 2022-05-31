package bloongame;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Bloon extends JLabel{   
   private int richtungX;
   private int richtungY;
   private int spawnTime;
   private int dmg;
   private int speed;
   Random rnd = new Random();
   private int[] sign = {1, -1};
   
   public Bloon(int typ, int difficulty){
       this.speed = difficulty;
       switch(typ){
            case 0:
                this.sBloon();
                break;
                
            case 1:
                this.mBloon();
                break;
                
            case 2:
                this.lBloon();
                break;
                
            case 3:
                this.jBloon();
                break;            
        }         
    } 
   
    public void sBloon(){
        this.setSize(14,14);
        try {
        ImageIcon iconSBloon = new ImageIcon(getClass().getResource("/sources/blueBloon.png"));
        Image imgS = iconSBloon.getImage();
        Image rszSBloonImg = imgS.getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH);        
        this.setIcon(new ImageIcon(rszSBloonImg));
        } catch (Exception ex) {
        System.out.println(ex);
        }
        this.setWerte(8); 
        this.setDmg(1);
    }
    
    private void mBloon(){
        this.setSize(18,18);
        try {
            ImageIcon iconLBloon = new ImageIcon(getClass().getResource("/sources/blueBloon.png"));
            Image imgL = iconLBloon.getImage();
            Image rszLBloonImg = imgL.getScaledInstance(18, 18, java.awt.Image.SCALE_SMOOTH);        
            this.setIcon(new ImageIcon(rszLBloonImg));
            } catch (Exception ex) {
            System.out.println(ex);
        }    
        this.setWerte(6); 
        this.setDmg(2);
    }
    
    private void lBloon(){
        this.setSize(22,22);       
        try {
            ImageIcon iconLBloon = new ImageIcon(getClass().getResource("/sources/blueBloon.png"));
            Image imgL = iconLBloon.getImage();
            Image rszLBloonImg = imgL.getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH);        
            this.setIcon(new ImageIcon(rszLBloonImg));
            } catch (Exception ex) {
            System.out.println(ex);
        }    
       this.setWerte(4); 
       this.setDmg(3);
    }
    
    private void jBloon(){
       this.setSize(50,50);
    }     

     public void setRichtungX(int richtungX) {
        this.richtungX = richtungX;    }
     
    public void setRichtungY(int richtungY) {
        this.richtungY = richtungY;   
    }
    
    public void setSpawnTime(int spawnTime) {
        this.spawnTime = spawnTime;
    }
    
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
    public int getRichtungX() {
        return richtungX;
    }

    public int getRichtungY() {
        return richtungY;
    }
    
    public int getDmg() {
        return dmg;
    }
    
    public int getSpawnTime() {
        return spawnTime;
    }   
    // überarbeiten
    
    public void setWerte(int max){        
        this.richtungX = (int)(rnd.nextInt(max)+1)*sign[rnd.nextInt(sign.length)] + speed;
        this.richtungY = (int)(rnd.nextInt(max)+1)*sign[rnd.nextInt(sign.length)] + speed;        
    }

    public void changeSpeed(double difficulty){
        if (difficulty == 0.75) {
            speed = -2;       
        } else if ( difficulty == 1.5) {
            speed = 2; 
        }else if (difficulty == 1){
            speed = 0; 
        }
    }
    private ImageIcon ImageIcon(URL resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
}
