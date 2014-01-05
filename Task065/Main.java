package  Task065;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    private Scanner mInput;
    private PrintWriter mOutput;


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
        String sentMessage = mInput.nextLine();

        int n = mInput.nextInt();
        mInput.nextLine();

        int minDiff = Integer.MAX_VALUE;

        //key - diff, value - list of indices
        Map map = new HashMap< Integer, Collection>();
        for (int i = 0; i < n; ++i) {
            String possibleMessage = mInput.nextLine();
            int currentDiff = 0;
            for (int j = 0; j < possibleMessage.length(); ++j) {
                if (sentMessage.charAt(j) != possibleMessage.charAt(j)) {
                    ++currentDiff;
                }
                if (currentDiff > minDiff) {
                    break;
                }
            }
            if (currentDiff <= minDiff) {
                minDiff = currentDiff;
                List indices = (List)map.get(new Integer(currentDiff));
                if (indices == null) {
                    indices = new LinkedList<Integer>();
                    indices.add(i + 1);
                    map.put(currentDiff, indices);
                }
                else {
                    indices.add(i + 1);
                }
            }
        }
        List indices = (List)map.get(new Integer(minDiff));
        // n is 0
        if (indices == null) {
            mOutput.println(0);
        }
        else {
            int size = indices.size();
            mOutput.println(size);
            for (int i = 0; i < size; ++i) {
                mOutput.print(indices.get(i));
                mOutput.print(' ');
            }
        }
    }
}