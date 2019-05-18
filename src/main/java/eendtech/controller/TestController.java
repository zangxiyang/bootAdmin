package eendtech.controller;

import eendtech.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/5/10 22:02
 */
@Controller

@RequestMapping("/test")
public class TestController {
    @Autowired
    CustomerService customerService;


}
