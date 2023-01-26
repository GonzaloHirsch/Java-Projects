package interviewProblems.Design_Twitter;


import java.util.*;

class Solution {
    class Twitter {
        private Map<Integer, Set<Integer>> relations;
        private Map<Integer, TweetNode> tweets;
        private int time = 0;

        public Twitter() {
            this.relations = new HashMap<>();
            this.tweets = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            TweetNode lastTweet = this.tweets.get(userId);
            TweetNode tweet = new TweetNode(tweetId, this.time++);
            if (lastTweet != null) tweet.next = lastTweet;
            lastTweet = tweet;
            this.tweets.put(userId, lastTweet);
        }

        public List<Integer> getNewsFeed(int userId) {
            // We'll merge k-sorted lists
            PriorityQueue<TweetNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
            // Add own tweets
            if (this.tweets.containsKey(userId)) pq.add(this.tweets.get(userId));
            // Add other's tweets
            for (Integer user : this.relations.getOrDefault(userId, Collections.emptySet()))
                if (this.tweets.containsKey(user)) pq.add(this.tweets.get(user));

            List<Integer> result = new ArrayList<>();
            TweetNode tweet;
            while (!pq.isEmpty() && result.size() < 10) {
                tweet = pq.poll();
                result.add(tweet.id);
                if (tweet.next != null) pq.add(tweet.next);
            }

            return result;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> followed = this.relations.getOrDefault(followerId, new HashSet<>());
            followed.add(followeeId);
            this.relations.put(followerId, followed);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followed = this.relations.getOrDefault(followerId, new HashSet<>());
            followed.remove(followeeId);
            this.relations.put(followerId, followed);
        }

        private class TweetNode {
            public int id;
            public int time;
            public TweetNode next;
            public TweetNode (int id, int time) {
                this.id = id;
                this.time = time;
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}