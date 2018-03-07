package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
@Service
@Aspect
public class AfterAdvice {
	
	@After("PointcutCommon.allPointcut()")
	public void afterlog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("���ֿ�Finally"  );
		System.out.println("���ֿ� Method"+method.toString()  );
		System.out.println("���ֿ�Args" +args[0].toString());
	}
}
