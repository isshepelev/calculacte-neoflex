package ru.isshepelev.calculacteneoflex.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.isshepelev.calculacteneoflex.infrastructure.service.VacationCalculatorService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class VacationCalculatorController {

    private final VacationCalculatorService vacationCalculatorService;

    @Autowired
    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @GetMapping("/calculate")
    public BigDecimal calculateVacationPay(@RequestParam BigDecimal averageSalary,
                                           @RequestParam int vacationDays,
                                           @RequestParam(required = false) String startDate,
                                           @RequestParam(required = false) String endDate) {
        if (startDate != null && endDate != null) {
            return vacationCalculatorService.calculateVacationPayWithHolidays(averageSalary, vacationDays,
                    LocalDate.parse(startDate), LocalDate.parse(endDate));
        }
        return vacationCalculatorService.calculateVacationPay(averageSalary, vacationDays);
    }
}