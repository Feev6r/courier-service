package dev.ferv.courier_service.infrastructure.configuration.openApi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "Fernando",
            email = "FernandoVillegass000@gmail.com"
        ),
        description = "OpenApi documentation for the microservice proyect",
        title = "OpenApi specification - Fernando",
        version = "1.0",
        license = @License(
            name = "",
            url = ""
        ),
        termsOfService = "Terms of service"
        
        
    ),
    servers = {
        @Server(
            description = "Local ENV",
            url = "http://localhost:8083/"
        )
    }

)
public class OpenApiConfiguration {

}
