package uiMain;

import java.util.*;

import BaseDatos.Serializacion;
import excepciones.Error1;
import excepciones.Error2;
import gestorAplicacion.academico.Asignatura;
import gestorAplicacion.academico.Grado;
import gestorAplicacion.academico.Nota;
import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;
import javafx.scene.control.TextField;

public class Main {

	public static void inicio() {
		System.out.println("BIENVENIDO A SYSTOOL V1.1 C5.0");
		System.out.println("Por favor escoja una opción para acceder a sus funcionalidades:");
		System.out.println("1. Estudiante");
		System.out.println("2. Profesor");
		System.out.println("3. Grado");
		System.out.println("4. Asignatura");
		System.out.println("5. Salir");
	}

	// -------------------------------------------------------------------------------------------------------------------------

	static ArrayList<Estudiante> estudiantes1;
	static ArrayList<Profesor> profesores1;
	static ArrayList<Asignatura> asignaturas1;
	static ArrayList<Grado> grados1;
	private static String alerta = "";

	public static String getAlerta() {
		return alerta;
	}

	public static void setAlerta(String a) {
		alerta = a;
	}

	public Main() {
		Serializacion.b2();
	}

	public static boolean crearEst(TextField creEs1, TextField creEs2, TextField creEs3, TextField creEs4,
			TextField creEs5) {
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();

		boolean salida = true;

		try {
			try {
				if (creEs1.getText().equals("") || creEs2.getText().equals("") || creEs3.getText().equals("")
						|| creEs1.getText().equals("") || creEs1.getText().equals("")) {
					throw new Error1(4);
				}
			} catch (Error1 e2) {
				alerta = e2.getSalida();
			}

			throw new Error1(creEs1, creEs2, creEs3, creEs4, creEs5);

		} catch (Error1 e) {
			salida = e.isA();
		}
		return salida;
	}

	public static String informeNotas(int dni,TextField inf) {
//		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		String salida = "";
		try {
			if (inf.getText().equals("")) {
				throw new Error1(4);
			}
			else {
				try {
					if (estudiantes1.size() > 0) {
						ArrayList<Integer> dnis = new ArrayList<>();
						for (Estudiante e : estudiantes1) {
							dnis.add(e.getDNI());
							if (e.getDNI() == dni) {
								salida = e.misNotas();
							}
						}

						if (!dnis.contains(dni)) {
							throw new Error1(3);
						}

					} else {
						throw new Error1(2);
					}
				} catch (Error1 e) {
					salida = e.getSalida();
				}
			}
		} catch (Error1 e2) {
			alerta = e2.getSalida();
		}
		
		return salida;
	}

	public static String mejoresColegio() {
//		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		String salida = "";
		try {
			for (Estudiante e : estudiantes1) {
				e.promedio_general();
			}
			if (estudiantes1.size() > 9) {
				salida = Estudiante.mejores_colegio();
			} else {
				throw new Error2(1);
			}
		} catch (Error2 e) {
			salida = e.getSalida();
		}

		return salida;
	}

	public static String infoEst(int dni) {
//		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		String salida = "";
		try {
			if (estudiantes1.size() > 0) {
				ArrayList<Integer> dnis = new ArrayList<>();
				for (Estudiante e : estudiantes1) {
					dnis.add(e.getDNI());
					if (e.getDNI() == dni) {
						salida = e.toString();
					}
				}
				if (!dnis.contains(dni)) {
					throw new Error1(3);
				}
			} else {
				throw new Error1(2);
			}
		} catch (Error1 e) {
			salida = e.getSalida();
		}

		return salida;
	}

	public static boolean crearProf(TextField crePro1, TextField crePro2, TextField crePro3, TextField crePro4,
			TextField crePro5, TextField crePro6) {
		Serializacion.b2();
		profesores1 = Serializacion.getProfesores();
		boolean salida = true;

		try {
			throw new Error2(crePro1, crePro2, crePro3, crePro4, crePro5, crePro6);
		} catch (Error2 e) {
			salida = e.isEsNum();
		}
		return salida;
	}

