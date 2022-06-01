package bloongame;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//changeDiff in refresh()

public class Statistik extends JPanel {

    private JLabel lblTime = new JLabel();
    private JLabel lblLeben = new JLabel();
    private JLabel lblPoints = new JLabel();
    private JLabel lblHighScore = new JLabel(); 
    private JLabel lblDiffText = new JLabel(); 
    private JLabel lblDiff = new JLabel();
    private int ablage = 20;
    private int counter = 100;
    private double difficulty;

    public Statistik() {        
        this.setSize(100, 400);
        this.setBackground(Color.LIGHT_GRAY);        
        
        //Zeit
        lblTime.setSize(80, 20);
        lblTime.setLocation(10, 10);
        lblTime.setBackground(Color.LIGHT_GRAY);
        lblTime.setOpaque(true);  
        lblTime.setText("n/a");
        this.add(lblTime);
        
        //Leben
        lblLeben.setSize(80, 20);
        lblLeben.setLocation(10, 40);
        lblLeben.setBackground(Color.LIGHT_GRAY);
        lblLeben.setOpaque(true);  
        lblLeben.setText("n/a");
        this.add(lblLeben);
        
        //Punkte
        lblPoints.setSize(80, 20);
        lblPoints.setLocation(10, 70);
        lblPoints.setBackground(Color.LIGHT_GRAY);
        lblPoints.setOpaque(true);
        lblPoints.setText("n/a");
        this.add(lblPoints);
        
        //Highscore
        lblHighScore.setSize(80, 20);
        lblHighScore.setLocation(10, 100);
        lblHighScore.setBackground(Color.LIGHT_GRAY);
        lblHighScore.setOpaque(true);
        lblHighScore.setText("n/a");
        this.add(lblHighScore);
        
        //Difficulty Text
        lblDiffText.setSize(80, 20);
        lblDiffText.setLocation(10, 130);
        lblDiffText.setBackground(Color.LIGHT_GRAY);
        lblDiffText.setOpaque(true);
        lblDiffText.setText("n/a");
        this.add(lblDiffText);
        
        //Difficulty
        lblDiff.setSize(80, 20);
        lblDiff.setLocation(10, 160);
        lblDiff.setBackground(Color.LIGHT_GRAY);
        lblDiff.setOpaque(true);
        lblDiff.setText("n/a");
        this.add(lblDiff);
    }
    
    public void refresh(int time, int leben, int points, int highScore){
        lblTime.setText("Zeit : " + (int)time/1000 + "s");
        lblLeben.setText("Leben : " + leben + "");
        lblPoints.setText("Points : " + points + "");
        lblHighScore.setText("Highscore : " + highScore);
        lblDiffText.setText("  Difficulty:  ");
        
        if(ablage> leben){
            this.counter = 0;
        }
        ablage = leben;  
        this.lebenAnimation();      
    }
    
    public void lebenAnimation(){
       if(this.counter<5){
           if (counter %2 ==0){
               lblLeben.setForeground(Color.red);   
           }
           else{
               lblLeben.setForeground(Color.black);
           } 
           counter++;
       }
       else{
           lblLeben.setForeground(Color.black);
       }
    }
    public void changeDiff(double difficulty) {
        this.difficulty = difficulty;
        if (difficulty == 0.75) {
            lblDiff.setText("Leicht");
        } else if ( difficulty == 1.5) {
            lblDiff.setText("Schwer");
        }else if (difficulty == 1){
            lblDiff.setText("Normal");
        }else{
            lblDiff.setText("Stat not equaldiff");
        };
    }  
}
