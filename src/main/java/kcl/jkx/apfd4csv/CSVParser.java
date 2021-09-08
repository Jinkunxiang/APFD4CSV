package kcl.jkx.apfd4csv;

import java.io.*;
import java.util.List;

public class CSVParser {

    private List fl;
    private TestSuite ts;
    //Sequences
    private List ss;

    public CSVParser() {
        this.fl = null;
        this.ts = null;
        this.ss = null;
    }

    public int detectionReader(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.err.println("The input file path is invalid!");
            return 1;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int count = 0;
            String tmp;
            while ((tmp = br.readLine()) != null) {
                count ++;
                if (count == 1) {
                    FaultList faultList = new FaultList(tmp);
                    if ((fl = faultList.getFl()) == null) {
                        System.err.println("Fault information is invalid!");
                        return 2;
                    }
                    else {
                        // ready for parsing test case information
                        ts = new TestSuite(fl);
                    }
                }
                else {
                    if (ts.addTestCase(tmp) == false) {
                        System.err.println("Test Case information is invalid");
                        return 3;
                    }
                }
            }
            if (count == 0) {
                System.err.println("Fault information is invalid!");
                return 2;
            }
            if (count == 1) {
                System.err.println("Test Case information is invalid");
                return 3;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int sequenceReader(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.err.println("The input file path is invalid!");
            return 1;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int count = 0;
            String tmp;
            while ((tmp = br.readLine()) != null) {
                count ++;
                if(ts.getSequencedTestSuite(tmp) == null) {
                    System.err.println("Input sequence is invalid!");
                    return 3;
                }
            }
            if (count == 0) {
                System.err.println("The input file is empty!");
                return 2;
            }
            if (ts.getSs().size() != 0) {
                ss = ts.getSs();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List getFl() {
        return fl;
    }

    public List getSs() {
        return ss;
    }
}
