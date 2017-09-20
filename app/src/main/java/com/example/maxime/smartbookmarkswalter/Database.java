package com.example.maxime.smartbookmarkswalter;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maxime on 20/09/2017.
 */

public class Database extends SQLiteOpenHelper {

    /**
     * Constante contenant le numéro actuel de la base de données
     */
    public static final int DATABASE_VERSION = 1;
    /**
     * Constante contenant le nom du fichier de base de données
     */
    public static final String DATABASE_NAME = "macollec.db";

    /**
     * Initialisation simple de la base de données à partir d'un contexte.
     * @param context
     */
    public Database(Context context){
        //Appel du constructeur parent avec les paramètre minimum, qui sont :
        // - Le contexte
        // - Le nom du fichier de base de données
        // - Un objet CursorFactory, inutile dans notre cas.
        // - La version courante de la base de données.
        //Le système va tenter de créer et maintenir à jour le fichier de base de données
        //selon le numéro de version passé ici, à l'aide des méthodes onCreate, onUpgrade et onDowngrade.
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Création de la table book
        db.execSQL("CREATE TABLE \"Books\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"title\" VARCHAR NOT NULL , \"author\" VARCHAR NOT NULL , \"genre\" VARCHAR NOT NULL ); ");
        //Création de la table commentaires
        db.execSQL("CREATE TABLE \"Comments\" (\"id\"  PRIMARY KEY  NOT NULL , \"bookId\"  NOT NULL , \"comment\"  NOT NULL , \"date\"  NOT NULL ); ");

        //AJout des livres
        db.execSQL("INSERT INTO \"Books\" VALUES(1,'Les fleurs du mal','Charles Baudelaire','Poèmes'); ");
        db.execSQL("INSERT INTO \"Books\" VALUES(2,'Germinal','Emile Zola','Roman'); ");
        db.execSQL("INSERT INTO \"Books\" VALUES(3,'Les misérables','Victor Hugo','Roman'); ");
        db.execSQL("INSERT INTO \"Books\" VALUES(4,'1984','George Orwell','Science-Fiction'); ");
        db.execSQL("INSERT INTO \"Books\" VALUES(5,'Le Meilleur des mondes','Aldous Huxley','Science-Fiction'); ");
        db.execSQL("INSERT INTO \"Books\" VALUES(6,'Vingt mille lieues sous les mers','Jules Verne','Aventure'); ");
        db.execSQL("INSERT INTO \"Books\" VALUES(7,'Les Trois Mousquetaires','Alexandre Dumas','Aventure'); ");

        //Je crée un objet ContentValues permettant de représenter
        //une ligne de la table type.
        ////ContentValues cv = new ContentValues();
        //Je paramètre pour chaque champ de la table type la valeur
        //désirée
        ////cv.put("libelle","Video");
        ////cv.put("mimetype","video/*");
        ////cv.put("icone",0);
        //J'insère les données
        ////db.insert("type",null,cv);

        ////cv.put("libelle","Audio");
        ////cv.put("mimetype","audio/*");
        //J'insère les données
        ////db.insert("type",null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Rien à faire ici en version 1, personne n'a encore installé l'application.
    }

}
