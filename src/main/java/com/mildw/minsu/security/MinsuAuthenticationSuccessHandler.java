package com.mildw.minsu.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.mildw.minsu.dao.AccountRepository;
import com.mildw.minsu.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class MinsuAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        String redirectUrl = null;
        if (savedRequest != null) {
            redirectUrl = savedRequest.getRedirectUrl();
            try {
                URI uri = new URI(redirectUrl);
                String path = uri.getPath();
                final String serverAddress = RequestUtils.getServerURL(request);
                redirectUrl = serverAddress + path;
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        // JSON RESPONSE
        if (RequestUtils.acceptJson(request)) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            HashMap<String, Object> resultMap = Maps.newHashMap();
            resultMap.put("status", HttpStatus.OK.value());
            resultMap.put("redirect", redirectUrl);

            ObjectMapper objectMapper = new ObjectMapper();
            final String jsonString = objectMapper.writeValueAsString(resultMap);

            PrintWriter writer = response.getWriter();  // 이건뭔데 writer야?
            writer.print(jsonString);
            writer.flush();
            writer.close();

            clearAuthenticationAttributes(request); // 이건뭐야?
        } else {
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;
                authenticationToken.setDetails(new MinsuAuthenticationDetails(request));
            }
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}
