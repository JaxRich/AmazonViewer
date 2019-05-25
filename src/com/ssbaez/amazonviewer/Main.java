package com.ssbaez.amazonviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ssbaez.amazonviewer.model.Movie;

public class Main {
	
	public static void main(String[] args) {
		
		//Movie movie = new Movie("Coco", "Fantasy", "Unknown", 120, (short)2017);
		//System.out.println(movie);
		showMenu();
		
	}
	
	public static void showMenu() {
		
		Scanner input = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println("BIENVENIDOS AMAZON VIEWER\n");
			System.out.println("Selecciona el número de la opción deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
			response = input.nextInt();
			
			switch(response) {
			case 0:
				// Salir
				break;
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
				break;
			case 6:
				makeReport(new Date());
				break;
				
			default:
				System.out.println("\n...¡¡Selecciona una opcion pendejazo!!...\n");
				break;
			}
			
		}while(response != 0);
		
	}
	
	public static void showMovies() {
		
		int response = 0;
		ArrayList<Movie> movies = Movie.makeMovieList(); //Así se llama a un metodo static sin crear un Objeto
		
		do {
			
			System.out.println("\n :: MOVIES ::\n");
			// Este for estara imprimiendo todos los datos de movies dummy
			for (int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			}
			System.out.println("0. Regresar al Menu\n");
			
			Scanner input = new Scanner(System.in);
			response = input.nextInt(); // Aquí se recibe la seleccion
			
			// Se crea una variable de tipo Movie
			Movie movieSelected;
			
			if(response != 0 && response <= movies.size()) { // Se evalua la seleccion
				movieSelected = movies.get(response - 1);
				movieSelected.setViewed(true);
				Date dateI = movieSelected.starToSee(new Date()); // Aquí se manda el momento en el que se empezo a ver y se guarda en dateI
				
				// Simulacion de ver la pelicula
				for (int i = 0; i < 10000 ; i++) {
					System.out.println(".....................................");
				}
				
				// Al terminar de ver la pelicula
				movieSelected.stopToSee(dateI, new Date());
				System.out.printf("%n%s%s %s%n", 
						"Viste: ", movieSelected, "milisegundos");
			}
			else if(response == 0)
				System.out.println("---> Saliendo a Menu Principal");
			else
				System.out.println("Selección errónea");
			
		}while(response != 0);
	}
	
	public static void showSeries() {
		int response = 0;
		do {
			System.out.println("\n :: SERIES ::\n");
		}while(response != 0);
	}
	
	public static void showChapters() {
		int response = 0;
		do {
			System.out.println("\n :: CHAPTERS ::\n");
		}while(response != 0);
	}
	
	public static void showBooks() {
		int response = 0;
		do {
			System.out.println("\n :: BOOKS ::\n");
		}while(response != 0);
	}
	
	public static void showMagazines() {
		int response = 0;
		do {
			System.out.println("\n :: MAGAZINES ::\n");
		}while(response != 0);
	}
	
	public static void makeReport() {
		
	}
	
	public static void makeReport(Date date) {
		
	}
}
