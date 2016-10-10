package ch.dodora.ultraquizz.database;

import android.database.Cursor;
import android.provider.BaseColumns;

import java.util.ArrayList;

import ch.dodora.ultraquizz.StarterActivity;
import ch.dodora.ultraquizz.quizz.Question;

/**
 * Created by rdomi on 10/10/2016.
 */

public final class TableQuestion {

    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS \"" + QuestionEntry.TABLE_NAME + "\" (\n" +
            "\t`" + QuestionEntry.COLUMN_NAME_ID + "`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`" + QuestionEntry.COLUMN_NAME_PROPOSITION + "`\tTEXT NOT NULL,\n" +
            "\t`" + QuestionEntry.COLUMN_NAME_ANSWER + "`\tTEXT NOT NULL,\n" +
            "\t`" + QuestionEntry.COLUMN_NAME_THEME + "`\tINTEGER\n" + ");";
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + QuestionEntry.TABLE_NAME;
    public static final String SQL_CREATE_PART_00 = "INSERT INTO `" + QuestionEntry.TABLE_NAME + "` VALUES" +
            " (1,'Afghanistan','Kaboul',1),\n" +
            " (2,'Afrique du Sud','Pretoria',1),\n" +
            " (3,'Albanie','Tirana',1),\n" +
            " (4,'Algérie','Alger',1),\n" +
            " (5,'Allemagne','Berlin',1),\n" +
            " (6,'Andorre','Andorre-la-Vieille',1),\n" +
            " (7,'Angola','Luanda',1),\n" +
            " (8,'Antigua-et-Barbuda','Saint John''s',1),\n" +
            " (9,'Arabie Saoudite','Riyad',1),\n" +
            " (10,'Argentine','Buenos Aires',1),\n" +
            " (11,'Arménie','Erevan',1),\n" +
            " (12,'Australie','Canberra',1),\n" +
            " (13,'Autriche','Vienne',1),\n" +
            " (14,'Azerbaïdjan','Bakou',1),\n" +
            " (15,'Bahamas','Nassau',1),\n" +
            " (16,'Bahreïn','Manama',1),\n" +
            " (17,'Bangladesh','Dacca',1),\n" +
            " (18,'Barbade','Bridgetown',1),\n" +
            " (19,'Belgique','Bruxelles',1),\n" +
            " (20,'Belize','Belmopan',1),\n" +
            " (21,'Bénin','Porto-Novo',1),\n" +
            " (22,'Bhoutan','Thimbu',1),\n" +
            " (23,'Biélorussie','Minsk',1),\n" +
            " (24,'Birmanie','Naypyidaw',1),\n" +
            " (25,'Bolivie','Sucre',1),\n" +
            " (26,'Bosnie-Herzégovine','Sarajevo',1),\n" +
            " (27,'Botswana','Gaborone',1),\n" +
            " (28,'Brésil','Brasilia',1),\n" +
            " (29,'Brunei','Bandar Seri Begawan',1),\n" +
            " (30,'Bulgarie','Sofia',1),\n" +
            " (31,'Burkina Faso','Ouagadougou',1),\n" +
            " (32,'Burundi','Bujumbura',1),\n" +
            " (33,'Cambodge','Phnom Penh',1),\n" +
            " (34,'Cameroun','Yaoundé',1),\n" +
            " (35,'Canada','Ottawa',1),\n" +
            " (36,'Cap-Vert','Praia',1),\n" +
            " (37,'Chili','Santiago',1),\n" +
            " (38,'Chine','Pékin',1),\n" +
            " (39,'Chypre','Nicosie',1),\n" +
            " (40,'Colombie','Bogota',1),\n" +
            " (41,'Comores','Moroni',1),\n" +
            " (42,'Congo','Brazzaville',1),\n" +
            " (43,'Corée du Nord','Pyongyang',1),\n" +
            " (44,'Corée du Sud','Séoul',1),\n" +
            " (45,'Costa Rica','San José',1),\n" +
            " (46,'Côte d''Ivoire','Yamoussoukro',1),\n" +
            " (47,'Croatie','Zagreb',1),\n" +
            " (48,'Cuba','La Havane',1),\n" +
            " (49,'Danemark','Copenhague',1),\n" +
            " (50,'Djibouti','Djibouti',1),\n" +
            " (51,'Dominique','Roseau',1),\n" +
            " (52,'Egypte','Le Caire',1),\n" +
            " (53,'Emirats Arabes Unis','Abu Dhabi',1),\n" +
            " (54,'Equateur','Quito',1),\n" +
            " (55,'Erythrée','Asmara',1),\n" +
            " (56,'Espagne','Madrid',1),\n" +
            " (57,'Estonie','Tallinn',1),\n" +
            " (58,'Etats-Unis','Washington',1),\n" +
            " (59,'Ethiopie','Addis-Abeba',1),\n" +
            " (60,'Fidji','Suva',1),\n" +
            " (61,'Finlande','Helsinki',1),\n" +
            " (62,'France','Paris',1),\n" +
            " (63,'Gabon','Libreville',1),\n" +
            " (64,'Gambie','Banjul',1),\n" +
            " (65,'Géorgie','Tbilissi',1),\n" +
            " (66,'Ghana','Accra',1),\n" +
            " (67,'Grèce','Athènes',1),\n" +
            " (68,'Grenade','Saint George''s',1),\n" +
            " (69,'Guatemala','Guatemala',1),\n" +
            " (70,'Guinée','Conakry',1),\n" +
            " (71,'Guinée équatoriale','Malabo',1),\n" +
            " (72,'Guinée-Bissau','Bissau',1),\n" +
            " (73,'Guyana','Georgetown',1),\n" +
            " (74,'Haïti','Port-au-Prince',1),\n" +
            " (75,'Honduras','Tegucigalpa',1),\n" +
            " (76,'Hongrie','Budapest',1),\n" +
            " (77,'Île Maurice','Port Louis',1),\n" +
            " (78,'Inde','New Delhi',1),\n" +
            " (79,'Indonésie','Jakarta',1),\n" +
            " (80,'Irak','Bagdad',1),\n" +
            " (81,'Iran','Téhéran',1),\n" +
            " (82,'Irlande','Dublin',1),\n" +
            " (83,'Islande','Reykjaík',1),\n" +
            " (84,'Israël','Jérusalem',1),\n" +
            " (85,'Italie','Rome',1),\n" +
            " (86,'Jamaïque','Kingston',1),\n" +
            " (87,'Japon','Tokyo',1),\n" +
            " (88,'Jordanie','Amman',1),\n" +
            " (89,'Kazakhstan','Astana',1),\n" +
            " (90,'Kenya','Nairobi',1),\n" +
            " (91,'Kirghizistan','Bichkek',1),\n" +
            " (92,'Kiribati','Tarawa',1),\n" +
            " (93,'Kosovo','Pristina',1),\n" +
            " (94,'Koweït','Koweït',1),\n" +
            " (95,'Laos','Vientiane',1),\n" +
            " (96,'Lesotho','Maseru',1),\n" +
            " (97,'Lettonie','Riga',1),\n" +
            " (98,'Liban','Beyrouth',1),\n" +
            " (99,'Liberia','Monrovia',1),\n" +
            " (100,'Libye','Tripoli',1),\n" +
            " (101,'Liechtenstein','Vaduz',1),\n" +
            " (102,'Lituanie','Vilnius',1),\n" +
            " (103,'Luxembourg','Luxembourg',1),\n" +
            " (104,'Macédoine','Skopje',1),\n" +
            " (105,'Madagascar','Antananarivo',1),\n" +
            " (106,'Malaisie','Kuala Lumpur',1),\n" +
            " (107,'Malawi','Lilongwe',1),\n" +
            " (108,'Maldives','Malé',1),\n" +
            " (109,'Mali','Bamako',1),\n" +
            " (110,'Malte','La Valette',1),\n" +
            " (111,'Maroc','Rabat',1),\n" +
            " (112,'Marshall','Majuro',1),\n" +
            " (113,'Mauritanie','Nouakchott',1),\n" +
            " (114,'Mexique','Mexico',1),\n" +
            " (115,'Micronésie','Palikir',1),\n" +
            " (116,'Moldavie','Chisinau',1),\n" +
            " (117,'Monaco','Monaco',1),\n" +
            " (118,'Mongolie','Oulan-Bator',1),\n" +
            " (119,'Monténégro','Podgorica',1),\n" +
            " (120,'Mozambique','Maputo',1),\n" +
            " (121,'Namibie','Windhoek',1),\n" +
            " (122,'Nauru','Yaren',1),\n" +
            " (123,'Népal','Katmandou',1),\n" +
            " (124,'Nicaragua','Managua',1),\n" +
            " (125,'Niger','Niamey',1),\n" +
            " (126,'Nigeria','Abuja',1),\n" +
            " (127,'Norvège','Oslo',1),\n" +
            " (128,'Nouvelle-Zélande','Wellington',1),\n" +
            " (129,'Oman','Mascate',1),\n" +
            " (130,'Ouganda','Kampala',1),\n" +
            " (131,'Ouzbékistan','Tachkent',1),\n" +
            " (132,'Pakistan','Islamabad',1),\n" +
            " (133,'Palaos','Melekeok',1),\n" +
            " (134,'Panama','Panama',1),\n" +
            " (135,'Papouasie-Nouvelle-Guinée','Port Moresby',1),\n" +
            " (136,'Paraguay','Asunción',1),\n" +
            " (137,'Pays-Bas','Amsterdam',1),\n" +
            " (138,'Pérou','Lima',1),\n" +
            " (139,'Philippines','Manille',1),\n" +
            " (140,'Pologne','Varsovie',1),\n" +
            " (141,'Portugal','Lisbonne',1),\n" +
            " (142,'Qatar','Doha',1),\n" +
            " (143,'République Centrafricaine','Bangui',1),\n" +
            " (144,'République Démocratique du Congo','Kinshasa',1),\n" +
            " (145,'République Dominicaine','Saint-Domingue',1),\n" +
            " (146,'République Tchèque','Prague',1),\n" +
            " (147,'Roumanie','Bucarest',1),\n" +
            " (148,'Royaume-Uni','Londres',1),\n" +
            " (149,'Russie','Moscou',1),\n" +
            " (150,'Rwanda','Kigali',1),\n" +
            " (151,'Sainte-Lucie','Castries',1),\n" +
            " (152,'Saint-Kitts-et-Nevis','Basseterre',1),\n" +
            " (153,'Saint-Marin','Saint-Marin',1),\n" +
            " (154,'Saint-Vincent-et-les-Grenadines','Kingstown',1),\n" +
            " (155,'Salomon','Honiara',1),\n" +
            " (156,'Salvador','San Salvador',1),\n" +
            " (157,'Samoa','Apia',1),\n" +
            " (158,'São Tomé et Príncipe','São Tomé',1),\n" +
            " (159,'Sénégal','Dakar',1),\n" +
            " (160,'Serbie','Belgrade',1),\n" +
            " (161,'Seychelles','Victoria',1),\n" +
            " (162,'Sierra Leone','Freetown',1),\n" +
            " (163,'Singapour','Singapour',1),\n" +
            " (164,'Slovaquie','Bratislava',1),\n" +
            " (165,'Slovénie','Ljubljana',1),\n" +
            " (166,'Somalie','Mogadiscio',1),\n" +
            " (167,'Soudan','Khartoum',1),\n" +
            " (168,'Sri Lanka','Sri Jayawardenapura',1),\n" +
            " (169,'Suède','Stockholm',1),\n" +
            " (170,'Suisse','Berne',1),\n" +
            " (171,'Suriname','Paramaribo',1),\n" +
            " (172,'Swaziland','Mbabane',1),\n" +
            " (173,'Syrie','Damas',1),\n" +
            " (174,'Tadjikistan','Douchanbe',1),\n" +
            " (175,'Taïwan','Taipei',1),\n" +
            " (176,'Tanzanie','Dodoma',1),\n" +
            " (177,'Tchad','N''Djamena',1),\n" +
            " (178,'Thaïlande','Bangkok',1),\n" +
            " (179,'Timor-Oriental','Dili',1),\n" +
            " (180,'Togo','Lomé',1),\n" +
            " (181,'Tonga','Nukualofa',1),\n" +
            " (182,'Trinité-et-Tobago','Port of Spain',1),\n" +
            " (183,'Tunisie','Tunis',1),\n" +
            " (184,'Turkménistan','Achgabat',1),\n" +
            " (185,'Turquie','Ankara',1),\n" +
            " (186,'Tuvalu','Fanafuti',1),\n" +
            " (187,'Ukraine','Kiev',1),\n" +
            " (188,'Uruguay','Montevideo',1),\n" +
            " (189,'Vanuatu','Port-Vila',1),\n" +
            " (190,'Vatican','Vatican',1),\n" +
            " (191,'Venezuela','Caracas',1),\n" +
            " (192,'Viêt Nam','Hanoi',1),\n" +
            " (193,'Yémen','Sanaa',1),\n" +
            " (194,'Zambie','Lusaka',1),\n" +
            " (195,'Zimbabwe','Harare',1);";

