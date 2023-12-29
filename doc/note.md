# springboot常见注解
1. @Repository：注解通常用于标识一个类作为数据访问层的组件，它通常与JPA（Java Persistence API）一起使用

# 常见问题
1. 样式无法正常显示时，对于src、href链接使用th:src、th:href的形式
   1. 添加th的支持：`<html lang="en" xmlns:th="http://www.thymeleaf.org">`
   2. 修改成th:href的形式：`<link th:href="@{/css/bootstrap.min.css}" rel="stylesheet">`