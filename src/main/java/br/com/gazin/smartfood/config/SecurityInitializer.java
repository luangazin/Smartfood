package br.com.gazin.smartfood.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author luangazin
 *
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer{
	
	public SecurityInitializer() {
		super(SecurityConfig.class);
	}

}
