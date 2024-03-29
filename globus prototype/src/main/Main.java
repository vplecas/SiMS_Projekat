package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Narudzbina;
import model.RegistrovaniKupac;
import model.Uloga;

public class Main extends Application {
	//Dodajem novi komentar
	Stage window;
	Scene scene1, scene2, scene3, sceneProducts;
	BorderPane border1, border2;
	GridPane grid1, grid2, gridproducts;
	ScrollPane sp1;
	StackPane stack1;
	ScrollBar sc1, scProducts;
	HBox hbox1;
	VBox vbox1, vbox2, vbProducts;
	ArrayList<RegistrovaniKupac> users = new ArrayList<>();
	FileLoader fl = new FileLoader();
	DropShadow shadow = new DropShadow();
	ArrayList<Narudzbina> orders = new ArrayList<>();
	Table table = new Table();

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// get screensize of monitor
		Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
		window = primaryStage;
		
		
		border1 = new BorderPane();
		hbox1 = addHBox();
		border1.setTop(hbox1);
		gridproducts = addGridPaneProducts();
		border1.setCenter(gridproducts);
		
		
		grid1 = new GridPane();
		grid1.setAlignment(Pos.CENTER);
		vbox1 = addVBoxLogIn();
		grid1.add(vbox1, 0, 0);
		grid1.setStyle("-fx-background-color: #A9A9A9;");
		
		grid2 = new GridPane();
		grid2.setAlignment(Pos.CENTER);
		vbox2 = addVBoxSignIn();
		grid2.add(vbox2, 0, 0);
		grid2.setStyle("-fx-background-color: #ADFF2F;");
		
		scene1 = new Scene(border1, screenSize.getWidth(), screenSize.getHeight());
		scene2 = new Scene(grid1, screenSize.getWidth(), screenSize.getHeight());
		scene3 = new Scene(grid2, screenSize.getWidth(), screenSize.getHeight());
		//sceneProducts = new Scene(gridproducts, screenSize.getWidth(), screenSize.getHeight());
		
