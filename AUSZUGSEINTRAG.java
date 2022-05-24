
/**
 * Enthält die Daten für die Übersicht zu den gewählten Produkte.
 * 
 * @author  
 * @version 1.0
 */
class AUSZUGSEINTRAG
{
    private String[] datensatz;

    /**
     * Besetzt eines Datensatzes.
     */
    AUSZUGSEINTRAG (String vorname, String nachname, String gMo, String gDi, String gMi, String gDo, String gFr)
    {
        datensatz= new String[7];
        datensatz[0]=vorname;
        datensatz[1]=nachname;
        datensatz[2]=gMo;
        datensatz[3]=gDi;
        datensatz[4]=gMi;
        datensatz[5]=gDo;
        datensatz[6]=gFr;
    }
    
    /**
     * Gib einen Datensatz zurück - Aufbau: Vorname, Nachname, gMo, gDi, gMi, gDo, gFr
     * @return laufende Nummer des Auszugs
     */
    public String[] GibDatensatz ()
    {
        return datensatz;
    }
    
    
}
