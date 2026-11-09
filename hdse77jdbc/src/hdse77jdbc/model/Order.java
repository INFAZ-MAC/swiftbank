package hdse77jdbc.model;

import java.util.Date;
import java.util.List;

public class Order{
    private String orderId;
    private String customerId;
    private Date date;
    private List<OrderDetials>orderDetialList;

    public Order() {
    }

    public Order(String orderId, String customerId, Date date, List<OrderDetials> orderDetialList) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.orderDetialList = orderDetialList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderDetials> getOrderDetialList() {
        return orderDetialList;
    }

    public void setOrderDetialList(List<OrderDetials> orderDetialList) {
        this.orderDetialList = orderDetialList;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", date=" + date + ", orderDetialList=" + orderDetialList + '}';
    }
    
    
}