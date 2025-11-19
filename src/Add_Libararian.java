
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class Add_Libararian extends Application {

    @Override
    public void start(Stage primary) {
        primary.setTitle("Add Libararian ");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);  // عشان نخلي العرض في المنتصف
        grid.setHgap(10);  // للابتعاد عن النصوص 
        grid.setVgap(10);
        grid.setPadding(new Insets(45, 45, 55, 65));

        Text scenetitle = new Text("Add Librarian");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label firstName = new Label("First Name:");
        grid.add(firstName, 0, 1);

        TextField firstNameTextField = new TextField();
        grid.add(firstNameTextField, 1, 1);

        Label lastName = new Label("last Name:");
        grid.add(lastName, 0, 2);

        TextField lastNameTextField = new TextField();
        grid.add(lastNameTextField, 1, 2);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 3);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 3);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 4);

        PasswordField pwBox = new PasswordField();  // مربع نصي خاص لاخفاء كلمة السر 
        grid.add(pwBox, 1, 4);

        Button addLib = new Button("Add Libararian");
        grid.add(addLib, 1, 6);
        addLib.setPrefSize(150, 40);

        Button back = new Button("Back");
        grid.add(back, 1, 9);
        back.setPrefSize(150, 50);

        Scene scene = new Scene(grid, 350, 325);
        primary.setScene(scene);
        primary.show();
        
        back.setOnAction((ActionEvent event) -> {     
            Admin infoScenePane = new Admin();
            infoScenePane.start(primary);
        });
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (userTextField.getText().isEmpty() || pwBox.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "you must enter username and password");

                } else {
                    try {
                        FileWriter fw = new FileWriter("Libararian.txt", true);     // في حال لم يكن أصلاً موجوداً و فتحه للكتابة فيه users.txt لإنشاء ملف إسمه FileWriter هنا قمنا بإنشاء كائن نوعه
                        
                        fw.write("Name: ( " + firstNameTextField.getText() + " ");
                        fw.write(lastNameTextField.getText() + " )\n");
                        fw.write("username: " + userTextField.getText() + "\n");                  // هنا قمنا بكتابة إسم المستخدم في الملف
                        fw.write("password: " + pwBox.getText() + "\n\n");            // ثم قمنا بكتابة كلمة المرور
                        fw.flush();                                            // بعدها قمنا بتفريغ الذاكرة
                        fw.close();                                            // بعدها قمنا بإغلاق الكائن المتصل بالملف
                        JOptionPane.showMessageDialog(null, "Student has been successfully added !");
                        firstNameTextField.setText("");
                        lastNameTextField.setText("");
                        userTextField.setText("");
                        pwBox.setText("");

                    } catch (IOException ex) {
                        System.out.println("ex : " + ex);
                    }
                }

            }
        };

        // when button is pressed
        addLib.setOnAction(event);

    }

//    public static void main(String[] args) {
//        launch(args);
//    }

}
