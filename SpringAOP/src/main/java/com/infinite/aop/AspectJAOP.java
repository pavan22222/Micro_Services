package com.infinite.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJAOP {

	@Pointcut(value = "execution(* com.infinite.beans.*.*(..))")
	private void pointCutExpression() {

	}

	// @Before("pointCutExpression()")
	@Before("execution(* com.infinite.beans.BankService.deposite(..))")
	public void validateArguments(JoinPoint jp) {
		System.out.println(jp.getSignature().getName() + " " + Arrays.deepToString(jp.getArgs()));
	}

	@AfterReturning(value="execution(* com.infinite.beans.BankService.withdraw(..))",returning = "retValue")
	public void showReturnValue(JoinPoint jp,String retValue) {
		System.out.println(jp.getSignature().getName() + " " + Arrays.deepToString(jp.getArgs()));
		System.out.println(retValue);
	}
	
	@Around(value="execution(* com.infinite.beans.BankService.getBalance(..))")
	public Object aroundAdviceMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(pjp.getSignature().getName() + " " + Arrays.deepToString(pjp.getArgs()));
		pjp.getArgs()[0]=2222l;
		Object obj=pjp.proceed(pjp.getArgs());
		System.out.println(obj);
		return 12222f;
	}
	
	@AfterThrowing(value="pointCutExpression()",throwing = "tw")
	public void throwsAdvice(JoinPoint jp,Throwable tw) {
		System.out.println("Throws Advice");
		System.out.println(jp.getSignature().getName() + " " + Arrays.deepToString(jp.getArgs()));
		System.out.println(tw.getMessage());
	}

}
