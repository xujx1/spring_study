package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import service.impl.CompactDiscImpl;

@Configuration
/*@ComponentScan(basePackages = {"service"})*/
/*@ComponentScan(basePackageClasses = {CompactDiscImpl.class, CdPlayImpl.class})*/
@ComponentScan(basePackageClasses = CompactDiscImpl.class)
@ImportResource("classpath:spring.xml")
public class Config {

   /* @Bean
    public ICompactDisc compactDiscImpl() {
        return new CompactDiscImpl();
    }

    @Bean
    public CdPlayImpl cdPlayImpl() {
        return new CdPlayImpl(compactDiscImpl());
    }*/

}