		window.setMaximized(true);
		window.setScene(scene1);
		window.show();
	}

	private GridPane addGridPaneProducts() throws FileNotFoundException {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(10);
		grid.setVgap(10);
		
		FileInputStream input = new FileInputStream("protein.jpg");
        Image image = new Image(input);
        int s = 300;
        ImageView iv1 = new ImageView(image);
        iv1.setFitHeight(s); iv1.setFitWidth(s);
        ImageView iv2 = new ImageView(image);
        iv2.setFitHeight(s); iv2.setFitWidth(s);
        ImageView iv3 = new ImageView(image);
        iv3.setFitHeight(s); iv3.setFitWidth(s);
        ImageView iv4 = new ImageView(image);
        iv4.setFitHeight(s); iv4.setFitWidth(s);
        
        Button kupi1 = new Button("Kupi");
        Button kupi2 = new Button("Kupi");
        Button kupi3 = new Button("Kupi");
        Button kupi4 = new Button("Kupi");
		
        grid.add(iv1, 0, 0);
        grid.add(iv2, 1, 0);
        grid.add(kupi1, 0, 1);
        grid.add(kupi2, 1, 1);
        grid.add(iv3, 0, 2);
        grid.add(iv4, 1, 2);
        grid.add(kupi3, 0, 3);
        grid.add(kupi4, 1, 3);
        
        kupi1.setOnAction(e -> {
			try {
				Order.display("Order", "Nista", orders);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		});
        kupi2.setOnAction(e -> {
			try {
				Order.display("Order", "Nista", orders);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        kupi3.setOnAction(e -> {
			try {
				Order.display("Order", "Nista", orders);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        kupi4.setOnAction(e -> {
			try {
				Order.display("Order", "Nista", orders);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        
		return grid;
	}

	private VBox addVBoxLogIn() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(15, 12, 15, 12));
		vbox.setSpacing(10);
		vbox.setStyle("-fx-background-color: #336699;");
		vbox.setAlignment(Pos.CENTER);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(10);
		grid.setVgap(8);
		
		Label usernameLabel = new Label("Username: ");
		
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("username");
		
		Label passwordLabel = new Label("Password: ");
		
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("password");
		
		HBox hbButtons = new HBox();
	    hbButtons.setSpacing(10.0);
	    
	    Button btnSubmit = new Button("Submit"); // Sign in button
	    Button btnClear = new Button("Clear");
	    Button btnExit = new Button("Exit");
	    btnSubmit.setStyle("-fx-font-size: 12pt;");
	    btnClear.setStyle("-fx-font-size: 10pt;");
		
	    hbButtons.getChildren().addAll(btnSubmit, btnClear, btnExit);
	    
	    grid.add(usernameLabel, 0, 0);
	    grid.add(usernameInput, 1, 0);
	    grid.add(passwordLabel, 0, 1);
	    grid.add(passwordInput, 1, 1);
	    grid.add(hbButtons, 0, 2, 2, 1);
	    
	    vbox.getChildren().addAll(grid);
	    
	    btnSubmit.setOnAction(e -> {
	    	window.setScene(scene1);
	    });
	    
	    btnExit.setOnAction(e -> {
	    	window.setScene(scene1);
	    });
	    
		return vbox;
	}

	private VBox addVBoxSignIn() throws IOException {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(15, 12, 15, 12));
		vbox.setSpacing(10);
		vbox.setStyle("-fx-background-color: #336699;");
		vbox.setAlignment(Pos.CENTER);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(10);
		grid.setVgap(8);
		
		//Name label
		Label nameLabel = new Label("Name: ");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		//Name input
		TextField nameInput = new TextField();
		nameInput.setPromptText("name");
		GridPane.setConstraints(nameInput, 1, 0);
		
		//Surname label
		Label surnameLabel = new Label("Surname: ");
		GridPane.setConstraints(surnameLabel, 0, 1);
		
		//Surname input
		TextField surnameInput = new TextField();
		surnameInput.setPromptText("surname");
		GridPane.setConstraints(surnameInput, 1, 1);
		
		//Birthday label
		Label bDayLabel = new Label("Birthday: ");
		GridPane.setConstraints(bDayLabel, 0, 2);
		
		//Birthday input
		TextField bDayInput = new TextField();
		bDayInput.setPromptText("dd.mm.yyyy.");
		GridPane.setConstraints(bDayInput, 1, 2);
		
		//Username label
		Label usernameLabel = new Label("Username: ");
		GridPane.setConstraints(usernameLabel, 0, 3); //top left of the grid
		
		//Username input
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("username");
		GridPane.setConstraints(usernameInput, 1, 3);
		
		//Password label
		Label passwordLabel = new Label("Password: ");
		GridPane.setConstraints(passwordLabel, 0,4);
		
		//Password input
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("password");
		GridPane.setConstraints(passwordInput, 1, 4);
		
		//Mail label
		Label mailLabel = new Label("Email address: ");
		GridPane.setConstraints(mailLabel, 0, 5);
		
		//Mail input
		TextField mailInput = new TextField();
		mailInput.setPromptText("email");
		GridPane.setConstraints(mailInput, 1, 5);
		
		Button signInButton = new Button("Sign in");
		GridPane.setConstraints(signInButton, 1, 6);
		
		Button quitButton = new Button("Quit");
		GridPane.setConstraints(quitButton, 2, 6);
		
		grid.getChildren().addAll(nameLabel, nameInput, surnameLabel, surnameInput, bDayLabel, bDayInput,
				usernameLabel, usernameInput, passwordLabel, passwordInput, mailLabel, mailInput, signInButton, quitButton);
	    
		quitButton.setOnAction(e -> window.setScene(scene1));
		
		signInButton.setOnAction(e -> {
			boolean correct = checkUserInputs(nameInput.getText(), surnameInput.getText(), bDayInput.getText(),
					usernameInput.getText());
			if (correct) {
				try { fl.loadRegUsers(users);} catch (IOException e1) {e1.printStackTrace();}
				RegistrovaniKupac rk;
				try {
					rk = createRegisteredUser(nameInput.getText(), surnameInput.getText(), bDayInput.getText(),
							usernameInput.getText(), passwordInput.getText(), mailInput.getText());
					users.add(rk);
					try {fl.writeUsers(users);} catch (IOException e1) {e1.printStackTrace();}
					nameInput.clear(); surnameInput.clear(); bDayInput.clear();
					usernameInput.clear(); passwordInput.clear(); mailInput.clear();
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
				
				//window.setScene(scene1);//Pri zavrsetku ide na scenu 1, ali ce naknadno ici na svoju scenu.
			}else {
				nameInput.clear(); surnameInput.clear(); bDayInput.clear();
				usernameInput.clear(); passwordInput.clear(); mailInput.clear();
			}
		});
		
	    vbox.getChildren().addAll(grid);
	    
		return vbox;
	}

	private RegistrovaniKupac createRegisteredUser(String name, String surname, String bday, String username, String password, String mail) throws ParseException {
		Date regday = new Date(); // Current day
		Date bdaydate = new SimpleDateFormat("dd.MM.yyyy.").parse(bday);
		RegistrovaniKupac rk = new RegistrovaniKupac(name, surname, bdaydate, regday, Uloga.REGKUPAC, username, password, mail);
		
		return rk;
	}

	private Boolean checkUserInputs(String name, String surname, String bDay, String username) { 
		//Returns true if all methods in if statement are true.
		if (checkName(name) && checkName(surname) && checkBDay(bDay) && checkUsername(username)) {
			System.out.println("Prosla provera za unos.");
			return true;
		}
		return false;
	}
	
	boolean checkName(String name) {
		if (name.equals(null) || name.equals("")) {
			System.out.println("Nista nismo uneli");
			return false;
		}
		
		for (int i = 0; i < name.length(); i++) {
			try {
				Integer.parseInt(String.valueOf(name.charAt(i)));
				System.out.println("Broj");
				return false;
			} catch (Exception e) {
				continue;
			}
		}
		System.out.println("Prsla provera za ime i/ili prezime");
		return true;
	}
	
	boolean checkBDay(String bday) {
		try {
			Date dateOfBirth = new SimpleDateFormat("dd.MM.yyyy.").parse(bday);
		} catch (DateTimeParseException e) {
			return false;
		} catch (ParseException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		System.out.println("Prosla provera za datum.");
		return true;
	}
	
	boolean checkUsername(String username) {
		for (RegistrovaniKupac rk : users) {
			if (rk.getKorisnickoIme().equals(username)) {
				return false;
			}
		}
		System.out.println("Prosla provera za username.");
		return true;
	}

	public HBox addHBox() {
		final Pane leftSpacer = new Pane();
	    HBox.setHgrow(leftSpacer, Priority.SOMETIMES);
	
	    final Pane rightSpacer = new Pane();
	    HBox.setHgrow(rightSpacer, Priority.SOMETIMES);
		
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    Button productsButton = new Button("Products");
	    productsButton.setPrefSize(100, 20);

	    Button button2 = new Button("My orders");
	    button2.setPrefSize(100, 20);
	    
	    Button button3 = new Button("Button3");
	    button3.setPrefSize(100, 20);
	    
	    Button button4 = new Button("Button4");
	    button4.setPrefSize(100, 20);
	    
	    Button button5 = new Button("Button5");
	    button5.setPrefSize(100, 20);
	    
	    Button button6 = new Button("Contact us");
	    button6.setPrefSize(100, 20);
	    
	    Button buttonLogIn = new Button("Log in");
	    buttonLogIn.setPrefSize(100, 20);
	    
	    buttonLogIn.setOnAction(e -> {
	    	window.setScene(scene2);
	    });
	    
	    Button buttonSignIn = new Button("Sign in");
	    buttonSignIn.setPrefSize(100, 20);
	    
	    buttonSignIn.setOnAction(e -> {
	    	window.setScene(scene3);
	    });
	    
	    button2.setOnAction(e -> {
	    	Table.display(orders);
	    });
	    
//	    productsButton.setOnAction(e -> {
//	    	window.setScene(sceneProducts);
//	    });
	    
	    hbox.getChildren().addAll(leftSpacer, productsButton, button2, button3, button4, button5, button6,  rightSpacer, buttonLogIn, buttonSignIn);

	    return hbox;
	}
	
	

}