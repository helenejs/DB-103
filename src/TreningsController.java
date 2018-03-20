
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

	import javafx.application.Application;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextField;
	import javafx.stage.Stage;
	

public class TreningsController extends Application{

		
		@FXML
		Button registerWorkoutButton, registerExerciseButton, registerMachineButton, registerExcersiceGroupButton,
		registerExerciseInGroupButton, registerExerciseInWorkoutButton, registerExerciseOnMachineButton;
		
		@FXML
		TextField registrerTreningsoktFelt, registrerOvelseFelt, registrerApparatFelt, registrerOvelsesgruppeFelt,
		registrerOvelseIGruppeFelt,registrerOvelseITreningsoktFelt, registrerOvelsePaaApparatFelt;
		
		public TreningsController() {
			
		}
		
		
		//register workout to databse
		@FXML
		public void registrerTreningsokt() throws SQLException {
			List<String> input = Arrays.asList(registrerTreningsoktFelt.getText().split(","));
			Connection myConn = new Main().connect();
			List<String> dateString = Arrays.asList(input.get(0).split("-"));
			int year = Integer.parseInt(dateString.get(0));
			int month = Integer.parseInt(dateString.get(1));
			int day = Integer.parseInt(dateString.get(2));
			Date date = new Date(year, month, day);
			String time = input.get(1);
			int duration = Integer.parseInt(input.get(2));
			int personligForm = Integer.parseInt(input.get(3));
			int prestasjon = Integer.parseInt(input.get(4));
			String notat = input.get(5);
			System.out.println(input);
			//AdminController.insertWorkout(myConn, date, time, duration, personligForm, prestasjon, notat);
			System.out.println("Treningsøkt lagt til");
		
		}
		
		
		@FXML
		public void registrerOvelse() throws SQLException {
			List<String> input = Arrays.asList(registrerOvelseFelt.getText().split(","));
			Connection myConn = new Main().connect();
			String navn = input.get(0);
			String beskrivelse = input.get(1);
			
			AdminController.settinnOvelse(myConn, navn, beskrivelse);
			System.out.println("Exercise added");
		}
		
		@FXML
		public void registrerApparat() throws SQLException {
			List<String> input = Arrays.asList(registrerApparatFelt.getText().split(","));
			Connection myConn = new Main().connect();
			String navn = input.get(0);
			String beskrivelse = input.get(1);
			
			AdminController.settInnApparat(myConn, navn, beskrivelse);
			System.out.println("Apprat lagt til");
		}
		
		
		@FXML
		public void registrerOvelsesgruppe() throws SQLException {
			List<String> input = Arrays.asList(registrerOvelsesgruppeFelt.getText().split(","));
			Connection myConn = new Main().connect();
			String navn = input.get(0);
			
			AdminController.settInnOvelsesgruppe(myConn, navn);
			System.out.println("Exercise group added");
		}
		
		
		@FXML
		public void registrerOvelseIGruppe() throws SQLException {
			List<String> input = Arrays.asList(registrerOvelseIGruppeFelt.getText().split(","));
			Connection myConn = new Main().connect();
			String groupName = input.get(0);
			String exerciseName = input.get(1);
			
			AdminController.settInnGruppeMedOvelse(myConn, groupName, exerciseName);
			System.out.println("Exercise added to exercise group.");
		}
		
		
		@FXML
		public void registrerOvelseITreningsokt() throws SQLException {
			List<String> input = Arrays.asList(registrerOvelseITreningsoktFelt.getText().split(","));
			Connection myConn = new Main().connect();
			List<String> dateString = Arrays.asList(input.get(0).split("-"));
			int year = Integer.parseInt(dateString.get(0));
			int month = Integer.parseInt(dateString.get(1));
			int day = Integer.parseInt(dateString.get(2));
			Date workoutDate = new Date(year, month, day);
			String exerciseName = input.get(1);
			int antallKilo = Integer.parseInt(input.get(2));
			int antallSet = Integer.parseInt(input.get(3));
			
			AdminController.settinnTreningsoktMedOvelse(myConn, workoutDate, exerciseName, antallKilo, antallSet);
			System.out.println("Exercise was added to this workout");
		}
		
		
		@FXML
		public void registrerOvelsePaaApparat() throws SQLException {
			List<String> input = Arrays.asList(registrerOvelsePaaApparatFelt.getText().split(","));
			Connection myConn = new Main().connect();
			String exerciseName = input.get(0);
			String machineName = input.get(1);
			
			AdminController.settInnOvelsePaaApparat(myConn, exerciseName, machineName);
			System.out.println("Exercise was added to the machine");
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
		    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Hovedside.fxml"));
		    		Parent root = loader.load();
		    		Scene scene = new Scene(root);
		    		primaryStage.setScene(scene);
		    		primaryStage.show();
		    		
		    }

		    
		public static void main(String[] args) {
		        launch(args);
		}
	}