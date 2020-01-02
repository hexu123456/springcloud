package com.hx.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {
	
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource getDataSource(){
		
		 return new DruidDataSource();
	}
	//配置druid监控
	//第一步：配置一个管理后台的servlet,主要是配置druid监控平台
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		// IP白名单
		// servletRegistrationBean.addInitParameter("allow", "*.");
		// IP黑名单(共同存在时，deny优先于allow)
		// servletRegistrationBean.addInitParameter("deny", "139.158.xxx.xxx");
		// 控制台管理用户
		servletRegistrationBean.addInitParameter("loginUsername", "admin");//登录druid平台用户名
		servletRegistrationBean.addInitParameter("loginPassword", "123456");//登录druid平台密码
		// 是否能够重置数据 禁用HTML页面上的“Reset All”功能
		//servletRegistrationBean.addInitParameter("resetEnable", "true");
		return servletRegistrationBean;
	}

	/**
	 * 第二步：配置一个web监控，注册一个：filterRegistrationBean 没有这个类的话，则URI监控、session监控、web应用都出不来
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean druidStatFilter2() {
		System.out.println("filterRegistrationBean configure start.");
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(
				new WebStatFilter());
		// 添加过滤规则.拦截
		filterRegistrationBean.addUrlPatterns("/*");
		// 添加不需要忽略的格式信息.不拦截信息
		filterRegistrationBean.addInitParameter("exclusions",
				"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

}
