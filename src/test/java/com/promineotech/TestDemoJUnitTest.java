package com.promineotech;



import  static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo= new TestDemo();
	}

@ParameterizedTest
@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	 void assertThatTwoPositiveNumbersAreAddedCorrectly(
			int a, int b, int expected, boolean expectException
			
			) {
	if(!expectException) {
	assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	}
	else {
		 assertThatThrownBy(()-> testDemo.addPositive(
				a,b)).isInstanceOf(IllegalArgumentException.class);
	}
		
	}
static Stream<Arguments> argumentsForAddPositive() {
	return Stream.of(
			arguments(2, 4, 6, false),
			arguments(100,200,300,false),
			arguments(1,98,99, false),
			arguments(0,0,0,true));
	

}
@Test
void assertThatSubstraction() {
	assertThat(testDemo.substractionPositive(14,5)).isEqualTo(9);
	
}


@Test
void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
	assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
	assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
	
	
}
@Test
void assertThatNumberSquaredIsCorrect(){
	TestDemo mockDemo = spy(testDemo);
	doReturn(5).when(mockDemo).getRandomInt();
	int fiveSquared = mockDemo.randomNumberSquared();
	assertThat(fiveSquared).isEqualTo(25);
	
	
}

}
