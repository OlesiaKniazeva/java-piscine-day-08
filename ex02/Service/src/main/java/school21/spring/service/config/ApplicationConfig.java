package school21.spring.service.config;

//import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource("db.properties")
@ComponentScan("school21.spring.service")
public class ApplicationConfig {
    @Value("${db.url}")
    private String url;

    @Value(("{db.user"))
    private String login;

    @Value("{db.password}")
    private String password;

    @Value("{db.driver.name}")
    private String driver;

//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL)
//                .build();
//
//        return database;
//    }


    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();

        source.setUsername(login);
        source.setPassword(password);
        source.setUrl(url);
        source.setDriverClassName(driver);

        return source;
    }

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariDataSource source = new HikariDataSource();
        source.setUsername(login);
        source.setPassword(password);
        source.setJdbcUrl(url);
        source.setDriverClassName(driver);

        return source;
    }
}
