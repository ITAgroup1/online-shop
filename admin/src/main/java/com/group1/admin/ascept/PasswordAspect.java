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


//    @Around("execution(com.group1.admin.service public * register(..))")
    @Around("execution(* com.group1.admin.service.AdminService.register(..))||execution(* com.group1.admin.service.AdminService.login())")
    public Object register(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around1...");
        Object o = encrypt(joinPoint);
        System.out.println("around2...");
        return o;
    }

//    @Around("execution(* com.group1.admin.service.AdminService.login(..))")
//    public Object login(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("around1...");
//        Object o = encrypt(joinPoint);
//        System.out.println("around2...");
//        return o;
//    }

    private Object encrypt(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = joinPoint.getArgs();
        Admin admin = (Admin) objects[0];
        String password = DigestUtils.md5Hex(admin.getPassword());
        System.out.println(password);
        admin.setPassword(password);
        objects[0] = admin;
        Object o = joinPoint.proceed(objects);
        return o;
    }
}
