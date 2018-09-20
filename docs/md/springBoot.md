# SpringBoot2.0.5入门
## SpringBoot的启动方式
1. 在idea中直接运行
2. 使用maven命令运行：mvn spring-boot:run
3. mvn install 编译打成jar包后 java -jar xx.jar启动
4. 放在中间件下启动

**pom.xml**
```xml
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>2.0.5.RELEASE</version>
	<relativePath/> <!-- lookup parent from repository -->
</parent>

<dependencies>
	<!--web项目必须的依赖-->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
<dependencies>
```
**启动类加@SpringBootApplication注释，main方法调用run方法**
```java
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        //springBoot的启动
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
```

## SpringBoot的配置文件
在项目的resource目录下，有一个SpringBoot的全局配置文件`application.properties`，这个配置文件可以修改项目的访问端口、上下文路径等：
```
#修改项目访问端口
server.port=8080
#修改项目访问上下文路径
server.servlet.context-path=/springboot
```
SpringBoot同时支持yaml格式配置文件，可以用`application.yml`替换`application.properties`文件
```yaml
server:
  port: 8080
  servlet:
    context-path: /springboot
```

## 属性配置
|  标签 | 作用  |
| :------------ | :------------ |
| @Value  | 注入属性值,@Value("xx")返回值xx,@Value("${id}")返回id属性值  |
| @Component  | 注入为spring bean对象  |
| @ConfigurationProperties  | 注入配置（配置分组）  |

**配置文件占位符**
在配置文件中我们可以使用占位符取其他属性值、设置默认值或者随机数等
```yaml
id: ${random.uuid}
num: ${random.int(10)}
name: zhang
fullName: ${name}san
```

**实例**
application.yml
```yaml
projectname: springboot
user:
  userName: 开发环境用户
  age: 20
  info: "name:${user.userName},age:${user.age}"
```
pom.xml
```xml
<!--Java注释处理器生成自己的配置元数据文件-->
<!--针对ConfigurationProperties添加-->
<dependency>
	<groupId> org.springframework.boot </groupId>
	<artifactId> spring-boot-configuration-processor </artifactId>
	<optional> true </optional>
</dependency>
```
UserProperties
```java
@Component("userProperties")
@ConfigurationProperties(prefix = "user")
public class UserProperties {

    /** 用户名. */
    private String userName;
    /** 年龄. */
    private Integer age;
    /** 简介. */
    private String info;
	
	get,set...
}
```
UserController
```java
@RestController
public class UserController {

    /** 注入单个配置属性. */
    @Value("${projectname}")
    private String projectname;

    /** 注入一组配置属性. */
    @Autowired
    private UserProperties userProperties;

    @RequestMapping(value="/getUser",method = RequestMethod.GET)
    public String getUser(){
        return userProperties.getInfo();
    }
}
```

## 多环境配置
**开发环境和生产环境的切换**
application.yml
```yaml
# dev 为使用开发环境配置application-dev.yml
# prod 为使用生产环境配置application-prod.yml
spring:
  profiles:
    active: dev
```
application-dev.yml
```yaml
# 开发环境
user:
  userName: 开发环境用户
  age: 20
  info: "name:${user.userName},age:${user.age}"
```
application-prod.yml
```yaml
# 生产环境
user:
  userName: 生产环境用户
  age: 25
  info: "name:${user.userName},age:${user.age}"
```
**命令启动时可以带上参数**
`java -jar xx.jar --spring.profiles.active=prod`

## Controller的使用
| 注解  |  解释 |
| :------------ | :------------ |
| @Controller  | 处理http请求,和@ResponseBody一起使用或者使用模板  |
| @RestController  | Spring4之后新加的注解，返回json，等同于@ResponseBody加上@Controller  |
| @RequestMapping| 配置url映射|
| @Pathvariable| 获取url中的数据|
| @RequestParam| 获取请求参数的值|
| @GetMapping| 组合注解，还有@PostMapping、@PutMapping等|

**实列**
@Controller和@ResponseBody的一起使用
```java
@Controller
@ResponseBody
public class DeptController {
    @RequestMapping(value="/getDept",method = RequestMethod.GET)
    public String getDept(){
        return "dept";
    }
}
```
@RestController的使用
```java
@RestController
@RequestMapping("/dept")//添加类的访问路径
public class DeptController {
    //多个路径"/getDept"和"/dept"都可以访问该方法
	@RequestMapping(value={"/getDept","/queryDept"},method = RequestMethod.GET)
	public String getDept(){
	return "dept";
	}
}
```
@Pathvariable的使用
```java
//访问http://localhost:8080/springboot/dept/getDept/26 获取参数
@RequestMapping(value="/getDept/{id}",method = RequestMethod.GET)
	public String getDept(@PathVariable("id") Integer deptId){
	return "id= "+deptId;
}
```
@RequestParam的使用
```java
//访问http://localhost:8080/springboot/dept/getDept?id=25 获取参数
@RequestMapping(value="/getDept",method = RequestMethod.GET)
	public String getDept(@RequestParam("id") Integer deptId){
	return "id= "+deptId;
}
```
@RequestParam设置默认值
```java
//访问http://localhost:8080/springboot/dept/getDept?id=25 获取参数
@RequestMapping(value="/getDept",method = RequestMethod.GET)
	public String getDept(@RequestParam(value="id",required = false,defaultValue = "20") Integer deptId){
	return "id= "+deptId;
}
```
**等效于@GetMapping的使用**
```java
//访问http://localhost:8080/springboot/dept/getDept?id=25 获取参数
@GetMapping(value="/getDept")
	public String getDept(@RequestParam(value="id",required = false,defaultValue = "20") Integer deptId){
	return "id= "+deptId;
}
```
## 连接数据库
application.yml
```yaml
spring:
  profiles:
    active: dev
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/db_springboot
    username: root
    password: 123456
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

## JpaRepository的使用
不需要IUserDao实现类UserDaoImpl，直接调用findAll()、getOne(id)等方法
```java
public interface IUserDao extends JpaRepository<User,Integer> {
    /** 自定义方法，按照getXxByMm格式. */
    List<User> getUserByName(String name);
}
```


**RESTfull GET 获取**
```java
@GetMapping(value="/listUser")
public List<User> listUser() {
	return userDao.findAll();
}

@GetMapping(value="/getUser")
public User getUser(@RequestParam("id") Integer id){
	return userDao.getOne(id);
}

@GetMapping(value="/getUserByName")
public List<User> getUser(@RequestParam("name") String name){
	//自定义的方法
	return userDao.getUserByName(name);
}
```
**RESTfull POST 创建**
```java
@PostMapping(value="/saveUser")
public User saveUser(@RequestParam("name") String name,@RequestParam("sex") Integer sex){
	User user = new User();
	user.setName(name);
	user.setSex(sex);
	return userDao.save(user);
}
```
**RESTfull PUT 更新**
可创建可更新
```java
@PutMapping(value="/updateUser")
public User updateUser(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("sex") Integer sex){
	User user = new User();
	user.setId(id);
	user.setName(name);
	user.setSex(sex);
	return userDao.save(user);
}
```
**RESTfull DELETE 更新**
```java
@DeleteMapping("/deleteUser")
public void deleteUser(@RequestParam("id") Integer id){
	userDao.deleteById(id);
}
```
## 事务管理
@Transactional
