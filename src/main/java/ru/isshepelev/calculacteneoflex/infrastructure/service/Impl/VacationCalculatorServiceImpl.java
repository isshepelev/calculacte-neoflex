package ru.isshepelev.calculacteneoflex.infrastructure.service.Impl;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import ru.isshepelev.calculacteneoflex.infrastructure.service.VacationCalculatorService;

@Service
public class VacationCalculatorServiceImpl implements VacationCalculatorService {
    private static final BigDecimal DAYS_IN_MONTH = BigDecimal.valueOf(30);

    @Override
    public BigDecimal calculateVacationPay(BigDecimal averageSalary, int vacationDays) {
        BigDecimal dailySalary = averageSalary.divide(DAYS_IN_MONTH, 2, RoundingMode.HALF_UP);
        return dailySalary.multiply(BigDecimal.valueOf(vacationDays));
    }

    @Override
    public BigDecimal calculateVacationPayWithHolidays(BigDecimal averageSalary, int vacationDays, LocalDate startDate, LocalDate endDate) {
        long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
        int workingDays = (int) totalDays - countWeekendsAndHolidays(startDate, endDate);
        return calculateVacationPay(averageSalary, workingDays);
    }

    @Override
    public int countWeekendsAndHolidays(LocalDate startDate, LocalDate endDate) {
        int weekends = 0;
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            if (date.getDayOfWeek().getValue() > 5) {
                weekends++;
            }
        }
        return weekends;
    }
}
