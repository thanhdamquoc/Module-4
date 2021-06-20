package com.codegym.service;

import com.codegym.model.Vote;

import java.util.List;
import java.util.Map;

public interface VoteService {
    public List<Vote> findByDate(String date);
    public int[] findTotalByDate(String date);
    void add(Vote vote);
}
