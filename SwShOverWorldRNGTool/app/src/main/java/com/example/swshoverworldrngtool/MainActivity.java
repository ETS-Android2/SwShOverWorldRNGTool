package com.example.swshoverworldrngtool;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.swshoverworldrngtool.ui.main.SectionsPagerAdapter;
import com.example.swshoverworldrngtool.databinding.ActivityMainBinding;

import com.example.swshoverworldrngtool.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'swshoverworldrngtool' library on application startup.
    static {
        System.loadLibrary("swshoverworldrngtool");
    }

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding binding;

    public static final String EXTRA_MESSAGE =
            "com.example.android.swshoverworldrngtool.extra.MESSAGE";
    public static final String EXTRA_MESSAGE1 =
            "com.example.android.swshoverworldrngtool.extra.MESSAGE1";
    public static final int TEXT_REQUEST = 1;
    private EditText mMessages0;
    private EditText mMessages1;
    private EditText tsv;
    private EditText trv;
    private CheckBox shiny;
    private CheckBox mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mMessages0 = findViewById(R.id.s0);
        mMessages1 = findViewById(R.id.s1);
        shiny = findViewById(R.id.shinycharm);
        mark = findViewById(R.id.markcharm);
        tsv = findViewById(R.id.tsv);
        trv = findViewById(R.id.trv);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        // Restore the state.
        if (savedInstanceState != null) {
            mMessages0.setText(savedInstanceState.getString("s0_text"));
            mMessages1.setText(savedInstanceState.getString("s1_text"));
//            if(savedInstanceState.getBoolean("ShinyCharm")){
//                shiny.setChecked(true);
//            }
//            if(savedInstanceState.getBoolean("MarkCharm")){
//                mark.setChecked(true);
//            }
//            tsv.setText(savedInstanceState.getString("tsv"));
//            trv.setText(savedInstanceState.getString("trv"));
        }
    }



