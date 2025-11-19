
/*
اسماء المشاركين في المشروع       
            مؤمن بسام صرصور
            يوسف رجب الخطيب
            خلدون رافت نجم
*/


import javafx.application.Application;
import static javafx.application.Application.launch;
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
public class User_SignUp_LogIn extends Application {

    @Override
    public void start(Stage primary) {
        primary.setTitle("Choose the type of user ");
        
        Group root = new Group();
        Scene scene = new Scene(root,400,400,Color.WHITESMOKE);
        
        Text scenetitle = new Text("Entry Limit ");
        scenetitle.setLayoutX(120);
        scenetitle.setLayoutY(70);
        scenetitle.setFont(new Font("Arial", 33));
        
        Button signUp = new Button("User SignUp");
        signUp.setLayoutX(100);
        signUp.setLayoutY(100);
        signUp.setFont(new Font("Arial", 20));; // button حجم وشكل
        signUp.setPrefSize(200,40);
        
        Button login = new Button("User Login");
        login.setLayoutX(100);
        login.setLayoutY(150);
        login.setFont(new Font("Arial", 20));
        login.setPrefSize(200,40);
        
        root.getChildren().add(scenetitle);
        root.getChildren().add(signUp);
        root.getChildren().add(login);
        primary.setScene(scene);
        primary.show();
     
        login.setOnAction((ActionEvent event) -> {
            TypeOFUser infoScenePane = new TypeOFUser();
            infoScenePane.start(primary);
            
        });
        
        signUp.setOnAction((ActionEvent event) -> {
            SignUp infoScenePane = new SignUp();
            infoScenePane.start(primary);
            
        });

    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
