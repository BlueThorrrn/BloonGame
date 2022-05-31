package bloongame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndPanel extends JPanel{
    private JLabel lblText = new JLabel();    
    private JLabel lblPoints = new JLabel();   
    private JLabel lblHighScore = new JLabel();
    private JLabel lbltime = new JLabel();
   
    
    
    public EndPanel(int points, int highscore, int time){
        this.setLayout(null);
        this.setSize(580, 300);
        this.setBackground(Color.red);
        this.setBackground(new Color(232, 85, 29));
        
        lblText.setSize(200, 40);
        lblText.setLocation(250, 30);
        lblText.setOpaque(false);
        lblText.setText("Verloren");
        lblText.setFont(new Font("Courier", Font.PLAIN, 30)); //vielleicht Dick
        this.add(lblText);
        
        lblPoints.setSize(200, 40);
        lblPoints.setLocation(80, 80);
        lblPoints.setOpaque(false);
        lblPoints.setText("Highscore : " + points);
        lblPoints.setFont(new Font("Courier", Font.PLAIN, 30)); //vielleicht Dick
        this.add(lblPoints);
        
        lblHighScore.setSize(200, 40);
        lblHighScore.setLocation(80, 120);
        lblHighScore.setOpaque(false);
        lblHighScore.setText("Punkte : " + highscore);
        lblHighScore.setFont(new Font("Courier", Font.PLAIN, 30)); //vielleicht Dick
        this.add(lblHighScore);
        
        lbltime.setSize(300, 40);
        lbltime.setLocation(80, 160);
        lbltime.setOpaque(false);
        lbltime.setText("Zeit : " + (int) time/1000 + " Sekunden");
        lbltime.setFont(new Font("Courier", Font.PLAIN, 30)); //vielleicht Dick
        this.add(lbltime);
        
        
    }
    
}
