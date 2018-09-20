import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.scene.text.*;


public class Popup {

   public static void display(FerramentaFX f){
      display(f.getDescricao(), f.getNome());
   }

   public static void display(ObjetoFX o){
      display(o.getDescricao(), o.getNome());
   }

  public static void display(String descricao, String nome){
      Stage window = new Stage();
      window.setTitle(nome);

      Button b = new Button("ok");
      b.setOnAction(e -> window.close());

      Text t = new Text(descricao);
      t.setFont(Font.loadFont("",25));
      t.setTextAlignment(TextAlignment.CENTER);

      HBox hb = new HBox(t,b);
      hb.setAlignment(Pos.CENTER);
      hb.setSpacing(20);
      hb.setPadding(new Insets(20));

      Scene scene = new Scene(hb);
      window.setScene(scene);
      window.showAndWait();
  }
}
