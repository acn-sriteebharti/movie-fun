package org.superbiz.moviefun;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class AlbumsConfigBean {

    @Bean
    public DataSource albumsDataSource(DatabaseServiceCredentials serviceCredentials) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(serviceCredentials.jdbcUrl("albums-mysql"));
        HikariConfig config = new HikariConfig();
        config.setDataSource(dataSource);
        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean albumsEntityManagerFactory(DataSource albumsDataSource, HibernateJpaVendorAdapter vendor){
        LocalContainerEntityManagerFactoryBean local = new LocalContainerEntityManagerFactoryBean();
        local.setDataSource(albumsDataSource);
        local.setJpaVendorAdapter(vendor);
        local.setPackagesToScan(DatabaseConfigBean.class.getPackage().getName());
        local.setPersistenceUnitName("albums");
        return local;
    }

    @Bean
    public PlatformTransactionManager albumsTransactionManager(EntityManagerFactory albumsEntityManagerFactory){
        return new JpaTransactionManager(albumsEntityManagerFactory);
    }

}
