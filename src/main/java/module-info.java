module com.exam_java.exam_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires TrayNotification;


    opens com.exam_java.exam_java to javafx.fxml;
    exports com.exam_java.exam_java;
}