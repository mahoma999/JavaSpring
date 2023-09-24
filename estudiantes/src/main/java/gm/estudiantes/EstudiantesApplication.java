package gm.estudiantes;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gm.estudiantes.modelo.Estudiante;
import gm.estudiantes.servicio.EstudianteServicio;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {
	@Autowired
	EstudianteServicio estudianteServicio;
	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);
	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Ininciando la aplicacion...");
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Finalizando la aplicacion...");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecuntando metodo run de spring ..." + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);

		}
		// TODO Auto-generated method stub

	}

	private void mostrarMenu() {
		logger.info(nl);
		logger.info("*** SISTEMA DE eSTUDIANTES ***" + nl);
		logger.info("1. Listar Estudiantes" + nl);
		logger.info("2. Buscar Estudiante" + nl);
		logger.info("3. Agregar Estudiante" + nl);
		logger.info("4. Modificar Estudiante" + nl);
		logger.info("5. Eliminar Estudiante" + nl);
		logger.info("6. Salir" + nl);
		logger.info("Elige una opción:" + nl);
	}

	private boolean ejecutarOpciones(Scanner consola) {
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion) {
			case 1 :

			logger.info(nl + "Listado de Estudiantes: " + nl);
			List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
			estudiantes.forEach(estudiante -> logger.info(estudiante.toString() + nl));
			break; // Importante agregar el break para finalizar el caso
		case 2:
			logger.info("Introduce el id estudiante a buscar: ");
			var idEstudiante = Integer.parseInt(consola.nextLine());
			Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
			if (estudiante != null)
				logger.info("Estudiante encontrado: " + estudiante + nl);
			else
				logger.info("Estudiante No encontrado con id: " + idEstudiante + nl);
			break;
		case 3:
			logger.info("Agregar Estudiante: " + nl);
			logger.info("Nombre: ");
			var nombre = consola.nextLine();
			logger.info("Apellido: '");
			var apellido = consola.nextLine();
			logger.info("Telefono: ");
			var telefono = consola.nextLine();
			logger.info("Email: ");
			var email = consola.nextLine();
			// Crear el objeto estudiante sin el id
			Estudiante estudiante1 = new Estudiante();
			estudiante1.setNombre(nombre);
			estudiante1.setApellido(apellido);
			estudiante1.setTelefono(telefono);
			estudiante1.setEmail(email);
			estudianteServicio.guardarEstudiante(estudiante1);
			logger.info("Estudiante agregado: " + estudiante1 + nl);
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			salir=true;

			break;

		default:
			break;
		// Manejar otros casos aquí si es necesario
		}
		return salir;
	}

}
