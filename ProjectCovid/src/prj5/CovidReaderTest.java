package prj5;

import java.io.FileNotFoundException;

/**
 * This is the Covid Reader Test Class
 * 
 * @author Ben Rosenbloom
 * @version 2021.11.18
 * @author Raena Rahimi Bafrani (raenar@vt.edu)
 * @version 2021.11.18
 * @author Tejas Choudhary
 * @version 2021.11.18
 */
public class CovidReaderTest extends student.TestCase {

    private CovidReader reader;
    private LinkedList<State> state = new LinkedList<State>();

    /**
     * Set up ran before each test.
     * 
     * @throws FileNotFoundException
     *             If file if not found in setup, throws exeption.
     */
    public void setUp() throws FileNotFoundException {

        reader = new CovidReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");

        Race whitedc = new Race("white", "70678", "1924");
        Race blackdc = new Race("black", "179563", "13365");
        Race latindc = new Race("latinX", "97118", "2269");
        Race asiandc = new Race("asian", "5407", "254");
        Race otherdc = new Race("other", "108784", "170");
        State dc = new State("DC", whitedc, blackdc, latindc, asiandc, otherdc);
        state.add(dc);

        Race whitega = new Race("white", "1122398", "51012");
        Race blackga = new Race("black", "1199125", "50296");
        Race latinga = new Race("latinX", "601778", "6152");
        Race asianga = new Race("asian", "60426", "1846");
        Race otherga = new Race("other", "1542083", "1848");
        State ga = new State("GA", whitega, blackga, latinga, asianga, otherga);
        state.add(ga);

        Race whitemd = new Race("white", "534910", "44759");
        Race blackmd = new Race("black", "764514", "42863");
        Race latinmd = new Race("latinX", "635420", "11343");
        Race asianmd = new Race("asian", "47733", "3999");
        Race othermd = new Race("other", "539893", "2103");
        State md = new State("MD", whitemd, blackmd, latinmd, asianmd, othermd);
        state.add(md);

        Race whitenc = new Race("white", "1202651", "30203");
        Race blacknc = new Race("black", "525056", "16605");
        Race latinnc = new Race("latinX", "787616", "NA");
        Race asiannc = new Race("asian", "41305", "727");
        Race othernc = new Race("other", "1192110", "6303");
        State nc = new State("NC", whitenc, blacknc, latinnc, asiannc, othernc);
        state.add(nc);

        Race whitetn = new Race("white", "1140754", "16926");
        Race blacktn = new Race("black", "491709", "9442");
        Race latintn = new Race("latinX", "443364", "NA");
        Race asiantn = new Race("asian", "25846", "403");
        Race othertn = new Race("other", "847967", "2122");
        State tn = new State("TN", whitetn, blacktn, latintn, asiantn, othertn);
        state.add(tn);

        Race whiteva = new Race("white", "616402", "34311");
        Race blackva = new Race("black", "426362", "14702");
        Race latinva = new Race("latinX", "738177", "NA");
        Race asianva = new Race("asian", "NA", "NA");
        Race otherva = new Race("other", "777332", "5745");
        State va = new State("VA", whiteva, blackva, latinva, asianva, otherva);
        state.add(va);
    }


    /**
     * Test getStates()
     */
    public void testGetStates() {
        assertEquals(reader.getstate(), state);

    }
}
