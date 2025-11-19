
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
public class Admin extends Application {

    @Override
    public void start(Stage primary) {
        primary.setTitle("Admin ");

        Group root = new Group();
        Scene scene = new Scene(root, 400, 500, Color.WHITESMOKE);
        
        Text scenetitle = new Text("Admin");
        scenetitle.setLayoutX(150);
        scenetitle.setLayoutY(70);
        scenetitle.setFont(new Font("Arial", 33));
        
        Button add_Book = new Button("Add Book");
        add_Book.setLayoutX(100);
        add_Book.setLayoutY(100);
        add_Book.setFont(new Font("Arial", 20));
        add_Book.setPrefSize(200, 40);

        Button add_Libararian = new Button("Add Libararian"); // اضافة طالب
        add_Libararian.setLayoutX(100);
        add_Libararian.setLayoutY(150);
        add_Libararian.setFont(new Font("Arial", 20));
        add_Libararian.setPrefSize(200, 40);
        
        Button BookLoan = new Button("Book Loan");
        BookLoan.setLayoutX(100);
        BookLoan.setLayoutY(200);
        BookLoan.setFont(new Font("Arial", 20));
        BookLoan.setPrefSize(200, 40);

        Button view_Librarian = new Button("View Librarian");   // بدو يعرض اسماء الطلاب
        view_Librarian.setLayoutX(100);
        view_Librarian.setLayoutY(250);
        view_Librarian.setFont(new Font("Arial", 20));
        view_Librarian.setPrefSize(200, 40);

        Button return_Book = new Button("Return Book");
        return_Book.setLayoutX(100);
        return_Book.setLayoutY(300);
        return_Book.setFont(new Font("Arial", 20));
        return_Book.setPrefSize(200, 40);
        
//        Button viewBook = new Button("View Book"); // عرض جميع الكتب
//        viewBook.setLayoutX(100);
//        viewBook.setLayoutY(350);
//        viewBook.setFont(new Font("Arial", 20));
//        viewBook.setPrefSize(200, 40);

        Button logout = new Button("Logout");    // رجوع للقائمة السابقة
        logout.setLayoutX(100);
        logout.setLayoutY(350);
        logout.setFont(new Font("Arial", 20));
        logout.setPrefSize(200, 40);

        //btn.setStyle("-fx-background-color: #ff0000; ");   بيخلي لون الزر احمر
        //btn.setFont(new Font("Arial", 20));   // button هنا قمنا بتغيير نوع و حجم خط الكائن
        // btn.setTextFill(Color.RED);    // button هنا قمنا بتغيير لون خط الكائن
        root.getChildren().add(scenetitle);
        root.getChildren().add(add_Book);
        root.getChildren().add(add_Libararian);
        root.getChildren().add(BookLoan);
        root.getChildren().add(view_Librarian);
        root.getChildren().add(return_Book);
        root.getChildren().add(logout);
        primary.setScene(scene);
        primary.show();
        
        
        add_Book.setOnAction((ActionEvent event) -> {
            Add_Book infoScenePane = new Add_Book();
            infoScenePane.start(primary);
        });
        
        add_Libararian.setOnAction((ActionEvent event) -> {
            Add_Libararian infoScenePane = new Add_Libararian();
            infoScenePane.start(primary);
        });

        
        BookLoan.setOnAction((ActionEvent event) -> {
            BookLoan_GUI infoScenePane = new BookLoan_GUI();
            infoScenePane.start(primary);
        });
        
        view_Librarian.setOnAction((ActionEvent event) -> {     
            ViewLibrarian infoScenePane = new ViewLibrarian();
            infoScenePane.start(primary);
        });
        
        return_Book.setOnAction((ActionEvent event) -> {     // لسا مش جاهزة
            ReturnBook infoScenePane = new ReturnBook();
            infoScenePane.start(primary);
        });
        
        logout.setOnAction((ActionEvent event) -> {
            TypeOFUser infoScenePane = new TypeOFUser();
            infoScenePane.start(primary);
        });
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}
