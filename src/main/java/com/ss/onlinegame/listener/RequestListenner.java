package com.ss.onlinegame.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class RequestListenner implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre)  {
        //将所有request请求都携带上httpSession
        HttpSession session = ((HttpServletRequest) sre.getServletRequest()).getSession();
    }
    public RequestListenner() {}

    @Override
    public void requestDestroyed(ServletRequestEvent arg0)  {}
}
