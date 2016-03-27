package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Simple class that provides jokes
 */
public class Joker implements JokeProvider {

    /**
     * Return random joke from jokes base
     * @return Joke
     */
    @Override
    public synchronized String getJoke()  {
        final int jokesCount = jokes.size();

        final Random randomGenerator = new Random();
        final int jokeNumber = randomGenerator.nextInt(jokesCount);

        return jokes.get(jokeNumber);
    }


    private static final List<String> jokes = new ArrayList<>();
    static {
        jokes.add("Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all");
        jokes.add("It is so cold outside I saw a politician with his hands in his own pockets.");
        jokes.add("My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.");
        jokes.add("I wanted to grow my own food but I couldn’t get bacon seeds anywhere");
        jokes.add("I'd like to buy a new boomerang please. Also, can you tell me how to throw the old one away?");
        jokes.add("You can train a cat to do anything the cat wants to do at the moment it wants to do it");
    }
}
