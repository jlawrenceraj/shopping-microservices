package com.mphasis.fedex.kafka2db.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "orderEntityManagerFactory", transactionManagerRef = "orderTransactionManager", basePackages = {
		"com.mphasis.fedex.kafka2db.order.repository" })
public class OrderConfig {

	@Bean(name = "orderDataSource")
	@ConfigurationProperties(prefix = "order.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "orderEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("orderDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.mphasis.fedex.kafka2db.order.model")
				.persistenceUnit("shoppingcart").build();
	}

	@Bean(name = "orderTransactionManager")
	public PlatformTransactionManager productTransactionManager(
			@Qualifier("orderEntityManagerFactory") EntityManagerFactory orderEntityManagerFactory) {
		return new JpaTransactionManager(orderEntityManagerFactory);
	}
}