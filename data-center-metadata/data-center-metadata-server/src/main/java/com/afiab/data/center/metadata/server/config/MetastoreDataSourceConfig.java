package com.afiab.data.center.metadata.server.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 13:21
 * @Description: 维表数据源配置
 */
@Configuration
@MapperScan(basePackages = "com.afiab.data.center.metadata.dao.mapper.metastore" ,sqlSessionTemplateRef = "metastoreSqlSessionTemplate" )
public class MetastoreDataSourceConfig {
    @Value("${spring.datasource.type}")
    private String type ;
    @Value("${spring.datasource.druid.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.metastore.druid.url}")
    private String url;
    @Value("${spring.datasource.metastore.druid.username}")
    private String userName;
    @Value("${spring.datasource.metastore.druid.password}")
    private String password;
    @Value("${spring.datasource.metastore.druid.filters}")
    private String filters ;
    @Value("${spring.datasource.metastore.druid.maxActive}")
    private Integer maxActive;
    @Value("${spring.datasource.metastore.druid.initialSize}")
    private Integer initialSize;
    @Value("${spring.datasource.metastore.druid.maxWait}")
    private long maxWait;
    @Value("${spring.datasource.metastore.druid.minIdle}")
    private Integer minIdle;
    @Value("${spring.datasource.metastore.druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.metastore.druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.metastore.druid.maxEvictableIdleTimeMillis}")
    private long maxEvictableIdleTimeMillis;
//    @Value("${spring.datasource.metastore.druid.phy-timeout-millis}")
//    private long phyTimeoutMillis;
    @Value("${spring.datasource.metastore.druid.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${spring.datasource.metastore.druid.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${spring.datasource.metastore.druid.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${spring.datasource.metastore.druid.poolPreparedStatements}")
    private Boolean poolPreparedStatements;
    @Value("${spring.datasource.metastore.druid.maxOpenPreparedStatements}")
    private int maxOpenPreparedStatements;
    @Value("${spring.datasource.metastore.druid.validationQuery}")
    private String validationQuery;

    @Bean(name = "metastoreDataSource")
    public DataSource platformDataSource() throws Exception{
        Class classes = Class.forName(type);
        String druidName = "mysql_系统默认_metastore_2";
        DruidDataSource dataSource = (DruidDataSource) DataSourceBuilder
                .create()
                .driverClassName(driverClassName)
                .type(classes)
                .url(url)
                .username(userName)
                .password(password)
                .build();
        dataSource.setName(druidName);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
//        dataSource.setPhyTimeoutMillis(phyTimeoutMillis);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        dataSource.setFilters(filters);
        return dataSource;
    }

    @Bean(name = "metastoreSqlSessionFactory")
    public SqlSessionFactory platformSqlSessionFactory(@Qualifier("metastoreDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/metastore/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "metastoreDataSourceTransactionManager")
    public DataSourceTransactionManager platformDataSourceTransactionManager(@Qualifier("metastoreDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "metastoreSqlSessionTemplate")
    public SqlSessionTemplate platformSqlSessionTemplate(@Qualifier("metastoreSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
