
public class CondimentoMoca extends CondimentoDecorator {
	CondimentoMoca(Bebida b){
		nombre = b.getNombre() + " + Moca";
		precio=b.precio+500;
	}

}
