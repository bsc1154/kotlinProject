module com.example.kotlinproject {
    requires javafx.controls;
    requires javafx.fxml;
                requires kotlin.stdlib;
    
                            
    opens com.example.kotlinproject to javafx.fxml;
    exports com.example.kotlinproject;
}