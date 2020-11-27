package excepciones;

import javafx.scene.control.TextField;

public class Error1 extends ErrorAplicacion {

	private String salida = "";
	private int dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String acudiente;
	private boolean esNum;

	public Error1() {
	}

	public Error1(int n) {
		if (n == 2) { // VERIFICA QUE SÍ HAYAN DATOS CREADOS
			salida = "No hay creaciones registradas, por favor\r\nvaya a la sección de creación correspondiente.";
		} else if (n == 3) { // VERIFICA QUE SÍ EXISTAN REGISTROS CON EL DATO INGRESADO
			salida = "No se encuentran registros con el/los dato(s) ingresado(s).";
		} else if (n == 4) {
			salida = "Por favor complete todos los campos.";
		}
	}

	public Error1(TextField creEs1, TextField creEs2, TextField creEs3, TextField creEs4, TextField creEs5) {
		// VERIFICA QUE EN LOS CAMPOS NUMÉRICOS SÍ SE INGRESEN SÓLO NÚMEROS PARA ESTUDIANTE
		try {
			dni = Integer.parseInt(creEs1.getText());
			nombre = creEs2.getText();
			apellido = creEs3.getText();
			edad = Integer.parseInt(creEs4.getText());
			acudiente = creEs5.getText();
			esNum = true;
		} catch (NumberFormatException e) {
			esNum = false;
		}
	}

	public String getSalida() {
		return salida;
	}

	public boolean isA() {
		return esNum;
	}

}
