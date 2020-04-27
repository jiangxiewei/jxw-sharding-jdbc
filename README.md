# sharding-jdbc公交云内部版本(ibus-sharding-jdbc)

## 使用前准备
![apache](src/main/resources/picture/apache.png)  
请参考sharding-sphere(apache)[官方文档](https://shardingsphere.apache.org)学习sharding-jdbc.
## RELEASE-1.0.0
- 基于sharding-jdbc 3.1.0版本进行修改.(非apache版本)
- 提前了ConfigMapContext的初始化操作,使用户的sharding-algorithm在使用时能正常拿到配置值.
- 修复了sharding-jdbc一个异常无法抛出的bug(只能抛出NullPointerException,隐藏了真实异常).
- 给基于hint(暗示)的路由方式中,setShardingValue进行的强制数据库路由添加了SQL解析模块(之前是跳过的).并给HintShardingAlgorithm添加了解析出来的表名. PS:此修改仅对基于hint的强制路由和 prepareStatement形式的查询进行过简单测试,其他情况使用请慎重.
- 原版不支持包含UNION的SQL解析,此处特意放开这个限制,由用户侧进行选择是否使用.
