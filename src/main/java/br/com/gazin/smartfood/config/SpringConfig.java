package br.com.gazin.smartfood.config;

import java.sql.SQLException;
import java.util.Locale;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import br.com.gazin.smartfood.mapper.UserMapper;
import oracle.jdbc.pool.OracleDataSource;

@Configuration
// Marks this class as configuration
// Specifies which package to scan
@ComponentScan("br.com.gazin.smartfood")
// Enables Spring's annotations
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter {

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
	public ViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		viewResolver.setOrder(1);
		return viewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Bean
	public DataSource getDataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setURL("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUser("COMANDA");
		dataSource.setPassword("ROOT");
		return dataSource;
	}

	@Bean
	@Autowired
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(
				environment);
		configuration.addMapper(UserMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		return sqlSessionFactory;
	}

	/**
	 * Configuration to support multi-language
	 */
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

	@Bean(name = "localeResolver")
	public SessionLocaleResolver getCookieLocaleResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		//sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}

	@Bean(name = "localeChangeInterceptor")
	public LocaleChangeInterceptor getLocaleChangeInterceptor() {
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("language");
		return changeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getLocaleChangeInterceptor());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}