package com.hcl;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hcl.config.AppConfig;
import com.hcl.dao.EmpDAO;
import com.hcl.model.Emp;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EmpDAO empDAO = ctx.getBean(EmpDAO.class);
		int ch=1;

		do {
			System.out.println("MENU\n1.ViewAll\n2.ViewEmployee\n3.Delete Record\n4.Update Record\n5.Insert Record");
			System.out.print("Enter your choice:");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("List of Employees:");
				for (Emp e : empDAO.getAllEmps()) {
					System.out.println(e);
				}
				break;
			case 2:
				System.out.print("Enter the empId:");
				int i = sc.nextInt();
				System.out.println(empDAO.getEmpById(i));
				break;
			case 3:
				System.out.print("Enter the employee id you need to delete:");
				i = sc.nextInt();
				empDAO.deleteEmp(empDAO.getEmpById(i));
				System.out.println("Delete Successful");
				break;
			case 4:
				System.out.println("Enter the id you want update");
				i = sc.nextInt();
				System.out.println("Enter Employee Name");
				String name = sc.next();
				System.out.println("Enter Salary");
				int sal = sc.nextInt();
				Emp e = empDAO.getEmpById(i);
				e.setEmpName(name);
				e.setEmpSal(sal);
				empDAO.updateEmp(e);
				break;
			case 5:
				System.out.println("Enter Employee Number:");
				int eno = sc.nextInt();
				System.out.println("Enter Employee Name:");
				name = sc.next();
				System.out.println("Enter Employee Salary:");
				sal = sc.nextInt();
				Emp e1 = new Emp();
				e1.setEmpId(eno);
				e1.setEmpName(name);
				e1.setEmpSal(sal);
				empDAO.createEmp(e1);
				System.out.println("Insert Successful");
				break;
			default:
				System.out.println("Invalid Entry");
				break;

			}
			System.out.println("Do you want to continue(1/0):");
			ch = sc.nextInt();
		} while (ch == 1);

	}

}
