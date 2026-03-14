public class Feedback{
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    private String feedbackUsingConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5){
        String concatenatedFeedback = sent1 + sent2 + sent3 + sent4 + sent5;
        return concatenatedFeedback;
    }
    private String feedbackUsingStringBuilder(String sent1, String sent2, String sent3, String sent4, String sent5){
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(sent2).append(sent3).append(sent4).append(sent5);
        return sb.toString();
    }
    private boolean checkFeedbackLength(String feedback){
        return feedback.length() > 500;
    }
    private void createReviewID(String firstName, String lastName, String completefeedback){
        String userName = firstName + lastName;
        reviewID = (userName.substring(2,6).toUpperCase() + completefeedback.substring(10,15).toLowerCase() + String.valueOf(completefeedback.length()) + "_" + String.valueOf(System.currentTimeMillis())).replace(" ", "");
    }
    @Override
    public String toString() {
        return "Feedback: " + '\n' +
                "firstName = " + firstName + '\n' +
                "lastName = " + lastName + '\n' +
                "email = " + email + '\n' +
                "completeFeedback = " + completeFeedback + '\n' +
                "reviewID = " + reviewID + '\n' +
                "longFeedback = " + longFeedback;
    }
    public void analysizeFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5){
        if (isConcatenation){
            completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
            longFeedback=checkFeedbackLength(completeFeedback);
            createReviewID(firstName, lastName, completeFeedback);
        }
        else {
            completeFeedback = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5);
            longFeedback=checkFeedbackLength(completeFeedback);
            createReviewID(firstName, lastName, completeFeedback);
        }
    }
    public Feedback(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}