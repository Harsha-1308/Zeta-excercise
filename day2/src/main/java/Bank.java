import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<ICreditCard> cards = new ArrayList<>();
    ICreditCard issueCard(String customerName,CreditType type) {
        //check for blank
        ICreditCard card = null;
        switch (type){
            case Emerald -> {
                card= new EmeraldCredCard(customerName);
            }
            case Platinum -> {
            }
            case Infenium -> {
                card= new Inferium(customerName);
            }
        }
        cards.add(card);
        return card;
    }
}