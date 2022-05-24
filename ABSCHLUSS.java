
/**
 * Abschluss einer Personenliste.
 * 
 * @author 
 * @version 1.0
 */
class ABSCHLUSS extends LISTENELEMENTP
{
    
    /**
     * Belegt die Attribute.
     */
    ABSCHLUSS ()
    {
        super ();
    }

    /**
     * Fügt eine Person in die nach Namen sortierte Liste ein.
     * @param person Referenz auf die einzufügende.
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENTP Einfuegen (PERSON person)
    {
        return new KNOTENP (this, person);
    }
    
    /**
     * Löscht das angegebene Datenlement aus der Liste.
     * Nutzt die Sortierung der Liste aus.
     * @param person Referenz auf die zu löschende Person.
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENTP Loeschen (PERSON person)
    {
        return this;
    }
    
    /**
     * Sucht die angegebene Person.
     * Nutzt die Sortierung der Liste aus.
     * @param name Name der zu suchenden Person.
     * @return Referenz auf die Person oder null.
     */
    PERSON Suchen (String name)
    {
        return null;
    }
    
    /**
     * Zählt die Elemente der Liste.
     * @param derNicht wird bei der Zählung übergangen.
     * @return Anzahl der Mitglieder der Liste.
     */
    int Zaehlen (String derNicht)
    {
        return 0;
    }
    
    /**
     * Trägt die Namen in das Feld ein.
     * @param derNicht wird beim Eintrag übergangen.
     * @param ergebnis Referenz auf das Feld mit den gefundenen Daten.
     * @param pos Index, auf dem das nächste Element eingetragen werden soll.
     */
    void NamenEintragen (String derNicht, String [] ergebnis, int pos)
    {
        // hier ist nichts mehr zu tun
    }
}
