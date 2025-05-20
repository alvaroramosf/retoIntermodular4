package clases;

public class Guerrero extends Personaje{
	private static final int FUERZA = 15;
	private static final int DEFENSA = 10;
	private static final int POCIONES = 2;
	
	int pociones;
	
	public Guerrero(String nombre, int vida) {
		super(nombre, vida, FUERZA, DEFENSA);
		this.pociones = POCIONES;
	}
	
	@Override
	public void curar() {
		if(pociones > 0) {
			this.vida = this.vidaInicial;
			pociones --;
		}
	}
	
	@Override
	public void resetear() {
		pociones = POCIONES;
	}
	
	@Override
	public String toString() {
		return this.nombre + ": vida: " +this.vida + "/" + this.vidaInicial + "; Pociones:" + this.pociones;
	}
}
