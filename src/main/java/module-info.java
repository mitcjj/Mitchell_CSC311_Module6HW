module org.example.mitchell_csc311_module6hw {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mitchell_csc311_module6hw to javafx.fxml;
    exports org.example.mitchell_csc311_module6hw;
}