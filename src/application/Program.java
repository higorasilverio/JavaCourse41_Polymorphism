package application;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		List<Product> products = new ArrayList<Product>();
		
		System.out.print("Enter the number of products: ");
		int number = input.nextInt();
		for (int control = 1; control <= number; control++) {
			System.out.println("Product #" + control + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			input.nextLine();
			char decision = input.nextLine().charAt(0);
			System.out.print("Name: ");
			String name = input.nextLine();
			System.out.print("Price: ");
			double price = input.nextDouble();
			if (decision == 'c') {
				products.add(new Product(name, price));
			}
			else if (decision == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(input.next());
				products.add(new UsedProduct(name, price, manufactureDate));
			}
			else if (decision == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = input.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			}
			else System.out.println("Invalid data entry!");
		}
		
		System.out.println();
		System.out.println("PRICE TAGS");
		for(Product prod : products) {
			System.out.println(prod.priceTag());
		}
		
		input.close();
	}

}
