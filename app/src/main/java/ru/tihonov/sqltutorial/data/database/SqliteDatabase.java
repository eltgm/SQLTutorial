package ru.tihonov.sqltutorial.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import ru.tihonov.sqltutorial.models.Unit;

public class SqliteDatabase extends SQLiteOpenHelper implements Database {
    //класс для работы с базой данных
    private static final int DATABASE_VERSION = 1;
    private final String UNITS_TABLE = "unitsTable";

    public SqliteDatabase(Context context) {
        super(context, "unitsDB.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + UNITS_TABLE +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "UNIT_NAME TEXT," +
                "UNIT_TEXT TEXT);");

        ContentValues cv = new ContentValues();

        cv.put("UNIT_NAME", "Учебник MySQL");
        cv.put("UNIT_TEXT", "<html>\n" +
                "<head>\n" +
                "<style> \n" +
                "\n" +
                "select{ border:0 !important; outline: 1px inset black !important; outline-offset: -1px !important; }\n" +
                "ul.nav-list.primary>li a.videolink{ background: none; margin: 0px; padding: 0px; border: 1px solid #d6d6d6;}\n" +
                "div.feature-box div.feature-box-icon, .col-md-3 .course-box, li.heading, div.footer-copyright { background: #004e61 url(/images/pattern.png) repeat center center !important;}\n" +
                ".sub-main-menu .sub-menuu div:hover, .sub-main-menu .viewall, header nav ul.nav-main li a:hover, button.btn-responsive-nav, header div.search button.btn-default { background: #004e61 !important;}\n" +
                ".submenu-item{ border-bottom: 2px solid #004e61 !important; border-top: 2px solid #004e61 !important }\n" +
                ".ace_scroller{overflow: auto!important;}\\n\" + \n" +
                "a.demo{font-family: \\\"Open Sans\\\",Arial,sans-serif; background:#004e61; color:#fff; font-size:13px; padding:3px 10px; border:1px solid #d6d6d6; position:absolute; right:5px; margin:-6px 17px 0px 0px;}\n" +
                "a.demo:hover{opacity:.8}\n" +
                "body{\n" +
                "    background-color: #eeeeee;\n" +
                "   }" +
                "</style> \n" +
                "</head>\n" +
                "<hr>\n" +
                "<h1>Учебник MySQL</h1>\n" +
                "<div class=\\\"center-aligned tutorial-menu\\\">\n" +
                "</div>\n" +
                "<div>\n" +
                "<p>MySQL является самой популярной системой управления базами данных с открытым исходным кодом. MySQL - одна из лучших СУБД, используемая для разработки различных сетевых приложений. MySQL разрабатывается, продается и поддерживается MySQL AB, которая является шведской компанией. Этот урок научит вас работать с MySQL.</p>\n" +
                "</div>\n" +
                "<h1>Аудитория</h1>\n" +
                "<p>Этот учебник подготовлен для новичков, чтобы помочь им понять основные понятия, связанные с языками MySQL\n" +
                "</p>\n" +
                "<h1>Предпосылки</h1> \n" +
                "<p>Прежде чем вы начнете практиковать различные типы примеров, приведенные в этом учебном пособии, предполагается, что вы уже знаете о том, что такое база данных, в особенности СУБД и что такое компьютерный язык программирования.\n" +
                "</p>\n" +
                "<hr>\n" +
                "<br><br>\n" +
                "</html>");


        db.insert(UNITS_TABLE, null, cv);

        cv.put("UNIT_NAME", "Что такое база данных?");
        cv.put("UNIT_TEXT", "<html>\n" +
                "<style>\n" +
                "select{ border:0 !important; outline: 1px inset black !important; outline-offset: -1px !important; }\n" +
                "ul.nav-list.primary>li a.videolink{    background: none; margin: 0px; padding: 0px; border: 1px solid #d6d6d6;}\n" +
                "div.feature-box div.feature-box-icon, .col-md-3 .course-box, li.heading, div.footer-copyright { background: #004e61 url(/images/pattern.png) repeat center center !important;}\n" +
                ".sub-main-menu .sub-menuu div:hover, .sub-main-menu .viewall, header nav ul.nav-main li a:hover, button.btn-responsive-nav, header div.search button.btn-default { background: #004e61 !important;}\n" +
                ".submenu-item{ border-bottom: 2px solid #004e61 !important; border-top: 2px solid #004e61 !important }\n" +
                ".ace_scroller{overflow: auto!important;}\n" +
                "a.demo{font-family: \"Open Sans\",Arial,sans-serif; background:#004e61; color:#fff; font-size:13px; padding:3px 10px; border:1px solid #d6d6d6; position:absolute; right:5px; margin:-6px 17px 0px 0px;}\n" +
                "a.demo:hover{opacity:.8}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<hr>\n" +
                "<h2>Что такое база данных?</h2>\n" +
                "<p>База данных представляет собой отдельное приложение, которое хранит набор данных. Каждая база данных имеет один или несколько различных API для создания, доступа, управления, поиска и репликации данных, которые она хранит.</p>\n" +
                "<p>Могут также использоваться другие типы хранилищ данных, такие как файлы в файловой системе или большие хеш-таблицы в памяти, но извлечение и запись данных не будут такими быстрыми и легкими в этих типах систем.</p>\n" +
                "<p>В настоящее время мы используем системы управления реляционными базами данных (РСУБД) для хранения и управления огромным объемом данных. Это называется реляционной базой данных, поскольку все данные хранятся в разных таблицах, а отношения устанавливаются с использованием первичных ключей или других ключей, известных как <b>внешние ключи</b>.</p>\n" +
                "<p>Система управления реляционными базами данных (РСУБД)</b> это программное обеспечение, которое &minus;</p>\n" +
                "<ul class=\"list\">\n" +
                "<li><p>Позволяет реализовать базу данных с таблицами, столбцами и индексами.</p></li>\n" +
                "<li><p>Гарантирует ссылочную целостность между строками различных таблиц.</p></li>\n" +
                "<li><p>Автоматически обновляет индексы.</p></li>\n" +
                "<li><p>Интерпретирует SQL-запрос и объединяет информацию из разных таблиц.</p></li>\n" +
                "</ul>\n" +
                "<h2>Терминология РСУБД</h2>\n" +
                "<p>Прежде чем мы перейдем к объяснению базы данных MySQL, давайте пересмотреть несколько определений, связанных с базой данных.</p>\n" +
                "<ul class=\"list\">\n" +
                "<li><p><b>База данных</b> &minus; База данных представляет собой набор таблиц со связанными данными.</p></li>\n" +
                "<li><p><b>Таблица</b> &minus; Таблица - это матрица с данными. Таблица в базе данных выглядит как простая электронная таблица.</p></li>\n" +
                "<li><p><b>Столбец</b> &minus; Один столбец (элемент данных) содержит данные одного и того же типа, например почтовый индекс столбца.</p></li>\n" +
                "<li><p><b>Строка</b> &minus; Строка (запись) представляет собой группу связанных данных, например данные одной подписки.</p></li>\n" +
                "<li><p><b>Избыточность</b> &minus; сохранение данных дважды, избыточно, чтобы сделать систему быстрее.</p></li>\n" +
                "<li><p><b>Первичный ключ</b> &minus; первичный ключ уникален. Значение ключа не может встречаться дважды в одной таблице. С помощью ключа вы можете найти только одну строку.</p></li>\n" +
                "<li><p><b>Внешний ключ</b> &minus; Внешний ключ - это связующий штырь между двумя таблицами.</p></li>\n" +
                "<li><p><b>Составной ключ</b> &minus;  составной ключ - это ключ, состоящий из нескольких столбцов, потому что один столбец недостаточно уникален. </p></li>\n" +
                "<li><p><b>Индекс</b> &minus; Индекс в базе данных напоминает индекс в конце книги. </p></li>\n" +
                "<li><p><b> Ссылочная целостность </b> &minus; ссылочная целостность гарантирует, что значение внешнего ключа всегда указывает на существующую строку. </p></li>\n" +
                "</ul>\n" +
                "<h2>База данных MySQL </h2>\n" +
                "<p> MySQL - это быстрая и простая в использовании РСУБД, используемая для многих малых и крупных предприятий. MySQL разрабатывается, продается и поддерживается MySQL AB, которая является шведской компанией. MySQL становится настолько популярным из-за многих веских причин  &minus;</p>\n" +
                "<ul class=\"list\">\n" +
                "<li><p> MySQL выпущен под лицензией с открытым исходным кодом. Поэтому вам нечего платить, чтобы использовать его. </p></li>\n" +
                "<li><p> MySQL - очень мощная программа сама по себе. Он обрабатывает большой набор функциональных возможностей самых дорогих и мощных пакетов баз данных..</p></li>\n" +
                "<li><p> MySQL использует стандартную форму хорошо известного языка данных SQL. </p></li>\n" +
                "<li><p> MySQL работает во многих операционных системах и на многих языках, включая PHP, PERL, C, C ++, JAVA и т. д. </p></li>\n" +
                "<li><p> MySQL работает очень быстро и хорошо работает даже с большими наборами данных. </p></li>\n" +
                "<li><p> MySQL очень дружит с PHP, самым ценным языком для веб-разработки. </p></li>\n" +
                "<li><p> MySQL поддерживает большие базы данных, до 50 миллионов строк и более в таблице. Предел размера файла по умолчанию для таблицы составляет 4 ГБ, но вы можете увеличить его (если ваша операционная система справится с этим) до теоретического предела в 8 миллионов терабайт (ТБ). </p></li>\n" +
                "<li><p> MySQL настраивается. Лицензия GPL с открытым исходным кодом позволяет программистам изменять программное обеспечение MySQL в соответствии с их конкретными средами. </p></li>\n" +
                "</ul>\n" +
                "<h2>Прежде чем начнете</h2>\n" +
                "<p> Прежде чем начинать этот учебник, вы должны иметь базовые знания в информации, содержащейся в наших учебниках по PHP и HTML. </p>\n" +
                "<p> В этом учебном пособии основное внимание уделяется использованию MySQL в среде PHP. Многие примеры, приведенные в этом уроке, будут полезны для программистов PHP..</p>\n" +
                "<br><br>\n" +
                "</html>\n");


        db.insert(UNITS_TABLE, null, cv);

        cv.put("UNIT_NAME", "Установка  MySQL на Linux/UNIX/Windows");
        cv.put("UNIT_TEXT", "<html>\n" +
                "<style>\n" +
                "select{ border:0 !important; outline: 1px inset black !important; outline-offset: -1px !important; }\n" +
                "ul.nav-list.primary>li a.videolink{    background: none; margin: 0px; padding: 0px; border: 1px solid #d6d6d6;}\n" +
                "div.feature-box div.feature-box-icon, .col-md-3 .course-box, li.heading, div.footer-copyright { background: #004e61 url(/images/pattern.png) repeat center center !important;}\n" +
                ".sub-main-menu .sub-menuu div:hover, .sub-main-menu .viewall, header nav ul.nav-main li a:hover, button.btn-responsive-nav, header div.search button.btn-default { background: #004e61 !important;}\n" +
                ".submenu-item{ border-bottom: 2px solid #004e61 !important; border-top: 2px solid #004e61 !important }\n" +
                ".ace_scroller{overflow: auto!important;}\n" +
                "a.demo{font-family: \"Open Sans\",Arial,sans-serif; background:#004e61; color:#fff; font-size:13px; padding:3px 10px; border:1px solid #d6d6d6; position:absolute; right:5px; margin:-6px 17px 0px 0px;}\n" +
                "a.demo:hover{opacity:.8}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "\n" +
                "<h2>Установка  MySQL на Linux/UNIX</h2>\n" +
                "<p>Рекомендуемый способ установки MySQL в системе Linux - через RPM. MySQL AB делает следующие RPM доступными для загрузки на своем веб-сайте &minus;</p>\n" +
                "<ul class=\"list\">\n" +
                "<li><p><b>MySQL</b> &minus; Сервер базы данных MySQL управляет базами данных и таблицами, контролирует доступ пользователей и обрабатывает SQL-запросы.</p></li>\n" +
                "<li><p><b>MySQL- client </b> &minus; клиентские программы MySQL, которые позволяют подключаться к серверу и взаимодействовать с ним.</p></li>\n" +
                "<li><p><b>MySQL-devel</b> &minus; библиотеки и файлы заголовков, которые пригождаются при компиляции других программ, которые используют MySQL.</p></li>\n" +
                "<li><p><b>MySQL-shared</b> &minus; общие библиотеки для клиента MySQL.</p></li>\n" +
                "<li><p><b>MySQL-bench</b> &minus; инструменты тестирования производительности и производительности для сервера базы данных MySQL.</p></li>\n" +
                "</ul>\n" +
                "<p>Перечисленные здесь MySQL RPM основаны на системе SuSE Linux , но они, как правило, не будут работать с другими вариантами Linux.</p>\n" +
                "<p>Теперь вам нужно будет придерживаться приведенных ниже шагов, чтобы продолжить установку  &minus;</p>\n" +
                "<ul class=\"list\">\n" +
                "<li><p>Войдите в систему, используя пользователя<b>root</b> user.</p></li>\n" +
                "<li><p>Переключитесь в каталог, содержащий RPM..</p></li>\n" +
                "<li><p>Установите сервер базы данных MySQL, выполнив следующую команду. Не забудьте заменить имя файла курсивом на имя файла вашего RPM.</p></li>\n" +
                "</ul>\n" +
                "<pre class=\"result notranslate\">\n" +
                "[root@host]# rpm -i MySQL-5.0.9-0.i386.rpm\n" +
                "</pre>\n" +
                "<p>Вышеупомянутая команда заботится об установке сервера MySQL, создании пользователя MySQL, создании необходимой конфигурации и запуске сервера MySQL автоматически.</p>\n" +
                "<p>Вы можете найти все связанные с MySQL бинарные файлы в / usr / bin и / usr / sbin. Все таблицы и базы данных будут созданы в каталоге / var / lib / mysql..</p>\n" +
                "<ul class=\"list\">\n" +
                "<li><p>В следующем поле кода есть необязательный, но рекомендуемый шаг для установки остальных RPM таким же образом &minus;</p></li>\n" +
                "</ul>\n" +
                "<pre class=\"result notranslate\">\n" +
                "[root@host]# rpm -i MySQL-client-5.0.9-0.i386.rpm\n" +
                "[root@host]# rpm -i MySQL-devel-5.0.9-0.i386.rpm\n" +
                "[root@host]# rpm -i MySQL-shared-5.0.9-0.i386.rpm\n" +
                "[root@host]# rpm -i MySQL-bench-5.0.9-0.i386.rpm\n" +
                "</pre>\n" +
                "<h2>Установка MySQL в Windows</h2>\n" +
                "<p>Установка по умолчанию в любой версии Windows теперь намного проще, чем раньше, поскольку MySQL теперь поставляется в комплекте с установщиком. Просто загрузите пакет установщика, распакуйте его в любом месте и запустите файл setup.exe.</p>\n" +
                "<p>Установленный по умолчанию установщик setup.exe проведет вас через тривиальный процесс и по умолчанию установит все под C: \\ mysql.</Cp>\n" +
                "<p>Протестируйте сервер, выпустив его из командной строки в первый раз. Перейдите в расположение сервера mysqld, который, вероятно, C: \\ mysql \\ bin, и введите &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "mysqld.exe --console\n" +
                "</pre>\n" +
                "<p><b>ПРИМЕЧАНИЕ</b> &minus; Если вы находитесь в NT, вам придется использовать mysqld-nt.exe вместо mysqld.exe</p>\n" +
                "<p>Если все пойдет хорошо, вы увидите сообщения о запуске и InnoDB . Если нет, у вас может быть проблема с правами доступа. Убедитесь, что каталог, в котором хранятся ваши данные, доступен любому пользователю (возможно, MySQL), в котором работают процессы базы данных.</p>\n" +
                "<p>MySQL не добавит себя в меню «Пуск», и нет особого способа GUI для остановки сервера. Поэтому, если вы пытаетесь запустить сервер, дважды щелкнув исполняемый файл mysqld, вы должны помнить о том, чтобы остановить процесс вручную, используя mysqladmin, Task List, Task Manager или другие средства Windows.</p>\n" +
                "<h2>Проверка установки MySQL</h2>\n" +
                "<p>После того, как MySQL был успешно установлен, базовые таблицы были инициализированы и сервер запущен: вы можете проверить, что все работает так, как должно быть, с помощью некоторых простых тестов.</p>\n" +
                "<h3> Используйте утилиту MYSQLADMIN ДЛЯ получения статуса сервера</h3>\n" +
                "<p>Используйте mysqladmin для проверки версии сервера. Этот двоичный файл будет доступен в / usr / bin в linux и в C: \\ mysql \\ bin в окнах.</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "[root@host]# mysqladmin --version\n" +
                "</pre>\n" +
                "<p>Это приведет к следующему результату в Linux. Он может варьироваться в зависимости от вашей установки -&minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "mysqladmin  Ver 8.23 Distrib 5.0.9-0, for redhat-linux-gnu on i386\n" +
                "</pre>\n" +
                "<p>Если вы не получите такое сообщение, может возникнуть какая-то проблема при установке, и вам понадобится помощь в ее устранении.</p>\n" +
                "<h3>Выполнение простых команд  SQL с использованием MySQL Client</h3>\n" +
                "<p>Вы можете подключиться к серверу MySQL через клиент MySQL и с помощью команды mysql . В настоящий момент вам не нужно указывать пароль, поскольку по умолчанию он будет установлен как пустой.</p>\n" +
                "<p>Вы можете использовать следующую команду&minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "[root@host]# mysql\n" +
                "</pre>\n" +
                "<p>Он должен быть вознагражден приглашением mysql>. Теперь вы подключены к серверу MySQL, и вы можете выполнить все команды SQL в приглашении mysql> следующим образом &minus;</p>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "mysql&gt; SHOW DATABASES;\n" +
                "+----------+\n" +
                "| Database |\n" +
                "+----------+\n" +
                "|   mysql  | \n" +
                "|   test   |  \n" +
                "+----------+\n" +
                "2 rows in set (0.13 sec)\n" +
                "</pre>\n" +
                "<h2>Шаги после установки</h2>\n" +
                "<p>MySQL поставляется с пустым паролем для пользователя root MySQL. Как только вы успешно установили базу данных и клиент, вам необходимо установить пароль root, как указано в следующем блоке кода -&minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "[root@host]# mysqladmin -u root password \"new_password\";\n" +
                "</pre>\n" +
                "<p>Теперь, чтобы установить соединение с вашим сервером MySQL, вам придется использовать следующую команду &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "[root@host]# mysql -u root -p\n" +
                "Enter password:*******\n" +
                "</pre>\n" +
                "<p>Пользователи UNIX также захотят разместить ваш каталог MySQL в вашем PATH, поэтому вам не придется постоянно вводить полный путь каждый раз, когда вы хотите использовать клиент командной строки..</p>\n" +
                "<p>Для bash это было бы что-то вроде &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "export PATH = $PATH:/usr/bin:/usr/sbin\n" +
                "</pre>\n" +
                "<h2>Запуск  MySQL во время загрузки</h2>\n" +
                "<p>Если вы хотите запустить сервер MySQL во время загрузки, убедитесь, что у вас есть следующая запись в файле /etc/rc.local.</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "/etc/init.d/mysqld start\n" +
                "</pre>\n" +
                "<p>Кроме того, вы должны иметь двоичный файл mysqld в каталоге /etc/init.d/.</p>\n" +
                "<hr>\n" +
                "<br><br>\n" +
                "</html>\n" +
                "\n");


        db.insert(UNITS_TABLE, null, cv);

        cv.put("UNIT_NAME", "Запуск и выключение MySQL Server");
        cv.put("UNIT_TEXT", "<html>\n" +
                "\n" +
                "<style>\n" +
                "select{ border:0 !important; outline: 1px inset black !important; outline-offset: -1px !important; }\n" +
                ".btnsbmt{ background: #004e61 !important;}\n" +
                "ul.nav-list.primary>li a.videolink{    background: none; margin: 0px; padding: 0px; border: 1px solid #d6d6d6;}\n" +
                "div.feature-box div.feature-box-icon, .col-md-3 .course-box, li.heading, div.footer-copyright { background: #004e61 url(/images/pattern.png) repeat center center !important;}\n" +
                ".sub-main-menu .sub-menuu div:hover, .sub-main-menu .viewall, header nav ul.nav-main li a:hover, button.btn-responsive-nav, header div.search button.btn-default { background: #004e61 !important;}\n" +
                ".submenu-item{ border-bottom: 2px solid #004e61 !important; border-top: 2px solid #004e61 !important }\n" +
                ".ace_scroller{overflow: auto!important;}\n" +
                "a.demo{font-family: \"Open Sans\",Arial,sans-serif; background:#004e61; color:#fff; font-size:13px; padding:3px 10px; border:1px solid #d6d6d6; position:absolute; right:5px; margin:-6px 17px 0px 0px;}\n" +
                "a.demo:hover{opacity:.8}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<hr>\n" +
                "<h2>Запуск и выключение MySQL Server</h2>\n" +
                "<p>Сначала проверьте, работает ли ваш сервер MySQL или нет. Вы можете использовать следующую команду, чтобы проверить это &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "ps -ef | grep mysqld\n" +
                "</pre>\n" +
                "<p>Если ваш MySql запущен, вы увидите, что процесс <b>mysqld</b> указан в вашем результате. Если сервер не запущен, вы можете запустить его, используя следующую команду &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "root@host# cd /usr/bin\n" +
                "./safe_mysqld &amp;\n" +
                "</pre>\n" +
                "<p>Теперь, если вы хотите закрыть уже запущенный сервер MySQL, вы можете сделать это, используя следующую команду &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "root@host# cd /usr/bin\n" +
                "./mysqladmin -u root -p shutdown\n" +
                "Enter password: ******\n" +
                "</pre>\n" +
                "<h2>Настройка учетной записи MySQL </h2>\n" +
                "<p>Для добавления нового пользователя в MySQL вам просто нужно добавить новую запись в пользовательскую таблицу в базе данных mysql . </p>\n" +
                "<p>Следующая программа представляет собой пример добавления нового пользователя<b>гостя</b> с привилегиями SELECT, INSERT и UPDATE с паролем<b>guest123;</b> SQL-запрос&minus;</p>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "root@host# mysql -u root -p\n" +
                "Enter password:*******\n" +
                "mysql&gt; use mysql;\n" +
                "Database changed\n" +
                "\n" +
                "mysql&gt; INSERT INTO user \n" +
                "          (host, user, password, \n" +
                "           select_priv, insert_priv, update_priv) \n" +
                "           VALUES ('localhost', 'guest', \n" +
                "           PASSWORD('guest123'), 'Y', 'Y', 'Y');\n" +
                "Query OK, 1 row affected (0.20 sec)\n" +
                "\n" +
                "mysql&gt; FLUSH PRIVILEGES;\n" +
                "Query OK, 1 row affected (0.01 sec)\n" +
                "\n" +
                "mysql&gt; SELECT host, user, password FROM user WHERE user = 'guest';\n" +
                "+-----------+---------+------------------+\n" +
                "|    host   |   user  |     password     |    \n" +
                "+-----------+---------+------------------+\n" +
                "| localhost |  guest  | 6f8c114b58f2ce9e |\n" +
                "+-----------+---------+------------------+\n" +
                "1 row in set (0.00 sec)\n" +
                "</pre>\n" +
                "<p>При добавлении нового пользователя не забудьте зашифровать новый пароль, используя функцию PASSWORD (), предоставленную MySQL. Как вы можете видеть в приведенном выше примере, пароль mypass зашифрован до 6f8c114b58f2ce9e.</p>\n" +
                "<p>Обратите внимание на заявление FLUSH PRIVILEGES. Это говорит серверу перезагрузить таблицы предоставления. Если вы его не используете, вы не сможете подключиться к MySQL с использованием новой учетной записи пользователя, по крайней мере, до перезагрузки сервера.</p>\n" +
                "<p>Вы также можете указать другие привилегии для нового пользователя, установив значения следующих столбцов в таблице пользователя на «Y» при выполнении запроса INSERT, или вы можете обновить их позже, используя запрос UPDATE.</p>\n" +
                "<ul class=\"list\">\n" +
                "<li>Select_priv</li>\n" +
                "<li>Insert_priv</li>\n" +
                "<li>Update_priv</li>\n" +
                "<li>Delete_priv</li>\n" +
                "<li>Create_priv</li>\n" +
                "<li>Drop_priv</li>\n" +
                "<li>Reload_priv</li>\n" +
                "<li>Shutdown_priv</li>\n" +
                "<li>Process_priv</li>\n" +
                "<li>File_priv</li>\n" +
                "<li>Grant_priv</li>\n" +
                "<li>References_priv</li>\n" +
                "<li>Index_priv</li>\n" +
                "<li>Alter_priv</li>\n" +
                "</ul>\n" +
                "<p>Другим способом добавления учетной записи пользователя является использование команды GRANT SQL. Следующий пример добавит пользовател<b>zara</b> с паролем <b>zara123</b> для конкретной базы данных, которая названа как <b>TUTORIALS</b>.</p>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "root@host# mysql -u root -p password;\n" +
                "Enter password:*******\n" +
                "mysql&gt; use mysql;\n" +
                "Database changed\n" +
                "\n" +
                "mysql&gt; GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP\n" +
                "    -&gt; ON TUTORIALS.*\n" +
                "    -&gt; TO 'zara'@'localhost'\n" +
                "    -&gt; IDENTIFIED BY 'zara123';\n" +
                "</pre>\n" +
                "<p>Это также создаст запись в таблице базы данных MySQL, называемой <b>user</b>.</p>\n" +
                "<p><b>ПРИМЕЧАНИЕ </b> &minus; MySQL не завершает команду до тех пор, пока вы не добавите полуточку (;) в конце команды SQL.</p>\n" +
                "<h2>Конфигурация файла /etc/my.cnf </h2>\n" +
                "<p>В большинстве случаев вы не должны касаться этого файла. По умолчанию он будет иметь следующие записи &minus;</p>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "[mysqld]\n" +
                "datadir = /var/lib/mysql\n" +
                "socket = /var/lib/mysql/mysql.sock\n" +
                "\n" +
                "[mysql.server]\n" +
                "user = mysql\n" +
                "basedir = /var/lib\n" +
                "\n" +
                "[safe_mysqld]\n" +
                "err-log = /var/log/mysqld.log\n" +
                "pid-file = /var/run/mysqld/mysqld.pid\n" +
                "</pre>\n" +
                "<p>Здесь вы можете указать другой каталог для журнала ошибок, иначе вы не должны изменять какую-либо запись в этой таблице.</p>\n" +
                "<h2>Административные команды MySQL </h2>\n" +
                "<p>Вот список важных команд MySQL, которые вы будете использовать время от времени для работы с базой данных MySQL &minus;</p>\n" +
                "<ul class=\"list\">\n" +
                "<li><p><b>USE Databasename</b> &minus; это будет использоваться для выбора базы данных в рабочей области MySQL.</p></li>\n" +
                "<li><p><b>SHOW DATABASES</b> &minus; отображает базы данных, доступные СУБД MySQL.</p></li>\n" +
                "<li><p><b>SHOW TABLES</b> &minus; Показывает таблицы в базе данных после того, как база данных была выбрана с помощью команды use.</p></li>\n" +
                "<li><p><b>SHOW COLUMNS FROM <i>tablename:</i></b> показывает атрибуты, типы атрибутов, информацию о ключах, разрешено ли NULL, значения по умолчанию и другая информация для таблицы </p></li>\n" +
                "<li><p><b>SHOW INDEX FROM tablename</b> &minus; представляет детали всех индексов в таблице, включая PRIMARY KEY.</p></li>\n" +
                "<li><p><b>SHOW TABLE STATUS LIKE tablename\\G</b> &minus; сообщает данные о производительности и статистике СУБД MySQL. </p></li>\n" +
                "</ul>\n" +
                "<p> В следующей главе мы обсудим, как PHP-синтаксис используется в MySQL.</p>\n" +
                "<hr>\n" +
                "<br><br>\n" +
                "</html>\n");


        db.insert(UNITS_TABLE, null, cv);

        cv.put("UNIT_NAME", "Синтаксис PHP MySQL");
        cv.put("UNIT_TEXT", "<html>\n" +
                "\n" +
                "<style>\n" +
                "select{ border:0 !important; outline: 1px inset black !important; outline-offset: -1px !important; }\n" +
                "ul.nav-list.primary>li a.videolink{    background: none; margin: 0px; padding: 0px; border: 1px solid #d6d6d6;}\n" +
                "div.feature-box div.feature-box-icon, .col-md-3 .course-box, li.heading, div.footer-copyright { background: #004e61 url(/images/pattern.png) repeat center center !important;}\n" +
                ".sub-main-menu .sub-menuu div:hover, .sub-main-menu .viewall, header nav ul.nav-main li a:hover, button.btn-responsive-nav, header div.search button.btn-default { background: #004e61 !important;}\n" +
                ".submenu-item{ border-bottom: 2px solid #004e61 !important; border-top: 2px solid #004e61 !important }\n" +
                ".ace_scroller{overflow: auto!important;}\n" +
                "a.demo{font-family: \"Open Sans\",Arial,sans-serif; background:#004e61; color:#fff; font-size:13px; padding:3px 10px; border:1px solid #d6d6d6; position:absolute; right:5px; margin:-6px 17px 0px 0px;}\n" +
                "a.demo:hover{opacity:.8}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<hr>\n" +
                "<p>MySQL работает очень хорошо в сочетании различных языков программирования, таких как PERL, C, C ++, JAVA и PHP. Из этих языков PHP является самым популярным из-за его возможностей разработки веб-приложений.</p>\n" +
                "<p>В этом учебном пособии основное внимание уделяется использованию MySQL в среде PHP. Если вас интересует MySQL с помощью PERL, вы можете рассмотреть возможность чтения учебника PERL .</p>\n" +
                "<p>PHP предоставляет различные функции для доступа к базе данных MySQL и для управления записями данных в базе данных MySQL. Вам нужно будет вызывать функции PHP так же, как вы вызываете любую другую функцию PHP.</p>\n" +
                "<p>Функции PHP для использования с MySQL имеют следующий общий формат &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "mysql_<i>function</i>(value,value,...);\n" +
                "</pre>\n" +
                "<p>Вторая часть имени функции специфична для функции, обычно это слово, которое описывает, что делает функция. Ниже перечислены две функции, которые мы будем использовать в нашем учебнике &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "mysqli_connect($connect);\n" +
                "mysqli_query($connect,\"SQL statement\");\n" +
                "</pre>\n" +
                "<p>В следующем примере показан общий синтаксис PHP для вызова любой функции MySQL.</p>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "&lt;html&gt;\n" +
                "   &lt;head&gt;\n" +
                "      &lt;title&gt;PHP with MySQL&lt;/title&gt;\n" +
                "   &lt;/head&gt;\n" +
                "   &lt;body&gt;\n" +
                "      &lt;?php\n" +
                "         $retval = mysql_<i>function</i>(value, [value,...]);\n" +
                "         if( !$retval ) {\n" +
                "            die ( \"Error: a related error message\" );\n" +
                "         }\n" +
                "         // Otherwise MySQL  or PHP Statements\n" +
                "      ?&gt;\n" +
                "   &lt;/body&gt;\n" +
                "&lt;/html&gt;\n" +
                "</pre>\n" +
                "<p>Начиная со следующей главы, мы увидим все важные функции MySQL вместе с PHP. </p> \n" +
                "<hr>\n" +
                "<br><br>\n" +
                "</html>\n" +
                "\n");


        db.insert(UNITS_TABLE, null, cv);

        cv.put("UNIT_NAME", "Подключение к MySQL");
        cv.put("UNIT_TEXT", "<html>\n" +
                "<style>\n" +
                "select{ border:0 !important; outline: 1px inset black !important; outline-offset: -1px !important; }\n" +
                "ul.nav-list.primary>li a.videolink{    background: none; margin: 0px; padding: 0px; border: 1px solid #d6d6d6;}\n" +
                "div.feature-box div.feature-box-icon, .col-md-3 .course-box, li.heading, div.footer-copyright { background: #004e61 url(/images/pattern.png) repeat center center !important;}\n" +
                ".sub-main-menu .sub-menuu div:hover, .sub-main-menu .viewall, header nav ul.nav-main li a:hover, button.btn-responsive-nav, header div.search button.btn-default { background: #004e61 !important;}\n" +
                ".submenu-item{ border-bottom: 2px solid #004e61 !important; border-top: 2px solid #004e61 !important }\n" +
                ".ace_scroller{overflow: auto!important;}\n" +
                "a.demo{font-family: \"Open Sans\",Arial,sans-serif; background:#004e61; color:#fff; font-size:13px; padding:3px 10px; border:1px solid #d6d6d6; position:absolute; right:5px; margin:-6px 17px 0px 0px;}\n" +
                "a.demo:hover{opacity:.8}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<hr>\n" +
                "<h2>MySQL соединение с использованием  MySQL Binary</h2>\n" +
                "<p>Вы можете установить базу данных MySQL, используя двоичный код mysql в командной строке.</p>\n" +
                "<h3>Пример</h3>\n" +
                "<p>Вот простой пример подключения к серверу MySQL из командной строки &minus;</p>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "[root@host]# mysql -u root -p\n" +
                "Enter password:******\n" +
                "</pre>\n" +
                "<p>Это даст вам командную строкуmysql&gt; где вы сможете выполнить любую команду SQL. Ниже приведен результат вышеуказанной команды&minus;</p>\n" +
                "<p>Следующий блок кода показывает результат выше кода &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "Welcome to the MySQL monitor.  Commands end with ; or \\g.\n" +
                "Your MySQL connection id is 2854760 to server version: 5.0.9\n" +
                "\n" +
                "Type 'help;' or '\\h' for help. Type '\\c' to clear the buffer.\n" +
                "</pre>\n" +
                "<p>В приведенном выше примере мы использовали пользователя root как пользователь, но вы также можете использовать любого другого пользователя. Любой пользователь сможет выполнять все операции SQL, которые разрешены для этого пользователя.</p>\n" +
                "<p>Вы можете отключиться от базы данных MySQL в любое время, используя команду <b>exit</b> command at mysql&gt; prompt.</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "mysql&gt; exit\n" +
                "Bye\n" +
                "</pre>\n" +
                "<h2>Подключение MySQL с использованием PHP Script</h2>\n" +
                "<p>PHP предоставляет функцию<b>mysql_connect()</b> чтобы открыть соединение с базой данных. Эта функция принимает пять параметров и возвращает идентификатор ссылки MySQL при успешном завершении или FALSE при сбое.</p>\n" +
                "<h3>Синтаксис</h3>\n" +
                "<pre class=\"result notranslate\">\n" +
                "connection mysql_connect(server,user,passwd,new_link,client_flag);\n" +
                "</pre>\n" +
                "<p>\n" +
                "<table class=\"table table-bordered\"> \n" +
                "<tr>\n" +
                "<th style=\"width:11%;\">S. No.</th>\n" +
                "<th style=\"text-align:center;\">Параметрr &amp; Описание</th>\n" +
                "</tr>  \n" +
                "<tr>\n" +
                "<td style=\"text-align:center;vertical-align:middle;\">1</td>\n" +
                "<td>\n" +
                "<p><b>server </b></p>\n" +
                "<p>Необязательно. Имя узла, на котором запущен сервер базы данных. Если не указано, значение по умолчанию будет <b>localhost:3306</b>.</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"text-align:center;vertical-align:middle;\">2</td>\n" +
                "<td>\n" +
                "<p><b>user</b></p>\n" +
                "<p>Необязательно. Имя пользователя, доступ к базе данных. Если не указано, то по умолчанию будет имя пользователя, которому принадлежит серверный процесс.</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"text-align:center;vertical-align:middle;\">3</td>\n" +
                "<td>\n" +
                "<p><b>passwd</b></p>\n" +
                "<p>Необязательно. Пароль пользователя, обращающегося к базе данных. Если не указано, то по умолчанию будет пустой пароль.</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"text-align:center;vertical-align:middle;\">4</td>\n" +
                "<td>\n" +
                "<p><b>new_link</b></p>\n" +
                "<p>Необязательно. Если второй вызов выполняется с помощью mysql_connect () с теми же аргументами, новое соединение не будет установлено; вместо этого будет возвращен идентификатор уже открытого соединения.</p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"text-align:center;vertical-align:middle;\">5</td>\n" +
                "<td>\n" +
                "<p><b>client_flags</b></p>\n" +
                "<p>Необязательно &minus; комбинация следующих констант &minus;</p>\n" +
                "<ul class=\"list\">\n" +
                "<li><p>MYSQL_CLIENT_SSL &minus; Использовать шифрование SSL.</p></li>\n" +
                "<li><p>MYSQL_CLIENT_COMPRESS &minus; Использовать протокол сжатия.</p></li>\n" +
                "<li><p>MYSQL_CLIENT_IGNORE_SPACE &minus; разрешить пробел после имен функций.</p></li>\n" +
                "<li><p>MYSQL_CLIENT_INTERACTIVE &minus; разрешить интерактивные таймауты секунд бездействия до закрытия соединения.</p></li>\n" +
                "</ul>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<p>Вы можете отключиться от базы данных MySQL в любое время, используя другую функцию PHP<b>mysql_close()</b>. Эта функция принимает единственный параметр, который является соединением, возвращаемым функцией  <b>mysql_connect()</b> .</p>\n" +
                "<h3>Синтаксис</h3>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "bool mysql_close ( resource $link_identifier );\n" +
                "</pre>\n" +
                "<p>Если ресурс не указан, то последняя открытая база данных будет закрыта. Эта функция возвращает true, если она успешно закрывает соединение, иначе возвращает false.</p>\n" +
                "<h3>Пример</h3>\n" +
                "<p>Попробуйте следующий пример подключения к MySQL server &minus;</p>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "&lt;html&gt;\n" +
                "   &lt;head&gt;\n" +
                "      &lt;title&gt;Connecting MySQL Server&lt;/title&gt;\n" +
                "   &lt;/head&gt;\n" +
                "   &lt;body&gt;\n" +
                "      &lt;?php\n" +
                "         $dbhost = 'localhost:3306';\n" +
                "         $dbuser = 'guest';\n" +
                "         $dbpass = 'guest123';\n" +
                "         $conn = mysql_connect($dbhost, $dbuser, $dbpass);\n" +
                "         if(! $conn ) {\n" +
                "            die('Could not connect: ' . mysql_error());\n" +
                "         }\n" +
                "         echo 'Connected successfully';\n" +
                "         mysql_close($conn);\n" +
                "      ?&gt;\n" +
                "   &lt;/body&gt;\n" +
                "&lt;/html&gt;\n" +
                "</pre>\n" +
                "<hr>\n" +
                "<br><br>\n" +
                "</html>\n" +
                "\n");

        db.insert(UNITS_TABLE, null, cv);

        cv.put("UNIT_NAME", "Создание базы данных в MySQL");
        cv.put("UNIT_TEXT", "<html>\n" +
                "\n" +
                "<style>\n" +
                "select{ border:0 !important; outline: 1px inset black !important; outline-offset: -1px !important; }\n" +
                "ul.nav-list.primary>li a.videolink{    background: none; margin: 0px; padding: 0px; border: 1px solid #d6d6d6;}\n" +
                "div.feature-box div.feature-box-icon, .col-md-3 .course-box, li.heading, div.footer-copyright { background: #004e61 url(/images/pattern.png) repeat center center !important;}\n" +
                ".sub-main-menu .sub-menuu div:hover, .sub-main-menu .viewall, header nav ul.nav-main li a:hover, button.btn-responsive-nav, header div.search button.btn-default { background: #004e61 !important;}\n" +
                ".submenu-item{ border-bottom: 2px solid #004e61 !important; border-top: 2px solid #004e61 !important }\n" +
                ".ace_scroller{overflow: auto!important;}\n" +
                "a.demo{font-family: \"Open Sans\",Arial,sans-serif; background:#004e61; color:#fff; font-size:13px; padding:3px 10px; border:1px solid #d6d6d6; position:absolute; right:5px; margin:-6px 17px 0px 0px;}\n" +
                "a.demo:hover{opacity:.8}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<hr>\n" +
                "<h2>Создание базы данных с помощью mysqladmin</h2>\n" +
                "<p>Для создания или удаления базы данных MySQL вам понадобятся специальные привилегии. Поэтому, предполагая, что у вас есть доступ к пользователю root, вы можете создать любую базу данных с помощью mysql <b>mysqladmin</b> binary.</p>\n" +
                "<h3>Пример</h3>\n" +
                "<p>Вот простой пример создания базы данных под названием<b>TUTORIALS</b> &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "[root@host]# mysqladmin -u root -p create TUTORIALS\n" +
                "Enter password:******\n" +
                "</pre>\n" +
                "<p>Это создаст базу данных MySQL под названием TUTORIALS.</p>\n" +
                "<h2>Создание базы данных с использованием PHP Script</h2>\n" +
                "<p>PHP использует функцию<b>mysql_query</b> для создания или удаления базы данных MySQL. Эта функция принимает два параметра и возвращает TRUE при успешном завершении или FALSE при сбое.</p>\n" +
                "<h3>Синтаксис</h3>\n" +
                "<pre class=\"result notranslate\">\n" +
                "bool mysql_query( sql, connection );\n" +
                "</pre>\n" +
                "<p>\n" +
                "<table class=\"table table-bordered\">\n" +
                "<tr>\n" +
                "<th style=\"width:11%;\">S. No.</th>\n" +
                "<th style=\"text-align:center;\">Параметры &amp; Описапние</th>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>sql</td>\n" +
                "<td>Обязательный - SQL-запрос для создания или удаления базы данных MySQL</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>connection</td>\n" +
                "<td>Необязательно - если не указано, будет использовано последнее открытое соединение mysql_connect.</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<h3>Пример</h3>\n" +
                "<p>TСледующий пример создания базы данных &minus;</p>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "&lt;html&gt;\n" +
                "   &lt;head&gt;\n" +
                "      &lt;title&gt;Creating MySQL Database&lt;/title&gt;\n" +
                "   &lt;/head&gt;\n" +
                "   &lt;body&gt;\n" +
                "      &lt;?php\n" +
                "         $dbhost = 'localhost:3036';\n" +
                "         $dbuser = 'root';\n" +
                "         $dbpass = 'rootpassword';\n" +
                "         $conn = mysql_connect($dbhost, $dbuser, $dbpass);\n" +
                "         if(! $conn ) {\n" +
                "            die('Could not connect: ' . mysql_error());\n" +
                "         }\n" +
                "         echo 'Connected successfully&lt;br /&gt;';\n" +
                "         $sql = 'CREATE DATABASE TUTORIALS';\n" +
                "         $retval = mysql_query( $sql, $conn );\n" +
                "         if(! $retval ) {\n" +
                "            die('Could not create database: ' . mysql_error());\n" +
                "         }\n" +
                "         echo \"Database TUTORIALS created successfully\\n\";\n" +
                "         mysql_close($conn);\n" +
                "      ?&gt;\n" +
                "   &lt;/body&gt;\n" +
                "&lt;/html&gt;\n" +
                "</pre>\n" +
                "<hr>\n" +
                "<br><br>\n" +
                "</html>\n" +
                "\n");

        db.insert(UNITS_TABLE, null, cv);

        /*cv.put("UNIT_NAME", "");
        cv.put("UNIT_TEXT", "");

        db.insert(UNITS_TABLE, null, cv);*/

        cv.put("UNIT_NAME", "Удаление базы данных в MySQL");
        cv.put("UNIT_TEXT", "<html>\n" +
                "<style>\n" +
                "select{ border:0 !important; outline: 1px inset black !important; outline-offset: -1px !important; }\n" +
                "ul.nav-list.primary>li a.videolink{    background: none; margin: 0px; padding: 0px; border: 1px solid #d6d6d6;}\n" +
                "div.feature-box div.feature-box-icon, .col-md-3 .course-box, li.heading, div.footer-copyright { background: #004e61 url(/images/pattern.png) repeat center center !important;}\n" +
                ".sub-main-menu .sub-menuu div:hover, .sub-main-menu .viewall, header nav ul.nav-main li a:hover, button.btn-responsive-nav, header div.search button.btn-default { background: #004e61 !important;}\n" +
                ".submenu-item{ border-bottom: 2px solid #004e61 !important; border-top: 2px solid #004e61 !important }\n" +
                ".ace_scroller{overflow: auto!important;}\n" +
                "a.demo{font-family: \"Open Sans\",Arial,sans-serif; background:#004e61; color:#fff; font-size:13px; padding:3px 10px; border:1px solid #d6d6d6; position:absolute; right:5px; margin:-6px 17px 0px 0px;}\n" +
                "a.demo:hover{opacity:.8}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<hr>\n" +
                "<h2>Удаление базы данных с помощью mysqladmin</h2>\n" +
                "<p>Для создания или удаления базы данных MySQL вам понадобятся специальные привилегии. Итак, если у вас есть доступ к пользователю root, вы можете создать любую базу данных, используя двоичный mysql<b>mysqladmin</b> .</p>\n" +
                "<p>Будьте осторожны при удалении любой базы данных, потому что вы потеряете все данные, доступные в вашей базе данных.</p>\n" +
                "<p>Ниже приведен пример удаления базы данных (TUTORIALS), созданной в предыдущей главе &minus;</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "[root@host]# mysqladmin -u root -p drop TUTORIALS\n" +
                "Enter password:******\n" +
                "</pre>\n" +
                "<p>Это даст вам предупреждение, и оно подтвердит, действительно ли вы хотите удалить эту базу данных или нет.</p>\n" +
                "<pre class=\"result notranslate\">\n" +
                "Dropping the database is potentially a very bad thing to do.\n" +
                "Any data stored in the database will be destroyed.\n" +
                "\n" +
                "Do you really want to drop the 'TUTORIALS' database [y/N] y\n" +
                "Database \"TUTORIALS\" dropped\n" +
                "</pre>\n" +
                "<h2>Удаление базы данных с помощью PHP Script</h2>\n" +
                "<p>PHP использует функцию<b>mysql_query</b>для создания или удаления базы данных MySQL. Эта функция принимает два параметра и возвращает TRUE при успешном завершении или FALSE при сбое..</p>\n" +
                "<h3>Синтаксис</h3>\n" +
                "<pre class=\"result notranslate\">\n" +
                "bool mysql_query( sql, connection );\n" +
                "</pre>\n" +
                "<br>\n" +
                "<table class=\"table table-bordered\">\n" +
                "<tr>\n" +
                "<th style=\"text-align:center;\">Параметр</th>\n" +
                "<th style=\"text-align:center;\">Описание</th>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>sql</td>\n" +
                "<td>Обязательный - SQL-запрос для создания или удаления базы данных MySQL</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>connection</td>\n" +
                "<td>Необязательно - если не указано, будет использовано последнее открытое соединение mysql_connect.</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<h3>Пример</h3>\n" +
                "<p>Попробуйте следующий пример, чтобы удалить базу данных &minus;</p>\n" +
                "<pre class=\"prettyprint notranslate\">\n" +
                "&lt;html&gt;\n" +
                "   &lt;head&gt;\n" +
                "      &lt;title&gt;Deleting MySQL Database&lt;/title&gt;\n" +
                "   &lt;/head&gt;\n" +
                "   &lt;body&gt;\n" +
                "      &lt;?php\n" +
                "         $dbhost = 'localhost:3036';\n" +
                "         $dbuser = 'root';\n" +
                "         $dbpass = 'rootpassword';\n" +
                "         $conn = mysql_connect($dbhost, $dbuser, $dbpass);\n" +
                "         if(! $conn ) {\n" +
                "            die('Could not connect: ' . mysql_error());\n" +
                "         }\n" +
                "         echo 'Connected successfully&lt;br /&gt;';\n" +
                "         $sql = 'DROP DATABASE TUTORIALS';\n" +
                "         $retval = mysql_query( $sql, $conn );\n" +
                "         if(! $retval ) {\n" +
                "            die('Could not delete database: ' . mysql_error());\n" +
                "         }\n" +
                "         echo \"Database TUTORIALS deleted successfully\\n\";\n" +
                "         mysql_close($conn);\n" +
                "      ?&gt;\n" +
                "   &lt;/body&gt;\n" +
                "&lt;/html&gt;\n" +
                "</pre>\n" +
                "<p><b>ПРЕДУПРЕЖДЕНИЕ</b> &minus; При удалении базы данных с использованием PHP-скрипта она не запрашивает подтверждения. Поэтому будьте осторожны при удалении базы данных MySQL.</p>\n" +
                "<hr>\n" +
                "<br><br>\n" +
                "</html>\n" +
                "\n");

        db.insert(UNITS_TABLE, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + UNITS_TABLE);
            onCreate(db);
        }
    }

    @Override
    public Observable<Unit> getUnits() {

        List<Unit> units = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.query(UNITS_TABLE,
                new String[]{"_id", "UNIT_NAME", "UNIT_TEXT"},
                null,
                null,
                null, null, null);

        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("_id");
            int unitNameIndex = c.getColumnIndex("UNIT_NAME");
            int unitTextIndex = c.getColumnIndex("UNIT_TEXT");
            do {
                Unit unit = new Unit();
                unit.setId(Integer.valueOf(c.getString(idColIndex)));
                unit.setName(c.getString(unitNameIndex));
                unit.setText(c.getString(unitTextIndex));
                units.add(unit);

            } while (c.moveToNext());
        }

        c.close();

        return Observable.fromIterable(units);
    }
}
