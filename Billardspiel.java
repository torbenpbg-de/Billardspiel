import sum.kern.*; 
/** 
 * @author Torben Piepenburg 
 * @version 0.4
 */ 
public class Billardspiel 
{ 
    // Objekte 
    private Bildschirm hatBildschirm; 
    private Maus hatMaus; 
    private Kugel Kugel1;
    private Kugel Kugel2;
    private Kugel Kugel3;
    Stift meinStift;
    // Konstruktor - erzeugen der Objekte  public Hauptprogramm() 
    { 
        hatBildschirm = new Bildschirm(640,480);
        hatMaus = new Maus(); 
        meinStift = new Stift();
        Kugel1 = new Kugel(100, 100, 5, 0.1, 80); 
        Kugel2 = new Kugel(400, 200, 8, 0.2, 100);
        Kugel3 = new Kugel(100, 300, 10, 0.15, 60); 

    } 
    // Dienste 
    /**
     * "Hauptdienst" des Programmes
     */
    public void fuehreAus() 
    { 
        //Grenzpunkte: (x = 80 bis 560 | y = 80 bis 360)
        this.zeichneTisch();
       
        //Die Kugel bewegt sich innerhalb des Tisches solange kein Doppelklick
        do 
        {            
            Kugel1.bewege();
            Kugel2.bewege();
            Kugel3.bewege();
        } while (!hatMaus.doppelKlick());   
        
        // Aufraeumen 
        Kugel1.gibFrei();
        Kugel2.gibFrei(); 
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
