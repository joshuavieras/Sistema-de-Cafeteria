package StarbuzzApp;

public class CondimentoLeche extends CondimentoDecorator {
	Bebida b;
	public CondimentoLeche(Bebida b) {
		this.b=b;
        nombre = b.getNombre() + " con Leche al vapor";
        precio=b.precio+500;
    }
	@Override
	public String getDescripción() {
		// TODO Auto-generated method stub
		return b.getNombre()+", Leche al Vapor";
	}
}
