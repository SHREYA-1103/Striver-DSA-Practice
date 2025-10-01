import java.util.*;

public class DesignTwitter {

    public static class Twitter{
        HashMap<Integer, Set<Integer>> friendsOfUser;
        PriorityQueue<List<Integer>> timeline;
        int curr;

        public Twitter(){
            this.friendsOfUser = new HashMap<>();
            this.timeline = new PriorityQueue<>((a, b) -> b.get(0) - a.get(0));
            this.curr = 0;
        }

        public void postTweet(int userId, int tweetId){
            timeline.add(Arrays.asList(curr++, tweetId, userId));
            Set<Integer> set = new HashSet<>();
            if(friendsOfUser.containsKey(userId)){
                set = friendsOfUser.get(userId);
            }
            if(!set.contains(userId)){
                set.add(userId);
                friendsOfUser.put(userId, set);
            }
        }

        public List<Integer> getNewsFeed(int userId){
            List<Integer> res = new ArrayList<>();
            if(!friendsOfUser.containsKey(userId)){
                return res;
            }
            PriorityQueue<List<Integer>> userTimeline = new PriorityQueue<>(timeline);

            int n = 0;

            while(!userTimeline.isEmpty() && n < 10){
                List<Integer> topTweet = userTimeline.remove();

                int tweetUserId = topTweet.get(2);

                if(friendsOfUser.get(userId).contains(tweetUserId)){
                    res.add(topTweet.get(1));
                    n++;
                }
            }

            return res;
        }

        public void follow(int followerId, int followeeId){
            Set<Integer> set = new HashSet<>();
            if(friendsOfUser.containsKey(followerId)){
                set = friendsOfUser.get(followerId);
            }
            if(!set.contains(followeeId)){
                set.add(followeeId);
                friendsOfUser.put(followerId, set);
            }

            friendsOfUser.get(followerId).add(followerId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followersExist(followerId) && followerId != followeeId) {
                friendsOfUser.get(followerId).remove(followeeId);
            }
        }

        public boolean followersExist(int followerId) {
            return friendsOfUser.containsKey(followerId);
        }
    }

    public static void main(String args[]){
        Twitter tw = new Twitter();

        tw.postTweet(1,2);
        tw.postTweet(2,6);
        System.out.println(tw.getNewsFeed(1));
        tw.follow(1,2);
        System.out.println(tw.getNewsFeed(1));
        tw.unfollow(1,2);
        tw.postTweet(1,7);
        System.out.println(tw.getNewsFeed(1));
    }
}
