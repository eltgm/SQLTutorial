package ru.tihonov.sqltutorial.presentation.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import ru.tihonov.sqltutorial.R;

public class MainActivity extends AppCompatActivity {
    //основной класс приложения, необходимый для инициализации контейнера
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) //если активити не было создано раньше - создаем фрагмент и добавляем транзакцию по замене экрана
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flMain, new UnitsFragment())
                    .commit();
    }

    @Override
    public void onBackPressed() { //обработка нажатия кнопки "НАЗАД"
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) { //если на экране не экран с уроками - переходим на него
            getSupportFragmentManager().popBackStack();
            setTitle("Home");
        } else
            openQuitDialog(); // иначе открываем диалог для подтверждения выхода из приложения
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                this);
        quitDialog.setTitle("Выход: Вы уверены?");

        quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        quitDialog.show();
    }
}
