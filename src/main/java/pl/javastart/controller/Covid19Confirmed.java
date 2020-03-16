package pl.javastart.controller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;


@Service
public class Covid19Confirmed {
    public static final String COVID_CONFIRMED = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";

    private DataRepo dataRepo;

    public Covid19Confirmed(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() throws IOException, InterruptedException {

        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(COVID_CONFIRMED, String.class);

        StringReader stringReader = new StringReader(forObject);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

        for (CSVRecord strings : parser) {
            double lat = Double.parseDouble(strings.get("Lat"));
            double lon = Double.parseDouble(strings.get("Long"));
//            String text = strings.get("3/15/20");
            String text = strings.get(strings.size() - 1);

            dataRepo.addPoint(new Point(lat, lon, text));
        }


    }
}

