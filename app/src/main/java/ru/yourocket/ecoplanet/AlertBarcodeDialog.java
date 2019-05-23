package ru.yourocket.ecoplanet;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.widget.Toast;

/** класс, содержащий в себе метод задания штрихкода
 * и метод для создания диалогового окна
 */

public class AlertBarcodeDialog extends AppCompatDialogFragment {
    private String message;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder;
        String title = "Подтвердите правильность распознавания";
        String button1String = "Подтвердить";
        String button2String = "Отмена";

        //final Context context = ScannerActivity.this;

        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);  // заголовок
        builder.setMessage(message); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(getActivity(), "Вы сделали правильный выбор",
                        Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(getActivity(), "Возможно вы правы", Toast.LENGTH_LONG)
                        .show();
            }
        });
        builder.setCancelable(true);
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(getActivity(), "Вы ничего не выбрали",
                        Toast.LENGTH_LONG).show();
            }
        });
        return builder.create();
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

}