	public static String infoProf(int dni) {
//		Serializacion.b2();
		profesores1 = Serializacion.getProfesores();
		String salida = "";
		try {
			if (profesores1.size() > 0) {
				ArrayList<Integer> dnis = new ArrayList<>();
				for (Profesor p : profesores1) {
					dnis.add(p.getDNI());
					if (p.getDNI() == dni) {
						salida = p.toString();
					}
				}
				if (!dnis.contains(dni)) {
					throw new Error1(3);
				}
			} else {
				throw new Error1(2);
			}
		} catch (Error1 e) {
			salida = e.getSalida();
		}

		return salida;
	}

	public static boolean crearGr(TextField creGr1, TextField creGr2) {
		Serializacion.b2();
		grados1 = Serializacion.getGrados();
		boolean salida = true;

		try {
			throw new Error2(creGr1, creGr2);
		} catch (Error2 e) {
			salida = e.isEsNum();
		}
		return salida;
	}

	public static String profEnc(int idg, int dni) {
		Serializacion.b2();
		profesores1 = Serializacion.getProfesores();
		grados1 = Serializacion.getGrados();
		String salida = "";
		try {
			if (profesores1.size() > 0 && grados1.size() > 0) {
				ArrayList<Integer> dnis = new ArrayList<>();
				ArrayList<Integer> ids = new ArrayList<>();
				for (Grado g : grados1) {
					ids.add(g.getId());
					for (Profesor p : profesores1) {
						dnis.add(p.getDNI());
						if (p.getDNI() == dni && g.getId() == idg) {
							g.setProfesor_encargado(p);
							salida = "Profesor agregado exitosamente";
						}
					}
				}
				if (!ids.contains(idg) || !dnis.contains(dni)) {
					throw new Error1(3);
				}
			} else {
				throw new Error1(2);
			}
		} catch (Error1 e) {
			salida = e.getSalida();
		}
		return salida;

	}

	public static String aggEstGr(int idg, int e) {
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		grados1 = Serializacion.getGrados();
		String salida = "";

		try {
			if (grados1.size() > 0 && estudiantes1.size() > 0) {
				ArrayList<Integer> nombres = new ArrayList<>();
				ArrayList<Integer> est = new ArrayList<>();
				for (Grado g : grados1) {
					nombres.add(g.getId());
					for (Estudiante es : estudiantes1) {
						est.add(es.getDNI());
						if (es.getDNI() == e && g.getId() == idg) {
							g.agregarEstudiante(es);
							salida = "Estudiante agregado exitosamente";
						}
					}
				}
				if (!nombres.contains(idg) || !est.contains(e)) {
					throw new Error1(3);
				}
			} else {
				throw new Error1(2);
			}
		} catch (Error1 er) {
			salida = er.getSalida();
		}
		return salida;
	}

	public static String infoGr(int dni) {
//		Serializacion.b2();
		grados1 = Serializacion.getGrados();
		String salida = "";
		try {
			if (grados1.size() > 0) {
				ArrayList<Integer> ids = new ArrayList<>();
				for (Grado e : grados1) {
					ids.add(e.getId());
					if (e.getId() == dni) {
						salida = e.toString();
					}
				}
				if (!ids.contains(dni)) {
					throw new Error1(3);
				}
			} else {
				throw new Error1(2);
			}
		} catch (Error1 e) {
			salida = e.getSalida();
		}
		return salida;
	}

	public static String cuadroHonor(int idg) {
//		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		grados1 = Serializacion.getGrados();
		String salida = "";

		try {
			if (grados1.size() > 0 && estudiantes1.size() > 0) {
				ArrayList<Integer> ids = new ArrayList<>();
				for (Grado g : grados1) {
					ids.add(g.getId());
					if (g.getId() == idg) {
						salida = Estudiante.cuadro_Honor(idg);
					}
				}
				if (!ids.contains(idg)) {
					throw new Error1(3);
				}
			} else {
				throw new Error1(2);
			}
		} catch (Error1 e) {
			salida = e.getSalida();
		}

		return salida;
	}

