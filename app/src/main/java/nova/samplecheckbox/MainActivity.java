package nova.samplecheckbox;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    CustomChoiceListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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


        // delete button에 대한 이벤트 처리.
        Button deleteButton = (Button) findViewById(R.id.buttonDelete);
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                SparseBooleanArray checkedItems = listview.getCheckedItemPositions();
                int count = adapter.getCount();

                for (int i = count - 1; i >= 0; i--) {
                    if (checkedItems.get(i)) {
                        adapter.listViewItemList.remove(i);
                    }
                }

                // 모든 선택 상태 초기화.
                listview.clearChoices();

                adapter.notifyDataSetChanged();
            }
        });


        // selectAll button에 대한 이벤트 처리.
        Button selectAllButton = (Button)findViewById(R.id.buttonSelectAll) ;
        selectAllButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count = 0 ;
                count = adapter.getCount() ;

                for (int i=0; i<count; i++) {
                    listview.setItemChecked(i, true) ;
                }
            }
        }) ;



    }

    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.buttonSwitchMode):
                ListView listView = (ListView) findViewById(R.id.listview1);
                if (listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE) {
                    Toast.makeText(getApplicationContext(), "단일 선택 모드로 변경되었습니다.", Toast.LENGTH_SHORT).show();
                    listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                } else if (listView.getChoiceMode() == ListView.CHOICE_MODE_SINGLE) {
                    Toast.makeText(getApplicationContext(), "다중 선택 모드로 변경되었습니다.", Toast.LENGTH_SHORT).show();
                    listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                }
                break;
        }
    }


}



