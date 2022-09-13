package prj5;

import java.awt.Color;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Covid GUI Class
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
public class GUICovid {

    private LinkedList<State> states;
    private Window window;

    private State onScreen;
    // State which is currently on the Screen

    private String comparatorCheck;
    // String to check which comparator needs to run.

    /**
     * Initialize the Buttons and Create the actual Window.
     * @param obj
     *           a state object from LinkedList
     */
    public GUICovid(LinkedList<State> obj) {
        this.states = obj;
        onScreen = null;
        comparatorCheck = " ";
        window = new Window();
        // SET WINDOW SIZE TO CALCULATE AND PLAY WITH VALUES SO IT LOOKS BETTER
        window.setSize(1000, 700);

        // Initialize buttons
        Button alphaSortButton = new Button("Sort by Alpha");
        alphaSortButton.onClick(this, "sortByAlpha");
        window.addButton(alphaSortButton, WindowSide.NORTH);
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        Button cfrSortButton = new Button("Sort by CFR");
        cfrSortButton.onClick(this, "sortByCFR");
        window.addButton(cfrSortButton, WindowSide.NORTH);
        Button displayDC = new Button("Represent DC");
        displayDC.onClick(this, "showDC");
        window.addButton(displayDC, WindowSide.SOUTH);
        Button displayGA = new Button("Represent GA");
        displayGA.onClick(this, "showGA");
        window.addButton(displayGA, WindowSide.SOUTH);
        Button displayMD = new Button("Represent MD");
        displayMD.onClick(this, "showMD");
        window.addButton(displayMD, WindowSide.SOUTH);
        Button showNCButton = new Button("Represent NC");
        showNCButton.onClick(this, "showNC");
        window.addButton(showNCButton, WindowSide.SOUTH);
        Button showTNButton = new Button("Represent TN");
        showTNButton.onClick(this, "showTN");
        window.addButton(showTNButton, WindowSide.SOUTH);
        Button showVAButton = new Button("Represent VA");
        showVAButton.onClick(this, "showVA");
        window.addButton(showVAButton, WindowSide.SOUTH);
    }


    /**
     * Display the DC data
     * 
     * @param button
     *            Represents DC passed in.
     */
    public void showDC(Button button) {
        onScreen = states.get(0);
        windowUpdate();
        TextShape shape = new TextShape(4 * window.getGraphPanelWidth() / 10,
            window.getGraphPanelHeight() / 10,
            "DC Case Fatality Ratios by Race", Color.black);
        window.addShape(shape);

    }


    /**
     * Shows the GA data
     * 
     * @param button
     *            Represent GA passed in.
     */
    public void showGA(Button button) {
        onScreen = states.get(1);
        windowUpdate();
        TextShape shape = new TextShape(4 * window.getGraphPanelWidth() / 10,
            window.getGraphPanelHeight() / 10,
            "GA Case Fatality Ratios by Race", Color.black);
        window.addShape(shape);

    }


    /**
     * Shows the MD data.
     * 
     * @param button
     *            Represent MD passed in .
     */
    public void showMD(Button button) {
        onScreen = states.get(2);
        windowUpdate();
        TextShape shape = new TextShape(4 * window.getGraphPanelWidth() / 10,
            window.getGraphPanelHeight() / 10,
            "MD Case Fatality Ratios by Race", Color.black);
        window.addShape(shape);

    }


    /**
     * Shows the NC data.
     * 
     * @param button
     *            Represent NC passed in.
     */
    public void showNC(Button button) {
        onScreen = states.get(3);
        windowUpdate();
        TextShape shape = new TextShape(4 * window.getGraphPanelWidth() / 10,
            window.getGraphPanelHeight() / 10,
            "NC Case Fatality Ratios by Race", Color.black);
        window.addShape(shape);

    }


    /**
     * Shows the TN data.
     * 
     * @param button
     *            Represent TN passed in.
     */
    public void showTN(Button button) {
        onScreen = states.get(4);
        windowUpdate();
        TextShape shape = new TextShape(4 * window.getGraphPanelWidth() / 10,
            window.getGraphPanelHeight() / 10,
            "TN Case Fatality Ratios by Race", Color.black);
        window.addShape(shape);

    }