	public static String prevencion(int idg) {
//		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		grados1 = Serializacion.getGrados();
		String salida = "";

		try {
			if (grados1.size() > 0 && estudiantes1.size() > 0) {
				ArrayList<Integer> ids = new ArrayList<>();
				for (Grado g : grados1) {
					ids.add(g.getId());
					if (g.getId() == idg) {
						salida = Estudiante.prevencion_bajo_rendimiento(idg);
					}
				}
				if (!ids.contains(idg)) {
					throw new Error1(3);
				}
			} else {
				throw new Error1(2);
			}
		} catch (Error1 e) {
			salida = e.getSalida();
		}

		return salida;
	}

	public static String promedioGr(int idg) {
//		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		grados1 = Serializacion.getGrados();
		String salida = "";
		try {
			if (grados1.size() > 0 && estudiantes1.size() > 0) {
				ArrayList<Integer> ids = new ArrayList<>();
				for (Grado g : grados1) {
					ids.add(g.getId());
					if (g.getId() == idg) {
						salida = Float.toString(Estudiante.promedio_grado(idg));
					}
				}
				if (!ids.contains(idg)) {
					throw new Error1(3);
				}
			} else {
				throw new Error1(2);
			}
		} catch (Error1 e) {
			salida = e.getSalida();
		}
		return salida;
	}

	public static boolean crearAsig(TextField crAs1, TextField crAs2, TextField crAs3) {
		Serializacion.b2();
		asignaturas1 = Serializacion.getAsignaturas();
		boolean salida = true;
		try {
			throw new Error2(crAs1, crAs2, crAs3);
		} catch (Error2 e) {
			salida = e.isEsNum();
		}
		return salida;
	}

	public static String crearNota(float cal, int asignatura, int dni) {
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		asignaturas1 = Serializacion.getAsignaturas();
		String salida = "";

		try {
			if (asignaturas1.size() > 0 && estudiantes1.size() > 0) {
				Asignatura a2 = null;
				Estudiante e1 = null;

				ArrayList<Integer> id_asign = new ArrayList<>();
				for (Asignatura a : asignaturas1) {
					id_asign.add(a.getId());
					if (a.getId() == asignatura) {
						a2 = a;
					}
				}
				ArrayList<Integer> dnis = new ArrayList<>();
				for (Estudiante e : estudiantes1) {
					dnis.add(e.getDNI());
					if (e.getDNI() == dni) {
						e1 = e;
					}
				}

				if (id_asign.contains(asignatura) && dnis.contains(dni)) {
					Nota n1 = new Nota(cal, e1, a2);
					salida = "nota creada exitosamente";
				} else {
					throw new Error1(3);
				}

			} else {
				throw new Error1(2);
			}
		} catch (Error1 e) {
			salida = e.getSalida();
		}
		return salida;

	}
	// -------------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {

		Serializacion.b2();

		ArrayList<Estudiante> estudiantes = Serializacion.getEstudiantes();
		ArrayList<Profesor> profesores = Serializacion.getProfesores();
		ArrayList<Asignatura> asignaturas = Serializacion.getAsignaturas();
		ArrayList<Grado> grados = Serializacion.getGrados();

