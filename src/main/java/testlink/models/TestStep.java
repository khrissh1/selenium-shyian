package testlink.models;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class TestStep {

    public String stepAction;// = "New step action";// + System.currentTimeMillis();
    public String executionResult;// = "Some execution result";
    public String execution;// = "Manual";

    public String getStepAction() {
        return stepAction;
    }

    public String getExecutionResult() {
        return executionResult;
    }

    public String getExecution() {
        return execution;
    }

    public void setStepAction(String stepAction) {
        this.stepAction = stepAction;
    }

    public void setExecutionResult(String executionResult) {
        this.executionResult = executionResult;
    }

    public void setExecution(String execution) {
        this.execution = execution;
    }
}
