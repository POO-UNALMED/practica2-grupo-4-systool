import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaInicio extends Application {
	public void start(Stage primario) throws Exception{
		BorderPane inicio = new BorderPane();
		BorderPane izqui = new BorderPane();
		BorderPane dere = new BorderPane();
		
		
		
		////////////////////////////////////////
		izqui.setTop(new Label("BIENVENIDO A SYSTOOL"));
		
		
		
		inicio.setLeft(izqui);
		
		
		////////////////////////////////
		
		
		inicio.setRight(dere);
		
		
		
		
		
		
		
		
		
		
		
		primario.setTitle("SYSTOOL 2.0v");
		Scene prisce = new Scene (inicio,400,400);
		primario.setScene(prisce);
		primario.show();
		
	}
	
	public static void main(String args[]) {
		launch(args);
	}
	
	
	
}
