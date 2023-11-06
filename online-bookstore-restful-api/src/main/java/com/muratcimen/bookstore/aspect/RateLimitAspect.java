package com.muratcimen.bookstore.aspect;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Component
public class RateLimitAspect {

    private final Bucket bucket;

    public RateLimitAspect(Bucket bucket) {
        this.bucket = bucket;
    }

    @Pointcut("@annotation(com.muratcimen.config.RateLimited)")
    public void rateLimitedMethods() {}

    @Around("rateLimitedMethods()")
    public Object rateLimitCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        if (probe.isConsumed()) {
            return joinPoint.proceed();
        } else {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "The request rate is limited. Please try again later.");
        }
    }
}