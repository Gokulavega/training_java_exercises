package training_java_question7;

import java.util.Arrays;
import java.util.Objects;

public class Company {
	
	private String companyName;
	private Department[] depts;
	public Company() {
	}
	public Company(String companyName, Department[] depts) {
		super();
		this.companyName = companyName;
		this.depts = depts;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Department[] getDepts() {
		return depts;
	}
	public void setDepts(Department[] depts) {
		this.depts = depts;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(depts);
		result = prime * result + Objects.hash(companyName);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(companyName, other.companyName) && Arrays.equals(depts, other.depts);
	}
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", depts=" + Arrays.toString(depts) + "]";
	}
	
	public Employee[] getEmployeesByDept(int deptId) {
		for(Department dep: depts) {
			if(dep.getDeptId() == deptId) 
				return dep.getEmps();
		}
		return null;
	}

	public Employee[] getEmployeesBySalary(double salary) {
		int count = 0;
		Employee[] emps = new Employee[8];
		for(Department dep: depts) {
			for(Employee emp : dep.getEmps()) {
				if(emp.getSalary() ==  salary)
					emps[count++] = emp;
			}
		}
		return emps;
	}

	public Employee[] getEmployeesByDesignation(String name) {
		int count = 0;
		Employee[] emps = new Employee[8];
		for(Department dep: depts) {
			for(Employee emp : dep.getEmps()) {
				if(emp.getDesignation().equals(name))
					emps[count++] = emp;
			}
		}
		return emps;
	}

}
