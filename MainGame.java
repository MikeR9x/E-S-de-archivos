package adivina;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MainGame {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
            File file, directory;
            String path;
            System.out.print("Enter file path: ");
            //C:\Users\El Mike\Desktop\Nemesiz\Code
            path = scan.nextLine();
            file = new File(path);
            if (file.exists()) {
                directory = new File(file.getParent());
                System.out.println("Directory: " + directory.getName());
                System.out.println("File selected to open: " + file.getName());
                System.out.println("Full path name: " + file.getAbsolutePath());
            } else {
                System.out.println("File does not exist.");
            }
            System.out.println("\n\n");
            System.out.print("Enter file path for saving data: ");
            path = scan.nextLine();
            file = new File(path);
            directory = new File(file.getParent());
            if (!directory.exists()) {
                directory.mkdirs();
            }
            if (file.exists()) {
                System.out.println("File already exists.");
            } else {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Directory: " + directory.getName());
            System.out.println("File selected for saving data: " + file.getName());
            System.out.println("Full path name: " + file.getAbsolutePath());
		
			try {
					int option = 1;
					int wins = 0;
					int games = 0;
					System.out.println("Ingresa tu usuario");
					String jugador = scan.nextLine();
					while(option == 1) {
						write(wins, games, jugador, file);
						read(file);
						Game game = new Game(10);
						game.PrintMenu();
						games++;
						wins += game.wins;
						System.out.println("Seguir jugando = 1, salir = 2");
						option = scan.nextInt();
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void write(int wins, int games, String jugador, File file) throws IOException {
		
		FileWriter fileWriter 	= new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print("Bienvenido ");
		printWriter.print(jugador);
		printWriter.print(" al juego: Adivina quién?\n");
		printWriter.print("Juegos ganados: ");
		printWriter.println(wins);
		printWriter.print("Juegos jugados: ");
		printWriter.println(games);
		printWriter.close();
	}
	
	public static void read(File file)  throws IOException{
        // Creating a path choosing file from local
        // directory by creating an object of Path class
        Path fileName = Path.of(file.getPath());
        // Now calling Files.readString() method to
        // read the file
        String str = Files.readString(fileName);
        // Printing the string
        System.out.println(str);
    }	
}