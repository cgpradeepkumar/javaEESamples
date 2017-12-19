package sample.aop.example1;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pkumar on 28/9/17.
 */

@Aspect
@Configuration
public class SampleAspect {

    private static Logger logger;

    static {
        logger = Logger.getLogger(SampleAspect.class);
    }

    @Pointcut("execution (* sample.aop.example1.*.*(..))")
    public void intercept(ProceedingJoinPoint joinPoint) {
        logger.info("Intercepted......");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Before("intercept()")
    public void beforeAdvice() {
        logger.info("before......");
    }
}
