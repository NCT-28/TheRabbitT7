package vn.com.rabbit.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("vn.com.rabbit.*")
@EnableTransactionManagement
@PropertySource({ "classpath:database.properties" })
@EnableJpaRepositories(basePackages = "vn.com.rabbit.repository")
public class ApplicationContextConfig {

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	  
	
	/** 
	 * Config Specifies the file size up
	 */
//	@Bean(name = "multipartResolver")
//	public MultipartResolver getMultipartResolver() {
//		CommonsMultipartResolver resover = new CommonsMultipartResolver();
//		// 1MB
//		resover.setMaxUploadSize(1 * 1024 * 1024);
//
//		return resover;
//	}
	
	/**
	 * Config data base.
	 */
	@Autowired
    private Environment env;


    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        System.out.println("## getSessionFactory .... ");
        try {
            Properties properties = new Properties();

            // Xem: ds-hibernate-cfg.properties
            properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
            properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
           // properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
            properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
            
            LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

            // Package contain entity classes
            // Package chứa các entity class.
            factoryBean.setPackagesToScan(new String[] { "vn.com.rabbit.entity" });
            factoryBean.setDataSource(dataSource);
            factoryBean.setHibernateProperties(properties);
            factoryBean.afterPropertiesSet();
            //
            SessionFactory sf = factoryBean.getObject();
            System.out.println("## getSessionFactory: " + sf);
            return sf;
        } catch (Exception e) {
            System.out.println("Error getSessionFactory: " + e);
            e.printStackTrace();
            throw e;
        }
    }


    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        return dataSource;
    }
    // Hibernate Transaction Manager
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
