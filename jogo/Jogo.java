package jogo;

import javafx.application.Application;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.geometry.*;
import java.util.*;
import javafx.collections.*;
import javafx.scene.text.*;
import jogo.engine.*;
import jogo.ferramentas.*;
import jogo.objetos.*;
import jogo.salas.*;
import jogo.interfaceGrafica.*;

public class Jogo extends Application{

  static Engine engine;
  Scene scene;
  ImageView imgSala;
  ListView<String> portas;
  ListView<String> inventario;
  ListView<String> objetos;
  Stage window;

  public static void main(String[]args){
      engine = new Engine();
      launch();
  }

  @Override
  public void start(Stage primaryStage){
    window = primaryStage;
    //musica
    
    AudioClip musica = new AudioClip("file:jogo/musicas/musica");
    musica.setVolume(0.3);
    musica.play();
    musica.setCycleCount(AudioClip.INDEFINITE);

    //Imagem da sala
    imgSala = new ImageView(new Image ("file:jogo/" + engine.getRepVisual()));
    imgSala.setFitWidth(700);
    imgSala.setFitHeight(500);

    //imagem de fundo
    ImageView fundo = new ImageView();
    fundo.setImage(new Image("file:jogo/imagens/fundo"));
    fundo.setFitWidth(900);
    fundo.setFitHeight(590);

    //button Mutar
    ImageView imageMutar = new ImageView("file:jogo/imagens/mutar");
    imageMutar.setFitWidth(20);
    imageMutar.setFitHeight(20);
    Button mutar = new Button();
    mutar.setPadding(new Insets(15));
    mutar.setGraphic(imageMutar);
    mutar.setOnAction(e -> {
      if(musica.isPlaying())
        musica.stop();
      else
        musica.play();
    });
    // Texto caminhos
    Text textCaminhos = new Text("Perspectivas");
    //textCaminhos.setFont(Font.loadFont("file:fontes/Snacks.ttf", 30));
    textCaminhos.setTextAlignment(TextAlignment.CENTER);
    Text textInventario = new Text("Inventario");
    //textInventario.setFont(Font.loadFont("file:fontes/Snacks.ttf", 30));
    textInventario.setTextAlignment(TextAlignment.CENTER);
    Text textObjetos = new Text("Objetos");
    //textObjetos.setFont(Font.loadFont("file:fontes/Snacks.ttf", 30));
    textObjetos.setTextAlignment(TextAlignment.CENTER);

    //Texto objetos
    Button usar = new Button("Usar");
    usar.setPadding(new Insets(10));
    usar.setOnAction(e -> usar());

    // Lista das portas
    portas = new ListView();
    inventario = new ListView();
    objetos = new ListView();
    attListas();

    // Pane para os textos e listas
    HBox menus = new HBox();
    menus.setAlignment(Pos.CENTER);
    menus.setPadding(new Insets(10));
    menus.setSpacing(15);
    menus.getChildren().addAll(textInventario,inventario,textObjetos,objetos
    ,textCaminhos,portas, usar);

    StackPane sp = new StackPane();
    sp.getChildren().addAll(imgSala, mutar);
    sp.setMaxSize(imgSala.getFitWidth(), imgSala.getFitHeight());
    sp.setAlignment(mutar, Pos.TOP_RIGHT);

    BorderPane bp = new BorderPane();
    bp.setBottom(menus);
    bp.setCenter(sp);

    StackPane pane = new StackPane();
    pane.getChildren().addAll(fundo, bp);
    // criar a scene
    scene = new Scene(pane);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Prisão");
    primaryStage.show();

  }

  public void entrar(String s){
    List<String> aux = engine.entrar(s);
    imgSala.setImage(new Image ("file:jogo/" + engine.getRepVisual()));
    attListas();
    for(String f : aux)
      PopupPegar.display(f);
  }

  public void usar(){
      PopupUsar.display(engine);
      imgSala.setImage(new Image ("file:jogo/" + engine.getRepVisual()));
      attListas();
      if(engine.getVitoria()){
        PopupVitoria.display();
        window.close();
      }
  }

  public void attListas(){
    portas.setOrientation(Orientation.HORIZONTAL);
    portas.setPrefSize(180, 50);
    portas.setItems(FXCollections.observableArrayList(engine.portasDisponiveis()));
    portas.setOnMouseClicked(e -> {
        if(portas.getSelectionModel().getSelectedItem() != null)
          entrar(portas.getSelectionModel().getSelectedItem());
    });

    inventario.setOrientation(Orientation.HORIZONTAL);
    inventario.setPrefSize(180, 50);
    inventario.setItems(FXCollections.observableArrayList(engine.inventario()));
    inventario.setOnMouseClicked(e -> {
      if(inventario.getSelectionModel().getSelectedItem() != null)
          PopupJogo.display(engine.getFerramenta(inventario.getSelectionModel().getSelectedItem()));
    });

    objetos.setOrientation(Orientation.HORIZONTAL);
    objetos.setPrefSize(180, 50);
    objetos.setItems(FXCollections.observableArrayList(engine.objetosDisponiveis()));
    /*objetos.setOnMouseClicked(e -> {
      if(objetos.getSelectionModel().getSelectedItem() != null)
          Popup.display(engine.getObjeto(objetos.getSelectionModel().getSelectedItem()));
    });
    */
  }
}
