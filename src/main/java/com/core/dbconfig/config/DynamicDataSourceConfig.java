
package com.core.dbconfig.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.core.dbconfig.multipledatasource.DataSourceType;
import com.core.dbconfig.multipledatasource.DynamicDataSource;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Configuration
public class DynamicDataSourceConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Bean(name = "masterDataSource") // 声明其为Bean实例
    @Primary // 在同样的DataSource中，首先使用被标注的DataSource
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "slaveDataSource") // 声明其为Bean实例
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource slaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * @return
     * @desc 动态配置多数据源
     */
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource multipleDataSource(@Qualifier("masterDataSource") DataSource masterDb, @Qualifier("slaveDataSource") DataSource slaveDb) {
        DynamicDataSource multipleDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER, masterDb);
        targetDataSources.put(DataSourceType.SLAVE, slaveDb);
        //添加数据源
        multipleDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        multipleDataSource.setDefaultTargetDataSource(masterDb);
        multipleDataSource.afterPropertiesSet();
        return multipleDataSource;
    }


    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //模块依赖打包的时候报错，找不到setTypeAliasesPackage，所以需要添加下面设置
        VFS.addImplClass(SpringBootVFS.class);
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/mysql/*.xml"));
        //bean.setTypeAliasesPackage("com.core.data.model");
        return bean.getObject();
    }


    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        //解决mybatis查询过滤掉为空字段的问题
        sqlSessionTemplate.getConfiguration().setCallSettersOnNulls(true);
        return sqlSessionTemplate;
    }
}

