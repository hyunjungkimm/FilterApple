package GUI_;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class Event {
    public static void main(String[] args) {
        Button button = new Button("Send");
      /*  
      오류 원인 찾기
      button.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                label.setText("Sent");
            }
        });
        //람다
        button.setOnAction((ActionEvent event) -> label.setText("Sent!!"));*/
    }
}
