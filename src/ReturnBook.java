
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class ReturnBook extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Return Book");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);  // عشان نخلي العرض في المنتصف
        grid.setHgap(10);  // للابتعاد عن النصوص 
        grid.setVgap(10);
        //grid.setPadding(new Insets(0, 5, 15, 15));

        Text scenetitle = new Text("Return Book ");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label idBook = new Label("ID Book :");
        grid.add(idBook, 0, 1);

        TextField idBookTextField = new TextField();
        grid.add(idBookTextField, 1, 1);
        
        Label userNameLibrarian = new Label("UserName Librarian :");
        grid.add(userNameLibrarian, 0, 2);

        TextField userNameLibrarianTextField = new TextField();
        grid.add(userNameLibrarianTextField, 1, 2);


//        Button isThere = new Button("Is There ");
//        grid.add(isThere, 1, 3);
//        isThere.setPrefSize(100, 30);

        Button returnBook = new Button("Return Book ");
        grid.add(returnBook, 1, 4);
        returnBook.setPrefSize(100, 30);

        Button back = new Button("Back ");
        grid.add(back, 1, 5);
        back.setPrefSize(100, 30);

        Scene scene = new Scene(grid, 350, 325);
        primaryStage.setScene(scene);
        primaryStage.show();

        

        back.setOnAction((ActionEvent event) -> {
            Admin infoScenePane = new Admin();
            infoScenePane.start(primaryStage);

        });

//        returnBook.setOnAction((ActionEvent event) -> {
//            JOptionPane.showMessageDialog(null, "The book has been returned !");
//            Admin infoScenePane = new Admin();
//            infoScenePane.start(primaryStage);
//        });
        
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                boolean findIdBook = false, findUserName = false;

                try {
                    FileWriter fw = new FileWriter("Loan Book.txt", true);    // في حال لم يكن أصلاً موجوداً و فتحه للكتابة فيه users.txt لإنشاء ملف إسمه FileWriter هنا قمنا بإنشاء كائن نوعه
                    File frLib = new File("Loan Book.txt");
                    File frBook = new File("Loan Book.txt");

                    Scanner myReaderLib = new Scanner(frLib);
                    Scanner myReaderBook = new Scanner(frBook);

                    ArrayList<String> libData = new ArrayList<>();
                    while (myReaderLib.hasNext() && !findIdBook) {
                        String data = myReaderLib.nextLine();
                        findIdBook = data.contains(idBookTextField.getText());
                        libData.add(data);
                    }
                    myReaderLib.close();

                    ArrayList<String> bookData = new ArrayList<>();
                    while (myReaderBook.hasNext() && !findUserName) {
                        String data = myReaderBook.nextLine();
                        findUserName = data.contains(userNameLibrarianTextField.getText());
                        bookData.add(data);
                    }
                    myReaderBook.close();

                    System.out.println("findLib && findBook : " + findIdBook + " , " + findUserName);

                    if (findIdBook && findUserName) {
                        JOptionPane.showMessageDialog(null, "The book has been returned !");
                        idBookTextField.setText("");
                        userNameLibrarianTextField.setText("");
//                        Librarian infoScenePane = new Librarian();
//                        infoScenePane.start(primaryStage);
                    } else {
                        JOptionPane.showMessageDialog(null, "some error!");
                        
                    }

                } catch (IOException ex) {
                    System.out.println("ex : " + ex);
                }

            }
        };
        // when button is pressed
        returnBook.setOnAction(event);
        
    }

//    public static void main(String[] args) {
//        launch(args);
//    }

}
