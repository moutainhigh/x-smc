package com.x.storm.sequence.dao;

import java.util.List;

import com.x.storm.sequence.model.Sequence;
import com.x.storm.sequence.model.SequenceCache;

public interface ISequenceDao {

    SequenceCache getSequenceCache(String sequenceName);

    List<Sequence> queryAllSequence();

    Sequence querySequenceByName(String sequenceName);

    void modifySequence(String sequenceName, long nextVal);

}
