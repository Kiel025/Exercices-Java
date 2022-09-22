package map.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> candidates = new HashMap<>();

		System.out.print("Enter file full path: ");
		String path = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				Integer votes = Integer.parseInt(fields[1]);
				if (!candidates.containsKey(fields[0])) {
					candidates.put(fields[0], votes);
				} else {
					candidates.put(fields[0], candidates.get(fields[0]) + votes);
				}
				line = br.readLine();
			}
			
			for (String s : candidates.keySet()) {
				System.out.println(s + ": " + candidates.get(s));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}

	}

}
