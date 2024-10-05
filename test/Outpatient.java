package com.test;


import com.algonquin.cst8288.fall24.assignment1.patient.Outpatient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutpatientTest {

    private Outpatient outpatient;

    @BeforeEach
    void setUp() {
        outpatient = new Outpatient("002", "Jane Smith", "jane@example.com", "123-456-7890", "1985-05-05", "2023-12-01");
    }

    @Test
    void testAdmit_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> outpatient.admit());
    }

    @Test
    void testGetAppointmentDate() {
        assertEquals("2023-12-01", outpatient.getAppointmentDate());
    }
}
