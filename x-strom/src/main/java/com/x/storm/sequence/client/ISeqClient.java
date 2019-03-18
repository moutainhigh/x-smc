package com.x.storm.sequence.client;

public interface ISeqClient {

    Long nextValue(String sequenceName);

}
