
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.issueCard("Pariwesh",CreditType.Emerald);
        bank.issueCard("Geetika",CreditType.Infenium);
        System.out.println(bank.cards);
    }
}