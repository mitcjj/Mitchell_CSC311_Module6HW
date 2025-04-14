package org.example.mitchell_csc311_module6hw;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class takes the information from the Form created in the FormApplication
 * and displays that information to the user.
 * The user can then create a new Form and start all over again.
 *
 * @author Jared Mitchell
 */
public class FormDisplayController implements Initializable {
    @FXML
    private VBox root;
    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label email;
    @FXML
    private Label dob;
    @FXML
    private Label zipCode;

    /**
     * Returns the user to the FormFiller page to fill out another form.
     *
     * @author Jared Mitchell
     */
    @FXML
    private void newForm(){
        Parent newRoot;
        Scene scene = root.getScene();
        try{
            newRoot = FXMLLoader.load(getClass().getResource("formFiller-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene.setRoot(newRoot);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        firstName.setText("Your first name is " + FormApplication.display.getFirstName() );
        lastName.setText("Your last name is " + FormApplication.display.getLastName() );
        email.setText("Your email is " + FormApplication.display.getEmail() );
        dob.setText("Your date of birth is " + FormApplication.display.getDob() );
        zipCode.setText("Your zip code is " + FormApplication.display.getZipCode() );
    }
}
