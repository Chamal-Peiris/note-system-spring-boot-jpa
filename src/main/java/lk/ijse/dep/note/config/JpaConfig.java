package lk.ijse.dep.note.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@EnableTransactionManagement
public class JpaConfig {
    @Autowired
    private Environment env;
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean lcmfb = new LocalContainerEntityManagerFactoryBean();
        lcmfb.setDataSource(ds);
        lcmfb.setJpaVendorAdapter(jpaVendorAdapter);
        lcmfb.setPackagesToScan("lk.ijse.dep.note.entity");
        return lcmfb;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(env.getProperty("jpa.show-sql",Boolean.class,false));
        jpaVendorAdapter.setGenerateDdl(env.getProperty("jpa.generate-ddl",Boolean.class,false));
        jpaVendorAdapter.setDatabasePlatform(env.getProperty("jpa.dialect"));
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        return  jpaVendorAdapter;
    }

    @Bean
    public DataSource dataSource(){
       final HikariDataSource hikariDataSource = new HikariDataSource();
       hikariDataSource.setJdbcUrl(env.getRequiredProperty("hikari.jdbc-url"));
       hikariDataSource.setUsername(env.getRequiredProperty("hikari.username"));
       hikariDataSource.setPassword(env.getRequiredProperty("hikari.password"));
       hikariDataSource.setDriverClassName(env.getRequiredProperty("hikari.driver-classname"));
       hikariDataSource.setMaximumPoolSize(env.getRequiredProperty("hikari.max-pool-size",Integer.class));
       return hikariDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }

    public static PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return  new PersistenceExceptionTranslationPostProcessor();
    }
}
