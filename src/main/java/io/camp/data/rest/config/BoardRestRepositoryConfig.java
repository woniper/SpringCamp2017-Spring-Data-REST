package io.camp.data.rest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.List;

@Configuration
public class BoardRestRepositoryConfig
        extends RepositoryRestConfigurerAdapter {

    /**
     * Request, Response, URL Config
     */
    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config) {

        super.configureRepositoryRestConfiguration(config);
    }

    /**
     * Converter Config
     */
    @Override
    public void configureConversionService(
            ConfigurableConversionService conversionService) {

        super.configureConversionService(conversionService);
    }

    /**
     * Validation Config
     */
    @Override
    public void configureValidatingRepositoryEventListener(
            ValidatingRepositoryEventListener validatingListener) {

        super.configureValidatingRepositoryEventListener(validatingListener);
    }

    /**
     * ExceptionHandler Config
     */
    @Override
    public void configureExceptionHandlerExceptionResolver(
            ExceptionHandlerExceptionResolver exceptionResolver) {

        super.configureExceptionHandlerExceptionResolver(exceptionResolver);
    }

    /**
     * MessageConverter Config
     */
    @Override
    public void configureHttpMessageConverters(
            List<HttpMessageConverter<?>> messageConverters) {

        super.configureHttpMessageConverters(messageConverters);
    }

    /**
     * ObjectMapper Config
     */
    @Override
    public void configureJacksonObjectMapper(
            ObjectMapper objectMapper) {

        super.configureJacksonObjectMapper(objectMapper);
    }
}
