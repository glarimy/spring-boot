package com.glarimy.spring.directory.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.spring.directory.api.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Set<Employee> findByNameContaining(String name);
}
