package gestorAplicacion.perfiles;
import gestorAplicacion.academico.*;
import java.util.*;
import java.util.Map.Entry;

import BaseDatos.Serializacion;

import java.io.*;
//CLASE NECESARIA PARA EL PROYECTO EN SU TOTALIDAD
public class Estudiante extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	private String acudiente;
	private float promedio;
	private ArrayList <Nota> notas = new ArrayList <Nota>();
	private HashMap <Integer,Float> promedios = new HashMap <Integer,Float>();
	private static ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private Grado grado;
	private boolean ayuda = false;
	private final float rango= 3;
	
	public Estudiante (int DNI, String nombres, String apellidos, int edad, String acudiente){
		super(DNI, nombres, apellidos, edad);
		this.setAcudiente(acudiente);
		estudiantes.add(this);
		Serializacion.base_datos();
	}
	
	public  void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public  String getNombre() {
		return nombre;
	}
	public  void setApellido(String apellido) {
		this.apellido=apellido;
	}
	public  String getApellido() {
		return apellido;
	}
	public void setDNI(int DNI) {
		this.DNI=DNI;
	}
	public  int getDNI() {
		return DNI;
	}
	public  void setEdad(int edad) {
		this.edad=edad;
	}
	public  int getEdad() {
		return edad;
	}
	public void setAcudiente(String acudiente) {
		this.acudiente = acudiente;
	}
	public String getAcudiente() {
		return acudiente;
	}
	public float getPromedio() {
		return promedio;
	}public void setPromedio(float prom){
		this.promedio = prom;
	}
	public void setNotas(ArrayList <Nota> notas){
		this.notas = notas;
	}
	public ArrayList <Nota> getNotas (){
		return notas;
	}
	public void setGrado (Grado grado) {
		this.grado = grado;
	}
	public Grado getGrado () {
		return grado;
	}
	public boolean isAyuda() {
		return ayuda;
	}
	public void setAyuda(boolean ayuda) {
		this.ayuda = ayuda;
	}
	public float getRango() {
		return rango;
	}

	public static ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public static void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		Estudiante.estudiantes = estudiantes;
	}

	public void agregarNota(Nota cero) {
		this.notas.add(cero);
		Serializacion.base_datos();
		
	}
	
	//ESTE M�TODO ORGANIZA LAS NOTAS DEL ESTUDIANTE CON RESPECTO A LAS MATERIAS, Y DEVUELVE UN STRING
	//CON TODAS LAS CALIFICACIONES DE LAS NOTAS DE CADA MATERIA QUE TIENE EL ESTUDIANTE.
	public String misNotas() {
		Collections.sort(notas, new Comparator <Nota>() {
			   public int compare(Nota obj1, Nota obj2) {
			      return obj1.getAsignatura().getNombre().compareTo(obj2.getAsignatura().getNombre());
			   }
			});
		String sal="";
		int comp=0;
		for(Nota temp:notas) {
			sal+=temp.getAsignatura().getNombre() +" "+temp.getCalificacion()+"\n";
		}
		
		
		return sal;
	}
	//ESTE M�TODO RECIBE UN OBJETO TIPO ASIGNATURA, LO QUE HACE ES BUSCAR TODAS LAS CALIFICACIONES QUE TIENE
	//EL ESTUDIANTE EN DICHA ASIGNATURA Y DEVUELVE EL PROMEDIO DE ELLAS, TAMBIEN LLENA UN HASMAP CON LA ASIGNATURA 
	//ENVIADA COMO CLAVE Y SU PROMEDIO COMO VALOR 
	public float promedio_asignatura(Asignatura asi) {
		float totalnotas = 0;
		int iter=0;
		for(Nota temp: notas){
		    if(temp.getAsignatura().getId()==asi.getId()) {
		    	totalnotas+=temp.getCalificacion();
		    	iter++;
		    }
		}
		totalnotas = totalnotas / iter;
		promedios.put(asi.getId(), totalnotas);
		Serializacion.base_datos();
		return totalnotas;
	}
	
	//ESTE M�TODO SE ENCARGA DE ENVIAR A PROMEDIO ASIGNATURA TODAS LAS ASIGNATURAS PARA LLENAR EL HASHMAP DE
	//PROMEDIOS CON LAS ASIGNATURAS Y SUS RESPECTIVOS PROMEDIOS
	public void promedios() {
		for(Nota temp: notas){
			promedio_asignatura(temp.getAsignatura());
		}
	}
	
	//ESTE M�TODO RECORRE EL HASHMAP Y HACE EL PROMEDIO DE LOS PROMEDIOS DE LAS ASIGNATURAS PARA OBTENER 
	//EL PROMEDIO GENERAL DEL ESTUDIANTE Y ASIGNA.
	public void promedio_general() {
		float promediog=0;
		this.promedios();
		if (promedios.size()>0) {
			for (Entry<Integer, Float> entry : promedios.entrySet()) {
				promediog+=entry.getValue();
			}
			promediog=promediog/this.promedios.size();
			this.setPromedio(promediog);
		}
		else {
			this.setPromedio(0);
		}
		Serializacion.base_datos();
	}
	
	//ESTE M�TODO RECORRE EL HASHMAP DE PROMEDIOS Y VERIFICA MEDIANTE UNA SECUENCIA DE BOOLEANOS QUE
	//TODAS LAS MATERIAS TENGAN EL 100% DE SUS CALIFICACIONES, SI ES ASI RETORNA TRUE EN CASO CONTRARIO RETORNA FALSE.
	public Boolean porcentaje_periodo() {
		int x=0,y=0;
		boolean t=false;
		for (Entry<Integer, Float> entry : promedios.entrySet()) {
			for(Nota temp: notas) {
				if(entry.getKey().equals(temp.getAsignatura().getId())) {
					if(temp.getAsignatura().getPorcentaje_avance()==100) {
						t=true;
					}else {
						t=false;
					}
				}
			}if(t==true) {
				x++;
			}y++;
		}if (y==x) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//ESTE M�TODO RECIBE EL ID DE UNA ASIGNATURA, Y BUSCA DICHA ASIGNATURA EN LA LISTA DE NOTAS AL ENCONTRARLA
	//LE PIDE EL PORCENTAJE DE AVANCE DESDE ASIGNATURA Y LO RETORNA.
	public float avance_asignatura(int asi) {
		float por = 0;
		for(Nota temp: notas) {
			if (temp.getAsignatura().getId()==asi){
				por= temp.getAsignatura().getPorcentaje_avance();
			}
		}return por;
	}
	
	//ESTE M�TODO RECORRE EL HASHMAP (USAMOS EL HASHMAP PARA TENER CONSIDERAR SOLO UNA ASIGNATURA, 
	//YA QUE NO PERMITE KEYS REPETIDAS) PARA PEDIR EL AVANCE DE CADA ASIGNATURA Y LOS PROMEDIA PARA SABER CUAL
	//ES EL PORCENTAJE DE AVANCE DEL PERIODO.
	public float avance_periodo () {
		float aja = 0;
		short ayuda=0;
		for (Entry<Integer, Float> entry : promedios.entrySet()) {
			ayuda+=avance_asignatura(entry.getKey());
		}
		if(promedios.size()>0) {
			aja=ayuda/promedios.size();
		}
	
		return aja;
	}
	public String toString() {
		this.promedio_general();
		return "Primer nombre: "+this.getNombre()+"\n"+
				"Primer Apellido: "+this.getApellido()+"\n"+
				"DNI: "+this.getDNI()+"\n"+
				"Edad: "+this.getEdad()+"\n"+
				"Acudiente: "+this.getAcudiente()+"\n"+
				"Promedio: "+this.getPromedio()+"\n"+
				"Grado: "+this.getGrado()
				;
	}
	
	//ESTE M�TODO ORDENA EL LISTADO DE ESTUDIANTE RESPECTO A SU PROMEDIO Y LUEGO IMPRIME LOS PRIMERO 10,
	//QUE SERIAN LOS MEJORES 10 DEL COLEGIO.
	public static String mejores_colegio() {
		Collections.sort(estudiantes, new Comparator <Estudiante>() {
			   public int compare(Estudiante obj1, Estudiante obj2) {
			      return new Float(obj2.getPromedio()).compareTo(obj1.getPromedio());
			   }
			});
		String sal="";
		for (int i = 0; i < 9; i++) {
			sal+=estudiantes.get(i).getNombre() +" "+estudiantes.get(i).getApellido()+" "+estudiantes.get(i).getPromedio()+"\n";
		}
		return sal;
	}
	
	// M�TODO QUE RETORNA EL PROMEDIO DEL GRADO A PARTIR DE LA SUMA DE TODOS LOS PROMEDIOS DE SUS ESTUDIANTES Y 
	// DIVIDIRLO POR LA CANTIDAD DE LOS MISMOS.
	public static float promedio_grado(int graId) {
		float promG=0;
		int count=0;
		for(Estudiante temp: estudiantes){
			if(temp.getGrado()!=null) {
			if(temp.getGrado().getId()==graId) {
				count++;
				temp.promedio_general();
				promG = promG + temp.getPromedio();
				}
			}
			else {
				
			}
		}
		return promG/count; 
	}
	
	// ESTE M�TODO ORGANIZA LA LISTA DE LOS ESTUDIANTES INSCRITOS EN EL GRADO POR SU PROMEDIO (DESCENDENTE) Y DEPENDIENDO DE LA CANTIDAD
	// DE ESTUDIANTES, MUESTRA 1/4 � UN 1/5 DE SU TOTALIDAD (LOS PRIMEROS), ES DECIR, LOS ESTUDIANTES CON EL PROMEDIO M�S ALTO.
	public static String cuadro_Honor(int graId){
		String sal="";
		ArrayList <Estudiante> e = new ArrayList<Estudiante>();
		for(Estudiante temp: estudiantes) {
			if(temp.getGrado()!=null) {
				if(temp.getGrado().getId()==graId) {
					e.add(temp);
					temp.promedio_general();
				}
			}
			
		}
		if (e.size() > 0) {
			Collections.sort(e, new Comparator<Estudiante>() {
				public int compare(Estudiante obj1, Estudiante obj2) {
					return new Float(obj2.getPromedio()).compareTo(obj1.getPromedio());
				}
			});

			if (e.size() % 2 == 0) {
				for (int i = 0; i < e.size() ; i++) {
					sal += e.get(i).getPromedio() + " " + e.get(i).getNombre() + " "
							+ e.get(i).getApellido() + "\n";
				}
			} 
		} else {
			sal = "No tenemos estudiantes en este grado";
		}
		return sal;

	}
	
	
	
	// ESTE M�TODO VERIFICA SI EL PROCENTAJE DE CADA ESTUDIANTE EN UN GRADO ES BAJO EN UN DETERMINADO MOMENTO DEL A�O ESCOLAR
	// E IMPRIME A DICHO ESTUDIANTE QUE CUMPLA ESTO, ES DECIR, MOSTRAR� A LOS ESTUDIANTES QUE VAYAN MAL EN EL PROMEDIO GENERAL
	// PARA AS� SUGERIRLE UNA AYUDA PEDAG�GICA Y LOGRE RECUPERAR O SUBIR DICHO PROMEDIO PARA QUE NO PIERDA EL A�O.
	public static String prevencion_bajo_rendimiento(int graId) {
		String sal = "";
		ArrayList <Estudiante> e = new ArrayList<Estudiante>();
		for(Estudiante temp: estudiantes) {
			if(temp.getGrado()!=null) {
				if(temp.getGrado().getId()==graId) {
					e.add(temp);
					temp.promedio_general();
				}
			}
		}
		for (Estudiante temp : e) {
			if (temp.getPromedio() >= 0 && temp.getPromedio() < temp.getRango()) {
				temp.setAyuda(true);
				sal += "El estudiante " + temp.getNombre() + " " + temp.getApellido() + " " + temp.getDNI()
						+ " necesita ayuda pedag�gica" + "\n";
			}
			else if (temp.getPromedio() >= temp.getRango()) {
				sal += "El estudiante " + temp.getNombre() + " " + temp.getApellido() + " " + temp.getDNI()
						+ " NO necesita ayuda pedag�gica" + "\n";
			}
		}
		Serializacion.base_datos();
		return sal;
	}
	

	
}
