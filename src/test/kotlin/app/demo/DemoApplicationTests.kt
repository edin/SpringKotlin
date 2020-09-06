package app.demo

import app.demo.domain.BuzzRule
import app.demo.domain.FizzBuzzRule
import app.demo.domain.FizzRule
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.ThreadLocalRandom

@SpringBootTest
class DemoApplicationTests
{
	fun randomValue(): Int {
		return ThreadLocalRandom.current().nextInt(100)
	}

	@Test
	fun fizzRule() {
		val result = FizzRule().process(randomValue())
		Assertions.assertThat(result).isEqualTo("Fizz")
	}

	@Test
	fun buzzRule() {
		val result = BuzzRule().process(randomValue())
		Assertions.assertThat(result).isEqualTo("Buzz")
	}

	@Test
	fun fizzMatchesRule() {
		val rule = FizzRule()
		val value = randomValue() * 3

		Assertions.assertThat(rule.matches(value)).isEqualTo(true)
		Assertions.assertThat(rule.matches(value+1)).isEqualTo(false)
		Assertions.assertThat(rule.matches(value+2)).isEqualTo(false)
	}
}
