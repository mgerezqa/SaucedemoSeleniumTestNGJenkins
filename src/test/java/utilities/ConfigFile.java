package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
		static Properties p;
		static FileReader fr;

	public static  void startConfig() throws IOException{
		try {
			 fr = new FileReader("D:\\Documentos\\Practicas_Testing\\Selenenium_WebDriver\\Saucedemo_TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
			 p = new Properties();
			 p.load(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static String read(String parameter) {
		return (p.getProperty(parameter));
	}

	public static void close() {
        try {
            if (fr != null) {
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
}
