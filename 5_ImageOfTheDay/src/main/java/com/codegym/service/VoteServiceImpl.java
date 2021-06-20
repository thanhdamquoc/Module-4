package com.codegym.service;

import com.codegym.model.Vote;
import com.codegym.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Override
    public List<Vote> findByDate(String date) {
        return voteRepository.findByDate(date);
    }

    @Override
    public void add(Vote vote) {
        voteRepository.add(vote);
    }

    @Override
    public int[] findTotalByDate(String date) {
        int[] dailyVotes = new int[]{0,0,0,0,0};
        List<Vote> voteList = findByDate(date);
        for (Vote vote : voteList) {
            int star = vote.getStarLevel();
            dailyVotes[star-1]++;
        }
        return dailyVotes;
    }
}