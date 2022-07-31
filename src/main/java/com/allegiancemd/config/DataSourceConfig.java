package com.allegiancemd.config;

import com.allegiancemd.entity.Patient;
import com.allegiancemd.model.AllegianceMdModel1;
import com.allegiancemd.model.AllegianceMdModel2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.allegiancemd.repo",
        transactionManagerRef = "transcationManager",
        entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
public class DataSourceConfig {

    @Autowired
    private AllegianceMdModel1 allegianceMdModel1;
    @Autowired
    private AllegianceMdModel2 allegianceMdModel2;

    @Bean
    @Primary
    @Autowired
    public DataSource dataSource() {
        DataSourceRouting dataSourceRouting = new DataSourceRouting();
        dataSourceRouting.initDataSource(allegianceMd1DataSource(), allegianceMd2DataSource());
        return dataSourceRouting;
    }

    public DataSource allegianceMd1DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(allegianceMdModel1.getUrl());
        dataSource.setUsername(allegianceMdModel1.getUsername());
        dataSource.setPassword(allegianceMdModel1.getPassword());
        return dataSource;
    }

    public DataSource allegianceMd2DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(allegianceMdModel2.getUrl());
        dataSource.setUsername(allegianceMdModel2.getUsername());
        dataSource.setPassword(allegianceMdModel2.getPassword());
        return dataSource;
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource()).packages(Patient.class).build();
    }

    @Bean(name = "transcationManager")
    public JpaTransactionManager transactionManager(
            @Autowired @Qualifier("entityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
