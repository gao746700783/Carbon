package tk.zielony.carbonsamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import carbon.widget.ScrimInsetsLayout;
import carbon.widget.Toolbar;
import tk.zielony.carbonsamples.applibrary.CalculatorActivity;
import tk.zielony.carbonsamples.applibrary.DrawerActivity;
import tk.zielony.carbonsamples.applibrary.PicassoActivity;
import tk.zielony.carbonsamples.applibrary.RecyclerCardsActivity;
import tk.zielony.carbonsamples.applibrary.ScrimInsetsLayoutActivity;


public class AppsLibrariesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setIconVisible(true);
        toolbar.setText("Apps & Libraries");

        ListView listView = (ListView) findViewById(R.id.list);
        String[] items = new String[]{
                "Calculator", "Picasso", "RecyclerView & cards", "Nawigation drawer", "ScrimInsetsLayout (API 21+)"
        };
        final Class[] activities = new Class[]{
                CalculatorActivity.class, PicassoActivity.class, RecyclerCardsActivity.class, DrawerActivity.class, ScrimInsetsLayoutActivity.class
        };
        final boolean[] beta = new boolean[]{
                true, false, false, false, true
        };
        listView.setAdapter(new MainListAdapter(items, beta));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(AppsLibrariesActivity.this, activities[position]));
            }
        });
    }

}
