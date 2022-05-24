
/**
 * Verwaltet die CATERER.
 * 
 * @author 
 * @version 1.0
 */
class CATERER
{
    private static CATERER derCaterer = new CATERER ();
   // private KONTENLISTE konten;
    private PERSONENLISTE kunden;
    private PERSONENLISTE angestellte;
    private DATENBANKVERBINDUNG verbindung;
    
    /**
     * Baut die DatenCATERERverbindung auf und legt die Verwaltungslisten an.
     */
    private CATERER()
    {
        verbindung = new DATENBANKVERBINDUNG ();
        //konten = new KONTENLISTE ();
        kunden = new PERSONENLISTE ();
        angestellte = new PERSONENLISTE ();
        verbindung. KundenHolen (kunden);
        verbindung. AngestellteHolen (angestellte, this);
        //verbindung. KontenHolen (konten, kunden);
    }
    /**
     * Gibt die eine CATERER zurück.
     * @return die CATERER
     */
    static CATERER CatererGeben ()
    {
        return derCaterer;
    }
    /**
     * Speichert die Namen der Gerichte in der Datenbank
     * @param Liste der Gerichte, sortiert von Mo - Fr mit je zwei Gerichten
     */
    public void GerichteAktualisieren(String[] liste)
    {
     verbindung.GerichteAktualisieren(liste);
    }
    
     /**
     * Liefert die Namen der Gerichte in der Datenbank
     * @return Liste der Gerichte, sortiert von Mo - Fr mit je zwei Gerichten
     */
    public String[] GerichteLieferen()
    {
    return verbindung.GerichteLieferen();
    }
    
    /**
     * Holt die Übersicht der gewählten Gerichte für den Angestellten.
     * @return Feld von Texten
     */
    public AUSZUGSEINTRAG [] UebersichtGErstellen()
    {
        return verbindung.AuszugsdatenErstellen();
        
    }
    /**
     * Schließt alle Datenkanäle zur persistenten Datenhaltung;
     */
    void Beenden ()
    {
        verbindung. VerbindungBeenden ();
    }

    /**
     * Meldet die DatenCATERERverbindung für diese CATERER.
     * @return DatenCATERERverbindung.
     */
    DATENBANKVERBINDUNG DatenbankverbindungGeben ()
    {
        return verbindung;
    }

    // /**
     // * Trägt einen neuen Kunden ein und setzt ihn als aktuellen Kunden.
     // * Die Namenseindeutigkeit muss schon überprüft sein.
     // * Der Kunde wird auch in der Datenbank eingetragen.
     // * @param name Name des neuen Kunden.
     // * @param pin PIN des neuen Kunden.
     // */
    // void NeuenKundenEinrichten (String name, String pin)
    // {
        // KUNDE k = new KUNDE (name, pin);
        // kunden. Einfuegen (k);
        // verbindung. NeuenKundenEinfuegen (k);
    // }

    /**
     * Sucht in der Liste der Kunden nach einem bestimmten Namen.
     * @param name Benutzername des zu suchenden Kunden.
     * @return der Kunde oder null, falls der Name nicht exisitiert.
     */
    KUNDE KundenSuchen (String name)
    {
        return (KUNDE) kunden. Suchen (name);
    }

    // /**
     // * Löscht den angegebenen Kunden.
     // * pre: Es darf kein Konto dieses Kunden mehr existieren.
     // * @param k der zu löschende Kunde
     // */
    // void KundenLoeschen (KUNDE k)
    // {
        // kunden. Loeschen (k);
        // verbindung. PersonLoeschen (k);
    // }

    /**
     * Meldet die Namen aller Kunden.
     * @return Feld mit den Namen der Kunden.
     */
    String [] KundennamenGeben ()
    {
        return kunden. PersonennamenGeben (new KUNDE ("", ""));
    }

    /**
     * Trägt einen neuen Angestellten ein und setzt ihn als aktuellen Angestellten.
     * Die Namenseindeutigkeit muss schon überprüft sein.
     * Der Angestellte wird auch in der DatenCATERER eingetragen.
     * @param name Benutzername des neuen Angestellten.
     * @param pin PIN des neuen Angestellten.
     */
    void NeuenAngestelltenEinrichten (String name, String pin)
    {
        ANGESTELLTER a = new ANGESTELLTER (name, pin, this);
        angestellte. Einfuegen (a);
        verbindung. NeuenAngestelltenEinfuegen (a);
    }

    /**
     * Sucht in der Liste der Angestellten nach einem bestimmten Namen.
     * @param name Name des zu suchenden Angestellten.
     * @return der Angestellte oder null, falls der Name nicht exisitiert.
     */
    ANGESTELLTER AngestelltenSuchen (String name)
    {
        return (ANGESTELLTER) angestellte. Suchen (name);
    }

    // /**
     // * Löscht den angegebenen Angestellten.
     // * @param a der zu löschende Angestellte
     // */
    // void AngestelltenLoeschen (ANGESTELLTER a)
    // {
        // angestellte. Loeschen (a);
        // verbindung. PersonLoeschen (a);
    // }

    /**
     * Meldet die Namen aller Angestellten.
     * @param derNicht diese Person kommt nicht in die Liste.
     * @return Feld mit den Namen der Angestellten.
     */
    String [] AngestelltennamenGeben (ANGESTELLTER derNicht)
    {
        return angestellte. PersonennamenGeben (derNicht);
    }

    // /**
     // * Legt ein neues Sparkonto an.
     // * Die Referenz wird in konten gespeichert.
     // * @param zins der Zinssatz für das neue Konto
     // * @param fuerKunde der Besitzer des neuen Kontos
     // * @return die Nummer des neuen Kontos
     // */
    // int SparkontoEinrichten (double zins, KUNDE fuerKunde)
    // {
        // SPARKONTO kontoneu;
        // int nummer;
        // nummer = verbindung. MaxKontonummerGeben () + 1;
        // kontoneu = new SPARKONTO (nummer, zins, fuerKunde, verbindung);
        // konten. Einfuegen (kontoneu);
        // verbindung. NeuesSparkontoEinfuegen (kontoneu);
        // return nummer;
    // }

    // /**
     // * Legt ein neues Girokonto an.
     // * Die Referenz wird in konten gespeichert.
     // * @param kredit der Überziehungsrahmen für das neue Konto
     // * @param fuerKunde der Besitzer des neuen Kontos
     // * @return die Nummer des neuen Kontos
     // */
    // int GirokontoEinrichten (double kredit, KUNDE fuerKunde)
    // {
        // GIROKONTO kontoneu;
        // int nummer;
        // nummer = verbindung. MaxIDNummerGeben () + 1;
        // kontoneu = new GIROKONTO (nummer, kredit, fuerKunde, verbindung);
        // konten. Einfuegen (kontoneu);
        // verbindung. NeuesGirokontoEinfuegen (kontoneu);
        // return nummer;
    // }

    // /**
     // * Löscht das angegebene Konto, falls
     // * der Kontostand 0 ist.
     // * @param konto das zu löschende Konto
     // * @return true, falls das Konto gelöscht wurde
     // */
    // boolean KontoLoeschen (KONTO konto)
    // {
        // if (konto. KontostandGeben () == 0.0)
        // {
            // konten. Loeschen (konto);
            // verbindung. KontoLoeschen (konto);
            // return true;
        // }
        // else
        // {
            // return false;
        // }
    // }

    

    
    
}
