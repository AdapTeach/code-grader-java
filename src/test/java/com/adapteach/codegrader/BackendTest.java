package com.adapteach.codegrader;

import com.adapteach.codegrader.model.Assessments;
import com.adapteach.codegrader.model.SubmissionJson;
import com.adapteach.codegrader.model.SubmissionResultJson;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

public class BackendTest {

    Backend backend = new Backend();

    @Test
    public void shouldPassForCorrectHelloWorldSubmission() throws IOException {
        SubmissionJson submission = new SubmissionJson();
        submission.assessment = Assessments.HELLO_WORLD;

        submission.code
                = "public class " + submission.assessment.className + " {" +
                "" +
                "   public String helloWorld() {" +
                "       return \"Hello, World !\";" +
                "   }" +
                "" +
                "}";

        SubmissionResultJson result = backend.submit(submission);

        assertThat(result.pass).isTrue();
    }


    @Test
    public void shouldFailForIncorrectHelloWorldSubmission() throws IOException {
        SubmissionJson submission = new SubmissionJson();
        submission.assessment = Assessments.HELLO_WORLD;

        submission.code
                = "public class " + submission.assessment.className + " {" +
                "" +
                "   public String helloWorld() {" +
                "       return \"Unexpected output\";" +
                "   }" +
                "" +
                "}";

        SubmissionResultJson result = backend.submit(submission);

        assertThat(result.pass).isFalse();
    }

    //    @Test
    public void meaningOfLife() throws IOException {
        SubmissionJson submission = new SubmissionJson();

        submission.code = "public class Program {" +
                "" +
                "   public String execute() {" +
                "       return \"42\";" +
                "   }" +
                "" +
                "}";

        SubmissionResultJson result = backend.submit(submission);

        assertThat(result.out).isEqualTo("42");
    }

}
