package ru.forgethedragon.ftdadditions.client.font;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

public class TextFormattingEffect {

    public static String stringToGolden(String parString, int parShineLocation, boolean parReturnToBlack, EnumChatFormatting color)
    {
        int stringLength = parString.length();
        if (stringLength < 1)
        {
            return "";
        }
        String outputString = "";
        for (int i = 0; i < stringLength; i++)
        {
            if ((i+parShineLocation+ Minecraft.getSystemTime()/20)%88==0)
            {
                outputString = outputString + color.WHITE+parString.substring(i, i+1);
            }
            else if ((i+parShineLocation+Minecraft.getSystemTime()/20)%88==1)
            {
                outputString = outputString + color.YELLOW+parString.substring(i, i+1);
            }
            else if ((i+parShineLocation+Minecraft.getSystemTime()/20)%88==87)
            {
                outputString = outputString + color.YELLOW+parString.substring(i, i+1);
            }
            else
            {
                outputString = outputString + color.GOLD+parString.substring(i, i+1);
            }
        }
        // return color to a common one after (most chat is white, but for other GUI might want black)
        if (parReturnToBlack)
        {
            return outputString + color.BLACK;
        }
        return outputString + color.WHITE;
    }
}
