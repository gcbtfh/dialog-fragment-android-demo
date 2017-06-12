package demo.perfsoft.com.dialogfragmentdemo;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tong Hung on 17-May-17.
 * Copyright (C) SFR Software.
 */

public class MyCustomDialogFragment extends DialogFragment implements View.OnClickListener {
    private EditText et;
    private Button btn;
    private OnTextSubmit onTextSubmit;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.custom_dialog_layout);

        et = (EditText) dialog.findViewById(R.id.etDialog);
        btn = (Button) dialog.findViewById(R.id.btnSendDialog);
        btn.setOnClickListener(this);

        return dialog;
    }

    @Override
    public void onClick(View v) {
        onTextSubmit.onTextSubmitted(et.getText().toString());
        dismiss();
    }

    public void setOnTextSubmit(OnTextSubmit onTextSubmit){
        this.onTextSubmit = onTextSubmit;
    }

    public interface OnTextSubmit {
        void onTextSubmitted(String value);
    }
}
