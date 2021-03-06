package io.bootique.jackson;


import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertEquals;

public class YearDeserializerIT extends DeserializerIT {

    @Test
    public void testDeserialization01() throws Exception {
        Year value = mapper.readValue("1986", Year.class);
        assertEquals("The value is not correct.", Year.of(1986), value);
    }

    @Test
    public void testDeserialization02() throws Exception {
        Bean1 bean1 = readValue(Bean1.class, mapper, "a: \"x\"\n" +
                "c:\n" +
                "  year: 2017");
        assertEquals("The value is not correct.", Year.of(2017), bean1.c.year);
    }
    @Test
    public void testDeserialization03() throws Exception {
        Bean1 bean1 = readValue(Bean1.class, mapper, "a: \"x\"\n" +
                "c:\n" +
                "  year: " + Year.of(2017).toString());
        assertEquals("The value is not correct.", Year.of(2017), bean1.c.year);
    }
}
