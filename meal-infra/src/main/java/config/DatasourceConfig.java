package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("repository")
@PropertySource("classpath:datasource.properties")
public class DatasourceConfig {

    @Value("${datasource.url}")
    private String DB_URL;

    @Value("${datasource.user}")
    private String DB_USER;

    @Value("${datasource.password}")
    private String DB_PWD;

    @Value("${datasource.driver}")
    private String DB_DRIVER;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PWD);

        return dataSource;
    }

    /*
        Configure Spring's transaction manager to use a DataSource
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    /*
        Configure jOOQ's ConnectionProvider to use Spring's TransactionAwareDataSourceProxy,
         which can dynamically discover the transaction context
     */
    @Bean
    public TransactionAwareDataSourceProxy transactionAwareDataSource() {
        return new TransactionAwareDataSourceProxy(dataSource());
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(transactionAwareDataSource());
    }

    @Bean
    public DefaultConfiguration defaultConfiguration() {
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        defaultConfiguration.setSQLDialect(SQLDialect.POSTGRES_9_5);
        defaultConfiguration.setConnectionProvider(connectionProvider());
        return defaultConfiguration;
    }

    @Bean
    public DefaultDSLContext dsl() {
        return new DefaultDSLContext(defaultConfiguration());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
