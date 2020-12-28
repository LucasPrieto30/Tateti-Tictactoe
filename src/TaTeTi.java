

import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import java.awt.*;

public class TaTeTi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPrincipal marco1 =new MarcoPrincipal();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoPrincipal extends JFrame {
	
	public MarcoPrincipal() {
		
		setTitle("Tic tac toe");
		setBounds(540,200,400,400);
		setVisible(true);
		LaminaPrincipal lamina = new LaminaPrincipal();
		add(lamina);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/icon/tateti.png"));
	}
	
}

class LaminaPrincipal extends JPanel {
	
	public LaminaPrincipal() {
		
		setBackground(Color.blue);
		JPanel lamina_juego =new JPanel();
		JPanel lamina_restart=new JPanel();
		setLayout(new BorderLayout());
		
		boton1= new JButton();
		boton2= new JButton();
		boton3= new JButton();
		boton4= new JButton();
		boton5= new JButton();
		boton6= new JButton();
		boton7= new JButton();
		boton8= new JButton();
		boton9= new JButton();
		restart= new JButton("Restart");
		restart.setEnabled(false);
		
		boton1.addActionListener(new Seleccion());
		boton2.addActionListener(new Seleccion());
		boton3.addActionListener(new Seleccion());
		boton4.addActionListener(new Seleccion());
		boton5.addActionListener(new Seleccion());
		boton6.addActionListener(new Seleccion());
		boton7.addActionListener(new Seleccion());
		boton8.addActionListener(new Seleccion());
		boton9.addActionListener(new Seleccion());
		restart.addActionListener(new RestartGame());
		
		lamina_juego.setLayout(new GridLayout(3,3));
		lamina_juego.add(boton1);
		lamina_juego.add(boton2);
		lamina_juego.add(boton3);
		lamina_juego.add(boton4);
		lamina_juego.add(boton5);
		lamina_juego.add(boton6);
		lamina_juego.add(boton7);
		lamina_juego.add(boton8);
		lamina_juego.add(boton9);
		lamina_restart.add(restart);
		add(lamina_restart,BorderLayout.SOUTH);
		add(lamina_juego,BorderLayout.CENTER);
		turno =0;
		opciones=9;
	}
	
	private class Seleccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton clickeado = (JButton) e.getSource();
			if (turno%2 ==0) {
				clickeado.setText("X");
				clickeado.setBackground(Color.red);
				clickeado.setEnabled(false);
			}else {
				clickeado.setText("O");
				clickeado.setBackground(Color.blue);
				clickeado.setEnabled(false);
			}
			turno++;
			opciones--;
			
			if (opciones==0) {
				boton5.setText("GAME OVER");
				restart.setEnabled(true);
			}

		}
		
	}
	
	private class RestartGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton boton = (JButton) e.getSource();
			boton.setEnabled(false);
			reseteaBotones();
			
		}
		
		public void reseteaBotones() {
			
			boton1.setEnabled(true);
			boton1.setText("");
			boton1.setBackground(null);
			
			boton2.setEnabled(true);
			boton2.setText("");
			boton2.setBackground(null);
			
			boton3.setEnabled(true);
			boton3.setText("");
			boton3.setBackground(null);
			
			boton4.setEnabled(true);
			boton4.setText("");
			boton4.setBackground(null);
			
			boton5.setEnabled(true);
			boton5.setText("");
			boton5.setBackground(null);
			
			boton6.setEnabled(true);
			boton6.setText("");
			boton6.setBackground(null);
			
			boton7.setEnabled(true);
			boton7.setText("");
			boton7.setBackground(null);
			
			boton8.setEnabled(true);
			boton8.setText("");
			boton8.setBackground(null);
			
			boton9.setEnabled(true);
			boton9.setText("");
			boton9.setBackground(null);
			turno=0;
			opciones=9;
			
		}
		
	}
	int turno;
	int opciones;
	JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,restart;
	
}

class LaminaGameOver extends JPanel{
	
	public LaminaGameOver() {
		
		setBackground(Color.magenta);
		JLabel gameover=new JLabel("GAME OVER");
		add(gameover);
		
	}
	
}
