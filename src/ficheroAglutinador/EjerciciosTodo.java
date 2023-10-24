package ficheroAglutinador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class EjerciciosTodo {
	
	public void ejercicio1() {
		String nombreArchivo = "personas1.txt";
        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            
         // Crea un BufferedReader para leer el archivo
            BufferedReader bufferedReader = new BufferedReader(archivo);

            String linea;
            // Lee y muestra el contenido del archivo línea por línea
            while ((linea = bufferedReader.readLine()) != null) {
                String id = linea.substring(0, 4);
                String name = linea.substring(4, 14);
                String surname = linea.substring(14, 29);
                String surnameTwo = linea.substring(29, 44);
                String phone = linea.substring(44, 52);
                System.out.println("id: " + id.trim()+ " name: "+ name.trim()+ " surname: "+ surname.trim()+ " surnameTwo: "+ surnameTwo.trim()+ " phone: "+ phone.trim());
            }

            // Cierra el BufferedReader
            bufferedReader.close();            
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
	}
	
	public void ejercicio2() {
		String nombreArchivo = "personas2.txt";
        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            
         // Crea un BufferedReader para leer el archivo
            BufferedReader bufferedReader = new BufferedReader(archivo);

            String linea;
            // Lee y muestra el contenido del archivo línea por línea
            while ((linea = bufferedReader.readLine()) != null) {       
            	String[] datos = linea.split("@");
                System.out.println("id: " + datos[0]+ " name: "+ datos[1]+ " surname: "+ datos[2]+ " surnameTwo: "+ datos[3]+ " phone: "+ datos[4]);
            }

            // Cierra el BufferedReader
            bufferedReader.close();            
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
	}

	public void ejercicio3() throws IOException {
		String nombreArchivo = "personas1.txt";		
		String PersonaUnificado = "PersonaUnificado.txt";		
		FileWriter fileWriter = new FileWriter(PersonaUnificado);        
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);               
        
        
        try {
            FileReader archivo = new FileReader(nombreArchivo);            
            BufferedReader bufferedReader = new BufferedReader(archivo);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String id = linea.substring(0, 4);
                String name = linea.substring(4, 14);
                String surname = linea.substring(14, 29);
                String surnameTwo = linea.substring(29, 44);
                String phone = linea.substring(44, 52);
                System.out.println("id: " + id.trim()+ " name: "+ name.trim()+ " surname: "+ surname.trim()+ " surnameTwo: "+ surnameTwo.trim()+ " phone: "+ phone.trim());
                bufferedWriter.write( id+ name+ surname+ surnameTwo+phone);
                bufferedWriter.newLine();
            }

            bufferedReader.close();            
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
        
        nombreArchivo = "personas2.txt";
        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            
         // Crea un BufferedReader para leer el archivo
            BufferedReader bufferedReader = new BufferedReader(archivo);

            String linea;
            // Lee y muestra el contenido del archivo línea por línea
            while ((linea = bufferedReader.readLine()) != null) {       
            	String[] datos = linea.split("@");
                System.out.println("id: " + datos[0]+ " name: "+ datos[1]+ " surname: "+ datos[2]+ " surnameTwo: "+ datos[3]+ " phone: "+ datos[4]);
                bufferedWriter.write(datos[0]+ "@"+datos[1]+ "@"+datos[2]+ "@"+datos[3]+ "@"+datos[4]);
                bufferedWriter.newLine();
            }

            // Cierra el BufferedReader
            bufferedReader.close();            
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
        
        bufferedWriter.close();
	}
	
	public void ejercicio4() {
		String nombreArchivo = "personas1.txt";

        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String id = "1111";
            String name="uuuuuuuuuu";
            String surname="qqqqqqqqqqqqqqq";
            String surnameTwo="sssssssssssssss";
            String phone = "12345678";
            String cadena = id + name +surname + surnameTwo +phone+"\n";
            bufferedWriter.write(cadena);
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
	}
	//mirar porque no me escribe debajo
	public void ejercicio5() {
		String nombreArchivo = "personas2.txt";

        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String id = "1111";
            String name="uuuuuuuuuu";
            String surname="qqqqqqqqqqqqqqq";
            String surnameTwo="sssssssssssssss";
            String phone = "12345678";
            String cadena = id + "@"+ name + "@"+surname + "@"+ surnameTwo + "@"+phone+"\n";
            bufferedWriter.write(cadena);
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
	}
	
	public void ejercicio6() {
		
		String nombreArchivo = "personas1.txt";
		String nuevoArchivo = "Personas1_todo.txt";
        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
    		FileWriter archivoEscritura = new FileWriter(nuevoArchivo,true);
    	    BufferedWriter escritor = new BufferedWriter(archivoEscritura);
            
         // Crea un BufferedReader para leer el archivo
            BufferedReader bufferedReader = new BufferedReader(archivo);

            String linea;
            // Lee y muestra el contenido del archivo línea por línea
            while ((linea = bufferedReader.readLine()) != null) {
                String id = linea.substring(0, 4);
                String name = linea.substring(4, 14);
                String surname = linea.substring(14, 29);
                String surnameTwo = linea.substring(29, 44);
                String phone = linea.substring(44, 52);
                System.out.println("id: " + id.trim()+ " name: "+ name.trim()+ " surname: "+ surname.trim()+ " surnameTwo: "+ surnameTwo.trim()+ " phone: "+ phone.trim());
                escritor.write(linea+"\n");
            }

            // Cierra el BufferedReader
            bufferedReader.close();      
            escritor.close();
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
        
        System.out.println("nuevo fichero");
		
		nombreArchivo = "personas2.txt";
        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
    		FileWriter archivoEscritura = new FileWriter(nuevoArchivo,true);
    	    BufferedWriter escritor = new BufferedWriter(archivoEscritura);
            
         // Crea un BufferedReader para leer el archivo
            BufferedReader bufferedReader = new BufferedReader(archivo);

            String linea;
            // Lee y muestra el contenido del archivo línea por línea
            while ((linea = bufferedReader.readLine()) != null) {       
            	String[] datos = linea.split("@");
                String id = addString(datos[0],4);
                String name = addString(datos[1],10);
                String surname = addString(datos[2],15);
                String surnameTwo = addString(datos[3],15);
                String phone = addString(datos[4],8);
                escritor.write(id+name+surname+surnameTwo+phone+"\n");
            }

            // Cierra el BufferedReader
            bufferedReader.close();
            escritor.close();
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
		
	}

	public void ejercicio7() {
		
		String nombreArchivo = "personas1.txt";
		String nuevoArchivo = "Personas2_todo.txt";
        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
    		FileWriter archivoEscritura = new FileWriter(nuevoArchivo,true);
    	    BufferedWriter escritor = new BufferedWriter(archivoEscritura);
            
         // Crea un BufferedReader para leer el archivo
            BufferedReader bufferedReader = new BufferedReader(archivo);

            String linea;
            // Lee y muestra el contenido del archivo línea por línea
            while ((linea = bufferedReader.readLine()) != null) {
                String id = linea.substring(0, 4);
                String name = linea.substring(4, 14);
                String surname = linea.substring(14, 29);
                String surnameTwo = linea.substring(29, 44);
                String phone = linea.substring(44, 52);
                System.out.println("id: " + id.trim()+ " name: "+ name.trim()+ " surname: "+ surname.trim()+ " surnameTwo: "+ surnameTwo.trim()+ " phone: "+ phone.trim());
                escritor.write(id.trim()+ "@"+ name.trim()+ "@"+ surname.trim()+ "@"+ surnameTwo.trim()+ "@"+ phone.trim()+"\n");
            }

            // Cierra el BufferedReader
            bufferedReader.close();      
            escritor.close();
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
        
        System.out.println("nuevo fichero");
		
		nombreArchivo = "personas2.txt";
        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
    		FileWriter archivoEscritura = new FileWriter(nuevoArchivo,true);
    	    BufferedWriter escritor = new BufferedWriter(archivoEscritura);
            
         // Crea un BufferedReader para leer el archivo
            BufferedReader bufferedReader = new BufferedReader(archivo);

            String linea;
            // Lee y muestra el contenido del archivo línea por línea
            while ((linea = bufferedReader.readLine()) != null) {       
            	String[] datos = linea.split("@");
                System.out.println("id: " + datos[0]+ " name: "+ datos[1]+ " surname: "+ datos[2]+ " surnameTwo: "+ datos[3]+ " phone: "+ datos[4]);
                escritor.write(datos[0].trim()+ "@"+ datos[1].trim()+ "@"+ datos[2].trim()+ "@"+ datos[3].trim()+ "@"+ datos[4].trim()+"\n");
            }

            // Cierra el BufferedReader
            bufferedReader.close();
            escritor.close();
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
		
	}	
	
	public void ejercicio8() {
		
	}
	
	//perguntar a sergio
	public void ejercicio9() {
		ArrayList<Persona> personasList = new ArrayList<>();
		personasList.add(new Persona(1,"Aaron","Gonzalez","Alvarez",695236510));
		personasList.add(new Persona(1,"Jose","Torres","Garcia",632541256));
		personasList.add(new Persona(1,"Juan","Gonzalez","Alvarez",965236541));
		personasList.add(new Persona(1,"Pedro","Marquez","Alvarez",369852147));
		
		//crearmos el archivo y lo guardamos
		try {
			FileOutputStream fileOut = new FileOutputStream("PUserializado.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(personasList);
			out.close();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//leer .ser
		ArrayList<Persona> leerPersona = null;
		
		try {
			FileInputStream fileIn = new FileInputStream("PUserializado.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			leerPersona = (ArrayList<Persona>) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Persona persona : leerPersona) {
            System.out.println("id: " + persona.getId() + " name: "+ persona.getName());
        }
		
		
	}
	
	public void ejercicio10() {
		
	}
	
	private String addString(String data,int size) {
		int sizeData = data.length();
		if(sizeData == size) {
			return data;			
		}else {
			for(int x =0; x<(size-sizeData);x++) {
				data+=" ";
			}
			String newdata = data;
			return newdata;
		}
	}
}
