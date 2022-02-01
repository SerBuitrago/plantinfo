package co.com.plantinfo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.plantinfo.usecase",
        includeFilters = { @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")},
        useDefaultFilters = false)
public class UseCasesConfig { }
