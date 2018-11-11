package org.ys.core.shiro.filter;

import com.alibaba.dubbo.rpc.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ys.core.shiro.session.RemoteSessionService;


public class ShiroCustomFilter implements Filter {

    final static Logger logger = LoggerFactory.getLogger(ShiroCustomFilter.class);

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if(invoker.getInterface().equals(RemoteSessionService.class)){
            //去获取信息
        }else{
            //追加补充信息
            String sessionId = "";
            Subject subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                //判断是否登陆过
            }
            sessionId = subject.getSession().getId().toString();
            invocation.getAttachments().put("x-session-id", StringUtils.defaultString(sessionId));
        }
        //logger.info("CustomFilter.login[{}]", JsonUtils.toJson(invocation.getAttachments()));
        Result result = invoker.invoke(invocation);
        return result;
    }
}