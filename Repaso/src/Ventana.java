import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Ventana extends JFrame implements MouseInputListener{
	
	public Ventana() {
		setTitle("Dibujo");
		setSize(400, 400);
		setLocation(200, 200);
		addMouseListener(this);
		addMouseMotionListener(this);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.black);
		g.drawLine(10, 10, 100, 100);
		g.fillRect(70, 70, 100, 100);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// down + up en un rango de tiempo 
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//bajo el boton
		System.out.println(e.getX()+"");
		System.out.println(e.getY()+"");
		
		//solicita repintado
		repaint();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// subio el boton
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//entro en un area
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// salio del area
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// arrastrado - click + movimiento
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// movimiento -arrastrado - click
	}
	
	//recusrividad - 2 opciones con return de valor y sin el 
	
	public void contar(int inicio, int fin) {
		//caso base
		if(inicio > fin ) {
			return;
		}
		
		System.out.println(inicio);
		
		//invocar nuevamente considerando desplazamiento
		contar(inicio +1, fin);
	}
	
	public int sumatoria(int inicio, int fin) {
		
		if(inicio == fin){
			return inicio;
		}
		
		return inicio + sumatoria(inicio +1, fin);
		
	}

}
