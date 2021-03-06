package com.adapteach.codeassesser.model;

import com.google.api.client.util.Key;
import lombok.ToString;

import java.util.List;

@ToString
public class SubmissionResultJson {

    @Key
    public boolean pass;

    @Key
    public List<String> compilationErrors;

    @Key
    public String exceptionMessage;

    @Key
    public List<String> failedTestMessages;

}
