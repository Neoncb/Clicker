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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JTextArea;



public class ClickerMain {


  JFrame window;
  JLabel counterLabel, perSecLabel, PrestigeLabel;                         //Definition der Label
  JButton feature1, feature2, feature3, feature4, feature5, close;         //Definition Buttons der Features
  JPanel ItemPanel, PrestigeP;                                             //Definition der Panel
  int timerSpeed;                                                          //Definition Geschwindigkeit des timeres
  int feature1p, feature2p, feature3p, feature4p, feature5p;               //Definition Preis der features
  int feature1c, feature2c, feature3c, feature4c, feature5c;               //Definition Anzahl der features
  double clickerCounter;                                                   //Definition Anzahl von Bier
  double perSecond;                                                        //Definition passive income 
  boolean timerOn;                                                         //Definition Aktivität des timers
  Font font1, font2, font3;                                                //Definition Schriftarten
  Clicker Click = new Clicker();                                           //Definition class Clicker
  boolean Visible;                                                         //Definition Sichtbarkeit des Panels
  JTextArea messageInfo;                                                   //Definition Beschreibung der features
  MouseMovement mMovement = new MouseMovement();                           //Definition Standort der Maus
  Prestiger p = new Prestiger();                                           //Definition class Prestiger
  closing c = new closing();                                               //Definition class closing
  int click;                                                               //Definition Klickmultiplikator
  int multiplicator;                                                       //Definition passive income multiplikator


  JButton Prestige, MouseClick, Pcum;                                      //Definition Buttons für Prestigefeatures
  int crowncapp;                                                           //Definition Prestigewährung 
  int mouseClickp, Pcump;                                                  //Definition Preise der Prestigefeatures


  Timer timer;

  public static void main(String[] args) {

    new ClickerMain();

  }




  public ClickerMain() {

    timerOn = false;            // no Auto clicker = Timer off
    perSecond = 0;              // passive income = 0
    clickerCounter = 0;         // Startwert des Biers = 0
    click = 1;
    multiplicator = 1;

    feature1c = 0;              // Anzahl des features = 0
    feature2c = 0;              // Anzahl des features = 0
    feature3c = 0;              // Anzahl des features = 0
    feature4c = 0;              // Anzahl des features = 0
    feature5c = 0;              // Anzahl des features = 0

    feature1p = 10;             // Preis des 1. features = 10
    feature2p = 50;             // Preis des 2. features = 50
    feature3p = 150;            // Preis des 3. features = 150
    feature4p = 350;            // Preis des 4. features = 350
    feature5p = 500;            // Preis des 5. features = 500

    crowncapp = 0;
    mouseClickp = 100;
    Pcump = 250;








    createFont();
    InterfaceUI();

  }
  public void createFont(){                                //Schriftartenerstellung (Anfang)

    font1 = new Font("Comic Sans MS", Font.PLAIN, 32); 
    font2 = new Font("Comic Sans MS", Font.PLAIN, 15);
    font3 = new Font("SansSerif MS", Font.BOLD, 50);       //Schriftartenerstellung (Ende)

  }


