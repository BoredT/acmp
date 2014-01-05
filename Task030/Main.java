package  Task030;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    private Scanner mInput;
    private PrintWriter mOutput;

    private static final int NUMBER_OF_DIGITS = 10;
    int[] mDigitCount = new int[NUMBER_OF_DIGITS];
    private int mHours;
    private int mMinutes;
    private int mSeconds;


    public static void main(String [] args) {
        new Main().run();
    }

    public void run() {
        try {
            openFiles();
            solveTask();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        finally  {
            if (mInput != null) {
                mInput.close();
            }
            if (mOutput != null) {
                mOutput.close();
            }
        }

    }

    public void openFiles() throws FileNotFoundException {
        mInput = new Scanner(new File("input.txt"));
        mOutput = new PrintWriter(new File("output.txt"));
    }

    public void solveTask() {
        String startingTime = mInput.nextLine();
        String endingTime = mInput.nextLine();

        mHours = Integer.valueOf(startingTime.substring(0, 2));
        mMinutes = Integer.valueOf(startingTime.substring(3, 5));
        mSeconds = Integer.valueOf(startingTime.substring(6, 8));

        int endingHours = Integer.valueOf(endingTime.substring(0, 2));
        int endingMinutes = Integer.valueOf(endingTime.substring(3, 5));
        int endingSeconds = Integer.valueOf(endingTime.substring(6, 8));
        calc();

        while(mHours != endingHours || mMinutes != endingMinutes || mSeconds != endingSeconds) {
            incTime();
            calc();
        }

        for (int i = 0; i < NUMBER_OF_DIGITS; ++i) {
            mOutput.println(mDigitCount[i]);
        }
    }

    public void calc() {
        ++mDigitCount[mHours / 10];
        ++mDigitCount[mHours % 10];
        ++mDigitCount[mMinutes / 10];
        ++mDigitCount[mMinutes % 10];
        ++mDigitCount[mSeconds / 10];
        ++mDigitCount[mSeconds % 10];
    }

    public void incTime() {
        ++mSeconds;
        if (mSeconds == 60) {
            mSeconds = 0;
            ++mMinutes;
        }
        if (mMinutes == 60) {
            mMinutes = 0;
            ++mHours;
        }
        if (mHours == 24) {
            mHours = 0;
        }
    }
}