package io.pivotal.beach.tokyo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/*")
    public String index() {
        return "index";
    }

}
