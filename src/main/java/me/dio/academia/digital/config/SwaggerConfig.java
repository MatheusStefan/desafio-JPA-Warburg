package me.dio.academia.digital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("me.dio.academia.digital"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build());
		
		
		return docket;
	}
	
	private ApiInfoBuilder informacoesApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Rest API Academia Digital");
        apiInfoBuilder.description("API para estudos de JPA");
        apiInfoBuilder.version("1.0");

        return apiInfoBuilder;

    }
}
