import kcl.jkx.apfd4csv.APFDCalculator;
import kcl.jkx.apfd4csv.CSVParser;
import org.junit.jupiter.api.Test;

public class Test1 {
    @Test
    public void testAPFDCalculator() {
        CSVParser parser = new CSVParser();
        parser.detectionReader("src/test/resources/Example.csv");
        parser.sequenceReader("src/test/resources/Sequence.csv");
        APFDCalculator calculator = new APFDCalculator(parser.getFl(), parser.getSs());
        System.out.println(calculator.calculate());
    }
}
