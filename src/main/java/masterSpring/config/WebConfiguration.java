package masterSpring.config;

import masterSpring.date.ReLocalDateFormat;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDate;

@Configuration

public class WebConfiguration extends WebMvcConfigurerAdapter{
    @Override   public void addFormatters(FormatterRegistry registry){
        registry.addFormatterForFieldType(LocalDate.class, new ReLocalDateFormat());
    }



}
