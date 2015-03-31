package testlink.models;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class TestCase {
    public String name;// = "New test case5";// + System.currentTimeMillis();
    public String details;// = "Some details";
    public String preconditions;// = "Some preconditions";

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPreconditions(String preconditions) {
        this.preconditions = preconditions;
    }
}
