# data-center (数据平台)

## 0、数据平台架构

### 0.1、架构图

![1693982167799](C:\Users\ZHANGBAIFA\AppData\Roaming\Typora\typora-user-images\1693982167799.png)



### 0.2、架构说明

~~~mysql
架构说明：
1、限流（sentinel）熔断策略：流量激增进行熔断策略处理，防止后端服务因流量激增而被压垮
2、路由转发（路由优先级:主机路由 –> 网络路由 –> 默认路由）
3、网关(gateway):
4、鉴权(权限中心):数据权限&功能权限
5、服务集合：数据管理服务、元数据分析服务、OLAP、数据处理平台(实时&离线)、数据采集、数据质量、指标平台、标签平台、AB实验室、推荐平台、权限管理平台、审批平台、大数据任务诊断平台、智能运维平台
6、注册中心:consul
7、配置中心:apollo
8、日志中心:elk（Elasticsearch , Logstash, Kibana）
9、消息队列:rocketMQ
10、健康检查:请求http接口，consul健康检查接口
11、统一监控大盘:grafana（metrics采集jvm等信息）
12、服务链路追踪：cat
13、分布式缓存：redis、memcache
14、存储：mysql、neo4j、es
~~~



## 1、data-center-user (权限中心平台)

1.1、用户、角色、用户组、菜单

1.2、审批 (审批流)

1.3、权限 (个人权限、角色权限、用户组、行权限、列权限) RBRC模型 RBRA模型

1.4、审计

1.5、

## 2、data-center-metadata (数据资产平台)

2.1、数据源

2.2、元数据

2.3、数据地图

2.4、数据血缘

2.5、数据应用

2.6、

## 3、data-center-scheduler (调度平台)

3.1、离线数据处理

3.2、实时数据处理调度

3.3、实时数据采集

3.4、

## 4、data-center-olap (olap 在线数据分析平台)

4.1、sql查询

4.2、数据下载

4.3、数据文件

4.4、

## 5、data-center-metrics (指标平台)

5.1、指标

5.2、模型

5.3、数据集

5.4、



## 6、data-center-service （数据接口服务平台）

6.1、文件管理、api管理、mq管理

6.2、应用管理

6.3、



## 7、data-center-quality (dq 数据质量平台)

7.1、监控

7.2、规则

7.3、配置

7.4、告警

7.5、

## 8、data-center-tagx (标签平台)

8.1、标签（基础标签、自定义标签）

8.2、人群圈选、商品圈选

8.3、画像（人群、商品...）

8.4、系统管理

8.5、任务管理

8.6、



## 9、data-center-report (报表平台)

9.1、报表管理

9.2、可视化配置管理

9.3、



## 10、data-center-ui （数据中台ui）