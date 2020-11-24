package uiMain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VentanaInicio extends Application {
	public static void main(String args[]) {
		launch(args);
	}
	
	Stage primario;
	Scene prisce;
	Scene user;
	BorderPane ustage;
	GridPane p5;
	Label hoja1;
	TextArea hoja;
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
		//DEFAULT DE LOS PANELES
		////////////////////////////////////////
		p1.setTop(p3);
		Label bienvenida = new Label("BIENVENIDO A SYSTOOL");
		bienvenida.setTextFill(Color.web("#6666FF"));
		p3.setPadding(new Insets(15,15,15,15));
		p3.setAlignment(Pos.CENTER);
		p3.add(bienvenida, 1, 1);
		
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
		
		
		Image imaini = new Image(getClass().getResourceAsStream("/imagenes/sparta.jpg"));
		ImageView im01 = new ImageView(imaini);
		im01.setFitHeight(200);
		im01.setFitWidth(200);
		p4.setBottom(ingre);
		p4.setTop(im01);
		p4.setPadding(new Insets(15,15,15,15));
		BorderPane.setAlignment(ingre, Pos.CENTER);
		BorderPane.setAlignment(im01, Pos.CENTER);
		
		///////////////////////////////////////////
		p2.setTop(p5);
		Label hoja1 = new Label("Sebastian Agudelo Osorio,\r\n20 años, me gusta la pepsi, la animación y la musica");
		Label hoja2 = new Label("Daniela Guardia Cuervo,\r\n20 años, me gusta la pepsi, la animación y la musica");
		Label hoja3 = new Label("Cristian David Quinchia Ramirez,\r\n20 años, me gusta la pepsi, la animación y la musica");
		hoja1.setTextFill(Color.web("#000000"));
		hoja1.setPrefWidth(50);
		hoja1.setPrefHeight(50);
		p5.setPadding(new Insets(15,15,15,15));
		p5.setAlignment(Pos.CENTER);
		p5.add(hoja1,1,1);
		p5.setStyle("-fx-border-color: black");
		
		//////////////////////////////////
		p2.setCenter(p6);
		Image fot01 = new Image(getClass().getResourceAsStream("/fotos/sebas.png"));
		ImageView prog = new ImageView(fot01);
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
	
	
	

