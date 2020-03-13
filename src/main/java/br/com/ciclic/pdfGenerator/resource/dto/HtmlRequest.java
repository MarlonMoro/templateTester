package br.com.ciclic.pdfGenerator.resource.dto;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;


public class HtmlRequest {

  @NotNull
  private Map<String, Object> parameters = new HashMap<>();
  @NotBlank
  private String templateName;

  public Map<String, Object> getParameters() {
    return parameters;
  }

  public String getTemplateName() {
    return templateName;
  }
}