		int loop = 0;
		while (loop == 0) {

			inicio();
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(System.in);
			int opcion = reader.nextInt();
			int funcionalidad;

			switch (opcion) {
			case 1:
				System.out.println("1. Crear estudiante\r\n" + "2. Informe de notas individual\r\n"
						+ "3. Mejores 10 estudiantes del colegio\r\n" + "4. Ver información estudiante\r\n"
						+ "5. Atrás");
				funcionalidad = reader.nextInt();

				switch (funcionalidad) {
				case 1:
					System.out.print("DNI: ");
					int cedula = reader.nextInt();
					System.out.println("");
					System.out.print("Primer nombre: ");
					String nombres = reader.next();
					System.out.println("");
					System.out.print("Primer apellido: ");
					String apellidos = reader.next();
					System.out.println("");
					System.out.print("Edad: ");
					int edad = reader.nextInt();
					System.out.println("");
					System.out.print("Nombre de acudiente: ");
					String acudiente = reader.next();
					System.out.println("");
					new Estudiante(cedula, nombres, apellidos, edad, acudiente);

					System.out.println("Estudiante creado exitosamente.");

					break;
				case 2:

					if (estudiantes.size() > 0) {
						System.out.print("Ingrese el DNI de un estudiante registrado: ");
						int dni = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> dnis = new ArrayList<>();
						for (Estudiante e : estudiantes) {
							dnis.add(e.getDNI());
							if (e.getDNI() == dni) {
//							System.out.println("Sus notas son: ");
//							System.out.println(e.misNotas());
							}
						}
						if (!dnis.contains(dni)) {
							System.out.println("El estudiante con DNI " + dni + " no se encuentra registrado.");
						}
					} else {
						System.out.println(
								"Usted no ha creado estudiantes, por favor vaya a la sección de crear estudiantes.");
					}
					break;

				case 3:
					for (Estudiante e : estudiantes) {
						e.promedio_general();
					}
					if (estudiantes.size() > 9) {
						System.out.println(Estudiante.mejores_colegio());
					} else {
						System.out.println(
								"Usted no ha creado estudiantes o no tiene minimo 10 estudiantes, por favor vaya a la sección de crear estudiantes.");
					}
					break;
				case 4:
					if (estudiantes.size() > 0) {
						System.out.print("Ingrese el DNI de un estudiante registrado: ");
						int dni = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> dnis = new ArrayList<>();
						for (Estudiante e : estudiantes) {
							dnis.add(e.getDNI());
							if (e.getDNI() == dni) {
								System.out.println(e.toString());

							}
						}
						if (!dnis.contains(dni)) {
							System.out.println("El estudiante con DNI " + dni + " no se encuentra registrado.");
						}
					} else {
						System.out.println(
								"Usted no ha creado estudiantes, por favor vaya a la sección de crear estudiantes.");
					}

					break;
				case 5:
					break;
				default:
					System.out.println("Ingrese una opción válida");
					break;

				}
				break;

			case 2:
				System.out.println("1. Crear profesor\r\n" + "2. Ver información profesor \r\n" + "3. Atrás");
				funcionalidad = reader.nextInt();
				switch (funcionalidad) {
				case 1:
					System.out.print("DNI: ");
					int cedula = reader.nextInt();
					System.out.println("");
					System.out.print("Primer nombre: ");
					String nombres = reader.next();
					System.out.println("");
					System.out.print("Primer apellido: ");
					String apellidos = reader.next();
					System.out.println("");
					System.out.print("Edad: ");
					int edad = reader.nextInt();
					System.out.println("");
					System.out.print("Título: ");
					String titulo = reader.next();
					System.out.println("");
					System.out.print("E-mail: ");
					String email = reader.next();
					System.out.println("");
					new Profesor(cedula, nombres, apellidos, edad, titulo, email);
					System.out.println("Profesor creado exitosamente");
					break;
				case 2:
					if (profesores.size() > 0) {
						System.out.print("Ingrese el DNI de un profesor registrado: ");
						int dni = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> dnis = new ArrayList<>();
						for (Profesor p : profesores) {
							dnis.add(p.getDNI());
							if (p.getDNI() == dni) {
								System.out.println(p.toString());
							}
						}
						if (!dnis.contains(dni)) {
							System.out.println("El profesor con DNI " + dni + " no se encuentra registrado.");
						}
					} else {
						System.out.println(
								"Usted no ha creado profesores, por favor vaya a la sección de crear profesores.");
					}
					break;
				case 3:
					break;
				default:
					System.out.println("Ingrese una opción válida");
					break;
				}

				break;
			case 3:
				// ------------AGREGAR "AGREGAR ASIGNATURA" y "VER ASIGNATURAS" ambos con
				// id-----------------------------------------------------------------------------------
				System.out.println("1. Crear grado\r\n" + "2. Crear profesor encargado\r\n"
						+ "3. Agregar estudiante\r\n" + "4. Ver información de grado\r\n" + "5. Cuadro de honor\r\n"
						+ "6. Prevención de bajo rendimiento\r\n" + "7. Ver promedios de los grados\r\n" + "8. Atrás");
				funcionalidad = reader.nextInt();
				switch (funcionalidad) {
				case 1:
					System.out.print("Ingrese el ID del grado: ");
					int id = reader.nextInt();
					System.out.println("");
					System.out.print("Ingrese el nombre del grado: ");
					String n = reader.next();
					System.out.println("");
					new Grado(id, n);
					System.out.println("Grado creado exitosamente");
					break;
				case 2:
					if (profesores.size() > 0 && grados.size() > 0) {
						System.out.print("Ingrese el ID del grado: ");
						int idg = reader.nextInt();
						System.out.println("");
						System.out.print("Ingrese el DNI de un profesor registrado: ");
						int dni = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> dnis = new ArrayList<>();
						ArrayList<Integer> ids = new ArrayList<>();
						for (Grado g : grados) {
							ids.add(g.getId());
							for (Profesor p : profesores) {
								dnis.add(p.getDNI());
								if (p.getDNI() == dni && g.getId() == idg) {
									g.setProfesor_encargado(p);
									System.out.println("Profesor agregado correctamente.");
								}
							}

						}
						if (!ids.contains(idg) || !dnis.contains(dni)) {
							System.out.println(
									"Grado o profesor ingreado no existente, por favor vaya a la sección de creaciones");
						}
					} else {
						System.out.println(
								"No existen profesores o grados registrados, por favor vaya a la sección de creaciones.");
					}

					break;
				case 3:
					if (grados.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Ingrese el ID del grado: ");
						int idg = reader.nextInt();
						System.out.println("");
						System.out.print("Ingrese el DNI del estudiante: ");
						int e = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> nombres = new ArrayList<>();
						ArrayList<Integer> est = new ArrayList<>();
						for (Grado g : grados) {
							nombres.add(g.getId());
							for (Estudiante es : estudiantes) {
								est.add(es.getDNI());
								if (es.getDNI() == e && g.getId() == idg) {
									g.agregarEstudiante(es);
									System.out.println("Estudiante Matriculado exitosamente");
								}
							}
						}
						if (!nombres.contains(idg) || !est.contains(e)) {
							System.out.println(
									"Grado o estudiante ingreado no existente, por favor vaya a la sección de creaciones");
						}
					} else {
						System.out.println(
								"No existen estudiantes o grados registrados, por favor vaya a la sección  de creaciones");
						break;
					}
					break;
				// NO SE IMPLEMENTO POR ERROR DE NLP(NullPointer) QUE NO SE LOGRO CORREGIR
				/*
				 * case 4: if (grados.size() > 0 && asignaturas.size() > 0) {
				 * System.out.print("Ingrese el ID del grado: "); int id_g = reader.nextInt();
				 * System.out.println(""); System.out.print("Ingrese el id de la asignatura: ");
				 * int id_a = reader.nextInt(); System.out.println(""); ArrayList<Integer> idg =
				 * new ArrayList<>(); ArrayList<Integer> ida = new ArrayList<>(); for (Grado g :
				 * grados) { idg.add(g.getId()); for (Asignatura a : asignaturas) {
				 * ida.add(a.getId()); if (a.getId() == id_a && g.getId() == id_g) {
				 * g.agregarAsignatura(a);
				 * System.out.println("Asignatura agregada exitosamente"); } } } if
				 * (!idg.contains(id_g) || !ida.contains(id_a)) { System.out.println(
				 * "Grado o asignatura ingreadoa no existente, por favor vaya a la sección de creaciones"
				 * ); } } else { System.out.println(
				 * "No existen aignaturas o grados registrados, por favor vaya a la sección  de creaciones"
				 * ); break; } break;
				 */

				case 4:
					if (grados.size() > 0) {
						System.out.print("Ingrese el ID de un grado registrado: ");
						int dni = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> ids = new ArrayList<>();
						for (Grado e : grados) {
							ids.add(e.getId());
							if (e.getId() == dni) {
								System.out.println(e.toString());
							}
						}
						if (!ids.contains(dni)) {
							System.out.println("El grado con ID " + dni + " no se encuentra registrado.");
						}
					} else {
						System.out.println(
								"Usted no ha creado grados, por favor vaya a la sección de crear estudiantes.");
					}

					break;
				case 5:
					if (grados.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Ingrese el ID de un grado registrado: ");
						int idg = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> ids = new ArrayList<>();
						for (Grado g : grados) {
							ids.add(g.getId());
							if (g.getId() == idg) {
								System.out.println(Estudiante.cuadro_Honor(idg));
							}
						}
						if (!ids.contains(idg)) {
							System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
						}
					} else {
						System.out.println(
								"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
					}

					break;
				case 6:
					if (grados.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Ingrese el ID de un grado registrado: ");
						int idg = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> ids = new ArrayList<>();
						for (Grado g : grados) {
							ids.add(g.getId());
							if (g.getId() == idg) {
								System.out.println(Estudiante.prevencion_bajo_rendimiento(idg));
							}
						}
						if (!ids.contains(idg)) {
							System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
						}
					} else {
						System.out.println(
								"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
					}
					break;
				/*
				 * case 8: if (grados.size() > 0 && estudiantes.size() > 0) {
				 * System.out.print("Ingrese el ID de un grado registrado: "); int idg =
				 * reader.nextInt(); System.out.println(""); ArrayList<Integer> ids = new
				 * ArrayList<>(); for (Grado g : grados) { ids.add(g.getId()); if (g.getId() ==
				 * idg) { System.out.println(g.cuadro_superacion()); } } if (!ids.contains(idg))
				 * { System.out.println("El grado con DNI " + idg +
				 * " no se encuentra registrado."); } } else { System.out.println(
				 * "No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones."
				 * ); } break;
				 */
				case 7:
					if (grados.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Ingrese el ID de un grado registrado: ");
						int idg = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> ids = new ArrayList<>();
						for (Grado g : grados) {
							ids.add(g.getId());
							if (g.getId() == idg) {
								System.out.println("El promedio del grado es: " + Estudiante.promedio_grado(idg));
							}
						}
						if (!ids.contains(idg)) {
							System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
						}
					} else {
						System.out.println(
								"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
					}
					break;
				case 8:
					break;
				default:
					System.out.println("Ingrese una opción válida");
					break;
				}

				break;
			case 4:
				System.out.println("1. Crear asignatura\r\n" + "2. Crear nota\r\n" + "3. Atrás");
				funcionalidad = reader.nextInt();
				switch (funcionalidad) {
				case 1:
					System.out.print("ID: ");
					int id = reader.nextInt();
					System.out.println("");
					System.out.print("Nombre: ");
					String nombre = reader.next();
					System.out.println("");
					System.out.print("Número de notas: ");
					byte numero = reader.nextByte();
					System.out.println("");
					new Asignatura(id, nombre, numero);
					System.out.println("Asignatura creada exitosamente");
					break;
				case 2:
					if (asignaturas.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Calificación: ");
						float cal = reader.nextFloat();
						System.out.println("");
						System.out.print("ID de la asignatura: ");
						int asignatura = reader.nextInt();
						System.out.println("");
						System.out.print("DNI del estudiante: ");
						int dni = reader.nextByte();
						System.out.println("");
						Asignatura a2 = null;
						Estudiante e1 = null;

						ArrayList<Integer> id_asign = new ArrayList<>();
						for (Asignatura a : asignaturas) {
							id_asign.add(a.getId());
							if (a.getId() == asignatura) {
								a2 = a;
							}
						}
						ArrayList<Integer> dnis = new ArrayList<>();
						for (Estudiante e : estudiantes) {
							dnis.add(e.getDNI());
							if (e.getDNI() == dni) {
								e1 = e;
							}
						}

						if (id_asign.contains(asignatura) && dnis.contains(dni)) {
							new Nota(cal, e1, a2);
							System.out.println("Nota creada exitosamente");
							break;
						} else {
							System.out.println(
									"Asignatura o estudiante ingresado no existe, por vaya ingrese datos existentes.");
							break;
						}

					} else {
						System.out.println(
								"No existen asignaturas creadas, por favor vaya a la sección de crear asignaturas.");
					}
					break;
				case 3:
					break;
				default:
					System.out.println("Ingrese una opción válida");
					break;
				}

				break;
			case 5: // SALIR
				loop = -1;
				break;
			}

		}

		estudiantes = Serializacion.getEstudiantes();
		profesores = Serializacion.getProfesores();
		asignaturas = Serializacion.getAsignaturas();
		grados = Serializacion.getGrados();

		// Serializacion.base_datos();

		System.out.println("Hasta pronto <3");
	}

}
