package cipriano.view;

import cipriano.NormaMachine;
import cipriano.model.Registrador;
import cipriano.util.EditingCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrique on 09/04/2016.
 */
public class DialogRegistradorController {
    @FXML
    TableView<RegistradorViewModel> tableView;

    @FXML
    TableColumn<RegistradorViewModel, String> colunaNome;

    @FXML
    TableColumn colunaValor;

    @FXML
    ObservableList<RegistradorViewModel> registradorViewModels = FXCollections.observableArrayList();


    private NormaMachine normaMachine;

    @FXML
    public void initialize(){
        Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
                    public TableCell call(TableColumn p) {return new EditingCell();}
                };

        colunaNome.setCellValueFactory(new PropertyValueFactory<RegistradorViewModel, String>("nome"));
        colunaValor.onEditCommitProperty();
        colunaValor.setCellValueFactory(new PropertyValueFactory<RegistradorViewModel, Integer>("valor"));
        colunaValor.setCellFactory(cellFactory);
        colunaValor.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<RegistradorViewModel, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<RegistradorViewModel, Integer> t) {
                ((RegistradorViewModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setValor(t.getNewValue());
            }
        });
    }

    public void exibeModalRegistradores(List<Registrador> registradores){
        for(Registrador r : registradores){
            registradorViewModels.add(new RegistradorViewModel(r.getNome(), r.getValue()));
        }
        tableView.setItems(registradorViewModels);
    }

    @FXML
    public void executar(){
        List<Registrador> registradores = new ArrayList<>();
        for(RegistradorViewModel r : registradorViewModels){
            registradores.add(new Registrador(r.getNome(), r.getValor()));
        }
        normaMachine.updateRegistors(registradores);
    }

    public void setNormaMachine(NormaMachine normaMachine, List<Registrador> registradores) {
        this.normaMachine = normaMachine;
        exibeModalRegistradores(registradores);
    }
}
