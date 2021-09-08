package kcl.jkx.apfd4csv;

import java.util.LinkedList;
import java.util.List;

public class TestSuite {

    private List fl;
    private List tcs;
    private List ss;

    TestSuite(List fl) {
        this.fl = fl;
        this.tcs = new LinkedList<TestCase>();
        this.ss = new LinkedList<LinkedList<TestCase>>();
    }

    public boolean addTestCase(String detail) {
        boolean result = true;
        TestCase tc = new TestCase(detail, fl);
        //check whether test case information parsed successfully
        if (tc.getStatus()) {
            tcs.add(tc);
        }
        else {
            result = false;
        }
        return result;
    }

    public List getSequencedTestSuite(String sequence) {
        List sequencedTestSuite = new LinkedList<TestCase>();
        if (tcs != null) {
            String[] s = sequence.split(",");
            for (int i = 0; i < s.length; i++) {
                int tmp = Integer.valueOf(s[i]);
                if (tmp <= 0 || tmp > tcs.size()) {
                    return null;
                }
                sequencedTestSuite.add(tcs.get(tmp - 1));
            }
        }
        if (sequencedTestSuite != null) {
            ss.add(sequencedTestSuite);
        }
        return sequencedTestSuite;
    }

    public List getSs() {
        return ss;
    }

    @Override
    public String toString() {
        return "TestSuite{" +
                "tcs=" + tcs +
                '}';
    }
}
