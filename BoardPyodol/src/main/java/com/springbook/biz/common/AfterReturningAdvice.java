package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVo;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()" , returning="returnObj")
	public void afterRetuninglog(JoinPoint jp , Object returnObj  ) {
		
		String method = jp.getSignature().getName();
	if(returnObj instanceof UserVo) {
			UserVo user = (UserVo)returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() +"로그인(ADMIN)");
			}
		}
		
		System.out.println("[사후처리]" +method+returnObj.toString());
	}
}
