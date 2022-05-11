import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;

class TestDemoTest {
	TestDemo testDemo = new TestDemo();
	TestDemo mockDemo = spy(testDemo);

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
		mockDemo = spy(testDemo);
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

		}

	}

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(4, 4, 8, false), 
				arguments(90, 7, 97, false), 
				arguments(0, 0, 0, true),
				arguments(-2, -10, -12, true), 
				arguments(-7, 8, 1, true), 
				arguments(7, 7, 14, false));

	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}
