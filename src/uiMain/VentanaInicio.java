package uiMain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VentanaInicio extends Application {

	// MOUSE EVENTO CLICK

	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getEventType().toString().equals("MOUSE_PRESSED") && hoja.getText().equals("Sebastian Agudelo Osorio,\r\n20 años, estudiante de la \r\nUniversidad Nacional De Colombia,\r\nproductor, fanático de las tecnologías")) {
				hoja.setText(
						"Daniela Guardia Cuervo, 21 años de edad.\r\nEstudiante de ingeniería de sistemas e \r\ninformática, sexto semestre.");
				fot01 = new Image(getClass().getResourceAsStream("/fotos/dani.png"));
				prog.setImage(fot01);

			} else if (mouseEvent.getEventType().toString().equals("MOUSE_PRESSED") && hoja.getText().equals(
					"Daniela Guardia Cuervo, 21 años de edad.\r\nEstudiante de ingeniería de sistemas e \r\ninformática, sexto semestre.")) {
				hoja.setText(
						"Cristian David Quinchia Ramirez, 21 años.\r\nEstudiante de ingeniería de sistemas e \r\ninformática, sexto semestre.\r\nMe interesan las redes y telecomunicaciones.");
				fot01 = new Image(getClass().getResourceAsStream("/fotos/cris.png"));
				prog.setImage(fot01);
			} else if (mouseEvent.getEventType().toString().equals("MOUSE_PRESSED") && hoja.getText().equals(
					"Cristian David Quinchia Ramirez, 21 años.\r\nEstudiante de ingeniería de sistemas e \r\ninformática, sexto semestre.\r\nMe interesan las redes y telecomunicaciones.")) {
				hoja.setText(
						"Sebastian Agudelo Osorio,\r\n20 años, estudiante de la \r\nUniversidad Nacional De Colombia,\r\nproductor, fanático de las tecnologías");
				fot01 = new Image(getClass().getResourceAsStream("/fotos/sebas.png"));
				prog.setImage(fot01);
			}
		}

	};

	EventHandler<MouseEvent> movimiento = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {

			if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("01")) {
				ini = "02";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/02.png"));
				im01.setImage(imaini);
			} else if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("02")) {
				ini = "03";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/03.png"));
				im01.setImage(imaini);
			} else if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("03")) {
				ini = "04";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/04.png"));
				im01.setImage(imaini);
			} else if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("04")) {
				ini = "05";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/05.png"));
				im01.setImage(imaini);
			} else if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("05")) {
				ini = "01";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/01.png"));
				im01.setImage(imaini);
			}

		}

	};

	//////////////////////////
	EventHandler<ActionEvent> descre = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			Object control = e.getSource();
			if (control instanceof MenuItem) {
				if (control.equals(descripcion)) {
					des = new Label(
							"SYSTOOL es un sistema\r\nde monitoreo y muestra de\r\napartados educativos para el\r\nacceso a información de notas.");
					des.setFont(new Font("Tahoma", 15));
					p4.setCenter(des);
				} else if (control.equals(salir)) {
					primario.close();
				}
			}

		}

	};
	
	EventHandler<ActionEvent> clase = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent c) {
			Object control = c.getSource();
			if (control instanceof MenuItem) {
				if (control.equals(est)) {
					paneEst = new GridPane();

					title1 = new Label("MENU ESTUDIANTE");
					title1.setTextFill(Color.web("BLACK"));
					title1.setFont(new Font("Nirmala UI Semilight Bold", 25));
					est1 = new Button("Crear estudiante");
					est2 = new Button("Informe de notas individual");
					est3 = new Button("Mejores 10 estudiantes del colegio");
					est4 = new Button("Ver informacion estudiante");
					paneEst.setAlignment(Pos.CENTER);
					paneEst.add(title1, 1, 1);
					paneEst.add(new Label(""), 1, 2);
					paneEst.add(new Label(""), 1, 3);
					paneEst.add(est1, 1, 4);
					paneEst.add(new Label(""), 1, 5);
					paneEst.add(est2, 1, 6);
					paneEst.add(new Label(""), 1, 7);
					paneEst.add(est3, 1, 8);
					paneEst.add(new Label(""), 1, 9);
					paneEst.add(est4, 1, 10);
					ustage.setCenter(paneEst);
					
					
					
					
					////////////////////////////////////////////////
					
					est1.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField creEs1 = new TextField();
							TextField creEs2 = new TextField();
							TextField creEs3 = new TextField();
							TextField creEs4 = new TextField();
							TextField creEs5 = new TextField();
							crear = new Button("Crear");
							crear.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent event) {
									// TODO Auto-generated method stub
									//MAÑANA PONER PASO DE INFORMACION OSEA AQUÍ VA LA FUNCIOND EL MAIN
								}
								
							});
							Label alerta = new Label("Por favor complete todos los campos solicitados.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("CREAR ESTUDIANTE");
							describ.setFont(new Font("Tahoma", 17));
							paneCreEst = new GridPane();
							paneCreEst.setAlignment(Pos.CENTER);
							paneCreEst.add(describ,2,1);
							paneCreEst.add(new Label(""), 1, 2);
							paneCreEst.add(alerta,3,4);
							paneCreEst.add(new Label(""), 1, 5);
							paneCreEst.add(new Label("DNI*: "),1,6);
							paneCreEst.add(creEs1,3,6);
							paneCreEst.add(new Label(""), 1, 7);
							paneCreEst.add(new Label("Nombre*: "),1,8);
							paneCreEst.add(creEs2,3,8);
							paneCreEst.add(new Label(""), 1, 9);
							paneCreEst.add(new Label("Apellido*: "),1,10);
							paneCreEst.add(creEs3,3,10);
							paneCreEst.add(new Label(""), 1, 11);
							paneCreEst.add(new Label("Edad*: "),1,12);
							paneCreEst.add(creEs4,3,12);
							paneCreEst.add(new Label(""), 1, 13);
							paneCreEst.add(new Label("Acudiente*: "),1,14);
							paneCreEst.add(creEs5,3,14);
							paneCreEst.add(new Label(""), 2, 15);
							paneCreEst.add(crear,2,16);

							ustage.setCenter(paneCreEst);
							///EXCEPCION 
							///int J  = Integer.parseInt(creEs1.getText());
							
						}

					});
					est2.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField infEs1 = new TextField();
							Label alerta = new Label("Por favor complete el campo solicitado.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("INFORME DE NOTAS INDIVIDUAL");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el DNI del estudiante, el programa\n\rmostrará cada nota con su materia correspondiente.");
							descrip.setFont(new Font("Tahoma", 13));
							informe = new Button("Ver informe");
							informe.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									GridPane resultinfo = new GridPane();
									Label des = new Label("Hola");
									
									resultinfo.add(des, 1, 1);
									ustage.setCenter(resultinfo);
								}
								
							});
							
							
							paneInfEst = new GridPane();
							paneInfEst.setAlignment(Pos.CENTER);
							paneInfEst.add(describ,2,1);
							paneInfEst.add(new Label(""), 1, 2);
							paneInfEst.add(descrip,2,3);
							paneInfEst.add(new Label(""), 1, 4);
							paneInfEst.add(alerta,3,5);
							paneInfEst.add(new Label(""), 1, 6);
							paneInfEst.add(new Label("DNI*: "),1,7);
							paneInfEst.add(infEs1,3,7);
							paneInfEst.add(new Label(""), 1, 8);
							paneInfEst.add(informe, 2, 9);
							ustage.setCenter(paneInfEst);
						}
					});
					est3.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							paneMejEst = new GridPane();
							paneMejEst.setAlignment(Pos.CENTER);
							Label describ = new Label("MEJORES 10 ESTUDIANTES DEL COLEGIO");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("El programa mostrará una lista de\n\rlos 10 mejores estudiantes del colegio.");
							descrip.setFont(new Font("Tahoma", 13));
							paneMejEst.add(describ, 2, 1);
							paneMejEst.add(new Label(""),1,2);
							paneMejEst.add(descrip,2,3);
							ustage.setCenter(paneMejEst);
						}
					});
					est4.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField infoEs1 = new TextField();
							Label alerta = new Label("Por favor complete el campo solicitado.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("INFORMACION DE ESTUDIANTE");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el DNI del estudiante, el programa\n\rmostrará los datos del estudiante.");
							descrip.setFont(new Font("Tahoma", 13));
							informe = new Button("Buscar informacion");
							paneInfoEst = new GridPane();
							paneInfoEst.setAlignment(Pos.CENTER);
							paneInfoEst.add(describ,2,1);
							paneInfoEst.add(new Label(""), 1, 2);
							paneInfoEst.add(descrip,2,3);
							paneInfoEst.add(new Label(""), 1, 4);
							paneInfoEst.add(alerta,3,5);
							paneInfoEst.add(new Label(""), 1, 6);
							paneInfoEst.add(new Label("DNI*: "),1,7);
							paneInfoEst.add(infoEs1,3,7);
							paneInfoEst.add(new Label(""), 1, 8);
							paneInfoEst.add(informe, 2, 9);
							ustage.setCenter(paneInfoEst);
						}
					});
				} else if(control.equals(prof)) {
					panePro = new GridPane();
					title1 = new Label("MENU PROFESOR");
					title1.setTextFill(Color.web("BLACK"));
					title1.setFont(new Font("Nirmala UI Semilight Bold", 25));
					pro1 = new Button("Crear profesor");
					pro2 = new Button("Ver información profesor");
					panePro.setAlignment(Pos.CENTER);
					panePro.add(title1, 1, 1);
					panePro.add(new Label(""), 1, 2);
					panePro.add(new Label(""), 1, 3);
					panePro.add(pro1, 1, 4);
					panePro.add(new Label(""), 1, 5);
					panePro.add(pro2, 1, 6);
					ustage.setCenter(panePro);
					pro1.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField crePro1 = new TextField();
							TextField crePro2 = new TextField();
							TextField crePro3 = new TextField();
							TextField crePro4 = new TextField();
							TextField crePro5 = new TextField();
							TextField crePro6 = new TextField();
							crear = new Button("Crear");
							Label alerta = new Label("Por favor complete todos los campos solicitados.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("CREAR PROFESOR");
							describ.setFont(new Font("Tahoma", 17));
							paneCrePro = new GridPane();
							paneCrePro.setAlignment(Pos.CENTER);
							paneCrePro.add(describ,2,1);
							paneCrePro.add(new Label(""), 1, 2);
							paneCrePro.add(alerta,3,4);
							paneCrePro.add(new Label(""), 1, 5);
							paneCrePro.add(new Label("DNI*: "),1,6);
							paneCrePro.add(crePro1,3,6);
							paneCrePro.add(new Label(""), 1, 7);
							paneCrePro.add(new Label("Nombre*: "),1,8);
							paneCrePro.add(crePro2,3,8);
							paneCrePro.add(new Label(""), 1, 9);
							paneCrePro.add(new Label("Apellido*: "),1,10);
							paneCrePro.add(crePro3,3,10);
							paneCrePro.add(new Label(""), 1, 11);
							paneCrePro.add(new Label("Edad*: "),1,12);
							paneCrePro.add(crePro4,3,12);
							paneCrePro.add(new Label(""), 1, 13);
							paneCrePro.add(new Label("Titulo*: "),1,14);
							paneCrePro.add(crePro5,3,14);
							paneCrePro.add(new Label(""), 2, 15);
							paneCrePro.add(new Label("E-mail*: "),1,16);
							paneCrePro.add(crePro6,3,16);
							paneCrePro.add(new Label(""), 2, 17);
							paneCrePro.add(crear,2,18);

							ustage.setCenter(paneCrePro);
						}
					});
					pro2.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField infoPro1 = new TextField();
							Label alerta = new Label("Por favor complete el campo solicitado.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("INFORMACION DE PROFESOR");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el DNI del profesor, el programa\n\rmostrará los datos del profesor.");
							descrip.setFont(new Font("Tahoma", 13));
							informe = new Button("Buscar informacion");
							paneInfoPro = new GridPane();
							paneInfoPro.setAlignment(Pos.CENTER);
							paneInfoPro.add(describ,2,1);
							paneInfoPro.add(new Label(""), 1, 2);
							paneInfoPro.add(descrip,2,3);
							paneInfoPro.add(new Label(""), 1, 4);
							paneInfoPro.add(alerta,3,5);
							paneInfoPro.add(new Label(""), 1, 6);
							paneInfoPro.add(new Label("DNI*: "),1,7);
							paneInfoPro.add(infoPro1,3,7);
							paneInfoPro.add(new Label(""), 1, 8);
							paneInfoPro.add(informe, 2, 9);
							ustage.setCenter(paneInfoPro);
						}
					});
				} else if (control.equals(gr)) {
					paneGra = new GridPane();
					title1 = new Label("MENU GRADO");
					title1.setTextFill(Color.web("BLACK"));
					title1.setFont(new Font("Nirmala UI Semilight Bold", 25));
					gra1 = new Button("Crear grado");
					gra2 = new Button("Asignar profesor encargado");
					gra3 = new Button("Agregar estudiante");
					gra4 = new Button("Ver información de grado");
					gra5 = new Button("Cuadro de honor");
					gra6 = new Button("Prevención de bajo rendimiento");
					gra7 = new Button("Ver promedio del grado");
					paneGra.setAlignment(Pos.CENTER);
					paneGra.add(title1, 1, 1);
					paneGra.add(new Label(""), 1, 2);
					paneGra.add(new Label(""), 1, 3);
					paneGra.add(gra1, 1, 4);
					paneGra.add(new Label(""), 1, 5);
					paneGra.add(gra2, 1, 6);
					paneGra.add(new Label(""), 1, 7);
					paneGra.add(gra3, 1, 8);
					paneGra.add(new Label(""), 1, 9);
					paneGra.add(gra4, 1, 12);
					paneGra.add(new Label(""), 1, 13);
					paneGra.add(gra5, 1, 14);
					paneGra.add(new Label(""), 1, 15);
					paneGra.add(gra6, 1, 16);
					paneGra.add(new Label(""), 1, 17);
					paneGra.add(gra7, 1, 18);
					paneGra.add(new Label(""), 1, 19);
					ustage.setCenter(paneGra);
					gra1.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField creGr = new TextField();
							Label alerta = new Label("Por favor complete el campo solicitado.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("CREAR GRADO");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el ID del grado, el programa\n\rcreara dicho grado.");
							descrip.setFont(new Font("Tahoma", 13));
							crearGr = new Button("Crear");
							paneCreGr = new GridPane();
							paneCreGr.setAlignment(Pos.CENTER);
							paneCreGr.add(describ,2,1);
							paneCreGr.add(new Label(""), 1, 2);
							paneCreGr.add(descrip,2,3);
							paneCreGr.add(new Label(""), 1, 4);
							paneCreGr.add(alerta,3,5);
							paneCreGr.add(new Label(""), 1, 6);
							paneCreGr.add(new Label("ID*: "),1,7);
							paneCreGr.add(creGr,3,7);
							paneCreGr.add(new Label(""), 1, 8);
							paneCreGr.add(crearGr, 2, 9);
							ustage.setCenter(paneCreGr);
						}
					});
					gra2.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField crePrEn1 = new TextField();
							TextField crePrEn2 = new TextField();
							Label alerta = new Label("Por favor complete los campos solicitados.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("ASIGNAR PROFESOR ENCARGADO");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el ID del grado, el DNI del profesor\n\rel programa lo asignara al grado.");
							descrip.setFont(new Font("Tahoma", 13));
							asiPr = new Button("Asignar profesor");
							paneCreGr = new GridPane();
							paneCreGr.setAlignment(Pos.CENTER);
							paneCreGr.add(describ,2,1);
							paneCreGr.add(new Label(""), 1, 2);
							paneCreGr.add(descrip,2,3);
							paneCreGr.add(new Label(""), 1, 4);
							paneCreGr.add(alerta,3,5);
							paneCreGr.add(new Label(""), 1, 6);
							paneCreGr.add(new Label("ID*: "),1,7);
							paneCreGr.add(crePrEn1,3,7);
							paneCreGr.add(new Label(""), 1, 8);
							paneCreGr.add(new Label("DNI*: "),1,9);
							paneCreGr.add(crePrEn2,3,9);
							paneCreGr.add(new Label(""), 1, 10);
							paneCreGr.add(asiPr, 2, 11);
							ustage.setCenter(paneCreGr);
						}
					});
					gra3.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField asiEs1 = new TextField();
							TextField asiEs2 = new TextField();
							Label alerta = new Label("Por favor complete los campos solicitados.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("ASIGNAR ESTUDIANTE");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el ID del grado, el DNI del estudiante\n\rel programa lo asignara al grado.");
							descrip.setFont(new Font("Tahoma", 13));
							asiEs = new Button("Asignar estudiante");
							paneAsiEs = new GridPane();
							paneAsiEs.setAlignment(Pos.CENTER);
							paneAsiEs.add(describ,2,1);
							paneAsiEs.add(new Label(""), 1, 2);
							paneAsiEs.add(descrip,2,3);
							paneAsiEs.add(new Label(""), 1, 4);
							paneAsiEs.add(alerta,3,5);
							paneAsiEs.add(new Label(""), 1, 6);
							paneAsiEs.add(new Label("ID*: "),1,7);
							paneAsiEs.add(asiEs1,3,7);
							paneAsiEs.add(new Label(""), 1, 8);
							paneAsiEs.add(new Label("DNI*: "),1,9);
							paneAsiEs.add(asiEs2,3,9);
							paneAsiEs.add(new Label(""), 1, 10);
							paneAsiEs.add(asiEs, 2, 11);
							ustage.setCenter(paneAsiEs);
						}
					});
					gra4.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField verGr = new TextField();
							Label alerta = new Label("Por favor complete el campo solicitado.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("VER INFORMACION DEL GRADO");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el ID del grado, el programa\n\rmostrará la información del grado.");
							descrip.setFont(new Font("Tahoma", 13));
							infGr = new Button("Ver informacion del grado");
							paneInfG = new GridPane();
							paneInfG.setAlignment(Pos.CENTER);
							paneInfG.add(describ,2,1);
							paneInfG.add(new Label(""), 1, 2);
							paneInfG.add(descrip,2,3);
							paneInfG.add(new Label(""), 1, 4);
							paneInfG.add(alerta,3,5);
							paneInfG.add(new Label(""), 1, 6);
							paneInfG.add(new Label("ID*: "),1,7);
							paneInfG.add(verGr,3,7);
							paneInfG.add(new Label(""), 1, 8);
							paneInfG.add(infGr, 2, 9);
							ustage.setCenter(paneInfG);
						}
					});
					gra5.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField cuaHo = new TextField();
							Label alerta = new Label("Por favor complete el campo solicitado.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("CUADRO DE HONOR");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el ID del grado, el programa\n\rmostrará el cuadro de honor.");
							descrip.setFont(new Font("Tahoma", 13));
							vcuah = new Button("Ver cuadro de honor");
							paneCuaH = new GridPane();
							paneCuaH.setAlignment(Pos.CENTER);
							paneCuaH.add(describ,2,1);
							paneCuaH.add(new Label(""), 1, 2);
							paneCuaH.add(descrip,2,3);
							paneCuaH.add(new Label(""), 1, 4);
							paneCuaH.add(alerta,3,5);
							paneCuaH.add(new Label(""), 1, 6);
							paneCuaH.add(new Label("ID*: "),1,7);
							paneCuaH.add(cuaHo,3,7);
							paneCuaH.add(new Label(""), 1, 8);
							paneCuaH.add(vcuah, 2, 9);
							ustage.setCenter(paneCuaH);
						}
					});
					gra6.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField prev = new TextField();
							Label alerta = new Label("Por favor complete el campo solicitado.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("PREVENCION DE BAJO RENDIMIENTO");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el ID del grado, el programa mostrará\n\rlos estudiantes con malos promedios academicos.");
							descrip.setFont(new Font("Tahoma", 13));
							prevB = new Button("Ver prevencion por bajo rendimiento");
							panePrev = new GridPane();
							panePrev.setAlignment(Pos.CENTER);
							panePrev.add(describ,2,1);
							panePrev.add(new Label(""), 1, 2);
							panePrev.add(descrip,2,3);
							panePrev.add(new Label(""), 1, 4);
							panePrev.add(alerta,3,5);
							panePrev.add(new Label(""), 1, 6);
							panePrev.add(new Label("ID*: "),1,7);
							panePrev.add(prev,3,7);
							panePrev.add(new Label(""), 1, 8);
							panePrev.add(prevB, 2, 9);
							ustage.setCenter(panePrev);
						}
					});
					gra7.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField promG = new TextField();
							Label alerta = new Label("Por favor complete el campo solicitado.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("PROMEDIO DEL GRADO");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar el ID del grado, el programa mostrará\n\rel promedio del grado.");
							descrip.setFont(new Font("Tahoma", 13));
							promGr = new Button("Ver promedio");
							paneProG = new GridPane();
							paneProG.setAlignment(Pos.CENTER);
							paneProG.add(describ,2,1);
							paneProG.add(new Label(""), 1, 2);
							paneProG.add(descrip,2,3);
							paneProG.add(new Label(""), 1, 4);
							paneProG.add(alerta,3,5);
							paneProG.add(new Label(""), 1, 6);
							paneProG.add(new Label("ID*: "),1,7);
							paneProG.add(promG,3,7);
							paneProG.add(new Label(""), 1, 8);
							paneProG.add(promGr, 2, 9);
							ustage.setCenter(paneProG);
						}
					});
				} else if (control.equals(asig)) {
					paneAsig = new GridPane();
					title1 = new Label("MENU ASIGNATURA");
					title1.setTextFill(Color.web("BLACK"));
					title1.setFont(new Font("Nirmala UI Semilight Bold", 25));
					asig1 = new Button("Crear asignatura");
					asig2 = new Button("Crear nota");
					paneAsig.setAlignment(Pos.CENTER);
					paneAsig.add(title1, 1, 1);
					paneAsig.add(new Label(""), 1, 2);
					paneAsig.add(new Label(""), 1, 3);
					paneAsig.add(asig1, 1, 4);
					paneAsig.add(new Label(""), 1, 5);
					paneAsig.add(asig2, 1, 6);
					ustage.setCenter(paneAsig);
					asig1.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField crAs1 = new TextField();
							TextField crAs2 = new TextField();
							TextField crAs3 = new TextField();
							Label alerta = new Label("Por favor complete los campos solicitados.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("CREAR ASIGNATURA");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar los datos solicitados, el programa\n\rcreara la asignatura.");
							descrip.setFont(new Font("Tahoma", 13));
							crAs = new Button("Crear");
							paneCrAs = new GridPane();
							paneCrAs.setAlignment(Pos.CENTER);
							paneCrAs.add(describ,2,1);
							paneCrAs.add(new Label(""), 1, 2);
							paneCrAs.add(descrip,2,3);
							paneCrAs.add(new Label(""), 1, 4);
							paneCrAs.add(alerta,3,5);
							paneCrAs.add(new Label(""), 1, 6);
							paneCrAs.add(new Label("ID*: "),1,7);
							paneCrAs.add(crAs1,3,7);
							paneCrAs.add(new Label(""), 1, 8);
							paneCrAs.add(new Label("Nombre*: "),1,9);
							paneCrAs.add(crAs2,3,9);
							paneCrAs.add(new Label(""), 1, 10);
							paneCrAs.add(new Label("Numero de notas*: "),1,11);
							paneCrAs.add(crAs3,3,11);
							paneCrAs.add(new Label(""), 1, 12);
							paneCrAs.add(crAs, 2, 13);
							ustage.setCenter(paneCrAs);
						}
					});
					asig2.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							TextField crNo1 = new TextField();
							TextField crNo2 = new TextField();
							TextField crNo3 = new TextField();
							Label alerta = new Label("Por favor complete los campos solicitados.");
							alerta.setTextFill(Color.web("FIREBRICK"));
							Label describ = new Label("CREAR NOTA");
							describ.setFont(new Font("Tahoma", 17));
							Label descrip = new Label("Al ingresar los datos solicitados, el programa\n\rcreara la nota.");
							descrip.setFont(new Font("Tahoma", 13));
							crNo = new Button("Crear");
							paneCrNo = new GridPane();
							paneCrNo.setAlignment(Pos.CENTER);
							paneCrNo.add(describ,2,1);
							paneCrNo.add(new Label(""), 1, 2);
							paneCrNo.add(descrip,2,3);
							paneCrNo.add(new Label(""), 1, 4);
							paneCrNo.add(alerta,3,5);
							paneCrNo.add(new Label(""), 1, 6);
							paneCrNo.add(new Label("Calificacion*: "),1,7);
							paneCrNo.add(crNo1,3,7);
							paneCrNo.add(new Label(""), 1, 8);
							paneCrNo.add(new Label("ID de la asignatura*: "),1,9);
							paneCrNo.add(crNo2,3,9);
							paneCrNo.add(new Label(""), 1, 10);
							paneCrNo.add(new Label("DNI del estudiante*: "),1,11);
							paneCrNo.add(crNo3,3,11);
							paneCrNo.add(new Label(""), 1, 12);
							paneCrNo.add(crNo, 2, 13);
							ustage.setCenter(paneCrNo);
						}
					});
				}
			}
		}
	};
	
	
	

	public static void main(String args[]) {
		launch(args);
	}

	String ini = "01";
	Stage primario;
	Scene prisce;
	Scene user;
	BorderPane ustage;
	BorderPane p4;
	GridPane p5;
	Label hoja;
	Image imaini;
	ImageView im01;
	Image fot01;
	ImageView prog;
	Menu menucito;
	MenuItem descripcion;
	MenuItem salir;
	MenuItem est;
	MenuItem prof;
	MenuItem gr;
	MenuItem asig;
	MenuItem aruser;
	MenuItem arsalir;
	GridPane paneEst;
	GridPane paneCreEst;
	GridPane paneInfEst;
	GridPane paneMejEst;
	GridPane paneInfoEst;
	GridPane panePro;
	GridPane paneCrePro;
	GridPane paneInfoPro;
	GridPane paneGra;
	GridPane paneCreGr;
	GridPane paneAsiEs;
	GridPane paneInfG;
	GridPane paneCuaH;
	GridPane panePrev;
	GridPane paneProG;
	GridPane paneAsig;
	GridPane paneCrAs;
	GridPane paneCrNo;
	Label title1;
	Button est1;
	Button est2;
	Button est3;
	Button est4;
	Button crear;
	Button informe;
	Button pro1;
	Button pro2;
	Button gra1;
	Button gra2;
	Button gra3;
	Button gra4;
	Button gra5;
	Button gra6;
	Button gra7;
	Button gra8;
	Button crearGr;
	Button asiPr;
	Button asiEs;
	Button infGr;
	Button vcuah;
	Button prevB;
	Button promGr;
	Button asig1;
	Button asig2;
	Button crAs;
	Button crNo;
	
	Label des;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primario = primaryStage;

		// ESCENARIO USER
		// -------------------------------------------------------------------------------
		ustage = new BorderPane();
		Scene user = new Scene(ustage, 650, 420);
		MenuBar mainmenu = new MenuBar();
		Menu archivo = new Menu("Archivo");
		Menu pyc = new Menu("Procesos y consultas");
		Menu aiuda = new Menu("Ayuda");
		mainmenu.getMenus().addAll(archivo, pyc, aiuda);
		ustage.setTop(mainmenu);

		//////////////////////////////////////////////////////
		//USUARIO
		aruser = new MenuItem ("Usuario");
		arsalir = new MenuItem("Salir");
		archivo.getItems().addAll(aruser,arsalir);
		GridPane a = new GridPane();
		GridPane bb = new GridPane();
		ustage.setCenter(a);
