package gary.cregan.urbanquiz.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
	 
    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/gary.cregan.urbanquiz/databases/";
 
    private static String DB_NAME = "halfDictionary.sqlite";
 
    private SQLiteDatabase myDataBase; 
 
    private final Context myContext;
 
    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DataBaseHelper(Context context) {
 
    	super(context, DB_NAME, null, 1);
        this.myContext = context;
        
        // checking database and open it if exists
        if (checkDataBase()) 
        {
            openDataBase();
        } 
        else
        {
            try 
            {
                this.getReadableDatabase();
                copyDataBase();
                this.close();
                openDataBase();

            } 
            catch (IOException e) 
            {
                throw new Error("Error copying database: " + e.toString());
            }
        }

    }
 
    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase()
    {
    	File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();  
    }
 
    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{
 
    	//Open your local db as the input stream
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
 
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DB_NAME;
 
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
 
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    }
 
    public void openDataBase() throws SQLException{
 
    	//Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }
 
    @Override
	public synchronized void close() {
 
    	    if(myDataBase != null)
    		    myDataBase.close();
 
    	    super.close();
 
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
 
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
	}
	
	public boolean isOpen()
	{
		if(myDataBase.isOpen())
		{
			return true;
		}
		return false;
	}
	
	public List<String> getThreeRandomWordsWhenWrongAnswersNotAvailable()
	{
		List<String> returnedList = new ArrayList<String>();
		
		for(int i = 0; i < 3; i++)
		{
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(40184);
			String returnedWord = "";
			do
			{
				returnedWord = getWord(randomInt);
			}
			while(returnedWord == null
				  || returnedWord.equals("")
				  || returnedList.contains(returnedWord));
			
			returnedList.add(returnedWord);
		}
		return returnedList;
		
	}
	
	public String getWord(int id)
	{
		String returnedValue = "";
		//(table, columns, selection, selectionArgs, groupBy, having, orderBy)
		Cursor c = myDataBase.query("dictionary", new String[]{"word"}, "_id=?", new String[]{Integer.toString(id-1)}, null, null, null);
		while(c.getCount() == 0)
		{
			
		}
		
		if(c != null)
		{
			c.moveToFirst();
			returnedValue = c.getString(0);
		}
		c.close();
		return returnedValue;
	}
	
	public List<String> getWrongAnswers(String argWord)
	{
		List<String> returnedValue = new ArrayList<String>();
		//(table, columns, selection, selectionArgs, groupBy, having, orderBy)
		Cursor c = myDataBase.query("dictionary", new String[]{"word"}, "word like ?", new String[]{argWord.substring(0, 2) + "%"}, null, null, null);
		if(c != null)
		{
			if(c.getCount() == 0 || c.getCount() < 3)
			{
				returnedValue = getThreeRandomWordsWhenWrongAnswersNotAvailable();
			}
			else 
			{
				c.moveToFirst();
				do
				{
					returnedValue.add(c.getString(c.getColumnIndex("word")));
					c.moveToNext();
				}
				while(!c.isAfterLast());
			}

		}
		c.close();
		return returnedValue;
	}
 
        // Add your public helper methods to access and get content from the database.
       // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
       // to you to create adapters for your views.
 
}
