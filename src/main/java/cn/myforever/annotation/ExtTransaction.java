package cn.myforever.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 有这个注解的方法，自动开启事务，提交事务，回滚事务
 * @author Administrator
 *
 */
@Target({ElementType.METHOD})//只能用于方法
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtTransaction {

}
