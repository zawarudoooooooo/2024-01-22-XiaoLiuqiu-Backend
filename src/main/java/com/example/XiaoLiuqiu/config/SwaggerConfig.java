package com.example.XiaoLiuqiu.config;
//package com.example.quiz.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration //跟 spring 說此 class 為配置類
//@EnableOpenApi //通過此註釋來啟用 swagger
//@EnableWebMvc //引入 DelegatingWebMvcConfiguration 配置類，並啟用 spring MVC
//public class SwaggerConfig {
//	
//	// 接口訊息，包括 標題、說明、版本、聯絡人等
//	private ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder() //
//			.title("Quiz Restful API") // 標題
//			.description("Quiz API") // 說明
////			.termsOfServiceUrl("urn:tos") // 服務條款網址，默認 urn:tos
////			.contact(new Contact("DEFAULT", "", "")) // 聯絡人
////			.license("Apache 2.0") //
////			.version("v3") // 版本
////			.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.txt") //
//			.build();
//
//	@Bean
//	public Docket api() {
//		// 返回文檔概要訊息
//		return new Docket(DocumentationType.SWAGGER_2) //
//				.apiInfo(DEFAULT_API_INFO)//
//				.select()//
//				.apis(RequestHandlerSelectors.basePackage("com.example.quiz.controller"))//
//				.paths(PathSelectors.any())//
//				.build();
//	}
//}
