package com.afiab.data.center.metadata.server.config;

//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.util.Utils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.*;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 13:11
 * @Description: 主数据元连接池初始化配置
 */
@Configuration
@MapperScan(basePackages = "com.afiab.data.center.metadata.dao.mapper.metadata" ,sqlSessionTemplateRef = "metaSqlSessionTemplate" )
public class MetaDataSourceConfig {
    private static final String  URL_MAP_PATTERN = "/druid/*";
    @Value("${spring.datasource.type}")
    private String type ;
    @Value("${spring.datasource.druid.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.druid.url}")
    private String url;
    @Value("${spring.datasource.druid.username}")
    private String userName;
    @Value("${spring.datasource.druid.password}")
    private String password;
    @Value("${spring.datasource.druid.filters}")
    private String filters ;
    @Value("${spring.datasource.druid.maxActive}")
    private Integer maxActive;
    @Value("${spring.datasource.druid.initialSize}")
    private Integer initialSize;
    @Value("${spring.datasource.druid.maxWait}")
    private long maxWait;
    @Value("${spring.datasource.druid.minIdle}")
    private Integer minIdle;
    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.druid.maxEvictableIdleTimeMillis}")
    private long maxEvictableIdleTimeMillis;
//    @Value("${spring.datasource.druid.phy-timeout-millis}")
//    private long phyTimeoutMillis;
    @Value("${spring.datasource.druid.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${spring.datasource.druid.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${spring.datasource.druid.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${spring.datasource.druid.poolPreparedStatements}")
    private Boolean poolPreparedStatements;
    @Value("${spring.datasource.druid.maxOpenPreparedStatements}")
    private int maxOpenPreparedStatements;
    @Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;

    @Primary
    @Bean(name = "metaDataSource")
    public DataSource metaDataSource() throws Exception{
        Class classes = Class.forName(type);
        DruidDataSource dataSource = (DruidDataSource) DataSourceBuilder
                .create()
                .driverClassName(driverClassName)
                .type(classes)
                .url(url)
                .username(userName)
                .password(password)
                .build();
        String druidName = "mysql_系统默认_metadata_1";
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

    @Bean(name = "metaSqlSessionFactory")
    public SqlSessionFactory metaSqlSessionFactory(@Qualifier("metaDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/metadata/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "metaDataSourceTransactionManager")
    @Primary
    public DataSourceTransactionManager metaDataSourceTransactionManager(@Qualifier("metaDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "metaSqlSessionTemplate")
    public SqlSessionTemplate metaSqlSessionTemplate(@Qualifier("metaSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    /**
     * 配置监控服务器
     *
     * @return 返回监控注册的servlet对象
     */
    @Bean
    public ServletRegistrationBean statViewServletDemo() {
        ServletRegistrationBean srb = new ServletRegistrationBean(new StatViewServlet(), URL_MAP_PATTERN);
//        // 添加IP白名单
//        srb.addInitParameter("allow", "127.0.0.1");
//        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
//        srb.addInitParameter("deny", "192.168.25.123");
        // 添加控制台管理用户
//        srb.addInitParameter("loginUsername", druidUserName);
//        srb.addInitParameter("loginPassword", druidUserPwd);
        // 是否能够重置数据
        srb.addInitParameter("resetEnable", "false");
        return srb;
    }
    /**
     * 配置服务过滤器
     *
     * @return 返回过滤器配置对象
     */
    @Bean
    public FilterRegistrationBean statFilterDemo() {
        FilterRegistrationBean frb = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        frb.addUrlPatterns("/*");
        // 忽略过滤格式
        frb.addInitParameter("exclusions", URL_MAP_PATTERN +",*.js,*.gif,*.jpg,*.png,*.css,*.ico,");
        frb.setOrder(1);
        return frb;
    }

    /**
     * 方法名: removeDruidAdFilterRegistrationBean
     * 方法描述 除去页面底部的广告
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean removeDruidAdFilterRegistrationBean() {

        // 提取common.js的配置路径
        String commonJsPattern = URL_MAP_PATTERN.replaceAll("\\*", "js/common.js");

        final String filePath = "support/http/resources/js/common.js";

        //创建filter进行过滤
        Filter filter = new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {}

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                chain.doFilter(request, response);
                // 重置缓冲区，响应头不会被重置
                response.resetBuffer();
                // 获取common.js
                String text = Utils.readFromResource(filePath);
                // 正则替换banner, 除去底部的广告信息
                text = text.replaceAll("<a.*?banner\"></a><br/>", "");
                text = text.replaceAll("powered.*?shrek.wang</a>", "");
                response.getWriter().write(text);
            }

            @Override
            public void destroy() {}
        };

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setOrder(2);
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns(commonJsPattern);
        return registrationBean;
    }
}
