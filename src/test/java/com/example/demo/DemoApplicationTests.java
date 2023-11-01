package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DemoApplicationTests {
	Calculator underTest=new Calculator();

	@Test
	void itShouldAddTwoNumbers() {
		//when
		int numberOne=10;
		int numberTwo=20;
		int result=underTest.Add(numberOne,numberTwo);
		// then
		int expected=30;
		assertThat(result).isEqualTo(expected);

	}
	class Calculator{
		int Add(int a,int b) {
			return a+b;
		}
	}

}
