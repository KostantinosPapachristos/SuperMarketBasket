//Κωνσταντίνος Παπαχρήστος
package Project;

import java.util.Scanner;

public class SuperMarket {
	
	static SuperMarketBasket basket = new SuperMarketBasket(); 
    
	public static void main(String[] args) {
		//Αρχικοποίηση μεταβλητών
		Scanner valueToChange = new Scanner(System.in);
		Scanner scanChoice = new Scanner(System.in);  //Scanner της επιλογής λειτουργίας
		Scanner scanProduct = new Scanner(System.in);  //Scanner των προϊόντων
		Scanner enterToContinue = new Scanner(System.in); //Scanner για την συνέχεια μετά την αλλαγή γραμμής
		int choice = 1;
		String product = "";
		
		
		//υλοποίηση εφαρμογής
		System.out.println("Welcome To My SuperMarket\n");
		do {
			//Λειτουργίες εφαρμογής
			System.out.println("Please Select a Number:");
			System.out.println("0:Close App");
			System.out.println("1:Insert Into Basket");
			System.out.println("2:Delete From Basket");
			System.out.println("3:Change Product From Basket");
			System.out.println("4:Find Product In Basket");
			choice = scanChoice.nextInt();
			
			//Υλοποίηση κάθε λειτουργίας
			if (choice == 0){
				System.out.println("Bye Bye");
				printList();
			}
			else if (choice == 1) {
				System.out.println("Please insert a Product into the Basket:\n");
				product = scanProduct.nextLine();
				insertProduct(product);
				enterToContinue.nextLine();
			}
			else if (choice == 2) {
				System.out.println("Please delete a product from the Basket: \n");
				product = scanProduct.nextLine();
				deleteProduct(product);
				enterToContinue.nextLine();
			}
			else if (choice == 3) {
				System.out.println("Please enter the name of the product you want to change: \n");
				product = scanProduct.nextLine();
				System.out.println("Please enter the product to change to: ");
				String productToChange = valueToChange.nextLine();
				
				
				
				changeProduct(product, productToChange);
				enterToContinue.nextLine();
			}
			else if (choice == 4) {
				System.out.println("Please search a product from the basket: \n");
				product = scanProduct.nextLine();
				searchProduct(product);
				enterToContinue.nextLine();
			}
			else {
				System.out.println("The Choice: " + choice + " is not correct please try again\n");
			}
			product ="";
		}
		while(choice!= 0);
	}
	
	//Τελική λίστα
	public static void printList() {
		System.out.println("Your Ending list of products is: ");
		SuperMarketBasket.printBasket();
	}
	
	//Μέθοδος για εισαγωγή προϊόντων στο καλάθι.
	public static void insertProduct(String product) {
		boolean resultOfInsert = SuperMarketBasket.insertProductIntoBasket(product);
		if(resultOfInsert == true) {
			System.out.println("Product: " + product + " got inserted\n");
			System.out.println("Press enter to continue... ");
		}
		else {
			System.out.println("The Basket is Full \n");
			System.out.println("Press enter to continue... ");
		}
	}
	
	//Μέθοδος για διαγραφή προϊόντων στο καλάθι.
	public static void deleteProduct(String product){
		boolean resultOfDelete = basket.deleteProductFromBasket(product);
		if(resultOfDelete == true) {
			System.out.println("Product: " + product + " got deleted\n");
			System.out.println("Press enter to continue... ");
			}
		else {
			System.out.println("Couldn't find: " + product + " in the basket\n");
			System.out.println("Press enter to continue... ");
			
		}
	}
	
	//Μέθοδος για αλλαγή προϊόντων στο καλάθι.
	public static void changeProduct(String product, String product1) {
		boolean result = basket.changeProductFromBasket(product, product1);
		if(result == true) {
			System.out.println("Product: " + product + " got changed\n");
			System.out.println("Press enter to continue... ");
		}
		else {
			System.out.println("The product was not found to change");
			System.out.println("Press enter to continue... ");
		}
	}
	
	//Μέθοδος για την εύρεση των προϊόντων στο καλάθι
	public static void searchProduct(String product) {
		boolean result = basket.searchProductFromBasket(product);
		if(result == true) {
			System.out.println("Found " + product + " in the basket\n");
			System.out.println("Press enter to continue... ");	
		}
		else{
			System.out.println("The product was not found\n");
			System.out.println("Press enter to continue... ");
		}
	}
}
