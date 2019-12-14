package com.gjk.metstat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.Resource;
import java.util.Set;

@Configuration
public class ConvertersConfig {

  @Resource
  private Set<Converter<?, ?>> converters;

  /**
   * @return the conversion service.
   */
  @Bean
  public ConversionService conversionService() {
    ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
    bean.setConverters(converters);
    bean.afterPropertiesSet();
    return bean.getObject();
  }
}
