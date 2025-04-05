package ru.isshepelev.calculacteneoflex.infrastructure.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface VacationCalculatorService {

    BigDecimal calculateVacationPay(BigDecimal averageSalary, int vacationDays);

    BigDecimal calculateVacationPayWithHolidays(BigDecimal averageSalary, int vacationDays, LocalDate startDate, LocalDate endDate);

    int countWeekendsAndHolidays(LocalDate startDate, LocalDate endDate);
}
