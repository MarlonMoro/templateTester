package br.com.ciclic.pdfGenerator;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);

	}


}