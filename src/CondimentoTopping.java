
public class CondimentoTopping extends CondimentoDecorator {
	CondimentoTopping(Bebida b){
		nombre = b.getNombre() + " + Topping gratis";
		precio=b.getPrecio()+0;
	}
	
}
