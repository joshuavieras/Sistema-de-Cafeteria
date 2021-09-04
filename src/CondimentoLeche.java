
public class CondimentoLeche extends CondimentoDecorator {
	public CondimentoLeche(Bebida b) {
        nombre = b.getNombre() + " con Leche al vapor";
        precio=b.precio+500;
    }
}
