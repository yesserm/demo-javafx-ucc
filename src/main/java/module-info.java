module org.yesser.app {
    requires javafx.controls;
    requires  javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.naming;
    requires org.apache.logging.log4j;
    requires java.persistence;

    exports org.yesser.app;

    opens org.yesser.controller to javafx.fxml;
    opens org.yesser.model to org.hibernate.orm.core;

}