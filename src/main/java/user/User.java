package user;


import common.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity<String> implements Serializable {
private UserType userType;
private String email;
private String phoneNumber;
private String name;
private String username;
private String surname;

private SendLocation location;
private UserState userState;
private LanguageType languageType;


@Builder

    public User(String chatID, LocalDateTime created, LocalDateTime updated,
                UserType userType, String email, String phoneNumber, String name,
                String username, String surname,  SendLocation location,
                UserState userState, LanguageType languageType) {
        super(chatID, created, updated);
        this.userType = userType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.username = username;
        this.surname = surname;
        this.location = location;
        this.userState = userState;
        this.languageType = languageType;
    }
}
