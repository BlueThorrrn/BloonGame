package bloongame;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

// Bloondelte in Lamda vom btn durch bloonList.remove(this);    

public class Game extends JPanel{
    
    private ArrayList<Bloon> bloonList = new ArrayList<Bloon>();
    private ArrayList<Bloon> deleteList = new ArrayList<Bloon>();
    private Statistik statistik = new Statistik();
    private Random rnd = new Random();
    private Timer t;
    private int time = 0;
    private int leben = 20;
    private int points = 0;
    private int bloonCounter;
    private double spawnRate = 3.0; //Bloons pro 5sec

    
    
    public Game(){
        this.setSize(780, 400);  
        this.setBackground(Color.gray);
        this.setLayout(null);
        statistik.setLocation(this.getWidth()-statistik.getWidth() , 0); 
        this.add(statistik);        
        
        t = new Timer(50, (ActionEvent ae) -> {            
            this.gameLoop();                       
        });
        
    }
    
    public void startGame(){
        t.start();        
        for (int i = 0; i < rnd.nextInt(4)+5; i++) {
            this.createBloon();  
            this.add(bloonList.get(i));            
        }  
    }    
    
    public void gameLoop(){
        this.checkDeleteLsit();
        for (int i = 0; i < bloonList.size(); i++) {
            this.bloonBewegen(i);
            this.add(bloonList.get(i));
        }
        statistik.refresh(this.time, this.leben, this.points);
        this.time += t.getInitialDelay();        
        this.newBloons();
        this.repaint();
    }    
    
    public void createBloon(){
        Bloon newBloon = new Bloon(rnd.nextInt(3));               
        newBloon.setLocation(rnd.nextInt(this.getWidth() - statistik.getWidth() - 60)+30, rnd.nextInt(this.getHeight() - 60)+30);   
        newBloon.setSpawnTime(this.time);
        
        newBloon.addActionListener((ActionEvent ae) -> {                        
            this.addBloonCounter(); 
            this.addPoints(4 - newBloon.getDmg());   
            deleteList.add(newBloon); 
            this.remove(newBloon); 
        });         
        bloonList.add(newBloon);
    }
    
    public void newBloons(){        
        if(rnd.nextInt(100) <= this.spawnRate){
            this.createBloon();
            this.spawnRate();
        }        
    }
    
    public void bloonBewegen(int a){
        
        int borderO = 0;
        int borderU = this.getHeight();
        
        int borderL = 0;
        int borderR = this.getWidth() - statistik.getWidth();        
                
        Bloon b = bloonList.get(a);
               
        if(  b.getX() <= borderL ||  b.getX() + b.getWidth() >= borderR){  
            this.despawn(a);
            bloonList.get(a).setRichtungX(-b.getRichtungX());            
        }
        else if(b.getY() <= borderO){
            this.despawn(a);
            bloonList.get(a).setLocation(b.getX(), borderO);
            bloonList.get(a).setRichtungY(-b.getRichtungY());
        }
        else if(b.getY() + b.getHeight() >= borderU){
            this.despawn(a);
            bloonList.get(a).setLocation(b.getX(), borderU-b.getHeight());
            bloonList.get(a).setRichtungY(-b.getRichtungY());
        } 
        bloonList.get(a).setLocation(b.getX() + (b.getRichtungX()), b.getY()+(b.getRichtungY()));        
        
    }
    
    public void checkDeleteLsit(){
        for (int i = 0; i < this.deleteList.size(); i++) {
            this.remove(deleteList.get(i));
            this.bloonList.remove(deleteList.get(i));            
        }        
    }
    
    public void despawn(int a){        
        if(rnd.nextInt(100) <= 20 && this.bloonList.get(a).getSpawnTime() + 2000 <= this.time){
            this.remove(this.bloonList.get(a));
            deleteList.add(this.bloonList.get(a));
            this.removeLeben(this.bloonList.get(a).getDmg());
        } 
    }    
    
    public void addBloonCounter() { //vielleicht anderer Name
        this.bloonCounter ++;
    }
    
    public void addPoints(int points){
        this.points += points;
    }
    
    public void removeLeben(int dmg){
        this.leben -= dmg;
        if(leben <= 0){
            this.endGame();
        }        
    }

    public void endGame() {        
        this.t.stop();
    }
    
    public void pauseGame(){
        t.stop();
    }
    
    public void continueGame(){
        t.start();
        this.endScene();
    }
    
    public void restartGame(){
        t.stop();
        t.restart();
        for (int i = 0; i < bloonList.size(); i++) {
            this.remove(bloonList.get(i));            
        }    
        this.repaint();    
        this.bloonList.clear();
        
    }  
    
    public void endScene(){
        // Endstats + ieleicht animation (eigenes Panel?)
    }
 
    public void spawnRate(){
        if (spawnRate <= 8) {
            this.spawnRate = spawnRate + 0.1;            
        }        
    }
    
}
