//Francisco Mariano Amézquita Ramos A01634495
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.swing.*;

import figuras.increibles.Figura;

public class Ventana extends JFrame {

	// constantes 
	// valores que no van a cambiar
	// normalmente utilizados cuando hay un valor recurrente
	public static final int EJEMPLO = 1;
	public static final int EJEMPLO_SEGUNDO = 2;
	
	private PanelBotones botones;
	private AreaDibujo areaDibujo;
	private JMenu menu;
	private JMenuItem guardar, abrir;
	private JMenuBar bar;
	private JFileChooser chooser;
	
	public Ventana() {
		super("PAINT");
		setSize(800,800);
		setLocation(200,200);
		
		botones = new PanelBotones();
		areaDibujo = new AreaDibujo(botones);
		
		botones.setAreaDibujo();
		
		chooser = new JFileChooser();
		
		//add(b1);
		setLayout(new BorderLayout());
		add(botones, BorderLayout.WEST);
		add(areaDibujo, BorderLayout.CENTER);
		
		guardar = new JMenuItem("Guardar");
		abrir = new JMenuItem("Abrir");
		
		menu = new JMenu("Archivo");
		bar = new JMenuBar();
		
		menu.add(guardar);
		menu.add(abrir);
		
		bar.add(menu);
		
		
		setJMenuBar(bar);
		
		guardar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int resultado = chooser.showSaveDialog(Ventana.this);
						if (resultado == JFileChooser.APPROVE_OPTION) {
							String path = chooser.getSelectedFile().getPath() + ".txt";
							try {
								FileWriter fw = new FileWriter(path);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter pw = new PrintWriter(bw);
								
								LinkedList<Figura> listaFiguras = areaDibujo.getFigura();
								for(int i = 0; i < listaFiguras.size(); i++) {
									pw.println(listaFiguras.get(i));
								}
								pw.close();
								
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						
					}
				});
		
		
		abrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int resultado = chooser.showOpenDialog(Ventana.this);
				
				if(resultado == JFileChooser.APPROVE_OPTION) {
					
					File archivo = chooser.getSelectedFile().getAbsoluteFile();
					areaDibujo.abrir(archivo);
					repaint(); 
				}
				
			}
		});
		
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	
}
