package com.bulkbuy.enterprise.controller;
import com.bulkbuy.enterprise.dto.Bulk_Order;
import com.bulkbuy.enterprise.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

    Logger log = LoggerFactory.getLogger((this.getClass()));
    @Autowired
    IOrderService orderService;

    /**
     * Endpoint control handler
     * @return
     */

    @GetMapping("/index")
    public String getIndex(Model model){
        log.debug("Index endpoint reached");
        model.addAttribute("activePage", "index");
        return "index";
    }

    @GetMapping("/about")
    public String getAbout(Model model){
        log.debug("About endpoint reached");
        model.addAttribute("activePage", "about");
        return "about";
    }

    @GetMapping("/placeOrder")
    public String getPlaceOrder(Model model){
        log.debug("Place order endpoint reached");
        Bulk_Order order = new Bulk_Order();
        model.addAttribute("activePage", "placeOrder");
        model.addAttribute(order);
        return "placeOrder";
    }


    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("order") Bulk_Order order, BindingResult result, ModelMap model) throws Exception {

        log.debug("Save order endpoint reached");

        try {
            if(result.hasErrors())
            {
                throw new Exception("Form returned with error");
            }
            Bulk_Order newOrder = orderService.create(order);
            log.info("New order created successfully");
        }
        catch (Exception ex)
        {
            log.error("failed to save order", ex);
            throw ex;
        }

        return "index";
    }

    @RequestMapping(value = "/orderLookup/{id}", method = RequestMethod.POST)
    public Bulk_Order orderLookup(@PathVariable("id") int id) {

        Bulk_Order order = new Bulk_Order();

        try {
            order = orderService.findByOrderId(id);
        } catch (Exception ex) {
            log.error("Error when trying to retrieve order", ex);
        }

        if(order.getOrderId() != id) {
            log.info("Order of id " + id + " was not found");
        }

        return order;
    }

}
