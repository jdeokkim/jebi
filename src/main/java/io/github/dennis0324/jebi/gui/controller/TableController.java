package io.github.dennis0324.jebi.gui.controller;

import java.io.IOException;

import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import io.github.palexdev.materialfx.utils.NodeUtils;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXIconWrapper;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;



// class TextFieldListener implements EventHandler<ActionEvent> {
//     private final TextField textField ;
//     TextFieldListener(TextField textField) {
//       this.textField = textField ;
//     }

//     @Override
//     public void handle(ActionEvent arg0) {
//         System.out.println("testing");
//         // TODO Auto-generated method stub
        
//     }
// }

class BtnMouseEvent implements EventHandler<ActionEvent>{
    private String path;
    private StackPane contentArea; 
    private TableController tableController;
    public BtnMouseEvent(StackPane contentArea, String path,TableController tableController){
        this.path = path;
        this.contentArea = contentArea;
        this.tableController = tableController;
    }


    @Override
    public void handle(ActionEvent arg0) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource(path));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(parent);
            tableController.getPageLoader().setArgument(tableController);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }        
    }

}

<<<<<<< HEAD

<<<<<<< HEAD
public class TableController extends Controller implements Initializable {
=======
=======
/**
 * 로그인 페이지 컨트롤러를 나타내는 클래스.
 * 
 * @author dennis0324
 */
>>>>>>> 1d61eb3... 테이블 아이템 클릭 이벤트 추가 및 PageLoader파일 수정
public class TableController extends Controller {
>>>>>>> 5d97164... 컨트롤러 추가


    @FXML
    private MFXButton book;

    @FXML
    private StackPane contentArea; //일반 창 변경에 필요함

    @FXML
    private TextField searchBar;

    @FXML
    private MFXButton searchButton;

    @FXML
    private HBox searchContainer;

    @FXML
    private Button setting;

    @FXML
    private StackPane tableArea; //테이블 창 변경에 필요함

    @FXML
    private MFXButton user;

    @FXML
    private StackPane buttonContainer;

    @FXML
    private MFXButton Msetting;

    @FXML
    private MFXIconWrapper testing;


    @FXML
    void testingAction(ActionEvent event) {
        System.out.println(event);
    }

    
    @FXML
    void onSelectBook(ActionEvent event) {
        // getPageLoader().to(tableArea, "/pages/component/tableBookComponent.fxml", this);
        System.out.println("tseting");
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
=======
    public void initialize() {
>>>>>>> 5d97164... 컨트롤러 추가
        
=======
    @FXML
    void onSelectUser(ActionEvent event) {
        // try{
        //     Parent parent = FXMLLoader.load(getClass().getResource("/pages/component/tableBookComponent.fxml"));
        // }
        // contentArea.getChildren().removeAll();
        // contentArea.getChildren().setAll(parent);
        // getPageLoader().setArgument(this);
    }
    
>>>>>>> 1d61eb3... 테이블 아이템 클릭 이벤트 추가 및 PageLoader파일 수정

    public void initialize() {
        searchBar.focusedProperty().addListener(new InvalidationListener() {               
            @Override
            public void invalidated(Observable observable) {
                //here it is changing
                if(searchBar.isFocused()){
                    System.out.print("testing");
                }
                else{
                    System.out.print("testing2");
                }
            }
        });

        searchButton.setOnMouseClicked(event -> {
            System.out.println("mouse clicked");
        });

<<<<<<< HEAD

        MaterialIconView icon = new MaterialIconView(MaterialIcon.SETTINGS, "22"); // 'PERSON' is my icon from fontawesomefx, 22 is the icon size
        
<<<<<<< HEAD
        MFXIconWrapper filterIcon = new MFXIconWrapper(icon, 32).defaultRippleGeneratorBehavior(); // this will create the ripple effect, 32 is the ripple size
        
        Msetting.makeRegionCircular(filterIcon); // this will make the ripple circular
        Msetting.make
=======
        // MFXIconWrapper filterIcon = new MFXIconWrapper(icon, 32).defaultRippleGeneratorBehavior(); // this will create the ripple effect, 32 is the ripple size
        
        // Msetting.makeRegionCircular(filterIcon); // this will make the ripple circular
        // Msetting.make
>>>>>>> 5d97164... 컨트롤러 추가
        
=======
        //설정 버튼 샐성 구역
        MaterialIconView icon = new MaterialIconView(MaterialIcon.SETTINGS, "35"); // 'PERSON' is my icon from fontawesomefx, 22 is the icon size
        testing.setIcon(icon);
        testing.defaultRippleGeneratorBehavior();
        //지역을 둥글게 만들어준다.
        NodeUtils.makeRegionCircular(testing);
>>>>>>> 1d61eb3... 테이블 아이템 클릭 이벤트 추가 및 PageLoader파일 수정
        //
        //각 메뉴 사용자와 책에 클릭 이벤트 부여
        // user.setOnAction(new BtnMouseEvent(tableArea, "/pages/component/tableUserComponent.fxml",this));
        // book.setOnAction(new BtnMouseEvent(tableArea,"/pages/component/tableBookComponent.fxml",this));
        
        //첫 화면 설정
        setDefaultcontentArea();
        setDefaultTableContent();
    }

    /**
     * 클릭 액션 설정구역 기본내용 설정
     * 
     * 
     */

    private void setDefaultcontentArea(){
        Parent parent;
        try{
            parent = FXMLLoader.load(getClass().getResource("/pages/component/defaultSearchComponent.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(parent);
            // getPageLoader().setArgument(this);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 테이블 기본구역 기본 테이블 설정
     * 
     * 
     */
    private void setDefaultTableContent(){
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("/pages/component/tableBookComponent.fxml"));
            tableArea.getChildren().removeAll();
            tableArea.getChildren().setAll(parent);
            // getPageLoader().setArgument(this);

        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 기본 클릭 액션 설정구역의 정보를 반환
     * 
     * @return 변경해야하는 지역의 정보를 반환함
     */
    public StackPane getContentArea(){
        return contentArea;
    }

    /**
     * 테이블 구역의 정보 변환
     * 
     * @return 변경해야하는 지역의 정보를 반환함
     */
    public StackPane getTablePane(){
        return tableArea;
    }

}
