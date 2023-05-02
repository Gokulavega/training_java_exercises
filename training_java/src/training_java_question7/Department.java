package training_java_question7;

import java.util.Arrays;
import java.util.Objects;

public class Department {
	
	private int deptId;
	private String name;
	private Employee[] emps;
	
	
	public Department() {
	}


	public Department(int deptId, String name, Employee[] emps) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.emps = emps;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Employee[] getEmps() {
		return emps;
	}


	public void setEmps(Employee[] emps) {
		this.emps = emps;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(emps);
		result = prime * result + Objects.hash(deptId, name);
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
		Department other = (Department) obj;
		return deptId == other.deptId && Arrays.equals(emps, other.emps) && Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Departments [deptId=" + deptId + ", name=" + name + ", emps=" + Arrays.toString(emps) + "]";
	}

}
