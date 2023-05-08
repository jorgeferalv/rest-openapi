package com.formacion.controller;

import com.formacion.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Tag(name = "Employee", description = "Employee API REST with CRUD operations")
public class EmployeeController {

    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Retrieved employees",
                content={ @Content(mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = Employee.class)))})
    })
    @Operation(summary ="findAll employees", description = "Il retrieves all employees from databases without pagination")
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(List.of(
                new Employee(1L, "emp1", LocalDate.of(1990,1,1), 400000.0, true),
                new Employee(2L, "emp1", LocalDate.of(1991,1,1), 500000.0, false),
                new Employee(3L, "emp1", LocalDate.of(1992,1,1), 600000.0, true)
        ));
    }
}
