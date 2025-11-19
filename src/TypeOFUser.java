
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOMEN
 */
public class TypeOFUser extends Application {
    
    

    @Override
    public void start(Stage primary) {
        primary.setTitle("Choose the type of user ");
        
        Text scenetitle = new Text("User identification");
        scenetitle.setLayoutX(80);
        scenetitle.setLayoutY(70);
        scenetitle.setFont(new Font("Arial", 33));
        
        Group root = new Group();
        Scene scene = new Scene(root,400,400,Color.WHITESMOKE);
        Button admin_Login = new Button("Admin Login");
        admin_Login.setLayoutX(100);
        admin_Login.setLayoutY(100);
        admin_Login.setFont(new Font("Arial", 20));; // button حجم وشكل
        admin_Login.setPrefSize(200,40);
        
        Button librarian_Login = new Button("Librarian Login");
        librarian_Login.setLayoutX(100);
        librarian_Login.setLayoutY(150);
        librarian_Login.setFont(new Font("Arial", 20));
        librarian_Login.setPrefSize(200,40);
        
        Button back = new Button("Back");
        back.setLayoutX(100);
        back.setLayoutY(300);
        back.setFont(new Font("Arial", 20));
        back.setPrefSize(200,40);
        
        root.getChildren().add(scenetitle);
        root.getChildren().add(admin_Login);
        root.getChildren().add(librarian_Login);
        root.getChildren().add(back);
        primary.setScene(scene);
        primary.show();
        
        admin_Login.setOnAction((ActionEvent event) -> {
            Login_Admin infoScenePane = new Login_Admin();
            infoScenePane.start(primary);
            
        });
        
        librarian_Login.setOnAction((ActionEvent event) -> {
            Login_Librarian infoScenePane = new Login_Librarian();
            infoScenePane.start(primary);
            
        });

        back.setOnAction((ActionEvent event) -> {     
            User_SignUp_LogIn infoScenePane = new User_SignUp_LogIn();
            infoScenePane.start(primary);
        });
        
    }
//    public static void main(String[] args) {
//        launch(args);
//    }
}
