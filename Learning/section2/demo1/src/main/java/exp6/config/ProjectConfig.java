package exp6.config;


import exp6.beans.Person;
import exp6.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"exp6.beans"})
public class ProjectConfig {



}
