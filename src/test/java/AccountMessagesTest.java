import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AccountMessagesTest {

    private ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
    private PrintStream old;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(testOutput));
        old = System.out;
    }

    @After
    public void cleanUpStreams() {
        System.out.flush();
        System.setOut(old);
    }

    @Test
    public void nameCorrectNoMessageTest() {
        Account account = new Account("John Smith");
        boolean res = account.checkNameToEmboss();
        Assert.assertEquals("",
                testOutput.toString());
    }

    @Test
    public void nameWitoutSpacesMessageTest() {
        Account account = new Account("JohnSmith");
        boolean res = account.checkNameToEmboss();
        MatcherAssert.assertThat(testOutput.toString(),
                CoreMatchers.containsString("There must be at least one space in the string"));
    }

    @Test
    public void nameWithSpaceAsFirstSymbolMessageTest() {
        Account account = new Account(" JohnSmith");
        boolean res = account.checkNameToEmboss();
        MatcherAssert.assertThat(testOutput.toString(),
                CoreMatchers.containsString("There must be no space in the start of the string"));
    }

    @Test
    public void nameWithSpaceAsLastSymbolMessageTest() {
        Account account = new Account("JohnSmith ");
        boolean res = account.checkNameToEmboss();
        MatcherAssert.assertThat(testOutput.toString(),
                CoreMatchers.containsString("There must be no space in the end of the string"));
    }

    @Test
    public void nameWithTwoUnitedSpacesIsIncorrectTest() {
        Account account = new Account("John  Smith");
        boolean res = account.checkNameToEmboss();
        MatcherAssert.assertThat(testOutput.toString(),
                CoreMatchers.containsString("There can't be more than one space in the string"));
    }

    @Test
    public void nameWithTwoSpacesMessageTest() {
        Account account = new Account("John Smi th");
        boolean res = account.checkNameToEmboss();
        MatcherAssert.assertThat(testOutput.toString(),
                CoreMatchers.containsString
                        ("There can't be more than one space in the string"));
    }

    @Test
    public void nameTwoSymbolsLongMessageTest() {
        Account account = new Account("JS");
        boolean res = account.checkNameToEmboss();
        MatcherAssert.assertThat(testOutput.toString(), CoreMatchers.containsString("There must be more that 3 symbols in the string"));
    }

    @Test
    public void nameThreeSymbolsLongMessageTest() {
        Account account = new Account("J S");
        boolean res = account.checkNameToEmboss();
        Assert.assertEquals("",
                testOutput.toString());
    }

    @Test
    public void nameFourSymbolsLongMessageTest() {
        Account account = new Account("Jh S");
        boolean res = account.checkNameToEmboss();
        Assert.assertEquals("",
                testOutput.toString());
    }

    @Test
    public void nameEighteenSymbolsLongMessageTest() {
        Account account = new Account("1234 6789012345678");
        boolean res = account.checkNameToEmboss();
        Assert.assertEquals("",
                testOutput.toString());
    }

    @Test
    public void nameNineteenSymbolsLongMessageTest() {
        Account account = new Account("1234 67890123456789");
        boolean res = account.checkNameToEmboss();
        Assert.assertEquals("",
                testOutput.toString());
    }

    @Test
    public void nameTwentySymbolsLongMessageTest() {
        Account account = new Account("1234 678901234567890");
        boolean res = account.checkNameToEmboss();
        MatcherAssert.assertThat(testOutput.toString(), CoreMatchers.containsString
                ("There must be less that 19 symbols in the string"));
    }
}
