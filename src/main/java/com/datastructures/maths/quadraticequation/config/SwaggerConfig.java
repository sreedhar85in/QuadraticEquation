package com.datastructures.maths.quadraticequation.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicates;

import io.swagger.models.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@ComponentScan({ "com.datastructures.maths.quadraticequation.controller" })
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
	public Docket userApi() {
		
		List<ResponseMessage> list = new java.util.ArrayList<>();
		list.add(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Result")).build());
		list.add(new ResponseMessageBuilder().code(400).message("Unauthorized").responseModel(new ModelRef("Result")).build());
		list.add(new ResponseMessageBuilder().code(406).message("Unacceptable").responseModel(new ModelRef("Result")).build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.datastructures.maths.quadraticequation.controller"))
				.build()
				.securitySchemes(Collections.singletonList(apiKey()))
		        .securityContexts(Collections.singletonList(securityContext()));



		}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("API for printing roots for Quadratic equation").description("THis project is for learning the Quadratic Equation of Data Structures").version("1.0.0").license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
		
	
	}
	
	 @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");

	    registry.addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	  }
	 
	 
	 
	
	 private ApiKey apiKey() {
		    return new ApiKey("Authorization", "Authorization", "header");
		  }
	 
	 //Method to make all the controllers with authetication
			
			private SecurityContext securityContext() {
				return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/sum.*"))
						.build();
			}
			
			  private List<SecurityReference> defaultAuth() { AuthorizationScope
			  authorizationScope = new AuthorizationScope("global", "accessEverything");
			  AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
			  authorizationScopes[0] = authorizationScope; return Arrays.asList(new
			  SecurityReference("Authorization", authorizationScopes)); }
			 
	 
	 //Add below to the docket method also for all authentication of the controllers.
			  ///check examplees of security context for specific method level authetication in the below link,
			  //https://www.codota.com/code/java/methods/springfox.documentation.spring.web.plugins.Docket/securityContexts
			  //test commit for checking emails
			/*
			 * private SecurityContext securityContext() { return
			 * SecurityContext.builder().securityReferences(defaultAuth()).forPaths(
			 * PathSelectors.regex("/v1/api/.*")).build(); }
			 */
	 //.securityContexts(Collections.singletonList(securityContext()));
			/*
			 * private List<SecurityReference> securityReference =
			 * singletonList(SecurityReference.builder() .reference("JWT") .scopes(new
			 * AuthorizationScope[0]) .build() );
			 * 
			 * private List<HttpMethod> methods = Arrays.asList( HttpMethod.POST,
			 * HttpMethod.PUT, HttpMethod.DELETE );
			 * 
			 * private List<SecurityContext> securityContext() { List<SecurityContext> lsc =
			 * new ArrayList<>();
			 * 
			 * lsc.add(SecurityContext.builder() .securityReferences(securityReference)
			 * .forPaths(PathSelectors.ant("" + "/category/**"))
			 * .forHttpMethods(Predicates.in(methods)) .build() );
			 * 
			 * lsc.add(SecurityContext.builder() .securityReferences(securityReference)
			 * .forPaths(PathSelectors.ant("" + "/tag/**"))
			 * .forHttpMethods(Predicates.in(methods)) .build() );
			 * 
			 * lsc.add(SecurityContext.builder() .securityReferences(securityReference)
			 * .forPaths(PathSelectors.ant("" + "/file/**"))
			 * .forHttpMethods(Predicates.in(methods)) .build() );
			 * 
			 * lsc.add(SecurityContext.builder() .securityReferences(securityReference)
			 * .forPaths(PathSelectors.ant("" + "/user/**")) .build() );
			 * 
			 * return lsc; }
			 */
	 
	 
}
