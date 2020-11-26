package uiMain;

import java.util.*;

import BaseDatos.Serializacion;
import gestorAplicacion.academico.Asignatura;
import gestorAplicacion.academico.Grado;
import gestorAplicacion.academico.Nota;
import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;

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

	// Serializacion.b2();

	static ArrayList<Estudiante> estudiantes1;
	static ArrayList<Profesor> profesores1;
	static ArrayList<Asignatura> asignaturas1;
	static ArrayList<Grado> grados1;

	public static void crearEst(int dni, String nombre, String apellido, int edad, String acudiente) {
		Serializacion.b2();
		Estudiante e1 = new Estudiante(dni, nombre, apellido, edad, acudiente);
		estudiantes1 = Serializacion.getEstudiantes();
//		System.out.println(e1.getNombre());
	}

	public static String informeNotas(int dni) {
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		String salida = "";
		if (estudiantes1.size() > 0) {
			ArrayList<Integer> dnis = new ArrayList<>();
			for (Estudiante e : estudiantes1) {
				dnis.add(e.getDNI());
				if (e.getDNI() == dni) {
					salida = e.misNotas();
				}
			}
			if (!dnis.contains(dni)) {
				System.out.println("El estudiante con DNI " + dni + " no se encuentra registrado.");
			}
		} else {
			System.out.println("Usted no ha creado estudiantes, por favor vaya a la sección de crear estudiantes.");
		}
		return salida;
	}

	public static String mejoresColegio() {
		String salida = "";
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		for (Estudiante e : estudiantes1) {
			e.promedio_general();
		}
		if (estudiantes1.size() > 9) {
			salida = Estudiante.mejores_colegio();
//			System.out.println(Estudiante.mejores_colegio());
		} else {
			System.out.println(
					"Usted no ha creado estudiantes o no tiene minimo 10 estudiantes, por favor vaya a la sección de crear estudiantes.");
		}
		return salida;
	}

	public static String infoEst(int dni) {
		String salida = "";
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		if (estudiantes1.size() > 0) {
			ArrayList<Integer> dnis = new ArrayList<>();
			for (Estudiante e : estudiantes1) {
				dnis.add(e.getDNI());
				if (e.getDNI() == dni) {
					salida = e.toString();
//					System.out.println(e.toString());
				}
			}
			if (!dnis.contains(dni)) {
				System.out.println("El estudiante con DNI " + dni + " no se encuentra registrado.");
			}
		} else {
			System.out.println("Usted no ha creado estudiantes, por favor vaya a la sección de crear estudiantes.");
		}
		return salida;
	}

	public static void crearProf(int DNI, String nombres, String apellidos, int edad, String titulo, String email) {
		Serializacion.b2();
		Profesor p1 = new Profesor(DNI, nombres, apellidos, edad, titulo, email);
//		profesores1 = Serializacion.getProfesores();
//		System.out.println(e1.getNombre());
	}

	public static String infoProf(int dni) {
		String salida = "";
		Serializacion.b2();
		profesores1 = Serializacion.getProfesores();
		if (profesores1.size() > 0) {
			ArrayList<Integer> dnis = new ArrayList<>();
			for (Profesor p : profesores1) {
				dnis.add(p.getDNI());
				if (p.getDNI() == dni) {
					salida = p.toString();
//					System.out.println(p.toString());
				}
			}
			if (!dnis.contains(dni)) {
				System.out.println("El profesor con DNI " + dni + " no se encuentra registrado.");
			}
		} else {
			System.out.println("Usted no ha creado profesores, por favor vaya a la sección de crear profesores.");
		}
		return salida;
	}

	public static void crearGr(int id, String nombre) {
		Serializacion.b2();
		Grado g1 = new Grado(id, nombre);
//		grados1 = Serializacion.getGrados();
	}

	public static void profEnc(int idg, int dni) {
		Serializacion.b2();
		profesores1 = Serializacion.getProfesores();
		grados1 = Serializacion.getGrados();
		if (profesores1.size() > 0 && grados1.size() > 0) {
			ArrayList<Integer> dnis = new ArrayList<>();
			ArrayList<Integer> ids = new ArrayList<>();
			for (Grado g : grados1) {
				ids.add(g.getId());
				for (Profesor p : profesores1) {
					dnis.add(p.getDNI());
					if (p.getDNI() == dni && g.getId() == idg) {
						g.setProfesor_encargado(p);
//						profesores1 = Serializacion.getProfesores();
//						grados1 = Serializacion.getGrados();
//						System.out.println("Profesor agregado correctamente.");
					}
				}

			}
			if (!ids.contains(idg) || !dnis.contains(dni)) {
				System.out.println("Grado o profesor ingreado no existente, por favor vaya a la sección de creaciones");
			}
		} else {
			System.out
					.println("No existen profesores o grados registrados, por favor vaya a la sección de creaciones.");
		}
	}

	public static void aggEstGr(int idg, int e) {
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		grados1 = Serializacion.getGrados();

		if (grados1.size() > 0 && estudiantes1.size() > 0) {
			ArrayList<Integer> nombres = new ArrayList<>();
			ArrayList<Integer> est = new ArrayList<>();
			for (Grado g : grados1) {
				nombres.add(g.getId());
				for (Estudiante es : estudiantes1) {
					est.add(es.getDNI());
					if (es.getDNI() == e && g.getId() == idg) {
						g.agregarEstudiante(es);
//						estudiantes1 = Serializacion.getEstudiantes();
//						grados1 = Serializacion.getGrados();
//						System.out.println("Estudiante Matriculado exitosamente");
					}
				}
			}
			if (!nombres.contains(idg) || !est.contains(e)) {
				System.out
						.println("Grado o estudiante ingreado no existente, por favor vaya a la sección de creaciones");
			}
		}
	}

	public static String infoGr(int dni) {
		String salida = "";
		Serializacion.b2();
		grados1 = Serializacion.getGrados();
		if (grados1.size() > 0) {
			ArrayList<Integer> ids = new ArrayList<>();
			for (Grado e : grados1) {
				ids.add(e.getId());
				if (e.getId() == dni) {
					salida = e.toString();
//					System.out.println(e.toString());
				}
			}
			if (!ids.contains(dni)) {
				System.out.println("El grado con ID " + dni + " no se encuentra registrado.");
			}
		} else {
			System.out.println("Usted no ha creado grados, por favor vaya a la sección de crear estudiantes.");
		}
		return salida;
	}

	public static String cuadroHonor(int idg) {
		String salida = "";
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		grados1 = Serializacion.getGrados();

		if (grados1.size() > 0 && estudiantes1.size() > 0) {
			ArrayList<Integer> ids = new ArrayList<>();
			for (Grado g : grados1) {
				ids.add(g.getId());
				if (g.getId() == idg) {
					salida = Estudiante.cuadro_Honor(idg);
//					System.out.println(Estudiante.cuadro_Honor(idg));
				}
			}
			if (!ids.contains(idg)) {
				System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
			}
		} else {
			System.out.println(
					"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
		}
		return salida;
	}

	public static String prevencion(int idg) {
		String salida = "";
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		grados1 = Serializacion.getGrados();

		if (grados1.size() > 0 && estudiantes1.size() > 0) {
			ArrayList<Integer> ids = new ArrayList<>();
			for (Grado g : grados1) {
				ids.add(g.getId());
				if (g.getId() == idg) {
					salida = Estudiante.prevencion_bajo_rendimiento(idg);
//				System.out.println(Estudiante.prevencion_bajo_rendimiento(idg));
				}
			}
			if (!ids.contains(idg)) {
				System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
			}
		} else {
			System.out.println(
					"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
		}
		return salida;
	}

	public static float promedioGr(int idg) {
		float salida = 0;
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		grados1 = Serializacion.getGrados();
		if (grados1.size() > 0 && estudiantes1.size() > 0) {
			ArrayList<Integer> ids = new ArrayList<>();
			for (Grado g : grados1) {
				ids.add(g.getId());
				if (g.getId() == idg) {
					salida = Estudiante.promedio_grado(idg);
//				System.out.println("El promedio del grado es: " + Estudiante.promedio_grado(idg));
				}
			}
			if (!ids.contains(idg)) {
				System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
			}
		} else {
			System.out.println(
					"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
		}
		return salida;
	}

	public static void crearAsig(int id, String nombre, int numero) {
		Serializacion.b2();
		Asignatura a1 = new Asignatura(id, nombre, numero);
//		asignaturas1 = Serializacion.getAsignaturas();
	}

	public static void crearNota(float cal, int asignatura, int dni) {
		Serializacion.b2();
		estudiantes1 = Serializacion.getEstudiantes();
		asignaturas1 = Serializacion.getAsignaturas();
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
				Nota n1 =new Nota(cal, e1, a2);
//				estudiantes1 = Serializacion.getEstudiantes();
//				asignaturas1 = Serializacion.getAsignaturas();
//				profesores1 = Serializacion.getProfesores();
//				grados1 = Serializacion.getGrados();
				System.out.println("Nota creada exitosamente");
			} else {
				System.out.println("Asignatura o estudiante ingresado no existe, por vaya ingrese datos existentes.");
			}

		} else {
			System.out.println("No existen asignaturas creadas, por favor vaya a la sección de crear asignaturas.");
		}
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
