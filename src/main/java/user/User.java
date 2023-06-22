package user;


import common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity<String> implements Serializable {
private UserType userType;
private String email;
private String phoneNumber;
private String name;
private String username;
private String surname;
private String chatID;
private SendLocation location;
private UserState userState;
private LanguageType languageType;

}
