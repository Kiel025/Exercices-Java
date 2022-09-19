package file.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import file.entities.Product;

public class ProgramFile {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();

		System.out.print("Enter a file path: ");
		String strPath = sc.nextLine();
		File file = new File(strPath);
		
		sc.close();
		
		boolean success = new File(file.getParent() + "/out").mkdir();
		
		File summary = new File(file.getParent() + "/out/summary.csv");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();

			while (line != null) {
				String[] atrs = line.split(",");
				products.add(new Product(atrs[0], Double.parseDouble(atrs[1]), Integer.parseInt(atrs[2])));
				line = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(summary))) {
				for (Product p : products) {
					bw.write(p.getName() + "," + String.format("%.2f", p.totalValue()));
					bw.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
