package cn.myforever.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.myforever.annotation.ExtTransaction;
import cn.myforever.transaction.MyTransaction;
@Component
@Aspect
public class TransactionAop {
	@Autowired
	private MyTransaction myTransaction;
	@AfterThrowing("execution(* cn.myforever.service.*.*(..))")
	public void afterThrowing() {
		System.out.println("异常通知");
		myTransaction.rollback();
	}
	@Around("execution(* cn.myforever.service.*.*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("坏绕通知前");
		//判断方法上是否有ExtTransaction注解
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		System.out.println(ms.getName());
		ExtTransaction extTransaction = ms.getMethod().getDeclaredAnnotation(ExtTransaction.class);
		System.out.println(extTransaction);
		if(extTransaction!=null) {
			//开启事务
			System.out.println("----开启事务");
			myTransaction.begin();
		}
		pjp.proceed();
		System.out.println("环绕通知之后");
		if(extTransaction!=null) {
			//开启事务
			System.out.println("----提交事务");
			myTransaction.commit();
		}
		
	}
}
