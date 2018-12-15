package com.example.exitpoll;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exitpoll.adapter.NameListAdapter;
import com.example.exitpoll.db.DatabaseHelper;
import com.example.exitpoll.model.PollItem;

import java.util.ArrayList;
import java.util.List;

import com.example.exitpoll.db.DatabaseHelper;
import com.example.exitpoll.model.PollItem;

import static com.example.exitpoll.db.DatabaseHelper.COL_ID;
import static com.example.exitpoll.db.DatabaseHelper.COL_IMAGE;
import static com.example.exitpoll.db.DatabaseHelper.COL_NUMBER;
import static com.example.exitpoll.db.DatabaseHelper.COL_COUNT;
import static com.example.exitpoll.db.DatabaseHelper.TABLE_NAME;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<PollItem> mNameItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mHelper = new DatabaseHelper(Main2Activity.this);
        mDb = mHelper.getWritableDatabase();

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadNameData();
        setupListView();
    }

    private void loadNameData() {
        Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);

        mNameItemList = new ArrayList<>();
        while (c.moveToNext()) {
            long _id = c.getLong(c.getColumnIndex(COL_ID));
            String number = c.getString(c.getColumnIndex(COL_NUMBER));
            String count = c.getString(c.getColumnIndex(COL_COUNT));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));

            PollItem item = new PollItem(_id, number, count,image);
            mNameItemList.add(item);
        }
        c.close();
    }

    private void setupListView() {
        NameListAdapter adapter = new NameListAdapter(
                Main2Activity.this,
                R.layout.activity_main2,
                mNameItemList
        );
//        ListView lv = findViewById(R.id.result_list_view);
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                PollItem item = mNameItemList.get(position);
//                Toast t = Toast.makeText(Main2Activity.this,item.title, Toast.LENGTH_SHORT);
//                t.show();
//
//
//
//            }
//        });

    }
}