//		//-----//
//		Label title = new Label("SYSTOOL");
//		title.setTextFill(Color.web("LIGHTSEAGREEN"));
//		title.setFont(new Font("Nirmala UI Semilight Bold", 50));
//		BorderPane.setAlignment(title, Pos.CENTER);
		
		Image sys = new Image(getClass().getResourceAsStream("/imagenes/01.png"));
		ImageView mysys = new ImageView(sys);
		mysys.setFitWidth(300);
		mysys.setFitHeight(200);
		BorderPane.setAlignment(mysys, Pos.CENTER);
		bb.add(mysys, 1, 1);
		
		a.setAlignment(Pos.CENTER);
		a.add(mysys, 1, 1);
		a.add(bb, 1, 2);
		bb.setAlignment(Pos.CENTER);
		a.setPadding(new Insets(15, 15, 15, 15));
		bb.setPadding(new Insets(15, 15, 15, 15));
		//EVENTOS DE ARCHIVO
		aruser.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ustage.setCenter(a);
				
			}
			
		}
		);
		arsalir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primario.setScene(prisce);
				primario.setTitle("SYSTOOL 2.0v");
			}
			
		}
		);	

		// -------------------------------------------------------------------------------------------
		//PROCESOS Y CONSULTAS
		est = new MenuItem("Estudiante");
		prof = new MenuItem("Profesor");
		gr = new MenuItem("Grado");
		asig = new MenuItem("Asignatura");
		pyc.getItems().addAll(est, prof, gr, asig);
		est.setOnAction(clase);
		prof.setOnAction(clase);
		gr.setOnAction(clase);
		asig.setOnAction(clase);
		

		// -------------------------------------------------------------------------------------------
		
		//AYUDA
		
		MenuItem acerca = new MenuItem("Acerca de SYSTOOL");
		aiuda.getItems().add(acerca);
		Alert info = new Alert(AlertType.NONE);
		acerca.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				info.setAlertType(AlertType.INFORMATION);
				info.setTitle("Conoce sobre SYSTOOL");
				
				info.setHeaderText("SYSTOOL\r\nPlataforma creada por:\r\nCristian David Quinchia Ramirez\r\nDaniela Guardia Cuervo\r\nSebastian Agudelo Osorio");
				info.setContentText("Gracias por preferir SYSTOOL");
				
				info.show();
			}
		
		});
		
		
		
		
		
		
		
		///////////////////////////////////////
		// ESCENARIO DEFAULT
		BorderPane inicio = new BorderPane();
		inicio.setPadding(new Insets(0, 15, 15, 15));
		BorderPane p1 = new BorderPane(); // PANEL IZQUIERDO
		BorderPane p2 = new BorderPane(); // PANEL DERECHO

		// MENU INICIAL
		MenuBar inimenu = new MenuBar();
		menucito = new Menu("Menu");
		inimenu.getMenus().add(menucito);
		inicio.setTop(inimenu);
		descripcion = new MenuItem("Descripcion");
		salir = new MenuItem("Salir");
		menucito.getItems().addAll(descripcion, salir);

		descripcion.setOnAction(descre);
		salir.setOnAction(descre);

		//////////////////////////////

		// PANELES IZQUIERDOS
		GridPane p3 = new GridPane();
		p4 = new BorderPane();
		// PANELES DERECHOS
		GridPane p5 = new GridPane();
		GridPane p6 = new GridPane();
		inicio.setLeft(p1);
		inicio.setRight(p2);
		//p1.setStyle("-fx-border-color: black");
