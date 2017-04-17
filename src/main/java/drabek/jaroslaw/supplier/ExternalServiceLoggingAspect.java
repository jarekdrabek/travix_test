package drabek.jaroslaw.supplier;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class ExternalServiceLoggingAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ExternalServiceLoggingAspect.class);

    @Around("@annotation(externalService)")
    public List<Object> logAround(ProceedingJoinPoint joinPoint, ExternalService externalService) throws Throwable {
        LOG.info("Querying external resource ({}) with parameters: {}", joinPoint.getSignature().getDeclaringType(), joinPoint.getArgs());
        List<Object> response = (List<Object>)joinPoint.proceed();
        LOG.info("External resource returned value: {}",response);
        return response;
    }
}
