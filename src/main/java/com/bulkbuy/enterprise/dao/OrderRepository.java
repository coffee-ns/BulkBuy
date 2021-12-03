package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Bulk_Order;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/***
 * Crud Repository responsible for providing various methods to interact with the database
 */

public interface OrderRepository extends CrudRepository<Bulk_Order, Integer> {


}
