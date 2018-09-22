package jogo.interfaceGrafica;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.scene.text.*;

public class PopupVitoria {

  public static void display(){
      Stage window = new Stage();
      window.setTitle("Parabéns!");

      Button b = new Button("ok");
      b.setOnAction(e -> window.close());

      Text t = new Text("Parabéns você ganhou o jogo!");
      t.setFont(Font.loadFont("",40));
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
