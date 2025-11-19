
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Login_Librarian extends Application {

    static String userName1 = "";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student registration screen");
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

        Button back = new Button("Back ");
        grid.add(back, 1, 5);
        back.setPrefSize(100, 30);

        Scene scene = new Scene(grid, 350, 325);
        primaryStage.setScene(scene);
        primaryStage.show();

        back.setOnAction((ActionEvent event) -> {
            TypeOFUser infoScenePane = new TypeOFUser();
            infoScenePane.start(primaryStage);
        });

        // مش صح  
//        signIn.setOnAction((ActionEvent event) -> {
//            if (userTextField.getText().equals("admin") && pwBox.getText().equals("admin")) {
//                Librarian infoScenePane = new Librarian();
//                infoScenePane.start(primaryStage);
//
//            } else {
//                JOptionPane.showMessageDialog(null, "username or password is incorrect!!!!!");
//            }
//        });
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                boolean findUserLib = false, findPassword = false;

                try {
                    File frLib = new File("Libararian.txt");
                    File frBook = new File("Libararian.txt");

                    Scanner myReaderLib = new Scanner(frLib);
                    Scanner myReaderBook = new Scanner(frBook);

                    ArrayList<String> libData = new ArrayList<>();
                    while (myReaderLib.hasNext() && !findUserLib) {
                        String data = myReaderLib.nextLine();
                        findUserLib = data.contains(userTextField.getText());
                        libData.add(data);
                    }
                    myReaderLib.close();

                    ArrayList<String> bookData = new ArrayList<>();
                    while (myReaderBook.hasNext() && !findPassword) {
                        String data = myReaderBook.nextLine();
                        findPassword = data.contains(pwBox.getText());

                        bookData.add(data);
                    }
                    myReaderBook.close();

                    System.out.println("findLib && findBook : " + findUserLib + " , " + findPassword);

                    if (findUserLib && findPassword) {
                        userName1 = userTextField.getText();
                        Librarian infoScenePane = new Librarian();
                        infoScenePane.start(primaryStage);
                    } else {
                        JOptionPane.showMessageDialog(null, "some error!");
                    }

                } catch (IOException ex) {
                    System.out.println("ex : " + ex);
                }

            }
        };
        // when button is pressed
        signIn.setOnAction(event);

    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}
