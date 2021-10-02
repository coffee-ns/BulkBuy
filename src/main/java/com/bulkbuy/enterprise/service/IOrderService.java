package com.bulkbuy.enterprise.service;

import com.bulkbuy.enterprise.dto.Order;

import java.util.List;

/**
 * Interface, takes care of logic for Orders.
 */
public interface IOrderService {

    /**
     * Creates an order and inserts it into the List
     * @param order The order to be created
     */
    void Create(Order order);

    /**
     * Finds an order by its orderId attribute
     * @param id the id to look for
     * @return the order with the specified id. If the order does not exist, returns null.
     */
    Order findByOrderId(int id);

    /**
     * Returns all orders in a List
     * @return a list of all orders collected
     */
    List<Order> getAllOrders();
}
