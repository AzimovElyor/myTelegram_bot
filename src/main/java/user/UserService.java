package user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
   private UserRepository userRepository = UserRepository.getInstance();
   private static  UserService userService = null;

public List<User> getAll(){
   return userRepository.getAll();
}
public User getUser(Update update){
   String chatId = update.getMessage().getChatId().toString();
   Optional<User> optionalUser = userRepository.findByChatID(chatId);

    String firstName = update.getMessage().getChat().getFirstName();
    String lastName = update.getMessage().getChat().getLastName();
    String userName = update.getMessage().getChat().getUserName();

   User user = optionalUser.orElse(User.builder()
           .id(UUID.randomUUID())
           .created(LocalDateTime.now())
           .updated(LocalDateTime.now())
           .username(userName)
           .name(firstName)
           .surname(lastName)
           .userType(UserType.USER)
           .chatId(chatId)
           .userState(UserState.REGISTER)
           .build());
if(optionalUser.isEmpty()){
userRepository.add(user);
}
return user;
}
public User getUser(CallbackQuery callbackQuery){
    String chatID = callbackQuery.getMessage().getChatId().toString();
    Optional<User> optionalUser = userRepository.findByChatID(chatID);

return optionalUser.orElseThrow(() -> new RuntimeException("User not found by chatId " + chatID));
}

public User update(User user){
return userRepository.save(user);

}
   public static UserService getInstance() {
      if(userService == null){
         return new UserService();
      }
      return userService;
   }
}
