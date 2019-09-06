package me.kosgei.BitcoinSms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BitcoinSmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitcoinSmsApplication.class, args);
	}

}
