package tic.tak.toe;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class GUI extends BorderPane {

    protected final StackPane stackPane;
    protected final BorderPane borderPane;
    protected final Button button;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button0;
    protected final ImageView imageView;
    protected final Button button1;
    protected final ImageView imageView0;
    protected final Button button2;
    protected final ImageView imageView1;
    protected final Button button3;
    protected final ImageView imageView2;
    protected final Button button4;
    protected final ImageView imageView3;
    protected final Button button5;
    protected final ImageView imageView4;
    protected final Button button6;
    protected final ImageView imageView5;
    protected final Button button7;
    protected final ImageView imageView6;
    protected final Button button8;
    protected final ImageView imageView7;
    protected final VBox vBox;
    protected final HBox hBox;
    protected final ComboBox comboBox;
    protected final HBox hBox0;
    protected final Button button9;
    protected final Text text;
    protected final Button button10;
    protected final Text text0;
    protected final HBox hBox1;
    protected final TextField textField;
    protected final Pane pane;
    protected final ImageView imageView8;
    protected final Text text1;
    protected final ScrollPane scrollPane;
    protected final VBox vBox0;
    protected final Pane pane0;
    protected final HBox hBox2;
    protected final Button button11;
    protected final ImageView imageView9;
    protected final Button button12;
    protected final ImageView imageView10;
    protected final Button button13;
    protected final ImageView imageView11;
    protected final Pane pane1;
    protected final Pane pane2;
    protected final Button button14;
    protected final Button button15;

    public GUI() {

        stackPane = new StackPane();
        borderPane = new BorderPane();
        button = new Button();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button0 = new Button();
        imageView = new ImageView();
        button1 = new Button();
        imageView0 = new ImageView();
        button2 = new Button();
        imageView1 = new ImageView();
        button3 = new Button();
        imageView2 = new ImageView();
        button4 = new Button();
        imageView3 = new ImageView();
        button5 = new Button();
        imageView4 = new ImageView();
        button6 = new Button();
        imageView5 = new ImageView();
        button7 = new Button();
        imageView6 = new ImageView();
        button8 = new Button();
        imageView7 = new ImageView();
        vBox = new VBox();
        hBox = new HBox();
        comboBox = new ComboBox();
        hBox0 = new HBox();
        button9 = new Button();
        text = new Text();
        button10 = new Button();
        text0 = new Text();
        hBox1 = new HBox();
        textField = new TextField();
        pane = new Pane();
        imageView8 = new ImageView();
        text1 = new Text();
        scrollPane = new ScrollPane();
        vBox0 = new VBox();
        pane0 = new Pane();
        hBox2 = new HBox();
        button11 = new Button();
        imageView9 = new ImageView();
        button12 = new Button();
        imageView10 = new ImageView();
        button13 = new Button();
        imageView11 = new ImageView();
        pane1 = new Pane();
        pane2 = new Pane();
        button14 = new Button();
        button15 = new Button();

        setPrefHeight(621.0);
        setPrefWidth(747.0);

        BorderPane.setAlignment(stackPane, javafx.geometry.Pos.CENTER);
        stackPane.setPrefHeight(150.0);
        stackPane.setPrefWidth(200.0);

        borderPane.setFocusTraversable(true);
        borderPane.setPrefHeight(397.0);
        borderPane.setPrefWidth(725.0);

        BorderPane.setAlignment(button, javafx.geometry.Pos.CENTER);
        button.setMnemonicParsing(false);
        button.setPrefHeight(49.0);
        button.setPrefWidth(751.0);
        button.setText("RESTART GAME");
        button.setFont(new Font(25.0));
        borderPane.setBottom(button);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setMaxHeight(USE_PREF_SIZE);
        gridPane.setMaxWidth(USE_PREF_SIZE);
        gridPane.setMinHeight(USE_PREF_SIZE);
        gridPane.setMinWidth(USE_PREF_SIZE);
        gridPane.setPrefHeight(275.0);
        gridPane.setPrefWidth(368.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        BorderPane.setMargin(gridPane, new Insets(10.0));

        button0.setMnemonicParsing(false);
        button0.setPrefHeight(229.0);
        button0.setPrefWidth(365.0);
        button0.setStyle("-fx-background-color: #ffffff;");
        button0.getStyleClass().add("pane_style_right");
        button0.getStylesheets().add("/tic/tak/toe/tic.css");

        imageView.setFitHeight(75.0);
        imageView.setFitWidth(100.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        button0.setGraphic(imageView);

        GridPane.setColumnIndex(button1, 1);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(205.0);
        button1.setPrefWidth(257.0);
        button1.setStyle("-fx-background-color: #ffffff;");
        button1.getStyleClass().add("pane_style_background");
        button1.getStylesheets().add("/tic/tak/toe/tic.css");

        imageView0.setFitHeight(75.0);
        imageView0.setFitWidth(100.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        button1.setGraphic(imageView0);

        GridPane.setColumnIndex(button2, 2);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(238.0);
        button2.setPrefWidth(314.0);
        button2.setStyle("-fx-background-color: #ffffff;");
        button2.getStyleClass().add("pane_style_left");
        button2.getStylesheets().add("/tic/tak/toe/tic.css");

        imageView1.setFitHeight(75.0);
        imageView1.setFitWidth(100.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        button2.setGraphic(imageView1);

        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(277.0);
        button3.setPrefWidth(349.0);
        button3.setStyle("-fx-background-color: #ffffff;");
        button3.getStyleClass().add("pane_style_all_except_left");
        button3.getStylesheets().add("/tic/tak/toe/tic.css");

        imageView2.setFitHeight(75.0);
        imageView2.setFitWidth(100.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        button3.setGraphic(imageView2);

        GridPane.setColumnIndex(button4, 1);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(285.0);
        button4.setPrefWidth(366.0);
        button4.setStyle("-fx-background-color: #ffffff;");
        button4.getStyleClass().add("pane_style_all");
        button4.getStylesheets().add("/tic/tak/toe/tic.css");

        imageView3.setFitHeight(75.0);
        imageView3.setFitWidth(100.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        button4.setGraphic(imageView3);

        GridPane.setColumnIndex(button5, 2);
        GridPane.setRowIndex(button5, 1);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(319.0);
        button5.setPrefWidth(508.0);
        button5.setStyle("-fx-background-color: #ffffff;");
        button5.getStyleClass().add("pane_style_all_except_right");
        button5.getStylesheets().add("/tic/tak/toe/tic.css");

        imageView4.setFitHeight(75.0);
        imageView4.setFitWidth(100.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        button5.setGraphic(imageView4);

        GridPane.setRowIndex(button6, 2);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(251.0);
        button6.setPrefWidth(495.0);
        button6.setStyle("-fx-background-color: #ffffff;");
        button6.getStyleClass().add("pane_style_right");
        button6.getStylesheets().add("/tic/tak/toe/tic.css");

        imageView5.setFitHeight(75.0);
        imageView5.setFitWidth(100.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        button6.setGraphic(imageView5);

        GridPane.setColumnIndex(button7, 1);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(220.0);
        button7.setPrefWidth(458.0);
        button7.setStyle("-fx-background-color: #ffffff;");
        button7.getStyleClass().add("pane_style_background");
        button7.getStylesheets().add("/tic/tak/toe/tic.css");

        imageView6.setFitHeight(75.0);
        imageView6.setFitWidth(100.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        button7.setGraphic(imageView6);

        GridPane.setColumnIndex(button8, 2);
        GridPane.setRowIndex(button8, 2);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(220.0);
        button8.setPrefWidth(568.0);
        button8.setStyle("-fx-background-color: #ffffff;");
        button8.getStyleClass().add("pane_style_left");
        button8.getStylesheets().add("/tic/tak/toe/tic.css");

        imageView7.setFitHeight(75.0);
        imageView7.setFitWidth(100.0);
        imageView7.setPickOnBounds(true);
        imageView7.setPreserveRatio(true);
        button8.setGraphic(imageView7);
        gridPane.setOpaqueInsets(new Insets(0.0));
        borderPane.setCenter(gridPane);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(131.0);
        vBox.setPrefWidth(747.0);

        comboBox.setPrefHeight(28.0);
        comboBox.setPrefWidth(199.0);
        comboBox.setTranslateX(20.0);
        comboBox.setTranslateY(10.0);

        hBox0.setPrefHeight(43.0);
        hBox0.setPrefWidth(747.0);
        hBox0.setTranslateY(10.0);

        button9.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        button9.setEllipsisString("");
        button9.setMinWidth(53.0);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(39.0);
        button9.setPrefWidth(180.0);
        button9.setStyle("-fx-background-color: #19b5fe;");
        button9.setText("X");
        button9.setTranslateX(250.0);
        button9.setFont(new Font("Arial Black", 11.0));

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("-");
        text.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text.setWrappingWidth(128.91811561584473);
        button9.setGraphic(text);

        button10.setCenterShape(false);
        button10.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        button10.setEllipsisString("");
        button10.setMinWidth(53.0);
        button10.setMnemonicParsing(false);
        button10.setPrefHeight(39.0);
        button10.setPrefWidth(179.0);
        button10.setStyle("-fx-background-color: #19b5fe;");
        button10.setText("O");
        button10.setTranslateX(340.0);
        button10.setFont(new Font("Arial Black", 11.0));
        button10.setOpaqueInsets(new Insets(0.0));

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("-");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text0.setWrappingWidth(128.91811561584473);
        button10.setGraphic(text0);

        hBox1.setTranslateY(20.0);

        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setEditable(false);
        textField.setPrefHeight(28.0);
        textField.setPrefWidth(292.0);
        textField.setText("Game Over");
        textField.setTranslateX(300.0);
        borderPane.setTop(vBox);

        pane.setPrefHeight(584.0);
        pane.setPrefWidth(747.0);
        pane.setScaleX(0.65);
        pane.setScaleY(0.65);
        pane.getStyleClass().add("win_pane");
        pane.getStylesheets().add("/tic/tak/toe/tic.css");
        pane.setTranslateY(25.0);

        imageView8.setFitHeight(287.0);
        imageView8.setFitWidth(330.0);
        imageView8.setLayoutX(200.0);
        imageView8.setLayoutY(124.0);
        imageView8.setPickOnBounds(true);
        imageView8.setPreserveRatio(true);
        imageView8.setTranslateY(-20.0);

        text1.setLayoutX(233.0);
        text1.setLayoutY(503.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Text");
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(204.3164005279541);
        text1.setFont(new Font(34.0));

        StackPane.setAlignment(scrollPane, javafx.geometry.Pos.CENTER_LEFT);
        scrollPane.setMaxHeight(USE_PREF_SIZE);
        scrollPane.setMaxWidth(USE_PREF_SIZE);
        scrollPane.setMinHeight(USE_PREF_SIZE);
        scrollPane.setMinWidth(USE_PREF_SIZE);
        scrollPane.setPrefHeight(399.0);
        scrollPane.setPrefWidth(157.0);

        vBox0.setPrefHeight(460.0);
        vBox0.setPrefWidth(144.0);
        scrollPane.setContent(vBox0);

        pane0.setPrefHeight(621.0);
        pane0.setPrefWidth(587.0);
        pane0.setScaleX(0.2);
        pane0.setScaleY(0.06);
        pane0.setTranslateX(299.0);
        pane0.setTranslateY(-168.0);

        hBox2.setPrefHeight(650.0);
        hBox2.setPrefWidth(757.0);

        button11.setMaxHeight(USE_PREF_SIZE);
        button11.setMaxWidth(USE_PREF_SIZE);
        button11.setMinHeight(USE_PREF_SIZE);
        button11.setMinWidth(USE_PREF_SIZE);
        button11.setMnemonicParsing(false);
        button11.setPrefHeight(581.0);
        button11.setPrefWidth(200.0);

        imageView9.setFitHeight(150.0);
        imageView9.setFitWidth(200.0);
        imageView9.setPickOnBounds(true);
        imageView9.setPreserveRatio(true);
        imageView9.setRotate(180.0);
        imageView9.setScaleX(1.2000000000000002);
        imageView9.setScaleY(2.5);
        imageView9.setImage(new Image(getClass().getResource("../../../images/arrow.png").toExternalForm()));
        button11.setGraphic(imageView9);

        button12.setMaxHeight(USE_PREF_SIZE);
        button12.setMaxWidth(USE_PREF_SIZE);
        button12.setMinHeight(USE_PREF_SIZE);
        button12.setMinWidth(USE_PREF_SIZE);
        button12.setMnemonicParsing(false);
        button12.setPrefHeight(581.0);
        button12.setPrefWidth(200.0);
        button12.setTranslateX(15.0);

        imageView10.setFitHeight(517.0);
        imageView10.setFitWidth(150.0);
        imageView10.setPickOnBounds(true);
        imageView10.setPreserveRatio(true);
        imageView10.setScaleY(3.5999999999999996);
        imageView10.setImage(new Image(getClass().getResource("../../../images/Actions-media-record-icon.png").toExternalForm()));
        button12.setGraphic(imageView10);

        button13.setMaxHeight(USE_PREF_SIZE);
        button13.setMaxWidth(USE_PREF_SIZE);
        button13.setMinHeight(USE_PREF_SIZE);
        button13.setMinWidth(USE_PREF_SIZE);
        button13.setMnemonicParsing(false);
        button13.setPrefHeight(581.0);
        button13.setPrefWidth(200.0);
        button13.setTranslateX(30.0);

        imageView11.setFitHeight(150.0);
        imageView11.setFitWidth(200.0);
        imageView11.setPickOnBounds(true);
        imageView11.setPreserveRatio(true);
        imageView11.setScaleX(1.2000000000000002);
        imageView11.setScaleY(2.5);
        imageView11.setImage(new Image(getClass().getResource("../../../images/arrow.png").toExternalForm()));
        button13.setGraphic(imageView11);

        pane1.setPrefHeight(200.0);
        pane1.setPrefWidth(200.0);

        pane2.setMaxHeight(USE_PREF_SIZE);
        pane2.setMaxWidth(USE_PREF_SIZE);
        pane2.setMinHeight(USE_PREF_SIZE);
        pane2.setMinWidth(USE_PREF_SIZE);
        pane2.setPrefHeight(60.0);
        pane2.setPrefWidth(200.0);
        pane2.setStyle("-fx-background-color: #333;");
        pane2.setTranslateX(272.0);
        pane2.setTranslateY(227.0);

        button14.setLayoutX(117.0);
        button14.setLayoutY(14.0);
        button14.setMnemonicParsing(false);
        button14.setText("accept");

        button15.setLayoutX(27.0);
        button15.setLayoutY(14.0);
        button15.setMnemonicParsing(false);
        button15.setText("refuse");
        setCenter(stackPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button0);
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(button2);
        gridPane.getChildren().add(button3);
        gridPane.getChildren().add(button4);
        gridPane.getChildren().add(button5);
        gridPane.getChildren().add(button6);
        gridPane.getChildren().add(button7);
        gridPane.getChildren().add(button8);
        hBox.getChildren().add(comboBox);
        vBox.getChildren().add(hBox);
        hBox0.getChildren().add(button9);
        hBox0.getChildren().add(button10);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(textField);
        vBox.getChildren().add(hBox1);
        stackPane.getChildren().add(borderPane);
        pane.getChildren().add(imageView8);
        pane.getChildren().add(text1);
        stackPane.getChildren().add(pane);
        stackPane.getChildren().add(scrollPane);
        hBox2.getChildren().add(button11);
        hBox2.getChildren().add(button12);
        hBox2.getChildren().add(button13);
        pane0.getChildren().add(hBox2);
        stackPane.getChildren().add(pane0);
        stackPane.getChildren().add(pane1);
        pane2.getChildren().add(button14);
        pane2.getChildren().add(button15);
        stackPane.getChildren().add(pane2);

    }
}
