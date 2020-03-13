package br.com.ciclic.pdfGenerator.service;

import br.com.ciclic.pdfGenerator.resource.dto.HtmlRequest;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

@Service
public class TemplateService {


  public ResponseEntity<?> generateHtml(HtmlRequest htmlRequest){

    String html;
    try {
       html = processTemplate(htmlRequest.getTemplateName(), htmlRequest.getParameters());
    } catch (Exception e){
      return new ResponseEntity<>(e, HttpStatus.SERVICE_UNAVAILABLE);
    }
    return new ResponseEntity<>(html, HttpStatus.CREATED);
  }

//  private String processTemplate(String templateUrl, Map<String, String> variables){
//
//    TemplateEngine templateEngine = new TemplateEngine();
//    templateEngine.setTemplateResolver(emailTemplateResolver());
//    Context thymeleafContext = new Context();
//    thymeleafContext.setVariables(variables);
//    return templateEngine.process(templateUrl, thymeleafContext);
//  }

  private String processTemplate(String templateUrl, Map<String, Object> variables){

    TemplateEngine templateEngine = new TemplateEngine();
    templateEngine.setTemplateResolver(emailTemplateResolver());
    Context thymeleafContext = new Context();
    thymeleafContext.setVariables(variables);
    return templateEngine.process(templateUrl, thymeleafContext);
  }

  public UrlTemplateResolver emailTemplateResolver() {
    UrlTemplateResolver urlTemplateResolver = new UrlTemplateResolver();
    urlTemplateResolver.setTemplateMode("HTML5");
    urlTemplateResolver.setTemplateMode("XHTML");
    urlTemplateResolver.setCharacterEncoding("UTF-8");
    urlTemplateResolver.setOrder(1);
    return urlTemplateResolver;
  }

  private ClassLoaderTemplateResolver fileTemplateResolver() {
    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("XHTML");
    templateResolver.setCharacterEncoding("UTF-8");
    return templateResolver;
  }

}
