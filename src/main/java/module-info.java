module org.yesser.app {
    requires javafx.controls;
    requires  javafx.fxml;
    requires org.hibernate.orm.core;

    exports org.yesser.app;

    opens org.yesser.controller to javafx.fxml;

}