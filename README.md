## Требования

Для запуска проекта необходимо иметь установленный [Docker](https://www.docker.com/).

## Запуск проекта

1. Клонируйте репозиторий:
  git clone [https://github.com/isshepelev/Note.git](https://github.com/isshepelev/calculacte-neoflex.git)

2. Перейдите в папку проекта
   
3. Запустите проект с помощью Docker:
   docker-compose up --build
   
4. После запуска сервис будет доступен по адресу: http://localhost:8080

## Примеры запросов
Без учёта праздников и выходных:
http://localhost:8080/calculate?averageSalary=30000&vacationDays=10

С учётом праздничных и выходных дней:
http://localhost:8080/calculate?averageSalary=30000&vacationDays=10&startDate=2025-05-01&endDate=2025-05-10
