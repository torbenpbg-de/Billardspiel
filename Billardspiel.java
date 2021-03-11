import sum.kern.*; 
/** 
 * @author Torben Piepenburg 
 * @version 0.2
 */ 
public class Billardspiel 
{ 
    // Objekte 
    private Bildschirm hatBildschirm; 
    private Maus hatMaus; 
    private Kugel hatKugel;
    Stift meinStift;
    // Konstruktor - erzeugen der Objekte  public Hauptprogramm() 
    { 
        hatBildschirm = new Bildschirm(640,480);  hatMaus = new Maus(); 
        hatKugel = new Kugel();  meinStift = new Stift();
    } 
    // Dienste 
    /**
     * "Hauptdienst" des Programmes
     */
    public void fuehreAus() 
    { 
        //Grenzpunkte: (x = 80 bis 560 | y = 80 bis 360)
        this.zeichneTisch();

        //Kugel wird in den Billardtisch gesetzt
        hatKugel.bewegeBis(320, 220);
        
        //Die Kugel bewegt sich innerhalb des Tisches solange kein Doppelklick
        do 
        {            
            hatKugel.bewege(0.25);
        } while (!hatMaus.doppelKlick());   
        
        // Aufraeumen 
        hatKugel.gibFrei(); 
        hatMaus.gibFrei(); 
        hatBildschirm.gibFrei();     
    }

    /**
     * In diesem Teil wird der Billardtisch gezeichnet
     */
    private void zeichneTisch()
    {
        //Zeichnen des Billardtisches
        meinStift.bewegeBis(80, 80);
        meinStift.runter();
        meinStift.bewegeBis(560, 80);
        meinStift.bewegeBis(560, 360);
        meinStift.bewegeBis(80, 360);
        meinStift.bewegeBis(80, 80);

        // Aufraeumen 
        meinStift.gibFrei();
    }
}
