package org.ys.core.shiro.common;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;

import java.util.concurrent.Callable;

class MyResult implements Callable<Result> {

    private Invoker<?> invoker;

    private Invocation invocation;

    public MyResult(Invoker<?> invoker, Invocation invocation) {
        this.invocation = invocation;
        this.invoker = invoker;
    }

    @Override
    public Result call() throws Exception {
        Result result = invoker.invoke(invocation);
        return result;
    }
}
