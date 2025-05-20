package clases;



public abstract class Personaje {
// estadisticas
	protected int vida;
	protected int vidaInicial;
	protected int ataque;
	protected int defensa;
	protected String nombre;

	public Personaje() {}

	public Personaje(String nombre, int vida, int ataque, int defensa) {
		this.nombre = nombre;
		this.vida = vida;
		this.vidaInicial = vida; // vidaInicial se iguala a vida
		this.ataque = ataque;
		this.defensa = defensa;
    }

	// Getters
	public int getVida() {
		return vida;
	}

	public int getVidaInicial() {
		return vidaInicial;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public String getNombre() {
		return nombre;
	}

    // Setters
	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setVidaInicial(int vidaInicial) {
		this.vidaInicial =vidaInicial;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
    }

	
	public void atacar(Personaje otro) {
	    int daño = (this.ataque - otro.getDefensa()) < 0 ? 0 : (this.ataque - otro.getDefensa());
	    otro.setVida(otro.getVida() - daño);
	}


	
	


	public void resetear() {
		this.vida = this.vidaInicial;
	}

	public boolean muerto() {
		return this.vida <= 0;
	}
	
	@Override
	public String toString() {
		return this.nombre + ": vida: " +this.vida + "/" + this.vidaInicial;
	}

}
