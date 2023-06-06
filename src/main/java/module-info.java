module bk201.dev.autoledger {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens bk201.dev.autoledger to javafx.fxml;
    exports bk201.dev.autoledger;
}