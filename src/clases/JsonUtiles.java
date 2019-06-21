package clases;
/**
 * Clase JsonUtiles
 */
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;

public class JsonUtiles {
	/**
	 * Grabar
	 * @param array
	 */
	public static void grabar(JSONArray array,String nombre) {
		try {
			FileWriter file = new FileWriter(nombre);
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
/**
 * Leer
 * @return contenido leido
 */
	public static String leer(String nombre) 
	{
		String contenido = "";
		try 
		{
			contenido = new String(Files.readAllBytes(Paths.get(nombre)));
		} 
		catch (IOException e ) 
		{
			e.printStackTrace();
		}
		return contenido;
	}
}