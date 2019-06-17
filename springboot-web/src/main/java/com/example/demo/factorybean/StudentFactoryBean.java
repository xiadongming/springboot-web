package com.example.demo.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class StudentFactoryBean implements FactoryBean<Student>{

	private String name;
	private String age;
	@Override
	public Student getObject() throws Exception {
		return new Student(name,age);
	}
	@Override
	public Class<?> getObjectType() {
		return Student.class;
	}
	@Override
	public boolean isSingleton() {
		return true;
	}

}
