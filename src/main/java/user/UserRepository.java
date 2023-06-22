package user;

import common.BaseRepository;
import lombok.NoArgsConstructor;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class UserRepository extends BaseRepository<String,User> {
    private final String PATH_OF_USER = "src/main/java/user/User.txt";
    private static UserRepository userRepository = null;
    @Override
    protected String getFilePath() {
        return PATH_OF_USER;
    }
    public Optional<User> findByChatID(String chatID){
        List<User> users = getAll();
        for (User user : users) {
            if(user.getId().equals(chatID)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
    public static UserRepository getInstance() {
        if(userRepository == null){
            return new UserRepository();
        }
        return userRepository;
    }
}
