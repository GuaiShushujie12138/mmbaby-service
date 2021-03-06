package com.mmbaby.base.interceptor;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.mmbaby.base.util.GeneralResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 10:01
 */
@Aspect
@Component("csCatRemoteServiceInterceptor")
@Order(0)
public class CatRemoteServiceInterceptor {

    @Pointcut("execution(* com.mmbaby..*Service.*(..)) "
            + " && !execution(* com.mmbaby..*BizServiceImpl.*(..)) "
            + " && !execution(* com.mmbaby..*DomainServiceImpl.*(..))")
    public void servicePointcut() {
    }

    @Around("servicePointcut()")
    public Object around(ProceedingJoinPoint proceeding) throws Throwable {

        String className = proceeding.getTarget().getClass().getSimpleName();
        String methodName = proceeding.getSignature().getName();

        Transaction t = Cat.newTransaction("remoteService", className + "." + methodName);

        try {
            Object resultObj = proceeding.proceed();
            t.setStatus(Transaction.SUCCESS);
            return resultObj;
        }catch (Exception ex) {
            t.setStatus(ex);
            Cat.logError(ex);
            return new GeneralResult().returnFaile("系统错误:" + ex.getMessage());
        } finally {
            t.complete();
        }

    }
}
