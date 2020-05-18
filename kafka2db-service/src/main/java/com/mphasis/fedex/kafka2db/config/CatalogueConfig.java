package com.mphasis.fedex.kafka2db.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "catalogueEntityManagerFactory", transactionManagerRef = "catalogueTransactionManager", basePackages = {
		"com.mphasis.fedex.kafka2db.catalogue.repository" })
public class CatalogueConfig {

	@Primary
	@Bean(name = "catalogueDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "catalogueEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("catalogueDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.mphasis.fedex.kafka2db.catalogue.model")
				.persistenceUnit("shoppingcart").build();
	}

	@Primary
	@Bean(name = "catalogueTransactionManager")
	public PlatformTransactionManager productTransactionManager(
			@Qualifier("catalogueEntityManagerFactory") EntityManagerFactory catalogueEntityManagerFactory) {
		return new JpaTransactionManager(catalogueEntityManagerFactory);
	}
}