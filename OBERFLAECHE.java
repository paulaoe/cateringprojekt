


import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JOptionPane;               
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;

/**
 * Realisiert die Bedienoberfläche.
 * 
 * @author  
 * @version 1.0
 */




class OBERFLAECHE implements OBERFLAECHENINTERFACE, MELDUNGSBEOBACHTER
{
    Font font = new Font("Arial", Font.PLAIN, 18);
    private static final int breite = 800;
    private static final int hoehe = 700;
    private JFrame fenster;
    private JPanel anmeldeJPanel;
    private JPanel kundeAuswahlJPanel;
    //private JPanel kundeArbeitJPanel;
    private JPanel angestellterAuswahlJPanel;
    private JLabel l;
    private JButton b;
    private JButton abmelden, beenden;
    //private JButton kontoWaehlen, kontoAnlegen, kontoLoeschen, kontoAuszuege;
    //private JButton angestelltenLoeschen, kundeLoeschen;
    private JComboBox wahlMo;    
    private JComboBox wahlDi;
    private JComboBox wahlMi;
    private JComboBox wahlDo;
    private JComboBox wahlFr;
    private JComboBox angestelltenwahl;
    private JTextField anmeldeJPanel_name;
    private JTextField anmeldeJPanel_pin;
    private JTextField gMo1;
    private JTextField gMo2;
    private JTextField gDi1;
    private JTextField gDi2;
    private JTextField gMi1;
    private JTextField gMi2;
    private JTextField gDo1;
    private JTextField gDo2;
    private JTextField gFr1;
    private JTextField gFr2;
    
    
    // private JTextField angestelltenJPanel_name;
    // private JTextField angestelltenJPanel_pin;
    // private JTextField angestelltenJPanel_wert;
    // private JTextField angestelltenJPanel_name2;
    // private JTextField angestelltenJPanel_pin2;
    // private JTextField pin_neu_1, pin_neu_2;
    // private JLabel aktKontoFuerKunde, kontostandFuerKunde;
    // private JLabel verwendungFuerWert;
    // private JTextField kundeArbeitJPanel_betrag;
     private JLabel status;
     private JLabel fehler;
     private JLabel frage;
    // private JLabel angestellter_kunde;
     private JDialog fehlermeldung;
     private JDialog textanzeige;
     private JDialog nachfrage;
     private JDialog loganzeige;
     private JTextArea anzeigetext;
    private JTextArea logtext;
    // private ButtonGroup  kontoart;
    // private JCheckBox sparkonto, girokonto;
    private KONTROLLEURINTERFACE kontroller;
    // Antwort auf den FragenJDialog
    private boolean antwort;

    /**
     * Ezeugt alle Bedienelemente
     */
    OBERFLAECHE (KONTROLLEURINTERFACE k)
    
