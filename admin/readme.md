# intercept 防止表单重复提交

1、在Spring MVC的配置文件里加入

        <mvc:interceptor>
             <mvc:mapping path="/**"/>
             <bean class="com.group1.core.interceptor.FormTokenInterceptor"/>
        </mvc:interceptor>

2、在需要生成token的controller上增加@FormToken(save=true)，而在需要检查重复提交的controller上添加@FormToken(remove=true)就可以了。
另外，你需要在view里在form里增加下面代码：

        <inputtype="hidden"name="formToken"value="${formToken}" />
        
- 注意在ajax提交时 要加上 formToken参数

#  ajax跨域问题

1、配置文件解决

      <filter>
          <filter-name>CORS</filter-name>
          <filter-class>com.thetransactioncompany.cors.CORSFilter</filter-class>
          <init-param>
            <param-name>cors.allowGenericHttpRequests</param-name>
            <param-value>true</param-value>
          </init-param>
          <init-param>
            <param-name>cors.allowOrigin</param-name>
            <param-value>*</param-value>
          </init-param>
          <init-param>
            <param-name>cors.allowSubdomains</param-name>
            <param-value>false</param-value>
          </init-param>
          <init-param>
            <param-name>cors.supportedMethods</param-name>
            <param-value>GET, HEAD, POST, OPTIONS</param-value>
          </init-param>
          <init-param>
            <param-name>cors.supportedHeaders</param-name>
            <param-value>*</param-value>
          </init-param>
          <init-param>
            <param-name>cors.exposedHeaders</param-name>
            <param-value>X-Test-1, X-Test-2</param-value>
          </init-param>
          <init-param>
            <param-name>cors.supportsCredentials</param-name>
            <param-value>true</param-value>
          </init-param>
          <init-param>
            <param-name>cors.maxAge</param-name>
            <param-value>3600</param-value>
          </init-param>
        </filter>
        <filter-mapping>
          <filter-name>CORS</filter-name>
          <url-pattern>/*</url-pattern>
        </filter-mapping>
         
2、注解解决

        @CrossOrigin(origins = "*", maxAge = 3600)