package com.group1.admin.ascept;

import com.group1.core.entity.admin.Admin;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PasswordAspect {

    @Around("execution(* com.group1.admin.service.AdminService.login(..))")
    public Object aroundEncrypt(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args =pjp.getArgs();
        Admin admin =(Admin) args[0];
        String pwd = admin.getPassword();
        admin.setPassword(DigestUtils.md5Hex(pwd));
        return pjp.proceed(args);

    }
}
