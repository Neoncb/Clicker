import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JTextArea;



public class ClickerMain {

  JLabel counterLabel, perSecLabel;
  JButton feature1, feature2, feature3, feature4, CloseOnExit, Open;
  int timerSpeed, beervalue;
  int feature1p, feature2p, feature3p, feature4p;
  int feature1c, feature2c, feature3c, feature4c;
  double clickerCounter;
  double perSecond;                   // use of double because of numbers below 1 
  boolean timerOn;
  Font font1, font2;
  Clicker Click = new Clicker();
  boolean Visible;
  JTextArea messageInfo; 
  MouseMovement mMovement = new MouseMovement();
  
  Timer timer;
  
  public static void main(String[] args) {
    
    new ClickerMain();
    
  }
  
 
    
  
  public ClickerMain() {
    
    
    timerOn = false;            // no Auto clicker = Timer off
    perSecond = 0;
    clickerCounter = 0;
    
    feature1c = 0;
    feature2c = 0;
    feature3c = 0;
    feature4c = 0;
    
    feature1p = 10;
    feature2p = 50;
    feature3p = 150;
    feature4p = 350;
    Visible = false;
   

    
    

    
    createFont();
    InterfaceUI();
    
  }
  public void createFont(){
    
    font1 = new Font("Comic Sans MS", Font.PLAIN, 32); // font name, font style, font size
    font2 = new Font("Comic Sans MS", Font.PLAIN, 15);
    
  }
  
  
    public void InterfaceUI(){
      
    JFrame window = new JFrame();               //erstellt das Fenster 
    window.setSize(1920, 1080);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setExtendedState(JFrame.MAXIMIZED_BOTH);       //Maximierung des Fensters
    window.getContentPane().setBackground(Color.white);
    window.setLayout(null);
    
    JPanel ClickerPanel = new JPanel();             //erstelt Clicker Fenster 
    ClickerPanel.setBounds(720, 400, 210, 210);
    ClickerPanel.setBackground(Color.black);
    ClickerPanel.setLayout(new GridBagLayout());
    window.add(ClickerPanel);
    
    ImageIcon Beerclicker = new ImageIcon(getClass().getClassLoader().getResource("Beer.png")); 
    
    JButton CounterButton = new JButton();            //erstellt Clicker Button 
    CounterButton.setBackground(Color.black);
    CounterButton.setFocusPainted(false);
    CounterButton.setBorder(null);
    CounterButton.setIcon(Beerclicker);
    CounterButton.addActionListener(Click);
    CounterButton.setActionCommand("selfclicks");
    ClickerPanel.add(CounterButton);
    
    
    JPanel counterPanel = new JPanel();             //erstellt Counter Fenster
    counterPanel.setBounds(50, 60, 300, 80);
    counterPanel.setBackground(Color.white);
    counterPanel.setLayout(new GridLayout(2, 1));
    window.add(counterPanel);
    

    
    counterLabel = new JLabel(clickerCounter + " Beer");   //erstellt die Schrift anzeige
    counterLabel.setForeground(Color.black);
    counterLabel.setFont(font1);
    counterPanel.add(counterLabel);
    
    
    perSecLabel = new JLabel();                 //erstellt die Schrift anzeige
    perSecLabel.setForeground(Color.black);
    perSecLabel.setFont(font2);
    counterPanel.add(perSecLabel);
    
    
    
    JPanel Board = new JPanel();
    Board.setBounds(1120, 270, 550, 700);
    Board.setBackground(Color.black);
    Board.setLayout(new GridLayout(2,1)); 
    window.add(Board);
    
    JPanel ItemPanel = new JPanel();
    ItemPanel.setBackground(Color.black);
    ItemPanel.setLayout(new GridLayout(4,1));
    Board.add(ItemPanel);
    
    feature1 = new JButton("Hand");
    feature1.setFont(font1);
    feature1.setFocusPainted(false);
    feature1.addActionListener(Click);
    feature1.setActionCommand("Hand");              //spezieller command als return   
    feature1.addMouseListener(mMovement);
    ItemPanel.add(feature1);
    
    feature2 = new JButton("2 Hands");
    feature2.setFont(font1);
    feature2.setFocusPainted(false);
    feature2.addActionListener(Click);
    feature2.setActionCommand("2");    
    feature2.addMouseListener(mMovement);
    ItemPanel.add(feature2);
    
    feature3 = new JButton("4 Hands");
    feature3.setFont(font1);
    feature3.setFocusPainted(false);
    feature3.addActionListener(Click);
    feature3.setActionCommand("4");    
    feature3.addMouseListener(mMovement);
    ItemPanel.add(feature3);
    
    feature4 = new JButton("8 Hands");
    feature4.setFont(font1);
    feature4.setFocusPainted(false);
    feature4.addActionListener(Click);
    feature4.setActionCommand("8");   
    feature4.addMouseListener(mMovement);
    ItemPanel.add(feature4);
    
    JPanel Controls = new JPanel();
    Controls.setLayout(new GridLayout(4,1));
    Board.add(Controls);
    
    JPanel featureInfo = new JPanel();
    featureInfo.setBounds(1120, 100, 550, 150);
    featureInfo.setBackground(Color.white);
    window.add(featureInfo);
    
    messageInfo = new JTextArea();
    messageInfo.setBounds(1120, 100, 550, 150);
    messageInfo.setForeground(Color.black);
    messageInfo.setBackground(Color.white);
    messageInfo.setFont(font2);
    messageInfo.setLineWrap(true);
    messageInfo.setWrapStyleWord(true);
    messageInfo.setEditable(false);
    featureInfo.add(messageInfo);
    

    window.setVisible(true);
  }
    
    
  
