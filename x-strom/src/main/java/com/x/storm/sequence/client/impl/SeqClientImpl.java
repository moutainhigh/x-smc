package com.x.storm.sequence.client.impl;

import com.x.storm.sequence.client.ISeqClient;
import com.x.storm.sequence.service.ISequenceService;
import com.x.storm.sequence.service.impl.SequenceServiceImpl;

public class SeqClientImpl implements ISeqClient {

    private ISequenceService sequenceService;

    public SeqClientImpl() {
        this.sequenceService = new SequenceServiceImpl();
    }

    @Override
    public Long nextValue(String sequenceName) {
        return sequenceService.nextValue(sequenceName);
    }

}