  public void InterfaceUI(){

    window = new JFrame();                                 //erstellt das Fenster (Anfang)
    window.setSize(1920, 1080);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setExtendedState(JFrame.MAXIMIZED_BOTH);       
    window.getContentPane().setBackground(Color.white);
    window.setLayout(null);                                //erstellt das Fenster (Ende)

    JPanel ClickerPanel = new JPanel();                    //erstellt Clickerfenster (Anfang) 
    ClickerPanel.setBounds(720, 400, 210, 210);
    ClickerPanel.setBackground(Color.black);
    ClickerPanel.setLayout(new GridBagLayout());
    window.add(ClickerPanel);                              //erstellt Clickerfenster  (Ende)

    ImageIcon Beerclicker = new ImageIcon(getClass().getClassLoader().getResource("Beer.png")); //Definition Bierbild

    JButton CounterButton = new JButton();                 //erstellt Clicker Button mit Bild im Clickerfenster  (Anfang)
    CounterButton.setBackground(Color.black);
    CounterButton.setFocusPainted(false);
    CounterButton.setBorder(null);
    CounterButton.setIcon(Beerclicker);
    CounterButton.addActionListener(Click);
    CounterButton.setActionCommand("selfclicks");
    ClickerPanel.add(CounterButton);                       //erstellt Clicker Button mit Bild im Clickerfenster  (Ende)


    JPanel counterPanel = new JPanel();                    //erstellt Counterpanel (Anfang)
    counterPanel.setBounds(50, 100, 300, 130);
    counterPanel.setBackground(Color.white);
    counterPanel.setLayout(new GridLayout(3, 1));
    window.add(counterPanel);                              //erstellt Counterpanel (Ende)



    counterLabel = new JLabel(clickerCounter + " Beer");   //erstellt die Schriftanzeige im Counterfenster für Beers (Anfang)
    counterLabel.setForeground(Color.black);
    counterLabel.setFont(font1);
    counterPanel.add(counterLabel);                        //erstellt die Schriftanzeige im Counterfenster für Beers (Ende)


    perSecLabel = new JLabel();                            //erstellt die Schriftanzeige für den Passiveincome (Anfang)
    perSecLabel.setForeground(Color.black);
    perSecLabel.setFont(font2);
    counterPanel.add(perSecLabel);                         //erstellt die Schriftanzeige für den Passiveincome  (Ende)

    PrestigeLabel = new JLabel("Crown Cap " + "|" + crowncapp + "|" );   //erstellt die Schriftanzeige im Counterfenster für Crown Caps (Anfang)
    PrestigeLabel.setForeground(Color.black);
    PrestigeLabel.setFont(font1);
    counterPanel.add(PrestigeLabel);                                     //erstellt die Schriftanzeige im Counterfenster für Crown Caps (Ende)


    ItemPanel = new JPanel();                   //erstellt Panel für features (Anfang)
    ItemPanel.setBounds(1120, 270, 550, 700);
    ItemPanel.setBackground(Color.black);
    ItemPanel.setLayout(new GridLayout(5,1));
    ItemPanel.setVisible(true);
    window.add(ItemPanel);                      //erstellt Panel für features (Ende)

    feature1 = new JButton("Hand");             //Button für feature "Hand"    (Anfang)
    feature1.setFont(font1);
    feature1.setFocusPainted(false);
    feature1.addActionListener(Click);
    feature1.setActionCommand("Hand");                 
    feature1.addMouseListener(mMovement);
    ItemPanel.add(feature1);                    //Button für feature "Hand"    (Ende)

    feature2 = new JButton("2 Hands");          //Button für feature "2 Hands" (Anfang)
    feature2.setFont(font1);
    feature2.setFocusPainted(false);
    feature2.addActionListener(Click);
    feature2.setActionCommand("2");    
    feature2.addMouseListener(mMovement);
    ItemPanel.add(feature2);                    //Button für feature "2 Hands" (Ende)

    feature3 = new JButton("4 Hands");          //Button für feature "4 Hands" (Anfang)
    feature3.setFont(font1);
    feature3.setFocusPainted(false);
    feature3.addActionListener(Click);
    feature3.setActionCommand("4");    
    feature3.addMouseListener(mMovement);
    ItemPanel.add(feature3);                    //Button für feature "4 Hands" (Ende)

    feature4 = new JButton("8 Hands");          //Button für feature "8 Hands" (Anfang)
    feature4.setFont(font1);
    feature4.setFocusPainted(false);
    feature4.addActionListener(Click);
    feature4.setActionCommand("8");   
    feature4.addMouseListener(mMovement);
    ItemPanel.add(feature4);                    //Button für feature "8 Hands"   (Ende)

    feature5 = new JButton("16 Hands");         //Button für feature "16 Hands"  (Anfang)
    feature5.setFont(font1);
    feature5.setFocusPainted(false);
    feature5.addActionListener(Click);
    feature5.setActionCommand("16");
    feature5.addMouseListener(mMovement);
    ItemPanel.add(feature5);                    //Button für feature "16 Hands"  (Ende)


    JPanel featureInfo = new JPanel();          //erstellt Fläche für die Beschreibung der features (Anfang)
    featureInfo.setBounds(1120, 100, 550, 150);
    featureInfo.setBackground(Color.white);
    window.add(featureInfo);                    //erstellt Fläche für die Beschreibung der features (Ende)


    messageInfo = new JTextArea();              //erstellt Beschreibung für die features (Anfang)
    messageInfo.setBounds(1120, 100, 550, 150);
    messageInfo.setForeground(Color.black);
    messageInfo.setBackground(Color.white);
    messageInfo.setFont(font2);
    messageInfo.setLineWrap(true);
    messageInfo.setWrapStyleWord(true);
    messageInfo.setEditable(false);
    featureInfo.add(messageInfo);              //erstellt Beschreibung für die features (Ende)

    PrestigeP = new JPanel();                  //erstellt prestige Panel (Anfang)
    PrestigeP.setBounds(1120, 270, 550, 420);
    PrestigeP.setBackground(Color.black);
    PrestigeP.setLayout(new GridLayout(3,1));
    PrestigeP.setVisible(false);
    window.add(PrestigeP);                     //erstellt prestige Panel (Ende)

    Prestige = new JButton("Prestige");        //Button für feature "Prestige"  (Anfang)
    Prestige.setFont(font1);
    Prestige.setFocusPainted(false);
    Prestige.addActionListener(p);
    Prestige.setActionCommand("zero");
    Prestige.addMouseListener(mMovement);
    PrestigeP.add(Prestige);                   //Button für feature "Prestige"  (Ende)

    MouseClick = new JButton("POWWAAA");       //Button für feature "POWWAAA"  (Anfang)
    MouseClick.setFont(font1);
    MouseClick.addActionListener(p);
    MouseClick.setActionCommand("MouseClick");
    MouseClick.addMouseListener(mMovement);
    PrestigeP.add(MouseClick);                 //Button für feature "Prestige"  (Ende)

    Pcum = new JButton("Passiv Beer");         //Button für feature "Passiv Beer"  (Anfang)
    Pcum.setFont(font1);
    Pcum.addActionListener(p);
    Pcum.setActionCommand("Passive");
    Pcum.addMouseListener(mMovement);
    PrestigeP.add(Pcum);                       //Button für feature "Prestige"  (Ende)

    JLabel Name = new JLabel();                //erstellt Titel des Spiels (Anfang)
    Name.setBounds(50, 20, 350, 100);
    Name.setBackground(Color.white);
    Name.setForeground(Color.black);
    Name.setFont(font3);
    Name.setText("Beer clicker");
    window.add(Name);                          //erstellt Titel des Spiels (Ende)

    JPanel closep = new JPanel();              //erstellt close panel (Anfang)
    closep.setBounds(1670, 270, 140, 700);
    closep.setLayout(new GridLayout(1,1));
    window.add(closep);                        //erstellt close panel (Ende)

    close = new JButton("<html> P <br> R <br> E <br> S<br> T<br> I<br> G <br>E</html>"); //erstellt Button für prestige/normal Tausch (Anfang)
    close.setForeground(Color.black);
    close.setFont(font1);
    close.setBackground(Color.red);
    close.addActionListener(c);
    close.setActionCommand("close");
    closep.add(close);                                                                   //erstellt Button für prestige/normal Tausch (Ende)


    window.setVisible(true);
  }



