package uiMain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
			if (mouseEvent.getEventType().toString().equals("MOUSE_PRESSED") && hoja.getText().equals("Sebastian Agudelo Osorio,\r\n20 años, estudiante de la \r\nUniversidad Nacional De Colombia,\r\nproductor, fanatico de las tecnologias")) {
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
						"Sebastian Agudelo Osorio,\r\n20 años, estudiante de la \r\nUniversidad Nacional De Colombia,\r\nproductor, fanatico de las tecnologias");
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
				imaini = new Image(getClass().getResourceAsStream("/imagenes/01.jpg"));
				im01.setImage(imaini);
			} else if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("02")) {
				ini = "03";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/02.jpeg"));
				im01.setImage(imaini);
			} else if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("03")) {
				ini = "04";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/03.jpg"));
				im01.setImage(imaini);
			} else if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("04")) {
				ini = "05";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/04.jpeg"));
				im01.setImage(imaini);
			} else if (mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("05")) {
				ini = "01";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/05.png"));
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
					title1 = new Label("GONORREA");
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
				} else if(control.equals(prof)) {
					
				} else if (control.equals(gr)) {
					
				} else if (control.equals(asig)) {
					
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
	GridPane paneEst;
	GridPane paneCreEst;
	Label title1;
	Button est1;
	Button est2;
	Button est3;
	Button est4;
	Button crear;
	
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

		// BorderPane arch = new BorderPane();
		GridPane a = new GridPane();
		GridPane bb = new GridPane();
		ustage.setCenter(a);
		Label title = new Label("SYSTOOL");
		title.setTextFill(Color.web("LIGHTSEAGREEN"));
		title.setFont(new Font("Nirmala UI Semilight Bold", 50));
		a.setAlignment(Pos.CENTER);
		a.add(title, 1, 1);
		a.add(bb, 1, 2);
		bb.setAlignment(Pos.CENTER);
		Button exit = new Button("Salir");
		exit.setFont(new Font("Tahoma", 17));
		///ustage.setBottom();
		a.setPadding(new Insets(15, 15, 15, 15));
		bb.add(exit, 1, 1);
		BorderPane.setAlignment(title, Pos.CENTER);
		// HANDLER DEL BOTON
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primario.setScene(prisce);
				primario.setTitle("SYSTOOL 2.0v");
			}

		});
		
		

		// -------------------------------------------------------------------------------------------

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

		imaini = new Image(getClass().getResourceAsStream("/imagenes/sparta.jpg"));
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
				"Sebastian Agudelo Osorio,\r\n20 años, estudiante de la \r\nUniversidad Nacional De Colombia,\r\nproductor, fanatico de las tecnologias");
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
