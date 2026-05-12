class Twitter {

    // We want it to belong to each individual Twitter object
    private int timestamp = 0;

    // For each Twitter instance, we want to track the userId and get the user
    private Map<Integer, User> users = new HashMap<>();

    private static class User {
        int userId;
        List<Tweet> listOfTweets;
        Set<Integer> following;

        User(int userId) {
            this.userId = userId;
            this.listOfTweets = new ArrayList<>();
            this.following = new HashSet<>();
        }
    }

    private static class Tweet {
        int tweetId;
        int userId; 
        int tweetTimestamp;

        Tweet(int tweetId, int userId, int tweetTimestamp) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.tweetTimestamp = tweetTimestamp;
        } 
    }

    public Twitter() {}
    
    public void postTweet(int userId, int tweetId) {
        // Grab the user
        User user = users.computeIfAbsent(userId, k -> new User(userId));

        timestamp++;
        Tweet tweet = new Tweet(tweetId, userId, timestamp);
        user.listOfTweets.add(tweet);
    }

    private static class Wrapper {
        private int index;
        List<Tweet> tweets;

        // We are passing Tweets list, we already sanitize and verified existence of it
        Wrapper(List<Tweet> tweets) {
            this.tweets = tweets;
            this.index = tweets.size() - 1;
        }

        Tweet getLatestTweet() {
            return tweets.get(index);
        }

        boolean hasNextValidIndex() {
            return index > 0;
        }

        void decrement() {
            if (hasNextValidIndex()) index--;
        }
    }

    
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        User user = users.get(userId);
        if (user == null) return result;

        PriorityQueue<Wrapper> latestTweet = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getLatestTweet().tweetTimestamp, 
                                      a.getLatestTweet().tweetTimestamp)
        );

        if (!user.listOfTweets.isEmpty()) {
            latestTweet.add(new Wrapper(user.listOfTweets));
        }

        for (int followeeId : user.following) {
            if (followeeId == userId) continue;

            User followee = users.get(followeeId);
            if (followee == null || followee.listOfTweets.isEmpty()) continue;
            
            latestTweet.add(new Wrapper(followee.listOfTweets));
        }

        while (!latestTweet.isEmpty() && result.size() < 10) {
            Wrapper latestTweetObject = latestTweet.poll();
            result.add(latestTweetObject.getLatestTweet().tweetId);
            
            if (latestTweetObject.hasNextValidIndex()) {
                latestTweetObject.decrement();
                latestTweet.add(latestTweetObject);
            }
        }

        return result;

    }

    
    public void follow(int followerId, int followeeId) {
        User user = users.computeIfAbsent(followerId, k -> new User(followerId));
        user.following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User user = users.get(followerId);

        if (user == null) return;
        
        user.following.remove(followeeId);
        
    }
}
