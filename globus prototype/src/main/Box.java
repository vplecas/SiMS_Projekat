package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Box {
	private Stage window;

	public Box(Stage window) {
		super();
		this.window = window;
	}

	public VBox addVBoxLogIn(Scene scene1) {
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

	public VBox addVBoxSignIn(Scene scene1) {
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
		
		Button loginButton = new Button("Log in");
		GridPane.setConstraints(loginButton, 1, 6);
		
		grid.getChildren().addAll(nameLabel, nameInput, surnameLabel, surnameInput, bDayLabel, bDayInput,
				usernameLabel, usernameInput, passwordLabel, passwordInput, mailLabel, mailInput, loginButton);
	    
	    loginButton.setOnAction(e -> {
	    	window.setScene(scene1);
	    });
		
	    vbox.getChildren().addAll(grid);
	    
		return vbox;
	}

	public HBox addHBox(Scene scene2, Scene scene3) {
		final Pane leftSpacer = new Pane();
	    HBox.setHgrow(leftSpacer, Priority.SOMETIMES);
	
	    final Pane rightSpacer = new Pane();
	    HBox.setHgrow(rightSpacer, Priority.SOMETIMES);
		
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    Button button1 = new Button("Button1");
	    button1.setPrefSize(100, 20);

	    Button button2 = new Button("Button2");
	    button2.setPrefSize(100, 20);
	    
	    Button button3 = new Button("Button3");
	    button3.setPrefSize(100, 20);
	    
	    Button button4 = new Button("Button4");
	    button4.setPrefSize(100, 20);
	    
	    Button button5 = new Button("Button5");
	    button5.setPrefSize(100, 20);
	    
	    Button button6 = new Button("Button6");
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
	    
	    hbox.getChildren().addAll(leftSpacer, button1, button2, button3, button4, button5, button6,  rightSpacer, buttonLogIn, buttonSignIn);

	    return hbox;
	}
}
