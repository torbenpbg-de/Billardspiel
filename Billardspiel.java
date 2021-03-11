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
    private Farbkugel Farbkugel1;
    private Farbkugel Farbkugel2;
    Stift meinStift;
    
    // Konstruktor - erzeugen der Objekte  public Hauptprogramm() 
    { 
        hatBildschirm = new Bildschirm(640,480);
        hatMaus = new Maus(); 
        meinStift = new Stift();
        Kugel1 = new Kugel(100, 100, 5, 0.1, 80, hatBildschirm); 
        Kugel2 = new Kugel(400, 200, 8, 0.2, 100, hatBildschirm);
        Kugel3 = new Kugel(500, 300, 10, 0.4, 120, hatBildschirm);
        Farbkugel1 = new Farbkugel(400, 300, 10, 0.4, 150, hatBildschirm, Farbe.GRUEN);
        Farbkugel2 = new Farbkugel(200, 150, 15, 0.8, 10, hatBildschirm, Farbe.ROT); 

    }  
    // Dienste 
    /**
     * "Hauptdienst" des Programmes
     */
    public void fuehreAus() 
    { 
        //Die Kugel bewegt sich innerhalb des Tisches solange kein Doppelklick
        do 
        {            
            Kugel1.bewege();
            Kugel2.bewege(); 
            Kugel3.bewege();   
            Farbkugel1.bewege();
            Farbkugel2.bewege();
        } while (!hatMaus.doppelKlick());   
        
        // Aufraeumen 
        Kugel1.gibFrei();
        Kugel2.gibFrei();
        Farbkugel1.gibFrei(); 
        Farbkugel2.gibFrei(); 
        hatMaus.gibFrei(); 
        hatBildschirm.gibFrei();     
    }
    
}
