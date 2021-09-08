package kcl.jkx.apfd4csv;

import java.util.LinkedList;
import java.util.List;

public class FaultList {

    private List fl;

    public FaultList(String detail) {
        fl = new LinkedList<String>();
        if (parseDetail(detail) == false) {
            fl = null;
        }
    }

    private boolean parseDetail(String detail) {
        boolean flag = true;

        String[] faults = detail.split(",");
        int length = faults.length;
        if (length == 0 || length == 1) {
            flag = false;
        }
        else {
            for (int i = 1; i < length; i++) {
                fl.add(faults[i] + "_" + i);
            }
        }

        return flag;
    }

    public List getFl() {
        return fl;
    }
}