  public class Clicker implements ActionListener{
  
    public void actionPerformed(ActionEvent event) {
      
      String action = event.getActionCommand();
      
      switch(action){                           // Counter geht nur noch hoch wenn Bier geklickt wird
        case"selfclicks":
          clickerCounter++;
          counterLabel.setText(clickerCounter + " Beer");    
          break;
        case"Hand":     
          if(clickerCounter >= feature1p){
            clickerCounter = clickerCounter - feature1p;
            feature1p = feature1p + 5;
            counterLabel.setText(clickerCounter + " Beer");
            feature1c++;
            feature1.setText("Hand " + "|" +feature1c + "|");
            perSecond = perSecond + 0.1;
            timerUpdate();
          }
          break;
          
        case"2":
          if(clickerCounter >= feature2p){
            clickerCounter = clickerCounter - feature2p;
            feature2p = feature2p + 10;
            counterLabel.setText(clickerCounter + " Beer");
            feature2c++;
            feature2.setText("2 Hands" + "|" + feature2c + "|");
            perSecond = perSecond + 1;
            timerUpdate();
        }
          break;
          
        case"4":
          if(clickerCounter >= feature3p){
            clickerCounter = clickerCounter - feature3p;
            feature3p = feature3p + 30;
            counterLabel.setText(clickerCounter + " Beer");
            feature3c++;
            feature3.setText("4 Hands" + "|" + feature3c + "|");
            perSecond = perSecond + 4;
            timerUpdate(); 
          }

          
          break;
          
        case"8":
          if(clickerCounter >= feature4p){
            clickerCounter = clickerCounter - feature4p;
            feature4p = feature4p + 50;
            counterLabel.setText(clickerCounter + " Beer");
            feature4c++;
            feature4.setText("8 Hands" + "|" + feature4c + "|");
            perSecond = perSecond + 8;
            timerUpdate();  
          }

           
          break;
        
      }
      
      

    }


  
  }
  
   public void setTimer()  {
      
      timer = new Timer(timerSpeed, new ActionListener() {        // timerSpeed = millisekunde
        
      @Override
      public void actionPerformed(ActionEvent e){
        
        clickerCounter = clickerCounter + perSecond;
        String b = String.format("%.1f", clickerCounter);
        counterLabel.setText(b + " Beer");  
      } 
      
      });   
    } 
  
  
  public void timerUpdate() {
      
     if(timerOn==false) {
      timerOn=true;
     }
     else if(timerOn==true) {
     timer.stop();
     }
      
      double speed = 1000;  
      timerSpeed = (int)Math.round(speed);
                
      String s = String.format("%.1f", perSecond);
      perSecLabel.setText("per second " + s);
      
      setTimer();
      timer.start();
    }
  
  public class MouseMovement implements MouseListener{
    
    @Override 
    public void mouseClicked(MouseEvent e){
      
    }
    @Override
    public void mouseEntered(MouseEvent e){
    	JButton button = (JButton)e.getSource();
    	
        if(button == feature1) {
        	messageInfo.setText("Hand\n|price| " + feature1p + "\n Proceedes to get one Hand every 10 seconds");
        }
        else if(button == feature2) {
        	messageInfo.setText("2 Hands \n|price| " + feature2p + "\n Proceedes to get two Hand every 10 seconds");
        }
        else if(button == feature3) {
        	messageInfo.setText("4 Hands \n|price| " + feature3p + "\n Proceedes to get four Hand every 10 seconds");
        }
        else if(button == feature4) {
        	messageInfo.setText("8 Hands \n|price| " + feature4p + "\n Proceedes to get eight Hand every 10 seconds");
        }
    } 
    @Override
    public void mouseExited(MouseEvent e){
    	JButton button = (JButton)e.getSource();
    	
    	if(button == feature1) {
    		messageInfo.setText(null);
    	}
    	else if(button == feature2) {
    		messageInfo.setText(null);
    	}
    	else if(button == feature3) {
    		messageInfo.setText(null);
    	}
    	else if(button == feature4) {
    		messageInfo.setText(null);
    	}
    }
    @Override
    public void mousePressed(MouseEvent e){
      
    }
    @Override
    public void mouseReleased(MouseEvent e){
      
    }

  }

  

}
