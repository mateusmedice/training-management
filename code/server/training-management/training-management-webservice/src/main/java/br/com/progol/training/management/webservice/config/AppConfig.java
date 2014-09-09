package br.com.progol.training.management.webservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("br.com.progol.training.management.*")
@EnableWebMvc
public class AppConfig {

}
