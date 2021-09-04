
public class Main {
	static void printBeverage(Bebida b) {
        System.out.println("Bebida: " + b.getNombre()+ ", Precio: " + b.getPrecio());
    }
	public static void main(String args[]) throws Exception {
		Bebida expresso = new Expresso();
		Bebida darkroast = new DarkRoast();
		Bebida houseBlend = new HouseBlend();
		Bebida decaf = new Decaf();

        printBeverage(expresso);
        printBeverage(houseBlend);
        printBeverage(darkroast);
        printBeverage(decaf);
        CondimentoLeche Capuccino= new CondimentoLeche(expresso);
        
        printBeverage(Capuccino);
        
        System.out.println("========================");
    }
}
