package com.x.storm.sequence.factory;

import com.x.storm.sequence.client.ISeqClient;
import com.x.storm.sequence.client.impl.SeqClientImpl;

public final class SeqClientFactory {

    private SeqClientFactory() {

    }

    private static ISeqClient sequenceClient;

    public static ISeqClient getSeqClient() {
        if (sequenceClient == null) {
                sequenceClient = new SeqClientImpl();
        }
        return sequenceClient;
    }
}
