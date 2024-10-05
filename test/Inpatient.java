package com.test;


import com.algonquin.cst8288.fall24.assignment1.patient.Inpatient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InpatientTest {

    private Inpatient inpatient;

    @BeforeEach
    void setUp() {
        inpatient = new Inpatient("001", "John Doe", "john@example.com", "123-456-7890", "1990-01-01", "Room101");
    }

    @Test
    void testAdmit() {
        assertDoesNotThrow(() -> inpatient.admit());
    }

    @Test
    void testGetRoomNumber() {
        assertEquals("Room101", inpatient.getRoomNumber());
    }
}
