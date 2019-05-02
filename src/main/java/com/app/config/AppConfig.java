package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.app")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:app.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;

	//1. DataSource
	@Bean
	public BasicDataSource ds() {
		BasicDataSource d=new BasicDataSource();
		d.setDriverClassName(env.getProperty("db.driver"));
		d.setUrl(env.getProperty("db.url"));
		d.setUsername(env.getProperty("db.un"));
		d.setPassword(env.getProperty("db.pwd"));
		return d;
	}
	
	//2. SessionFactory
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean s=new LocalSessionFactoryBean();
		s.setDataSource(ds());
		s.setHibernateProperties(props());
		s.setPackagesToScan("com.app.model");
		return s;
	}
	
	private Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("hb.dialect"));
		p.put("hibernate.show_sql", env.getProperty("hb.showsql"));
		p.put("hibernate.format_sql", env.getProperty("hb.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("hb.ddlauto"));
		return p;
	}
	
	//3. HT
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(sf().getObject());
		return h;
	}
	//4. HTxM
	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sf().getObject());
		return htm;
	}
	
	//5. ViewResolver
	@Bean
	public InternalResourceViewResolver vr() {
		InternalResourceViewResolver v=new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("mvc.prefix"));
		v.setSuffix(env.getProperty("mvc.suffix"));
		return v;
	}
	
	//6. Password encoder
	@Bean
	public BCryptPasswordEncoder encoder() {
		BCryptPasswordEncoder enc=new BCryptPasswordEncoder();
		return enc;
	}
	
	
	
}