package com.example.kdm.a30seconds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kdm.a30seconds.QuizContract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "30Seconds.db";
    private static final int DATABASE_VERSION = 1;

    private static QuizDbHelper instance;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                CategoriesTable.TABLE_NAME + "( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";

        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillCategoriesTable() {
        Category c1 = new Category("Sports");
        addCategory(c1);
        Category c2 = new Category("Science");
        addCategory(c2);
        Category c3 = new Category("Bollywood");
        addCategory(c3);
        Category c4 = new Category("Harry Potter");
        addCategory(c4);
        Category c5 = new Category("Food");
        addCategory(c5);
    }

    private void addCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }

    private void fillQuestionsTable() {

        //Science-

        Question q1 = new Question("Which Planet have highest number of Moons?",
                "Jupiter", "Saturn", "Earth", 1,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q1);
        Question q2 = new Question("Which is the most abundant gas in the earth's atmosphere?",
                "Nitrogen(78.08)", "Hydrogen", "Carbon diOxide", 1,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q2);
        Question q3 = new Question(" Who invented periodic table?",
                "Dmitri Mendeleev", "Issac Newton", "David Joseph", 1,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q3);
        Question q4 = new Question("Which toxic element present in automobile exhausts?",
                "Tustin", "Iron", "Lead", 3,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q4);
        Question q5 = new Question("Which gas evolved from paddy fields and marshes?",
                "Methane", "Hydrogen", "Helium", 1,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q5);
        Question q6 = new Question("Which gases cause acid rain",
                "Helium", "Sulphur diOxide, Nitrogen Oxide", "Carbon diOxide", 2,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q6);
        Question q7 = new Question("With which polymer, the cabinets of radio and TV made of?",
                "Polythene", "Polystyrene", "Nylon", 2,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q7);
        Question q8 = new Question("Which chemical is used to make rain coats?",
                "Polythene", "Tericot", "Poly Vinyl Chloride(PVC)", 3,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q8);
        Question q9 = new Question("Which type of plastics can be recycled?",
                "Thermoplastic", "Polyprophylene (PP)", "Poly Vinyl Chloride(PVC)", 1,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q9);
        Question q10 = new Question("Which is the purest form of carbon?",
                "Graphite", "Sodium Nitrate", "Athene", 1,
                Question.DIFFICULTY_MEDIUM,Category.SCIENCE);
        addQuestion(q10);
        Question q11 = new Question("Which is the heaviest metal?",
                "Iron", "Osmium", "Mercury", 2,
                Question.DIFFICULTY_EASY,Category.SCIENCE);
        addQuestion(q11);
        Question q12 = new Question("Bleaching action of Chlorine is by: ",
                "Oxidation", "Reduction", "Decomposition", 3,
                Question.DIFFICULTY_MEDIUM,Category.SCIENCE);
        addQuestion(q12);
        Question q13 = new Question("What is the element present on lead pencils?",
                "Lead", "Carbon(Graphite)", "Copper", 2,
                Question.DIFFICULTY_MEDIUM,Category.SCIENCE);
        addQuestion(q13);
        Question q14 = new Question("What is the solvent of gold?",
                "Aqua Regia", "PolySulphide Solution", "Liquid Gold", 1,
                Question.DIFFICULTY_HARD,Category.SCIENCE);
        addQuestion(q14);
        Question q15 = new Question("Which chemical is the reason behind the brown colour of human faces?",
                "Athens", "Sodium Nitrate", "Bilirubin", 3,
                Question.DIFFICULTY_HARD,Category.SCIENCE);
        addQuestion(q15);
        Question q16 = new Question("Name the chemical assed to make tooth pastes white?",
                "Hydrogen", "Carbon diOxide", "Titanium diOxide", 3,
                Question.DIFFICULTY_EASY,Category.SCIENCE);
        addQuestion(q16);

        //Sports-

        //Easy

        Question q17 = new Question("Which Bowler took most Wickets in Test Cricket Match?",
                "Anil Kumble", "Muttiah Muralitharan", "Wasim Akram", 2,
                Question.DIFFICULTY_EASY, Category.SPORTS);
        addQuestion(q17);
        Question q18 = new Question("Sultan Azlan Shah Cup is related to which among the following Sports?",
                "Hockey", "Table Tennis", "Badminton", 1,
                Question.DIFFICULTY_EASY, Category.SPORTS);
        addQuestion(q18);
        Question q19 = new Question("Sachin Tendulkar hit his 100th international century against which among the following team?",
                "Bangladesh", "Sri Lanka", "South Africa", 1,
                Question.DIFFICULTY_EASY, Category.SPORTS);
        addQuestion(q19);
        Question q20 = new Question("The word “Agricultural shot” is known to be used sometimes in which among the following sports?",
                "Hockey", "Badminton", "Cricket", 3,
                Question.DIFFICULTY_EASY, Category.SPORTS);
        addQuestion(q20);
        Question q21 = new Question("Murugappa Gold Cup is related to which among the following sports?",
                "Table Tennis", "Hockey", "Badminton", 2,
                Question.DIFFICULTY_EASY, Category.SPORTS);
        addQuestion(q21);
        Question q22 = new Question("Biggest Cricket Stadium in the World?",
                "Edgbaston (Birmingham)", "Lord's(London)", "Melbourne Cricket Ground", 3,
                Question.DIFFICULTY_EASY, Category.SPORTS);
        addQuestion(q22);

        //Medium

        Question q23 = new Question("THE WORLD BENEATH HIS FEET is a Biography of?",
                "Pulela Gopichand", "Nawab Pataudi", "Ajit Wadekar", 1,
                Question.DIFFICULTY_MEDIUM, Category.SPORTS);
        addQuestion(q23);
        Question q24 = new Question("Which among the following country is the host of 2018 Commonwealth Games?",
                "Canada", "England", "Australia", 3,
                Question.DIFFICULTY_MEDIUM, Category.SPORTS);
        addQuestion(q24);
        Question q25 = new Question("Which among the following is played on a synthetic hard court?",
                "Wimbledon", "Australia Open", "French Open", 2,
                Question.DIFFICULTY_MEDIUM, Category.SPORTS);
        addQuestion(q25);
        Question q26 = new Question("On which among the following courts, Chennai Open is played ?",
                "Grass Court", "Clay Court", "Hard Court", 3,
                Question.DIFFICULTY_MEDIUM, Category.SPORTS);
        addQuestion(q26);
        Question q27 = new Question("Who among the following is the first Indian to score a century in Indian Premier League (IPL)?",
                "Manish Pandey", "Gautam Gambhir", "Rahul Dravid", 1,
                Question.DIFFICULTY_MEDIUM, Category.SPORTS);
        addQuestion(q27);

        //Hard

        Question q28 = new Question("The World Military Cup organized by the International Military Sports Council (CISM) involves which among the following sports?",
                "Cricket", "Tennis", "Football", 3,
                Question.DIFFICULTY_HARD, Category.SPORTS);
        addQuestion(q28);
        Question q29 = new Question("With which among the following sports, Ian Thorpe is related to?",
                "Athletics", "Swimming", "Racing", 2,
                Question.DIFFICULTY_HARD, Category.SPORTS);
        addQuestion(q29);
        Question q30 = new Question("Which of the following trophies is related with the game of ‘Football’?",
                "VCC Cup", "Merdeka Cup ", "Everest Cup", 2,
                Question.DIFFICULTY_HARD, Category.SPORTS);
        addQuestion(q30);
        Question q31 = new Question("Who among the following was first Rajiv Gandhi Khel Ratna?",
                "Vishwanath Anand", "Geet Sethi", "Nameirakpam Kunjarani", 1,
                Question.DIFFICULTY_HARD, Category.SPORTS);
        addQuestion(q31);
        Question q32 = new Question("Who among the following was the first Indian sportsman to boycott the Olympic torch relay in support of the Tibetan independence movement?",
                "Baichung Bhutia", "Dhanraj Pillay", "Chandu Borde", 1,
                Question.DIFFICULTY_HARD, Category.SPORTS);
        addQuestion(q32);

        //Bollywood-

        //Easy

        Question q33 = new Question("What are John Abraham and Akshay Kumar's professions in Garam Masala?",
                "Journalist", "Photographer", "Reporter", 2,
                Question.DIFFICULTY_EASY, Category.BOLLYWOOD);
        addQuestion(q33);
        Question q34 = new Question(" From where does Veeru propose to Basanti in Sholay?",
                "Top of Roof", "Top of Hill", "Top of Water Tank", 3,
                Question.DIFFICULTY_EASY, Category.BOLLYWOOD);
        addQuestion(q34);
        Question q35 = new Question("Anupam Kher's real age when he played a 65-year-old retired principal in Saaransh was..?",
                "42", "28", "30", 2,
                Question.DIFFICULTY_EASY, Category.BOLLYWOOD);
        addQuestion(q35);
        Question q36 = new Question("Madhuri Dixit's name in N Chandra's 'Tezaab' was..?",
                "Mohini", "Madhuri", "Pooja", 1,
                Question.DIFFICULTY_EASY, Category.BOLLYWOOD);
        addQuestion(q36);
        Question q37 = new Question("Which of these films was Ashutosh Gowariker's directorial debut?",
                "Pehla Nasha", "Jung", "Swadesh", 1,
                Question.DIFFICULTY_EASY, Category.BOLLYWOOD);
        addQuestion(q37);
        Question q38 = new Question("Aishwarya Rai was crowned Miss World in which year?",
                "1993", "1995", "1994", 3,
                Question.DIFFICULTY_EASY, Category.BOLLYWOOD);
        addQuestion(q38);

        //Medium

        Question q39 = new Question("Who plays the blind friend in the 1964 Dosti?",
                "Ramu", "Dinu", "Mohan", 3,
                Question.DIFFICULTY_MEDIUM, Category.BOLLYWOOD);
        addQuestion(q39);
        Question q40 = new Question(" Who was the male lead in the Sharmila Tagore-Shabana Azmi starrer Doosri Dulhan?",
                "Dharmendra", "Victor Banerjee", "Sanjeev Kumar", 2,
                Question.DIFFICULTY_MEDIUM, Category.BOLLYWOOD);
        addQuestion(q40);
        Question q41 = new Question("Lata Mangeshkar was awarded the Padma Bhushan in which year?",
                "1959", "1969", "1962", 2,
                Question.DIFFICULTY_MEDIUM, Category.BOLLYWOOD);
        addQuestion(q41);
        Question q42 = new Question("Which of these actors has never appeared in television advertisements?",
                "Anil Kapoor", "Hrithik Roshan", "Govinda", 1,
                Question.DIFFICULTY_MEDIUM, Category.BOLLYWOOD);
        addQuestion(q42);
        Question q43 = new Question("The title track of Chameli Ki Shaadi was sung by..?",
                "Anil Kapoor", "Dilip Kumar", "Kishore Kumar", 1,
                Question.DIFFICULTY_MEDIUM, Category.BOLLYWOOD);
        addQuestion(q43);

        //Hard

        Question q44 = new Question("Dilip Kumar-Meena Kumari starrer Yahudi was directed by...?",
                "Bimal Roy", "Mehboob", "Raj Kapoor", 1,
                Question.DIFFICULTY_HARD, Category.BOLLYWOOD);
        addQuestion(q44);
        Question q45 = new Question("The name of Kajol's character in Sohail Khan's Pyar Kiya Toh Darna Kya was...?",
                "Heena", "Muskan", "Anjali", 2,
                Question.DIFFICULTY_HARD, Category.BOLLYWOOD);
        addQuestion(q45);
        Question q46 = new Question("Raj Kapoor-Nargis starrer 'Chori Chori' was inspired from which Hollywood classic?",
                "Blithe Spirit", "It's a Wonderful Life", "It happened one Night", 3,
                Question.DIFFICULTY_HARD, Category.BOLLYWOOD);
        addQuestion(q46);
        Question q47 = new Question("The catch-line 'American dream, Indian soul' was of the film...?",
                "Pardes", "American Desi", "Indian", 1,
                Question.DIFFICULTY_HARD, Category.BOLLYWOOD);
        addQuestion(q47);
        Question q48 = new Question("The aboriginal instrument used in the music of Dil Chahta Hai was...?",
                "Bagpiper", "Didgeridoo", "Clarinet", 2,
                Question.DIFFICULTY_HARD, Category.BOLLYWOOD);
        addQuestion(q48);

        //Hollywood-

        //Easy

        Question q49 = new Question("In Harry Potter, who plays Nearly Headless Nick in the movie?",
                "Nicholas Cage", "John Hurt", "John Cleese", 3,
                Question.DIFFICULTY_EASY, Category.HARRYPOTTER);
        addQuestion(q49);
        Question q50 = new Question("In Harry Potter who plays Mr. Ollivander, the wand maker and merchant in Diagon Alley in the movie?",
                "George Harrison", "John Hurt", "John Cleese", 2,
                Question.DIFFICULTY_EASY, Category.HARRYPOTTER);
        addQuestion(q50);
        Question q51 = new Question(" In Harry Potter, who plays Hagrid in the movie?",
                "Robbie Coltrane", "John Hurt", "Robert DeNiro", 1,
                Question.DIFFICULTY_EASY, Category.HARRYPOTTER);
        addQuestion(q51);
        Question q52 = new Question(" In Harry Potter who plays Ron Weasley in the movie?",
                "Rupert Grint", "Robin Pinter", "Robert Grant", 1,
                Question.DIFFICULTY_EASY, Category.HARRYPOTTER);
        addQuestion(q52);
        Question q53 = new Question("In 'The Sorcerer's Stone' who plays Hermione Granger in the movie?",
                "Emily Watson", "Emma Watson", "Emma Thompson", 2,
                Question.DIFFICULTY_EASY, Category.HARRYPOTTER);
        addQuestion(q53);

        //Medium

        Question q54 = new Question("In Harry Potter, who plays Albus Dumbledore in the movie?",
                "Richard Harris", "Richard Burton", "Richard Dreyfuss", 1,
                Question.DIFFICULTY_MEDIUM, Category.HARRYPOTTER);
        addQuestion(q54);
        Question q55 = new Question("In Harry Potter who plays Professor McGonagall in the movie?",
                "Julie Christie", "Maggie Smith", "Vanessa Redgrave", 2,
                Question.DIFFICULTY_MEDIUM, Category.HARRYPOTTER);
        addQuestion(q55);
        Question q56 = new Question("In 'The Sorcerer's Stone' what flavor jellybean does Dumbledore finally get?",
                "Vomit", "Blueberry", "EarWax", 3,
                Question.DIFFICULTY_MEDIUM, Category.HARRYPOTTER);
        addQuestion(q56);
        Question q57 = new Question(" In 'Goblet of Fire', who gave Harry the Gillyweed?",
                "Neville", "Prof.Sprout", "Dobby", 1,
                Question.DIFFICULTY_MEDIUM, Category.HARRYPOTTER);
        addQuestion(q57);
        Question q58 = new Question("Who directed the movie 'Goblet of Fire'?",
                "George Harrison", "John Hurt", "John Cleese", 3,
                Question.DIFFICULTY_MEDIUM, Category.HARRYPOTTER);
        addQuestion(q58);

        //Hard

        Question q59 = new Question("During the second task, what charm does Cedric use to help him breathe underwater?",
                "Gillyweed Charm", "Bubblehead Charm", "Sharkhead Charm", 2,
                Question.DIFFICULTY_HARD, Category.HARRYPOTTER);
        addQuestion(q59);
        Question q60 = new Question("What does Filch do repeatedly throughout the film?",
                "Chokes on his drink", "Bumps into Dumbledore", "Lets the cannon off too early", 3,
                Question.DIFFICULTY_HARD, Category.HARRYPOTTER);
        addQuestion(q60);
        Question q61 = new Question("In 'Goblet of Fire', what does Harry buy from the witch�s trolley on the Hogwarts Express?",
                "He does'nt buy anything", "Chocolate Frog", "A pumpkin pasty", 1,
                Question.DIFFICULTY_HARD, Category.HARRYPOTTER);
        addQuestion(q61);
        Question q62 = new Question("In 'The Prisoner of Azkaban' film, who tells Harry, Hermione and Ron that the Fat Lady is missing?",
                "Ginny", "Percy", "George", 1,
                Question.DIFFICULTY_HARD, Category.HARRYPOTTER);
        addQuestion(q62);
        Question q63 = new Question("In the 'Prisoner of Azkaban', who is sleeping in the train compartment when Harry, Hermione and Ron enters?",
                "Prof.Lupin", "Prof.Snape", "Prof.Dumbledore", 1,
                Question.DIFFICULTY_HARD, Category.HARRYPOTTER);
        addQuestion(q63);
        Question q64 = new Question(" In Harry Potter, what are the numbers on the front of the Hogwart's Express?",
                "5897", "5972", "3097", 2,
                Question.DIFFICULTY_HARD, Category.HARRYPOTTER);
        addQuestion(q64);
        Question q65 = new Question( "In 'The Sorcerer's Stone', how many last minute points does Gryffindor get from Dumbledore?",
                "100", "200", "170", 3,
                Question.DIFFICULTY_HARD, Category.HARRYPOTTER);
        addQuestion(q65);

        //Food-

        //Easy

        Question q66 = new Question("What crop is NOT cultivated in Goa?",
                "Coconut", "Rice", "Corn", 3,
                Question.DIFFICULTY_EASY, Category.FOOD);
        addQuestion(q66);
        Question q67 = new Question("Which chocolate bar with a honeycomb centre was introduced in 1929?",
                "Wispa", "Flake", "Crunchie", 2,
                Question.DIFFICULTY_EASY, Category.FOOD);
        addQuestion(q67);
        Question q68 = new Question("Today Cadbury uses high quality cocoa beans from which location?",
                "South Africa", "North Africa", "West Africa", 3,
                Question.DIFFICULTY_EASY, Category.FOOD);
        addQuestion(q68);
        Question q69 = new Question("In 1875, Daniel Peter produced the first milk chocolate bar using powdered milk. What nationality was he?",
                "Swiss", "English", "French", 1,
                Question.DIFFICULTY_EASY, Category.FOOD);
        addQuestion(q69);
        Question q70 = new Question("What do you call Indian ice-cream?",
                "Gaajar ka Halwa", "Kheer", "Kulfi", 3,
                Question.DIFFICULTY_EASY, Category.FOOD);
        addQuestion(q70);

        //Medium

        Question q71 = new Question("When was Milk Tray first introduced?",
                "1915", "1932", "1923", 1,
                Question.DIFFICULTY_MEDIUM, Category.FOOD);
        addQuestion(q71);
        Question q72 = new Question("How many grams of fat can be found in a single Canadian McChicken sauce packet?",
                "10", "7", "16", 1,
                Question.DIFFICULTY_MEDIUM, Category.FOOD);
        addQuestion(q72);
        Question q73 = new Question(" In which U.S. state did the first McDonalds appear? (Not the franchise. Known then as 'McDonalds Hamburgers')",
                "Illinois", "California", "North Carolina", 2,
                Question.DIFFICULTY_MEDIUM, Category.FOOD);
        addQuestion(q73);
        Question q74 = new Question("Lassi is a drink made from what dairy product?",
                "Butter Milk", "Yogurt", "Cream Cheese", 2,
                Question.DIFFICULTY_MEDIUM, Category.FOOD);
        addQuestion(q74);
        Question q75 = new Question("Thali is a favorite dish of Southern India. How is it served?",
                "In a clay pot", "In a tall glass", "In small bowls on a metal tray", 3,
                Question.DIFFICULTY_MEDIUM, Category.FOOD);
        addQuestion(q75);

        //Hard

        Question q76 = new Question("Until Victorian times, chocolate was thought of as a drink. When did the first chocolate bar appear?",
                "1831", "1828", "No sure date!", 3,
                Question.DIFFICULTY_HARD, Category.FOOD);
        addQuestion(q76);
        Question q77 = new Question("According to the McDonalds Canada website, how many grams of fat are in a McVeggie burger?",
                "10", "7", "22", 2,
                Question.DIFFICULTY_HARD, Category.FOOD);
        addQuestion(q77);
        Question q78 = new Question("The name 'McDonalds' came from the two brothers who originally owned 'Mcdonalds Hamburgers'. What were the two brothers' names?",
                "Robert and Niel", "Carl and Ray", "Dick and Mac", 3,
                Question.DIFFICULTY_HARD, Category.FOOD);
        addQuestion(q78);
        Question q79 = new Question("Within McDonalds restaurants, which level of individuals would train a new employee on the customer service (cashier) station?",
                "Crew Trainer", "Team Coordinator", "Swing Manager", 1,
                Question.DIFFICULTY_HARD, Category.FOOD);
        addQuestion(q79);
        Question q80 = new Question("Curries are made in different ways, according to the part of the country. If you were served Madras-style curry, you should expect it to be..",
                "Fishy", "Fragrant", "Hot", 3,
                Question.DIFFICULTY_HARD, Category.FOOD);
        addQuestion(q80);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            } while (c.moveToNext());
        }

        c.close();
        return categoryList;
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestions(int categoryID, String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " =? " +
                " AND " + QuestionsTable.COLUMN_DIFFICULTY + " =? ";

        String[] selectionArgs = new String[]{String.valueOf(categoryID), difficulty};
        Cursor c = db.query(
                QuestionsTable.TABLE_NAME,
                null,
                selection,
        selectionArgs,
        null,
        null,
        null

        );

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
