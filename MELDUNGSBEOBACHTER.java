
/**
 * Beschreibt den Beobachter von Meldungen.
 * 
 * @author  
 * @version 1.0
 */

interface MELDUNGSBEOBACHTER
{
    /**
     * Fehlermeldungen beim Ausführen von Aktionen
     */
    void FehlermeldungEmpfangen (String text);

    /**
     * Aktionslog für den Ablauf
     */
    void LogeintragEmpfangen (String text);

}
