package StarbuzzApp;

public class CondimentoTopping extends CondimentoDecorator {
	private Bebida b;
	CondimentoTopping(Bebida b){
		this.b=b;
		nombre = b.getNombre() + " , Topping";
	}

	@Override
	public String getDescripción() {
		// TODO Auto-generated method stub
		return b.getNombre()+", Topping";
	}
	
}
