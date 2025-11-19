
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
public class FineBookLoan extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fine Book Loan");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);  // عشان نخلي العرض في المنتصف
        grid.setHgap(10);  // للابتعاد عن النصوص 
        grid.setVgap(10);

        Text scenetitle = new Text("Fine Book Loan");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Text fineBook = new Text("");
        fineBook.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(fineBook, 0, 2, 4, 3);

        // لاظهار اسماء الطلاب هنا بدنا مربع نصي

        
        Button back = new Button("Back");
        grid.add(back, 1, 5);
        back.setPrefSize(100, 30);

        Scene scene = new Scene(grid, 1050, 625);
        primaryStage.setScene(scene);
        primaryStage.show();

        back.setOnAction((ActionEvent event) -> {     
            Librarian infoScenePane = new Librarian();
            infoScenePane.start(primaryStage);
        });
        
        File frLib = new File("Loan Book.txt");
        ArrayList<String> libData = new ArrayList<>();
        boolean findLib = false;
        try {
            Scanner myReaderLib = new Scanner(frLib);
            while (myReaderLib.hasNext()) {
                String data = myReaderLib.nextLine();
                findLib = data.contains(Login_Librarian.userName1);
                if (findLib) {
                    libData.add(data);
                    System.out.println("findLib : " + findLib);
                }

            }
            myReaderLib.close();
        } catch (FileNotFoundException ex) {
            System.out.println("ex : " + ex);        }

        String result = "";
        for (String i : libData) {
            result += (i + "\n");

        }
        fineBook.setText(result);
        System.out.println("libData " + libData);
        
        
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
    
}
