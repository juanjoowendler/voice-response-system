package ppai.grupo6.services.utils;
import java.io.File;
import java.io.IOException;
public class ReactAppLauncher {
    public static void launchReactApp() {
        try {
            // Ruta al directorio de tu proyecto React
            String proyectoReactPath = "C://Users//JP_La//repositorios//DSI//PPAI_JAVA//frontend-react-verdad";

            // Comando para iniciar la aplicación React
            String comando = "npm start";

            // Configura el proceso
            ProcessBuilder processBuilder = new ProcessBuilder()
                    .directory(new File(proyectoReactPath))
                    .command("cmd", "/c", comando);

            // Inicia el proceso
            Process procesoReact = processBuilder.start();

            // Espera a que el proceso termine (si es necesario)
            int exitCode = procesoReact.waitFor();
            System.out.println("La aplicación React ha terminado con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
