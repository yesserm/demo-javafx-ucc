module org.yesser.app {
    requires javafx.controls;
    requires  javafx.fxml;
    exports org.yesser.app;

    opens org.yesser.controller to javafx.fxml;
}