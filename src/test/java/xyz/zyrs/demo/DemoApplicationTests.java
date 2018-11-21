package xyz.zyrs.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	public 	static void  main(String args[]){
		System.out.println(fact(5));
	}

	/**
	 * 阶乘
	 * @param n
	 * @return
	 */
	public static double fact(int n){
		if(n <= 1){
			return 1;
		}

		return n*fact(n-1);
	}
}
