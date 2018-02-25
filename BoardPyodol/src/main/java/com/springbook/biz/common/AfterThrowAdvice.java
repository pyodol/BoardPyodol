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
		
		System.out.println("[����ó��]" +method + "()�޼��� ������ �߻��� ���� �޽���" +exceptObj.getMessage());
		System.out.println("���ֿ��� �︰�̳�");
	}
}
