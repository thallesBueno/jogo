import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.collections.*;
import javafx.scene.text.*;

public class PopupPegar{

  public static void display(String s){
    Stage window = new Stage();
    Scene scene;

    Text text = new Text(s + " agora está no seu inventario!");
    Button buttonOk = new Button("OK");
    buttonOk.setOnAction(e -> window.close());

    HBox pane = new HBox();
    pane.getChildren().addAll(text,buttonOk);
    pane.setAlignment(Pos.CENTER);
    pane.setSpacing(30);
    pane.setPadding(new Insets(40));

    scene = new Scene(pane);
    window.setScene(scene);
    window.showAndWait();
  }
}
