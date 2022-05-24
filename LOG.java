
import java.text.SimpleDateFormat;  
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Verwaltet die Einträge in die Logdatei.
 * 
 * @author 
 * @version 1.0
 */
class LOG implements MELDUNGSBEOBACHTER{
    PrintWriter pWriter = null;
    public LOG() {

        try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("log.txt")),true);

            Date d = new Date();

            Calendar c = Calendar.getInstance();
            c.setTime(d);
            c.roll(Calendar.HOUR, -1);

            d = c.getTime();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(d);

            pWriter.println("Logdatei vom " + date);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                //pWriter.close();
            }
        }
    }

    /**
     * Schliesst die Logdatei.
     */
    void Schliessen ()
    {
        try
        {
            pWriter. close ();
        }
        catch (Exception e)
        {
            e. printStackTrace ();
        }
    }

    /**
     * Fehlermeldungen beim Ausführen von Aktionen
     */
    public void FehlermeldungEmpfangen (String text)
    {
        try
        {
            pWriter.println("Fehler: " + text);

        }
        catch (Exception e)
        {
            e. printStackTrace ();
        }
    }

    /**
     * Aktionslog für den Ablauf
     */
    public void LogeintragEmpfangen (String text)
    {
        try
        {
            pWriter.println("Log: "+ text);

        }
        catch (Exception e)
        {
            e. printStackTrace ();
        }
    }
}
