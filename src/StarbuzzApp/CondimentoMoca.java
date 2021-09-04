package StarbuzzApp;

public class CondimentoMoca extends CondimentoDecorator {
	private Bebida b;
	CondimentoMoca(Bebida b){
		this.b=b;
		nombre = b.getNombre() + ", Moca";
		precio=b.precio+500;
	}
	@Override
	public String getDescripción() {
		// TODO Auto-generated method stub
		return b.getNombre()+", Moca";
	}

}
