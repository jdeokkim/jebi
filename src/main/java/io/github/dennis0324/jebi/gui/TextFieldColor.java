package io.github.dennis0324.jebi.gui;


import javafx.scene.control.TextField;

/**
 * @author dennis ko
 */
public class TextFieldColor {
    private TextField textField;

    /**
     * 색깔 변경하기 위한 `enum` 변수
     * 
     * 
     */
    public enum TextfieldType{
        idle,
        wrong
    }

    public TextFieldColor(TextField textField){
        this.textField = textField;
    }

    /**
     * 색깔 변경 클라스
     * 
     */
    public void setState(TextfieldType type){
        for(int i = 0; i < textField.getStylesheets().size(); i++){
            textField.getStylesheets().remove(i);
        }
        if(type == TextfieldType.idle){
            textField.getStylesheets().add(getClass().getResource("/css/customMFXTextField.css").toString());
        }
        else if(type == TextfieldType.wrong){
            textField.getStylesheets().add(getClass().getResource("/css/customMFXTextFieldWrong.css").toString());
        }
    }
}