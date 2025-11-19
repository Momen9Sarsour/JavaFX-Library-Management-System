
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
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
public class BookLoan_GUI extends Application {

    @Override
    public void start(Stage primary) {
        primary.setTitle("BOOK LOAN ");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);  // عشان نخلي العرض في المنتصف
        grid.setHgap(10);  // للابتعاد عن النصوص 
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 45, 20, 35));

        Text scenetitle = new Text("Book Loan");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label idBook = new Label("ID Book:");
        grid.add(idBook, 0, 1);

        TextField idBookTextField = new TextField();
        grid.add(idBookTextField, 1, 1);

        Label userNameLibrarian = new Label("UserName Librarian :");
        grid.add(userNameLibrarian, 0, 2);

        TextField userNameLibaraianTextField = new TextField();
        grid.add(userNameLibaraianTextField, 1, 2);

        Label dateLoan = new Label("Date Loan :");
        grid.add(dateLoan, 0, 3);

        TextField dateLoanTextField = new TextField();
        dateLoanTextField.setText(Date.valueOf(LocalDate.now()).toString());
        grid.add(dateLoanTextField, 1, 3);

        Label dateReturnBook = new Label("Date Return Book :");
        grid.add(dateReturnBook, 0, 4);

        TextField dateReturnBookTextField = new TextField();
        grid.add(dateReturnBookTextField, 1, 4);

        Label financialValue = new Label("Financial Value :");
        grid.add(financialValue, 0, 5);

        TextField financialValueTextField = new TextField();
        grid.add(financialValueTextField, 1, 5);

        Button loanBook = new Button("Loan Book");
        grid.add(loanBook, 1, 10);
        loanBook.setPrefSize(100, 30);

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
                boolean findLib = false, findBook = false;
                if (idBookTextField.getText().isEmpty() || userNameLibaraianTextField.getText().isEmpty() || dateReturnBookTextField.getText().isEmpty() || financialValueTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "you must enter username and password and date and Financial ");

                } else {
                    try {
                        FileWriter fw = new FileWriter("Loan Book.txt", true);     // في حال لم يكن أصلاً موجوداً و فتحه للكتابة فيه users.txt لإنشاء ملف إسمه FileWriter هنا قمنا بإنشاء كائن نوعه
                        File frLib = new File("Libararian.txt");
                        File frBook = new File("Book.txt");

                        Scanner myReaderLib = new Scanner(frLib);
                        Scanner myReaderBook = new Scanner(frBook);

                        ArrayList<String> libData = new ArrayList<>();
                        while (myReaderLib.hasNext() && !findLib) {
                            String data = myReaderLib.nextLine();
                            findLib = data.contains(userNameLibaraianTextField.getText());
                            libData.add(data);
                        }
                        myReaderLib.close();

                        ArrayList<String> bookData = new ArrayList<>();
                        while (myReaderBook.hasNext() && !findBook) {
                            String data = myReaderBook.nextLine();
                            findBook = data.contains(idBookTextField.getText());

                            bookData.add(data);
                        }
                        myReaderBook.close();
                        //  System.out.println("libData.contains(idLibaraianTextField.getText()) : " + libData.contains(idLibaraianTextField.getText()));
                        //  System.out.println("\n\nlibData : " + libData);

                        System.out.println("findLib && findBook : " + findLib + " , " + findBook);

                        if (findLib && findBook) {
                            fw.write("id book: " + idBookTextField.getText() + ", ");                  // هنا قمنا بكتابة إسم المستخدم في الملف          
                            fw.write("username Libaraian: " + userNameLibaraianTextField.getText() + ", ");
                            fw.write("Date from: " + dateLoanTextField.getText() + ", ");
                            fw.write("return date: " + dateReturnBookTextField.getText() + ", ");
                            fw.write("financial Value: " + financialValueTextField.getText() + "\n\n");
                            fw.flush();                                            // بعدها قمنا بتفريغ الذاكرة
                            fw.close();                                            // بعدها قمنا بإغلاق الكائن المتصل بالملف

                            JOptionPane.showMessageDialog(null, "The book has been successfully borrowed !");
                            
                            idBookTextField.setText("");
                            userNameLibaraianTextField.setText("");
                            dateReturnBookTextField.setText("");
                            financialValueTextField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "some error!");
                        }

                    } catch (IOException ex) {
                        System.out.println("ex : " + ex);
                    }
                }

            }
        };
        // when button is pressed
        loanBook.setOnAction(event);

    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}