    private TableQuestion() {
    }

    public static final void SQL_RETRIEVE_QUESTION(String theme) {
        final String ALIAS_COUNTER = "alias_counter";
        Cursor cursorBase, cursorQuestion;

        cursorBase = StarterActivity.db.rawQuery("SELECT " + TableTheme.ThemeEntry.COLUMN_NAME_ID + ", " + TableTheme.ThemeEntry.COLUMN_NAME_THEME + ", COUNT(*) AS \"" + ALIAS_COUNTER + "\"\n" +
                "FROM " + TableTheme.ThemeEntry.TABLE_NAME + ", " + QuestionEntry.TABLE_NAME + "\n" +
                "WHERE LOWER(" + TableTheme.ThemeEntry.COLUMN_NAME_THEME + ") LIKE \"" + theme.toLowerCase() + "\"", null);
        final int COL_THEME_ID = cursorBase.getColumnIndexOrThrow(TableTheme.ThemeEntry.COLUMN_NAME_ID);
        final int COL_THEME_THEME = cursorBase.getColumnIndexOrThrow(TableTheme.ThemeEntry.COLUMN_NAME_THEME);
        final int COL_TABLE_COUNTER = cursorBase.getColumnIndexOrThrow(ALIAS_COUNTER);

        cursorBase.moveToFirst();
        final int THEME_ID = cursorBase.getInt(COL_THEME_ID);
        final String THEME_THEME = cursorBase.getString(COL_THEME_THEME);
        final int TABLE_COUNTER = cursorBase.getInt(COL_TABLE_COUNTER);

        do {
            int id = (int) (Math.random() * TABLE_COUNTER);
            cursorQuestion = StarterActivity.db.rawQuery("SELECT " + QuestionEntry.COLUMN_NAME_ID + ", " + QuestionEntry.COLUMN_NAME_PROPOSITION + ", " + QuestionEntry.COLUMN_NAME_ANSWER + "\n" +
                    "FROM " + QuestionEntry.TABLE_NAME + "\n" +
                    "WHERE " + QuestionEntry.COLUMN_NAME_ID + " = " + id + "\n" +
                    "AND " + QuestionEntry.COLUMN_NAME_THEME + " = " + THEME_ID, null);
            final int COL_QUESTION_ID = cursorQuestion.getColumnIndex(QuestionEntry.COLUMN_NAME_ID);
            final int COL_QUESTION_PROPOSITION = cursorQuestion.getColumnIndex(QuestionEntry.COLUMN_NAME_PROPOSITION);
            final int COL_QUESTION_ANSWER = cursorQuestion.getColumnIndex(QuestionEntry.COLUMN_NAME_ANSWER);

            cursorQuestion.moveToFirst();
            final int QUESTION_ID = cursorQuestion.getInt(COL_QUESTION_ID);
            final String QUESTION_PROPOSITION = cursorQuestion.getString(COL_QUESTION_PROPOSITION);
            final String QUESTION_ANSWER_RIGHT = cursorQuestion.getString(COL_QUESTION_ANSWER);
            ArrayList<String> QUESTION_ANSWER_FALSES = new ArrayList<>(3);

            //Generate false answers
            do {
                int answerFalseId = (int) (Math.random() * TABLE_COUNTER);
                //Id must be differente
                if (answerFalseId != QUESTION_ID) {
                    //Answer (false) must be different
                    Cursor cursorAnswerFalse = StarterActivity.db.rawQuery("SELECT " + QuestionEntry.COLUMN_NAME_ANSWER + "\n" +
                            "FROM " + QuestionEntry.TABLE_NAME + "\n" +
                            "WHERE " + QuestionEntry.COLUMN_NAME_ID + " = " + answerFalseId, null);
                    final int COL_ANSWER_FALSE = cursorAnswerFalse.getColumnIndex(QuestionEntry.COLUMN_NAME_ANSWER);
                    cursorAnswerFalse.moveToFirst();
                    final String ANSWER_FALSE = cursorAnswerFalse.getString(COL_ANSWER_FALSE);
                    if (ANSWER_FALSE.toLowerCase() != QUESTION_ANSWER_RIGHT.toLowerCase() && !QUESTION_ANSWER_FALSES.contains(ANSWER_FALSE))
                        QUESTION_ANSWER_FALSES.add(ANSWER_FALSE);

                    if (!cursorAnswerFalse.isClosed()) cursorAnswerFalse.close();
                }
            } while (QUESTION_ANSWER_FALSES.size() < 3);
            new Question(THEME_THEME, QUESTION_PROPOSITION, QUESTION_ANSWER_RIGHT, QUESTION_ANSWER_FALSES);

        } while (Question.questions.size() < Question.QUESTIONS_TO_DISPLAY);

        //Close Cursors
        if (!cursorBase.isClosed()) cursorBase.close();
        if (!cursorQuestion.isClosed()) cursorQuestion.close();
    }

    public static class QuestionEntry implements BaseColumns {
        public static final String TABLE_NAME = "tb_question";
        public static final String COLUMN_NAME_ID = "id_ques";
        public static final String COLUMN_NAME_PROPOSITION = "proposition_ques";
        public static final String COLUMN_NAME_ANSWER = "answer_ques";
        public static final String COLUMN_NAME_THEME = "id_theme";
    }
}
