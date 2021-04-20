module com.grupo7.gameespolapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.grupo7.gameespolapp to javafx.fxml;
    exports com.grupo7.gameespolapp;
}