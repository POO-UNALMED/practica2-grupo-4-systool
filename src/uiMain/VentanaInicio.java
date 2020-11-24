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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VentanaInicio extends Application {
	
	//MOUSE EVENTO CLICK
	
	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() { 
	@Override
	public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getEventType().toString().equals("MOUSE_PRESSED") && hoja.getText().equals("Sebastian Agudelo Osorio,\r\n20 años, me gusta la pepsi, la animación y la musica\r\nUniversidad Nacional De Colombia")) {
				hoja.setText("Daniela Guardia Cuervo,\r\n20 años, me gusta la pepsi, la animación y la musica");
				fot01=new Image(getClass().getResourceAsStream("/fotos/dani.png"));
				prog.setImage(fot01);
				
			}
			else if(mouseEvent.getEventType().toString().equals("MOUSE_PRESSED") && hoja.getText().equals("Daniela Guardia Cuervo,\r\n20 años, me gusta la pepsi, la animación y la musica")) {
				hoja.setText("Cristian David Quinchia Ramirez,\r\n20 años, me gusta la pepsi, la animación y la musica");
				fot01=new Image(getClass().getResourceAsStream("/fotos/cris.png"));
				prog.setImage(fot01);
			}
			else if(mouseEvent.getEventType().toString().equals("MOUSE_PRESSED") && hoja.getText().equals("Cristian David Quinchia Ramirez,\r\n20 años, me gusta la pepsi, la animación y la musica")) {
				hoja.setText("Sebastian Agudelo Osorio,\r\n20 años, me gusta la pepsi, la animación y la musica\r\nUniversidad Nacional De Colombia");
				fot01=new Image(getClass().getResourceAsStream("/fotos/sebas.png"));
				prog.setImage(fot01);
			}
	}	
	
	};
	
	
	EventHandler<MouseEvent> movimiento = new EventHandler<MouseEvent>() { 
		@Override
		public void handle(MouseEvent mouseEvent) {
			
			if(mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("01") ) {
				ini = "02";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/01.jpg"));
				im01.setImage(imaini);
			}
			else if(mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("02")) {
				ini = "03";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/02.jpeg"));
				im01.setImage(imaini);
			}else if(mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("03")) {
				ini = "04";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/03.jpg"));
				im01.setImage(imaini);
			}else if(mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("04")) {
				ini = "05";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/04.jpeg"));
				im01.setImage(imaini);
			}else if(mouseEvent.getEventType().toString().equals("MOUSE_ENTERED") && ini.equals("05")) {
				ini = "01";
				imaini = new Image(getClass().getResourceAsStream("/imagenes/05.png"));
				im01.setImage(imaini);
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
	GridPane p5;
	Label hoja;
	Image imaini;
	ImageView im01;
	Image fot01;
	ImageView prog;
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primario = primaryStage;

		//ESCENARIO USER
		BorderPane ustage = new BorderPane();
		Scene user = new Scene(ustage,650,420);
		MenuBar mainmenu = new MenuBar();
		Menu profe = new Menu("Profesor");
		Menu grado = new Menu("Grado");
		Menu studen = new Menu("Estudiante");
		mainmenu.getMenus().addAll(profe, grado, studen);
		ustage.setTop(mainmenu);
		////////////////////////////////////////////
		
		
		///////////////////////////////////////
		//ESCENARIO DEFAULT
		BorderPane inicio = new BorderPane();
		inicio.setPadding(new Insets(15,15,15,15));
		BorderPane p1 = new BorderPane(); //PANEL IZQUIERDO
		BorderPane p2 = new BorderPane(); //PANEL DERECHO
		//PANELES IZQUIERDOS
		GridPane p3 = new GridPane();
		BorderPane p4 = new BorderPane();
		//PANELES DERECHOS
		GridPane p5 = new GridPane();
		GridPane p6 = new GridPane();
		inicio.setLeft(p1);
		inicio.setRight(p2);
		p1.setStyle("-fx-border-color: black");
		p2.setStyle("-fx-border-color: black");
		//DEFAULT DE LOS PANELES
		////////////////////////////////////////
		p1.setTop(p3);
		Label bienvenida = new Label("BIENVENIDO A SYSTOOL");
		bienvenida.setTextFill(Color.web("#6666FF"));
		p3.setPadding(new Insets(15,15,15,15));
		p3.setAlignment(Pos.CENTER);
		p3.add(bienvenida, 1, 1);
		p3.setStyle("-fx-border-color: black");
		////////////////////////////////
		p1.setCenter(p4);
		Button ingre = new Button("Ingresar");
		
		//HANDLER DEL BOTON
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
		
		im01.setFitHeight(200);
		im01.setFitWidth(200);
		p4.setBottom(ingre);
		p4.setTop(im01);
		p4.setPadding(new Insets(15,15,15,15));
		BorderPane.setAlignment(ingre, Pos.CENTER);
		BorderPane.setAlignment(im01, Pos.CENTER);
		p4.setStyle("-fx-border-color: black");
		///////////////////////////////////////////
		p2.setTop(p5);
		hoja = new Label("Sebastian Agudelo Osorio,\r\n20 años, me gusta la pepsi, la animación y la musica\r\nUniversidad Nacional De Colombia");
		hoja.setOnMousePressed(mouseHandler);
		hoja.setTextFill(Color.web("#000000"));
		hoja.setPrefWidth(300);
		hoja.setPrefHeight(50);
		p5.setPadding(new Insets(15,15,15,15));
		p5.setAlignment(Pos.CENTER);
		p5.add(hoja,1,1);
		p5.setStyle("-fx-border-color: black");
		
		//////////////////////////////////
		p2.setCenter(p6);
		fot01 = new Image(getClass().getResourceAsStream("/fotos/sebas.png"));
		prog = new ImageView(fot01);
		prog.setFitHeight(200);
		prog.setFitWidth(150);
		p6.add(prog,1,1);
		p6.setPadding(new Insets(15,15,15,15));
		p6.setAlignment(Pos.CENTER);
		p6.setStyle("-fx-border-color: black");
		//FIN DEL DEFAULT
		///////////////////////////////////////////
		
		///////////////////////////////////
		
		//ESCENARIO INCICIAL
		primario.setTitle("SYSTOOL 2.0v");
		Scene prisce = new Scene (inicio,650,420);
		primario.setScene(prisce);
		primario.show();
		
		/////////////////////////////////
		
	}
	

	

}
	
	
	

