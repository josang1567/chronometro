module Chornometre {
    requires javafx.controls;
    requires javafx.fxml;

    opens Chornometre to javafx.fxml;
    exports Chornometre;
}
