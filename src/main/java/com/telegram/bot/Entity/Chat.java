package com.telegram.bot.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @OneToOne
    public User user;

    @Column(columnDefinition = "TIMESTAMP")
    public LocalDateTime  createdAt;
}
