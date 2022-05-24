import java. sql. *;
import java. util. ArrayList;

/**
 * Stellt die Methoden zum Zugriff auf die Datenbank zur Verfügung.
 * 
 * @author 
 * @version 
 */
class DATENBANKVERBINDUNG implements MELDUNGSERZEUGER
{
    /** Speichert die Verbindung zur Datenbank. */
    private Connection conn;
    /** Die Meldungsbeobachter */
    private ArrayList<MELDUNGSBEOBACHTER> allebeobachter;
    
    /**
     * Baut die Verbindung zur Datenbank auf.
     */
    DATENBANKVERBINDUNG ()
    {
        allebeobachter = new ArrayList<MELDUNGSBEOBACHTER> ();
        try
        {
           
            Class.forName ("com.mysql.cj.jdbc.Driver").newInstance();
            // conn = DriverManager. getConnection("jdbc:mysql://w4004344/bankverwaltung?user=bank&password=verwaltung");
            conn = DriverManager. getConnection("jdbc:mysql://localhost/catering?user=catering&password=mitarbeiter");
            //conn = DriverManager. getConnection("jdbc:mysql://126.0.0.2/bankverwaltung?user=bank&password=verwaltung");
            LogeintragMelden ("Verbindung aufgebaut.");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Holt die Liste der Kunden aus der Datenbank.
     * @param kunden Liste zur Verwaltung der Kunden.
     */
    void Catering ()
    {
        try
        {
            Statement st = conn. createStatement ();
            ResultSet rs = st. executeQuery ("SELECT Vorname FROM personen ");
            String ausgabe="";
            while (rs. next ())
            {
                ausgabe= ausgabe + rs. getString ("Vorname") + "    ";
            }
           
            rs. close ();
            st. close ();
             System.out.println(ausgabe);
            LogeintragMelden ("Liste angefordert.");
        } catch (Exception e)
        {
            ExceptionMelden (e);
        }
    }

   /**
     * Speichert die Namen der Gerichte in der Datenbank
     * @param Liste der Gerichte, sortiert von Mo - Fr mit je zwei Gerichten
     */
    public void GerichteAktualisieren(String[] liste)
    {
    try
        {
            //Fehler bei Aktualiseriung
            
            System.out.println("Neue Gerichte:  " + liste[0]+"   "+ liste[1]+"   "+ liste[2]);
                       
            Statement st = conn. createStatement ();
            
            if(! liste[0].equals(""))        
            st. executeUpdate ("UPDATE gerichte SET Mo=" + "'"+ liste[0] + "'"+ " WHERE Nr= '  1 ' ");
            if(! liste[1].equals(""))        
            st. executeUpdate ("UPDATE gerichte SET Mo=" + liste[1] + " WHERE Nr='  2  '");
           if(! liste[2].equals(""))       
            st. executeUpdate ("UPDATE gerichte SET Di=" + liste[2] + " WHERE Nr='  1  '");
           if(! liste[3].equals(""))
            st. executeUpdate ("UPDATE gerichte SET Di=" + liste[3] + " WHERE Nr='  2  '");
            if(! liste[4].equals(""))   
            st. executeUpdate ("UPDATE gerichte SET Mi=" + liste[4] + " WHERE Nr='  1  '");
            if(! liste[5].equals(""))        
            st. executeUpdate ("UPDATE gerichte SET Mi=" + liste[5] + " WHERE Nr='  2  '");
            if(! liste[6].equals(""))    
            st. executeUpdate ("UPDATE gerichte SET Do=" + liste[6] + " WHERE Nr='  1  '");
           if(! liste[7].equals(""))
            st. executeUpdate ("UPDATE gerichte SET Do=" + liste[7] + " WHERE Nr='  2  '");
            if(! liste[8].equals(""))      
            st. executeUpdate ("UPDATE gerichte SET Fr=" + liste[8] + " WHERE Nr='  1  '");
            if(! liste[9].equals(""))     
            st. executeUpdate ("UPDATE gerichte SET Fr=" + liste[9] + " WHERE Nr='  2  '");
                        
            st. close ();
            System.out.println("Gerichte DB");
            LogeintragMelden ("Gerichte aktualisiert. " );
        } catch (Exception e)
        {
            ExceptionMelden (e);
        }
        
        
    }
    
    /**
     * Liefert die Namen der Gerichte in der Datenbank
     * @return Liste der Gerichte, sortiert von Mo - Fr mit je zwei Gerichten
     */
    public String[] GerichteLieferen()
    {
      String[] gerichte=new String[10];
      
      try
        {
            Statement st = conn. createStatement ();
            ResultSet rs = st. executeQuery ("SELECT Mo, Di, Mi, Do, Fr   FROM gerichte WHERE Nr='1'");
            
            while (rs. next ())
            {
                gerichte[0]= rs.getString ("Mo");
                gerichte[2]= rs.getString ("Di");
                gerichte[4]= rs.getString ("Mi");
                gerichte[6]= rs.getString ("Do");
                gerichte[8]= rs.getString ("Fr");
                
               
            }
            rs. close ();
            st. close ();
             st = conn. createStatement ();
             rs = st. executeQuery ("SELECT Mo, Di, Mi, Do, Fr   FROM gerichte WHERE Nr='2'");
            
            while (rs. next ())
            {
                gerichte[1]= rs.getString ("Mo");
                gerichte[3]= rs.getString ("Di");
                gerichte[5]= rs.getString ("Mi");
                gerichte[7]= rs.getString ("Do");
                gerichte[9]= rs.getString ("Fr");
                
               
            }
            rs. close ();
            st. close ();
            
        } catch (Exception e)
        {
            ExceptionMelden (e);
        } 
        
        
    return gerichte; 
    }
        
   
    
    
    /**
     * Registriert einen Beobachter beim Produzenten.
     * @param beobachter der neue Beobachter
     */
    public void Registrieren (MELDUNGSBEOBACHTER beobachter)
    {
        allebeobachter. add (beobachter);
    }

    /**
     * Meldet einen Beobachter beim Produzenten ab.
     * @param beobachter der abzumeldende Beobachter
     */
    public void Abmelden (MELDUNGSBEOBACHTER beobachter)
    {
        allebeobachter. remove (beobachter);
    }

    /**
     * Trägt eine Logmeldung für alle Beobachte ein.
     * @param text der Eintrag
     */
    private void LogeintragMelden (String text)
    {
        for (MELDUNGSBEOBACHTER b: allebeobachter)
        {
            b. LogeintragEmpfangen (text);
        }
    }

    /**
     * Meldet die Ausnahemsituation an alle Beobachter
     * @param e die Ausnahemsituation
     */
    private void ExceptionMelden (Exception e)
    {
        StackTraceElement [] stack = e. getStackTrace ();
        for (MELDUNGSBEOBACHTER b: allebeobachter)
        {
            b. FehlermeldungEmpfangen (e. getMessage ());
            for (int i = 0; i < stack. length; i++)
            {
                b. FehlermeldungEmpfangen (stack [i]. toString ());
            }
            b. LogeintragEmpfangen (e. getMessage ());
        }
    }

    /**
     * Meldet einen Fehler an alle Beobachter
     * @param text der Fehler
     */
    private void FehlerMelden (String text)
    {
        for (MELDUNGSBEOBACHTER b: allebeobachter)
        {
            b. FehlermeldungEmpfangen (text);
            b. LogeintragEmpfangen (text);
        }
    }

    /**
     * Beendet die Verbindung, danach ist Schluss.
     */
    void VerbindungBeenden ()
    {
        try
        {
            conn. close ();
            LogeintragMelden ("Verbindung beendet.");
        } catch (Exception e)
        {
            ExceptionMelden (e);
        }
    }

    /**
     * Holt die Liste der Kunden aus der Datenbank.
     * @param kunden Liste zur Verwaltung der Kunden.
     */
    void KundenEinfuegen (PERSONENLISTE kunden)
    {
        try
        {
            Statement st = conn. createStatement ();
            ResultSet rs = st. executeQuery ("SELECT name, pin FROM person WHERE klasse='k'");
            while (rs. next ())
            {
                kunden. Einfuegen (new KUNDE (rs. getString ("name"), rs. getString ("pin")));
            }
            rs. close ();
            st. close ();
            LogeintragMelden ("Kundenliste angefordert.");
        } catch (Exception e)
        {
            ExceptionMelden (e);
        }
    }
    
    /**
     * Holt die Liste der Kunden aus der Datenbank.
     * @param kunden Liste zur Verwaltung der Kunden.
     */
    void KundenHolen (PERSONENLISTE kunden)
    {
        try
        {
            Statement st = conn. createStatement ();
            ResultSet rs = st. executeQuery ("SELECT Benutzername, Passwort FROM personen");
            while (rs. next ())
            {
                kunden. Einfuegen (new KUNDE (rs. getString ("Benutzername"), rs. getString ("Passwort")));
            }
            rs. close ();
            st. close ();
            LogeintragMelden ("Kundenliste angefordert.");
        } catch (Exception e)
        {
            ExceptionMelden (e);
        }
    }

    /**
     * Holt die Liste der Kunden aus der Datenbank.
     * @param angestellte Liste zur Verwaltung der Angestellten.
     * @param bank Bank, für die der Angestellte arbeitet.
     */
    void AngestellteHolen (PERSONENLISTE angestellte, CATERER caterer)
    {
        try
        {
            Statement st = conn. createStatement ();
            ResultSet rs = st. executeQuery ("SELECT Benutzername, Passwort FROM personen WHERE Status='M'");
            while (rs. next ())
            {
                angestellte. Einfuegen (new ANGESTELLTER (rs. getString ("Benutzername"), rs. getString ("Passwort"), caterer));
            }
            rs. close ();
            st. close ();
            LogeintragMelden ("Angestelltenliste angefordert.");
        } catch (Exception e)
        {
            ExceptionMelden (e);
        }
    }

    

    /**
     * Speichert den neuen Angestellten in der Datenbank.
     * Die Eindeutigkeit des Namens muss überprüft sein.
     * @param a der zu speichernde Angestellte
     */
    void NeuenAngestelltenEinfuegen (ANGESTELLTER a)
    {
        try
        {
            Statement st = conn. createStatement ();
            st. executeUpdate ("INSERT INTO person (name, pin, klasse) VALUES ('" + a. NameGeben () + "', '" + a. PinGeben () + "', 'a')");
            st. close ();
            LogeintragMelden ("Neuer Angestellter eingefügt: " + a. NameGeben () + ".");
        } catch (Exception e)
        {
            ExceptionMelden (e);
        }
    }

    // /**
     // * Speichert den neuen Kunden in der Datenbank.
     // * Die Eindeutigkeit des Namens muss überprüft sein.
     // * @param k der zu speichernde Kunde
     // */
    // void NeuenKundenEinfuegen (KUNDE k)
    // {
        // try
        // {
            // Statement st = conn. createStatement ();
            // st. executeUpdate ("INSERT INTO person (name, pin, klasse) VALUES ('" + k. NameGeben () + "', '" + k. PinGeben () + "', 'k')");
            // st. close ();
            // LogeintragMelden ("Neuer Kunde eingefügt: " + k. NameGeben () + ".");
        // } catch (Exception e)
        // {
            // ExceptionMelden (e);
        // }
    // }

    // /**
     // * Setzt eine neue PIN für den Kunden.
     // * @param name Benutzername des Kunden
     // * @param nummer die neue PIN
     // */
    // void PinSetzen (String name, String nummer)
    // {
        // try
        // {
            // Statement st = conn. createStatement ();
            // st. executeUpdate ("UPDATE personen SET Passwort=" + nummer + " WHERE Benutzername='" + name + "'");
            // st. close ();
            // LogeintragMelden ("PIN gesetzt für Benutzername: " + name + ".");
        // } catch (Exception e)
        // {
            // ExceptionMelden (e);
        // }
    // }

    // /**
     // * Speichert das neue Sparkonto in der Datenbank.
     // * @param konto das neu einzurichtende Konto
     // */
    // void NeuesSparkontoEinfuegen (SPARKONTO konto)
    // {
        // try
        // {
            // Statement st = conn. createStatement ();
            // st. executeUpdate ("INSERT INTO konto (kontonummer, kontostand, eigentuemer) VALUES (" + konto. KontonummerGeben () + ", " + konto. KontostandGeben () + ", '" + konto. EigentuemerGeben (). NameGeben () + "')");
            // st. executeUpdate ("INSERT INTO sparkonto (kontonummer, zinssatz) VALUES (" + konto. KontonummerGeben () + ", " + konto. ZinssatzGeben () + ")");
            // st. close ();
            // LogeintragMelden ("Neues Sparkonto eingefügt mit Nummer: " + konto. KontonummerGeben () + ".");
        // } catch (Exception e)
        // {
            // ExceptionMelden (e);
        // }
    // }

    // /**
     // * Speichert das neue Girokonto in der Datenbank.
     // * @param konto das neu einzurichtende Konto
     // */
    // void NeuesGirokontoEinfuegen (GIROKONTO konto)
    // {
        // try
        // {
            // Statement st = conn. createStatement ();
            // st. executeUpdate ("INSERT INTO konto (kontonummer, kontostand, eigentuemer) VALUES (" + konto. KontonummerGeben () + ", " + konto. KontostandGeben () + ", '" + konto. EigentuemerGeben (). NameGeben () + "')");
            // st. executeUpdate ("INSERT INTO girokonto (kontonummer, ueberziehungsrahmen) VALUES (" + konto. KontonummerGeben () + ", " + konto. UeberziehungsrahmenGeben () + ")");
            // st. close ();
            // LogeintragMelden ("Neues Girokonto eingefügt mit Nummer: " + konto. KontonummerGeben () + ".");
        // } catch (Exception e)
        // {
            // ExceptionMelden (e);
        // }
    // }

    // /**
     // * Löscht das angegebene Konto aus der Datenbank.
     // * Der Kontostand wird als "0" erwartet.
     // * @param konto das zu löschende Konto
     // */
    // void KontoLoeschen (KONTO konto)
    // {
        // try
        // {
            // Statement st = conn. createStatement ();
            // st. executeUpdate ("DELETE FROM konto WHERE kontonummer=" + konto. KontonummerGeben ());
            // st. close ();
            // LogeintragMelden ("Konto gelöscht mit Nummer: " + konto. KontonummerGeben () + ".");
        // } catch (Exception e)
        // {
            // ExceptionMelden (e);
        // }
    // }

    // /**
     // * Löscht die angegebene Person aus der Datenbank.
     // * Bei Kunden muss überprüft sein, dass der Kunde keine Konten mehr hat.
     // * @param p die zu löschende Person
     // */
    // void PersonLoeschen (PERSON p)
    // {
        // try
        // {
            // Statement st = conn. createStatement ();
            // st. executeUpdate ("DELETE FROM person WHERE name='" + p. NameGeben () + "'");
            // st. close ();
            // LogeintragMelden ("Person gelöscht mit Name: " + p. NameGeben () + ".");
        // } catch (Exception e)
        // {
            // ExceptionMelden (e);
        // }
    // }

    
      
          
    /**
     * Generiert die Daten für die Erstellung der Übersicht der gewählten Gerichte.
     * @return Referenz auf das Feld oder null
     */
    AUSZUGSEINTRAG [] AuszugsdatenErstellen ()
    {
        Statement st;
        ResultSet rs;
        AUSZUGSEINTRAG [] resultat;
        int anzahl;
        int pos;
        try
        {
            st = conn. createStatement ();
            rs = st. executeQuery ("SELECT COUNT(*) FROM personen" );
            if (rs. next ())
            {
                anzahl = rs. getInt (1);
            }
            else
            {
                anzahl = 0;
            }
            rs. close ();
            if (anzahl == 0)
            {
                st. close ();
                return null;
            }
            resultat = new AUSZUGSEINTRAG [anzahl];           
            rs = st. executeQuery ("SELECT Vorname, Nachname, GerichtMo, GerichtDi,GerichtMi, GerichtDo, GerichtFr  FROM personen ");
            for (pos = 0; rs. next (); pos++)
            {
                resultat [pos] = new AUSZUGSEINTRAG (rs. getString ("Vorname"),rs. getString ("Nachname"),Integer.toString(rs. getInt ("GerichtMo")), Integer.toString(rs. getInt ("GerichtDi")),Integer.toString(rs. getInt ("GerichtMi")),Integer.toString(rs. getInt ("GerichtDo")),Integer.toString(rs. getInt ("GerichtFr")));
            }
            rs. close ();
            st. close ();
            LogeintragMelden ("Gerichteübersicht erstellt.");
            return resultat;
        } catch (Exception e)
        {
            ExceptionMelden (e);
        }
        return null;
    }
    
    /**
     * Ermittelt die maximal bisher vergebene Kundennummer.
     * @return maximal vergebene Kundennummer
     */
    int MaxIDNummerGeben ()
    {
        Statement st;
        ResultSet rs;
        int max;
        try
        {
            st = conn. createStatement ();
            rs = st. executeQuery ("SELECT MAX(ID) FROM personen ");
            if (rs. next ())
            {
                max = rs. getInt (1);
            }
            else
            {
                max = 0;
            }
            rs. close ();
            st. close ();
            return max;
        } catch (Exception e)
        {
            ExceptionMelden (e);
        }
        return 0;
    }
        
}
