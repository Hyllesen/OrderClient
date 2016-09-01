/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stefan
 */
public class OrderWebServiceTest {
    
    String testCustomer = "Jens Test";
    String testProductId = "1";
    String testProductName = "Sko";
    int testProductAmount = 50;
    String testIsPaid = "Not yet paid";
    
    public OrderWebServiceTest() {
    }
    /**
     * orderProduct takes an order number (string), customer name (string), an
        amount (integer), and a product (string) and returns the order number as
        a string
     */
    @Test
    public void orderProductTest() {
        String result = orderProduct(testProductId, testCustomer, testProductAmount, testProductName);
        assertEquals(testProductId, result);
    }
    
    /**
     * getOrderInfo takes as argument an order number and returns a string with the
        information of the order, e.g., ”Order number 2: Customer Peter has ordered
        10 pencil. Is paid” for an order made with order number 2 by customer Peter
        who has ordered 10 amount of product ”pencil” and where payment was okay.
        If the order is not yet paid, then ”Not yet paid” should be returned instead of
        ”Is paid”
     * @param orderNumber
     * @param customerName
     * @param amount
     * @param productName
     * @return 
     */
    @Test
    public void getOrderInfoTest() {
        String result = getOrderInfo(testProductId);
        assertEquals("Order number " + testProductId + ": Customer " + testCustomer + " has ordered " + testProductAmount + " " + testProductName + ". " + testIsPaid, result);  
    }

    private static String orderProduct(java.lang.String orderNumber, java.lang.String customerName, int amount, java.lang.String productName) {
        dk.dtu.OrderWebService_Service service = new dk.dtu.OrderWebService_Service();
        dk.dtu.OrderWebService port = service.getOrderWebServicePort();
        return port.orderProduct(orderNumber, customerName, amount, productName);
    }

    private static void payOrder(java.lang.String ccNumber, java.lang.String orderNumber) {
        dk.dtu.OrderWebService_Service service = new dk.dtu.OrderWebService_Service();
        dk.dtu.OrderWebService port = service.getOrderWebServicePort();
        port.payOrder(ccNumber, orderNumber);
    }

    private static String getOrderInfo(java.lang.String orderNumber) {
        dk.dtu.OrderWebService_Service service = new dk.dtu.OrderWebService_Service();
        dk.dtu.OrderWebService port = service.getOrderWebServicePort();
        return port.getOrderInfo(orderNumber);
    }
    
}
