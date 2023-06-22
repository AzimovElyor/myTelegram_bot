package user;

import com.ctc.wstx.shaded.msv_core.verifier.identity.Matcher;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
private static final Pattern pattern = Pattern.compile("\"^\\\\+?998?\\\\s?-?(90|91|93|94|95|98|99|33|97|71)\\\\s?-?(\\\\d{3})\\\\s?-?(\\\\d{2})\\\\s?-?(\\\\d{2})$\"");
public static boolean validateUzbekPhoneNumbers(String phoneNumber){
    return pattern.matcher(phoneNumber).matches();
}
}
