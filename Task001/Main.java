package Task001;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

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
        int a = mInput.nextInt(), b = mInput.nextInt();
        mOutput.print(a + b);
    }
}
