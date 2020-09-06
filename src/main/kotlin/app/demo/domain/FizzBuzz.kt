package app.demo.domain

interface Rule {
    fun matches(n: Int) : Boolean
    fun process(n: Int) : String
}

open class DivisibleRule (private val divisor: Int, private val message: String) : Rule {
    override fun matches(n: Int) = n % divisor == 0
    override fun process(n: Int) = message
}

class FizzRule : DivisibleRule(3, "Fizz");
class BuzzRule : DivisibleRule(5, "Buzz");
class FizzBuzzRule : DivisibleRule(15, "FizzBuzz");

open class FizzBuzzValue private constructor (val id: Int) {
    class Message(id: Int, val message: String) : FizzBuzzValue(id)
    class Number(id: Int) : FizzBuzzValue(id)
}

class FizzBuzzChain
{
    private var rules :MutableList<Rule> = mutableListOf()

    constructor(vararg rules: Rule) {
        for (rule in rules) {
            this.rules.add(rule)
        }
    }

    fun process(n: Int) = when(val rule = rules.firstOrNull { it.matches(n) }) {
        is Rule -> FizzBuzzValue.Message(n, rule.process(n))
        else -> FizzBuzzValue.Number(n)
    }

    fun getValues(n: Int) = (1 .. n).map { it -> this.process(it) }.toList()
}
