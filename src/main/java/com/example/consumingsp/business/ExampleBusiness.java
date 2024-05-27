package com.example.consumingsp.business;

import com.example.consumingsp.dto.ExampleRecord;
import com.example.consumingsp.repository.ExampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleBusiness {

    private final ExampleRepository exampleRepository;

    public ExampleBusiness(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public List<ExampleRecord> getProducts() {
        return exampleRepository.callStoredProcedure();
    }
}
