package com.qf.shiro;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean getShiroFilter(SecurityManager securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        shiroFilterFactoryBean.setSuccessUrl("/Student/index");
//        shiroFilterFactoryBean.setLoginUrl("/Student/loginPage");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/Student/unauth");
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("/Student/loginPage","anon");
//        map.put("/Student/login","anon");
//        map.put("/**/**","authc");
////        map.put("Student/add","roles[role1]");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
//        return shiroFilterFactoryBean;
//    }
//    @Bean(name = "securityManager")
//    public SecurityManager getSecurityManager(MyRealm myRealm){
////        SecurityManager securityManager = new SecurityManager(myRealm);
//        SecurityManager securityManager = new DefaultWebSecurityManager(myRealm);
//        return securityManager;
//    }
//    @Bean(name = "myRealm")
//    public MyRealm getRealm(){
//        MyRealm myRealm = new MyRealm();
//        // 配置 加密 （在加密后，不配置的话会导致登陆密码失败）
//        myRealm.setCredentialsMatcher(hashedCredentialsMatcher()); //+++++++++++
//        System.out.println("myShiroRealm 注入成功");
//        return myRealm;
//    }
//    @Bean("shiroDialect")
//    public ShiroDialect getShiroDialect(){
//        return new ShiroDialect();
//    }
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher(){
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        // 使用md5 算法进行加密
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        return hashedCredentialsMatcher;
//    }


}
