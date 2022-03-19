package com.cognizant.academy.blueteam.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Quantity cannot be negative")
public class NegativeQuantityException extends Exception{

}
