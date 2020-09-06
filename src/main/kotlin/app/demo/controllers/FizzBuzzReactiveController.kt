package app.demo.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom

data class StockPrice(val symbol: String,
                      val price: Double,
                      val time: LocalDateTime)
@RestController
class FizzBuzzReactive()
{
    @GetMapping(value = ["/fizz-buzz/stream"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun prices(): Flux<StockPrice> {
        return Flux
                .interval(Duration.ofSeconds(1))
                .map { StockPrice("fizz-buzz", randomStockPrice(), LocalDateTime.now()) }
    }

    private fun randomStockPrice(): Double {
        return ThreadLocalRandom.current().nextDouble(100.0)
    }
}