package co.drillapp.whiskey_app.controllers;

import co.drillapp.whiskey_app.dtos.DashboardDTO;
import co.drillapp.whiskey_app.services.WhiskeyRecordBo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class MainController {

    private WhiskeyRecordBo whiskeyRecordBo;

    public MainController(WhiskeyRecordBo whiskeyRecordBo) {
        this.whiskeyRecordBo = whiskeyRecordBo;
    }

    @GetMapping("/add")
    public ResponseEntity addRecord() {
        whiskeyRecordBo.addWhiskeyRecord();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/dashboard")
    public ResponseEntity getDashboardData() {
        DashboardDTO dashboardDTO = whiskeyRecordBo.getDashboardData();

        return new ResponseEntity<>(dashboardDTO, HttpStatus.OK);
    }

    @GetMapping("/persons/{number}")
    public ResponseEntity setNumberOfPersons(@PathVariable int number) {
        whiskeyRecordBo.setNumberOfPersons(number);
        return new ResponseEntity(HttpStatus.OK);
    }
}
