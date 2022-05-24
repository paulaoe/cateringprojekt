
/**
 * Allgemeines Element einer Personenliste
 * 
 * @author 
 * @version 1.0
 */
abstract class LISTENELEMENTP
{
    /**
     * Der Konstruktor ist nur der vollständigkeit halber angegeben.
     */
    LISTENELEMENTP ()
    {
        // (noch) nichts zu tun
    }

    /**
     * Fügt eine Person in die nach Namen sortierte Liste ein.
     * @param person Referenz auf die einzufügende.
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    abstract LISTENELEMENTP Einfuegen (PERSON person);
    
    /**
     * Löscht das angegebene Datenlement aus der Liste.
     * Nutzt die Sortierung der Liste aus.
     * @param person Referenz auf die zu löschende Person.
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    abstract LISTENELEMENTP Loeschen (PERSON person);
    
    /**
     * Sucht die angegebene Person.
     * Nutzt die Sortierung der Liste aus.
     * @param name Name der zu suchenden Person.
     * @return Referenz auf die Person oder null.
     */
    abstract PERSON Suchen (String name);
    
    /**
     * Zählt die Elemente der Liste.
     * @param derNicht wird bei der Zählung übergangen.
     * @return Anzahl der Mitglieder der Liste.
     */
    abstract int Zaehlen (String derNicht);
    
    /**
     * Trägt die Namen in das Feld ein.
     * @param derNicht wird beim Eintrag übergangen.
     * @param ergebnis Referenz auf das Feld mit den gefundenen Daten.
     * @param pos Index, auf dem das nächste Element eingetragen werden soll.
     */
    abstract void NamenEintragen (String derNicht, String [] ergebnis, int pos);
}
