package br.com.OthondeCarvalho.NotasBoletos.src.config;

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

import br.com.OthondeCarvalho.NotasBoletos.src.repository.auth.UserRepository;
import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackageClasses = UserRepository.class,
        transactionManagerRef = "h2TransactionManager", 
		entityManagerFactoryRef = "authEntityManager")
public class AuthDbConfig {

	@Bean(name = "authDataSource")
	@ConfigurationProperties(prefix = "auth.datasource")
	public DataSource authDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "authEntityManager")
	public LocalContainerEntityManagerFactoryBean authEntityManager(
			EntityManagerFactoryBuilder builder,
			@Qualifier("authDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("br.com.OthondeCarvalho.NotasBoletos.src.model.auth")
                .persistenceUnit("h2PU")
				.build();
	}
    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("authEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}