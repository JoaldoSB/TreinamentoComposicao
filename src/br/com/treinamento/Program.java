package br.com.treinamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.treinamento.entities.Department;
import br.com.treinamento.entities.HourContract;
import br.com.treinamento.entities.Worker;
import br.com.treinamento.entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Enter department's name: ");
		String departmentoName = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base Salary: ");
		double workerSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerSalary, new Department(departmentoName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract # " +i +" data:");
			System.out.print("Date (DD/MM/YYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: " );
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			
			worker.addContract(contract);
		}
		
		System.out.println("----");
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("name: " +worker.getName());
		System.out.println("Department: " +worker.getDepartment().getNome());
		System.out.println("Income for " + monthAndYear +": " +String.format("%.2f",  worker.income(year, month)));
	}

}