# sharding-jdbc 自用版本

## 使用前准备
[![apache](src/main/resources/picture/apache.png)](https://shardingsphere.apache.org)
请参考sharding-sphere(apache)[官方文档](https://shardingsphere.apache.org)学习sharding-jdbc.
基于sharding-jdbc 3.1.0修改,不过使用方面和apache版的4.0.0可能大多数差不多,可直接看4.0.0的文档.
## RELEASE-1.0.0
- 基于sharding-jdbc 3.1.0版本进行修改.(非apache版本)
- 提前了ConfigMapContext的初始化操作,使用户的sharding-algorithm在使用时能正常拿到配置值.
- 修复了sharding-jdbc一个异常无法抛出的bug(只能抛出NullPointerException,隐藏了真实异常).
- 给基于hint(暗示)的路由方式中,setShardingValue进行的强制数据库路由添加了SQL解析模块(之前是跳过的).并给HintShardingAlgorithm添加了解析出来的表名. PS:此修改仅对基于hint的强制路由和 prepareStatement形式的查询进行过简单测试,其他情况使用请慎重.
- 原版不支持包含UNION的SQL解析,此处特意放开这个限制,可能会引入BUG,可自行修改关闭.
- 原版3.1.0的遗留问题: 分页可能存在问题. github issue:https://github.com/apache/shardingsphere/issues/1722 目前认为可能是这个原因:https://blog.csdn.net/weixin_30721077/article/details/99647265 issue对应的修复是加上了单表时的特判.下版本(不存在)我将会尝试对此问题的修复
