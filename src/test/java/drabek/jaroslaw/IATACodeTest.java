package drabek.jaroslaw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.testng.Assert.*;

@RunWith(SpringRunner.class)
public class IATACodeTest {

    @Test(expected = IllegalArgumentException.class)
    public void test_too_long_code(){
        //when
        IATACode.of("KRAKOWAIRPORT");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_too_short_code(){
        //when
        IATACode.of("KR");
    }

    @Test
    public void test_3_letters_code(){
        //when
        IATACode.of("KRK");
    }

}