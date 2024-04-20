package test;

import dynamic.FemaleDynamic;
import dynamic.MaleDynamic;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicTest {

    @Test
    void should_change_from_Male_to_Female(){
        //given
        MaleDynamic male = new MaleDynamic("John", "Doe", LocalDate.of(1990, 7, 21), true);

        //when
        FemaleDynamic female = new FemaleDynamic(male, "Smith", false);

        //then
        assertEquals(MaleDynamic.getExtent().size(), 0);
        assertEquals(FemaleDynamic.getExtent().size(), 1);
    }

    @Test
    void should_change_from_Female_to_Male(){
        //given
        FemaleDynamic female = new FemaleDynamic("John", "Doe", LocalDate.of(1990, 7, 21), "Smith", false);

        //when
        MaleDynamic male = new MaleDynamic(female, true);

        //then
        assertEquals(FemaleDynamic.getExtent().size(), 0);
        assertEquals(MaleDynamic.getExtent().size(), 1);
    }

}