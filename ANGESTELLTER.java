
/**
 * Beschreibt die Angestellten des Cateringunternehmens.
 * 
 * @author 
 * @version 1.0
 */
class ANGESTELLTER extends PERSON
{
    /** Der Kunde, der gerade bearbeitet wird */
    private KUNDE aktKunde;
    /** Das Catering-Unternehmen, in der der Angestellte arbeitet. */
    private CATERER caterer;
    
    
    /**
     * Belegt name und pin der Person
     * @param n Name der neuen Person
     * @param p PIN der neuen Person
     * @param b Bank des Angestellten
     */
    ANGESTELLTER (String n, String p, CATERER b)
    {
        super (n, p);
        aktKunde = null;
        
        caterer = b;
    }

    // /**
     // * Trägt einen neuen Kunden ein und setzt ihn als aktuellen Kunden.
     // * @param name Name des neuen Kunden.
     // * @param pin Passwort des neuen Kunden.
     // * @return true, wenn der Kunde eingerichtet werden konnte.
     // */
    // boolean NeuenKundenEinrichten (String name, String pin)
    // {
        // if ((caterer. KundenSuchen (name) != null) || (caterer. AngestelltenSuchen (name) != null))
        // {
            // return false;
        // }
        // else
        // {
            // caterer. NeuenKundenEinrichten (name, pin); 
            // aktKunde = caterer. KundenSuchen (name);
            // aktKonto = null;
            // return true;
        // }
    // }

    /**
     * Wählt den angegebenen Kunden als aktuellen Kunden.
     * @param name Name des zu wählenden Kunden.
     * @return true, wenn der Kunde existiert.
     */
    boolean KundeWaehlen (String name)
    {
        aktKunde = caterer. KundenSuchen (name);
        
        return aktKunde != null;
    }

    /**
     * Meldet den aktuellen Kunden.
     * @return name Name des Kunden
     */
    KUNDE AktkundeGeben ()
    {
        return aktKunde;
    }

    // /**
     // * Löscht den aktuellen Kunden.
     // * @return Fehlermeldung oder null
     // */
    // String KundenLoeschen ()
    // {
        // if (caterer. KontonummernFuerKundenGeben (aktKunde) == null)
        // {
            // caterer. KundenLoeschen (aktKunde);
            // aktKonto = null;
            // aktKunde = null;
            // return null;
        // }
        // else
        // {
            // return "Der Kunde hat noch Konten.";
        // }
    // }

    // /**
     // * Legt ein neues Sparkonto für den aktuellen Kunden an.
     // * @param zins der Zinssatz für das neue Konto
     // * @return die Nummer des neuen Kontos;
     // */
    // int SparkontoEinrichten (double zins)
    // {
        // return caterer. SparkontoEinrichten (zins, aktKunde);
    // }

    // /**
     // * Legt ein neues Girokonto an.
     // * @param kredit der Überziehungsrahmen für das neue Konto
     // * @return die Nummer des neuen Kontos
     // */
    // int GirokontoEinrichten (double kredit)
    // {
        // return caterer. GirokontoEinrichten (kredit, aktKunde);
    // }


    

    // /**
     // * Löscht das aktuelle Konto, falls der Kontostand 0 ist.
     // * pre: das Konto gehört dem aktuellen Kunden.
     // * @return true, falls das Konto gelöscht wurde
     // */
    // boolean KontoLoeschen ()
    // {
        // if (caterer. KontoLoeschen (aktKonto))
        // {
            // aktKonto = null;
            // return true;
        // }
        // else
        // {
            // return false;
        // }
    // }
    
    // /**
     // * Generiert die Daten für die Erstellung des Kontoauszugs.
     // * @return Referenz auf das Ergebnisfeld oder null
     // */
    // AUSZUGSEINTRAG [] AuszugsdatenErstellen ()
    // {
        // return aktKonto. AuszugsdatenErstellen ();
    // }

    /**
     * Trägt einen neuen Angestellten ein.
     * @param name Name des neuen Angestellten.
     * @param pin PIN des neuen Angestellten.
     * @return true, wenn der Angestellte eingerichtet werden konnte.
     */
    boolean NeuenAngestelltenEinrichten (String name, String pin)
    {
        if ((caterer. KundenSuchen (name) != null) || (caterer. AngestelltenSuchen (name) != null))
        {
            return false;
        }
        else
        {
            caterer. NeuenAngestelltenEinrichten (name, pin); 
            return true;
        }
    }

    // /**
     // * Löscht den angegebenen Angestellten.
     // * @param name der zu löschende Angestellte
     // * @return true, wenn der Angestellte gelöscht werden konnte
     // */
    // boolean AngestelltenLoeschen (String name)
    // {
        // ANGESTELLTER a;
        // a = caterer. AngestelltenSuchen (name);
        // if (a != null)
        // {
            // caterer. AngestelltenLoeschen (a);
            // return true;
        // }
        // else
        // {
            // return false;
        // }
    // }
    
   
}