package com.amr.project.webapp.config.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**Аннотацией @Api помечаются классы-контроллеры.
 * Swagger при сканировании ищет сначала их, затем описывает их содержимое. */

@Api(value = "Имя контроллера для документации", description = "Краткое описание контроллера")
//@RestController
public class SwaggerControllerExample {


    @DeleteMapping("/{username}")

    /**Указываем операцию, в параметре:
     *  summary - короткое описание,
     *  description - развернутое описание */
    @Operation(summary = "Delete user",
            description = "This can only be done by the logged in user.")

    /**@ApiResponses - Используется когда ответов сервера несколько,
     *  в value перечисляются все ответы.
     *  Каждый отдельный помечается @ApiResponse */
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User deleted"),
        @ApiResponse(code = 400, message = "Invalid username"),
        @ApiResponse(code = 404, message = "User not found")
        })
    public Response deleteUser(

            /**Параметру можем добавить описание и необходимость (по дефолту false) */
            @Parameter(description = "The name that needs to be deleted", required = true) @PathVariable("username") String username) {
        return null;
    }

}
