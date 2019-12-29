package com.sso.controller;

import com.sso.bean.SessionContainer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Brian in 1:29 2018/12/12
 */
@Controller
public class LogController {

    @RequestMapping("/login")
    public String login() {

        return "sso/success";
    }

    @RequestMapping("/demo")
    public String demo() {

        return "sso/demo";
    }

    @RequestMapping("/tologout")
    @ResponseBody
    public String tologout(String jsessionid){
        if(!StringUtils.isAllEmpty(jsessionid)){
            HttpSession session = SessionContainer.SESSION_MAP.get(jsessionid);

            if(session !=null){
                session.invalidate();
                return "true";
            }
        }
        return "false";
    }
}
