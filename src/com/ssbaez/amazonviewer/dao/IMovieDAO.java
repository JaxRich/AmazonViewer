package com.ssbaez.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.ssbaez.amazonviewer.db.IDBConnection;
import com.ssbaez.amazonviewer.model.Movie;
import static com.ssbaez.amazonviewer.db.DataBase.*;

/**
 * 	La idea de tener un patron de disegno es que se puedan manejar metodos CRUD
 * */

public interface IMovieDAO extends IDBConnection {
	
	default Movie setMovieViewed(Movie movie) {
		
		try(Connection connection = connectToDB()) {
			
			Statement statement = connection.createStatement();
			
			String query = "INSERT INTO " + TVIEWED + " (" + 
					TVIEWED_IDMATERIAL + ", " + 
					TVIEWED_IDELEMENT + ", " +
					TVIEWED_IDUSER + ")" +
					" VALUES(" + ID_TMATERIAL[0] + ", " + movie.getId() + ", " + TUSER_IDUSUARIO + ")";
			
			// devuelve la cantidad de tuplas afectadas, si dev algo > 0 si se ejecuto la sentencia, se insert el registro
			if(statement.executeUpdate(query) > 0)
				System.out.println("Se marco en visto");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return movie;
	}
	
	default ArrayList<Movie> read(){
		
		ArrayList<Movie> movies = new ArrayList();
		
		try(Connection connection = connectToDB()){
			
			String query = "SELECT * FROM " + TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE), 
						rs.getString(TMOVIE_GENRE), 
						rs.getString(TMOVIE_CREATOR), 
						Integer.valueOf(rs.getString(TMOVIE_DURATION)), 
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
				
				int id_movie = Integer.valueOf(rs.getString(TMOVIE_ID));
				
				movie.setId(id_movie);
				movie.setViewed(getMovieViewed(preparedStatement, connection, id_movie));
				movies.add(movie);
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return movies;
	}
	// este metodo es privado porque solo podrá ser accesado desde read() 
	// id_movie identificador de la pelicula, para cotejar si ya esta en la tabla viewed querra decir q ya fue vista
	private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM " + TVIEWED + 
				" WHERE " + TVIEWED_IDMATERIAL + "= ?" + 
				" AND " + TVIEWED_IDELEMENT + "= ?" +
				" AND " + TVIEWED_IDUSER + "= ?";
		ResultSet rs = null;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ID_TMATERIAL[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, TUSER_IDUSUARIO);
			
			rs = preparedStatement.executeQuery();
			viewed = rs.next(); 
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return viewed;
	}

}