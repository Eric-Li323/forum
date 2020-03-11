## B站论坛

## 资料  

测试  
(句子末尾两个空格表示换行)  
[Spring文档](https://spring.io/guides)  
[Spring Web](https://spring.io/guides/gs/serving-web-content/)  
[elasticSearch社区](https://elasticsearch.cn/)
[BootStrap文档](https://v3.bootcss.com/components/#navbar)
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/)  
[OAuth参数](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)  
[okHttp](https://square.github.io/okhttp/)  
[flyway--sql脚本管理，类似git](https://flywaydb.org/getstarted/firststeps/maven#migrating-the-database)  
[布局文档](https://v3.bootcss.com/css/#grid)  
[Lombok配置--自动setter,getter，toString等方法](https://www.jianshu.com/p/2543c71a8e45)  
[Lombok官网](https://projectlombok.org/features/all)  
[thymeleaf](https://www.thymeleaf.org/documentation.html)  

## 工具  
  
  
## 脚本  
```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` bigint(0) NULL DEFAULT NULL,
  `gmt_modified` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```
```bash
mvn flyway:migrate
```