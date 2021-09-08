package kcl.jkx.apfd4csv;

import java.util.LinkedList;
import java.util.List;

public class TestCase {
    private String id;
    private List detectedFault;
    private boolean status;

    TestCase() {
        this.id = null;
        this.detectedFault = new LinkedList<String>();
        this.status = true;
    }

    TestCase(String detail, List fl) {
        this();
        String[] details = detail.split(",");
        int length = details.length;
        if (length == 0) {
            status = false;
        }
        else {
            this.id = details[0];
            for (int i = 1; i < length; i++) {
                if ("1".equals(details[i])) {
                    detectedFault.add(fl.get(i - 1));
                }
            }
        }
    }

    public boolean getStatus() {
        return status;
    }

    public List getDetectedFault() {
        return detectedFault;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "id='" + id + '\'' +
                ", detectedFault=" + detectedFault +
                '}';
    }
}
