package StarbuzzApp;

public abstract class Bebida {
	protected String nombre="";
	protected int precio;
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Bebida() {
	}
	public  String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precio;
	}
}
