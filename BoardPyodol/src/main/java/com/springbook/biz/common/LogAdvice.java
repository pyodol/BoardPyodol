package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class LogAdvice {
	
	
	@Before("PointcutCommon.allPointcut()")
	public void printLog() {
		System.out.println("�̿��� Before ���̺����");
	}
	
}