  public class Clicker implements ActionListener{

    public void actionPerformed(ActionEvent event) {

      String action = event.getActionCommand();

      switch(action){                                                 // definiert die Klicks des Spielers
      case"selfclicks":                                             //Klick auf beerimage (Anfang)
        clickerCounter = clickerCounter + click;                                           //erhöht den aktuellen Stand
        counterLabel.setText(clickerCounter + " Beer");             //aktualisiert die Schriftanzeige im Counterfenster
        break;                                                      //Klick auf beerimage (Ende)
          
      case"Hand":                                                   //Klick auf feature "hand" (Anfang)
        if(clickerCounter >= feature1p){                            //feature nur möglich, wenn der Spieler genügend Bier hat
          clickerCounter = clickerCounter - feature1p;              //zieht die Kosten des features ab
          feature1p = feature1p + 5;                                //erhöht die Kosten nach einem Kauf
          counterLabel.setText(clickerCounter + " Beer");           //aktualisiert die Schriftanzeige im Counterfenster
          feature1c++;                                              //erhöht den featurecounter für die Anzahl des features
          feature1.setText("Hand " + "|" +feature1c + "|");         //aktualisiert Schriftanzeige für den featurecounter
          perSecond = perSecond + 0.1;                              //erhöht die Generation an passivem Bier
          timerUpdate();                                            //aktualisiert den Timer, welche das Bier generiert
        }
        break;                                                      //Klick auf feature "hand" (Ende)

      case"2":                                                     //Klick auf feature "2 Hands" (Anfang)
        if(clickerCounter >= feature2p){                           //siehe Erklärung "Klick auf feature Hand"
          clickerCounter = clickerCounter - feature2p;
          feature2p = feature2p + 10;
          counterLabel.setText(clickerCounter + " Beer");
          feature2c++;
          feature2.setText("2 Hands" + "|" + feature2c + "|");
          perSecond = perSecond + 1;
          timerUpdate();
        }
        break;                                                     //Klick auf feature "2 Hands" (Ende)

      case"4":                                                     //Klick auf feature "4 Hands" (Anfang)
        if(clickerCounter >= feature3p){                           //siehe Erklärung "Klick auf feature Hand"
          clickerCounter = clickerCounter - feature3p;
          feature3p = feature3p + 30;
          counterLabel.setText(clickerCounter + " Beer");
          feature3c++;
          feature3.setText("4 Hands" + "|" + feature3c + "|");
          perSecond = perSecond + 4;
          timerUpdate(); 
        }
        break;                                                     //Klick auf feature "4 Hands" (Ende)

      case"8":                                                     //Klick auf feature "8 Hands" (Anfang)
        if(clickerCounter >= feature4p){                           //siehe Erklärung "Klick auf feature Hand"
          clickerCounter = clickerCounter - feature4p;
          feature4p = feature4p + 50;
          counterLabel.setText(clickerCounter + " Beer");
          feature4c++;
          feature4.setText("8 Hands" + "|" + feature4c + "|");
          perSecond = perSecond + 8;
          timerUpdate();  
        }
        break;                                                     //Klick auf feature "8 Hands" (Ende)
          
      case"16":                                                    //Klick auf feature "16 Hands" (Anfang)
        if(clickerCounter >= feature5p) {                          //siehe Erklärung "Klick auf feature Hand"
          clickerCounter = clickerCounter - feature5p;
          feature5p = feature5p + 100;
          counterLabel.setText(clickerCounter + " Beer");
          feature5c++;
          feature5.setText("16 Hands" + "|" + feature5c + "|");
          perSecond = perSecond + 16;
          timerUpdate();
        }
        break;                                                     //Klick auf feature "16 Hands" (Ende)

      }



    }



  }



