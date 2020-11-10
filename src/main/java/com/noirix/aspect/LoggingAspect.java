package com.noirix.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger log = Logger.getLogger(LoggingAspect.class);
    private static final Map<String,Integer> hashMap = new HashMap<String,Integer>();

//    @Before("aroundRepositoryPointcut()")
//    public void logBefore(JoinPoint joinPoint) {
//        log.info("Method " + joinPoint.getSignature().getName() + " start");
//    }
//
//    @AfterReturning(pointcut = "aroundRepositoryPointcut()")
//    public void doAccessCheck(JoinPoint joinPoint) {
//        log.info("Method " + joinPoint.getSignature().getName() + " finished");
//    }

    @Pointcut("execution(public * com.noirix.repository.impl.CarsRepositoryJdbcTemplateImpl.*(..))")
    public void aroundRepositoryPointcut() {
    }

    @Around("aroundRepositoryPointcut()")
    public Object aroundMethods(ProceedingJoinPoint jpj) throws Throwable {
        StopWatch clock = new StopWatch(jpj.toString());
            clock.start();
            Object proceed = jpj.proceed();
            clock.stop();
            if(hashMap.containsKey(jpj.getSignature().getName()))
                 hashMap.put(jpj.getSignature().getName(), hashMap.get(jpj.getSignature().getName())+1);
            else hashMap.put(jpj.getSignature().getName(),1);
            System.out.println(clock.prettyPrint());


            System.out.println("launch quantity method: "+jpj.getSignature().getName()+" "+ hashMap.get(jpj.getSignature().getName()));

            return proceed;

        }
        }





        //  public Object logAroundMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        //      log.info("Method " + joinPoint.getSignature().getName() + " start");
        //      Object proceed = joinPoint.proceed();
        //      log.info("Method " + joinPoint.getSignature().getName() + " finished");
        //      return proceed;




