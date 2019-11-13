package com.qf.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilter(SecurityManager securityManager){
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setSuccessUrl("/HeadTeacher/index");
        shiroFilterFactoryBean.setLoginUrl("/login/loginPage");
    //我们在页面用shiro:hasRole来写,所以这句就用不到了
//        shiroFilterFactoryBean.setUnauthorizedUrl("/HeadTeacher/unauth");
    Map<String,String> map = new HashMap<String,String>();
        map.put("/login/loginPage","anon");
        map.put("/login/login","anon");
        //你们的过滤器我给注释掉了,用啥解锁啥
//        map.put("/HeadTeacher/**","authc");
//        map.put("/Boos/**","authc");
//        map.put("/Lecture/**","authc");
//        map.put("/Student/**","authc");
        //最后整合用↓
//      map.put("/**/**","authc");
        //权限,现在你们还不急着用这个
//        map.put("HeadTeacher/*","roles[班主任]");
//        map.put("Boos/*","roles[校长]");
//        map.put("Lecture/*","roles[讲师]");
//        map.put("Student/*","roles[学生]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
}
    @Bean(name = "securityManager")
    public SecurityManager getSecurityManager(MyRealm myRealm){
        SecurityManager securityManager = new DefaultWebSecurityManager(myRealm);
        return securityManager;
    }
    @Bean(name = "myRealm")
    public MyRealm getRealm(){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }
    @Bean("shiroDialect")
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        return hashedCredentialsMatcher;
    }



}
