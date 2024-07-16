package TddPracticeInJava;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

    private final StringCalculator objUnderTest = new StringCalculator();

    @Test
    public void ExpectZeroForEmptyInput() {
        assertEquals(0, objUnderTest.add(""));
    }

    @Test
    public void ExpectZeroForSingleZero() {
        assertEquals(0, objUnderTest.add("0"));
    }

    @Test
    public void ExpectSumForTwoNumbers() {
        assertEquals(3, objUnderTest.add("1,2"));
    }

    @Test
    public void ExpectSumWithNewlineDelimiter() {
        assertEquals(6, objUnderTest.add("1\n2,3"));
    }

    @Test
    public void ignoreNumbersGreaterThan1000() {
        assertEquals(1, objUnderTest.add("1,1001"));
    }

    @Test
    public void ExpectSumWithCustomDelimiter() {
        assertEquals(3, objUnderTest.add("//;\n1;2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionForNegativeNumbers() {
        objUnderTest.add("1,-2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionForMultipleNegativeNumbers() {
        objUnderTest.add("-1,-2");
    }

    @Test
    public void ignoreNumbersGreaterThan1000InCustomDelimiter() {
        assertEquals(3, objUnderTest.add("//;\n2;1001;1"));
    }
}
