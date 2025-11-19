
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MOMEN
 */
public class Login_Admin extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Administrator record screen");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);  // عشان نخلي العرض في المنتصف
        grid.setHgap(10);  // للابتعاد عن النصوص 
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Sign In");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();  // مربع نصي خاص لاخفاء كلمة السر 
        grid.add(pwBox, 1, 2);

        Button signIn = new Button("Sign in");
        grid.add(signIn, 1, 3);
        signIn.setPrefSize(100, 30);

        Button back = new Button("Back");
        grid.add(back, 1, 5);
        back.setPrefSize(100, 30);

        Scene scene = new Scene(grid, 350, 325);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        signIn.setOnAction((ActionEvent event) -> {
            if (userTextField.getText().equals("admin") && pwBox.getText().equals("admin")) {
                Admin infoScenePane = new Admin();
                infoScenePane.start(primaryStage);

            } else {
                JOptionPane.showMessageDialog(null, "username or password is incorrect!!!!!");
            }
        });
        
        back.setOnAction((ActionEvent event) -> {     
            TypeOFUser infoScenePane = new TypeOFUser();
            infoScenePane.start(primaryStage);
        });

    }
//    public static void main(String[] args) {
//        launch(args);
//    }
}
