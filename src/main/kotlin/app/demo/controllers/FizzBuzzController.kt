import app.demo.services.*
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FizzBuzzController
{
    @GetMapping(value = ["/fizz"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fizz() : List<FizzBuzzValue> {
        val chain = FizzBuzzChain();
        chain.addRule(FizzRule())
        return (1..100).map { it -> chain.process(it) }.toList()
    }

    @GetMapping(value = ["/buzz"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun buzz() : List<FizzBuzzValue> {
        val chain = FizzBuzzChain();
        chain.addRule(BuzzRule())
        return (1..100).map { it -> chain.process(it) }.toList()
    }

    @GetMapping(value = ["/fizz-buzz"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fizzBuzz() : List<FizzBuzzValue> {
        val chain = FizzBuzzChain( );
        chain.addRule(FizzBuzzRule())
        chain.addRule(FizzRule())
        chain.addRule(BuzzRule())
        return (1..100).map { it -> chain.process(it) }.toList()
    }
}