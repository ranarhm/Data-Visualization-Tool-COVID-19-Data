package prj5;

import student.TestCase;

/**
 * Test class for State.
 * 
 * @author Benjamin Rosenbloom (bprosenbloom@vt.edu)
 * @version 2021.11.18
 * @author Raena Rahimi Bafrani (raenar@vt.edu)
 * @version 2021.11.18
 * @author Tejas Choudhary
 * @version 2021.11.18
 *
 */
public class StateTest extends TestCase {
    private State va;
    private Race white;
    private Race black;
    private Race latin;
    private Race asian;
    private Race other;

    /**
     * Initializes a list with number of states
     */
    public void setUp() {
        LinkedList<Race> list = new LinkedList<Race>();
        white = new Race("White", "200", "10");
        black = new Race("Black", "300", "15");
        latin = new Race("Latin", "450", "30");
        asian = new Race("Asian", "100", "10");
        other = new Race("Other", "350", "25");
        va = new State("VA", white, black, latin, asian, other);
        list.add(white);
        list.add(black);
        list.add(latin);
        list.add(asian);
        list.add(other);
    }


    /**
     * Tests get methods (getName, getRaces)
     */
    public void testGetMethods() {
        assertTrue(va.getName().equals("VA"));

        LinkedList<Race> raceList = new LinkedList<Race>();
        raceList.add(white);
        raceList.add(black);
        raceList.add(latin);
        raceList.add(asian);
        raceList.add(other);
        assertEquals(va.getRaces(), raceList);
    }


    /**
     * Tests equal method
     */
    public void testEquals() {

        assertTrue(va.equals(va));

        State newVa = new State("VA", white, black, latin, asian, other);
        assertTrue(va.equals(newVa));

        State nullState = null;
        assertFalse(va.equals(nullState));

        Object obj = new Object();
        assertFalse(va.equals(obj));

        State va1 = new State("VA", black, white, latin, asian, other);
        assertTrue(va.equals(va1));
    }
    
    /**
     * Tests alphaSortMethod method
     */
    public void testAlphaSortMethod() {
        va.alphaSortMethod();
        assertEquals(va.toString(), "VA\n"
            + "Asian: 100 cases, 10% CFR\n"
            + "Black: 300 cases, 5% CFR\n"
            + "Latin: 450 cases, 6.7% CFR\n"
            + "Other: 350 cases, 7.1% CFR\n"
            + "White: 200 cases, 5% CFR\n"
            + "=====\n"
            + "Asian: 100 cases, 10% CFR\n"
            + "Other: 350 cases, 7.1% CFR\n"
            + "Latin: 450 cases, 6.7% CFR\n"
            + "Black: 300 cases, 5% CFR\n"
            + "White: 200 cases, 5% CFR\n"
            + "=====");


    }
    
    /**
     * Tests crfSortMethod method
     */
    public void testCrfSortMethod() {
        va.cfrSortMethod();
        assertEquals(va.toString(), "VA\n"
            + "Asian: 100 cases, 10% CFR\n"
            + "Black: 300 cases, 5% CFR\n"
            + "Latin: 450 cases, 6.7% CFR\n"
            + "Other: 350 cases, 7.1% CFR\n"
            + "White: 200 cases, 5% CFR\n"
            + "=====\n"
            + "Asian: 100 cases, 10% CFR\n"
            + "Other: 350 cases, 7.1% CFR\n"
            + "Latin: 450 cases, 6.7% CFR\n"
            + "Black: 300 cases, 5% CFR\n"
            + "White: 200 cases, 5% CFR\n"
            + "=====");

    }

}
