package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * CovidReader Class
 * Reads Through the given file passed.
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
public class CovidReader {

    private LinkedList<State> state = new LinkedList<State>();

    /**
     * This is the constructor of the DocumentReader class. It specifies the
     * file that the DocumentReader will read.
     * 
     * @param fileName
     *            the passed file, NOT HARDCODED
     * @throws FileNotFoundException
     *             if file does not exist
     */
    public CovidReader(String fileName) throws FileNotFoundException {
        state = scanThroughFile(fileName);
    }


    /**
     * This method reads through the file of a known format, and transcribes it
     * into State objects consisting of Race objects.
     * 
     * @param fileName
     *            the location of the file
     * @return LinkedList of state
     * @throws FileNotFoundException
     *             if the file does not exist
     */
    private LinkedList<State> scanThroughFile(String fileName)
        throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        String line = file.nextLine();

        // Scans file through each line.
        while (file.hasNextLine()) {
            line = file.nextLine();
            String[] list = line.split(",");
            String name = list[0];
            // State Name
            Race whiteReader = new Race("white", list[1], list[6]);
            // White Cases and Deaths Respectfully
            Race blackReader = new Race("black", list[2], list[7]);
            // Black Cases and Deaths Respectfully
            Race latinXReader = new Race("latinX", list[3], list[8]);
            // Latinx Cases and Deaths Respectfully
            Race asianReader = new Race("asian", list[4], list[9]);
            // Asian Cases and Deaths Respectfully
            Race otherReader = new Race("other", list[5], list[10]);
            // Other Cases and Deaths Respectfully
            State tempState = new State(name, whiteReader, blackReader,
                latinXReader, asianReader, otherReader);
            state.add(tempState);

        }
        return state;

    }


    /**
     * Method to Get The state and return it.
     * 
     * @return state LinkedList.
     */
    public LinkedList<State> getstate() {
        return state;
    }
}
