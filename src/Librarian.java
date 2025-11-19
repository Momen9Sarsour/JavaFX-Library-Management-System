
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
public class Librarian extends Application {

    @Override
    public void start(Stage primary) {
        primary.setTitle("Student screen ");

        Group root = new Group();
        Scene scene = new Scene(root, 400, 500, Color.WHITESMOKE);   // لون الشاشة

        Text scenetitle = new Text("Librarian");
        scenetitle.setLayoutX(150);
        scenetitle.setLayoutY(70);
        scenetitle.setFont(new Font("Arial", 33));
        
        Button view_Book = new Button("View Book");
        view_Book.setLayoutX(100);
        view_Book.setLayoutY(100);
        view_Book.setFont(new Font("Arial", 20));
        view_Book.setPrefSize(200, 40);

        Button view_IssuedBook = new Button("View Issued Books");
        view_IssuedBook.setLayoutX(100);
        view_IssuedBook.setLayoutY(150);
        view_IssuedBook.setFont(new Font("Arial", 20));
        view_IssuedBook.setPrefSize(200, 40);
        
        Button fineBook = new Button("Fine Books");
        fineBook.setLayoutX(100);
        fineBook.setLayoutY(200);
        fineBook.setFont(new Font("Arial", 20));
        fineBook.setPrefSize(200, 40);

        Button logout = new Button("Logout");
        logout.setLayoutX(100);
        logout.setLayoutY(250);
        logout.setFont(new Font("Arial", 20));
        logout.setPrefSize(200, 40);

        root.getChildren().add(scenetitle);
        root.getChildren().add(view_IssuedBook);
        root.getChildren().add(view_Book);
        root.getChildren().add(fineBook);
        root.getChildren().add(logout);
        primary.setScene(scene);
        primary.show();
        
        
        view_Book.setOnAction((ActionEvent event) -> {     
            View_Book infoScenePane = new View_Book();
            infoScenePane.start(primary);
        });
        
        view_IssuedBook.setOnAction((ActionEvent event) -> {     
            viewIssuedBook infoScenePane = new viewIssuedBook();
            infoScenePane.start(primary);
        });
        
        fineBook.setOnAction((ActionEvent event) -> {     
            FineBookLoan infoScenePane = new FineBookLoan();
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
