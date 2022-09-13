package prj5;

import java.io.FileNotFoundException;

/**
 * InputJava Class
 * A for loop which scans through the File and Outputs the data accordingly.
 *
 * @author Benjamin Rosenbloom (bprosenbloom@vt.edu)
 * @version 2021.11.18
 * @author Raena Rahimi Bafrani (raenar@vt.edu)
 * @version 2021.11.18
 * @author Tejas Choudhary
 * @version 2021.11.18
 * 
 *          // Virginia Tech Honor Code Pledge:
 *          //
 *          // As a Hokie, I will conduct myself with honor and integrity at all
 *          times.
 *          // I will not lie, cheat, or steal, nor will I accept the actions
 *          // of those who do.
 *          // Your name: Group 51
 */
public class Input {

    /**
     * Main Method for Input.
     * 
     * @param args
     *            where the file data is found.
     * 
     * @throws FileNotFoundException
     *             file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        CovidReader reader;

        if (args.length > 0) {
            reader = new CovidReader(args[0]);

        }
        else {
            reader = new CovidReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");

        }

        LinkedList<State> states = reader.getstate();
        @SuppressWarnings("unused")
        GUICovid newGui = new GUICovid(states);

        for (State SortThrough : states) {
            System.out.println(SortThrough.toString());
        }

    }
}
