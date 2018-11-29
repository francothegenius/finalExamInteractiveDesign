//Francisco Mariano Amézquita Ramos A01634495
package figuras.increibles;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo extends Figura {

	public Circulo(int x, int y, int tipo, Color color) {
		super(x, y, tipo, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibujar(Graphics g) {
		

		g.setColor(getColor());
		g.drawOval(getX(), getY(), 100, 100);
	}

}
