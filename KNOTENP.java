
/**
 * (Innerer) Konten einer Personenliste.
 * 
 * @author 
 * @version 
 */
import java.text.Collator;
class KNOTENP extends LISTENELEMENTP
{
    private LISTENELEMENTP nachfolger;
    private PERSON person;
    private Collator myCollator;
    
    /**
     * Belegt die Attribute.
     * @param nr Referenz auf den Nachfolger dieses Konotens
     * @param p Referenz auf die zu verwaltende Person
     */
    KNOTENP (LISTENELEMENTP nf, PERSON p)
    {
        super ();
        nachfolger = nf;
        person = p;
        myCollator = Collator. getInstance ();
    }

    /**
     * Fügt eine Person in die nach Namen sortierte Liste ein.
     * @param p Referenz auf die einzufügende Person.
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENTP Einfuegen (PERSON p)
    {
        if (myCollator. compare (person. NameGeben (), p. NameGeben ()) < 0)
        {
            nachfolger = nachfolger. Einfuegen (p);
            return this;
        }
        else
        {
            return new KNOTENP (this, p);
        }
    }
    
    /**
     * Löscht das angegebene Datenlement aus der Liste.
     * Nutzt die Sortierung der Liste aus.
     * @param p Referenz auf die zu löschende Person.
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENTP Loeschen (PERSON p)
    {
        if (person == p)
        {
            return nachfolger;
        }
        else
        {
            if (myCollator. compare (person. NameGeben (), p. NameGeben ()) < 0)
            {
                nachfolger = nachfolger. Loeschen (p);
            }
            return this;
        }
    }
    
    /**
     * Sucht die angegebene Person.
     * Nutzt die Sortierung der Liste aus.
     * @param name Name der zu suchenden Person.
     * @return Referenz auf die Person oder null.
     */
    PERSON Suchen (String name)
    {
        if (name. equals (person. NameGeben ()))
        {
            return person;
        }
        else if (myCollator. compare (person. NameGeben (), name) < 0)
        {
            return nachfolger. Suchen (name);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Zählt die Elemente der Liste.
     * @param derNicht wird bei der Zählung übergangen.
     * @return Anzahl der Mitglieder der Liste.
     */
    int Zaehlen (String derNicht)
    {
        String name;
        name = person. NameGeben ();
        if (name. equals ("Chef") || name. equals (derNicht))
        {
            return nachfolger. Zaehlen (derNicht);
        }
        else
        {
            return nachfolger. Zaehlen (derNicht) + 1;
        }
    }
    
    /**
     * Trägt die Namen in das Feld ein.
     * @param derNicht wird beim Eintrag übergangen.
     * @param ergebnis Referenz auf das Feld mit den gefundenen Daten.
     * @param pos Index, auf dem das nächste Element eingetragen werden soll.
     */
    void NamenEintragen (String derNicht, String [] ergebnis, int pos)
    {
        String name;
        name = person. NameGeben ();
        if (name. equals ("Chef") || name. equals (derNicht))
        {
            nachfolger. NamenEintragen (derNicht, ergebnis, pos);
        }
        else
        {
            ergebnis [pos] = name;
            nachfolger. NamenEintragen (derNicht, ergebnis, pos + 1);
        }
    }
}
