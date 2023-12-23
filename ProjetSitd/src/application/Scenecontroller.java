package application;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import adminstrateurpage.adminpagecontroller;
import dbconnection.Connectionsql;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scenecontroller  {
	

	    @FXML
	    private Button EntrerEspaceAdministrateur;
	    
	    @FXML
	    private AnchorPane anchorPaneEtudiant;

	    @FXML
	    private AnchorPane anchorePaneAdmin;
	    
	    @FXML
	    private TextField usernameInputAdmin;

	    @FXML
	    private PasswordField passwordInputAdmin;

	    @FXML
	    private Label loginAdminEtat;

		private Stage Stage;
		private Scene scene;
		private Parent root;
	

int CONNECT_TRY=0;	 

public void switchToadminstrateurpage(ActionEvent event) throws IOException, SQLException {
	Connectionsql connection=new Connectionsql();
	    Connection con=connection.getConnection();
	    Statement stm=con.createStatement();
	    ResultSet rsadmin=stm.executeQuery("select * from admin ;");
	    rsadmin.next();
	    String adminName=usernameInputAdmin.getText();
	    String password=passwordInputAdmin.getText();
			if(rsadmin.getString("username").equals(adminName) && rsadmin.getString("password").equals(password)) {
		  System.out.println(adminName);
		  adminpagecontroller a=new adminpagecontroller();
		  a.setadmin(adminName);
		  Parent root = FXMLLoader.load(getClass().getResource("../adminstrateurpage/Adminpage.fxml"));
		  Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  Stage.setScene(scene);
		  Stage.show();
		  }
	      else if (!rsadmin.getString("username").equals(adminName) || !rsadmin.getString("password").equals(password)) {
	      loginAdminEtat.setText("Password or Username Incorrect ");
		  
		  CONNECT_TRY++;
		  if(CONNECT_TRY==3) {
			anchorPaneEtudiant.setVisible(true);
			anchorePaneAdmin.setVisible(false);
			EntrerEspaceAdministrateur.setOnAction(null);
           }
	      }
	       
		  }

//controlling visibility
public void switchToSceneadmin(ActionEvent event)  {
	anchorPaneEtudiant.setVisible(false);
	anchorePaneAdmin.setVisible(true);
		 }	 
public void switchToSceneetudiant(ActionEvent event)  {
	anchorPaneEtudiant.setVisible(true);
	anchorePaneAdmin.setVisible(false);
		 }	 
	 
}
