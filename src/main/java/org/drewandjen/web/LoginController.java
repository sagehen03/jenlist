package org.drewandjen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dhite on 3/19/16.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
