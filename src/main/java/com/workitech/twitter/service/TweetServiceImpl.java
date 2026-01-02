package com.workitech.twitter.service;

import com.workitech.twitter.dto.request.TweetCreateRequestDto;
import com.workitech.twitter.dto.response.TweetResponseDto;
import com.workitech.twitter.entity.Tweet;
import com.workitech.twitter.entity.User;
import com.workitech.twitter.exceptions.TweetNotFoundException;
import com.workitech.twitter.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    private final TweetRepository tweetRepository;
    @Autowired
    private final UserService userService;

    public TweetServiceImpl(TweetRepository tweetRepository, UserService userService) {
        this.tweetRepository = tweetRepository;
        this.userService = userService;
    }

    @Override
    public TweetResponseDto create(TweetCreateRequestDto tweetCreateRequestDto, String email) {

        User user = userService.getByEmail(email);

        Tweet tweet = new Tweet();

        tweet.setText(tweetCreateRequestDto.text());
        tweet.setUser(user);

        Tweet saved = tweetRepository.save(tweet);

        return new TweetResponseDto(saved.getId(), saved.getText(), user.getId());
    }

    @Override
    public List<TweetResponseDto> findByUserId(Long userId) {

        List<Tweet> tweets = tweetRepository.findByUserId(userId);

        return tweets.stream().map(tweet -> new TweetResponseDto(tweet.getId(), tweet.getText(), tweet.getUser().getId())).toList();
    }

    @Override
    public TweetResponseDto findById(Long id) {
        Tweet tweet = tweetRepository.findById(id).orElseThrow(() -> new TweetNotFoundException("Tweet not found: " + id));

        return new TweetResponseDto(tweet.getId(), tweet.getText(), tweet.getUser().getId());
    }

    @Override
    public TweetResponseDto update(String text, Long id) {
        Tweet tweet = tweetRepository.findById(id)
                .orElseThrow(() -> new TweetNotFoundException("Tweet not found: " + id));

        tweet.setText(text);

        Tweet saved = tweetRepository.save(tweet);

        return new TweetResponseDto(saved.getId(), saved.getText(), saved.getUser().getId());
    }

    @Override
    public void deleteById(Long id) {
        Tweet tweet = tweetRepository.findById(id).orElseThrow(() -> new TweetNotFoundException("Tweet not found: " + id));

        tweetRepository.delete(tweet);
    }
}
