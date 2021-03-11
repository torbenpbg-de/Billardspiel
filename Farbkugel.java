import sum.kern.*; 
/**
 * @author Torben Piepenburg
 * @version 0.5
 */
public class Farbkugel extends Kugel 
{ 
    // Bezugsobjekte 
    Buntstift hatStift; 
    // Attribute 
    private int zFarbe; 
    // Konstruktor 
    public Farbkugel(int pH, int pV, int pGroesse, double pGeschw, int pRichtung, Bildschirm pBildschirm, int pFarbe)
    { 
        super(pH, pV, pGroesse, pGeschw, pRichtung, pBildschirm);
        zFarbe = pFarbe; 
        hatStift = new Buntstift(); 
        hatStift.bewegeBis(pH, pV); 
        hatStift.setzeFarbe(zFarbe); 
        hatStift.setzeFuellmuster(Muster.GEFUELLT); 
    } 
    // Dienste 
    public void zeichne() 
    { 
        hatStift.bewegeBis(this.hPosition(), this.vPosition());
        hatStift.zeichneKreis(this.groesse()); 
    } 

    public void loesche() 
    { 
        hatStift.radiere(); 
        this.zeichne(); 
        hatStift.normal(); 
    } 
}

