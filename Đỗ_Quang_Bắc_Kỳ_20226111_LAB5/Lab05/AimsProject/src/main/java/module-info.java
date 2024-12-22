/**
 *
 */
/**
 *
 */
module AimsProject {
    requires java.desktop;
    requires javafx.swing;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.base;
    requires java.naming;

    opens hust.soict.itep.aims.screen to javafx.fxml;
    opens hust.soict.itep.aims.media to javafx.base;
}