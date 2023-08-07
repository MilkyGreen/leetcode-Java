package p300plus.p355;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Twitter {

    Map<Integer,Set<Integer>> followingMap = new HashMap<>();
    Map<Integer,Set<Integer>> followerMap = new HashMap<>();

    Map<Integer,LinkedList<int[]>> feeds = new HashMap<>();
    int counter = 0;
    Map<Integer,LinkedList<int[]>> userPosts = new HashMap<>();


    public Twitter() {

    }
    
    public void postTweet(int userId, int tweetId) {
        int[] post = new int[]{userId,tweetId,counter++};

        LinkedList<int[]> posts = userPosts.getOrDefault(userId,new LinkedList());
        posts.addFirst(post);
        userPosts.put(userId,posts);

        Set<Integer> followers  = followerMap.getOrDefault(userId,new HashSet());
        followers.add(userId);
        followerMap.put(userId,followers);

        for(Integer f : followers){
            LinkedList<int[]> feed = feeds.getOrDefault(f,new LinkedList());
            feed.addFirst(post);
            feeds.put(f,feed);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {

        LinkedList<int[]> feed = feeds.getOrDefault(userId,new LinkedList());
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < 10 && i < feed.size();i++){
            res.add(feed.get(i)[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {

        Set<Integer> followings = followingMap.getOrDefault(followerId,new HashSet());

        if(followings.contains(followeeId)){
            return;
        }

        LinkedList<int[]> posts = userPosts.get(followeeId);
        if(posts != null && posts.size() > 0){
            LinkedList<int[]> feed = feeds.getOrDefault(followerId,new LinkedList());

            LinkedList<int[]> newFeed = merge(posts,feed);

            feeds.put(followerId,newFeed);
        }

        // Map<Integer,Set<Integer>> followingMap = new HashMap<>();
        
        followings.add(followeeId);
        followingMap.put(followerId,followings);

        // Map<Integer,Set<Integer>> followerMap = new HashMap<>();
        Set<Integer> followers = followerMap.getOrDefault(followeeId,new HashSet());
        followers.add(followerId);
        followerMap.put(followeeId,followers);

    }

    private LinkedList<int[]> merge(LinkedList<int[]> a, LinkedList<int[]> b){
        int lena = a.size();
        int lenb = b.size();
        int i=0,j = 0;
        LinkedList<int[]> res = new LinkedList<>();
        while(i < lena && j < lenb){
            int[] aPost = a.get(i);
            int[] bPost = b.get(j);
            if(aPost[2] > bPost[2]){
                res.addLast(aPost);
                i++;
            }else{
                res.addLast(bPost);
                j++;
            }
        }
        while(i < lena){
            int[] aPost = a.get(i);
            res.addLast(aPost);
            i++;
        }
        while(j < lenb){
            int[] bPost = b.get(j);
            res.addLast(bPost);
            j++;
        }
        return res;
    }
    
    public void unfollow(int followerId, int followeeId) {

        // ap<Integer,Set<Integer>> followingMap = new HashMap<>();
        // Map<Integer,Set<Integer>> followerMap = new HashMap<>();

        // Map<Integer,LinkedList<int[]>> feeds = new HashMap<>();
        // int counter = 0;
        // Map<Integer,LinkedList<int[]>> userPosts = new HashMap<>();

        Set<Integer> followings = followingMap.getOrDefault(followerId,new HashSet());
        followings.remove(followeeId);

        // Map<Integer,Set<Integer>> followerMap = new HashMap<>();
        Set<Integer> followers = followerMap.getOrDefault(followeeId,new HashSet());
        followers.remove(followerId);

        LinkedList<int[]> posts = userPosts.get(followeeId);
        if(posts != null && posts.size() > 0){
            LinkedList<int[]> feed = feeds.get(followerId);

            LinkedList<int[]> newFeed = new LinkedList<>();
            for(int[] t : feed){
                if(t[0] != followeeId){
                    newFeed.addLast(t);
                }
            }
            feeds.put(followerId,newFeed);
        }
    }
}