  public class Prestiger implements ActionListener{


    public void actionPerformed(ActionEvent e) {

      String action = e.getActionCommand();

      switch(action) {
      case "zero":                                                            //Klick auf button "Prestige" (Anfang)
        if(clickerCounter >= 100) {                                             //wenn Clickercounter < 100 passiert nichts, ansonsten:

          crowncapp = crowncapp + (int) (clickerCounter / 100);                 //crowncapp erhält ein hundertstel von clickerCounter
          crowncapp = (int)Math.round(crowncapp);


          PrestigeLabel.setText("Crown cap" + "|" + crowncapp + "|" );          //crowncap Anzeige wird aktualisiert




          timerOn = false;                                                      //Zurücksetzung des bisherigen Spielfortschritts (außer der Prestigewährung und des Prestigefeatures) (Anfang)
          perSecond = 0;             
          clickerCounter = 0;        

          feature1c = 0;              
          feature2c = 0;              
          feature3c = 0;              
          feature4c = 0;              
          feature5c = 0;              

          feature1p = 10;             
          feature2p = 50;             
          feature3p = 150;            
          feature4p = 350;            
          feature5p = 500; 

          feature1.setText("Hand" + "|" + feature1c + "|");
          feature2.setText("2 Hands" + "|" + feature2c + "|");
          feature3.setText("4 Hands" + "|" + feature3c + "|");
          feature4.setText("8 Hands" + "|" + feature4c + "|");
          feature5.setText("16 Hands" + "|" + feature5c + "|");

          timerUpdate();                                                        //Zurücksetzung des bisherigen Spielfortschritts (außer der Prestigewährung und des Prestigefeatures) (Ende)


        }
        break;                                                                //Klick auf button "Prestige" (Ende)

      case "MouseClick":                                                      //Klick auf button "POWWAAA" (Anfang)
        if(crowncapp >= mouseClickp) {                                          //wenn genügend crown caps (>=mouseClickp):
          crowncapp = crowncapp - mouseClickp;                                  //Abzug der ausgegebenen crown caps
          PrestigeLabel.setText("Crown cap" + "|" + crowncapp + "|" );          //Aktualisierung der crown caps
          click++;                                                              //Erhöhung des Klickmultiplikators
          MouseClick.setText("POWWAAA" + "|"+ click + "|");                     //Aktualisierung des featurecounters
          mouseClickp = mouseClickp * 2;                                        //Erhöhung des Preises

        }
        break;                                                                //Klick auf button "Prestige" (Ende)

      case "Passive":                                                         //Klick auf "Passiv Beer" (Anfang)
        if(crowncapp >= Pcump) {                                                //wenn geügend crown caps (>=Pcump)
          crowncapp = crowncapp - Pcump;                                        //Abzug der ausgegebenen crown caps
          PrestigeLabel.setText("Crown cap" + "|" + crowncapp + "|" );          //Aktualisierung der crown caps
          multiplicator++;                                                      //Erhöhung des passive income multiplikators
          Pcum.setText("Passive Beer" + "|" + multiplicator + "|");             //Aktualisierung des featurecounters
          timerUpdate();                                                        //Erhöhung des Preises
          Pcump = Pcump * 2;

        }
        break;                                                                //Klick auf "Passiv Beer" (Ende)

      }


    }

  }

