package StarbuzzApp;

public class CondimentoSoja extends CondimentoDecorator {
	private Bebida b;
	CondimentoSoja(Bebida b){
		nombre = b.getNombre() + " con Soja";
		precio=b.precio+500;
	}
	
	@Override
	public String getDescripción() {
		// TODO Auto-generated method stub
		return b.getNombre()+", Soja";
	}
}
