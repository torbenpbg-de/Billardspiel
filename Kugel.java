import sum.kern.*; 
/** 
 * Die Klasse Kugel  
 * @author Torben Piepenburg
 * @version 0.4
 */ 
public class Kugel 
{ 
    // Bezugsobjekte 
    private Stift hatStift;
    private Bildschirm kenntBildschirm;
    
    // Attribute
    private int zGroesse;
    private double zGeschw;
    private double zRichtung;

    // Konstruktor 
    /** 
     * Der Stift zum Zeichnen der Kugel wird erzeugt. 
     */ 
    public Kugel(int pH, int pV, int pGroesse, double pGeschw, double pRichtung, Bildschirm pBildschirm) 
    {         
        zGroesse = pGroesse; 
        zGeschw = pGeschw;
        zRichtung = pRichtung;
        hatStift = new Stift(); 
        hatStift.bewegeBis(pH, pV);
        this.setzeRichtung(zRichtung);
        kenntBildschirm = pBildschirm;

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
        hatStift.zeichneKreis(zGroesse); 
    } 

    /** 
     * Die Kugel wird gelöscht. 
     */ 
    public void loesche() 
    { 
        //Löscht die Kugel
        hatStift.radiere();
        hatStift.zeichneKreis(zGroesse);
        hatStift.normal();
    } 

    /** 
     * Die Kugel bewegt sich über den Bildschirm.
     * @param pWeg beschreibt wie weit sich die Kugel bewegen soll.
     */ 
    public void bewege() 
    { 
        //Bewegt die Kugel
        this.loesche();        
        hatStift.bewegeUm(zGeschw);        
        this.zeichne();

        if (this.amLinkenRand() || this.amRechtenRand())
        {
            this.setzeRichtung(180 - hatStift.winkel());
        }
        else if (this.amOberenRand() || this.amUnterenRand())
        {
            this.setzeRichtung(360 - hatStift.winkel());
        }

    }

    public void bewegeBis ( double pX, double pY)
    {
        hatStift.bewegeBis(pX, pY);
    }

    /** 
     * die Richtung der Kugel wird geändert 
     * @param pRichtung neue Richtung der Kugel in Grad 
     */ 
    public void setzeRichtung(double pRichtung) 
    { 
        zRichtung = pRichtung;
        hatStift.dreheBis(zRichtung); 
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
     * wenn die Kugel den linken Rand erreicht soll "wahr" ausgegeben werden
     * Damit die "Außenpunkte" anstatt des Mittelpunktes der Kugel genommen wird die Größe addiert 
     * Damit die Kugel nicht auf dem Rand liegt sondern vor dem Rand stoppt wird eine 1 addiert
     */
    private boolean amLinkenRand()
    {
        if (this.hPosition() < 0 + zGroesse + 1)
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
     * Damit die "Außenpunkte" anstatt des Mittelpunktes der Kugel genommen wird die Größe subtrahiert
     * Damit die Kugel nicht auf dem Rand liegt sondern vor dem Rand stoppt wird eine 1 subtrahiert
     */
    private boolean amRechtenRand()
    {
        if (this.hPosition() > kenntBildschirm.breite() - zGroesse -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private boolean amOberenRand()
    {
        if (this.vPosition() < 0 + zGroesse +1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private boolean amUnterenRand()
    {
        if (this.vPosition() > kenntBildschirm.hoehe() - zGroesse -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setzeGroesse(int pGroesse)
    {
        zGroesse = pGroesse;
    }

    public int groesse()
    {
        return zGroesse;
    }

    public void setzeGeschw(double pGeschw)
    {
        zGeschw = pGeschw;
    }

    public double geschw()
    {
        return zGeschw;
    }

} 
