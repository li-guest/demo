## Mybatis 环境搭建

### 创建maven工程，导入相关的依赖
### 创建实体类和dao接口
### 创建Mybatis的主配置文件
### 创建映射配置文件


### 注意
    1. Mybatis 映射配置文件的位置必须和dao接口类的位置相同
    2. 映射配置文件的mapper标签和namespace属性取值必须是dao接口的全限定域名
    3. 映射配置文件的操作配置（select），id属性的取值必须是接口的方法名
  
### Mybatis 入门案例
    1. 读取配置文件
    2. 创建SqlSessionFactory 工厂类
    3. 创建Sqlsession
    4. 创建DAO的接口的代理对象
    5. 执行dao代理对象中的方法
    6. 释放Sqlsession
    
### 读取配置文件的方法
    1. 使用类加载器，但是只能读取类路径下配置文件
    2. 使用servletContext路径下的getRealPath();
    3. 创建工厂，Mybatis使用了构建者模式，