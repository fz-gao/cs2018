/*
package cn.fvti.cs2018.ws.web.interceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
*/
/**
 * Created by gsd on 2018/12/12.
 *//*

@Configuration
@Slf4j
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Resource(name = "localTokenManager")
    private TokenManager tokenManager;

    @Resource(name = "appTokenManager")
    private TokenManager appTokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("request url : {}", request.getRequestURI());

        if(this.checkMobile(request)) {
            return mobilePreHandle(request);
        }
        else {
            return webPreHandle(request);
        }
    }


    public boolean isLogin(HttpServletRequest request, String token) {
        SessionBean sb = null;
        if(this.checkMobile(request)) {
            sb = appTokenManager.validate(token);

        }
        else {
            token = CookieUtils.getCookie(request, TokenManager.TOKEN);
            sb = tokenManager.validate(token);
        }
        if (Strings.isNullOrEmpty(token) || sb == null) {
            return false;
        }

        return true;
    }
    private boolean mobilePreHandle(HttpServletRequest request) {
        String token = request.getHeader("token");
        SessionBean sb = appTokenManager.validate(token);
        if (Strings.isNullOrEmpty(token) || sb == null) {
            throw new BusinessException("token错误，无法访问", 401);
        }
        String requestURI = request.getRequestURI();
        if(!sb.getResourceObj().contains(requestURI)) {
            log.info("没有权限访问:{}", requestURI);
            throw new BusinessException("你没有访问权限", 403);
        }
        return true;
    }

    private boolean webPreHandle(HttpServletRequest request) {
        String token = CookieUtils.getCookie(request, TokenManager.TOKEN);
        SessionBean sb = tokenManager.validate(token);

        if (Strings.isNullOrEmpty(token) || sb == null) {
            throw new BusinessException("请重新登陆", 401);
        }

        //如果是管理员
        if(sb.getRoles()!=null && sb.getRoles().contains(Constant.ADMIN_ROLE)) {
            return true;
        }

        String requestURI = request.getRequestURI();
        if(!sb.getResourceObj().contains(requestURI)) {
            throw new BusinessException("你没有访问权限", 403);
        }
        return true;
    }

    public String getOpenApiRequestData(HttpServletRequest request){
        try {

            int contentLength = request.getContentLength();
            if (contentLength < 0) {
                return null;
            }
            byte buffer[] = new byte[contentLength];
            for (int i = 0; i < contentLength;) {

                int readlen = request.getInputStream().read(buffer, i, contentLength - i);
                if (readlen == -1) {
                    break;
                }
                i += readlen;
            }

            String charEncoding = request.getCharacterEncoding();
            if (charEncoding == null) {
                charEncoding = "UTF-8";
            }
            return new String(buffer, charEncoding);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean checkMobile(HttpServletRequest request) {
        boolean isFromMobile;
        String userAgent = request.getHeader( "USER-AGENT" ).toLowerCase();
        if(null == userAgent){
            userAgent = "";
        }
        isFromMobile=CheckMobile.check(userAgent);
        return isFromMobile;
    }
}
*/
