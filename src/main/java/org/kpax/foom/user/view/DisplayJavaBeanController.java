package org.kpax.foom.user.view;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.util.Callback;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Eugen Covaci {@literal eugen.covaci.q@gmail.com}
 * Created on 9/11/2019
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DisplayJavaBeanController {

    @FXML
    private TreeView<String> treeView;

    @FXML
    public void initialize() {
        System.out.println("Initialize");
        CheckBoxTreeItem rootItem = new CheckBoxTreeItem("Vehicles", null, false, true);

        rootItem.getChildren().add(new CheckBoxTreeItem("Cars", null, false, true));
        CheckBoxTreeItem motorcycles = new CheckBoxTreeItem("Motorcycles", null, false, true);

        motorcycles.getChildren().add(new CheckBoxTreeItem("Plains", null, false, true));

        rootItem.getChildren().add(motorcycles);
        treeView.setRoot(rootItem);

        treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {

            @Override
            public TreeCell<String> call(TreeView<String> param) {
                CheckBoxTreeCell<String> checkBoxTreeCell = new CheckBoxTreeCell<>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (getTreeItem() != null && !getTreeItem().isLeaf()) {
                            setGraphic(null);
                        }
                    }

                };
                return checkBoxTreeCell;
            }
        });


    }

    private class NodeContent {
        String value;
        boolean leaf;

        public NodeContent(String value, boolean leaf) {
            this.value = value;
            this.leaf = leaf;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return leaf;
        }

        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }
    }
}
