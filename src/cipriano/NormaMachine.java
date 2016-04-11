package cipriano;

import java.io.IOException;
import java.util.List;

import cipriano.model.Registrador;
import cipriano.view.DialogRegistradorController;
import cipriano.view.EditorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NormaMachine extends Application {

    private Stage primaryStage;
    private Stage dialogStage;
    private EditorController editorController;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("jNormaMachine");
        this.primaryStage.getIcons().add(new Image("file:resources/images/html_app_32.png"));
        initEditor();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Instancia o editor
     */
    private void initEditor() {
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

    public void showDialog(List<Registrador> registradores){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NormaMachine.class.getResource("view/DialogRegistrador.fxml"));
            VBox vBox = (VBox) loader.load();

            dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setTitle("Registradores");
            dialogStage.setScene(new Scene(vBox));

            DialogRegistradorController controller = loader.getController();
            controller.setNormaMachine(this, registradores);

            dialogStage.showAndWait();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updateRegistors(List<Registrador> registradors){
        dialogStage.close();
        editorController.run(registradors);
    }
}
