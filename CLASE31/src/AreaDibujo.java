//Francisco Mariano Amézquita Ramos A01634495
import java.awt.Color;
import java.util.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import figuras.increibles.*;

public class AreaDibujo extends JPanel implements MouseListener, MouseMotionListener {
	
	private ConfiguradorDibujo config;
	private LinkedList<Figura> figuras;
	private int x1,y1,x0, y0, figura;
	
	
	
	public LinkedList<Figura> getFigura(){
		return figuras;
	}

	public AreaDibujo(ConfiguradorDibujo config) {
		
		addMouseListener(this);
		this.config = config;
		figuras = new LinkedList<>();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		// agregar varios dibujos es cuestión de manejar el arreglo figuras
		
		for(int i = 0; i < figuras.size(); i++) {
			figuras.get(i).dibujar(g);
		}
	
		switch(figura) {
			
			case ConfiguradorDibujo.CIRCULO:
				g.setColor(config.getColor());
				g.drawOval(x0, y0, x1-x0, y1-y0);
				break;
				
			case ConfiguradorDibujo.RECTANGULO:
				g.setColor(config.getColor());
				g.drawRect(x0, y0, x1-x0, y1-y0);
				break;
		}
	}
	
	public void abrir(File data) {
		LinkedList<Figura> datos;
		datos = new LinkedList<>();
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(data));
			String linea = in.readLine();
			while(linea != null) {
				String [] datosS = linea.split(",");
				for(int i = 0; i < datosS.length; i++) {
					
					int x = Integer.parseInt(datosS[0]);
					int y = Integer.parseInt(datosS[1]);
					int tipo = Integer.parseInt(datosS[2]);
					Color color = new Color(Integer.parseInt(datosS[3]), Integer.parseInt(datosS[4]), Integer.parseInt(datosS[5]));
					
					if(tipo == 0) {
						
						Circulo cir = new Circulo(x, y, tipo, color);
						datos.add(cir);
					} else if(tipo == 1){
						Rectangulo rec = new Rectangulo(x, y, tipo, color);
						datos.add(rec);
					} else if(tipo == 2) {
						Texto texto = new Texto(x, y, tipo, color);
						datos.add(texto);
					}
				}
				linea = in.readLine();
			}
			figuras = datos;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed");
		switch(config.getFigura()) {
		
		case ConfiguradorDibujo.CIRCULO:
			figuras.add(new Circulo(
					e.getX(),
					e.getY(), 
					ConfiguradorDibujo.CIRCULO,
					config.getColor()));
			break;
		
		case ConfiguradorDibujo.RECTANGULO:
			figuras.add(new Rectangulo(
					e.getX(),
					e.getY(), 
					ConfiguradorDibujo.RECTANGULO,
					config.getColor()));
			break;
		
		case ConfiguradorDibujo.TEXTO:
			figuras.add(new Texto(
					e.getX(),
					e.getY(), 
					ConfiguradorDibujo.TEXTO,
					config.getColor()));
			break;
		}
		repaint();
		
		x0 = e.getX();
		y0 = e.getY();
		figura = config.getFigura();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("released");

		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("entered");

		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("exited");
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		int tempX1= e.getX();
		int tempY1 = e.getY();
		repaint();
		
		if(tempX1 < x0) {
			x1 = x0;
			x0 = tempX1;
		}
		
		if(tempY1 < y0) {
			
			y1 = y0;
			y0 = tempY1;
			
		}
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
