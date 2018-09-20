import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.collections.*;
import javafx.scene.text.*;

public class PopupUsar{

 public static void display(Engine engine){

      Stage window = new Stage();

      window.initModality(Modality.APPLICATION_MODAL);
      window.setTitle("Usar");
      window.setMinWidth(250);

      Text t1 = new Text("Usar");

      Text t2 = new Text("no/na");

      ListView<String> ferramentas = new ListView(FXCollections.observableArrayList(engine.inventario()));
      ferramentas.setMaxSize(200,50);

      ListView<String> objetos = new ListView(FXCollections.observableArrayList(engine.objetosDisponiveis()));
      objetos.setMaxSize(200,50);

      Button buttonUsar = new Button("Usar");

      buttonUsar.setOnAction(e ->{
            String[] aux = new String[2];
            aux[0] = ferramentas.getSelectionModel().getSelectedItem();
            aux[1] = objetos.getSelectionModel().getSelectedItem();

            if(aux[0] != null && aux[1] != null)
              engine.usar(aux[0],aux[1]);

            window.close();
        });

      buttonUsar.setAlignment(Pos.CENTER);

      HBox hb = new HBox();
      hb.getChildren().addAll(t1,ferramentas,t2,objetos, buttonUsar);
      hb.setSpacing(25);
      hb.setPadding(new Insets(40));
      hb.setAlignment(Pos.CENTER);

      Scene scene = new Scene(hb);
      window.setScene(scene);
      window.showAndWait();

  }
}
