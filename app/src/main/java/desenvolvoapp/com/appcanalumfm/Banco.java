package desenvolvoapp.com.appcanalumfm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Banco extends SQLiteOpenHelper {
    public Banco(@Nullable Context context) {
        super(context, "appcanalum", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = " CREATE TABLE musica ( " +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    nome TEXT, " +
                "    mensagem TEXT, " +
                "    musica TEXT, " +
                "    artista TEXT )";

        sqLiteDatabase.execSQL(sql);
    }

    public long insere(String nome, String mensagem, String musica, String artista) {
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("nome", nome);
        registro.put("mensagem", mensagem);
        registro.put("musica", musica);
        registro.put("artista", artista);
        long id = bd.insert("musica", null, registro);
        bd.close();
        return id;
    }

    public ArrayList<Musica> consultaTodos() {
        ArrayList<Musica> lista = null;
        String sql =  "SELECT * FROM musica";

        SQLiteDatabase banco = this.getReadableDatabase();

        Cursor c = banco.rawQuery(sql, null);
        if (c.moveToFirst()) {
            lista = new ArrayList<Musica>();
            do {
                Musica a = new Musica();
                a.setId(c.getLong(0));
                a.setNome(c.getString(1));
                a.setMensagem(c.getString(2));
                a.setMusica(c.getString(3));
                a.setArtista(c.getString(4));

                lista.add(a);

            }  while (c.moveToNext());

        }
        return lista;
    }

    public String consulta() {
        String retorno="";
        String sql =  "SELECT * FROM musica";

        SQLiteDatabase banco = this.getReadableDatabase();

        Cursor c = banco.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                retorno+= "Mensagem de ouvinte Nº" + c.getLong(0) + ": \n \n "
                        + "Nome do ouvinte - " + c.getString(1) + "\n "
                        + "Mensagem do ouvinte - " + c.getString(2) + "\n "
                        + "Música pedida - " + c.getString(3) + "\n "
                        + "Artista que toca a música - " + c.getString(4) + "\n ";
              }  while (c.moveToNext());

        }
        return retorno;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
