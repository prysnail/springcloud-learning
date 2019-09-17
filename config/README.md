# 分布式配置中心 Spring Cloud Config

## 访问方式

配置信息url与配置文件映射关系：

- /{application}/{profile}/[/{label}]
- /{application}-{profile}.yml
- /{label}/{application}-{profile}.yml


如：http://localhost:7001/config/prod/config-label-test

## 备注

运行程序需要先配置`application.properties`中的git信息