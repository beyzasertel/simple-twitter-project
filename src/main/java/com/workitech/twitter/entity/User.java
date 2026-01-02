package com.workitech.twitter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user", schema = "twitter_application")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 150)
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name= "username")
    @ToString.Exclude
    private String username;


    @Size(max = 150)
    @Email
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name= "email")
    @ToString.Exclude
    private String email;

    @Size(max = 150)
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name= "password")
    @ToString.Exclude
    private String password;

    @Size(max = 150)
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name= "name")
    private String name;

    @Size(max = 150)
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name= "surname")
    private String surname;


    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Tweet> tweets = new ArrayList<>();

    public void postTweet(Tweet tweet){

        if(tweet != null){
            tweets.add(tweet);
        }
    }

    public void deleteTweet(Tweet tweet){

        if(tweet != null){
            tweets.remove(tweet);
        }
    }
}
