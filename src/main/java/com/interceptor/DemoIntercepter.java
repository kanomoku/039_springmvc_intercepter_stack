package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*二. 拦截器栈
1. 多个拦截器同时生效时,组成了拦截器栈
2. 顺序:先进后出.
3. 执行顺序和在springmvc.xml 中配置顺序有关
4. 设置先配置拦截器A 在配置拦截器B 执行顺序为
preHandle(A) --> preHandle(B) --> 控制器方法--> postHandle(B)--> postHanle(A) --> JSP --> afterCompletion(B) --> afterCompletion(A)
*/
public class DemoIntercepter implements HandlerInterceptor{

	//进入控制器之前执行，如果返回值是false则阻止进入控制器
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("preHandle");//拦截的控制器的方法
		return true;
	}

	//控制器执行完成，进入jsp之前执行
	//日志记录
	//敏感词语过滤
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");

		
	}
	//jsp执行完成后执行
	//记录执行过程中出现的异常，无论是否出现异常该方法都会被执行
	//可以把异常记录到日志中
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");

		
	}


}
