
public class CondimentoSoja extends CondimentoDecorator {
	CondimentoSoja(Bebida b){
		nombre = b.getNombre() + " con Soja";
		precio=b.precio+500;
	}

}