  public class closing implements ActionListener{


    
    public void actionPerformed(ActionEvent e) {
      String action = e.getActionCommand();

      switch(action) {                                                                  
      case "close":                                                                     //Klick auf "Prestige"/"Normal" (Anfang)
        if(ItemPanel.isVisible()) {                                                       //wenn normal visible:
          ItemPanel.setVisible(false);                                                      //mach normal unvisible
          PrestigeP.setVisible(true);                                                       //und prestige visible
          close.setText("<html>N<br> O<br> R<br> M<br> A<br> L</html>");                    //wechsle Text auf NORMAL
          close.setBackground(Color.blue);                                                  //wechsle Hintergrund auf blau
          
        }else {                                                                           //ansonsten:
          ItemPanel.setVisible(true);                                                       //mach normal visible
          PrestigeP.setVisible(false);                                                      //und prestige unvisible                                                 
          close.setBackground(Color.red);                                                   //wechsle Hintergrund auf rot
          close.setText("<html> P <br> R <br> E <br> S<br> T<br> I<br> G <br>E</html>");    //wechsle Text auf PRESTIGE
        }
        break;                                                                          //Klick auf "Prestige"/"Normal" (Ende)
      }
      
    }
  }

  public void setTimer()  {

    timer = new Timer(timerSpeed, new ActionListener() {         // timerSpeed in millisekunden

      @Override
      public void actionPerformed(ActionEvent e){

        clickerCounter = clickerCounter + (perSecond * multiplicator);          //Anzahl an Bier wird von der Anzahl an generierten Bier erhöht
        String b = String.format("%.1f", clickerCounter);                       //Aktualisierung des Textfeldes, welches die Anzahl an Bier anzeigt
        counterLabel.setText(b + " Beer");                                      //Aktualisierung des Textfeldes, welches die Anzahl an Bier anzeigt


      } 

    });   
  } 


