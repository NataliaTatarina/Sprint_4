public class Praktikum {

    public static void main(String[] args) throws Exception {
        /*
             В этом методе заложи логику работы с классом Account.
             Нужно создать экземпляр класса Account: в качестве аргумента передать тестируемое имя
             и вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
         */
        String name = "1121 355556 56";
        Account account = new Account(name);
        if (account.checkNameToEmboss()) {
            System.out.println("Your name \"" + name + "\" can be printed on card");
        } else {
            System.out.println("Sorry. Your name \"" + name + "\" can not be printed on card");
        }
    }
}