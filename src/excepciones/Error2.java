package excepciones;

import javafx.scene.control.TextField;

public class Error2 extends ErrorAplicacion {

	private String salida = "";
	private int dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String titulo;
	private String email;
	private boolean esNum;

	public Error2() {
		// TODO Auto-generated constructor stub
	}

	public Error2(int n) {
		if (n == 1) { // VERIFICAR QUE SI HAYAN 10 ESTUDIANTES PARA mejoresColegio()
			salida = "Usted no ha creado estudiantes o no tiene mínimo 10 estudiantes, por favor vaya a la sección de crear estudiantes.";
		}
	}

	public Error2(TextField creEs1, TextField creEs2, TextField creEs3, TextField creEs4, TextField creEs5,
			TextField crePro6) {
		// VERIFICA QUE EN LOS CAMPOS NUMÉRICOS SÍ SE INGRESEN SÓLO NÚMEROS PARA PROFESOR
		try {
			dni = Integer.parseInt(creEs1.getText());
			nombre = creEs2.getText();
			apellido = creEs3.getText();
			edad = Integer.parseInt(creEs4.getText());
			titulo = creEs5.getText();
			email = creEs5.getText();
			esNum = true;
		} catch (NumberFormatException e) {
			esNum = false;
		}
	}

	public Error2(TextField creGr1, TextField creGr2) {
		// VERIFICA QUE EN LOS CAMPOS NUMÉRICOS SÍ SE INGRESEN SÓLO NÚMEROS PARA GRADO
		try {
			dni = Integer.parseInt(creGr1.getText());
			nombre = creGr2.getText();
			esNum = true;
		} catch (NumberFormatException e) {
			esNum = false;
		}
	}
	
	public Error2(TextField crAs1, TextField crAs2, TextField crAs3) {
		// VERIFICA QUE EN LOS CAMPOS NUMÉRICOS SÍ SE INGRESEN SÓLO NÚMEROS PARA ASIGNATURA
		try {
			dni = Integer.parseInt(crAs1.getText());
			nombre = crAs2.getText();
			edad = Integer.parseInt(crAs3.getText());
		}catch (NumberFormatException e) {
			esNum = false;
		}
	}
	
	public Error2(TextField crNo1,TextField crNo2,TextField crNo3, String n) {
		
	}

	public String getSalida() {
		return salida;
	}

	public boolean isEsNum() {
		return esNum;
	}

}
