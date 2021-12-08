package hu.testathlon.model.service;

import hu.testathlon.model.domain.TestResult;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    public String getAnswers(List<String> lines) {
        return lines.get(0);
    }

    public List<TestResult> getTestResults(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::createTestResult)
                .collect(Collectors.toList());
    }

    private TestResult createTestResult(String line) {
        String[] items = line.split(" ");
        String id = items[0];
        String answers = items[1];
        return new TestResult(id, answers);
    }
}
