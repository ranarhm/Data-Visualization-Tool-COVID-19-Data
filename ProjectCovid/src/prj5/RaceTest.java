package prj5;

/**
 * Test class for Race.
 * 
 * @author Ben Rosenbloom
 * @version 2021.11.18
 * @author Raena Rahimi Bafrani (raenar@vt.edu)
 * @version 2021.11.18
 * @author Tejas Choudhary
 * @version 2021.11.18
 */
public class RaceTest extends student.TestCase {

    private Race race;

    /**
     * Instantiates race as a new Race instance with name "White",
     * cases 200, and deaths as 10.
     */
    public void setUp() {
        race = new Race("White", "200", "10");

    }
    
    /**
     * Testing all get methods (getName, getCases, getDeaths)
     */
    public void testRace() {
        Race race1 = new Race("White", "NA", "NA");
        assertEquals(-1, race1.getCases());
        assertEquals(-1, race1.getDeaths());
        assertEquals(-1, race1.getCFR(), 0.0);
        
        Race race2 = new Race("White", "NA", "5");
        assertEquals(-1, race2.getCases());
        assertEquals(5, race2.getDeaths());
        assertEquals(-1, race2.getCFR(), 0.0);
    }



    /**
     * Testing all get methods (getName, getCases, getDeaths)
     */
    public void testGetMethods() {
        assertTrue(race.getName().equals("White"));
        assertEquals(200, race.getCases());
        assertEquals(10, race.getDeaths());
    }


    /**
     * Testing equals method.
     */
    public void testEquals() {

        Race raceNull = null;
        Object obj = new Object();
        Race raceNotEquals = new Race("Black", "150", "8");
        Race raceEquals = new Race("White", "200", "10");

        assertTrue(race.equals(race));

        assertFalse(race.equals(raceNull));
        assertFalse(race.equals(obj));
        assertFalse(race.equals(raceNotEquals));

        assertTrue(race.equals(raceEquals));
        
        Race race1 = new Race("White", "100", "10");
        assertFalse(race.equals(race1));
        
        Race race2 = new Race("White", "200", "5");
        assertFalse(race.equals(race2));
    }
}
