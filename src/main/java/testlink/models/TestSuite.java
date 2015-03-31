package testlink.models;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class TestSuite {

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }



    public String name;// = "New test suite5";// + System.currentTimeMillis();
    public String details;// = "Some details";

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String textAfterCreation = "Test Suite created";
}


