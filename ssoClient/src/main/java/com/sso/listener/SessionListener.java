package com.sso.listener;

import com.sso.bean.SessionContainer;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Brian in 1:31 2018/12/12
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        SessionContainer.SESSION_MAP.put(session.getId(), session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
