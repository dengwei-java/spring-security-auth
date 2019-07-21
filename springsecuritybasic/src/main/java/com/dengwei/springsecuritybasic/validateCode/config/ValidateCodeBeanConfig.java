/**
 * 
 */
package com.dengwei.springsecuritybasic.validateCode.config;

import com.dengwei.springsecuritybasic.validateCode.ValidateCodeGenerator;
import com.dengwei.springsecuritybasic.validateCode.image.ImageCodeGenerator;
import com.dengwei.springsecuritybasic.validateCode.shortMessage.DefaultSmsCodeSender;
import com.dengwei.springsecuritybasic.validateCode.shortMessage.SmsCodeSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhailiang
 *
 */
@Configuration
public class ValidateCodeBeanConfig {
	

	
	@Bean
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		return codeGenerator;
	}
	
	@Bean
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}

}
