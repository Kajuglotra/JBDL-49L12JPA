package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.example.demo.persondb"},
        entityManagerFactoryRef = "personEntityManager",
        transactionManagerRef = "personTxnManager"
)
public class PersonDbConfig {

    @Autowired
    Environment environment;

    @Bean
    @ConfigurationProperties(prefix = "spring.personds")
    public DataSource personDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean personEntityManager(){
        LocalContainerEntityManagerFactoryBean em =
                new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(personDataSource());
        em.setPackagesToScan("com.example.demo.persondb");

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect" , "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto" , environment.getProperty("spring.personds.ddl-auto"));

        em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        em.setJpaPropertyMap(properties);
        return em;
    }
    @Bean
    public PlatformTransactionManager personTxnManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(personEntityManager().getObject());
        return jpaTransactionManager;
    }

}
