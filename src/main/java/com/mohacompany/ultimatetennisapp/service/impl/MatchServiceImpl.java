package com.mohacompany.ultimatetennisapp.service.impl;

import com.mohacompany.ultimatetennisapp.domain.Match;
import com.mohacompany.ultimatetennisapp.repository.MatchRepository;
import com.mohacompany.ultimatetennisapp.service.MatchService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Match}.
 */
@Service
@Transactional
public class MatchServiceImpl implements MatchService {

    private final Logger log = LoggerFactory.getLogger(MatchServiceImpl.class);

    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match save(Match match) {
        log.debug("Request to save Match : {}", match);
        return matchRepository.save(match);
    }

    @Override
    public Match update(Match match) {
        log.debug("Request to save Match : {}", match);
        return matchRepository.save(match);
    }

    @Override
    public Optional<Match> partialUpdate(Match match) {
        log.debug("Request to partially update Match : {}", match);

        return matchRepository
            .findById(match.getId())
            .map(existingMatch -> {
                if (match.getPlayerOneName() != null) {
                    existingMatch.setPlayerOneName(match.getPlayerOneName());
                }
                if (match.getPlayerOneScore() != null) {
                    existingMatch.setPlayerOneScore(match.getPlayerOneScore());
                }
                if (match.getPlayerOneOdd() != null) {
                    existingMatch.setPlayerOneOdd(match.getPlayerOneOdd());
                }
                if (match.getPlayerTwoName() != null) {
                    existingMatch.setPlayerTwoName(match.getPlayerTwoName());
                }
                if (match.getPlayerTwoScore() != null) {
                    existingMatch.setPlayerTwoScore(match.getPlayerTwoScore());
                }
                if (match.getPlayerTwoOdd() != null) {
                    existingMatch.setPlayerTwoOdd(match.getPlayerTwoOdd());
                }
                if (match.getPrediction() != null) {
                    existingMatch.setPrediction(match.getPrediction());
                }
                if (match.getActualResult() != null) {
                    existingMatch.setActualResult(match.getActualResult());
                }
                if (match.getBetAmount() != null) {
                    existingMatch.setBetAmount(match.getBetAmount());
                }
                if (match.getPotentialGain() != null) {
                    existingMatch.setPotentialGain(match.getPotentialGain());
                }
                if (match.getGain() != null) {
                    existingMatch.setGain(match.getGain());
                }

                return existingMatch;
            })
            .map(matchRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Match> findAll(Pageable pageable) {
        log.debug("Request to get all Matches");
        return matchRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Match> findOne(Long id) {
        log.debug("Request to get Match : {}", id);
        return matchRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Match : {}", id);
        matchRepository.deleteById(id);
    }
}
