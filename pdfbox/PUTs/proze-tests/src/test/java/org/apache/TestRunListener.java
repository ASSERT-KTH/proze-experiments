package org.apache;

import com.google.auto.service.AutoService;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@AutoService(TestExecutionListener.class)
public class TestRunListener implements TestExecutionListener {

    private PrintWriter csvWriter;
    private boolean currentState = true;
    private String currentTestName = "";

    public TestRunListener() {
        try {
            csvWriter = new PrintWriter(new FileWriter("test-results-new1.csv", true));
            csvWriter.println("result" + "," + "test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        // Get the test name to check if the test changed, we need this for the second column
        String testName = testIdentifier.getDisplayName();
        // Here, the problem is sometimes the test name is the parameter itself, so we check for (
        if (testIdentifier.getDisplayName().contains("TestProzeGen")) {
            return;
        }
        if (testIdentifier.getDisplayName().contains("(")) {
            testName = testName.substring(0, testName.indexOf("("));
            // Check if this is the same test or a new test, if changed then we will change the color.
            if (!testName.equals(currentTestName)) {
                currentTestName = testName;
                currentState = !currentState;
            }
        } else {
            String result = testExecutionResult.getStatus() == TestExecutionResult.Status.SUCCESSFUL ? "1" : "0";
            String secondColumn = currentState ? "1" : "0";
            csvWriter.println(result + "," + secondColumn);
        }
    }

    public void close() {
        csvWriter.close();
    }
}