//		p2.setStyle("-fx-border-color: black");
		// DEFAULT DE LOS PANELES
		////////////////////////////////////////
		p1.setTop(p3);
		Label bienvenida = new Label("BIENVENIDO A SYSTOOL");
		bienvenida.setTextFill(Color.web("LIGHTSEAGREEN"));
		bienvenida.setFont(new Font("Nirmala UI Semilight Bold", 22));
		p3.setPadding(new Insets(15, 15, 15, 15));
		p3.setAlignment(Pos.CENTER);
		p3.add(bienvenida, 1, 1);
//		p3.setStyle("-fx-border-color: black");
		////////////////////////////////
		p1.setCenter(p4);
		Button ingre = new Button("Ingresar");
		ingre.setFont(new Font("Tahoma", 17));

		// HANDLER DEL BOTON
		ingre.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primario.setScene(user);
				primario.setTitle("SYSTOOL: Encantado de ayudar");
			}

		});

		imaini = new Image(getClass().getResourceAsStream("/imagenes/01.png"));
		im01 = new ImageView(imaini);
		im01.setOnMouseEntered(movimiento);

		im01.setFitHeight(150);
		im01.setFitWidth(250);
		p4.setBottom(ingre);
		p4.setTop(im01);
		p4.setPadding(new Insets(15, 15, 15, 15));
		BorderPane.setAlignment(ingre, Pos.CENTER);
		BorderPane.setAlignment(im01, Pos.CENTER);
