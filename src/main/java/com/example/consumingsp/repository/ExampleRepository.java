package com.example.consumingsp.repository;

import com.example.consumingsp.dto.ExampleRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class ExampleRepository {

    public static final String RESULT = "result";

    private final SimpleJdbcCall simpleJdbcCall;

    public ExampleRepository(DataSource dataSource) {
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("get_users");
    }

    public List<ExampleRecord> callStoredProcedure() {
        Map<String, Object> resultMap = simpleJdbcCall.execute();
        return (List<ExampleRecord>) resultMap.get(RESULT);
    }
}
