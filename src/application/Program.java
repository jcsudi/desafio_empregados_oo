package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Departament;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		Integer payDay = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		
		Departament dept = new Departament(departName, payDay, new Address(email, phone));
		
		System.out.print("Quantos funcionários tem o departamento? ");
		Integer departmentEmployees = sc.nextInt();
		
		for (int i = 0; i < departmentEmployees; i++) {
			sc.nextLine();
			System.out.println("Dados fo funcionário " + (i + 1));
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salário: ");
			Double salary = sc.nextDouble();
			
			Employee employee = new Employee(name, salary);
			
			dept.addEmployee(employee);	
			
		}
		
		showReport(dept);
		
		sc.close();
	}
		
	private static void showReport(Departament dept) {
		
        System.out.println();
		
		System.out.println("FOLHA DE PAGAMENTO");
		System.out.printf("Departamento de vendas R$ = %.2f%n", dept.payroll());
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionários: ");
		
		for(Employee e : dept.getEmployees()) {
			System.out.println(e.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());	
	
	}
}
