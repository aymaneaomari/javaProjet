package adminstrateurpage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import dbconnection.Connectionsql;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modele.*;

public class adminpagecontroller implements Initializable {

	static String admin;
	
	 public void setadmin(String admin) {
		this.admin=admin;
	}
	private Stage Stage;
	private Scene scene;
	private Parent root;
    
	@FXML
    private Label adminName; 
	
    @FXML
    private AnchorPane asideAnchorPane;
    

    @FXML
    private TabPane parentTabPan;
    
    @FXML
    private Tab departementTab;
    
    @FXML
    private ToggleButton departementButton;

    @FXML
    private ToggleButton ensaignantButton;

    @FXML
    private ToggleButton etudiantButton;

    @FXML
    private ToggleButton filiereButton;
    
    @FXML
    private ToggleButton moduleButton;
    
    @FXML
    private AnchorPane anchorPaneFiliere;

    @FXML
    private AnchorPane anchorePaneDepartement;

    @FXML
    private AnchorPane anchorePaneEnsaignant;

    @FXML
    private AnchorPane anchorePaneEtudiant;

    @FXML
    private AnchorPane anchorePaneModule;

 /*pour la partie departement*/   
    @FXML
    private TableColumn<departement, String> depColumnCd;

    @FXML
    private TableColumn<departement, Integer> depColumnId;

    @FXML
    private TableColumn<departement, String> depColumnNom;

    @FXML
    private TableView<departement> departementTableview;
    
    @FXML
    private Button searchButton;
    @FXML
    private TextField searchTextField; 
    
    ObservableList<departement> listdepartement=FXCollections.observableArrayList();
    
    
    @FXML
    private TableView<filiere> DepFiliereTableView;

    @FXML
    private TableColumn<filiere, Integer> depFiliereIDcolumn;

    @FXML
    private TableColumn<filiere, String> depFiliereNomcolumn;
     
    @FXML
    private TextField searchFiliereByDepartement;
    
    
/*pour la partie ensaignant*/  
    //affichage
    @FXML
    private TableView<Ensaignant> EnsaignantTableview;
    @FXML
    private TableColumn<Ensaignant,Integer > ensaiColumnGrade;

    @FXML
    private TableColumn<Ensaignant,String> ensaiColumnEmail;

    @FXML
    private TableColumn<Ensaignant,Integer> ensaiColumnId;

    @FXML
    private TableColumn<Ensaignant,String> ensaiColumnNom;

    @FXML
    private TableColumn<Ensaignant,String> ensaiColumnPrenom;
    
    @FXML
    private TextField SearchTextfieldAllEnsaignant;	
    
    //insertion
    
    @FXML
    private Spinner<Integer> spinnerensai;
    
    @FXML
    private TextField ensaiEmailTextfield;

    @FXML
    private TextField ensaiNomTextfield;

    @FXML
    private TextField ensaiPrenomTextfield;
    
    @FXML
    private Label emailcheckensai;
    
    @FXML
    private Button ajouterbutton;
    //update part
    @FXML
    private TextField searchTextFieldUpdateEnsaignant;

    @FXML
    private TextField ensaiNomTextfieldUpdate;
    
    @FXML
    private TextField ensaiPrenomTextfieldUpdate;
    
    @FXML
    private Spinner<Integer> spinnerensaiUpdate;

    @FXML
    private TextField ensaiEmailTextfieldUpdate;
    
    @FXML
    private Label updateEtatEnsaignant;
    

    
ObservableList<Ensaignant> listEnsaignant=FXCollections.observableArrayList();

/*pour la partie filiere*/
    @FXML
    private TableView<filiere> filiereTableview;
    
    @FXML
    private TableColumn<filiere, Integer> filiereColumnID;

    @FXML
    private TableColumn<filiere,String> filiereColumnNom;

    @FXML
    private TableColumn<filiere,String> filiereColumnResponsable;
    
    @FXML
    private TableColumn<filiere,String> filiereColumnDepartement;
    
   

