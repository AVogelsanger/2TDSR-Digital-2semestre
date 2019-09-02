package br.com.fiap.aula02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
public class Aula02ApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args){
        SpringBootApplication.run(Aula02Application.class, args);
    }

}
