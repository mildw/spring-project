package com.mildw.minsu.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mildw.minsu.controller.advice.Error;
import com.mildw.minsu.controller.advice.ErrorResponse;
import com.mildw.minsu.util.RequestUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MinsuAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        final Error error = getAuthenticationError(exception);
        response.setStatus(error.getHttpStatus().value());

        // JSON RESPONSE
        if (RequestUtils.acceptJson(request)) {

            ErrorResponse errorResponse = ErrorResponse.of(error);
            ObjectMapper objectMapper = new ObjectMapper();
            final String jsonString = objectMapper.writeValueAsString(errorResponse);

            PrintWriter writer = response.getWriter();
            writer.print(jsonString);
            writer.flush();
            writer.close();
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }

    private Error getAuthenticationError(AuthenticationException exception) {
        if(exception instanceof BadCredentialsException) {
            return Error.BAD_CREDENTIALS;
        }
        return Error.INTERNAL_AUTHENTICATION_SERVICE_EXCEPTION;
    }

}
