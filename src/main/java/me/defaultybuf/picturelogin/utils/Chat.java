package me.defaultybuf.picturelogin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;

public class Chat {
  private static final Pattern RGB_PATTERN = Pattern.compile("&#[a-fA-F0-9]{6}");

  public static String colorClassic(String str) {
    return ChatColor.translateAlternateColorCodes('&', str);
  }

  public static String colorRGB(String str) {
    Matcher matcher = RGB_PATTERN.matcher(str);
    while (matcher.find()) {
      final String color = str.substring(matcher.start() + 1, matcher.end());
      str = str.substring(0, matcher.start()) + ChatColor.of(color) +
          str.substring(matcher.end());
      matcher = RGB_PATTERN.matcher(str);
    }

    return str;
  }

  public static String color(String str) {
    return colorClassic(colorRGB(str));
  }
}
