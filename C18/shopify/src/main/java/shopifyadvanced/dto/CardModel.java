package shopifyadvanced.dto;

public class CardModel {

    private String cardName;
    private String cardNumber;
    private int securityCode;


    public CardModel() {
    }

    public String getCardName() {
        return cardName;
    }

    public CardModel setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CardModel setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public CardModel setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
        return this;
    }
}
