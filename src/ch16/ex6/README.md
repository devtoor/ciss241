16-6

a. Write a Java FX program that re-does 8-1 where the user is asked a question and a button shows the answer.  Use a vertical or horizontal box.

b. Modify part a so the user types the answer and it is checked again the correct answer and tells the user if they are correct.

Enter the following Java FX code into a text editor.  There is an Eclipse plug-in and setting that can be changed to run Java FX Applications, but running at the command prompt is show at the end.

```java
// ex166a.java

/* Bill Wohlleber
 * Exercise 16-6a
 * This program will use javafx
 * */
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.event.*;

public class ex166a extends Application
{
      public void start(Stage stage)
      {
            Label qlab = new Label("What does this application call itself?");
            Button abut = new Button("Answer");
            Label reslab = new Label();
            Font resfont = new Font("Ravie", 24);
            reslab.setFont(resfont);

            VBox vbox = new VBox();
            Insets insets = new Insets(5);
            vbox.setMargin(qlab, insets);
            vbox.setMargin(abut, insets);
            vbox.setMargin(reslab, insets);

            vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(qlab, abut, reslab);

            // inner class
            class ex166aevent implements EventHandler<ActionEvent>
            {
                  public void handle(ActionEvent e)
                  {
                    	reslab.setText("this");
                  }
            }

            abut.setOnAction(new ex166aevent());

            Scene scene = new Scene(vbox, 300, 100);
            stage.setScene(scene);

            stage.setTitle("ex166a");
            stage.show();
      }
}
```

```java
// ex166b.java

/* Bill Wohlleber
 * Exercise 16-6b
 * This program will use javafx
 * */
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.event.*;

public class ex166b extends Application
{
      public void start(Stage stage)
      {
            Label qlab = new Label("What does this application call itself?");
            TextField atext = new TextField();
            Button abut = new Button("Answer");
            Label reslab = new Label();
            Font resfont = new Font("Ravie", 24);
            reslab.setFont(resfont);

            VBox vbox = new VBox();
            Insets insets = new Insets(5);
            
            vbox.setMargin(qlab, insets);
            vbox.setMargin(atext, insets);   
            vbox.setMargin(abut, insets);
            vbox.setMargin(reslab, insets);
            vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(qlab, atext, abut, reslab);

            // inner class
            class ex166bevent implements EventHandler<ActionEvent>
            {
                  public void handle(ActionEvent e)
                  {
                        String s = atext.getText();
                        if (s.equals("this"))
                          	reslab.setText("Correct");
                        else
                          	reslab.setText("Try Again");
                  }
            }

            atext.setOnAction(new ex166bevent());
            abut.setOnAction(new ex166bevent());
            Scene scene = new Scene(vbox, 300, 130);  // higher

            stage.setScene(scene);

            stage.setTitle("ex166b");
            stage.show();
      }
}
```

