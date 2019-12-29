package com.sso.bean;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by Brian in 1:32 2018/12/12
 */
public class SessionContainer {
    public static HashMap<String, HttpSession> SESSION_MAP = new HashMap<>();
}
