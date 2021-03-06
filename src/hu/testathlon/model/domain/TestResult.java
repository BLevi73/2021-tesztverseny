package hu.testathlon.model.domain;

public class TestResult {

    private final String id;
    private final String answers;

    public TestResult(String id, String answers) {
        this.id = id;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public String getAnswers() {
        return answers;
    }
}
