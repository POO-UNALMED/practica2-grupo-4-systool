package excepciones;

public class ErrorAplicacion extends Exception {

	private String titulo = "";
	
	public ErrorAplicacion() {
		this.setTitulo("Manejo de errores de la Aplicación: ");
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

//	public ErrorAplicacion(String arg0) {
//		super(arg0);
//		// TODO Auto-generated constructor stub
//	}
//
//	public ErrorAplicacion(Throwable arg0) {
//		super(arg0);
//		// TODO Auto-generated constructor stub
//	}
//
//	public ErrorAplicacion(String arg0, Throwable arg1) {
//		super(arg0, arg1);
//		// TODO Auto-generated constructor stub
//	}
//
//	public ErrorAplicacion(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
//		super(arg0, arg1, arg2, arg3);
//		// TODO Auto-generated constructor stub
//	}

}
