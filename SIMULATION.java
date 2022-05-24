
/**
 * Baut die Simulation auf.
 * 
 * @author 
 * @version 1.0
 */
class SIMULATION
{

    /**
     * Legt die zentralen Objekte an und verknüpft sie.
     */
    private SIMULATION()
    {
        KONTROLLEUR k;
        OBERFLAECHE o;
		k = new KONTROLLEUR(CATERER.CatererGeben ());
		o = new OBERFLAECHE(k);
        CATERER.CatererGeben().DatenbankverbindungGeben (). Registrieren (o);
    }
    
    /**
     * Startmethode
     * @param ags Kommandozeilenargumente
     */
    public static void main (String [] args)
    {
        new SIMULATION ();
    }
}
