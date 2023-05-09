package com.serversystem.common;


import com.basicsystem.entity.InterfaceTime;
import com.basicsystem.entity.SysUserDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Aspect
@Component
@Slf4j
public class CostTimeAspect {

//    @Autowired
//    InterfaceTimeMapper interfaceTimeMapper;


    @Pointcut("execution(* com.serversystem.controller..*.*(..))")
    public void countTime() {
    }

    @Around("countTime()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {
            long beginTime = System.currentTimeMillis();
            obj = joinPoint.proceed();
            String methodName = joinPoint.getSignature().getName();
            String className = joinPoint.getSignature().getDeclaringTypeName();
            long costTime = System.currentTimeMillis() - beginTime;
            log.info("类：[{}]，方法：[{}]耗时时间为：[{}]", className, methodName, costTime / 1000 + "秒");
            if (costTime / 1000 > 1) {
                insertToDB(methodName, costTime, getUserId());
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }

    protected Long getUserId() {
        Subject subject = SecurityUtils.getSubject();
        SysUserDO user = (SysUserDO) subject.getPrincipal();
        if (!ObjectUtils.isEmpty(user)) {
            return user.getId();
        }
        return 0L;
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertToDB(String url, Long time, Long userId) {
        InterfaceTime interfaceTime = new InterfaceTime();
        interfaceTime.setName(url);
        interfaceTime.setCostTime(time);
        if (StringUtils.isEmpty(userId)){
            interfaceTime.setUserId(0l);
        }else {
            interfaceTime.setUserId(userId);
        }
//        interfaceTimeMapper.insert(interfaceTime);
    }

}