    {
       kontroller = k;
        
        kontroller. OberflaecheSetzen (this);
        // Fenster
        fenster = new JFrame ("Super Lecker - Catering");
        fenster. setSize (breite + 20, hoehe);
        fenster. setLocation (50, 50);
        fenster. setResizable (false);
        fenster. setLayout (null);
        fenster. addWindowListener (new WindowAdapter () {
            public void windowClosing (WindowEvent e)
            {
                // Nothalt
                kontroller. BeendenAusfuehren ();
            }
        });
         status = new JLabel ();
         status. setSize (breite, 20);
         status. setLocation (10, hoehe - 20);
         status. setText ("Status: keine Meldung");
         status. setVisible (true);
         fenster. add (status);
        abmelden = new JButton ();
       abmelden.setFont(font);
        abmelden. setSize (130, 30);
        abmelden. setLocation (breite - 140, hoehe - 100);
        abmelden. setLabel ("Abmelden");
        abmelden. setEnabled (false);
        abmelden. setVisible (true);
        fenster. add (abmelden);
        abmelden. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                kontroller. AbmeldenAusfuehren ();
            }
        });
        beenden = new JButton ();
        beenden.setFont(font);
        beenden. setSize (130, 30);
        beenden. setLocation (breite - 260, hoehe - 100);
        beenden. setLabel ("Beenden");
        beenden. setVisible (true);
        fenster. add (beenden);
        beenden. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                kontroller. BeendenAusfuehren ();
            }
        });
        AnmeldeJPanelAufbauen ();
        KundenauswahlJPanelAufbauen ();
        //KundenarbeitsJPanelAufbauen ();
        AngestelltenauswahlJPanelAufbauen ();
        
       
        
        // FehlerJDialog
        fehlermeldung = new JDialog (fenster, "Fehlermeldungen", true);
        fehlermeldung. setSize (400, 150);
        fehlermeldung. setLocation (100, 80);
        fehlermeldung. setResizable (false);
        fehlermeldung. setLayout (null);
        fehlermeldung. setVisible (false);
        fehler = new JLabel ();
        fehler. setSize (400, 20);
        fehler. setLocation (0, 40);
        fehler. setText ("");
        
        //fehler. setAlignment (JLabel. CENTER);
        fehler. setVisible (true);
        fehlermeldung. add (fehler);
        b = new JButton ();
        b. setSize (100, 30);
        b. setLocation (150, 80);
        b. setLabel ("Schliessen");
        b. setVisible (true);
        fehlermeldung. add (b);
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                fehlermeldung. setVisible (false);
            }
        });
        
        // Nachfrage
        nachfrage = new JDialog (fenster, "", true);
        nachfrage. setSize (400, 150);
        nachfrage. setLocation (100, 80);
        nachfrage. setResizable (false);
        nachfrage. setLayout (null);
        nachfrage. setVisible (false);
        frage = new JLabel ();
        frage. setSize (400, 20);
        frage. setLocation (0, 40);
        frage. setText ("");
       //frage.setAlignment (JLabel. CENTER);
        frage. setVisible (true);
        nachfrage. add (frage);
        b = new JButton ();
        b. setSize (100, 30);
        b. setLocation (50, 80);
        b. setLabel ("Nein");
        b. setVisible (true);
        nachfrage. add (b);
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                antwort = false;
                nachfrage. setVisible (false);
            }
        });
        b = new JButton ();
        b. setSize (100, 30);
        b. setLocation (250, 80);
        b. setLabel ("Ja");
        b. setVisible (true);
        nachfrage. add (b);
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                antwort = true;
                nachfrage. setVisible (false);
            }
        });
        antwort = false;
           
         // Textfenster zur Gerichtewahl
        textanzeige = new JDialog (fenster, "Wahl", true);
        textanzeige. setSize (600, 400);
        textanzeige. setLocation (100, 80);
        textanzeige. setResizable (false);
        textanzeige. setLayout (null);
        textanzeige. setVisible (false);
        anzeigetext = new JTextArea ();
        anzeigetext. setLocation (0, 20);
        anzeigetext. setSize (600, 330);
        anzeigetext. setVisible (true);
        anzeigetext. setEditable (false);
        textanzeige. add (anzeigetext);
        b = new JButton ();
        b. setSize (100, 30);
        b. setLocation (250, 360);
        b. setLabel ("Schliessen");
        b. setVisible (true);
        textanzeige. add (b);
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                textanzeige. setVisible (false);
            }
        });
           
        // Logfenster
        loganzeige = new JDialog (fenster, "Log", true);
        loganzeige. setSize (600, 400);
        loganzeige. setLocation (100, 80);
        loganzeige. setResizable (false);
        loganzeige. setLayout (null);
        loganzeige. setVisible (false);
        logtext = new JTextArea ();
        logtext. setLocation (0, 20);
        logtext. setSize (600, 330);
        logtext. setVisible (true);
        logtext. setEditable (false);
        loganzeige. add (logtext);
        b = new JButton ();
        b. setSize (100, 30);
        b. setLocation (250, 360);
        b. setLabel ("Schliessen");
        b. setVisible (true);
        loganzeige. add (b);
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                loganzeige. setVisible (false);
            }
        });
        fenster. setVisible (true);
    }
    
    /**
     * Setzt die Oberfläche auf den angegebenen Status.
     * @param status der neue Status der Oberfläche
     */
    public void StatusSetzen (Status status)
    {
        int [] nummern;
        switch (status)
        {
            case anmelden:
                abmelden. setEnabled (false);
                beenden. setVisible (true);
                anmeldeJPanel_name. setText ("");
                anmeldeJPanel_pin. setText ("");
                anmeldeJPanel. setVisible (true);
                //kundeArbeitJPanel. setVisible (false);
                kundeAuswahlJPanel. setVisible (false);
                angestellterAuswahlJPanel. setVisible (false);
                anmeldeJPanel_name. requestFocus ();
                break;
            case kunden_auswahl:
                abmelden. setEnabled (true);
                beenden. setVisible (false);
                anmeldeJPanel. setVisible (false);
                kundeAuswahlJPanel. setVisible (true);
                angestellterAuswahlJPanel. setVisible (false);
                break;
               // wahlMo. removeAll ();
                // nummern = kontroller. NummerFuerKundenGeben ();
                // if (nummern != null)
                // {
                    // for (int nummer: nummern)
                    // {
                       // // wahlMo. add ("" + nummer);
                    // }
                    // wahlMo. setEnabled (true);
                // }
                // else
                // {
                    // //wahlMo. add ("----");
                    // wahlMo. setEnabled (false);
                // }
                // kundeAuswahlJPanel. setVisible (true);
                // break;
            // case kundenkontoarbeit:
                // abmelden. setEnabled (true);
                // beenden. setVisible (false);
                // anmeldeJPanel. setVisible (false);
                // kundeAuswahlJPanel. setVisible (false);
                // angestellterAuswahlJPanel. setVisible (false);
                // kundeArbeitJPanel. setVisible (true);
                // kundeArbeitJPanel_betrag. setText ("");
                // kontostandFuerKunde. setText ("" + kontroller. BetragFuerKundenKontoGeben ());
                // aktKontoFuerKunde. setText ("Das aktuelle Konto hat die Nummer " + kontroller. NummerFuerKundenKontoGeben ());
                // break;
            case angestelltensicht:            
                abmelden. setEnabled (true);
                beenden. setVisible (true);
                anmeldeJPanel. setVisible (false);
                kundeAuswahlJPanel. setVisible (false);
                //kundeArbeitJPanel. setVisible (false);
                angestellterAuswahlJPanel. setVisible (true);
                // angestelltenwahl. removeAll ();
                // String [] namen = kontroller. AngestelltenNamenGeben ();
                // if (namen != null)
                // {
                    // for (String name: namen)
                    // {
                      // //angestelltenwahl. add (name);
                    // }
                    // angestelltenwahl. setEnabled (true);
                    // //angestelltenLoeschen. setEnabled (true);
                // }
                // else
                // {
                   // // angestelltenwahl. add ("----");
                    // angestelltenwahl. setEnabled (false);
                    // //angestelltenLoeschen. setEnabled (false);
                // }
                // kundenwahl. removeAll ();
                // namen = kontroller. KundenNamenGeben ();
                // if (namen != null)
                // {
                    // for (String name: namen)
                    // {
                      // //  kundenwahl. add (name);
                    // }
                    // kundenwahl. setEnabled (true);
                // }
                // else
                // {
                   // // kundenwahl. add ("----");
                    // kundenwahl. setEnabled (false);
                // }
                // wahlMo2. removeAll ();
            }
           
        }
            
            
                // if (status == Status. angestelltensicht)
                // {
                    // angestellter_kunde. setText ("Es ist kein Kunde ausgewählt");
                    // kontoWaehlen. setEnabled (false);
                    // kontoAnlegen. setEnabled (false);
                    // kontoAuszuege. setEnabled (false);
                    // kontoLoeschen. setEnabled (false);
                    // kundeLoeschen. setEnabled (false);
                // }
                // else
                // {
                    // angestellter_kunde. setText ("Sie arbeiten mit Kunde " + kontroller. NameVonAktkundeGeben () + ".");
                    // nummern = kontroller. NummerFuerAktKundenGeben ();
                    // kundeLoeschen. setEnabled (true);
                    // if (nummern != null)
                    // {
                        // for (int nummer: nummern)
                        // {
                           // // wahlMo2. add ("" + nummer);
                        // }
                        // wahlMo2. setEnabled (true);
                        // kontoWaehlen. setEnabled (true);
                    // }
                    // else
                    // {
                       // // wahlMo2. add ("----");
                        // wahlMo2. setEnabled (false);
                        // kontoWaehlen. setEnabled (false);
                    // }
                    // kontoAnlegen. setEnabled (true);
                    // if (status == Status. angestelltensicht_kundeundkonto)
                    // {
                        // kontoAuszuege. setEnabled (true);
                        // kontoLoeschen. setEnabled (true);
                    // }
                    // else
                    // {
                        // kontoAuszuege. setEnabled (false);
                        // kontoLoeschen. setEnabled (false);
                    // }
                // }
                // break;
            // default:
                // FehlertextZeigen ("Unbekannter Status: '" + status + "'.");
                // break;
        // }
    // }
    
    /**
     * Zeigt einen Fehlertext an.
     * Blockiert, bis das Fenster wieder unsichtbar wird.
     * @param text der anzuzeigende Fehlertext
     */
    private void FehlertextZeigen (String text)
    {
      // (Toolkit. getDefaultToolkit ()). beep ();
        fehler. setText (text);
        fehlermeldung. setVisible (true);
    }
    /**
     * Stellt eine mit Ja oder Nein zu beantwortende Frage.
     * Die Antwort wird im Attribut anwort abgelegt.
     * Blockiert, bis das Fenster wieder unsichtbar wird.
     * @param text die anzuzeigende Frage
     */
    private void FrageStellen (String text)
    {
        frage. setText (text);
        nachfrage. setVisible (true);
    }

    /**
     * Zeigt einen großen Text (Kundenwahl) an.
     * Blockiert, bis das Fenster wieder unsichtbar wird.
     * @param text der anzuzeigende Gerichtewahl
     */
    private void AnzeigetextZeigen (String [] text)
    {
        anzeigetext. setText (text [0]);
        for ( int i = 1; i < text. length; i++)
        {
            anzeigetext. append ("\n" + text [i]);
        }
        anzeigetext. setColumns (160);
        anzeigetext. setRows (text. length);
        textanzeige. setVisible (true);
    }

    /**
     * Erzeugt das AnmeldeJPanel
     */
    private void AnmeldeJPanelAufbauen ()
    {
        
        anmeldeJPanel = new JPanel ();
        anmeldeJPanel. setSize (breite, hoehe - 60);
        anmeldeJPanel. setLocation (10, 0);
        anmeldeJPanel. setLayout (null);
        anmeldeJPanel. setVisible (true);
        fenster. add (anmeldeJPanel);
        l = new JLabel ();
        l. setSize (breite, 20);
        l. setLocation (0, 10);
        l.setFont(new Font("MV Boli", Font.PLAIN, 24));
        l.setHorizontalAlignment(SwingConstants.CENTER);
        
        l. setText ("Bitte anmelden");
        l. setVisible (true);
        anmeldeJPanel. add (l);
        l = new JLabel ();
        l. setSize (130, 20);
        l. setLocation (breite / 2 - 140, 50);
       l.setHorizontalAlignment(SwingConstants.CENTER);
       l.setFont(font);
        l. setText ("Benutzername:");
        l. setVisible (true);
        anmeldeJPanel. add (l);
        anmeldeJPanel_name = new JTextField ();
        anmeldeJPanel_name.setFont(font);
        anmeldeJPanel_name. setSize (150, 30);
        anmeldeJPanel_name. setLocation (breite / 2 + 10, 50);
        anmeldeJPanel_name. setVisible (true);
        anmeldeJPanel. add (anmeldeJPanel_name);        
        l = new JLabel ();
        l. setSize (130, 20);
        l. setLocation (breite / 2 - 160, 80);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(font);
        l. setText ("Passwort:");
        l. setVisible (true);
        anmeldeJPanel. add (l);
        anmeldeJPanel_pin = new JTextField ();
        anmeldeJPanel_pin.setFont(font);
        anmeldeJPanel_pin. setSize (150, 30);
        anmeldeJPanel_pin. setLocation (breite / 2 + 10, 80);
        anmeldeJPanel_pin. setVisible (true);
        anmeldeJPanel. add (anmeldeJPanel_pin);        
        b = new JButton ();
        b.setFont(font);
        b. setSize (130, 40);
        b. setLocation (breite / 2 - 140, 130);
        b. setLabel ("als Kunde");
        b. setVisible (true);
        anmeldeJPanel. add (b);
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                try
                {
                    
                    kontroller. KundeAnmelden (anmeldeJPanel_name. getText (), anmeldeJPanel_pin. getText ());
                }
                catch (Exception ex)
                {
                    FehlertextZeigen ("Der Benutzername oder das Passwort ist falsch.");
                }
            }
        });
        b = new JButton ();
        b.setFont(font);
        b. setSize (150, 40);
        b. setLocation (breite / 2 + 10, 130);
        b. setLabel ("als Mitarbeiter");
        b. setVisible (true);
        anmeldeJPanel. add (b);
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                try
                {
                    kontroller. AngestellterAnmelden (anmeldeJPanel_name. getText (), anmeldeJPanel_pin. getText ());
                }
                catch (Exception ex)
                {
                    FehlertextZeigen ("Hast hast du deinen Benutzername oder dein Passwort falsch eingegeben? Oder bist du kein Mitarbeiter?");
                }
            }
        });
    }

    /**
     * Erzeugt das AuswahlJPanel für die Gerichtewahl des Kunden
     */
    private void KundenauswahlJPanelAufbauen()
    {
        kundeAuswahlJPanel = new JPanel ();
        kundeAuswahlJPanel. setSize (breite, hoehe - 60);
        kundeAuswahlJPanel. setLocation (10, 0);
        kundeAuswahlJPanel. setLayout (null);
        kundeAuswahlJPanel. setVisible (false);
        fenster. add (kundeAuswahlJPanel);
        l = new JLabel ();
        l. setSize (300, 20);
        l. setLocation (breite / 8, 30);
       
        l. setText ("Wähle deine Gerichte");
         l.setFont(new Font("MV Boli", Font.PLAIN, 24));
        l. setVisible (true);
        kundeAuswahlJPanel. add (l);
        
        l = new JLabel ();
        l.setFont(font);
        l. setSize (100, 30);
        l. setLocation (breite / 8 , 100);
        l. setText ("Montag:");
        l. setVisible (true);
        kundeAuswahlJPanel. add (l);        
        
        String[] mo = { "keines", kontroller.GerichteLieferen()[0], kontroller.GerichteLieferen()[1] };               
        wahlMo = new JComboBox (mo);
        wahlMo.setFont(font);
        wahlMo.setSelectedItem(0);
        wahlMo. setSize (400, 30);
        wahlMo. setLocation (breite / 3, 100);
        wahlMo. setVisible (true);
        kundeAuswahlJPanel. add (wahlMo);
        
        l = new JLabel ();
        l.setFont(font);
        l. setSize (100, 30);
        l. setLocation (breite / 8 , 140);
        l. setText ("Dienstag:");
        l. setVisible (true);
        kundeAuswahlJPanel. add (l);
        
        String[] di = { "keines", kontroller.GerichteLieferen()[2], kontroller.GerichteLieferen()[3] };               
        wahlDi = new JComboBox (di);
        wahlDi.setFont(font);
        wahlDi.setSelectedItem(0);
        wahlDi. setSize (400, 30);
        wahlDi. setLocation (breite / 3, 140);
        wahlDi. setVisible (true);
        kundeAuswahlJPanel. add (wahlDi);
        
         l = new JLabel ();
        l.setFont(font);
        l. setSize (100, 30);
        l. setLocation (breite / 8 , 190);
        l. setText ("Mittwoch:");
        l. setVisible (true);
        kundeAuswahlJPanel. add (l);
        
        String[] mi = { "keines", kontroller.GerichteLieferen()[4], kontroller.GerichteLieferen()[5] };               
        wahlMi = new JComboBox (mi);
        wahlMi.setFont(font);
        wahlMi.setSelectedItem(0);
        wahlMi. setSize (400, 30);
        wahlMi. setLocation (breite / 3, 190);
        wahlMi. setVisible (true);
        kundeAuswahlJPanel. add (wahlMi);
        
         l = new JLabel ();
        l.setFont(font);
        l. setSize (100, 30);
        l. setLocation (breite / 8 , 240);
        l. setText ("Donnerstag:");
        l. setVisible (true);
        kundeAuswahlJPanel. add (l);
        
        String[] don = { "keines", kontroller.GerichteLieferen()[6], kontroller.GerichteLieferen()[7] };               
        wahlDo = new JComboBox (don);
        wahlDo.setFont(font);
        wahlDo.setSelectedItem(0);
        wahlDo. setSize (400, 30);
        wahlDo. setLocation (breite / 3, 240);
        wahlDo. setVisible (true);
        kundeAuswahlJPanel. add (wahlDo);
        
         l = new JLabel ();
        l.setFont(font);
        l. setSize (100, 30);
        l. setLocation (breite / 8 , 290);
        l. setText ("Freitag:");
        l. setVisible (true);
        kundeAuswahlJPanel. add (l);
        
        String[] fr = { "keines", kontroller.GerichteLieferen()[8], kontroller.GerichteLieferen()[9] };               
        wahlFr = new JComboBox (fr);
        wahlFr.setFont(font);
        wahlFr.setSelectedItem(0);
        wahlFr. setSize (400, 30);
        wahlFr. setLocation (breite / 3, 290);
        wahlFr. setVisible (true);
        kundeAuswahlJPanel. add (wahlFr);
        
                
        
        // Auswahl für die restlichen Tage
        
        b = new JButton ();
        b. setSize (200, 30);
        b. setLocation (450, 500);
        b. setLabel ("Wahl speichern");
        b.setFont(font);
        b. setVisible (true);
        kundeAuswahlJPanel. add (b);
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                try
                {
                   // Gewählten Gerichte werden ausgelesen und in der Datenbank gespeichert
                   // JComboBox cb = (JComboBox)e.getSource();
                   //  String petName = (String)cb.getSelectedItem();
                }
                catch (Exception ex)
                {
                    //FehlertextZeigen ("Interner Fehler bei der Wahl der Gerichte.");
                }
            }
        });
        // l = new JLabel ();
        // l. setSize (100, 20);
        // l. setLocation (breite / 2 - 100, 150);
        // l. setText ("Neue PIN");
        // l. setVisible (true);
        // kundeAuswahlJPanel. add (l);
        // pin_neu_1 = new JTextField ();
        // pin_neu_1. setSize (100, 20);
        // pin_neu_1. setLocation (breite / 2, 150);
        // pin_neu_1. setVisible (true);
       // // pin_neu_1. setEchoChar('\u2022');
        // kundeAuswahlJPanel. add (pin_neu_1);
        // l = new JLabel ();
        // l. setSize (100, 20);
        // l. setLocation (breite / 2 - 100, 180);
        // l. setText ("Besätigung");
        // l. setVisible (true);
        // kundeAuswahlJPanel. add (l);
        // pin_neu_2 = new JTextField ();
        // pin_neu_2. setSize (100, 20);
        // pin_neu_2. setLocation (breite / 2, 180);
        // pin_neu_2. setVisible (true);
       // // pin_neu_2. setEchoChar('\u2022');
        // kundeAuswahlJPanel. add (pin_neu_2);
        // b = new JButton ();
        // b. setSize (200, 30);
        // b. setLocation (breite / 2 - 100, 210);
        // b. setLabel ("PIN ändern");
        // b. setVisible (true);
        // kundeAuswahlJPanel. add (b);
        // b. addActionListener (new ActionListener () {
            // public void actionPerformed (ActionEvent e)
            // {
                
                // if (pin_neu_1. getText (). equals (pin_neu_2. getText ()))
                // {
                    // try
                    // {
                        // kontroller. KundePinAendern (pin_neu_1. getText ());
                        // StatusmeldungSetzen ("Pin geändert.");
                    // }
                    // catch (Exception ex)
                    // {
                        // FehlertextZeigen ("Die PIN muss eine ganze Zahl sein.");
                    // }
                // }
                // else
                // {
                    // FehlertextZeigen ("Die beiden Angaben für die PIN müssen übereinstimmen.");
                // }
            // }
        // });
    }

    // /**
     // * Erzeugt das ArbeitsJPanel für die Kontenbearbeitung des Kunden
     // */
    // private void KundenarbeitsJPanelAufbauen ()
    // {
        // kundeArbeitJPanel = new JPanel ();
        // kundeArbeitJPanel. setSize (breite, hoehe - 60);
        // kundeArbeitJPanel. setLocation (10, 0);
        // kundeArbeitJPanel. setLayout (null);
        // kundeArbeitJPanel. setVisible (false);
        // fenster. add (kundeArbeitJPanel);
        // aktKontoFuerKunde = new JLabel ();
        // aktKontoFuerKunde. setSize (breite, 20);
        // aktKontoFuerKunde. setLocation (0, 30);
        // //aktKontoFuerKunde. setAlignment (JLabel. CENTER);
        // aktKontoFuerKunde. setText ("Das aktuelle Konto kat die Nummer ------");
        // aktKontoFuerKunde. setVisible (true);
        // kundeArbeitJPanel. add (aktKontoFuerKunde);
        // l = new JLabel ();
        // l. setSize (100, 20);
        // l. setLocation (0, 50);
        // l. setText ("Kontostand:");
        // l. setVisible (true);
        // kundeArbeitJPanel. add (l);
        // l = new JLabel ();
        // l. setSize (100, 20);
        // l. setLocation (0, 80);
        // l. setText ("Betrag:");
        // l. setVisible (true);
        // kundeArbeitJPanel. add (l);
        // kontostandFuerKunde = new JLabel ();
        // kontostandFuerKunde. setSize (100, 20);
        // kontostandFuerKunde. setLocation (110, 50);
        // kontostandFuerKunde. setText ("");
        // kontostandFuerKunde. setVisible (true);
        // kundeArbeitJPanel. add (kontostandFuerKunde);
        // kundeArbeitJPanel_betrag = new JTextField ();
        // kundeArbeitJPanel_betrag. setSize (100, 20);
        // kundeArbeitJPanel_betrag. setLocation (110, 80);
        // kundeArbeitJPanel_betrag. setText ("0");
        // kundeArbeitJPanel_betrag. setVisible (true);
        // kundeArbeitJPanel. add (kundeArbeitJPanel_betrag);
        // b = new JButton ();
        // b. setSize (100, 30);
        // b. setLocation (110, 110);
        // b. setLabel ("Abheben");
        // b. setVisible (true);
        // kundeArbeitJPanel. add (b);
        // b. addActionListener (new ActionListener () {
            // public void actionPerformed (ActionEvent e)
            // {
                // try
                // {
                    // kontroller. KundeKontoAbheben (Double. parseDouble (kundeArbeitJPanel_betrag. getText ()));
                    // kontostandFuerKunde. setText ("" + kontroller. BetragFuerKundenKontoGeben ());
                // }
                // catch (Exception ex)
                // {
                    // StatusmeldungSetzen ("Bitte einen korrekten Betrag eingeben");
                    // (Toolkit. getDefaultToolkit ()). beep ();
                    // kundeArbeitJPanel_betrag. requestFocus ();
                    // kundeArbeitJPanel_betrag. selectAll ();
                // }
            // }
        // });
        // b = new JButton ();
        // b. setSize (100, 30);
        // b. setLocation (110, 140);
        // b. setLabel ("Einzahlen");
        // b. setVisible (true);
        // kundeArbeitJPanel. add (b);
        // b. addActionListener (new ActionListener () {
            // public void actionPerformed (ActionEvent e)
            // {
                // try
                // {
                    // kontroller. KundeKontoEinzahlen (Double. parseDouble (kundeArbeitJPanel_betrag. getText ()));
                    // kontostandFuerKunde. setText ("" + kontroller. BetragFuerKundenKontoGeben ());
                // }
                // catch (Exception ex)
                // {
                    // StatusmeldungSetzen ("Bitte einen korrekten Betrag eingeben");
                  // //  (Toolkit. getDefaultToolkit ()). beep ();
                    // kundeArbeitJPanel_betrag. requestFocus ();
                    // kundeArbeitJPanel_betrag. selectAll ();
                // }
            // }
        // });

        // b = new JButton ();
        // b. setSize (200, 30);
        // b. setLocation (110, 200);
        // b. setLabel ("Kontoauszüge anzeigen");
        // b. setVisible (true);
        // kundeArbeitJPanel. add (b);
        // b. addActionListener (new ActionListener () {
            // public void actionPerformed (ActionEvent e)
            // {
                // AnzeigetextZeigen (kontroller. KundeKontoauszuegeGeben ());
            // }
        // });
        // b = new JButton ();
        // b. setSize (200, 30);
        // b. setLocation (breite - 220, 200);
        // b. setLabel ("Neues Konto wählen");
        // b. setVisible (true);
        // kundeArbeitJPanel. add (b);
        // b. addActionListener (new ActionListener () {
            // public void actionPerformed (ActionEvent e)
            // {
                    // kontroller. KundeKontoNeuWaehlen ();
            // }
        // });
    // }

    /**
     * Erzeugt das AuswahlJPanel für die Arbeitsabläufe des Angestellten
     */
    private void AngestelltenauswahlJPanelAufbauen()
    {
        angestellterAuswahlJPanel = new JPanel ();
        angestellterAuswahlJPanel. setSize (breite, hoehe - 60);
        angestellterAuswahlJPanel. setLocation (10, 0);
        angestellterAuswahlJPanel. setLayout (null);
        angestellterAuswahlJPanel. setVisible (false);
        fenster. add (angestellterAuswahlJPanel);
        l = new JLabel ();
        l. setSize (550, 30);
        l. setLocation (10, 30);
        l.setFont(font);
        l. setText ("Es kann eine Übersicht über die gewählten Gerichte erstellt werden.");
        l. setVisible (true);
        angestellterAuswahlJPanel. add (l);
        b = new JButton ();
        b. setSize (120, 30);
        b. setLocation (breite - 150,30);
        b. setLabel ("Erstellen");
        b.setFont(font);
        b. setVisible (true);
        
        angestellterAuswahlJPanel. add (b);
        
        
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                try
                {
                    // class CellRenderer extends DefaultTableCellRenderer {

            // /*
             // * (non-Javadoc)
             // * 
             // * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable,
             // *      java.lang.Object, boolean, boolean, int, int)
             // */
            // @Override
            // public Component getTableCellRendererComponent(JTable table,
                    // Object value, boolean isSelected, boolean hasFocus,
                    // int row, int column) {
                // // TODO Auto-generated method stub
                // if (true) {
                    // JLabel label = new JLabel((String) value);
                    // l.setFont(new java.awt.Font("Arial", 1, 24));                    
                    // return label;

                // }
                // return super.getTableCellRendererComponent(table, value,
                        // isSelected, hasFocus, row, column);
            // }

        // }

        
                    AUSZUGSEINTRAG[] a;
                    a = kontroller.UebersichtGErstellen();
                    // Data to be displayed in the JTable 
                    String [][] daten=new String[50][7];
                    for(int i=0;i<a.length; i++)
                    {
                        for(int j=0;j<7; j++)
                        {daten[i][j] = a[i].GibDatensatz() [j];}
                   }
                    // Column Names 
                    String[] spaltennamen = { "Vorname", "Nachname", "GerichtMo", "GerichtDi", "GerichtMi", "GerichtDo", "GerichtFr" }; 
  
                    // Initializing the JTable 
                   JTable j = new JTable(daten, spaltennamen);
                   j.setRowHeight(30);
                  // j.setDefaultRenderer(Object.class, new CellRenderer( ));
                   j.setBounds(60, 40, 800, 1000); 
                   JFrame f = new JFrame();
                   f.getContentPane().add( new JScrollPane( j ) );
                   f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                   f.pack();
                   f.setVisible( true );
                }
                catch (Exception ex)
                {
                    FehlertextZeigen ("Interner Fehler bei der wahlMo.");
                }
            }
        });
        
        l = new JLabel ();
        l. setSize (550, 30);
        l.setFont(new Font("MV Boli", Font.PLAIN, 24));
        l. setLocation (10, 90);
        l. setText ("Geben Sie die beiden neuen Gerichte ein ");        
        l. setVisible (true);
        angestellterAuswahlJPanel. add (l);
        
        l = new JLabel ();
        l. setSize (100, 20);
        l.setFont(font);
        l. setLocation (10, 140);
        l. setText ("Montag: ");
        l. setVisible (true);        
        angestellterAuswahlJPanel. add (l);
        
        gMo1 = new JTextField ();
        gMo1.setFont(font);
        gMo1. setSize (270, 30);
        gMo1. setLocation (180, 140);
        gMo1. setVisible (true);
        angestellterAuswahlJPanel. add (gMo1);   
        
        gMo2 = new JTextField ();
        gMo2.setFont(font);
        gMo2. setSize (270, 30);
        gMo2. setLocation (470, 140);
        gMo2. setVisible (true);
        angestellterAuswahlJPanel. add (gMo2);     
       
        l = new JLabel ();
        l. setSize (100, 20);
        l.setFont(font);
        l. setLocation (10, 190);
        l. setText ("Dienstag: ");
        l. setVisible (true);        
        angestellterAuswahlJPanel. add (l);
        
        gDi1 = new JTextField ();
        gDi1.setFont(font);
        gDi1. setSize (270, 30);
        gDi1. setLocation (180, 190);
        gDi1. setVisible (true);
        angestellterAuswahlJPanel. add (gDi1);   
        
        gDi2 = new JTextField ();
        gDi2.setFont(font);
        gDi2. setSize (270, 30);
        gDi2. setLocation (470, 190);
        gDi2. setVisible (true);
        angestellterAuswahlJPanel. add (gDi2); 
        
        l = new JLabel ();
        l. setSize (100, 20);
        l.setFont(font);
        l. setLocation (10, 240);
        l. setText ("Mittwoch: ");
        l. setVisible (true);        
        angestellterAuswahlJPanel. add (l);
        
        gMi1 = new JTextField ();
        gMi1.setFont(font);
        gMi1. setSize (270, 30);
        gMi1. setLocation (180, 240);
        gMi1. setVisible (true);
        angestellterAuswahlJPanel. add (gMi1);   
        
        gMi2 = new JTextField ();
        gMi2.setFont(font);
        gMi2. setSize (270, 30);
        gMi2. setLocation (470, 240);
        gMi2. setVisible (true);
        
        angestellterAuswahlJPanel. add (gMi2); 
         l = new JLabel ();
        l. setSize (120, 20);
        l.setFont(font);
        l. setLocation (10, 290);
        l. setText ("Donnerstag: ");
        l. setVisible (true);        
        angestellterAuswahlJPanel. add (l);
        
        gDo1 = new JTextField ();
        gDo1.setFont(font);
        gDo1. setSize (270, 30);
        gDo1. setLocation (180, 290);
        gDo1. setVisible (true);
        angestellterAuswahlJPanel. add (gDo1);   
        
        gDo2 = new JTextField ();
        gDo2.setFont(font);
        gDo2. setSize (270, 30);
        gDo2. setLocation (470, 290);
        gDo2. setVisible (true);
        angestellterAuswahlJPanel. add (gDo2); 
        
         l = new JLabel ();
        l. setSize (100, 20);
        l.setFont(font);
        l. setLocation (10, 340);
        l. setText ("Freitag: ");
        l. setVisible (true);        
        angestellterAuswahlJPanel. add (l);
        
        gFr1 = new JTextField ();
        gFr1.setFont(font);
        gFr1. setSize (270, 30);
        gFr1. setLocation (180, 340);
        gFr1. setVisible (true);
        angestellterAuswahlJPanel. add (gFr1);   
        
        gFr2 = new JTextField ();
        gFr2.setFont(font);
        gFr2. setSize (270, 30);
        gFr2. setLocation (470, 340);
        gFr2. setVisible (true);
        angestellterAuswahlJPanel. add (gFr2); 
        
        // gDi1 = new JTextField ();
        // gDi1.setFont(font);
        // gDi1. setSize (130, 30);
        // gDi1. setLocation (50, 100);
        // gDi1. setVisible (true);
        // angestellterAuswahlJPanel. add (gDi1);   
        
        // gDi2 = new JTextField ();
        // gDi2.setFont(font);
        // gDi2. setSize (130, 30);
        // gDi2. setLocation (200, 100);
        // gDi2. setVisible (true);
        // angestellterAuswahlJPanel. add (gDi2);   
       
        b = new JButton ();
        b. setSize (270, 30);
        b. setLocation (470, 420);
        b. setLabel ("Gerichte speichern");
        b. setVisible (true);
        b.setFont(font);
        angestellterAuswahlJPanel. add (b);
        b. addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                try
                {
                   kontroller. GerichteSpeichern (GerichteAuslesen());
                }
                catch (Exception ex)
                {
                  //  FehlertextZeigen ("Interner Fehler bei der Kundenwahl.");
                }
            }
        });
        
       
    }
    
    
     /**
     * Gewählte Gerichte werden ausgelesen
     * @param Sting[] Liste
     */
    public String[] GerichteAuslesen ()
    {
        String[] l = new String[10];
        l[0]= gMo1.getText();
        l[1]= gMo2.getText();
        l[2]= gDi1.getText();
        l[3]= gDi2.getText();
        l[4]= gMi1.getText();
        l[5]= gMi2.getText();
        l[6]= gDo1.getText();
        l[7]= gDo2.getText();
        l[8]= gFr1.getText();
        l[9]= gFr2.getText();
       return l;
    }
    
    
    /**
     * Statusanzeige besetzen
     * @param text anzuzeigender Statustext
     */
    public void StatusmeldungSetzen (String text)
    {
        status. setText ("Status: " + text);
    }

    /**
     * Fehlermeldungen beim Ausführen von Aktionen anzeigen
     * @param text anzuzeigende Fehlermeldung
     */
    public void FehlermeldungAnzeigen (String text)
    {
       // FehlertextZeigen (text);
    }

    /**
     * Fehlermeldungen beim Ausführen von Aktionen
     */
    public void FehlermeldungEmpfangen (String text)
    {
        FehlermeldungAnzeigen (text);
    }

    /**
     * Aktionslog für den Ablauf
     * @param text der Text des Logeintrags
     */
    public void LogeintragEmpfangen (String text)
    {
        logtext. append (text + "\n");
    }
}
