package br.com.ciclic.pdfGenerator.resource;

import br.com.ciclic.pdfGenerator.resource.dto.HtmlRequest;
import br.com.ciclic.pdfGenerator.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/")
public class GenerateResource {

  @Autowired
  private TemplateService templateService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_HTML_VALUE)
  public ResponseEntity<?> processTemplate(@RequestBody HtmlRequest htmlRequest)  {

    return templateService.generateHtml(htmlRequest);
  }

}