//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("s0_text",mMessages0.getText().toString());
//        outState.putString("s1_text",mMessages1.getText().toString());
//        outState.putBoolean("MarkCharm", mark.isChecked());
//        outState.putBoolean("ShinyCharm", shiny.isChecked());
//        outState.putString("tsv",tsv.getText().toString());
//        outState.putString("trv",trv.getText().toString());
//    }


    public void onclickState(View view) {
        Intent intent = new Intent(this, State_Search.class);
        mMessages0 = findViewById(R.id.s0);
        mMessages1 = findViewById(R.id.s1);
        String message0 = mMessages0.getText().toString();
        String message1 = mMessages1.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message0)
        .putExtra(EXTRA_MESSAGE1, message1);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onclickSetting(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply0 = data.getStringExtra(State_Search.EXTRA_REPLY);
                String reply1 = data.getStringExtra(State_Search.EXTRA_REPLY1);
                mMessages0 = findViewById(R.id.s0);
                mMessages1 = findViewById(R.id.s1);
                mMessages0.setText(reply0);
                mMessages1.setText(reply1);
            }
        }
    }

    public void onclickMainSearch(View view) {

        EditText st0 = findViewById(R.id.s0);
        String s0 = st0.getText().toString();
        EditText st1 = findViewById(R.id.s1);
        String s1 = st1.getText().toString();

        EditText advmin = findViewById(R.id.advmin);
        EditText advmax = findViewById(R.id.advmax);
        long  MinAdv = Long.parseLong(advmin.getText().toString());
        long MaxAdv = Long.parseLong(advmax.getText().toString());
        EditText tsv = findViewById(R.id.tsv);
        EditText trv = findViewById(R.id.trv);
        CheckBox shiny = findViewById(R.id.shinycharm);
        CheckBox mark = findViewById(R.id.markcharm);
        CheckBox weather = findViewById(R.id.weather);
        int TSV = Integer.parseInt(tsv.getText().toString());
        String tsvs =trv.getText().toString();
        int TRV = Integer.parseInt(tsvs, 16); // 16進数
        boolean ShinyCharm = shiny.isChecked();
        boolean MarkCharm  = mark.isChecked();
        boolean Weather    = weather.isChecked();
        CheckBox isStatic = findViewById(R.id.statickcheck);
        boolean Static     = isStatic.isChecked();

        CheckBox fishing = findViewById(R.id.fishing);
        CheckBox helditem = findViewById(R.id.randomItem);
        boolean   Fishing       = fishing.isChecked();
        boolean   HeldItem      = helditem.isChecked();

        EditText Lvmin = findViewById(R.id.LvMin);
        EditText Lvmax = findViewById(R.id.LvMax);
        EditText slotmin = findViewById(R.id.SlotMin);
        EditText slotmax = findViewById(R.id.SlotMax);

        int LevelMin = Integer.parseInt(Lvmin.getText().toString());
        int LevelMax = Integer.parseInt(Lvmax.getText().toString());

        int SlotMin = Integer.parseInt(slotmin.getText().toString());
        int SlotMax = Integer.parseInt(slotmax.getText().toString());

        EditText hmin = findViewById(R.id.hmin);
        EditText hmax = findViewById(R.id.hmax);
        EditText amin = findViewById(R.id.amin);
        EditText amax = findViewById(R.id.amax);
        EditText bmin = findViewById(R.id.bmin);
        EditText bmax = findViewById(R.id.bmax);
        EditText cmin = findViewById(R.id.cmin);
        EditText cmax = findViewById(R.id.cmax);
        EditText dmin = findViewById(R.id.dmin);
        EditText dmax = findViewById(R.id.dmax);
        EditText smin = findViewById(R.id.smin);
        EditText smax = findViewById(R.id.smax);

        int[] MinIVs = new int[6];
        int[] MaxIVs = new int[6];

        MinIVs[0] = Integer.parseInt(hmin.getText().toString());
        MaxIVs[0] = Integer.parseInt(hmax.getText().toString());
        MinIVs[1] = Integer.parseInt(amin.getText().toString());
        MaxIVs[1] = Integer.parseInt(amax.getText().toString());
        MinIVs[2] = Integer.parseInt(bmin.getText().toString());
        MaxIVs[2] = Integer.parseInt(bmax.getText().toString());
        MinIVs[3] = Integer.parseInt(cmin.getText().toString());
        MaxIVs[3] = Integer.parseInt(cmax.getText().toString());
        MinIVs[4] = Integer.parseInt(dmin.getText().toString());
        MaxIVs[4] = Integer.parseInt(dmax.getText().toString());
        MinIVs[5] = Integer.parseInt(smin.getText().toString());
        MaxIVs[5] = Integer.parseInt(smax.getText().toString());

        CheckBox ability = findViewById(R.id.isabilitylocked);
//        EditText EggMoveCount = findViewById(R.id.EggMoveCount);
        EditText kos = findViewById(R.id.KOs);

        boolean IsAbilityLocked = ability.isChecked();
        int EggMoveCount    = 0;
        int KOs             = Integer.parseInt(kos.getText().toString());

        CheckBox legendary = findViewById(R.id.legendary);
        int FlawlessIVs;
        if(legendary.isChecked()){
            FlawlessIVs     = 3;
        }else{
            FlawlessIVs     = 0;
        }
//        CheckBox shinylocked = findViewById(R.id.shinylocked);
        boolean IsShinyLocked   = false;
        CheckBox cutecharm = findViewById(R.id.cutecharm);
        boolean IsCuteCharm     = cutecharm.isChecked();
        CheckBox tsvsearch = findViewById(R.id.TSVsearch);
        boolean TSVSearch       = tsvsearch.isChecked();

        EditText desiredmark = findViewById(R.id.desiredMark);
        EditText desiredshiny = findViewById(R.id.desiredShiny);
        EditText desirednature = findViewById(R.id.desiredNature);

        String DesiredMark   = desiredmark.getText().toString();
        String DesiredShiny  = desiredshiny.getText().toString();
//        String DesiredShiny  = "Ignore";
        String DesiredNature = desirednature.getText().toString();


        if(LevelMax < LevelMin || SlotMax < SlotMin){
            toastError();
            return;
        }
        for(int i=0; i<6; i++){
            if(MaxIVs[i] < MinIVs[i]){
                toastError();
                return;
            }
        }

        // call to a native method
        TextView tv = findViewById(R.id.resultView);
        String Result = resultFromJNI(
                s0, s1, MinAdv, MaxAdv, TSV, TRV, ShinyCharm, MarkCharm,
                Weather, Static, Fishing, HeldItem, DesiredMark, DesiredShiny,
                DesiredNature, LevelMin, LevelMax, SlotMin, SlotMax, MinIVs, MaxIVs,
                IsAbilityLocked, EggMoveCount, KOs, FlawlessIVs, IsCuteCharm,
                IsShinyLocked, TSVSearch);

//        String Result = stringFromJNI();
        if(Result != null) {
            tv.setText(Result);
        }

        // 検索完了！
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    private void toastError() {
        Toast toast = Toast.makeText(this, R.string.toast_errormessage,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public native String resultFromJNI(String state0, String state1
            , long AdvMin, long AdvMax, int TSV, int TRV, boolean ShinyCharm
            , boolean MarkCharm, boolean Weather, boolean Static, boolean Fishing
            , boolean HeldItem, String DesiredMark, String DesiredShiny, String DesiredNature
            , int LevelMin, int LevelMax, int SlotMin, int SlotMax, int[] MinIVs, int[] MaxIVs
            , boolean IsAbilityLocked, int EggMoveCount, int KOs, int FlawlessIVs
            , boolean IsCuteCharm, boolean IsShinyLocked, boolean TSVSearch);

//    public native String stringFromJNI();
}