package app.demo.services

import app.demo.domain.*
import org.springframework.stereotype.Component

@Component
class FizzBuzzService
{
    fun getFizzValues(): List<FizzBuzzValue> {
        return FizzBuzzChain(FizzRule()).getValues(100)
    }

    fun getBuzzValues(): List<FizzBuzzValue> {
        return FizzBuzzChain(BuzzRule()).getValues(100)
    }

    fun getFizzBuzzValues(): List<FizzBuzzValue> {
        return FizzBuzzChain(FizzBuzzRule(), FizzRule(), BuzzRule()).getValues(100);
    }

    fun getFizzBuzzValue(value: Int): FizzBuzzValue {
        return FizzBuzzChain(FizzBuzzRule(), FizzRule(), BuzzRule()).process(value)
    }
}
