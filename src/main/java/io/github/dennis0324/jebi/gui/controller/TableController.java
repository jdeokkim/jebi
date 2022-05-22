/*
 * jebi: A book management software made with JavaFX.
 * 
 * Copyright (c) 2022 Dennis Ko (https://github.com/dennis0324)
 * Copyright (c) 2022 Jaedeok Kim (https://github.com/jdeokkim)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.dennis0324.jebi.gui.controller;

import io.github.dennis0324.jebi.model.User;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 * 메인 테이블 페이지 컨트롤러를 나타내는 클래스.
 * 
 * @author dennis0324, jdeokkim
 */
public class TableController extends Controller {
	// 접속한 사용자 계정의 정보.
    private static User user;
    
    // 사용자가 선택한 메뉴의 인덱스.
    private SimpleIntegerProperty menuIndexProperty = new SimpleIntegerProperty(-1);
    
    /* ::: 메뉴 버튼... ::: */
    
    @FXML
    private MFXButton userMenuBtn;
    
    @FXML
    private MFXButton bookMenuBtn;
    
    /* ::: 좌측 하단 사용자 정보... ::: */
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Label emailLabel;
	
	/* ::: 데이터 추가 영역... ::: */
	
	@FXML
	private TextField addToTableField;
	
	@FXML
	private MFXButton addToTableBtn;
	
	/* ::: 테이블 영역... ::: */
	
	@FXML
	private StackPane tablePane;
	
	@FXML
	private Parent tableUserCompo;
	
	@FXML
	private TableUserCompoController tableUserCompoController;
	
	@FXML
	private Parent tableBookCompo;
	
	@FXML
	private TableBookCompoController tableBookCompoController;
	
	/* ::: 사용자 및 책 검색 영역... ::: */
	
	@FXML
	private StackPane searchPane;
	
	@FXML
	private Parent searchCompo;
	
	@FXML
	private SearchCompoController searchCompoController;
	
	/* ::: 사용자 추가 및 편집 영역... ::: */
	
	@FXML
	private Parent userEditAddCompo;
	
	@FXML
	private UserEditAddCompoController userEditAddCompoController;
	
    /* ::: 책 추가 및 편집 영역... ::: */
	
	@FXML
	private Parent bookEditAddCompo;
	
	@FXML
	private BookEditAddCompoController bookEditAddCompoController;
	
	/* ::: 컨트롤러 기본 메소드 정의... ::: */
	
	@Override
	public void initialize() {
		// 선택한 메뉴에 따라 보여줄 내용을 변경한다.
		menuIndexProperty.addListener(
			(observable, oldValue, newValue) -> {
				if (oldValue != newValue) {
					Platform.runLater(
						() -> {
							final int menuIndex = newValue.intValue();
							
							{		
								tableUserCompo.setManaged((menuIndex == 0));
								tableUserCompo.setVisible((menuIndex == 0));
								
								tableBookCompo.setManaged((menuIndex == 1));
								tableBookCompo.setVisible((menuIndex == 1));
								
								tableUserCompoController.clearSelection();
								tableBookCompoController.clearSelection();
							}
							
							{							
								searchCompo.setManaged(true);
								searchCompo.setVisible(true);
								
								searchCompoController.updateFilters(menuIndex);
							}
							
							{
								userEditAddCompo.setManaged(false);
								userEditAddCompo.setVisible(false);
								
								bookEditAddCompo.setManaged(false);
								bookEditAddCompo.setVisible(false);
							}
						}
					);
				}
			}
		);
		
		menuIndexProperty.set(0);
		
		// 테이블에서 선택한 사용자에 따라 보여줄 내용을 변경한다.
		tableUserCompoController.getUserProperty().addListener(
			(observable, oldValue, newValue) -> {
				searchCompo.setManaged((newValue == null));
				searchCompo.setVisible((newValue == null));
				
				userEditAddCompo.setManaged((newValue != null));
				userEditAddCompo.setVisible((newValue != null));
				
				userEditAddCompoController.updateData(newValue);
			}
		);
		
		// 테이블에서 선택한 책에 따라 보여줄 내용을 변경한다.
		tableBookCompoController.getBookProperty().addListener(
			(observable, oldValue, newValue) -> {
				searchCompo.setManaged((newValue == null));
				searchCompo.setVisible((newValue == null));
				
				bookEditAddCompo.setManaged((newValue != null));
				bookEditAddCompo.setVisible((newValue != null));
			}
		);
		
		// 사용자가 '이전' 버튼을 클릭했을 때의 동작을 지정한다.
		userEditAddCompoController.getBackProperty().addListener(
			(observable, oldValue, newValue) -> {
				searchCompo.setManaged(newValue);
				searchCompo.setVisible(newValue);
				
				userEditAddCompo.setManaged(!newValue);
				userEditAddCompo.setVisible(!newValue);
			}
		);
	}

	@Override
	public void onPageLoad() {
		user = (User) getPageLoader().getArgument();
		
		// 사용자가 관리자 권한을 가지고 있지 않다면, 
		// 사용자가 볼 수 있는 메뉴를 제한한다.
		if (!user.isAdmin()) {
			// userMenuBtn.setVisible(false);
			// bookMenuBtn.setVisible(false);
			
			/* TODO: ... */
		}
    	
    	nameLabel.setText(user.getName());
    	emailLabel.setText(user.getEmail());
	}
	
	@FXML
	public void onAddToTableBtnAction() {
		/* TODO: ... */
	}
	
	@FXML
	public void onUserMenuBtnAction() {
		menuIndexProperty.set(0);
	}
	
	@FXML
	public void onBookMenuBtnAction() {
		menuIndexProperty.set(1);
	}
}