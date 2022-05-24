
/**
 * Beschreibt die Produzenten von Meldungen.
 * 
 * @author 
 * @version 1.0
 */

interface MELDUNGSERZEUGER
{
    /**
     * Registriert einen Beobachter beim Produzenten.
     */
    void Registrieren (MELDUNGSBEOBACHTER beobachter);

    /**
     * Meldet einen Beobachter beim Produzenten ab.
     */
    void Abmelden (MELDUNGSBEOBACHTER beobachter);
}
