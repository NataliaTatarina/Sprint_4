public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        boolean checkResult = true;
        if (name.length() < 3) {
            System.out.println("There must be more that 3 symbols in the string");
            checkResult = false;
        }
        if (name.length() > 19) {
            System.out.println("There must be less that 19 symbols in the string");
            checkResult = false;
        }
        if (name.startsWith(" ")) {
            System.out.println("There must be no space in the start of the string");
            checkResult = false;
        }
        if (name.endsWith(" ")) {
            System.out.println("There must be no space in the end of the string");
            checkResult = false;
        }
        if (name.replace(" ", "").length() > name.length() - 1) {
            System.out.println("There must be at least one space in the string");
            checkResult = false;
        }
        if (name.replace(" ", "").length() < name.length() - 1) {
            System.out.println("There can't be more than one space in the string");
            checkResult = false;
        }
        return checkResult;
    }
}