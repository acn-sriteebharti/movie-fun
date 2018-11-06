package org.superbiz.moviefun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DatabaseConfigBean {

    @Bean
    public DatabaseServiceCredentials garbanzoBean(@Value("${VCAP_SERVICES}") String vcap) {
        return new DatabaseServiceCredentials(vcap);
    }

    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setDatabase(Database.MYSQL);
        vendor.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        vendor.setGenerateDdl(true);
        return vendor;
    }
}
