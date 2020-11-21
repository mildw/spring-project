package com.mildw.minsu.security;

import com.mildw.minsu.util.RequestUtils;
import lombok.Getter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Getter
public class MinsuAuthenticationDetails extends WebAuthenticationDetails implements Serializable {

    private static final long serialVersionUID = -299L;

    private final String remoteAddress;
    private final String sessionId;

    public MinsuAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.remoteAddress = RequestUtils.getRemoteIP(request);
        this.sessionId = request.getSession().getId();
    }

}
