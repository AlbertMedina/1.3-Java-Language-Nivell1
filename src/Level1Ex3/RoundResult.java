package Level1Ex3;

public class RoundResult {

    private final Question question;
    private final String response;
    private final boolean isCorrect;

    public RoundResult(Question question, String response) {
        this.question = question;
        this.response = response;
        isCorrect = question.getCapital().equalsIgnoreCase(response);
    }

    public Question getQuestion() {
        return question;
    }

    public String getResponse() {
        return response;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
