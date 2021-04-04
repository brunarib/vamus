package br.com.vamus.controller.dtos.open.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "CategoriaDTO")
@ApiResponses({
        @ApiResponse(code = 500, message = "There was an internal error"/*, response = Problem.class*/)
})
public interface CategoriasControllerOpenApi {

}