    //isnertion part
     

    @FXML
    private TextField searchTextFieldFiliere;
    
    
    @FXML
    private ChoiceBox<String> choiceboxDepartement;
    
	@FXML
    private ChoiceBox<String> choiceboxResponsable;

    @FXML
    private TextField nomFiliereInputTextField;
    
    @FXML
    private Label filiereInsertEtat;

	
    //declaring the list of filiere
	ObservableList<filiere> listFiliere=FXCollections.observableArrayList();
	
	ObservableList<String> ensaignant=FXCollections.observableArrayList();

	ObservableList<String> departement = FXCollections.observableArrayList();
	
// part for modules
	
    @FXML
    private TableView<module> modulesTableView;
	
    @FXML
    private TableColumn<module, String> modulesColumnEnsai;

    @FXML
    private TableColumn<module, String> modulesColumnFiliere;

    @FXML
    private TableColumn<module, Integer> modulesColumnID;

    @FXML
    private TableColumn<module, String> modulesColumnNom;
    
    @FXML
    private TextField textFieldModule;
    
    //insertion

	    @FXML
	    private TextField insertionModuleNom;
	    
	    @FXML
	    private ChoiceBox<String> modulesDepartementChoixBox;

	    @FXML
	    private ChoiceBox<String> modulesEnsaignantChoixBox;
    
    
    ObservableList<module> listModules=FXCollections.observableArrayList();
    
    //part for Etudiant
	@FXML
    private TableView<Etudiant> etudiantTableView;
	
    @FXML
    private TableColumn<Etudiant,Integer> etudiantColumnCodeApoge;

    @FXML
    private TableColumn<Etudiant,String> etudiantColumnEmail;

    @FXML
    private TableColumn<Etudiant,String> etudiantColumnFiliere;

    @FXML
    private TableColumn<Etudiant,String> etudiantColumnNom;

    @FXML
    private TableColumn<Etudiant, String> etudiantColumnPrenom;
    //insertion 
	    @FXML
	    private TextField etudiantSearchInputField;
	    
	    @FXML
	    private TextField etudiantEmailInput;

	    @FXML
	    private TextField etudiantNomInput;

	    @FXML
	    private TextField etudiantPrénomInput;

		@FXML
		private ChoiceBox<String> FilérechoiceBoxInput;
		
		@FXML
		private Label InsertionEtatEtudiant;

    //update info 
    @FXML
    private TextField etudiantUpdateEmail;

    @FXML
    private ChoiceBox<String> etudiantUpdateFiliére;

    @FXML
    private TextField etudiantUpdateNom;

	@FXML
	private TextField etudiantUpdatePrenom;
    
	@FXML
	private TextField SearchInputUpdateEtudiant;
		    
	@FXML
	private Label etudiantCodeApogéLabel;
		    
    ObservableList<Etudiant> listEtudiant=FXCollections.observableArrayList();
    
    ObservableList<String> Filiere=FXCollections.observableArrayList();
    
