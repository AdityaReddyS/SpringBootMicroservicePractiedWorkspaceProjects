package com.shankar.repo;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shankar.model.Department;
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
	@Query("select deptno from Department")
	public List<Object> getAllDeptNo();

}
