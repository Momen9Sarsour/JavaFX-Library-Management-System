
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
public class viewIssuedBook extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("View Issued Book ");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);  // عشان نخلي العرض في المنتصف
        grid.setHgap(10);  // للابتعاد عن النصوص 
        grid.setVgap(10);

        Text scenetitle = new Text("View Issued Book ");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Text viewIssued = new Text("");
        viewIssued.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(viewIssued, 0, 2, 4, 3);

        //  هنا بدنا مربع نصي لاظهار اسماء الكتب التي استعارها
        Button back = new Button("Back ");
        grid.add(back, 1 , 5);
        back.setPrefSize(100, 30);

        Scene scene = new Scene(grid, 1050, 655);
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
        viewIssued.setText(result);
        System.out.println("libData " + libData);
    }

//    public static void main(String[] args) {
//        launch(args);
//    }

}
