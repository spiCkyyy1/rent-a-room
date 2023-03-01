module com.example.rentrooms {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.rentrooms to javafx.fxml;
    exports com.example.rentrooms;
    exports com.example.rentrooms.Manager;
    opens com.example.rentrooms.Manager to javafx.fxml;
    exports com.example.rentrooms.DataHandler;
    opens com.example.rentrooms.DataHandler to javafx.fxml;
    exports com.example.rentrooms.Clerks;
    opens com.example.rentrooms.Clerks to javafx.fxml;
    exports com.example.rentrooms.Table;
    opens com.example.rentrooms.Table to javafx.fxml;
}