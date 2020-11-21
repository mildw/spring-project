package com.mildw.minsu.util;

import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;

@UtilityClass
public class RequestUtils {
    private final String AJAX_HEADER_KEY = "X-Requested-With";
    private final String AJAX_HEADER_VALUE = "XMLHttpRequest";
    private final String X_FORWARDED_HOST = "X-Forwarded-Host";
    private final String X_FORWARDED_PROTOCOL = "X-Forwarded-Proto";
    private final String URL_LINK = "://";
    private final String PROXY_IP_SEPARATOR = ",";

    public boolean startWithAPI(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/api");
    }

    public boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader(AJAX_HEADER_KEY) != null
                && request.getHeader(AJAX_HEADER_KEY).equalsIgnoreCase(AJAX_HEADER_VALUE));
    }


    public boolean acceptJson(HttpServletRequest request) {
        final String accept = request.getHeader("accept");
        return accept != null && accept.contains("json");
    }

    public String getServerURL(HttpServletRequest request) {
        String host = request.getHeader(X_FORWARDED_HOST);
        if (host == null)
            return "http://" + request.getServerName() + ":" +request.getServerPort();

        String protocol = request.getHeader(X_FORWARDED_PROTOCOL);
        return protocol + URL_LINK + host;
    }

    // 여기도 공부좀
    public String getRemoteIP(HttpServletRequest request) {
        String ip = request.getHeader("X-FORWARDED-FOR");

        //proxy 환경일 경우
        if (ip == null || ip.length() ==0) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        //웹로직 서버일 경우
        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0) {
            ip = request.getRemoteAddr();
        }

        if (ip.contains(PROXY_IP_SEPARATOR)) {
            return ip.split(PROXY_IP_SEPARATOR)[0];
        }
        return ip;
    }

}