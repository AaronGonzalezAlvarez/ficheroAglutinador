package ficheroAglutinador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EjerciciosTodo {
	
	public void ejercicio1() throws IOException {
		String file = "personas1.txt";
		existFile(file);
		System.out.println(readFileTypeOne(file));
	}
	
	public void ejercicio2() throws IOException {
		String file = "personas2.txt";
		existFile(file);
		System.out.println(readFileTypeTwo(file));
	}

	public void ejercicio3() throws IOException {

		String file = "personas1.txt";
		existFile(file);
		String data = readFileTypeOne(file);
		
		file = "personas2.txt";
		existFile(file);
		data += readFileTypeTwo(file);
		System.out.println(data);
		createLineFile("PersonaUnificado.txt", data);
	}
	
	public void ejercicio4() throws IOException {		
		String[] data = new String[5];
		data[0] = "ID";
		data[1] = "NAME";
		data[2] = "SURNAME";
		data[3] = "SURNAMETWO";
		data[4] = "PHONE";
		readConsole(data);
	}

	public void ejercicio5() throws IOException {
		String[] data = new String[5];
		data[0] = "ID";
		data[1] = "NAME";
		data[2] = "SURNAME";
		data[3] = "SURNAMETWO";
		data[4] = "PHONE";
		readConsoleTwo(data);
	}
	
	public void ejercicio6() {		
		String url = "personas1_todo.txt";
		File file = new File(url);
		if(file.exists()) {
			System.err.println("El fichero ya existe.");
		}else {			
			String nombreArchivo = "personas1.txt";
			try {
	            FileReader archivo = new FileReader(nombreArchivo);
	    		FileWriter archivoEscritura = new FileWriter(url,true);
	    	    BufferedWriter escritor = new BufferedWriter(archivoEscritura);
	            BufferedReader bufferedReader = new BufferedReader(archivo);
	            String linea;
	            while ((linea = bufferedReader.readLine()) != null) {
	                escritor.write(linea+"\n");
	            }
	            bufferedReader.close();      
	            escritor.close();
	        } catch (IOException e) {
	            System.err.println("Error al crear el archivo: " + e.getMessage());
	        }		
			nombreArchivo = "personas2.txt";        
	        try {
	            FileReader archivo = new FileReader(nombreArchivo);
	    		FileWriter archivoEscritura = new FileWriter(url,true);
	    	    BufferedWriter escritor = new BufferedWriter(archivoEscritura);
	            BufferedReader bufferedReader = new BufferedReader(archivo);
	            String linea;
	            while ((linea = bufferedReader.readLine()) != null) {       
	            	String[] datos = linea.split("@");
	                String id = addString(datos[0],4);
	                String name = addString(datos[1],10);
	                String surname = addString(datos[2],15);
	                String surnameTwo = addString(datos[3],15);
	                String phone = addString(datos[4],8);
	                escritor.write(id+name+surname+surnameTwo+phone+"\n");
	            }
	            bufferedReader.close();
	            escritor.close();
	        } catch (IOException e) {
	            System.err.println("Error al crear el archivo: " + e.getMessage());
	        }
	        System.out.println("Toda la información a sido volcada en "+url);
			
		}                
	}

	public void ejercicio7() {
		
		String url = "personas2_todo.txt";
		File file = new File(url);
		if(file.exists()) {
			System.err.println("El fichero ya existe.");
		}else {
			String nombreArchivo = "personas1.txt";
	        try {
	            FileReader archivo = new FileReader(nombreArchivo);
	    		FileWriter archivoEscritura = new FileWriter(url,true);
	    	    BufferedWriter escritor = new BufferedWriter(archivoEscritura);
	            BufferedReader bufferedReader = new BufferedReader(archivo);
	            String linea;
	            while ((linea = bufferedReader.readLine()) != null) {
	                String id = linea.substring(0, 4);
	                String name = linea.substring(4, 14);
	                String surname = linea.substring(14, 29);
	                String surnameTwo = linea.substring(29, 44);
	                String phone = linea.substring(44, 52);
	                escritor.write(id.trim()+ "@"+ name.trim()+ "@"+ surname.trim()+ "@"+ surnameTwo.trim()+ "@"+ phone.trim()+"\n");
	            }
	            bufferedReader.close();      
	            escritor.close();
	        } catch (IOException e) {
	            System.err.println("Error al crear el archivo: " + e.getMessage());
	        }
			nombreArchivo = "personas2.txt";
	        try {
	            FileReader archivo = new FileReader(nombreArchivo);
	    		FileWriter archivoEscritura = new FileWriter(url,true);
	    	    BufferedWriter escritor = new BufferedWriter(archivoEscritura);
	            BufferedReader bufferedReader = new BufferedReader(archivo);
	            String linea;
	            while ((linea = bufferedReader.readLine()) != null) {       
	            	String[] datos = linea.split("@");
	                escritor.write(datos[0].trim()+ "@"+ datos[1].trim()+ "@"+ datos[2].trim()+ "@"+ datos[3].trim()+ "@"+ datos[4].trim()+"\n");
	            }
	            bufferedReader.close();
	            escritor.close();
	        } catch (IOException e) {
	            System.err.println("Error al crear el archivo: " + e.getMessage());
	        }	
	        System.out.println("Toda la información a sido volcada en "+url);
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

	private String readFileTypeOne(String nameFile) {
		String nombreArchivo = nameFile;        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(archivo);
            String linea;
            String cadena= "";
            while ((linea = bufferedReader.readLine()) != null) {
                String id = linea.substring(0, 4);
                String name = linea.substring(4, 14);
                String surname = linea.substring(14, 29);
                String surnameTwo = linea.substring(29, 44);
                String phone = linea.substring(44, 52);
                String data = "id: " + id.trim()+ " name: "+ name.trim()+ " surname: "+ surname.trim()+ " surnameTwo: "+ surnameTwo.trim()+ " phone: "+ phone.trim()+"\n";
                cadena+= data;
            }            
            bufferedReader.close();  
            return cadena;
        } catch (IOException e) {
           return "Error al crear el archivo: " + e.getMessage();
        }		
	}

	private String readFileTypeTwo(String nameFile) {

		String nombreArchivo = nameFile;        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(archivo);
            String linea;
            String cadena = "";
            while ((linea = bufferedReader.readLine()) != null) {       
            	String[] datos = linea.split("@");
                String data ="id: " + datos[0]+ " name: "+ datos[1]+ " surname: "+ datos[2]+ " surnameTwo: "+ datos[3]+ " phone: "+ datos[4]+"\n";
                cadena +=data;
            }
            bufferedReader.close(); 
            return cadena;
        } catch (IOException e) {
           return "Error al crear el archivo: " + e.getMessage();
        }
		
	}
	
	private void existFile(String url) throws IOException {

		File file = new File(url);
		if(!file.exists()) {
			file.createNewFile();
		}
	}
	
	private void createLineFile (String url, String text) throws IOException {
		existFile(url);		
		FileWriter fileWriter = new FileWriter(url,true);
		BufferedWriter w = new BufferedWriter(fileWriter);
		w.newLine();
		w.write(text);
		w.close();
		fileWriter.close();
	}
	
	private void readConsole(String[] datosAPedir) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String cadena="";
		String data="";
		String dateConsola="";
		for(int x=0;x<datosAPedir.length;x++) {
			boolean aux= true;
			while(aux) {
				System.out.print("Por favor, ingrese "+datosAPedir[x]+": ");
				dateConsola = scanner.nextLine();
				if(datosAPedir[x].equals("ID")) {
					if(dateConsola.length() <=4) {
						aux=false;
					}
				}else if(datosAPedir[x].equals("NAME")) {
					if(dateConsola.length() <=10) {
						aux=false;
					}
				}else if(datosAPedir[x].equals("SURNAME") || datosAPedir[x].equals("SURNAMETWO")) {
					if(dateConsola.length() <=15) {
						aux=false;
					}
				}else if(datosAPedir[x].equals("PHONE")) {
					if(dateConsola.length() <=8) {
						aux=false;
					}
				}
				
				if(aux) {
					System.out.println("el "+ datosAPedir[x] + " sobrepasa el tamaño permitido");
				}
			}
			
			if(datosAPedir[x].equals("ID")) {
				data+=addString(dateConsola, 4);
			}else if(datosAPedir[x].equals("NAME")) {
				data+=addString(dateConsola, 10);				
			}else if(datosAPedir[x].equals("SURNAME") || datosAPedir[x].equals("SURNAMETWO")) {
				data+=addString(dateConsola, 15);				
			}else if(datosAPedir[x].equals("PHONE")) {
				data+=addString(dateConsola, 8);				
			}			
		}		
		createLineFile("personas1.txt", data);        
	}
	
	private void readConsoleTwo(String[] datosAPedir) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String cadena="";
		String data="";
		for(int x=0;x<datosAPedir.length;x++) {
			System.out.print("Por favor, ingrese "+datosAPedir[x]+": ");
			if(datosAPedir[x].equals("ID")) {
				data+=scanner.nextLine();
			}else if(datosAPedir[x].equals("NAME")) {
				data+="@"+scanner.nextLine();				
			}else if(datosAPedir[x].equals("SURNAME") || datosAPedir[x].equals("SURNAMETWO")) {
				data+="@"+scanner.nextLine();				
			}else if(datosAPedir[x].equals("PHONE")) {
				data+="@"+scanner.nextLine();				
			}
			
		}
		createLineFile("personas2.txt", data);        
	}
}
