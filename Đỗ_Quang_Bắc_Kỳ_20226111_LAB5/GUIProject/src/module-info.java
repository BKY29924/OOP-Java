/**
 * 
 */
/**
 * 
 */
module GUIProject {
	requires java.desktop;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.controls;

	opens hust.soict.dsai.javafx to javafx.fxml;
    exports hust.soict.dsai.javafx;
}