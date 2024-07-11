package Course.src.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Course.src.entities.Department;
import Course.src.entities.HourContract;
import Course.src.entities.Worker;
import Course.src.entities.enums.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter departament's name: ");
        String departamentName = sc.nextLine();
        System.out.print("Enter worker data: ");
        System.out.println("Name: ");
        String workerName = sc.nextLine();
        System.out.println("Level: ");
        String workerLevel = sc.nextLine();
        System.out.println("Base salaary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departamentName));

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        for(int i = 1; i<=n; i++){
            System.out.println("Enter contract #"+i+ " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duartion (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println("----------------");
        System.out.print("Enter month and year to calculate income (MM/YYYY) ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartment().getName());
        System.out.println("Income for "+ monthAndYear+": "+String.format("%.2f",worker.income(year,month)));

        sc.close();

    }
}