  public void timerUpdate() {                               //Aktualisierung des timers 

    if(timerOn==false) {                                   
      timerOn=true;
    }
    else if(timerOn==true) {
      timer.stop();
    }

    double speed = 1000;                                   //Timerupdate alle 1000 millisekunden (1s)
    timerSpeed = (int)Math.round(speed);

    String s = String.format("%.1f", perSecond);           //Aktualisierung des Textfeldes, welches dden passive income anzeigt
    perSecLabel.setText("per second " + s);                //Aktualisierung des Textfeldes, welches dden passive income anzeigt

    setTimer();
    timer.start();
  }

  public class MouseMovement implements MouseListener{                                                             //beinhaltet Methoden die mit dem Standort des Mauszeigers zu tun haben (Anfang)

    @Override 
    public void mouseClicked(MouseEvent e){

    }
    @Override
    public void mouseEntered(MouseEvent e){
      JButton button = (JButton)e.getSource();

      if(button == feature1) {                                                                                              //hover der Maus über feature "Hand"
        messageInfo.setText("Hand\n|price| " + feature1p + "\n Proceedes to get one beer every 10 seconds");                //legt die Beschreibung des features fest
      }
      else if(button == feature2) {                                                                                         //hover der Maus über feature "2 Hands"
        messageInfo.setText("2 Hands \n|price| " + feature2p + "\n Proceedes to get two beer every 10 seconds");            //legt die Beschreibung des features fest
      }
      else if(button == feature3) {                                                                                         //hover der Maus über feature "4 Hands"
        messageInfo.setText("4 Hands \n|price| " + feature3p + "\n Proceedes to get four beer every 10 seconds");           //legt die Beschreibung des features fest
      }
      else if(button == feature4) {                                                                                         //hover der Maus über feature "8 Hands"
        messageInfo.setText("8 Hands \n|price| " + feature4p + "\n Proceedes to get eight beer every 10 seconds");          //legt die Beschreibung des features fest
      }                                                                                                          
      else if(button == feature5) {                                                                                         //hover der Maus über feature "16 Hands"
        messageInfo.setText("16 Hands \n|price| " + feature5p + "\n Proceedes to get 16 beer every 10 seconds");            //legt die Beschreibung des features fest
      }
      else if(button == MouseClick) {                                                                                       //hover der Maus über feature "POWWAAA"
        messageInfo.setText("POWWAAA \n|price|"  + mouseClickp + "\n Multiplies your Clickpower by " + (click + 1));        //legt die Beschreibung des features fest
      }
      else if(button == Pcum) {                                                                                               //hover der Maus über feature "Passiv Beer"
        messageInfo.setText("Passive Beer \n|price|"  + Pcump + "\n Multiplies your passive Beer by " + (multiplicator + 1)); //legt die Beschreibung des features fest
      }
      else if(button == Prestige) {                                                                                                                                                                      //hover der Maus über feature "Prestige"
        messageInfo.setText("Prestige\n" +"You lose all your progress and change your beer into crown caps\n " + "100 beer equals 1 crown cap\n" + "You can spend the crown caps on permanent upgrades");//legt die Beschreibung des features fest 
      }                                                                                                                     //beinhaltet Methoden die mit dem Standort des Mauszeigers zu tun haben (Ende)


    } 
    @Override
    public void mouseExited(MouseEvent e){         //Methode legt fest, dass die Beschreibung des features entfernt wird, wenn die Maus den Button verlässt (Anfang)
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
      else if(button == feature5) {
        messageInfo.setText(null);
      }
      else if(button == Prestige) {
        messageInfo.setText(null);
      }
      else if(button == MouseClick) {
        messageInfo.setText(null);
      }
      else if(button == Pcum) {
        messageInfo.setText(null);
      }                                            //Methode legt fest, dass die Beschreibung des features entfernt wird, wenn die Maus den Button verlässt (Ende)

    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseReleased(MouseEvent e){

    }

  }



}
