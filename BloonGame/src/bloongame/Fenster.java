package bloongame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fenster extends JFrame{  
    
    private JButton buttonst = new JButton();
    private JButton buttonrest = new JButton();
    private JButton buttonleicht = new JButton();
    private JButton buttonnormal = new JButton();
    private JButton buttonschwer = new JButton();
    private JLabel lblDiff = new JLabel();
    private Timer t;
    private boolean wasToggled = false;
    private boolean isToggled = true;
    private double difficulty;
    
    private Game game = new Game();      
    
    public Fenster() {
        
        //Fenster
        this.setLayout(null);
        this.setSize(900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bloongame");
        this.getContentPane().setBackground(Color.WHITE);        
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        //Startbutton
        buttonst.setLocation(315, 520);
        buttonst.setSize(150, 60);
        buttonst.setText("Start");
        buttonst.setBackground(Color.DARK_GRAY);
        buttonst.setForeground(Color.yellow);
        buttonst.setEnabled(false);
        this.add(buttonst);
        
        buttonst.addActionListener((ActionEvent ae) -> {              
            this.toggleBtn();
            buttonst.setLocation(10, 420);
            buttonrest.setEnabled(true);
            buttonrest.setVisible(true);
            this.moveButton();
            game.changeDiff(difficulty);
        }); 
        
        game.setLocation(10,10);
        this.add(game);
        
        //Restartbutton
        buttonrest.setLocation(10,490);
        buttonrest.setSize(150,60);
        buttonrest.setText("Restart");
        buttonrest.setBackground(Color.DARK_GRAY);
        buttonrest.setForeground(Color.yellow);
        buttonrest.setEnabled(false);  
        buttonrest.setVisible(false);
        this.add(buttonrest);
       
        buttonrest.addActionListener((ActionEvent ae) -> {  
            game.restartGame();
        });    
            
        //Buttons Schwierigkeit
        //Button Leicht
        buttonleicht.setLocation(155, 450);
        buttonleicht.setSize(150, 60);
        buttonleicht.setText("Leicht");
        buttonleicht.setBackground(Color.DARK_GRAY);
        buttonleicht.setForeground(Color.LIGHT_GRAY);
        buttonleicht.setEnabled(true);
        this.add(buttonleicht);    
        buttonleicht.addActionListener((ActionEvent ae) -> {  
            buttonst.setEnabled(true);
            buttonst.setForeground(Color.LIGHT_GRAY);
            difficulty = 0.75;
        });  

        //Button Normal
        buttonnormal.setLocation(315, 450);
        buttonnormal.setSize(150, 60); 
        buttonnormal.setText("Normal");
        buttonnormal.setBackground(Color.DARK_GRAY);
        buttonnormal.setForeground(Color.YELLOW);
        buttonnormal.setEnabled(true);
        this.add(buttonnormal);       
        buttonnormal.addActionListener((ActionEvent ae) -> {  
            buttonst.setEnabled(true);
            buttonst.setForeground(Color.yellow);
            difficulty = 1;
        });  

        //Button Schwer
        buttonschwer.setLocation(470, 450);
        buttonschwer.setSize(150, 60);
        buttonschwer.setText("Schwer");
        buttonschwer.setBackground(Color.DARK_GRAY);
        buttonschwer.setForeground(Color.RED);
        buttonschwer.setEnabled(true);
        this.add(buttonschwer);       
        buttonschwer.addActionListener((ActionEvent ae) -> {  
            buttonst.setEnabled(true);
            buttonst.setForeground(Color.red);
            difficulty = 1.5;
        });   
            
        //Label Schierigkeit
        lblDiff.setLocation(300, 420);
        lblDiff.setSize(180, 20);
        lblDiff.setText("Wähle deine Schwierigkeit aus!");
        lblDiff.setOpaque(true);  
        this.add(lblDiff);
    }
    
    public void starteSpiel(){                
        game.startGame(); 
    }
    
    public void moveButton() {
        buttonleicht.setEnabled(false);
        buttonnormal.setEnabled(false);
        buttonschwer.setEnabled(false);
        buttonleicht.setVisible(false);
        buttonnormal.setVisible(false);
        buttonschwer.setVisible(false);
        lblDiff.setOpaque(false);
        lblDiff.setVisible(false);
    }
    
    public void toggleBtn(){
        if(!this.wasToggled){            
            this.starteSpiel();
            buttonst.setText("pause");
            this.wasToggled = true;           
        }
        else if(this.isToggled){            
            game.pauseGame();
            buttonst.setText("continue");
            this.isToggled = false;
        }
        else if (!this.isToggled){
            game.continueGame();
            buttonst.setText("pause");
            this.isToggled = true;
        }
    }
     
}