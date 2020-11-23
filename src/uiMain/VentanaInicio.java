package uiMain;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VentanaInicio extends Application {
	public void start(Stage primario) throws Exception{
		BorderPane inicio = new BorderPane();
		inicio.setPadding(new Insets(15,15,15,15));
		
		BorderPane p1 = new BorderPane();
		BorderPane p2 = new BorderPane();
		
		GridPane p3 = new GridPane();
		BorderPane p4 = new BorderPane();
		GridPane p5 = new GridPane();
		GridPane p6 = new GridPane();
		
		inicio.setLeft(p1);
		inicio.setRight(p2);
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
		Image imaini = new Image(getClass().getResourceAsStream("/imagenes/sparta.jpg"));
		ImageView im01 = new ImageView(imaini);
		Label imalabel = new Label("SYSTOOL", new ImageView(imaini));
		p4.setBottom(ingre);
		p4.setTop(imalabel);
		p4.setPadding(new Insets(15,15,15,15));
		p4.setAlignment(ingre, Pos.CENTER);
		//p4.setAlignment(imalabel, Pos.CENTER);
		
		///////////////////////////////////////////
		p2.setTop(p5);
		Label hoja1 = new Label("Pues me gustan los monitos chinos y pues tambien soy JOvenciTO,\r\n tengo 20 y me gusta la pepsi dos mas dos es cuatro y me quiero morir");
		
		hoja1.setTextFill(Color.web("#000000"));
		hoja1.setPrefWidth(380);
		hoja1.setPrefHeight(10);
		p5.setPadding(new Insets(15,15,15,15));
		p5.setAlignment(Pos.CENTER);
		p5.add(hoja1,1,1);
		
		
		//////////////////////////////////
		p2.setCenter(p6);
		
		
		
		
		
		
		
		
		
		
		primario.setTitle("SYSTOOL 2.0v");
		Scene prisce = new Scene (inicio,600,380);
		primario.setScene(prisce);
		primario.show();
		
	}
	
	public static void main(String args[]) {
		launch(args);
	}
	
	
	
}
