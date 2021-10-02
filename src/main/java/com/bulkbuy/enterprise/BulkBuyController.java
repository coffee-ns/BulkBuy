package com.bulkbuy.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BulkBuyController {

    /**
     * Endpoint control handler
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

}