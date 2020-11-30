//вывести уникальный список всех друзей и друзей друзей до N уровня
package com.noirix.util;

import java.util.*;
import java.util.stream.Collectors;

public class UserFriend {


    private Long id;

    private String name;

    private String surname;

    private List<UserFriend> friends;


    public UserFriend() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<UserFriend> getFriends() {
        return friends;
    }

    public void setFriends(List<UserFriend> friends) {
        this.friends = friends;
    }

    public static class MainMethod {


        public static void main(String[] args) {
            getAllFriends(new UserFriend().getFriends(),5);

        }

        public static Set<UserFriend> getAllFriends(List<UserFriend> friends,
                                                     int index) {
            List<UserFriend> allFriends = new ArrayList<>();
            if (index == 0) {
                return Set.copyOf(allFriends);
            } else {
                for (int i = 0; i < friends.size(); i++) {
                    UserFriend userFriend = friends.get(i);
                    List<UserFriend> moreFriends =
                            new ArrayList<>();
                    for (UserFriend sub : allFriends
                    ) {
                        moreFriends.add(sub);
                        moreFriends.addAll(userFriend.getFriends());
                    }
                    allFriends.addAll(moreFriends);
                }
                getAllFriends(allFriends, index - 1);
            }
            return Set.copyOf(allFriends);


        }
    }
}
