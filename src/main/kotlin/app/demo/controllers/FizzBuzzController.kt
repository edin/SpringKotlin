package app.demo.controllers

import app.demo.domain.FizzBuzzValue
import app.demo.services.*
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FizzBuzzController(val fizzBuzzService: FizzBuzzService)
{
    @GetMapping(value = ["/fizz"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fizz() : List<FizzBuzzValue> {
        return fizzBuzzService.getFizzValues()
    }

    @GetMapping(value = ["/buzz"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun buzz() : List<FizzBuzzValue> {
        return fizzBuzzService.getBuzzValues()
    }

    @GetMapping(value = ["/fizz-buzz"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fizzBuzz() : List<FizzBuzzValue> {
        return fizzBuzzService.getFizzBuzzValues()
    }
}