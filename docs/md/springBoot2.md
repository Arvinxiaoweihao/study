# SpringBoot2.0.5进阶
## 表单验证
@Valid 验证属性
```java
@Min(value=50,message = "人数不能少于50人")
private Integer num;
```
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