    /**
     * Shows the VA data.
     * 
     * @param button
     *            Represent VA passed in.
     */
    public void showVA(Button button) {
        onScreen = states.get(5);
        windowUpdate();
        TextShape shape = new TextShape(4 * window.getGraphPanelWidth() / 10,
            window.getGraphPanelHeight() / 10,
            "VA Case Fatality Ratios by Race", Color.black);
        window.addShape(shape);

    }


    /**
     * Quits the window and terminates the programs instance.
     * 
     * @param button
     *            Quit button.
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Sorts passed races depending on which file is selected ALPHAbetically.
     * 
     * @param button
     *            Sort Alphabetically.
     */
    public void sortByAlpha(Button button) {
        comparatorCheck = "ALPHA";
        windowUpdate();
        TextShape shape = new TextShape(4 * window.getGraphPanelWidth() / 10,
            window.getGraphPanelHeight() / 10,
            "Sorted This State Alphabetically", Color.black);
        window.addShape(shape);

    }


    /**
     * Sorts passed races in descending CFR values based on which file is
     * passed.
     * 
     * @param button
     *            Sort CFR values "0.0"
     */
    public void sortByCFR(Button button) {
        comparatorCheck = "CFR";
        windowUpdate();
        TextShape shape = new TextShape(4 * window.getGraphPanelWidth() / 10,
            window.getGraphPanelHeight() / 10, "Sorted This State By CFR Value",
            Color.black);
        window.addShape(shape);
    }


    /**
     * Private Helper method to update the GUI Window When buttons are pressed.
     * Checks Comparator value in order to properly start Update function
     * and then appropriately calculates where to add text and bars.
     * ALL PLOTTING CALCULATIONS ARE DONE FOR SET REGION OF 1000x700
     * 
     */
    private void windowUpdate() {
        if (onScreen != null) {
            // Update Starts with Sorting Races Based on User Selected Button.
            if (comparatorCheck.equals("CFR")) {
                onScreen.cfrSortMethod();
            }
            else {
                onScreen.alphaSortMethod();
            }
            window.removeAllShapes();
            LinkedList<Race> races = onScreen.getRaces();
            Iterator<Race> iterator = races.iterator();

            // Positions of where everything is:
            // These are purely for looks purposes, the calculations make the
            // GUI window of 1000 x 700 Look Better, though the calculations
            // themselves can be switched to user preference and are NOT
            // the same for other window sizes.
            int startingXGRID = window.getGraphPanelWidth() / 10;
            int textHeight = 8 * window.getGraphPanelHeight() / 10;
            int cfrHeight = 9 * window.getGraphPanelHeight() / 10;
            int currentXGRID = startingXGRID;

            // Add bar shape and The Text on Screen.
            // Iterate through list calculating as it goes.
            while (iterator.hasNext()) {
                Race iteratedRace = iterator.next();
                double cfr = iteratedRace.getCFR();

                // Races and their respective Locations.
                TextShape raceShape = new TextShape(currentXGRID - 10,
                    textHeight, iteratedRace.getName(), Color.black);
                window.addShape(raceShape);

                if (cfr != -1) {
                    // Scales CFR to window size and plots
                    int cfrBarValue = (int)(cfr * 25);
                    Shape bar = new Shape(currentXGRID, 450 - cfrBarValue, 15,
                        cfrBarValue, Color.blue);
                    window.addShape(bar);

                    String stringCFR = String.valueOf(iteratedRace.getCFR());
                    // Converting GetCFR method from Double to String to be used
                    // in a TextShape.
                    TextShape shapeCFR = new TextShape(currentXGRID - 10,
                        cfrHeight, stringCFR + '%', Color.black);
                    window.addShape(shapeCFR);

                }
                else {
                    // Add NA text
                    TextShape shapeNA = new TextShape(currentXGRID - 5,
                        textHeight - 40, "NA", Color.black);
                    window.addShape(shapeNA);
                }

                // Allows the bars to be spaced out by an Interval of 5 Units.
                currentXGRID = currentXGRID + (window.getGraphPanelWidth() / 5);

            }

        }

    }
}
