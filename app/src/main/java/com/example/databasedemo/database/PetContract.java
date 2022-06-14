package com.example.databasedemo.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

// Outer class
public final class PetContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private PetContract() {}


    public static final String CONTENT_AUTHORITY = "com.example.databasedemo";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.databasedemo/pets/ is a valid path for
     * looking at pet data. content://com.example.databasedemo/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_PETS = "pets";


    // Now create a inner class for each of the tables of the database
    public static final class PetEntry implements BaseColumns{

        /** The content URI to access the pet data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        /**
         * Inner class that defines constant values for the pets database table.
         * Each entry in the table represents a single pet.
         */

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


        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;


        public static boolean isValidGender(int value){
            if(value == GENDER_UNKNOWN || value == GENDER_MALE || value == GENDER_FEMALE)
                return true;
            else
                return false;
        }




    }
}
