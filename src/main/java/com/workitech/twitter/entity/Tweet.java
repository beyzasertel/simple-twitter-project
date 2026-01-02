package com.workitech.twitter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tweet", schema = "twitter_application")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}

