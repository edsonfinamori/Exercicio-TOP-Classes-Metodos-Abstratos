package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <TaxPayer> list = new ArrayList<> ();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExp = sc.nextDouble();
				Individual ind = new Individual (name, anualIncome, healthExp);
				list.add(ind);
			}
			else {
				System.out.print("Number of employees: ");
				int numberEmp = sc.nextInt();
				Company comp = new Company(name, anualIncome, numberEmp);
				list.add(comp);
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer tx : list) {
			System.out.println(tx.getName() + ": $ " + String.format("%.2f", tx.tax()));
		}
		
		System.out.println();
		
		Double sum = 0.0;
		for (TaxPayer txTotal : list) {
			sum += txTotal.tax();
		}
		System.out.print("TOTAL TAXES: $ " + String.format("%.2f", sum));
			
		sc.close();
	}
}