package be.abis.exercise.test;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.engine.discovery.ClassSelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class ManualSuiteRunner {
    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectClass(MyTestSuite.class))
                .build();

        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(new TestExecutionListener() {
            @Override
            public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
                System.out.println(">> Finished: " + testIdentifier.getDisplayName() + " - " + testExecutionResult.getStatus());
            }
        });

        launcher.execute(request);
    }
}

