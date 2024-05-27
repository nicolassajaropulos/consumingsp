package com.example.consumingsp.api;

import com.example.consumingsp.business.ExampleBusiness;
import com.example.consumingsp.dto.ExampleRecord;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ExampleController {

    private static final List<ExampleRecord> records = new ArrayList<>();

    private final ExampleBusiness exampleBusiness;

    public ExampleController(ExampleBusiness exampleBusiness) {
        this.exampleBusiness = exampleBusiness;
    }

    @GetMapping("/products")
    public List<ExampleRecord> getProducts() {
        return records;
    }

    @PostMapping("/products")
    public void storeProduct(@RequestHeader Map<String, String> headers, @RequestBody ExampleRecord product) {
        records.add(product);
    }

}