    public void initialize(URL arg0, ResourceBundle arg1) {
	/*	ImageView depicone=new ImageView("./images/department.png");
		depicone.setFitHeight(30);
		depicone.setFitWidth(30);
		departementTab.setStyle("-fx-min-heignt:60;");
		departementTab.setGraphic(depicone);*/
		
		adminName.setText(admin);
		
		//initialize the departement Table view
		depColumnId.setCellValueFactory(new PropertyValueFactory<departement,Integer>("id"));
		depColumnCd.setCellValueFactory(new PropertyValueFactory<departement,String>("chefDepartement"));
		depColumnNom.setCellValueFactory(new PropertyValueFactory<departement,String>("nom"));
		
		depFiliereIDcolumn.setCellValueFactory(new PropertyValueFactory<filiere,Integer>("id"));
		depFiliereNomcolumn.setCellValueFactory(new PropertyValueFactory<filiere,String>("nom"));

		//initialize the Ensaignant table view
		ensaiColumnId.setCellValueFactory(new PropertyValueFactory<Ensaignant,Integer>("id"));
		ensaiColumnNom.setCellValueFactory(new PropertyValueFactory<Ensaignant,String>("nom"));
		ensaiColumnPrenom.setCellValueFactory(new PropertyValueFactory<Ensaignant,String>("prenom"));
		ensaiColumnEmail.setCellValueFactory(new PropertyValueFactory<Ensaignant,String>("email"));
		ensaiColumnGrade.setCellValueFactory(new PropertyValueFactory<Ensaignant,Integer>("grade"));

		SpinnerValueFactory<Integer> spinnervf=
										new  SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
		spinnervf.setValue(1);
		
		spinnerensai.setValueFactory(spinnervf);
		 //intilializ filiere part 
		
		filiereColumnID.setCellValueFactory(new PropertyValueFactory<filiere,Integer>("id"));
		filiereColumnNom.setCellValueFactory(new PropertyValueFactory<filiere,String>("nom"));
		filiereColumnResponsable.setCellValueFactory(new PropertyValueFactory<filiere,String>("responsable"));
		filiereColumnDepartement.setCellValueFactory(new PropertyValueFactory<filiere,String>("departement"));
		
		
		
		//initialzi modules part
		modulesColumnID.setCellValueFactory(new PropertyValueFactory<module,Integer>("id"));
		modulesColumnNom.setCellValueFactory(new PropertyValueFactory<module,String>("nom"));
		modulesColumnEnsai.setCellValueFactory(new PropertyValueFactory<module,String>("ensaignant"));
		modulesColumnFiliere.setCellValueFactory(new PropertyValueFactory<module,String>("filiere"));
		
		//initialzi etudiant part
		etudiantColumnCodeApoge.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("codeApogé"));
		etudiantColumnNom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
		etudiantColumnPrenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prénom"));
		etudiantColumnEmail.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("email"));
		etudiantColumnFiliere.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("filiere"));
			//for insertion etudiant
		
		
		
		
		try {
			Connectionsql connection=new Connectionsql();
			Connection con=connection.getConnection();
			Statement stm=con.createStatement();
			ResultSet rsdep=stm.executeQuery("select d.id,d.nom,concat(e.nom,\" \",e.prenom) as 'nom complet'from departement as d inner join ensaignant as e On d.chefdep=e.id;");
			while(rsdep.next()) {
				listdepartement.add(new departement(rsdep.getInt("id"),rsdep.getString("nom"),rsdep.getString("nom complet"))) ;
			}
			
			Statement stm2=con.createStatement();
			ResultSet rsensai=stm2.executeQuery("select * from ensaignant;");
			while(rsensai.next()) {
				listEnsaignant.add(new Ensaignant(rsensai.getInt("id"),rsensai.getString("Prenom"),
						  rsensai.getString("Nom"),rsensai.getString("email"),rsensai.getInt("grade"))) ;
			}
			
			
			Statement stm3=con.createStatement();
			ResultSet rsfiliere=stm3.executeQuery("select f.id,f.nom,concat(e.nom,' ',e.prenom) as responsable,d.nom as departement\r\n"
					+ "from filiere f inner join departement d on f.departement=d.id\r\n"
					+ "inner join ensaignant e on f.responsable=e.id;");
			while(rsfiliere.next()) {
				listFiliere.add(new filiere(rsfiliere.getInt("id"),rsfiliere.getString("nom"),rsfiliere.getString("responsable"),rsfiliere.getString("departement"))) ;
			}
			
			
		   Statement stm4=con.createStatement();
		   ResultSet rsmodules=stm4.executeQuery("Select m.id,m.nom,concat(e.prenom,' ',e.nom) as ensaignant,f.nom as filiere\r\n"
		   		+ "from modules m inner join ensaignant e on m.Ensaignant=e.id\r\n"
		   		+ "inner join filiere f on m.filiere=f.id;");
		   while(rsmodules.next()) {
			   listModules.add(new module(rsmodules.getInt("id"),rsmodules.getString("nom"),rsmodules.getString("ensaignant"),rsmodules.getString("filiere")));
			}
		   
		   
		   Statement stm5=con.createStatement();
		   ResultSet rsEtudiant=stm.executeQuery("SELECT e.apoge , e.nom , e.prenom ,e.email,f.nom as filiere\r\n"
		   		+ "from etudiant e inner join filiere f \r\n"
		   		+ "on e.filiere=f.id;");
		   while(rsEtudiant.next()) {
			   listEtudiant.add(new Etudiant(rsEtudiant.getInt("apoge"),rsEtudiant.getString("nom"),rsEtudiant.getString("prenom"),rsEtudiant.getString("email"),rsEtudiant.getString("filiere")));
			}
		   
		   

//initializing table views of all entites
			
			EnsaignantTableview.setItems(listEnsaignant);
			departementTableview.setItems(listdepartement);
			filiereTableview.setItems(listFiliere);
			modulesTableView.setItems(listModules);
			etudiantTableView.setItems(listEtudiant);
//initializing the departement spinner after adding alist of departement	
			
			for(departement i:listdepartement)
				departement.add(i.getNom()); 
			choiceboxDepartement.setItems(departement);
			modulesDepartementChoixBox.setItems(departement);
			
			for(Ensaignant i:listEnsaignant) 
				ensaignant.add(i.getNom()+" "+i.getPrenom());
			choiceboxResponsable.setItems(ensaignant);
			modulesEnsaignantChoixBox.setItems(ensaignant);
			
			for(filiere f:listFiliere)
				Filiere.add(f.getNom());
			FilérechoiceBoxInput.setItems(Filiere);
			
			etudiantUpdateFiliére.setItems(Filiere);
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//this part is for making the the logout from the adminpage
	public void switchmainpage(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("../application/main.fxml"));
		  Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  Stage.setScene(scene);
		  Stage.show();
		 }	
	public void SwitchEntiteAnchorPane(ActionEvent e ) {
	  if(e.getSource().equals(departementButton)) {
		  anchorePaneDepartement.setVisible(true);
		  anchorPaneFiliere.setVisible(false);
		  anchorePaneEnsaignant.setVisible(false);
		  anchorePaneEtudiant.setVisible(false);
		  anchorePaneModule.setVisible(false);
	  }
	  else if (e.getSource().equals(filiereButton)){
		  anchorePaneDepartement.setVisible(false);
		  anchorPaneFiliere.setVisible(true);
		  anchorePaneEnsaignant.setVisible(false);
		  anchorePaneEtudiant.setVisible(false);
		  anchorePaneModule.setVisible(false);
	  }
	  else if (e.getSource().equals(moduleButton)){
		  anchorePaneDepartement.setVisible(false);
		  anchorPaneFiliere.setVisible(false);
		  anchorePaneEnsaignant.setVisible(false);
		  anchorePaneEtudiant.setVisible(false);
		  anchorePaneModule.setVisible(true);
	  }
	  else if (e.getSource().equals(ensaignantButton)){
		  anchorePaneDepartement.setVisible(false);
		  anchorPaneFiliere.setVisible(false);
		  anchorePaneEnsaignant.setVisible(true);
		  anchorePaneEtudiant.setVisible(false);
		  anchorePaneModule.setVisible(false);
	  }
	  else if (e.getSource().equals(etudiantButton)){
		  anchorePaneDepartement.setVisible(false);
		  anchorPaneFiliere.setVisible(false);
		  anchorePaneEnsaignant.setVisible(false);
		  anchorePaneEtudiant.setVisible(true);
		  anchorePaneModule.setVisible(false);
	  }

		  
	}
	
	
	
	
