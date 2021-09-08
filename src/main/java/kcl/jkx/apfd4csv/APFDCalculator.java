package kcl.jkx.apfd4csv;

import java.util.LinkedList;
import java.util.List;

public class APFDCalculator {

    private List fl;
    private List<List<TestCase>> ss;

    public APFDCalculator(List fl, List ss) {
        this.fl = fl;
        this.ss = ss;
    }

    public List calculate() {
        List result = new LinkedList<String>();
        for (int i = 0; i < ss.size(); i++) {
            String tmp = calculateIndividual(ss.get(i));
            result.add(tmp);
        }
        return result;
    }

    private String calculateIndividual(List sequence) {
        int totalPosition = totalPosistion(sequence);
        float result = 1 - totalPosition / Float.valueOf(sequence.size() * fl.size()) + 1 / Float.valueOf(2 * sequence.size());
        return String.valueOf(result);
    }

    private int totalPosistion(List<TestCase> sequence) {
        int result = 0;
        int size = fl.size();
        for (int i = 0; i < size; i++) {
            String fault = fl.get(i).toString();
            for (int j = 0; j < sequence.size(); j++) {
                if (detectable(fault, sequence.get(j))) {
                    result += (j + 1);
                    break;
                }
            }
        }
        return result;
    }

    private boolean detectable(String fault, TestCase tc) {
        boolean result = false;
        List list = tc.getDetectedFault();
        if (list.contains(fault)) {
            result = true;
        }
        return result;
    }

}
