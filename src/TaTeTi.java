

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
		seleccion_j1 =new JButton [5];
		seleccion_j2 =new JButton [5];
		posicion_j1=0;
		posicion_j2=0;
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
				seleccion_j1[posicion_j1]=clickeado;
				posicion_j1++;
			}else {
				clickeado.setText("O");
				clickeado.setBackground(Color.blue);
				clickeado.setEnabled(false);
				seleccion_j2[posicion_j2]=clickeado;
				posicion_j2++;
			}
			turno++;
			opciones--;
			win();
			if (win()) {
				boton5.setText(winner);
				gameOver();
				restart.setEnabled(true);
			}else if (opciones==0) {

				gameOver();
				restart.setEnabled(true);
			}

		}
		
		
		public boolean win() {
			
			if (boton1.getText().equals("X") && boton2.getText().equals("X") && boton3.getText().equals("X")) {
				winner="RED WINS";
				return true;	
			}else if(boton4.getText().equals("X") && boton5.getText().equals("X") && boton6.getText().equals("X")){
				winner="RED WINS";
				return true;
			}else if(boton7.getText().equals("X") && boton8.getText().equals("X") && boton9.getText().equals("X")){
				winner="RED WINS";
				return true;
			}else if(boton1.getText().equals("X") && boton4.getText().equals("X") && boton7.getText().equals("X")){
				winner="RED WINS";
				return true;
			}else if(boton2.getText().equals("X") && boton5.getText().equals("X") && boton8.getText().equals("X")){
				winner="RED WINS";
				return true;
			}else if(boton3.getText().equals("X") && boton6.getText().equals("X") && boton9.getText().equals("X")){
				winner="RED WINS";
				return true;
			}else if(boton1.getText().equals("X") && boton5.getText().equals("X") && boton9.getText().equals("X")){
				winner="RED WINS";
				return true;
			}else if(boton3.getText().equals("X") && boton5.getText().equals("X") && boton7.getText().equals("X")){
				winner="RED WINS";
				return true;
			
			}else if (boton1.getText().equals("O") && boton2.getText().equals("O") && boton3.getText().equals("O")) {
				winner="BLUE WINS";
				return true;
			}else if(boton4.getText().equals("O") && boton5.getText().equals("O") && boton6.getText().equals("O")){
				winner="BLUE WINS";
				return true;
			}else if(boton7.getText().equals("O") && boton8.getText().equals("O") && boton9.getText().equals("O")){
				winner="BLUE WINS";
				return true;
			}else if(boton1.getText().equals("O") && boton4.getText().equals("O") && boton7.getText().equals("O")){
				winner="BLUE WINS";
				return true;
			}else if(boton2.getText().equals("O") && boton5.getText().equals("O") && boton8.getText().equals("O")){
				winner="BLUE WINS";
				return true;
			}else if(boton3.getText().equals("O") && boton6.getText().equals("O") && boton9.getText().equals("O")){
				winner="BLUE WINS";
				return true;
			}else if(boton1.getText().equals("O") && boton5.getText().equals("O") && boton9.getText().equals("O")){
				winner="BLUE WINS";
				return true;
			}else if(boton3.getText().equals("O") && boton5.getText().equals("O") && boton7.getText().equals("O")){
				winner="BLUE WINS";
				return true;
			}
			
			else {
				return false;
			}
			
			
			
		}
		
		
	}
	
	public void gameOver () {
		
		boton1.setEnabled(false);
		boton2.setEnabled(false);
		boton3.setEnabled(false);
		boton4.setEnabled(false);
		boton5.setEnabled(false);
		boton6.setEnabled(false);
		boton7.setEnabled(false);
		boton8.setEnabled(false);
		boton9.setEnabled(false);
		
	}
	
	private class RestartGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton boton = (JButton) e.getSource();
			boton.setEnabled(false);

			seleccion_j1 =new JButton [5];
			seleccion_j2 =new JButton [5];
			posicion_j1=0;
			posicion_j2=0;
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
	JButton [] seleccion_j1 ;
	JButton [] seleccion_j2 ;
	String winner;
	int turno;
	int opciones;
	int posicion_j1;
	int posicion_j2;
	JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,restart;
	
}

