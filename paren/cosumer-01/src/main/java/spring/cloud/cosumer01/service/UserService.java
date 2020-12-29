package spring.cloud.cosumer01.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author ruicai.li@hand-china.com
 */
public class UserService extends HystrixCommand {
    protected UserService(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Object run() throws Exception {
        return null;
    }
}
