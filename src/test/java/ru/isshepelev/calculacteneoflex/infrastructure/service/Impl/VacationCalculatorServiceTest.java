package ru.isshepelev.calculacteneoflex.infrastructure.service.Impl;

import org.junit.jupiter.api.Test;
import ru.isshepelev.calculacteneoflex.infrastructure.service.VacationCalculatorService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VacationCalculatorServiceTest {

    private final VacationCalculatorService service = new VacationCalculatorServiceImpl();

    @Test
    public void testCalculateVacationPay() {
        BigDecimal averageSalary = new BigDecimal("30000");
        int vacationDays = 10;
        BigDecimal result = service.calculateVacationPay(averageSalary, vacationDays);
        assertEquals(new BigDecimal("10000.00"), result);
    }

    @Test
    public void testCalculateVacationPayWithHolidays() {
        BigDecimal averageSalary = new BigDecimal("30000");
        int vacationDays = 10;
        LocalDate startDate = LocalDate.of(2025, 5, 1);
        LocalDate endDate = LocalDate.of(2025, 5, 10);
        BigDecimal result = service.calculateVacationPayWithHolidays(averageSalary, vacationDays, startDate, endDate);
        assertEquals(new BigDecimal("7000.00"), result);
    }
}