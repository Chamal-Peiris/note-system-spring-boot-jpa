package lk.ijse.dep.note.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@PropertySource("classpath:application.yml")
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

    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(env.getProperty("jpa.show-sql",Boolean.class,false));
        jpaVendorAdapter.setGenerateDdl(env.getProperty("jpa.generate-ddl",Boolean.class,false));
        jpaVendorAdapter.setDatabasePlatform(env.getProperty("jpa.dialect"));
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        return  jpaVendorAdapter;
    }
}
