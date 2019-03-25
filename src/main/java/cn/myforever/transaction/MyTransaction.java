package cn.myforever.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * 自定义注解工具类
 * @author Administrator
 *
 */
@Component
@Scope("prototype") //每个事物都是新的实例，解决线程安全问题
public class MyTransaction {
	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;
	//这里定义全局的,由于是多实例，所以这里没有关系
	private TransactionStatus transactionStatus;
	//开启事物
	public void begin() {
		System.out.println("开启事务");
		transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
	}
	//提交事务
	public void commit() {
		System.out.println("提交事务");
		if(transactionStatus!=null) {
			dataSourceTransactionManager.commit(transactionStatus);
		}
	}
	
	//回滚事务
	public void rollback() {
		System.out.println("回滚事务");
		if(transactionStatus!=null) {
			System.out.println("1");
			dataSourceTransactionManager.rollback(transactionStatus);
		}
	}
}
