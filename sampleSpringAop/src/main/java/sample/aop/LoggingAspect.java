package sample.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by pkumar on 8/6/17.
 */

@Aspect
public class LoggingAspect {

    private static Logger logger = Logger.getLogger(LoggingAspect.class);

    @Before("execution(* addCustomer*(..))")
    public void logEntry(JoinPoint joinPoint) {
        logger.info("Enter "+joinPoint.getSignature().getName());
    }

    @After("execution(* addCustomer*(..))")
    public void logExit(JoinPoint joinPoint) {
        logger.info("Exit "+ joinPoint.getSignature().getName());
    }
}
