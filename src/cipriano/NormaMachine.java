package cipriano;

import java.io.IOException;

import cipriano.view.EditorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class NormaMachine extends Application {

    private Stage primaryStage;
    private EditorController editorController;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("jNormaMachine");
        initEditor();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Instancia o editor
     */
    public void initEditor() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NormaMachine.class.getResource("view/Editor.fxml"));
            BorderPane painel = (BorderPane) loader.load();

            Scene scene = new Scene(painel);
            primaryStage.setScene(scene);

            editorController = loader.getController();
            editorController.setNormaMachine(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
