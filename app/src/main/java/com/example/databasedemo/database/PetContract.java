package com.example.databasedemo.database;

import android.provider.BaseColumns;

// Outer class
public final class PetContract {



    // Now create a inner class for each of the tables of the database
    public static final class PetEntry implements BaseColumns{

        // Defining constants for the table name and each of the column headings

        public final static String TABLE_NAME = "pets";
        public final static String _ID = BaseColumns._ID; // The field _ID came from the BaseColumns class
        public final static String COLUMN_PET_NAME = "name";
        public final static String COLUMN_PET_BREED = "breed";
        public final static String COLUMN_PET_GENDER = "gender";
        public final static String COLUMN_PET_WEIGHT = "weight";

        // Defining the constants for the gender

        public final static int GENDER_UNKNOWN = 0;
        public final static int GENDER_MALE = 1;
        public final static int GENDER_FEMALE = 2;

    }
}
