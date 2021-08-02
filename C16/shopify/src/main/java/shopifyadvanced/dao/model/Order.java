package shopifyadvanced.dao.model;


import shopifyadvanced.dto.CardModel;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date orderDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private int customerId;

    @Transient
    private String cardName;
    @Transient
    private String cardNumber;
    @Transient
    private int securityCode;


    public String getCardName() {
        return cardName;
    }

    public Order setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Order setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public Order setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    public Order() {}





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) { this.shippedDate = shippedDate; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", orderDate='").append(orderDate).append('\'');
        sb.append(", shippedDate='").append(shippedDate).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", comments='").append(comments).append('\'');
        sb.append(", customerId=").append(customerId);
        sb.append('}');
        return sb.toString();
    }
}
