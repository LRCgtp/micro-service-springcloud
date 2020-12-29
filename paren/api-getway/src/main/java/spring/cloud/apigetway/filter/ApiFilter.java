package spring.cloud.apigetway.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author ruicai.li@hand-china.com
 */
public class ApiFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("Token");
        if (null ==token || !token.equals("123456")){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            currentContext.setResponseBody("any permission been matches of you");
            return null;
        }
        //currentContext.setSendZuulResponse(true);
       //currentContext.setResponseStatusCode(200);
        //currentContext.setResponseBody("认证ok");
        return null;
    }
}
