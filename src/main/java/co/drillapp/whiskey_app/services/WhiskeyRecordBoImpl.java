package co.drillapp.whiskey_app.services;

import co.drillapp.whiskey_app.dtos.ChartValueDto;
import co.drillapp.whiskey_app.dtos.DashboardDTO;
import co.drillapp.whiskey_app.entities.Persons;
import co.drillapp.whiskey_app.entities.WhiskeyRecord;
import co.drillapp.whiskey_app.repositories.PersonsRepository;
import co.drillapp.whiskey_app.repositories.WhiskeyRecordRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class WhiskeyRecordBoImpl implements WhiskeyRecordBo {

    private WhiskeyRecordRepository whiskeyRecordRepository;

    private PersonsRepository personsRepository;

    public WhiskeyRecordBoImpl(WhiskeyRecordRepository whiskeyRecordRepository, PersonsRepository personsRepository) {
        this.whiskeyRecordRepository = whiskeyRecordRepository;
        this.personsRepository = personsRepository;
    }

    @Override
    public void addWhiskeyRecord() {
        whiskeyRecordRepository.save(new WhiskeyRecord());
    }

    @Override
    public DashboardDTO getDashboardData() {
        List<WhiskeyRecord> records = whiskeyRecordRepository.findAll(Sort.by("record"));
        Map<LocalDateTime, Long> collect = records.stream().collect(Collectors.groupingBy(WhiskeyRecord::getRecord, Collectors.counting()));
        List<ChartValueDto> chartValues = collect.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).map(entry -> new ChartValueDto(parseDateToTime(entry.getKey()), entry.getValue().intValue())).collect(Collectors.toList());

        if (!chartValues.isEmpty()) {
            for (int i = 1; i < chartValues.size(); i++) {
                chartValues.get(i).setQuantity(chartValues.get(i).getQuantity() + chartValues.get(i - 1).getQuantity());
            }
        }

        List<Persons> persons = personsRepository.findAll();
        int avgCupsPerPerson = records.size() / persons.get(persons.size() - 1).getNumber();
        int last10Minutes = whiskeyRecordRepository.findAllByRecordAfter(LocalDateTime.now().minusMinutes(10)).size();
        int numberOfBottles = records.size() / 6;


        return new DashboardDTO(records.size(), chartValues, avgCupsPerPerson, last10Minutes, numberOfBottles);
    }

    @Override
    public void setNumberOfPersons(int number) {
        personsRepository.save(new Persons(number));
    }

    private String parseDateToTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
