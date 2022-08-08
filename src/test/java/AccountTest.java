import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void correctNameTest() {
        Account account = new Account("John Smith");
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Test
    public void nameWitoutSpacesIsIncorrectTest() {
        Account account = new Account("JohnSmith");
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    public void nameWithSpaceAsFirstSymbolIsIncorrectTest() {
        Account account = new Account(" JohnSmith");
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    public void nameWithSpaceAsLastSymbolIsIncorrectTest() {
        Account account = new Account("JohnSmith ");
        Assert.assertEquals(account.checkNameToEmboss(), false);
    }

    @Test
    public void nameWithTwoUnitedSpacesIsIncorrectTest() {
        Account account = new Account("John  Smith");
        Assert.assertEquals(account.checkNameToEmboss(), false);
    }

    @Test
    public void nameWithTwoSpacesIsIncorrectTest() {
        Account account = new Account("John Smi th");
        Assert.assertEquals(account.checkNameToEmboss(), false);
    }

    @Test
    public void nameTwoSymbolsLongIsIncorrectTest() {
        Account account = new Account("JS");
        Assert.assertEquals(account.checkNameToEmboss(), false);
    }

    @Test
    public void nameThreeSymbolsLongIsCorrectTest() {
        Account account = new Account("J S");
        Assert.assertEquals(account.checkNameToEmboss(), true);
    }

    @Test
    public void nameFourSymbolsLongIsCorrectTest() {
        Account account = new Account("Jh S");
        Assert.assertEquals(account.checkNameToEmboss(), true);
    }

    @Test
    public void nameEighteenSymbolsLongIsCorrectTest() {
        Account account = new Account("1234 6789012345678");
        Assert.assertEquals(account.checkNameToEmboss(), true);
    }

    @Test
    public void nameNineteenSymbolsLongIsCorrectTest() {
        Account account = new Account("1234 67890123456789");
        Assert.assertEquals(account.checkNameToEmboss(), true);
    }

    @Test
    public void nameTwentySymbolsLongIsCorrectTest() {
        Account account = new Account("1234 678901234567890");
        Assert.assertEquals(account.checkNameToEmboss(), false);
    }
}
