package nova.samplecheckbox;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listview;
        CustomChoiceListViewAdapter adapter;

        // Adapter 생성
        adapter = new CustomChoiceListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.day1),
                "Account Box Black 36dp");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.day2),
                "Account Circle Black 36dp");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.day3),
                "Assignment Ind Black 36dp");


    }
    public void onClick(View v) {
        switch(v.getId()){
            case (R.id.buttonSwitchMode):
                ListView listView = (ListView) findViewById(R.id.listview1);
                if (listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE)
                {
                    listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                }
                else if (listView.getChoiceMode() == ListView.CHOICE_MODE_SINGLE)
                {
                    listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                }
                break;
        }
    }


}



