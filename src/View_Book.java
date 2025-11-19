
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
public class View_Book extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("View Book screen");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);  // عشان نخلي العرض في المنتصف
        grid.setHgap(10);  // للابتعاد عن النصوص 
        grid.setVgap(10);

        Text scenetitle = new Text("View Book");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Text viewBook = new Text("");
        viewBook.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(viewBook, 0, 1, 2, 1);
        
        // لاظهار اسماء الكتب هنا بدنا مربع نصي
        File frLib = new File("Book.txt");
        ArrayList<String> libData = new ArrayList<>();

        try {
            Scanner myReaderLib = new Scanner(frLib);
            while (myReaderLib.hasNext()) {
                String data = myReaderLib.nextLine();
                //   findLib = data.contains(idLibaraianTextField.getText());
                libData.add(data);
            }
            myReaderLib.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        }

        String result = "";
        for (String i : libData) {
            result += (i + "\n");

        }
        viewBook.setText(result);

        Button back = new Button("Back ");
        grid.add(back, 1, 5);
        back.setPrefSize(100, 30);

        Scene scene = new Scene(grid, 950, 655);
        primaryStage.setScene(scene);
        primaryStage.show();

        
        back.setOnAction((ActionEvent event) -> {
            Librarian infoScenePane = new Librarian();
            infoScenePane.start(primaryStage);
        });

    }

//    public static void main(String[] args) {
//        launch(args);
//    }

}
