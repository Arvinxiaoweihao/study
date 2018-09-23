# SpringBoot2.0.5进阶
## 表单验证
@Valid 验证属性
```java
@Min(value=50,message = "人数不能少于50人")
private Integer num;
```
**方法中添加BindingResult参数 得到验证返回结果**
```java
PostMapping(value="/saveDept")
	public Dept saveDept(@Valid Dept dept, BindingResult bindingResult){
	//bindingResult为验证结果
	if(bindingResult.hasErrors()){
		System.out.println(bindingResult.getFieldError().getDefaultMessage());
		return null;
	}
	return deptService.saveDept(dept);
}
```
## AOP切面编程
| 注解  | 说明  |
| :------------ | :------------ |
| @Before  | 被拦截方法之前执行  |
| @After  | 被拦截方法之后执行  |
|@AfterReturning | 拦截方法返回结果|
|@Aspect | 声明切面类  |
|@Pointcut | 声明切入点 |

表达式：`execution(public * 包路径.类名.方法名(参数))`
类中所有方法，及方法对应所有参数都被拦截：`execution(public * 包路径.类名.*(..))`
**方法中添加JoinPoint参数 得到切入点信息**
**@AfterReturning方法添加返回结果Object参数**

```java
@Aspect
@Component
public class DeptAspect {

    /** 日志. */
    private static final  Logger LOGGER = LoggerFactory.getLogger(DeptAspect.class);

    @Before("execution(public * com.thunisoft.springboot.controller.DeptController.*(..))")
    public void dealBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("url={}",request.getRequestURL());
        //请求方式
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("ip={}",request.getRemoteAddr());
        //类方法
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        LOGGER.info("args={}",joinPoint.getArgs());

    }

    @After("execution(public * com.thunisoft.springboot.controller.DeptController.*(..))")
    public void dealAfter(){
        LOGGER.info("listDept方法之后执行");
    }

    @AfterReturning(returning = "object",pointcut = "execution(public * com.thunisoft.springboot.controller.DeptController.*(..))")
    public void afterReturning(Object object){
        LOGGER.info("result={}",object);
    }
}
```
**@Pointcut有两种用法：**
1. 直接在切入方法上声明，@Before等指向相应的切入方法
2. 在空方法上声明，该方法内代码不会被调用，如下
```java
@Aspect
@Component("userAspect")
public class UserAspect {

    /** 日志. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAspect.class);

    @Pointcut("execution(public * com.thunisoft.springboot.controller.UserController.*(..))")
    public void deal(){
        //该方法类代码得不到执行
    }

    @Before("deal()")
    public void dealBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("url={}",request.getRequestURL());
        //请求方式
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("ip={}",request.getRemoteAddr());
        //类方法
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    @After("deal()")
    public void dealAfter(){
        LOGGER.info("dealAfter");
    }

    @AfterReturning(returning = "object",pointcut = "deal()")
    public void afterReturning(Object object){
        LOGGER.info("result={}",object);
    }
}
```
## 异常处理
| 注解  | 说明  |
| ------------ | ------------ |
| @ControllerAdvice  | 全局异常拦截，类似@Controller和@ResponseBody一起使用  |
| @ExceptionHandler  | 异常处理  |

DeptController类中
```java
@GetMapping(value="getDept")
    public Object getDept(@RequestParam("id") Integer id) throws Exception {
        Object dept = deptService.getDept(id);
        return ResultUtil.successResult(dept);
    }
```
DeptServiceImpl类中
```java
public Object getDept(Integer id) {
        Dept dept = deptDao.getOne(id);
        Integer num = dept.getNum();
        if(num < 5){
            throw new DeptException(DeptResultEnum.FAILED_LESS_FIVE);
        }else if(5 <= num && num <= 50){
            throw new DeptException(DeptResultEnum.FAILED_LESS_FIFTY);
        }
        return dept;
    }
```
```java
public class DeptException extends RuntimeException {

    /** code值. */
    private Integer code;

    public DeptException(DeptResultEnum deptResultEnum) {
        super(deptResultEnum.getMessage());
        this.code = deptResultEnum.getCode();
    }
	...
}
```
```java
public enum  DeptResultEnum {

    SUCCESS(0,"成功"),FAILED(1,"失败"),
    FAILED_LESS_FIVE(2,"人数不能少于5人"),FAILED_LESS_FIFTY(3,"人数不够，尽快扩充"),
    FAILED_UNKNOWN(4,"未知错误");

    /** code值. */
    private Integer code;
    /** 提示信息. */
    private String message;

     DeptResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
	...
}
```
```java
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    /** 日志. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value=Exception.class)
    public Result deptExceptionHandle(Exception e){
        if(e instanceof DeptException){
            DeptException deptException = (DeptException) e;
           return  ResultUtil.failedResult(deptException.getCode(),deptException.getMessage());
        }
        //查询不到结果时
        if(e instanceof EntityNotFoundException){
            return ResultUtil.successResult();
        }
        LOGGER.error("系统异常",e);
        return ResultUtil.failedResult(DeptResultEnum.FAILED_UNKNOWN.getCode(),DeptResultEnum.FAILED_UNKNOWN.getMessage());
    }
}
```
```java
public class ResultUtil {

    /**
     * 返回成功
     * @param object 返回内容
     * @return
     */
    public static Result successResult(Object object){
        Result result = new Result();
        result.setCode(DeptResultEnum.SUCCESS.getCode());
        result.setMessage(DeptResultEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 返回成功
     * @return
     */
    public static Result successResult(){
        return successResult(null);
    }

    /**
     * 返回失败
     * @param code code值
     * @param message 提示信息
     * @return
     */
    public static Result failedResult(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
```
```java
public class Result {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String message;

    /** 结果数据. */
    private Object data;
	...
}
```
## 单元测试
| 注解  | 说明  |
| :------------ | :------------ |
| @RunWith  | 运行环境，通常是 @RunWith(SpringRunner.class) |
| @SpringBootTest  | 启用整个springboot工程  |
| @AutoConfigureMockMvc | 自动模拟对象|

**service类上使用时，方法上加@Transactional**
否则报错 could not initialize proxy - no Session; 基于JPA的实现来分析，就是在进行数据库访问之时，我们使用懒加载加载数据的方法，当我们要获取的数据的时候，当前针对数据库的访问与操作session已经关闭且释放了，故提示no Session可用
```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceImplTest {

    @Autowired
    private IDeptService deptService;

    @Test
    @Transactional
    public void getDept() throws Exception {
        Dept dept = (Dept) deptService.getDept(13);
        Assert.assertEquals(Integer.valueOf(60),dept.getNum());
    }
}
```
**Controller类上使用时**
```java
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DeptControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void listDept() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/dept/listDept"))//根据访问路径全流程验证
                .andExpect(MockMvcResultMatchers.content().string("abc"))//期望结果，返回内容abc
                .andExpect(MockMvcResultMatchers.status().isOk());//期望结果,返回状态值
    }
}
```

