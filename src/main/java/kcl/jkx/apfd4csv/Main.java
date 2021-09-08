package kcl.jkx.apfd4csv;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("The arguments should be the path to detection details and test cases sequence!");
        }
        else {
            CSVParser parser = new CSVParser();
            parser.detectionReader(args[0]);
            parser.sequenceReader(args[1]);
            APFDCalculator calculator = new APFDCalculator(parser.getFl(), parser.getSs());
            System.out.println(calculator.calculate());
        }
    }
}
