//Francisco Mariano Amézquita Ramos A01634495
package figuras.increibles;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
	
	private int x, y, tipo;
	private Color color;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getTipo() {
		return tipo;
	}

	public Color getColor() {
		return color;
	}

	public Figura(int x, int y, int tipo, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.tipo = tipo;
		this.color = color;
	}

	public abstract void dibujar(Graphics g);
	
	public String toString() {
		return x + "," + y + "," + tipo + "," + color.getRed() + "," + color.getGreen() + "," +
				color.getBlue();
	}
}
