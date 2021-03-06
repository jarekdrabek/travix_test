package drabek.jaroslaw.common;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ISO8601UtilsTest {

    @Test
    public void should_serialize_local_date_to_ISO8601_string() {
        //given
        LocalDate toSerialize = LocalDate.of(2017, 3, 3);
        //when
        String serialized = ISO8601Utils.convertLocalDateToISO8601String(toSerialize);
        //then
        assertThat(serialized).isEqualTo("2017-03-03");
    }
}