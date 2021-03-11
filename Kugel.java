import sum.kern.*; 
/** 
 * Die Klasse Kugel  
 * @author Torben Piepenburg
 * @version 0.2
 */ 
public class Kugel 
{ 
    // Bezugsobjekte 
    private Stift hatStift; 
    // Attribute 
    // Konstruktor 
    /** 
     * Der Stift zum Zeichnen der Kugel wird erzeugt. 
     */ 
    public Kugel() 
    { 
        hatStift = new Stift(); 
        hatStift.bewegeBis(10, 100); 
    } 
    // Dienste
    /** 
     * Der Stift zum Zeichnen der Kugel wird frei gegeben. 
     */ 
    public void gibFrei() 
    { 
        hatStift.gibFrei(); 
    } 

    /** 
     * Die Kugel wird gezeichnet. 
     */ 
    public void zeichne() 
    { 
        hatStift.zeichneKreis(5); 
    } 

    /** 
     * Die Kugel wird gelöscht. 
     */ 
    public void loesche() 
    { 
        //Löscht die Kugel
        hatStift.radiere();
        hatStift.zeichneKreis(5);
        hatStift.normal();
    } 

    /** 
     * Die Kugel bewegt sich über den Bildschirm.
     * @param pWeg beschreibt wie weit sich die Kugel bewegen soll.
     */ 
    public void bewege(double pWeg) 
    { 
        //Bewegt die Kugel
        this.loesche();        
        hatStift.bewegeUm(pWeg);        
        this.zeichne();

        if (this.amLinkenRand())
        {
            this.setzeRichtung(0);
        }

        if (this.amRechtenRand())
        {
            this.setzeRichtung(180);
        }

    }

    public void bewegeBis ( double pX, double pY)
    {
        hatStift.bewegeBis(pX, pY);
    }

    /** 
     * Die horizontale Position der Kugel wird zurückgegeben
     * @return horizontale Position der Kugel 
     */ 
    public double hPosition() 
    { 
        return hatStift.hPosition(); 
    } 

    /** 
     * Die vertikale Position der Kugel wird zurückgegeben
     * @return vertikale Position der Kugel
     * ein Blick in die Zukunft ;)
     */ 
    public double vPosition() 
    { 
        return hatStift.vPosition(); 
    } 

    /** 
     * die Richtung der Kugel wird geändert 
     * @param pRichtung neue Richtung der Kugel in Grad 
     */ 
    public void setzeRichtung(double pRichtung) 
    { 
        hatStift.dreheBis(pRichtung); 
    } 

    /**
     * wenn die Kugel den linken Rand erreicht soll "wahr" ausgegeben werden
     * Damit die Kugel nicht auf dem Rand liegt sondern vor dem Rand stoppt wird eine 1 addiert
     */
    private boolean amLinkenRand()
    {
        if (this.hPosition() < 80 + 5 + 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * wenn die Kugel den rechten Rand erreicht soll "wahr" ausgegeben werden
     * Damit die Kugel nicht auf dem Rand liegt sondern vor dem Rand stoppt wird eine 1 subtrahiert
     */
    private boolean amRechtenRand()
    {
        if (this.hPosition() > 560 - 5 -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
} 
