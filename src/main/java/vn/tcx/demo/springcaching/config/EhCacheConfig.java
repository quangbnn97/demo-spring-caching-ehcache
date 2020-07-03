package vn.tcx.demo.springcaching.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
@ComponentScan(basePackages = "vn.tcx.demo.springcaching")
public class EhCacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(cacheManagerFactory().getObject());
    }

    public EhCacheManagerFactoryBean cacheManagerFactory() {
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();

        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factoryBean.setShared(true);

        return factoryBean;
    }
}
