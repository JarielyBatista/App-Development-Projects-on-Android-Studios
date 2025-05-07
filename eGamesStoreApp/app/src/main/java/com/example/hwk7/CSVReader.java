package com.example.hwk7;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Game> readCSV(Context context, String fileName) {
        List<Game> gameList = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open(fileName);  // Ensure context is passed here
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    gameList.add(new Game(parts[0], parts[1], parts[2]));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameList;
    }
}
