package com.burakguclu.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.burakguclu.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList(){
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "Ahmet", "Zafer"));
		employeeList.add(new Employee("2", "Berke", "Yıldız"));
		employeeList.add(new Employee("3", "Cemal", "Yılmaz"));
		employeeList.add(new Employee("4", "Deniz", "Konyalı"));
		employeeList.add(new Employee("5", "Eda", "Bardakçı"));
		
		return employeeList;
	}
	
}
