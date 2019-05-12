package com.example.vitelcoarge.LoginController;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.vitelcoarge.MainActivity;
import com.example.vitelcoarge.R;
import com.example.vitelcoarge.UI.LoginActivityUI;

public class CustomLogin {
    private Context context;
    public void logIn(View view) {

        if(LoginActivityUI.name.getText().toString().equalsIgnoreCase("Vitelco")&&LoginActivityUI.password.getText().toString().equalsIgnoreCase("12345")){
            Intent intent = new Intent();
            intent.setClass(view.getContext(), MainActivity.class);
            this.context.startActivity(new Intent(this.context,MainActivity.class));
            //finish();
        }
        else{
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this.context, R.style.AlertDialogStyle);

            dlgAlert.setMessage("Yanlış kullanıcı adı veya şifre girdiniz.");
            dlgAlert.setTitle("Giriş yapılamadı");
            dlgAlert.setPositiveButton("Tekrar dene", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
    }
}