//this part is for controlling the departement part
public void search(ActionEvent e) throws SQLException {
		String s=searchTextField.getText();
		ObservableList<departement> listdep=FXCollections.observableArrayList();		
		for(departement d:listdepartement)
			if (d.getNom().contains(s))
			listdep.add(d);
		
		departementTableview.setItems(listdep);
		
		}
public void searchDynamique(KeyEvent e) throws SQLException {
	String s=searchTextField.getText();
	ObservableList<departement> listdep=FXCollections.observableArrayList();		
	if(s!="") {for(departement d:listdepartement)
		if (d.getNom().contains(s))
		listdep.add(d);
	
	 departementTableview.setItems(listdep);}
	else if(s=="") departementTableview.setItems(listdepartement);
	}


public void searchFiliereOfdep(ActionEvent e) {
String  departement= searchFiliereByDepartement.getText(); 
ObservableList<filiere> listDepartementFiliere=FXCollections.observableArrayList();    
	for(filiere f:listFiliere)
		if(f.getDepartement().equals(departement))
			listDepartementFiliere.add(f);
		
	
DepFiliereTableView.setItems(listDepartementFiliere);
}
// this part is for controlling ensaignant part


public void ajoutEnsaignant(ActionEvent e) throws SQLException{
	String email=ensaiEmailTextfield.getText();
	String nom=ensaiNomTextfield.getText();
	String prenom=ensaiPrenomTextfield.getText();
	Integer grade=spinnerensai.getValue();

	Connectionsql connection=new Connectionsql();
	Connection con=connection.getConnection();
	PreparedStatement stm;
	if(email.matches("^(.+)@(.+)$")&&nom!=null&&prenom!=null) {
	try {
		stm = con.prepareStatement("insert into ensaignant(Prenom,Nom,email,grade) values(?,?,?,?);");	
		stm.setString(1,prenom);
		stm.setString(2,nom);
		stm.setString(3,email);
		stm.setInt(4, grade);
		stm.execute();
		emailcheckensai.setVisible(true);
		emailcheckensai.setText("information enregistre");
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
	else {
		emailcheckensai.setVisible(true);
		emailcheckensai.setText("les information incorrect ou incomplet");

	}
}

public void updateEnsaignantInfosSearch(ActionEvent e) {
	Integer id=Integer.parseInt(searchTextFieldUpdateEnsaignant.getText());

	for(Ensaignant ensai:listEnsaignant)
		if(ensai.getId().equals(id)) {
		ensaiNomTextfieldUpdate.setText(ensai.getNom());
		ensaiPrenomTextfieldUpdate.setText(ensai.getPrenom());
		ensaiEmailTextfieldUpdate.setText(ensai.getEmail());
		SpinnerValueFactory<Integer> spinnervf=
				new  SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
		spinnervf.setValue(ensai.getGrade());
		spinnerensaiUpdate.setValueFactory(spinnervf);}

	
}

public void updateEnsaignantInfos(ActionEvent e) {
	Integer id=Integer.parseInt(searchTextFieldUpdateEnsaignant.getText());
	String email=ensaiEmailTextfieldUpdate.getText();
	String nom=ensaiNomTextfieldUpdate.getText();
	String prenom=ensaiPrenomTextfieldUpdate.getText();
	Integer grade=spinnerensaiUpdate.getValue();

	Connectionsql connection=new Connectionsql();
	Connection con=connection.getConnection();
	PreparedStatement stm;
	if(email.matches("^(.+)@(.+)$")&&nom!=null&&prenom!=null) {
	try {
		stm = con.prepareStatement("UPDATE ensaignant SET prenom=?,nom=?,email=?,grade=? where id=?;");
		stm.setString(1,prenom);
		stm.setString(2,nom);
		stm.setString(3,email);
		stm.setInt(4,grade);
		stm.setInt(5, id);
		stm.execute();
		updateEtatEnsaignant.setText("updated");
	} catch (SQLException e1) {

		e1.printStackTrace();
	}	}
	else {
		updateEtatEnsaignant.setText("information incorrect");
	}

}
public void supprimerEnsaignantInfos(ActionEvent e) {
	Integer id=Integer.parseInt(searchTextFieldUpdateEnsaignant.getText());
	Connectionsql connection=new Connectionsql();
	Connection con=connection.getConnection();
	PreparedStatement stm;

	try {
		stm = con.prepareStatement("delete FROM ensaignant where id=?;");
		stm.setInt(1, id);
		
		if(stm.execute()) {
			updateEtatEnsaignant.setText("l'ensaignant a été supprimer");
			
		}
		else {
			updateEtatEnsaignant.setText("l'ensaignant n'a pas été supprimer");
		}

	} catch (SQLException e1) {

		e1.printStackTrace();
	}	}



public void searchAllEnsaignant(ActionEvent e ) throws SQLException {
	
String nomcomplet=	SearchTextfieldAllEnsaignant.getText();
nomcomplet=nomcomplet.toLowerCase().trim();
ObservableList<Ensaignant> list=FXCollections.observableArrayList();
for(Ensaignant e1:listEnsaignant)
	if(e1.getNomComplet().contains(nomcomplet)) 
		list.add(e1);

EnsaignantTableview.setItems(list);	
}
public void searchAllEnsaignantDynamique(KeyEvent e ) throws SQLException {
	
String nomcomplet=	SearchTextfieldAllEnsaignant.getText();
nomcomplet=nomcomplet.toLowerCase().trim();
ObservableList<Ensaignant> list=FXCollections.observableArrayList();
if(nomcomplet!="") {
for(Ensaignant e1:listEnsaignant)
	if(e1.getNomComplet().contains(nomcomplet)) 
		list.add(e1);

EnsaignantTableview.setItems(list);	}
else if(nomcomplet=="null")
	EnsaignantTableview.setItems(listEnsaignant);
}


//this part is for controlling filiere
public void searchfiliere(ActionEvent e ) throws SQLException {
 String searchInput= searchTextFieldFiliere.getText();
 searchInput=searchInput.trim();
 
	if(searchInput!=null) {
		Connectionsql connection=new Connectionsql();
		Connection con=connection.getConnection();
		PreparedStatement stm;
		stm=con.prepareStatement("select f.id,f.nom,concat(e.nom,' ',e.prenom) as responsable,d.nom as departement\r\n"
				+ "				from filiere f inner join departement d on f.departement=d.id\r\n"
				+ "				inner join ensaignant e on f.responsable=e.id  where f.nom=?");
		stm.setString(1, searchInput);
		ResultSet rs=stm.executeQuery();
		
		ObservableList<filiere> list=FXCollections.observableArrayList();
		
		while(rs.next())
			list.add(new filiere(rs.getInt("id"),rs.getString("nom"),rs.getString("responsable"),rs.getString("departement")));

		filiereTableview.setItems(list);
			
	}
	else
		filiereTableview.setItems(listFiliere);
	
}
public void ajouterfiliere(ActionEvent e) throws SQLException {
	String Nom=nomFiliereInputTextField.getText();
	Nom=Nom.trim();
	String Departement=choiceboxDepartement.getValue();
	Departement=Departement.trim();
	String Responsable=choiceboxResponsable.getValue();
	Responsable=Responsable.trim();
	
	if(Nom!=null&&Departement!=null&&Responsable!=null) {
		Connectionsql connection=new Connectionsql();
		Connection con=connection.getConnection();
		PreparedStatement stm;
		stm=con.prepareStatement("insert into filiere(nom,responsable,departement) values(?,?,?);");
		
		stm.setString(1,Nom);
		
		PreparedStatement stm1;
		stm1=con.prepareStatement("select id fro"
				+ "m ensaignant e where concat(e.nom,' ',e.prenom)=?;");
		stm1.setString(1, Responsable);		
		ResultSet resposableid=stm1.executeQuery();
		resposableid.next();
		System.out.println(resposableid.getInt("id"));
		stm.setInt(2,resposableid.getInt("id") );
		
		
		PreparedStatement stm2;
		stm2=con.prepareStatement("select id from departement  where nom=?;");
		stm2.setString(1,Departement);
		ResultSet departementid=stm2.executeQuery();
		departementid.next();
		System.out.println(departementid.getInt("id"));
		stm.setInt(3, departementid.getInt("id"));
		stm.execute();
		filiereInsertEtat.setText("information sont ajouter");
		
	}
	else
		filiereInsertEtat.setText("One of the filied is empty");
}

//this part is for controlling modules

public void searchModules(ActionEvent e) {
	
	String module=textFieldModule.getText();
	System.out.println(module);
	ObservableList<module> listmodulesSearched=FXCollections.observableArrayList();
	for (module m:listModules) {
	 if(m.getNom().equals(module))
		 listmodulesSearched.add(m);
			}
	
	modulesTableView.setItems(listmodulesSearched);
	
}

public void insertionModules(ActionEvent e ) {
String moduleNom=insertionModuleNom.getText();
String Departement=modulesDepartementChoixBox.getValue();
String ensaignant=modulesEnsaignantChoixBox.getValue();


	
}

//this part is for controlling etudiant
 public void searchEtudiant(ActionEvent e) {
	
	String etudiant=etudiantSearchInputField.getText();
	System.out.println(etudiant);
	ObservableList<Etudiant> listetudiantSearched=FXCollections.observableArrayList();
	for (Etudiant e1:listEtudiant) {
	 if(e1.getNom().equals(etudiant))
		 listetudiantSearched.add(e1);
			}
	
	etudiantTableView.setItems(listetudiantSearched);
	
}
public void inserezEtudiant(ActionEvent e) throws SQLException {
	String Nom=etudiantNomInput.getText();
	String Prenom=etudiantPrénomInput.getText();
	String Email=etudiantEmailInput.getText();
	String Filiére=FilérechoiceBoxInput.getValue();
	Integer filiereId=0;
	for(filiere f:listFiliere)
		if(f.getNom().equals(Filiére))
			filiereId=f.getId();
	
	 if(Nom!=null && Prenom!=null && Email.matches("^(.+)@(.+)$")) {
		Connectionsql connection=new Connectionsql();
		Connection con=connection.getConnection();
		PreparedStatement ptm=con.prepareStatement("insert into etudiant(nom,prenom,email,filiere) values (?,?,?,?);");
		ptm.setString(1, Nom);
		ptm.setString(2, Prenom);
		ptm.setString(3,Email);
		ptm.setInt(4, filiereId); 
		ptm.execute();
		InsertionEtatEtudiant.setText("Donnée ajouté");
	}
	 else
		InsertionEtatEtudiant.setText("Donnée non ajouté verifié les informations");

}


public void searchForUpdateEtudiant(ActionEvent e) {
Integer codeApoge=Integer.parseInt(SearchInputUpdateEtudiant.getText())	;
for(Etudiant etudiant:listEtudiant)
	if(etudiant.getCodeApogé()==codeApoge) {
		etudiantUpdateNom.setText(etudiant.getNom());
		etudiantUpdatePrenom.setText(etudiant.getPrénom());
		etudiantUpdateEmail.setText(etudiant.getEmail());
		etudiantUpdateFiliére.setValue(etudiant.getFiliere());
		etudiantCodeApogéLabel.setText(SearchInputUpdateEtudiant.getText());
	}

}


public void modifierInformationEtudiant(ActionEvent e) {
	String Nom=etudiantUpdateNom.getText();
	String Prenom=etudiantUpdatePrenom.getText();
	String Email=etudiantUpdateEmail.getText();
	String Filiére=etudiantUpdateFiliére.getValue();
	Integer codeApoge=Integer.parseInt(SearchInputUpdateEtudiant.getText());
	Integer filiéreId=0;
/*for(filiere f:listFiliere)
		if(f.getNom().equals(Filiére))
			filiéreId=f.getId();
	if(Nom!=null && Prenom!=null && Email.matches("^(.+)@(.+)$")) {
		Connectionsql connection=new Connectionsql();
		Connection con=connection.getConnection();
		PreparedStatement ptm=con.prepareStatement("UPDATE etudiant SET nom=? AND ")
	}*/
	
}
	
}

