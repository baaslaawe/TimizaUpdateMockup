package android.designimpactgroup.com.timiza2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainMenuActivity extends FragmentActivity {

    TextView txtContent;
    Runnable progressRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    protected void onStart() {
        super.onStart();
        final Activity activity = this;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Inflate and set the layout for the dialog; pass null as the parent view because its going in the dialog layout
        //final View dialogView = inflater.inflate(R.layout.number_response_dialog, null);
        builder.setMessage(R.string.LanguageSelect)
                // Add action buttons
                .setPositiveButton(R.string.Swahili, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Start Swahili dialogs
                        FirstScreen();
                    }
                })
                .setNegativeButton(R.string.English, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Start English dialogs
                        Intent intent = new Intent(activity, EnglishMainMenuActivity.class);
                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void FirstScreen() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog; pass null as the parent view because its going in the dialog layout
        final View dialogView = inflater.inflate(R.layout.number_response_dialog, null);
        builder.setView(dialogView)
                .setMessage(R.string.MainTimizaMenu)
                        // Add action buttons
                .setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Send number to next dialog
                        String choice = getMenuChoice(dialogView);
                        if (choice.equals("1")) {
                            TimizaLoginPIN();
                        } else {
                            //Do nothing
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // End session
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void TimizaLoginPIN() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.number_response_dialog, null);

        builder.setView(dialogView)
                .setMessage(R.string.AirtelMoneyLogin)
                        // Add action buttons
                .setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String choice = getMenuChoice(dialogView);
                        if (choice.equals(null)) {
                            //PIN doesn't matter, just go to next dialog
                            Signup1();
                        } else {
                            //They entered some kind of PIN so advance to next dialog, first signup tutorial page
                            Signup1();
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // End session
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void Signup1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.number_response_dialog, null);

        builder.setView(dialogView)
                .setMessage(R.string.SignupTutorial_1)
                        // Add action buttons
                .setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String choice = getMenuChoice(dialogView);
                        if (choice.equals("1")) {
                            Signup2();
                        } else if (choice.equals("*")){
                            FirstScreen();
                        } else {
                            //Do nothing
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // End session
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void Signup2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.number_response_dialog, null);

        builder.setView(dialogView)
                .setMessage(R.string.SignupTutorial_2)
                        // Add action buttons
                .setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String choice = getMenuChoice(dialogView);
                        if (choice.equals("1")) {
                            Signup3();
                        } else if (choice.equals("*")){
                            Signup1();
                        } else {
                            //Do nothing
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // End session
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void Signup3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.number_response_dialog, null);

        builder.setView(dialogView)
                .setMessage(R.string.SignupTutorial_3)
                        // Add action buttons
                .setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String choice = getMenuChoice(dialogView);
                        if (choice.equals("1")) {
                            Signup4();
                        } else if (choice.equals("*")){
                            Signup2();
                        } else {
                            //Do nothing
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // End session
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void Signup4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.number_response_dialog, null);

        builder.setView(dialogView)
                .setMessage(R.string.SignupTutorial_4)
                        // Add action buttons
                .setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String choice = getMenuChoice(dialogView);
                        if (choice.equals("1")) {
                            AcceptTandC();
                        } else if (choice.equals("*")){
                            Signup3();
                        } else {
                            //Do nothing
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // End session
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void AcceptTandC() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.number_response_dialog, null);

        builder.setView(dialogView)
                .setMessage(R.string.AcceptTandC)
                        // Add action buttons
                .setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String choice = getMenuChoice(dialogView);
                        if (choice.equals("1")) {
                            AcceptedTandC();
                        } else if (choice.equals("2")){
                            TandCcanceled();
                        } else if (choice.equals("*")){
                            Signup4();
                        } else {
                            //Do nothing
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // End session
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void AcceptedTandC() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.TandCaccepted)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void TandCcanceled() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.TandCcanceled)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    //Get user input from EditText box
    public String getMenuChoice(View v) {
        final EditText et = (EditText) v.findViewById(R.id.choice);
        String choice = et.getText().toString();
        return choice;
    }

    //ProgressDialog that displays for two seconds between Dialogs, indicates "USSD code is running"
    public void USSDprogressDialog(Runnable runnable) {
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("USSD code running...");
        progress.show();

        Handler handler = new Handler();
        handler.postDelayed(runnable, 2000);
    }
}
