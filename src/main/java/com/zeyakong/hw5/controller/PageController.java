package com.zeyakong.hw5.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Zeya Kong
 * On 4/5/2018 6:24 PM.
 */
@Controller
public class PageController {
    //return the static html file.
    @RequestMapping("/calculate")
    public String index() {
        return "index";
    }
}
