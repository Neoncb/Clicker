import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ClickerMain {

  JLabel counterLabel, perSecLabel;
  JButton feature1, feature2, feature3, feature4, CloseOnExit, Open;
  int clickerCounter, timerSpeed;
  double perSecond;                   // use of double because of numbers below 1 
  boolean timerOn;
  Font font1, font2;
  Clicker Click = new Clicker();
  Exiter Exit = new Exiter();
  boolean Visible;
  
  Timer timer;
  
  public static void main(String[] args) {
    
    new ClickerMain();
    
  }
  public ClickerMain() {
    
    timerOn = false;                  // no Auto clicker = Timer off
    perSecond = 0;
    clickerCounter = 0;
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
    window.setSize(1280, 720);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setExtendedState(JFrame.MAXIMIZED_BOTH);       //Maximierung des Fensters
    window.getContentPane().setBackground(Color.white);
    window.setLayout(null);
    
    JPanel ClickerPanel = new JPanel();             //erstelt Clicker Fenster 
    ClickerPanel.setBounds(50, 620, 400, 400);
    ClickerPanel.setBackground(Color.white);
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
    counterPanel.setBounds(50, 420, 200, 80);
    counterPanel.setBackground(Color.black);
    counterPanel.setLayout(new GridLayout(2, 1));
    window.add(counterPanel);
    

    
    counterLabel = new JLabel(clickerCounter + " Beer");   //erstellt die Schrift anzeige
    counterLabel.setForeground(Color.white);
    counterLabel.setFont(font1);
    counterPanel.add(counterLabel);
    
    
    perSecLabel = new JLabel();                 //erstellt die Schrift anzeige
    perSecLabel.setForeground(Color.white);
    perSecLabel.setFont(font2);
    counterPanel.add(perSecLabel);
    
    JPanel Board = new JPanel();
    Board.setBounds(1030, 100, 550, 700);
    Board.setBackground(Color.black);
    Board.setLayout(new GridLayout(1,2));
    window.add(Board);
    
    JPanel ItemPanel = new JPanel();
    ItemPanel.setBackground(Color.gray);
    ItemPanel.setLayout(new GridLayout(4,1));
    Board.add(ItemPanel);
    
    feature1 = new JButton("Hand");
    feature1.setFont(font1);
    feature1.setFocusPainted(false);
    feature1.addActionListener(Click);
    feature1.setActionCommand("Hand");              //spezieller command als return   
    ItemPanel.add(feature1);
    
    feature2 = new JButton("2 Hands");
    feature2.setFont(font1);
    feature2.setFocusPainted(false);
    feature2.addActionListener(Click);
    feature2.setActionCommand("2");              
    ItemPanel.add(feature2);
    
    
    feature3 = new JButton("4 Hands");
    feature3.setFont(font1);
    feature3.setFocusPainted(false);
    feature3.addActionListener(Click);
    feature3.setActionCommand("4");              
    ItemPanel.add(feature3);
    
    feature4 = new JButton("8 Hands");
    feature4.setFont(font1);
    feature4.setFocusPainted(false);
    feature4.addActionListener(Click);
    feature4.setActionCommand("8");              
    ItemPanel.add(feature4);
    
    JPanel Controls = new JPanel();
    Controls.setLayout(new GridLayout(4,1));
    Board.add(Controls);
    
    CloseOnExit = new JButton("X");
    CloseOnExit.setFont(font1);
    CloseOnExit.setFocusPainted(false);
    CloseOnExit.addActionListener(Exit);
    CloseOnExit.setActionCommand("X"); 
    Controls.add(CloseOnExit);
    
    Open = new JButton("Yes");
    Open.setFont(font1);
    Open.setFocusPainted(false);
    Open.addActionListener(Exit);
    Open.setActionCommand("X");
    Open.setVisible(Visible);
    Controls.add(Open);
    
    
    
    
    window.setVisible(true);
  }
    
    public void setTimer()  {
      
      timer = new Timer(timerSpeed, new ActionListener() {        // timerSpeed = millisekunde
        
      @Override
      public void actionPerformed(ActionEvent e){
        
        clickerCounter++;
        counterLabel.setText(clickerCounter + " Beer");  
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
      
      double speed = 1/perSecond*1000;  
      timerSpeed = (int)Math.round(speed);
                
      String s = String.format("%.1f", perSecond);
      perSecLabel.setText("per second " + s);
      
      setTimer();
      timer.start();
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
          perSecond = perSecond + 0.1;
          timerUpdate();
          break;
          
        case"2":
          perSecond = perSecond + 1;
          timerUpdate();
          break;
          
        case"4":
          perSecond = perSecond + 4;
          timerUpdate();
          break;
          
        case"8":
          perSecond = perSecond + 8;
          timerUpdate(); 
          break;
        
      }
      
      

    }


  
  }
  
  public class Exiter implements ActionListener{
    
    public void actionPerformed(ActionEvent e) {
      
      String action = e.getActionCommand();
      
      switch(action) {
      case"X":
        feature1.setVisible(false);
        feature2.setVisible(false);
        feature3.setVisible(false);
        feature4.setVisible(false);
        CloseOnExit.setVisible(false);
        
        Open.setVisible(true);
        
        
      
      }
      
    }
  }
  

}
