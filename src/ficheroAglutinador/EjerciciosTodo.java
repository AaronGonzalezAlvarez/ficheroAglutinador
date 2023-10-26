package ficheroAglutinador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
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
import java.util.Random;
import java.util.Scanner;

public class EjerciciosTodo {
	
	public void ejercicio1() throws IOException {
		String file = "personas1.txt";
		createFileIfnotExist(file);
		ArrayList<Person> people = readFileTypeOne(file);
		for (Person person : people) {
            System.out.println("ID: "+person.getId()+" NAME: "+person.getName()+" SURNAME: "+ person.getSurname() + " SURNAMETWO: " + person.getSurnameTwo()+" PHONE: "+person.getPhone());
        }
	}
	
	public void ejercicio2() throws IOException {
		String file = "personas2.txt";
		createFileIfnotExist(file);
		ArrayList<Person> people = readFileTypeTwo(file);
		for (Person person : people) {
            System.out.println("ID: "+person.getId()+" NAME: "+person.getName()+" SURNAME: "+ person.getSurname() + " SURNAMETWO: " + person.getSurnameTwo()+" PHONE: "+person.getPhone());
        }
	}

	public void ejercicio3() throws IOException {
		ArrayList<Person> personaUnificada = new ArrayList<Person>();
		String file = "personas1.txt";
		createFileIfnotExist(file);
		ArrayList<Person> people = readFileTypeOne(file);
		for (Person person : people) {
			personaUnificada.add(new Person(person.getId(),person.getName(),person.getSurname(),person.getSurnameTwo(),person.getPhone()));
        }		
		file = "personas2.txt";
		createFileIfnotExist(file);
		ArrayList<Person> peopleTwo = readFileTypeTwo(file);
		for (Person person : peopleTwo) {
			personaUnificada.add(new Person(person.getId(),person.getName(),person.getSurname(),person.getSurnameTwo(),person.getPhone()));
        }
		
		for (Person person : personaUnificada) {
            System.out.println("ID: "+person.getId()+" NAME: "+person.getName()+" SURNAME: "+ person.getSurname() + " SURNAMETWO: " + person.getSurnameTwo()+" PHONE: "+person.getPhone());
        }
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

	public void ejercicio7() throws IOException {
		
		String url = "personas2_todo.txt";
		File file = new File(url);
		if(file.exists()) {
			System.err.println("El fichero ya existe.");
		}else {
			
			addTextFileFormat(url,"personas1.txt");
			addTextFileFormat(url,"personas2.txt");
	        System.out.println("Toda la información a sido volcada en "+url);
		}					
	}	
	
	public void ejercicio8() throws IOException {
		String newFile ="UnificadoValorTexto.txt";
		String newFileBinaire = "UnificadoValorBinario.txt";
		
		FileWriter newFileWriter = new FileWriter(newFile);
		BufferedWriter w = new BufferedWriter(newFileWriter);
		
		FileOutputStream ileOutputStream = new FileOutputStream(newFileBinaire);
		DataOutputStream wFileBinaire = new DataOutputStream(ileOutputStream);
		ArrayList<Person> personaUnificada = new ArrayList<Person>();
		Random rand = new Random();
		String file = "personas1.txt";
		createFileIfnotExist(file);
		ArrayList<Person> people = readFileTypeOne(file);
		for (Person person : people) {
			personaUnificada.add(new Person(person.getId(),person.getName(),person.getSurname(),person.getSurnameTwo(),person.getPhone()));			
        }		
		file = "personas2.txt";
		createFileIfnotExist(file);
		ArrayList<Person> peopleTwo = readFileTypeTwo(file);
		for (Person person : peopleTwo) {
			personaUnificada.add(new Person(person.getId(),person.getName(),person.getSurname(),person.getSurnameTwo(),person.getPhone()));
        }
		
		for (Person person : personaUnificada) {			
			w.write("ID: "+person.getId()+" NAME: "+person.getName()+" SURNAME: "+ person.getSurname() + " SURNAMETWO: " + person.getSurnameTwo()+" PHONE: "+person.getPhone());       
			w.newLine();
			
			String cadena = "ID: "+person.getId()+" NAME: "+person.getName()+" SURNAME: "+ person.getSurname() + " SURNAMETWO: " + person.getSurnameTwo()+" PHONE: "+person.getPhone();
			byte[] stringByte = cadena.getBytes("UTF-8"); 
			wFileBinaire.writeInt(stringByte.length);
			wFileBinaire.write(stringByte);
			
			int numeroAleatorio = rand.nextInt(11) + 90;
			for(int x=0; x<numeroAleatorio;x++) {
				Long num= numRamdon();				
				w.write(person.getId()+"@"+num);
				w.newLine();
				
				cadena = person.getId()+"@"+num;
				byte[] stringByteTwo = cadena.getBytes("UTF-8"); 
				wFileBinaire.writeInt(stringByteTwo.length);
				wFileBinaire.write(stringByteTwo);
			}
        }
		wFileBinaire.close();
		w.close();
		newFileWriter.close();
		
		System.out.println("Archivos creados correctamente.");
		
	}
	
	public void ejercicio9() throws IOException {
		ArrayList<Person> personaUnificada = new ArrayList<Person>();
		String file = "personas1.txt";
		createFileIfnotExist(file);
		ArrayList<Person> people = readFileTypeOne(file);
		for (Person person : people) {
			personaUnificada.add(new Person(person.getId(),person.getName(),person.getSurname(),person.getSurnameTwo(),person.getPhone()));
        }		
		file = "personas2.txt";
		createFileIfnotExist(file);
		ArrayList<Person> peopleTwo = readFileTypeTwo(file);
		for (Person person : peopleTwo) {
			personaUnificada.add(new Person(person.getId(),person.getName(),person.getSurname(),person.getSurnameTwo(),person.getPhone()));
        }
		
		//crearmos el archivo y lo guardamos
		File fileSer = new File("PUserializado.ser");
		if(fileSer.exists()) {
			fileSer.delete();
		}
		try {
			FileOutputStream fileOut = new FileOutputStream("PUserializado.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(personaUnificada);
			out.close();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//leer .ser
		ArrayList<Person> leerPersona = null;
		
		try {
			FileInputStream fileIn = new FileInputStream("PUserializado.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			leerPersona = (ArrayList<Person>) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Person persona : leerPersona) {
            System.out.println("id: " + persona.getId() + " name: "+ persona.getName() + " surname: "+ persona.getSurname() + " name: "+ persona.getSurnameTwo() + " name: "+ persona.getPhone());
        }
		
		
	}
	
	public void ejercicio10() throws IOException {
		ArrayList<Person> personaUnificada = new ArrayList<Person>();
		Random rand = new Random();
		String file = "personas1.txt";
		createFileIfnotExist(file);
		ArrayList<Person> people = readFileTypeOne(file);
		for (Person person : people) {
			personaUnificada.add(new Person(person.getId(),person.getName(),person.getSurname(),person.getSurnameTwo(),person.getPhone()));			
        }		
		file = "personas2.txt";
		createFileIfnotExist(file);
		ArrayList<Person> peopleTwo = readFileTypeTwo(file);
		for (Person person : peopleTwo) {
			personaUnificada.add(new Person(person.getId(),person.getName(),person.getSurname(),person.getSurnameTwo(),person.getPhone()));
        }
		for (Person person : personaUnificada) {
			int numeroAleatorio = rand.nextInt(11) + 90;
			for(int x=0; x<numeroAleatorio;x++) {
				Long num= numRamdon();
				person.addLine(new Line(person.getId(),num));
			}
        }			
		//crearmos el archivo y lo guardamos
		File fileSer = new File("PUserializadoExtendido.ser");
		if(fileSer.exists()) {
			fileSer.delete();
		}
		try {
			FileOutputStream fileOut = new FileOutputStream("PUserializadoExtendido.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(personaUnificada);
			out.close();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//leer .ser
		ArrayList<Person> leerPersona = null;
		
		try {
			FileInputStream fileIn = new FileInputStream("PUserializadoExtendido.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			leerPersona = (ArrayList<Person>) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Person persona : leerPersona) {
            System.out.println("id: " + persona.getId() + " name: "+ persona.getName() + " surname: "+ persona.getSurname() + " name: "+ persona.getSurnameTwo() + " name: "+ persona.getPhone());
            for(Line line: persona.getLines()) {
            	System.out.println("\tID: "+ line.getId() + " NUM: "+line.getNum());
            }
        }
		
	}
	
	private Long numRamdon() {
		Random rand = new Random();
        long rangoMinimo = 123456789L;
        long rangoMaximo = 999999999L;
        long numeroAleatorio = rand.nextLong();
        if (numeroAleatorio < 0) {
            numeroAleatorio = Math.abs(numeroAleatorio);
        }
        numeroAleatorio = numeroAleatorio % (rangoMaximo - rangoMinimo + 1) + rangoMinimo;
		return numeroAleatorio;		
	}
	
	private void addTextFileFormat(String urlFile,String urlFileText) throws IOException {
		createFileIfnotExist(urlFile);
		try {
            FileReader archivo = new FileReader(urlFileText);
    		FileWriter archivoEscritura = new FileWriter(urlFile,true);
    	    BufferedWriter escritor = new BufferedWriter(archivoEscritura);
            BufferedReader bufferedReader = new BufferedReader(archivo);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
            	if(urlFileText.equals("personas1.txt")) {
            		String id = linea.substring(0, 4);
                    String name = linea.substring(4, 14);
                    String surname = linea.substring(14, 29);
                    String surnameTwo = linea.substring(29, 44);
                    String phone = linea.substring(44, 52);
                    escritor.write(id.trim()+ "@"+ name.trim()+ "@"+ surname.trim()+ "@"+ surnameTwo.trim()+ "@"+ phone.trim()+"\n");
            	}else {
            		String[] datos = linea.split("@");
                escritor.write(datos[0].trim()+ "@"+ datos[1].trim()+ "@"+ datos[2].trim()+ "@"+ datos[3].trim()+ "@"+ datos[4].trim()+"\n");
            	}                
            }
            bufferedReader.close();      
            escritor.close();
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
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

	private ArrayList<Person> readFileTypeOne(String nameFile) {		
		ArrayList<Person> people = new ArrayList<Person>();
		String nombreArchivo = nameFile;        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(archivo);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                int id = Integer.parseInt(linea.substring(0, 4).trim());
                String name = linea.substring(4, 14).trim();
                String surname = linea.substring(14, 29).trim();
                String surnameTwo = linea.substring(29, 44).trim();
                int phone = Integer.parseInt(linea.substring(44, 52).trim());        
                people.add(new Person(id,name,surname,surnameTwo,phone));
            }            
            bufferedReader.close();
        } catch (IOException e) {
            e.getMessage();
        }
		return people;		
	}

	private ArrayList<Person> readFileTypeTwo(String nameFile) {
		ArrayList<Person> people = new ArrayList<Person>();
		String nombreArchivo = nameFile;        
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(archivo);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {       
            	String[] datos = linea.split("@");
            	int id = Integer.parseInt(datos[0]);
            	int phone = Integer.parseInt(datos[4]);
                people.add(new Person(id,datos[1],datos[2],datos[3],phone));
            }
            bufferedReader.close(); 
        } catch (IOException e) {
           e.getMessage();
        }
		return people;		
	}
	
	private void createFileIfnotExist(String url) throws IOException {

		File file = new File(url);
		if(!file.exists()) {
			file.createNewFile();
		}
	}
	
	private void createLineFile (String url, String text) throws IOException {
		createFileIfnotExist(url);		
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
		ejercicio1();
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
		ejercicio2();
	}
}
