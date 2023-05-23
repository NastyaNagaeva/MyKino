package com.example.mykino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText username, password;

    Button buttonLogin;

    DBHelper myDBUser;

    private String usernameActivity;
    private Boolean registeredUser = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //появляется стрелка назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = (EditText) findViewById(R.id.usernameSignIn);
        password = (EditText) findViewById(R.id.passwordSignIn);

        myDBUser = new DBHelper(this);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(view -> {

            String user = username.getText().toString();
            String pass = password.getText().toString();

            //если какое-то из  полей незаплнено выводим соответсвуещее значение
            if (user.equals("")||pass.equals("")){
                Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
            }
            else{

                //проверям существует ли такое юзер с таким именем уже в бд
                Boolean userCheckResult = myDBUser.checkUsername(user);
                if (userCheckResult == false){
                    Toast.makeText(this, "Пользователя не существует! Зарегистрируйтесь!", Toast.LENGTH_SHORT).show();
                }
                else {
                    //проверяем совпадает ли пароль с именем
                    Boolean userPassCheckResult = myDBUser.checkUsernamePassword(user, pass);
                    if (userPassCheckResult == false){
                        Toast.makeText(this, "Пароль не верный!", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        //передаем булеан, что польлзователь зарегистрирован
                        registeredUser = true;
                        BaseActivity baseActivity = new BaseActivity();
                        baseActivity.setRegisteredUser(registeredUser);


                        Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT).show();
                        sendName();

                        //startActivity(new Intent(getApplicationContext(), AccountActivity.class));

                    }
                }
            }
        });


    }
    public void sendName()
    {
        //trim() – возвращает копию строки с пропущенными начальными и конечными пробелами
        usernameActivity = username.getText().toString().trim();

        //выхывает AccountActivity и передает имя юзера
        Intent intent = new Intent(this,AccountActivity.class);
        intent.putExtra(AccountActivity.USERNAME, usernameActivity);

        startActivity(intent);
    }

}