package org.example.mitchell_csc311_module6hw;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class uses regular expression to determine if the values given by the user meet the necessary guidelines.
 * Once they do, the "add" Button is enabled, allowing the user to commit the information to the display Form
 * created in the FormApplication class.
 * Booleans are used to determine if the user's inputs have met the criteria to prevent the passing of null values.
 *
 * @author Jared Mitchell
 */
public class FormFillerController {
    @FXML
    private VBox root;

    private boolean firstNameCorrect = false;
    private boolean lastNameCorrect = false;
    private boolean emailCorrect = false;
    private boolean dobCorrect = false;
    private boolean zipCorrect = false;

    /**
     * The names must use only alphabetical characters,
     * at a length of at least 2 characters but no more than 25 characters.
     *
     * @author Jared Mitchell
     */
    Pattern namePattern = Pattern.compile("[A-z]{2,25}+");
    Matcher firstNameMatcher;
    Matcher lastNameMatcher;

    /**
     * The email must be one from Farmingdale State College.
     *
     * @author Jared Mitchell
     */
    Pattern emailPattern = Pattern.compile("\\w+@farmingdale.edu");
    Matcher emailMatcher;

    /**
     * The date of birth requires the user to enter two digits, a /, two digits, a /,
     * and four more digits precisely.
     *
     * @author Jared Mitchell
     */
    Pattern dobPattern = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");
    Matcher dobMatcher;

    /**
     * The zip code requires exactly five digits.
     *
     * @author Jared Mitchell
     */
    Pattern zipPattern = Pattern.compile("\\d{5}");
    Matcher zipMatcher;

    @FXML
    private Label firstNameLabel;
    @FXML
    private TextField firstNameField;

    /**
     * Checks is the given first name is valid.
     *
     * @author Jared Mitchell
     */
    @FXML
    private void firstNameIsCorrect(){
        firstNameMatcher = namePattern.matcher(firstNameField.getText());
        if(!firstNameMatcher.matches()){
            firstNameCorrect = false;
            firstNameLabel.setText("Your first name does not meet the guidelines");
        } else {
            firstNameCorrect = true;
            firstNameLabel.setText("");
        }
    }

    @FXML
    private Label lastNameLabel;
    @FXML
    private TextField lastNameField;

    /**
     * Checks is the given last name is valid.
     *
     * @author Jared Mitchell
     */
    @FXML
    private void lastNameIsCorrect(){
        lastNameMatcher = namePattern.matcher(lastNameField.getText());
        if(!lastNameMatcher.matches()){
            lastNameCorrect = false;
            lastNameLabel.setText("Your last name does not meet the guidelines");
        } else {
            lastNameCorrect = true;
            lastNameLabel.setText("");
        }
    }

    @FXML
    private Label emailLabel;
    @FXML
    private TextField emailField;

    /**
     * Checks is the given email, when made all lowercase, is valid.
     *
     * @author Jared Mitchell
     */
    @FXML
    private void emailIsCorrect() {
        emailMatcher = emailPattern.matcher(emailField.getText().toLowerCase());
        if(!emailMatcher.matches()){
            emailCorrect = false;
            emailLabel.setText("Your email does not meet the guidelines");
        } else {
            emailCorrect = true;
            emailLabel.setText("");
        }
    }

    @FXML
    private Label dobLabel;
    @FXML
    private TextField dobField;

    /**
     * Checks is the given date of birth is using the valid format.
     *
     * @author Jared Mitchell
     */
    @FXML
    private void dobIsCorrect() {
        dobMatcher = dobPattern.matcher(dobField.getText());
        if(!dobMatcher.matches()){
            dobCorrect = false;
            dobLabel.setText("Your date of birth does not meet the guidelines");
        } else {
            dobCorrect = true;
            dobLabel.setText("");
        }
    }

    @FXML
    private Label zipLabel;
    @FXML
    private TextField zipField;

    /**
     * Checks is the given zip code is valid.
     *
     * @author Jared Mitchell
     */
    @FXML
    private void zipIsCorrect() {
        zipMatcher = zipPattern.matcher(zipField.getText());
        if(!zipMatcher.matches()){
            zipCorrect = false;
            zipLabel.setText("Your zip code does not meet the guidelines");
        } else {
            zipCorrect = true;
            zipLabel.setText("");
        }
    }

    @FXML
    private Button addButton;

    /**
     * When the user has correctly entered all values, the add button is enabled.
     * If anything changes, the add button is disabled.
     *
     * @author Jared Mitchell
     */
    @FXML
    private void enableAddButton(){
        if(firstNameCorrect&& lastNameCorrect&& emailCorrect&& dobCorrect&& zipCorrect){
            addButton.setDisable(false);
        } else {
            addButton.setDisable(true);
        }
    }

    /**
     * Commits the information given to the display Form created in the FormApplication class,
     * then takes the user to the FormDisplay page.
     *
     * @author Jared Mitchell
     */
    @FXML
    protected void onAddButtonClick() {
        FormApplication.display = new Form(firstNameField.getText(), lastNameField.getText(), emailField.getText(), dobField.getText(), zipField.getText());
        Parent newRoot;
        Scene scene = root.getScene();
        try{
            newRoot = FXMLLoader.load(getClass().getResource("formDisplay-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene.setRoot(newRoot);
    }
}