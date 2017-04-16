package drabek.jaroslaw.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RequestParametersLogging {

    private static final Logger LOG = LoggerFactory.getLogger(RequestParametersLogging.class);

    @Around("@annotation(externalSupplier)")
    public Object logAround(ProceedingJoinPoint joinPoint, ExternalSupplier externalSupplier) throws Throwable {
        LOG.info("Querying external resources with parameters: {}",joinPoint.getArgs());
        Object returnObject = joinPoint.proceed();
        return returnObject;
    }
}
