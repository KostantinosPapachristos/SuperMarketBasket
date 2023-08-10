package Project;

public class SuperMarketBasket {
	private static String[] basket;
	
	private static int nextAvailable;
	// constractor
	public SuperMarketBasket() {
		basket = new String[50]; 
		nextAvailable = 0;
	}
	
	
	public static void printBasket() {
		for(int i=0; i<nextAvailable; i++) {
			System.out.println(basket[i]);
		}
	}
	
	//Υλοποίηση της εισαγωγής προϊόντων
	public static boolean insertProductIntoBasket(String product) {
		if(nextAvailable>50) {
			return false;
		}
		else {
			basket[nextAvailable] = product;
			nextAvailable++;
			return true;
		}
	}
	
	//Υλοποίηση της διαγραφής προϊόντων
	public static boolean deleteProductFromBasket(String product) {
		for(int i = 0;i<nextAvailable;i++) {
			if(basket[i].equals(product)) {
				basket[i]=basket[nextAvailable];
				basket[nextAvailable]="";
				nextAvailable--;
				return true;
			}
		}
		return false;
	}
	
	//Υλοποίηση της αλλαγής προϊόντων
	public static boolean changeProductFromBasket(String product, String product1) {
		boolean entered = false;
		for(int i = 0;i<nextAvailable;i++) {
			if(basket[i].equals(product)) {
				basket[i] = product1;
				entered = true;
			}
		}
		return entered;
	}
	
	
	//Υλοποίηση της εύρεσης προϊόντων
	public static boolean searchProductFromBasket(String product) {
		 for(int i=0; i<50; i++) {
			 if(product.equals(basket[i])) {
				 return true;
			 }
		 }
		 return false;
	}
}
