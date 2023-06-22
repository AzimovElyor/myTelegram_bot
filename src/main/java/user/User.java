package user;


import common.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity<UUID> implements Serializable {
private UserType userType;
private String email;
private String phoneNumber;
private String name;
private String username;
private String surname;
private String chatId;
private SendLocation location;
private UserState userState;
private LanguageType languageType;


@Builder

    public User(UUID id ,LocalDateTime created, LocalDateTime updated,
                UserType userType, String email, String phoneNumber, String name,
                String username, String surname,String chatId,  SendLocation location,
                UserState userState, LanguageType languageType) {
        super(id ,created, updated);
        this.userType = userType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.username = username;
        this.surname = surname;
        this.chatId = chatId;
        this.location = location;
        this.userState = userState;
        this.languageType = languageType;
    }
}