//		p4.setStyle("-fx-border-color: black");
		///////////////////////////////////////////
		p2.setTop(p5);
		hoja = new Label(
				"Sebastian Agudelo Osorio,\r\n20 años, estudiante de la \r\nUniversidad Nacional De Colombia,\r\nproductor, fanático de las tecnologías");
		hoja.setFont(new Font("Tahoma", 15));
		hoja.setOnMousePressed(mouseHandler);
		hoja.setTextFill(Color.web("#000000"));
		hoja.setPrefWidth(300);
		hoja.setPrefHeight(80);
		p5.setPadding(new Insets(15, 15, 15, 15));
		p5.setAlignment(Pos.CENTER);
		p5.add(hoja, 1, 1);
//		p5.setStyle("-fx-border-color: black");

		//////////////////////////////////
		p2.setCenter(p6);
		fot01 = new Image(getClass().getResourceAsStream("/fotos/sebas.png"));
		prog = new ImageView(fot01);
		prog.setFitHeight(200);
		prog.setFitWidth(150);
		p6.add(prog, 1, 1);
		p6.setPadding(new Insets(15, 15, 15, 15));
		p6.setAlignment(Pos.CENTER);
//		p6.setStyle("-fx-border-color: black");
		// FIN DEL DEFAULT
		///////////////////////////////////////////

		///////////////////////////////////

		// ESCENARIO INCICIAL
		primario.setTitle("SYSTOOL 2.0v");
		prisce = new Scene(inicio, 650, 420);
		primario.setScene(prisce);
		primario.show();

		/////////////////////////////////

	}

}
