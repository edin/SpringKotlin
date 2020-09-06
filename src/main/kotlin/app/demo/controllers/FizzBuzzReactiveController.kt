package app.demo.controllers

import app.demo.domain.FizzBuzzValue
import app.demo.services.FizzBuzzService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.concurrent.ThreadLocalRandom

@RestController
class FizzBuzzReactive(val fizzBuzzService: FizzBuzzService)
{
    @GetMapping(value = ["/fizz-buzz/stream"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun prices(): Flux<FizzBuzzValue> {
        return Flux
            .interval(Duration.ofSeconds(1))
            .map {
                fizzBuzzService.getFizzBuzzValue(randomFizzBuzzValue())
            }
    }

    private fun randomFizzBuzzValue(): Int {
        return ThreadLocalRandom.current().nextInt(100)
    }
}