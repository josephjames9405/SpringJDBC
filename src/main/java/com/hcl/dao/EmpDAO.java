package com.hcl.dao;

import java.util.List;



import com.hcl.model.Emp;

public interface EmpDAO {
	Emp getEmpById(Integer id);

	List<Emp> getAllEmps();

	boolean deleteEmp(Emp emp);

	boolean updateEmp(Emp emp);

	boolean createEmp(Emp emp);

}
