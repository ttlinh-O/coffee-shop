package com.example.coffeeshop.controllers;

import com.example.coffeeshop.dtos.OrderRequestDTO;
import com.example.coffeeshop.dtos.OrderResponseDTO;
import com.example.coffeeshop.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Create an order", description = "Creates a new order based on the provided request.")
    @ApiResponse(responseCode = "201", description = "Order created successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = OrderResponseDTO.class)))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input")
    @ApiResponse(responseCode = "409", description = "Resource conflict")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PostMapping
    public OrderResponseDTO createOrder(
            @Parameter(description = "Order request data", required = true)
            @Valid @RequestBody OrderRequestDTO orderRequest) {
        return orderService.createOrder(orderRequest);
    }
}
