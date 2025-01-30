package services;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageService {
    private static Locale currentLocale;
    private static ResourceBundle resourceBundle;

    static {
        setLanguage(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
    }

    public static void setLanguage(String languageCode, String countryCode) {
        currentLocale = Locale.forLanguageTag(languageCode + "-" + countryCode);
        resourceBundle = ResourceBundle.getBundle("resources.Messages", currentLocale);
    }

    public static String getValue(String key) {
        try {
            return resourceBundle.getString(key);
        } catch (Exception e) {
            return "Key '" + key + "' not found in language: " + currentLocale.toLanguageTag();
        }
    }

    public static String getCurrentLanguage() {
        return currentLocale.getLanguage();
    }

    public static String getCurrentCountry() {
        return currentLocale.getCountry();
    }
}