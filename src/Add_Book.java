
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
//int id, int year, int numberOfCopyies, double financialValue, String titel,
//String publisher, String author, String status, Copy copiesOfBook
public class Add_Book extends Application {

    @Override
    public void start(Stage primary) {
        primary.setTitle("Add Book ");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);  // عشان نخلي العرض في المنتصف
        grid.setHgap(10);  // للابتعاد عن النصوص 
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 45, 20, 35));

        Text scenetitle = new Text("Add Book");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label idBook = new Label("ID Book:");
        grid.add(idBook, 0, 1);

        TextField idBookTextField = new TextField();
        grid.add(idBookTextField, 1, 1);

        Label titleBook = new Label("Title Book :");
        grid.add(titleBook, 0, 2);

        TextField titleBookTextField = new TextField();
        grid.add(titleBookTextField, 1, 2);

        Label publisherBook = new Label("Publisher Book :");
        grid.add(publisherBook, 0, 3);

        TextField publisherBookTextField = new TextField();
        grid.add(publisherBookTextField, 1, 3);

        Label authorBook = new Label("Author Book :");
        grid.add(authorBook, 0, 4);

        TextField authorBookTextField = new TextField();
        grid.add(authorBookTextField, 1, 4);

        Label yearBook = new Label("Year Book :");
        grid.add(yearBook, 0, 5);

        TextField yearBookTextField = new TextField();
        grid.add(yearBookTextField, 1, 5);

        Label numberOfCopies = new Label("Number of copies :");
        grid.add(numberOfCopies, 0, 6);

        TextField numberOfCopiesTextField = new TextField();
        grid.add(numberOfCopiesTextField, 1, 6);

        Label financialValue = new Label("Financial Value :");
        grid.add(financialValue, 0, 7);

        TextField financialValueTextField = new TextField();
        grid.add(financialValueTextField, 1, 7);

        Button adBook = new Button("Add Book");
        grid.add(adBook, 1, 10);
        adBook.setPrefSize(100, 30);

        Button back = new Button("Back");
        grid.add(back, 1, 12);
        back.setPrefSize(100, 30);

        Scene scene = new Scene(grid, 375, 425);
        primary.setScene(scene);
        primary.show();
        
        back.setOnAction((ActionEvent event) -> {     
            Admin infoScenePane = new Admin();
            infoScenePane.start(primary);
        });
        

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (idBookTextField.getText().isEmpty() || titleBookTextField.getText().isEmpty() || publisherBookTextField.getText().isEmpty() || authorBookTextField.getText().isEmpty() || yearBookTextField.getText().isEmpty() || numberOfCopiesTextField.getText().isEmpty() || financialValueTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "you must enter all fields");
                } else {
                    FileWriter fw = null;
                    try {
                        fw = new FileWriter("Book.txt", true); // في حال لم يكن أصلاً موجوداً و فتحه للكتابة فيه users.txt لإنشاء ملف إسمه FileWriter هنا قمنا بإنشاء كائن نوعه
                        fw.write("id:" + idBookTextField.getText() + ", ");                  // هنا قمنا بكتابة إسم المستخدم في الملف
                        fw.write("title:" + titleBookTextField.getText() + ", ");
                        fw.write("publisher:" + publisherBookTextField.getText() + ",");
                        fw.write("author:" + authorBookTextField.getText() + ", ");
                        fw.write("year:" + yearBookTextField.getText() + ", ");
                        fw.write("numberOfCopies:" + numberOfCopiesTextField.getText() + ", ");
                        fw.write("financialValue:" + financialValueTextField.getText() + "\n\n");
                        fw.flush();                                            // بعدها قمنا بتفريغ الذاكرة
                        fw.close();
                    } catch (IOException ex) {
                        System.out.println("ex : " + ex);
                    }
                    JOptionPane.showMessageDialog(null, "The book has been successfully added !");
                    
                    idBookTextField.setText("");
                    titleBookTextField.setText("");
                    publisherBookTextField.setText("");
                    authorBookTextField.setText("");
                    yearBookTextField.setText("");
                    numberOfCopiesTextField.setText("");
                    financialValueTextField.setText("");
                }

            }
        };

        // when button is pressed
        adBook.setOnAction(event);
        
    }

//    public static void main(String[] args) {
//        launch(args);
//    }

}
