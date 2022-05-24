
/**
 * Oberklasse für alle Personen.
 * 
 * @author  
 * @version 1.0
 */
abstract class PERSON
{
    protected String benutzername;
    protected String pin;
    
    /**
     * Belegt benutzername und pin der Person
     * @param b Benutzername der neuen Person
     * @param p PIN der neuen Person
     */
    PERSON (String b, String p)
    {
        benutzername = b;
        pin = p;
    }

    /**
     * Gibt die Pin des Kunden zurück
     * @return PIN des Kunden
     */
    String PinGeben ()
    {
        return pin;
    }

    /**
     * Gibt den Namen des Kunden zurück
     * @return Name des Kunden
     */
    String NameGeben ()
    {
        return benutzername;
    }

    /**
     * Setzt eine neues Passwort für den Kunden.
     * @param neuesPasswort das neue Passwort
     */
    void PinSetzen (String wort)
    {
        pin = wort;
        //CATERER.CatererGeben (). DatenbankverbindungGeben ().PinSetzen (benutzername, wort);
    }
    
}
