package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
@Service
@Aspect
public class AfterThrowAdvice {
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()" , throwing ="exceptObj")
	public void afterthrowlog(JoinPoint jp , Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[예외처리]" +method + "()메서드 수행중 발생된 예외 메시지" +exceptObj.getMessage());
		System.out.println("김주영은 헬린이네");
	}
}
